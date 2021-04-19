package com.example.demo;

import de.flapdoodle.embed.mongo.Command;
import de.flapdoodle.embed.mongo.config.ExtractedArtifactStoreBuilder;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.RuntimeConfigBuilder;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.config.IRuntimeConfig;
import de.flapdoodle.embed.process.io.directories.FixedPath;
import de.flapdoodle.embed.process.io.directories.IDirectory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class FlapdoodleMongoConfiguration {
    private static final Command command = Command.MongoD;
    private static final IDirectory extractStorePathRelative = new FixedPath("target/embedmongo");
    // private static final Directory extractStorePathAbsolute = new FixedPath("<absolute-path>/target/embedmongo");

    @Bean
    public IRuntimeConfig runtimeConfig() {
        return new RuntimeConfigBuilder().defaults(command)
                                         .artifactStore(new ExtractedArtifactStoreBuilder().defaults(command)
                                                                                           .extractDir(extractStorePathRelative))
                                         .build();
    }

    @Bean
    public IMongodConfig versionConfig() throws IOException {
        return new MongodConfigBuilder().version(Version.V4_0_2)
                                        .build();
    }
}
