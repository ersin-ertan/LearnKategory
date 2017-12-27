package A_Glossary.datatypes

import kategory.*
import p
import pp

fun main(args: Array<String>) {
    // Option can be returned and used in different ways

    fun returnString(b: Boolean): Option<String> = if (b) Option("a string") else Option.empty()
    // or
    fun returnString1(b: Boolean): Option<String> = if (b) Some("a string") else None


    // both returns are the same because Some and None are companion objects within Option
    val returnSome = returnString(true)
    val returnNone = returnString(false)

    val returnSome1 = returnString1(true)
    val returnNone1 = returnString1(false)

    (returnSome == returnSome1).p()
    (returnNone == returnNone1).p()


    when (returnSome) {
        is Some -> {
            returnSome.value
        } // note the auto cast from Option to Some, thus we use .value
        is None -> {
            "default value"
        }
    }.pp()

    if (returnNone.isEmpty) "Is empty $returnNone".pp()

    returnSome.getOrElse { "returnSome getOrElse default" }.pp()
    returnNone.getOrElse { "returnNone getOrElse default" }.p()

    returnSome.map { it + " returnSome plus map" }.pp()
    returnNone.map { it + " returnNone plus map" }.p()

    // note the it is available only if there is a value, else the default is used
    returnSome.fold({ " returnSome plus fold" }, { it + " returnSome plus fold!!!" }).pp()
    returnNone.fold({ " returnNone plus fold" }, { it + " returnNone plus fold!!!" }).p()

    1.some() == Some(2) // lift value into context of option
    none<String>()

    Option.functor().map(returnSome, { it + " returnSome plus functor map" }).pp()
    Option.functor().map(returnNone, { it + " returnSome plus functor map" }).p()

    Option.applicative().tupled(Option(1), Option("hello")).pp()

    // when looking at this example, press alt+enter to enable coroutine support
    Option.monad().binding {
        val a = Option("a").bind()
        val b = Option(a + "b").bind()
        yields(a + b) // "aab
    }.pp()

    Option.monad().binding {
        val a = Option("a").bind()
        val b = none<String>().bind() // including a none regardless of position, makes the result None
        yields(a + b)
    }.p()
}