# Typeclasses: define behaviour like a Java interface

[MonadError][1]: polymorphic function to work over any datatype with a MonadError instance
To solve polymorphic error handling
* polymorphism: abstracts types like functions abstract values
* higher kinded polymorphism: abstracts both type and type constructors
* higher order functions: abstract first order values and functions
* pure: 

[Either][2]: branching
To solve thrown exceptions within a system you are writing

* abstract data type(ADT): encapsulating a concept into a type, allowing us to provide operations if needed

[Try][3]: catching exceptions
To solve thrown exceptions from systems outside your control/visibility

* recover: like getOrElse, but with the exception passed into the function
* recoverWith: encapsulates your backup try for when the first try throws an exception
* transform: like fold and recoverWith, where both functions must try again but with switch semantic, so success is the left function and failure is the right

[Functional Error Handling][4]: using option, either, try

[IO][5]: interaction with program platform

[1]:https://github.com/ersin-ertan/LearnKategory/blob/master/src/main/kotlin/A_Glossary/datatypes/A_Option.kt
[2]:https://github.com/ersin-ertan/LearnKategory/blob/master/src/main/kotlin/A_Glossary/datatypes/B_Either.kt
[3]:https://github.com/ersin-ertan/LearnKategory/blob/master/src/main/kotlin/A_Glossary/datatypes/C_Try.kt
[4]:https://github.com/ersin-ertan/LearnKategory/blob/master/src/main/kotlin/A_Glossary/datatypes/D_FunctionalErrorHandling.kt
[5]:https://github.com/ersin-ertan/LearnKategory/blob/master/src/main/kotlin/A_Glossary/datatypes/E_IO.kt
