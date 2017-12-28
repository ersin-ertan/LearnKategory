package A_Glossary.typeclasses

import kategory.HK
import kategory.MonadError
import kategory.binding
import kategory.monadError

// MonadError a typeclass to handle error cases inside of monadic contexts. Typeclasses allow us to focus
// on behaviours and not the datatypes that implements them.

//monadError<OptionHK, Unit>()
//monadError<TryHK, Throwable>()
//monadError<EitherKindPartial<Exception1>, Exception1>()


sealed class MyException {
    object Exception1 : MyException()
    object Exception2 : MyException()
    class Exception3(val why: String) : MyException()
}

object First
object Second
object Third

inline fun <reified F> doFirst(monadError: MonadError<F, MyException> = monadError()): HK<F, First>
        = monadError.pure(First)

inline fun <reified F> doSecond(monadError: MonadError<F, MyException> = monadError()): HK<F, Second>
        = monadError.pure(Second)

inline fun <reified F> doThird(first: First, second: Second, monadError: MonadError<F, MyException> = monadError()): HK<F, Third>
        = monadError.raiseError(MyException.Exception3("because of something"))

// express the same program with a polymorphic context

inline fun <reified F> doAll(monadError: MonadError<F, MyException> = monadError()): HK<F, Third>
        = monadError.binding {
    val first = doFirst<F>().bind()
    val second = doSecond<F>().bind()
    val third = doThird<F>(first, second).bind()
    yields(third)
}