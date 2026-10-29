// COMP2850 Portfolio: Week 4
// ToDoList class
import kotlinx.datetime.LocalDate
import kotlin.io.path.Path
import kotlin.io.path.forEachLine
import kotlin.io.path.writer

class ToDoList() {
    private val items = mutableListOf<ToDoItem>()

    val size get() = items.size

    val notStarted get() = items.count { it.status == ItemStatus.NotStarted }
    val inProgress get() = items.count { it.status == ItemStatus.InProgress }
    val done get() = items.count { it.status == ItemStatus.Done }
    val overdue get() = items.count { it.isOverdue() }

    constructor(filename: String): this() {
        load(filename)
    }

    // 已修复：按冒号+空格拆分，匹配文件格式
    fun load(filename: String) {
        items.clear()
        Path(filename).forEachLine { line ->
            if (line.isNotBlank()) {
                val parts = line.split(": ", limit = 3)
                if (parts.size == 3) {
                    val dueDate = LocalDate.parse(parts[0].trim())
                    val status = ItemStatus.valueOf(parts[1].trim())
                    val description = parts[2].trim()
                    items.add(ToDoItem(dueDate, status, description))
                }
            }
        }
    }

    // 恢复原有实现：使用 toString 格式写入，和文件格式对齐
    fun save(filename: String) {
        Path(filename).writer().use {
            for (item in items) {
                it.write("$item\n")
            }
        }
    }

    fun add(vararg item: ToDoItem) = item.forEach { items.add(it) }

    fun deleteDone(): Boolean {
        return items.removeAll { it.status == ItemStatus.Done }
    }

    fun getItems(status: ItemStatus? = null): List<ToDoItem> {
        return if (status == null) {
            items.toList()
        } else {
            items.filter { it.status == status }
        }
    }

    fun getItemsDueOn(date: LocalDate): List<ToDoItem> {
        return items.filter { it.dueDate == date }
    }
}
