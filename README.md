# flapdoodle-3-test

- https://github.com/flapdoodle-oss/de.flapdoodle.embed.process/issues/122 
- https://github.com/flapdoodle-oss/de.flapdoodle.embed.mongo/issues/342 

## main branch
- flapdoodle 3
- spring boot 2.5
- Error when using `withExtraction` with relative path
```
2021-04-19 17:45:39.856  INFO 17546 --- [           main] com.example.demo.DemoApplicationTests    : No active profile set, falling back to default profiles: default
2021-04-19 17:45:40.598  INFO 17546 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data MongoDB repositories in DEFAULT mode.
2021-04-19 17:45:40.609  INFO 17546 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 6 ms. Found 0 MongoDB repository interfaces.
2021-04-19 17:45:41.539  INFO 17546 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
Extract /home/felix/.embedmongo/linux/mongodb-linux-x86_64-4.0.12.tgz START
Extract /home/felix/.embedmongo/linux/mongodb-linux-x86_64-4.0.12.tgz extract mongodb-linux-x86_64-4.0.12/bin/mongod
Extract /home/felix/.embedmongo/linux/mongodb-linux-x86_64-4.0.12.tgz nothing left
Extract /home/felix/.embedmongo/linux/mongodb-linux-x86_64-4.0.12.tgz DONE
2021-04-19 17:45:43.243 ERROR 17546 --- [           main] d.f.embed.process.runtime.Starter        : prepare executable

java.nio.file.NoSuchFileException: target/embedmongo/Linux-B64--4.0.12/target/embedmongo/Linux-B64--4.0.12/extractmongod
	at java.base/sun.nio.fs.UnixException.translateToIOException(UnixException.java:92) ~[na:na]
	at java.base/sun.nio.fs.UnixException.rethrowAsIOException(UnixException.java:111) ~[na:na]
	at java.base/sun.nio.fs.UnixException.rethrowAsIOException(UnixException.java:116) ~[na:na]
	at java.base/sun.nio.fs.UnixCopyFile.copy(UnixCopyFile.java:548) ~[na:na]
	at java.base/sun.nio.fs.UnixFileSystemProvider.copy(UnixFileSystemProvider.java:258) ~[na:na]
	at java.base/java.nio.file.Files.copy(Files.java:1295) ~[na:na]
	at de.flapdoodle.embed.process.extract.ExtractedFileSets.copy(ExtractedFileSets.java:53) ~[de.flapdoodle.embed.process-3.0.1.jar:na]
	at de.flapdoodle.embed.process.store.ExtractedArtifactStore.extractFileSet(ExtractedArtifactStore.java:114) ~[de.flapdoodle.embed.process-3.0.1.jar:na]
	at de.flapdoodle.embed.process.runtime.Starter.prepare(Starter.java:58) ~[de.flapdoodle.embed.process-3.0.1.jar:na]
	at de.flapdoodle.embed.process.runtime.Starter.prepare(Starter.java:51) ~[de.flapdoodle.embed.process-3.0.1.jar:na]
	at org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration.embeddedMongoServer(EmbeddedMongoAutoConfiguration.java:113) ~[spring-boot-autoconfigure-2.5.0-RC1.jar:2.5.0-RC1]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:na]
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:566) ~[na:na]
	at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:154) ~[spring-beans-5.3.6.jar:5.3.6]
	at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:653) ~[spring-beans-5.3.6.jar:5.3.6]
	at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod(ConstructorResolver.java:638) ~[spring-beans-5.3.6.jar:5.3.6]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod(AbstractAutowireCapableBeanFactory.java:1334) ~[spring-beans-5.3.6.jar:5.3.6]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1177) ~[spring-beans-5.3.6.jar:5.3.6]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:564) ~[spring-beans-5.3.6.jar:5.3.6]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:524) ~[spring-beans-5.3.6.jar:5.3.6]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335) ~[spring-beans-5.3.6.jar:5.3.6]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-5.3.6.jar:5.3.6]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333) ~[spring-beans-5.3.6.jar:5.3.6]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208) ~[spring-beans-5.3.6.jar:5.3.6]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:944) ~[spring-beans-5.3.6.jar:5.3.6]
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:918) ~[spring-context-5.3.6.jar:5.3.6]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583) ~[spring-context-5.3.6.jar:5.3.6]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:769) ~[spring-boot-2.5.0-RC1.jar:2.5.0-RC1]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:439) ~[spring-boot-2.5.0-RC1.jar:2.5.0-RC1]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:337) ~[spring-boot-2.5.0-RC1.jar:2.5.0-RC1]
	at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:123) ~[spring-boot-test-2.5.0-RC1.jar:2.5.0-RC1]
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99) ~[spring-test-5.3.6.jar:5.3.6]
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124) ~[spring-test-5.3.6.jar:5.3.6]
	at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124) ~[spring-test-5.3.6.jar:5.3.6]
	at org.springframework.test.context.web.ServletTestExecutionListener.setUpRequestContextIfNecessary(ServletTestExecutionListener.java:190) ~[spring-test-5.3.6.jar:5.3.6]
	at org.springframework.test.context.web.ServletTestExecutionListener.prepareTestInstance(ServletTestExecutionListener.java:132) ~[spring-test-5.3.6.jar:5.3.6]
	at org.springframework.test.context.TestContextManager.prepareTestInstance(TestContextManager.java:244) ~[spring-test-5.3.6.jar:5.3.6]
	at org.springframework.test.context.junit.jupiter.SpringExtension.postProcessTestInstance(SpringExtension.java:138) ~[spring-test-5.3.6.jar:5.3.6]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$invokeTestInstancePostProcessors$6(ClassBasedTestDescriptor.java:350) ~[junit-jupiter-engine-5.7.1.jar:5.7.1]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.executeAndMaskThrowable(ClassBasedTestDescriptor.java:355) ~[junit-jupiter-engine-5.7.1.jar:5.7.1]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$invokeTestInstancePostProcessors$7(ClassBasedTestDescriptor.java:350) ~[junit-jupiter-engine-5.7.1.jar:5.7.1]
	at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195) ~[na:na]
	at java.base/java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:177) ~[na:na]
	at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1655) ~[na:na]
	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484) ~[na:na]
	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474) ~[na:na]
	at java.base/java.util.stream.StreamSpliterators$WrappingSpliterator.forEachRemaining(StreamSpliterators.java:312) ~[na:na]
	at java.base/java.util.stream.Streams$ConcatSpliterator.forEachRemaining(Streams.java:735) ~[na:na]
	at java.base/java.util.stream.Streams$ConcatSpliterator.forEachRemaining(Streams.java:734) ~[na:na]
	at java.base/java.util.stream.ReferencePipeline$Head.forEach(ReferencePipeline.java:658) ~[na:na]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.invokeTestInstancePostProcessors(ClassBasedTestDescriptor.java:349) ~[junit-jupiter-engine-5.7.1.jar:5.7.1]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$instantiateAndPostProcessTestInstance$4(ClassBasedTestDescriptor.java:270) ~[junit-jupiter-engine-5.7.1.jar:5.7.1]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.7.1.jar:1.7.1]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.instantiateAndPostProcessTestInstance(ClassBasedTestDescriptor.java:269) ~[junit-jupiter-engine-5.7.1.jar:5.7.1]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$testInstancesProvider$2(ClassBasedTestDescriptor.java:259) ~[junit-jupiter-engine-5.7.1.jar:5.7.1]
	at java.base/java.util.Optional.orElseGet(Optional.java:369) ~[na:na]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$testInstancesProvider$3(ClassBasedTestDescriptor.java:258) ~[junit-jupiter-engine-5.7.1.jar:5.7.1]
	at org.junit.jupiter.engine.execution.TestInstancesProvider.getTestInstances(TestInstancesProvider.java:31) ~[junit-jupiter-engine-5.7.1.jar:5.7.1]
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.lambda$prepare$0(TestMethodTestDescriptor.java:101) ~[junit-jupiter-engine-5.7.1.jar:5.7.1]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.7.1.jar:1.7.1]
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.prepare(TestMethodTestDescriptor.java:100) ~[junit-jupiter-engine-5.7.1.jar:5.7.1]
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.prepare(TestMethodTestDescriptor.java:65) ~[junit-jupiter-engine-5.7.1.jar:5.7.1]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$prepare$1(NodeTestTask.java:111) ~[junit-platform-engine-1.7.1.jar:1.7.1]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.7.1.jar:1.7.1]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.prepare(NodeTestTask.java:111) ~[junit-platform-engine-1.7.1.jar:1.7.1]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:79) ~[junit-platform-engine-1.7.1.jar:1.7.1]
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541) ~[na:na]
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:38) ~[junit-platform-engine-1.7.1.jar:1.7.1]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:143) ~[junit-platform-engine-1.7.1.jar:1.7.1]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.7.1.jar:1.7.1]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$7(NodeTestTask.java:129) ~[junit-platform-engine-1.7.1.jar:1.7.1]
	at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:137) ~[junit-platform-engine-1.7.1.jar:1.7.1]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:127) ~[junit-platform-engine-1.7.1.jar:1.7.1]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.7.1.jar:1.7.1]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:126) ~[junit-platform-engine-1.7.1.jar:1.7.1]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:84) ~[junit-platform-engine-1.7.1.jar:1.7.1]
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541) ~[na:na]
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:38) ~[junit-platform-engine-1.7.1.jar:1.7.1]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:143) ~[junit-platform-engine-1.7.1.jar:1.7.1]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.7.1.jar:1.7.1]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$7(NodeTestTask.java:129) ~[junit-platform-engine-1.7.1.jar:1.7.1]
	at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:137) ~[junit-platform-engine-1.7.1.jar:1.7.1]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:127) ~[junit-platform-engine-1.7.1.jar:1.7.1]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.7.1.jar:1.7.1]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:126) ~[junit-platform-engine-1.7.1.jar:1.7.1]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:84) ~[junit-platform-engine-1.7.1.jar:1.7.1]
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.submit(SameThreadHierarchicalTestExecutorService.java:32) ~[junit-platform-engine-1.7.1.jar:1.7.1]
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutor.execute(HierarchicalTestExecutor.java:57) ~[junit-platform-engine-1.7.1.jar:1.7.1]
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestEngine.execute(HierarchicalTestEngine.java:51) ~[junit-platform-engine-1.7.1.jar:1.7.1]
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:108) ~[junit-platform-launcher-1.7.1.jar:1.7.1]
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:88) ~[junit-platform-launcher-1.7.1.jar:1.7.1]
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.lambda$execute$0(EngineExecutionOrchestrator.java:54) ~[junit-platform-launcher-1.7.1.jar:1.7.1]
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.withInterceptedStreams(EngineExecutionOrchestrator.java:67) ~[junit-platform-launcher-1.7.1.jar:1.7.1]
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:52) ~[junit-platform-launcher-1.7.1.jar:1.7.1]
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:96) ~[junit-platform-launcher-1.7.1.jar:1.7.1]
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:75) ~[junit-platform-launcher-1.7.1.jar:1.7.1]
	at com.intellij.junit5.JUnit5IdeaTestRunner.startRunnerWithArgs(JUnit5IdeaTestRunner.java:71) ~[junit5-rt.jar:na]
	at com.intellij.rt.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:33) ~[junit-rt.jar:na]
	at com.intellij.rt.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:221) ~[junit-rt.jar:na]
	at com.intellij.rt.junit.JUnitStarter.main(JUnitStarter.java:54) ~[junit-rt.jar:na]
```

### Links to find a solution in flapdoodle lib
- https://github.com/flapdoodle-oss/de.flapdoodle.embed.process/blob/de.flapdoodle.embed.process-2.1.2/src/main/java/de/flapdoodle/embed/process/store/ExtractedArtifactStore.java

### File stuff
- https://stackoverflow.com/questions/28698125/java-check-if-path-is-parent-of-a-file/28699663
- https://stackoverflow.com/questions/4746671/how-to-check-if-a-given-path-is-possible-child-of-another-path

### Workaround
create an absolute path from the relative target and pass it to flapdoodle's extraction/temp config
```java
final var absoluteExtractionPathFromRelative = Paths.get("target/embedmongo").toAbsolutePath().toString();
```

## flapdoodle 2 branch
- flapdoodle 2
- spring boot 2.4
- absolute and relative both working with extraction 
