# Java_Memory_CG_Task

## Source Links

Articles:

* <a href="https://www.youtube.com/watch?v=JbLClSMRK_I">[Ru] JVM, краткий курс общей анатомии</a>
* <a href="https://www.youtube.com/watch?v=EMXflWb9Z5w">[Ru] Что нового в JVM 8</a>
* <a href="https://plumbr.eu/java-garbage-collection-handbook">GC Handbook</a>
* <a href="https://habrahabr.ru/company/luxoft/blog/174231/">Грустная история тюнинга из 2013</a>

Official docs:

* <a href="http://www.oracle.com/technetwork/articles/java/vmoptions-jsp-140102.html">Java HotSpot VM Options</a>
* <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/vm/">Java Virtual Machine Technology </a>

Video:

* <a href="https://drive.google.com/drive/folders/1e_AG0l9HOdg5r4w31GT-oXK931ixkpBt">https://drive.google.com/drive/folders/1e_AG0l9HOdg5r4w31GT-oXK931ixkpBt</a>

Books:

* <a href="https://www.amazon.com/Java-Performance-Definitive-Guide-Getting/dp/1449358454">Java Performance: The Definitive Guide: Getting the Most Out of Your Code</a>

## Task

Description.

Task 2. (15 points) Tune regions and monitor with jdk monitoring tools

Note: Try Java 8 jdk tools

Take your pet or current project app for the next exercises with JVM settings via flags and console utilities.

* Heap should be divided to Old and Young generations of equal size, where areas of Young generation are in following ratio:  3-Eden, 1-S0, 1-S1
* Heap should be of 512MB and divided to Old and Young generations of equal size, where areas of Young generation are in following ratio:  2-Eden, 1-S0, 1-S1
* Heap should be of 512MB with Old generation of 128MB and Young generation with areas in following ratio:  3-Eden, 1-S0, 1-S1
* Heap should be divided to Old generation of 128MB and Young generations with areas:  Eden of 384MB, S0 of 128MB, S1 of 128MB
 

After JVM start make screenshots with jdk monitoring tools with JVM flags for each point.

Use this link to find appropriate tool. Check yourself with JVisualVM.