package A_Glossary.datatypes

import kategory.*
import p
import pp

fun main(args: Array<String>) {
    // thrown exceptions unknown to the compiler, and require you to search through source to see what can be thrown-caught

    // make the fact that an error can be thrown explicit via the functions type. Either used to fail fast.

    // Left is error, right is right
    fun isError(b: Boolean): Either<String, Int> = if (b) Either.Left("left error string") else Either.Right(99)

    isError(true).p()
    isError(false).p()

    // flatmap is right biased, an applies the function only if there is a right value
    isError(false).flatMap { Either.Right(it + 1) }.pp()
    isError(true).flatMap { Either.Right(it + 10) }.p()

    fun guessWeightGivenHeight(height: Int): Int =
            if (height <= 0) throw IllegalStateException("Your height $height must be greater than 0") else height * 2

//    guessWeightGivenHeight(-34) // will throw error

    fun guessWeightGivenHeight1(height: Int): Either<IllegalStateException, Int> =
            if (height <= 0) Either.Left(IllegalStateException("Your height $height must be greater than 0"))
            else Either.Right(height * 2)

    guessWeightGivenHeight1(65).flatMap { Either.Right(it + 5) }.map { "Your weight is $it" }.pp()
    guessWeightGivenHeight1(0).flatMap { Either.Right(it + 5) }.map { "Your weight is $it" }.p()


    var weight = guessWeightGivenHeight1(56)

    when (weight) {
        is Either.Left -> {
            when (weight.a) {
                is IllegalStateException -> weight.a.message
                else -> "Unknown error"
            }
        }
        is Either.Right -> "your weight in when is ${weight.b}"
    }?.pp()


    weight = guessWeightGivenHeight1(-3)

    when (weight) {
        is Either.Left -> {
            when (weight.a) {
                is IllegalStateException -> weight.a.message // note the message can be null
            // if there are more than one exception, usually when chaining they would go here
                else -> "Unknown error"
            }
        }
        is Either.Right -> "your weight in when is ${weight.b}"
    }?.p()

    // But this is all using externally defined errors, since we know exactly what can go wrong, we can encapsulate the
    // errors within a sealed class for our abstract data type(ADT), must be defined outside of function

    fun guessWeightGivenHeight2(height: Int): Either<WeightHeightGuessError.HeightBelowZero, Int> =
            if (height <= 0) Either.Left(WeightHeightGuessError.HeightBelowZero)
            else Either.Right(height * 2)

    // assuming that this operation is chaining together multiple different Either returning operations, we must use the
    // general WeightHeightGuessError as the return
    fun anotherOperationThatMightError(int: Int): Either<WeightHeightGuessError, Int> = guessWeightGivenHeight2(int).map { it + 1 }

    val newWeight = anotherOperationThatMightError(-4)
    when (newWeight) {
        is Either.Left -> when (newWeight.a) {
            is WeightHeightGuessError.HeightBelowZero -> "Pick a height greater than 0!"
        // no need for else because of sealed class, all other possible errors(ADTs) would go here
            WeightHeightGuessError.AnotherPossibleError -> TODO()
        }
        is Either.Right -> " Your new weight is ${newWeight.b}"
    }.pp()


    // again left and right

    (if (weight.contains(76)) "you are right" else "you are wrong").pp()

    ("your weight getOrElse is " + guessWeightGivenHeight2(-4).getOrElse { 70 }).pp()


    // and as seen before you can fold, functor, applicative, monad
    guessWeightGivenHeight2(-4).fold({1}, {2}).pp()
    guessWeightGivenHeight2(4).fold({1}, {2}).pp()

    1.left().fold({"a"},{"b"}).pp()

    // but note that functor, applicative, monad, require the type parameter for any Either.Left usage
    Either.functor<Int>().map(Either.Right(1), {it + 1}).pp()

    Either.applicative<Int>().tupled(Either.Right(1), Either.Right("a")).pp()

    // this doesn't work because Left return type is Nothing
    /*Either.monad<Int>().binding{
        val a = Either.Left(1).bind()
        val b = Either.Right(1 + a).bind()
        val c = Either.Right(4).bind()
        yields(a + b + c)
    }.pp()*/
}

sealed class WeightHeightGuessError {
    object HeightBelowZero : WeightHeightGuessError()
    object AnotherPossibleError : WeightHeightGuessError()
}
