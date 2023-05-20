package com.gaggle.assessment.musicinfo.config;

import com.gaggle.assessment.musicinfo.repository.eventhandler.SongEventHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {
    public RepositoryConfiguration(){
        super();
    }

    @Bean
    SongEventHandler songEventHandler() {
        return new SongEventHandler();
    }
}
