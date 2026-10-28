package hr.foi.rampu.memento.helpers

import hr.foi.rampu.memento.entities.Task
import hr.foi.rampu.memento.entities.TaskCategory
import java.util.Date

object MockDataLoader {
    fun getDemoData(): MutableList<Task> {
        val categories = getDemoCategories()

        return mutableListOf(
            Task(
                "Predaj seminarski",
                Date(),
                categories[0],
                false
            ),
            Task(
                "Pripremi labose",
                Date(),
                categories[1],
                false
            ),
            Task(
                "Spoji se na server",
                Date(),
                categories[2],
                false
            )
        )
    }

    fun getDemoCategories(): List<TaskCategory> {
        return listOf(
            TaskCategory("RAMPU", "#000080"),
            TaskCategory("RPP", "#FF0000"),
            TaskCategory("RWA", "#CCCCCC")
        )
    }
}







