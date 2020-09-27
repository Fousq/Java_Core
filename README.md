# Java_Core_2

## Source Links

Articals:

* <a href="https://habrahabr.ru/post/139736/">Простые аннотации</a>
* <a href="https://habrahabr.ru/company/golovachcourses/blog/217595/">Сложные аннотации</a>
* <a href="https://habrahabr.ru/post/318418/">Выгодно ли вызывать методы через Reflection?</a>
* <a href="https://www.baeldung.com/java-reflection">Reflection API</a>
* <a href="https://www.youtube.com/watch?v=GzOjCzHg5Ks">Reflection Madness (Heinz Kabutz, Greece)(video)</a>
* <a href="http://www.yegor256.com/2016/04/12/java-annotations-are-evil.html">Java Annotations Are a Big Mistake</a>

Offical docs:

* <a href="https://docs.oracle.com/javase/tutorial/java/annotations/">Annotations</a>
* <a href="https://docs.oracle.com/javase/tutorial/reflect/">Reflection API</a>

## Task 3

Description
Task 3. (10 points) Custom annotations

Use the project from the previous module [Java Core I] with class hierarchy or another pet project with class hierarchy.

Create custom annotations and use them in code

* @UseStackOnly which could be attached to fields and couldn’t be accessed in Runtime
* @UseArrayList which could be attached to methods and couldn’t be found in the bytecode
* @ThisCodeSmells(reviewer=”Petya”) which could be attached everywhere and could be repeatable
* @ProdCode which could be attached to methods only and should be accessed in Runtime