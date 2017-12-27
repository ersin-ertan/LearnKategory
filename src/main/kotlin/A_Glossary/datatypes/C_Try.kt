package A_Glossary.datatypes

import kategory.*
import p
import pp

fun main(args: Array<String>) {

    // try for computation with a result A, or an exception

    // Try as Success<A> or Failure<A> which would have been a Throwable

    // Like Either<Throwable, A> but for a specific use case where we explicitly know that there can be
    // a failure/code is outside our control

    open class GeneralException : Exception()
    class Exception1 : GeneralException()
    class Exception2 : GeneralException()

    fun doA() {
        throw Exception1()
    }

    fun doB(): List<String> {
        throw Exception2()
    }

    fun doC(): List<String> {
        doA()
        return doB()
    }

    fun doD(): List<String> = listOf<String>("a", "b", "c")

    // traditionally we use

    try {
        doC()
    } catch (e: Exception1) {
        "exception1".p()
    } catch (e: Exception2) {
        "exception2".p()
    }

    // but we want to
    val doC = Try { doC() }
    doC.pp()
    doC.getOrElse { emptyList() }.p()


    // will return result only if filter condition is met, else a failure is created, or propagated
    val doD = Try { doD() }
    doD.filter { it.size > 1 }.pp() // Success(value=[a,b,c])
    doD.filter { it.size > 5 }.p() // Failure PredicateException

    doC.filter { it.size > 1 }.p() // Failure Exception1

    doC.recover { ex ->
        emptyList() // default Success with empty list
    }.pp()

    // or if you have another function to try
    Try { doA() }.recoverWith { Try { doB() } }.pp() // last error is surfaced
    Try { doA() }.recoverWith { Try { doB() } }.recoverWith { doD }.p() // works

    // fold works the same as the others with the default on the left and working on the right
    doC.fold({ canBeOmitted -> listOf(1) }, { it.plus("d") }).pp()
    doD.fold({ listOf(1, 2) }, { it.plus("d").plus("e") }).p()

    // like fold and recoverWith where both functions can try again
    doC.transform({ Try { listOf(1) } }, { Try { listOf(1, 2) } }).pp()
    doD.transform({ Try { listOf(1, 2, 3) } }, { Try { listOf(1, 2, 3, 4) } }).p()

    doC.transform({ Try { listOf(1) } }, { doD }).pp()
    doD.transform({ doD }, { Try { listOf(1, 2, 3, 4) } }).p()


//    Functor, Applicative, Monad examples

    Try.functor().map(Try { "3".toInt() }, { it + 1 }).pp()

    Try.applicative().tupled(Try { "3".toInt() }, Try { "abc" }, Try { "fail".toInt() }).p()

    Try.monad().binding {
        val a = Try { "3".toInt() }.bind()
        val b = Try { "4".toInt() }.bind()
        val c = Try { "5".toInt() }.bind()
        yields(a + b + c)
    }.pp()

    Try.monad().binding {
        val a = Try { "fail".toInt() }.bind()
        val b = Try { "4".toInt() }.bind()
        val c = Try { "5".toInt() }.bind()
        yields(a + b + c)
    }.p()
}