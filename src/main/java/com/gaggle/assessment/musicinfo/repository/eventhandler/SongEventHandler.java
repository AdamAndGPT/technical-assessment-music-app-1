package com.gaggle.assessment.musicinfo.repository.eventhandler;

import com.gaggle.assessment.musicinfo.model.entities.Song;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RepositoryEventHandler(Song.class)
public class SongEventHandler {
    @Autowired
    RestTemplate restTemplate;

    @Value("${com.gaggle.assessment.musicinfo.webhook.url}")
    private String webhookUrl;

    @HandleAfterCreate
    public void handleSongAfterCreate(Song song) {
        log.info("POSTing created song to Webhook URL: " + webhookUrl);
        ResponseEntity<String> response = restTemplate.postForEntity(webhookUrl, song, String.class);
        log.info("Finished posting Song to Webhook URL, returned with status code: " + response.getStatusCode());
    }
}
