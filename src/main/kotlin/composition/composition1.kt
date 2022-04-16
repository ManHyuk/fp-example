package composition

import arrow.core.andThen
import arrow.core.compose
import kotlin.math.pow

//fun pow(num1: Int, num2: Int): Int = num1.toDouble()
//                                    .pow(num2.toDouble())
//                                    .toInt()
val pow = { num1: Int, num2: Int -> num1.toDouble().pow(num2.toDouble()).toInt() }

//fun negate(num: Int) = num * -1
val negate = { num: Int -> num * -1 }

//fun increment(num: Int) = num + 1
val increment = { num: Int -> num + 1 }

val addThree = { i: Int -> i + 3 }
val twice = { i: Int -> i * 2 }


fun main() {

//    val powered = pow(2, 3)
//    val negated = negate(powered)
//    val result = increment(negated)
//    println("result = ${result}")

//    println(increment(negate(pow(2, 3))))

//    infix fun <IP, R, P1> ((IP) -> R).compose(f: (P1) -> IP) {}

//    val composed = compose(
//        {num -> increment(num)},
//        {num -> negate(num)},
//        {num1, num2 -> pow(num1, num2)}
//    )
//
//    val piped = pipe(pow, negate, increment)
//
//    println(composed(2,4))
//    println("piped(2, 4) = ${piped(2, 4)}")
}

//fun compose(f1: (Int) -> Int, f2: (Int) -> Int, f3: (Int, Int) -> Int): (Int, Int) -> Int =
//    { x: Int, y: Int -> f1(f2(f3(x, y))) }

//fun pipe(f3: (Int, Int) -> Int, f2: (Int) -> Int, f1: (Int) -> Int) = { x: Int, y: Int -> f1(f2(f3(x, y))) }

//fun compose2(f: (Int) -> Int, g: (Int) -> Int, x:(Int, Int) -> Int): (Int) -> Int = { f(g(it)) }

//infix fun <F, G, R> ((F) -> R).compose(g: (G) -> F): (G) -> R {
//    return { gInput: G -> this(g(gInput)) }
//}



//infix fun compose(fn3: (Int) -> Int, fn2: (Int) -> Int, fn1: (num1: Int, num2: Int) -> Int): (Int, Int) -> Int {
//    return { x: Int, y: Int -> fn3(fn2(fn1(x, y)))}
//}