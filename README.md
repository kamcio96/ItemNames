# ItemNames
Translated items names

###Reason

Do you need translated item names? Just use this library, I will update item list when mc will be update.
Currently only PL lang is supported. If you have some time, you can create PR to my [github site](https://github.com/kamcio96/kamcio96.github.io) with your lang :wink:

###Usage

I don't have maven repo now. So you have clone that project and run ```mvn install```
pom.xml:
```xml
<dependency>
    <groupId>pl.kamcio96</groupId>
    <artifactId>IteamNames</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

plugin:
```java
private static ItemNames names = new ItemNames(ItemNames.PL);
```

Use single instance for plugin. Creating an object takes some time :smile:
