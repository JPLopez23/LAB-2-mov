package com.example.lab2

val num: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)

// Función para calcular el promedio de los números
fun Promedio(numbers: List<Int>): Double {
    val sum = num.sum()
    return sum.toDouble() / numbers.size
}

// Función para calcular los numeros impares
fun impares(num: List<Int>): List<Int> {
    return num.filter { it % 2 != 0 }
}

//Funcion para saber si un numero es palindromo
fun isPalindrome(num: Int): Boolean {
    val numStr = num.toString()
    val reversedNumStr = numStr.reversed()
    return numStr == reversedNumStr
}

//Funcion Saludo a nombres
val nombres: List<String> = listOf("Ana", "Maria", "Juan", "Pedro", "Luis", "Carlos", "Jose", "Laura", "Pablo", "Miguel")
fun Saludo(nombres: List<String>): List<String> {
    return nombres.map { nombre -> "Hola $nombre" }
}

//Funcion PerformOperation
fun performOperation(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
    return operation(num1, num2)
}

// Person y Student

data class Person(val name: String, val age: Int, val gender: String)
data class Student(val name: String, val age: Int, val gender: String, val studentId: String)

fun convertToStudent(person: Person, studentId: String): Student {
    return Student(person.name, person.age, person.gender, studentId)
}

fun mapPersonToStudent(persons: List<Person>): List<String> {
    return persons.map { person ->
        val student = convertToStudent(person, "ID-${person.name.take(3).toUpperCase()}123")
        "El Estudiante ${student.name} tiene ${student.age} años"
    }
}

fun main() {
    val promedio = Promedio(num)
    println("El promedio de los numeros es: $promedio")
    val impares = impares(num)
    println("Los numeros impares son: $impares")
    val palindromos = num.filter { isPalindrome(it) }
    println("Los numeros palindromos son: $palindromos")
    val saludo = Saludo(nombres)
    println("Los saludos son: $saludo")
    val suma = performOperation(5, 3, Int::plus)
    println("La suma es: $suma")
    val resta = performOperation(10, 4, Int::minus)
    println("La resta es: $resta")
    val multiplicacion = performOperation(7, 2, Int::times)
    println("La multiplicacion es: $multiplicacion")
    val division = performOperation(16, 4, Int::div)
    println("La division es: $division")
    val personas = listOf(Person("Alice", 24, "Female"), Person("Bob", 29, "Male"))
    val estudiantesInfo = mapPersonToStudent(personas)
    estudiantesInfo.forEach { println(it) }
}