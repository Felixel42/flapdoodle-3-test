package com.example.demo;

import de.flapdoodle.embed.mongo.Command;
import de.flapdoodle.embed.mongo.config.Defaults;
import de.flapdoodle.embed.mongo.config.MongodConfig;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.config.RuntimeConfig;
import de.flapdoodle.embed.process.extract.DirectoryAndExecutableNaming;
import de.flapdoodle.embed.process.extract.NoopTempNaming;
import de.flapdoodle.embed.process.io.directories.Directory;
import de.flapdoodle.embed.process.io.directories.FixedPath;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Paths;

@Configuration
public class FlapdoodleMongoConfiguration {
    private static final Command command = Command.MongoD;
    private static final Directory extractStorePathRelative = new FixedPath("target/embedmongo");
    // private static final Directory extractStorePathAbsolute = new FixedPath("<absolute-path>/target/embedmongo");

    @Bean
    public RuntimeConfig runtimeConfig() {
        final var absoluteExtractionPathFromRelative = Paths.get("target/embedmongo").toAbsolutePath().toString();
        return Defaults.runtimeConfigFor(command)
                       .artifactStore(Defaults.extractedArtifactStoreFor(command)
                                              .withExtraction(DirectoryAndExecutableNaming.builder()
                                                                                          .directory(new FixedPath(absoluteExtractionPathFromRelative))
                                                                                          .executableNaming(new NoopTempNaming())
                                                                                          .build())
//                                              .withTemp(DirectoryAndExecutableNaming.builder()
//                                                                                    .directory(new FixedPath(absoluteExtractionPathFromRelative))
//                                                                                    .executableNaming(new UUIDTempNaming())
//                                                                                    .build()
//                                              )
                       )
                       .build();
    }

    @Bean
    public MongodConfig versionConfig() {
        return MongodConfig.builder()
                           .version(Version.V4_0_12)
                           .build();
    }
}
