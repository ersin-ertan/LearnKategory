
# DataTypes: generalized patterns(code)

[Option][1]: absence of a value
To solve NullPointerException like kotlin's null safe ?

* higher order function: a function that takes or returns a function
* map: a higher order function that takes a function and can apply it to the value or collection values, returning the modified(or not, depends on functions logic) value/collection encapsulated within Some, else there was no value and will return None
* fold: like map but takes two functions, a default function if the value is None, and a function like maps, however the result won't be encapsulated within Some, it will be extracted
* lift: encapsulate your value within a container, much like `Some(value)`
* typeclass: like a java interface, defining behaviour without an instance, but rather a type for the compiler
* functor: a typeclass that allows you to call map on the contents of container(Some), without having to manually extract the value, call map, then repopulate the container.
* applicative: a typeclass that places values into a container(Pair or Tuple2) while maintaining the original container, where Some(a) and Some(b) become Some(Tuple2(a, b))
* monad: a type class that allows you to sequentially build a value to be placed within a container

[Either][2]: branching
To solve thrown exceptions

* abstract data type(ADT): encapsulating a concept into a type, allowing us to provide operations if needed

[Try][3]: catching exceptions

[IO][4]: interaction with program platform

[1]:https://github.com/ersin-ertan/LearnKategory/blob/master/src/main/kotlin/A_Glossary/datatypes/A_Option.kt
[2]:https://github.com/ersin-ertan/LearnKategory/blob/master/src/main/kotlin/A_Glossary/datatypes/B_Either.kt
[3]:https://github.com/ersin-ertan/LearnKategory/blob/master/src/main/kotlin/A_Glossary/datatypes/C_Try.kt
[4]:https://github.com/ersin-ertan/LearnKategory/blob/master/src/main/kotlin/A_Glossary/datatypes/D_IO.kt
