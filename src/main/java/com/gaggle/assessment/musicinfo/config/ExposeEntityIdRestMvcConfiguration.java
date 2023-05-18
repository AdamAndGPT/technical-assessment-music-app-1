package com.gaggle.assessment.musicinfo.config;


import com.gaggle.assessment.musicinfo.model.entities.Musician;
import com.gaggle.assessment.musicinfo.model.entities.Song;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Component
public class ExposeEntityIdRestMvcConfiguration implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Musician.class, Song.class);
    }
}
