TODO - Improve Separation of concerns definition

# Learn Functional Programming with Kategory
Kategory has functional datatypes & functional abstractions.

<details>
<summary>Why functional?</summary>
</br>

* Referential Transparency: functions have defined parameters and return types, and only operate on the input without modifying values outside of the functions scope
* Purity: Idempotent/deterministic/pure function. Repeated calls to a function yield the same result if the function parameter is unchanged
* Separation of Concerns: Computation is declarative and deferred, with specific nesting and ordering via a tree structure. Runtime evaluation provides the semantic
* goto Conceptual Understanding

</details>

### Contents

* [Glossary][1]
  * [Datatypes][2]
    * [Option][3]
    * [Either][4]
    * [Try][5]
    * [Functional Error Handling][6]
    * [IO][6]
  * [Typeclasses][7]
    * [Eq][8]
    * [Monoid][9]
    * [Functor][10]
    * [MonadError][11]
  * [Instances][12]
  * [Type constructors][13]
    * [Higher Kinds][14]
    * [Higher Kinds with Typeclasses][15]
    * [Higher Kinds with Typeclasses & Functions][16]


### Set Up

* The next two instructions will be for the top level {}, not the ones within buildscript {}
* Open root projects build.gradle and add ` maven { url 'https://dl.bintray.com/kategory/maven' }` in the repositories {}
* Add `compile 'io.kategory:kategory:0.4.0'` in the dependencies {}

### Conceptual Understanding
* Assumes you know kotlin
* Bottom up approach because top down is via Category theory/too abstract
* First, goto glossary and replace old code concept knowledge with functional datatypes for Option, Either, and Try
* Then do functional error handling practice within the datatypes package
* TODO Introduce monadic comprehension before MonadError
* Go to the typeclass MonadError to learn about error handling inside of monadic contexts
* Now we have basic control of functional style abstractions and thinking


[1]:https://github.com/ersin-ertan/LearnKategory/tree/master/src/main/kotlin/A_Glossary
[2]:https://github.com/ersin-ertan/LearnKategory/blob/master/src/main/kotlin/A_Glossary/datatypes
[3]:https://github.com/ersin-ertan/LearnKategory/blob/master/src/main/kotlin/A_Glossary/datatypes/A_Option.kt
[4]:https://github.com/ersin-ertan/LearnKategory/blob/master/src/main/kotlin/A_Glossary/datatypes/B_Either.kt
[5]:a
[6]:a
[7]:a
[8]:a
[9]:a
[10]:a
[11]:a
[12]:a
[13]:a
[14]:a
[15]:a
[16]:a
[17]:a
[18]:a
[19]:a