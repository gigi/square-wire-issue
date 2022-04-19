# Square Wire issue demo

Demo for issue demonstration
https://github.com/square/wire/discussions/2209#discussioncomment-2587999

## Working example

```shell
$ gradle bootRun

> Task :bootRun
Loader initing...
Initing roots [/Users/user/srv/www/wiredemo/proto]...
Trying to load files from folder [/Users/user/srv/www/wiredemo/proto]...
LOADED [google/protobuf/descriptor.proto, test.proto]!!!

BUILD SUCCESSFUL in 1s
4 actionable tasks: 1 executed, 3 up-to-date

```

## Non-working example

To build Spring Boot Jar run:

```shell
gradle bootJar
```

Run jar:
```shell
$ java -jar build/libs/wiredemo-0.0.1-SNAPSHOT.jar 

Loader initing...
Initing roots [/Users/user/srv/www/wiredemo/proto]...
Trying to load files from folder [/Users/user/srv/www/wiredemo/proto]...
ERROR HERE!!!
java.io.FileNotFoundException: /Users/user/srv/www/wiredemo/build/libs/wiredemo-0.0.1-SNAPSHOT.jar!/BOOT-INF/lib/wire-compiler-4.3.0.jar (No such file or directory)
        at java.base/java.io.RandomAccessFile.open0(Native Method)
        at java.base/java.io.RandomAccessFile.open(RandomAccessFile.java:344)
        at java.base/java.io.RandomAccessFile.<init>(RandomAccessFile.java:259)
        at java.base/java.io.RandomAccessFile.<init>(RandomAccessFile.java:213)
        at okio.JvmSystemFileSystem.openReadOnly(JvmSystemFileSystem.kt:82)
        at okio.internal.ZipKt.openZip(zip.kt:67)
        at okio.internal.ResourceFileSystem$Companion.toJarRoot(ResourceFileSystem.kt:201)
        at okio.internal.ResourceFileSystem$Companion.toClasspathRoots(ResourceFileSystem.kt:184)
        at okio.internal.ResourceFileSystem$roots$2.invoke(ResourceFileSystem.kt:47)
        at okio.internal.ResourceFileSystem$roots$2.invoke(ResourceFileSystem.kt:47)
        at kotlin.SynchronizedLazyImpl.getValue(LazyJVM.kt:74)
        at okio.internal.ResourceFileSystem.getRoots(ResourceFileSystem.kt:47)
        at okio.internal.ResourceFileSystem.<init>(ResourceFileSystem.kt:51)
        at okio.Okio__JvmOkioKt.asResourceFileSystem(JvmOkio.kt:233)
        at okio.Okio.asResourceFileSystem(Unknown Source)
        at com.squareup.wire.schema.CoreLoader$resourceFileSystem$2.invoke(CoreLoader.kt:46)
        at com.squareup.wire.schema.CoreLoader$resourceFileSystem$2.invoke(CoreLoader.kt:45)
        at kotlin.SynchronizedLazyImpl.getValue(LazyJVM.kt:74)
        at com.squareup.wire.schema.CoreLoader.getResourceFileSystem(CoreLoader.kt:45)
        at com.squareup.wire.schema.CoreLoader.load(CoreLoader.kt:51)
        at com.squareup.wire.schema.SchemaLoader.load(SchemaLoader.kt:140)
        at com.squareup.wire.schema.Linker.getFileLinker$wire_schema(Linker.kt:74)
        at com.squareup.wire.schema.Linker.link(Linker.kt:87)
        at com.squareup.wire.schema.SchemaLoader.loadSchema(SchemaLoader.kt:95)
        at com.gigi.wiredemo.WiredemoApplication.main(WiredemoApplication.java:30)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:568)
        at org.springframework.boot.loader.MainMethodRunner.run(MainMethodRunner.java:49)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:108)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:58)
        at org.springframework.boot.loader.JarLauncher.main(JarLauncher.java:88)
```