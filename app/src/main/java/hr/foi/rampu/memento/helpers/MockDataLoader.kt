package hr.foi.rampu.memento.helpers

import hr.foi.rampu.memento.entities.Task
import hr.foi.rampu.memento.entities.TaskCategory
import java.util.Date

object MockDataLoader {
    fun getDemoData(): List<Task> = listOf(
        Task(
            "Predaj seminarski",
            Date(),
            TaskCategory("RAMPU", "#000080"),
            false
        ),
        Task(
            "Pripremi labose",
            Date(),
            TaskCategory("RPP", "#FF0000"),
            false
        ),
        Task(
            "Spoji se na server",
            Date(),
            TaskCategory("RWA", "#CCCCCC"),
            false
        )
    )
}







