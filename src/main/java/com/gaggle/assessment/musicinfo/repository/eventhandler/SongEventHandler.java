package com.gaggle.assessment.musicinfo.repository.eventhandler;

import com.gaggle.assessment.musicinfo.model.entities.Song;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@Slf4j
@RepositoryEventHandler(Song.class)
public class SongEventHandler {
    @HandleAfterCreate
    public void handleSongAfterCreate(Song song) {
        log.info("POSTing created song to Webhook");
    }
}
