package ch01

/**
 * 함수형 프로그래밍의 핵심 개념
 *
 * 코틀린은 객체지향 + 함수형 프로그래밍을 모두 지원하는 다중 패러다임 언어다.
 * 함수형 프로그래밍의 3가지 핵심: 일급 시민 함수, 불변성, 부수 효과 없음
 *
 * Java와의 차이:
 * - Java는 8부터 람다를 지원하지만, 코틀린은 처음부터 함수형 프로그래밍을 핵심 설계에 포함
 * - Java의 함수형 인터페이스(Function, Predicate 등) 대신, 코틀린은 함수 타입을 직접 지원
 */

fun main() {
    println("=== 1. 일급 시민인 함수 ===")

    // 함수를 변수에 저장
    val greet: (String) -> String = { name -> "안녕하세요, ${name}님!" }
    println(greet("영희"))

    // 함수를 인자로 전달
    val numbers = listOf(1, 2, 3, 4, 5)
    val evenNumbers = numbers.filter { it % 2 == 0 }
    println("짝수: $evenNumbers")

    // 함수에서 새로운 함수를 반환
    val adder = createAdder(10)
    println("10 + 5 = ${adder(5)}")

    println()
    println("=== 2. 불변성 ===")

    // val을 사용한 불변 변수 (Java의 final과 유사)
    val immutableList = listOf("a", "b", "c")
    // immutableList.add("d")  // 컴파일 오류! 읽기 전용 컬렉션
    println("불변 리스트: $immutableList")

    // data class의 copy를 통한 불변 객체 변경
    data class User(val name: String, val age: Int)
    val user1 = User("철수", 25)
    val user2 = user1.copy(age = 26) // 원본은 변경되지 않고 새 객체 생성
    println("원본: $user1")
    println("복사본: $user2")

    println()
    println("=== 3. 부수 효과 없음 (순수 함수) ===")

    // 순수 함수: 같은 입력 → 항상 같은 출력
    println("3 + 5 = ${add(3, 5)}")
    println("3 + 5 = ${add(3, 5)}") // 몇 번 호출해도 동일한 결과

    // 람다를 활용한 컬렉션 처리 (부수 효과 없이 새 컬렉션 반환)
    val names = listOf("Kim", "Lee", "Park")
    val upperNames = names.map { it.uppercase() }
    println("원본: $names")
    println("변환: $upperNames") // 원본은 변하지 않음
}

// 함수를 반환하는 함수 (고차 함수)
fun createAdder(base: Int): (Int) -> Int {
    return { number -> base + number }
}

// 순수 함수: 외부 상태에 의존하지 않고, 외부 상태를 변경하지 않음
fun add(a: Int, b: Int): Int = a + b
