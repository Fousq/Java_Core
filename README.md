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

## Task 2

Description
Task 2. (20 points) Reflection API usage

Use the project from the previous module [Java Core I] with class hierarchy or another pet project with class hierarchy.

Rewrite your app with Reflection API:

* (5 points) Use reflection to instantiate all objects in client code via constructors (with or without arguments)
* (5 points) Use reflection API to fill private fields without setters
* (5 points) Use reflection API to change method calls from direct call on reflection call in client code
* (5 points) Print out the metadata for all classes in application in human-readable format (about all fields, methods, modifiers and etc.)