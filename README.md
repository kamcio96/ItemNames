# ItemNames 
![Build status](https://travis-ci.org/kamcio96/ItemNames.svg?branch=master)

Translated items names

### Reason

Do you need translated item names? Just use this library, I'll update item list when Minecraft gets update.
Actually, PL is the only supported language. If you have some time, you can create PR to my [github site](https://github.com/kamcio96/kamcio96.github.io) with your lang :wink:

### Usage

I don't have maven repo, so you have to clone this project and execute ```mvn install```
pom.xml:
```xml
<dependency>
    <groupId>pl.kamcio96</groupId>
    <artifactId>IteamNames</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```
```java
private static ItemNames names = new ItemNames(ItemNames.PL);
```

Use just a single instance of the library - creating an object takes some time :smile:
