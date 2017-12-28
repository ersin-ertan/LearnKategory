package A_Glossary.datatypes

import kategory.*
import p
import kotlin.system.measureTimeMillis

// exceptions break referential transparency leading to bugs at runtime, unaware to the caller.
// exceptions stop program flow, and may not survive async boundaries.
// Throwable is an open hierarchy and can catch more than you intended
// Throwables have a hidden performance cost, and are a poor choice in functional programming

fun main(args: Array<String>) {

//    ex01()
//    ex02()
}

fun ex01() {

    // TODO How would you change the function return types to use Option

    class A
    class B
    class C

    fun doA() = A()
    fun doB() = B()

    fun doC(a: A, b: B): C = C()

    // TODO Why use option? What would the function body look like for doC when using Option?

    // TODO Function C is dependent on A and B, what Option.function() would we call?

    // TODO What can't Option propagate?

}


fun ex02() {

    // TODO What would the above example look like if you used Try

    class A
    class B
    class C

    fun doA() = A()
    fun doB() = B()

    fun doC(a: A, b: B): C = C()

    // TODO What advantages does Try have over Option?

    // TODO What function would we use to extract 2 different types from Try?

    // TODO Do we have enough detail for the returned types to handle specific errors?

}

fun ex03(){

    // TODO When using Either, what must be define in order to work with errors?

    // TODO Why do we define these?

    // TODO What does the functions look like when using Either?

    class A
    class B
    class C

    fun doA() = A()
    fun doB() = B()

    fun doC(a: A, b: B): C = C()
}


// TODO Go to Monad Error