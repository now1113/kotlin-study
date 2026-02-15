package ch01

data class Person(
    val name: String,
    val age: Int? = null
)

fun main() {
    val persons = listOf(
        Person("영희", age = 29),
        Person("철수"),
    )
    // 람다식
    val oldest = persons.maxBy {
        it.age ?: 0 // 널에 적용하는 엘비스 연산자
    }
    // 문자열 템플릿
    println("가장 나이가 많은 사람: $oldest")
}

