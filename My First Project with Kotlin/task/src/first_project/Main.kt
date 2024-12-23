package first_project

import java.util.Locale

data class Product(val name: String, val price: Double, val total: Double)

fun main() {
    val products = listOf<Product>(
        Product("Bubblegum", 2.0, 202.0),
        Product("Toffee", 0.2, 118.0),
        Product("Ice cream", 5.0, 2250.0),
        Product("Milk chocolate", 4.0, 1680.0),
        Product("Doughnut", 2.5, 1075.0),
        Product("Pancake", 3.2, 80.0))

    printEarnedAmount(products)
    println("Net income: ${totalIncome(products) - totalExpences()}")
}

val totalIncome: (List<Product>) -> Double = {it.sumOf { it.total }}

fun printEarnedAmount(list: List<Product>) {
    println("Earned amount:")
    list.map { println(String.format(Locale.US,"%s: $%.0f", it.name, it.total)) }
    println("\nIncome: $${totalIncome(list)}")
}

fun totalExpences(): Double {
    println("Staff expenses:")
    val staffExpenses = readln().toDoubleOrNull() ?: 0.0
    println("Other expenses:")
    val otherExpenses = readln().toDoubleOrNull() ?: 0.0
    return staffExpenses + otherExpenses
}


