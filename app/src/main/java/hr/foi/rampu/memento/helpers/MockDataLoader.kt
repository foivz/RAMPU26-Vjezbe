package hr.foi.rampu.memento.helpers

import hr.foi.rampu.memento.database.TasksDatabase
import hr.foi.rampu.memento.entities.Task
import hr.foi.rampu.memento.entities.TaskCategory
import java.util.Date

object MockDataLoader {
    fun loadMockData() {
        val tasksDao = TasksDatabase.getInstance().getTasksDao()
        val taskCategoriesDao = TasksDatabase.getInstance().getTaskCategoriesDao()

        if (tasksDao.getAllTasks(true).isEmpty() &&
            tasksDao.getAllTasks(false).isEmpty() &&
            taskCategoriesDao.getAllCategories().isEmpty()) {
            val categories = arrayOf(
                TaskCategory(1,"RAMPU", "#000080"),
                TaskCategory(2,"RPP", "#FF0000"),
                TaskCategory(3,"RWA", "#CCCCCC")
            )
            taskCategoriesDao.insertCategory(*categories)

            val dbCategories = taskCategoriesDao.getAllCategories()

            val tasks = arrayOf(
                Task(
                    1,
                    "Predaj seminarski",
                    Date(),
                    dbCategories[0].id,
                    false
                ),
                Task(
                    2,
                    "Pripremi labose",
                    Date(),
                    dbCategories[1].id,
                    false
                ),
                Task(
                    3,
                    "Spoji se na server",
                    Date(),
                    dbCategories[2].id,
                    false
                )
            )

            tasksDao.insertTask(*tasks)
        }
    }

    fun getDemoCategories(): List<TaskCategory> {
        return listOf(
            TaskCategory(0,"RAMPU", "#000080"),
            TaskCategory(1,"RPP", "#FF0000"),
            TaskCategory(2,"RWA", "#CCCCCC")
        )
    }
}







