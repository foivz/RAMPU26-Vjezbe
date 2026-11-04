package hr.foi.rampu.memento.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import hr.foi.rampu.memento.R
import hr.foi.rampu.memento.adapters.TasksAdapter
import hr.foi.rampu.memento.database.TasksDatabase
import hr.foi.rampu.memento.helpers.MockDataLoader
import hr.foi.rampu.memento.helpers.NewTaskDialogHelper

class PendingFragment : Fragment() {
    private val tasksDao = TasksDatabase.getInstance().getTasksDao()
    private lateinit var recyclerView: RecyclerView
    private lateinit var btnCreateTask: FloatingActionButton
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pending, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = view.findViewById(R.id.rv_pending_tasks)
        btnCreateTask = view.findViewById(R.id.fab_pending_fragment_create_task)

        loadTaskList()
        recyclerView.layoutManager = LinearLayoutManager(view.context)

        btnCreateTask.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        val newTaskDialogView = LayoutInflater
            .from(requireContext())
            .inflate(R.layout.new_task_dialog, null)

        val dialogHelper = NewTaskDialogHelper(newTaskDialogView)

        AlertDialog.Builder(requireContext())
            .setView(newTaskDialogView)
            .setTitle(getString(R.string.create_a_new_task))
            .setPositiveButton(getString(R.string.create_a_new_task)) { _, _ ->
                var newTask = dialogHelper.buildTask()
                val newTaskId = tasksDao.insertTask(newTask)[0]
                newTask = tasksDao.getTask(newTaskId.toInt())
                val tasksAdapter = recyclerView.adapter as TasksAdapter
                tasksAdapter.addTask(newTask)
            }
            .show()

        val categories = TasksDatabase.getInstance().getTaskCategoriesDao().getAllCategories()
        dialogHelper.populateSpinner(categories)
        dialogHelper.activateDateTimeListeners()
    }

    private fun loadTaskList() {
        val tasks = tasksDao.getAllTasks(false)
        val tasksAdapter = TasksAdapter(tasks.toMutableList()) { taskId ->
            parentFragmentManager.setFragmentResult(
                "task_completed",
                Bundle().apply {
                    putInt("task_id", taskId)
                }
            )
        }

        recyclerView.adapter = tasksAdapter
    }
}





