package com.gaggle.assessment.musicinfo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaggle.assessment.musicinfo.data.DataInitializer;
import com.gaggle.assessment.musicinfo.model.entities.Musician;
import com.gaggle.assessment.musicinfo.model.entities.Song;
import com.gaggle.assessment.musicinfo.model.request.SongPostRequest;
import com.gaggle.assessment.musicinfo.model.response.MusicianResponse;
import com.gaggle.assessment.musicinfo.model.response.SongResponse;
import com.gaggle.assessment.musicinfo.repository.SongRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = MusicInfoApplication.class)
@AutoConfigureMockMvc
class IntegrationTests {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private SongRepository songRepo;

    @Autowired
    private DataInitializer dataInitializer;

    @Autowired
    private ObjectMapper objectMapper;

    private Stream<Song> songs = DataInitializer.getSongStream();

    @BeforeEach
    public void init() {
        dataInitializer.initData();
    }

    @Test
    void getAllSongs(){
        ResponseEntity<String> response = restTemplate.getForEntity("/songs", String.class);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void getAllMusicians(){
        ResponseEntity<String> response = restTemplate.getForEntity("/musicians", String.class);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void postMusicians() {
        Musician musician = new Musician(null, "Dave", "Singer");
        ResponseEntity<String> response = restTemplate.postForEntity("/musicians", musician, String.class);
        Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
    @Test
    void postSongWithContributor() throws JsonProcessingException {
        List<String> musicianHrefs = getMusicianHrefs(1);
        SongPostRequest songPostRequest = new SongPostRequest(null, "123456", "Test", "The Dave",
                musicianHrefs);
        ResponseEntity<String> songResponse = restTemplate.postForEntity("/songs", songPostRequest, String.class);
        SongResponse songResponsePojo = objectMapper.readValue(songResponse.getBody(), SongResponse.class);
        Assert.assertEquals(HttpStatus.CREATED, songResponse.getStatusCode());
        Assert.assertEquals("The Dave", songResponsePojo.getArtist());
        Optional<Song> byId = songRepo.findById(songResponsePojo.getId());
        Assert.assertEquals(1, byId.get().getMusicianList().size());
    }

    @Test
    void patchSongWithContributor() throws JsonProcessingException {
        Optional<Song> byId = createSongWithContributors(1);
        Assert.assertEquals(1, byId.get().getMusicianList().size());

        byId = createSongWithContributors(2);
        Assert.assertEquals(2, byId.get().getMusicianList().size());
    }

    @Test
    void deleteSong() throws JsonProcessingException {
        Optional<Song> byId = createSongWithContributors(1);
        Assert.assertEquals(true, byId.isPresent());

        Integer id = byId.get().getId();
        restTemplate.delete(String.format("/songs/%d", id));
        byId = songRepo.findById(id);
        Assert.assertEquals(false, byId.isPresent());
    }

    private Optional<Song> createSongWithContributors(int numberOfMusicians) throws JsonProcessingException {
        List<String> musicianHrefs = getMusicianHrefs(numberOfMusicians);
        SongPostRequest songPostRequest = new SongPostRequest(null, "123456", "Test", "The Dave",
                musicianHrefs);
        ResponseEntity<String> songResponse = restTemplate.postForEntity("/songs", songPostRequest, String.class);
        SongResponse songResponsePojo = objectMapper.readValue(songResponse.getBody(), SongResponse.class);
        Optional<Song> byId = songRepo.findById(songResponsePojo.getId());
        return byId;
    }

    private List<String> getMusicianHrefs(int numberOfMusicians) throws JsonProcessingException {
        List<String> hrefs = new ArrayList<>();
        for(int i=0; i<numberOfMusicians; i++) {
            Musician musician = new Musician(null, "Dave", "Singer");
            ResponseEntity<String> musicianResponse = restTemplate.postForEntity("/musicians", musician, String.class);
            MusicianResponse musicianResponsePojo = objectMapper.readValue(musicianResponse.getBody(), MusicianResponse.class);
            hrefs.add(musicianResponsePojo.get_links().getMusician().getHref());
        }
        return hrefs;
    }
}
