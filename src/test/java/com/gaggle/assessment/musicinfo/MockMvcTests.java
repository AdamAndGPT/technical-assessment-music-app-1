package com.gaggle.assessment.musicinfo;

import com.gaggle.assessment.musicinfo.data.DataInitializer;
import com.gaggle.assessment.musicinfo.model.entities.Song;
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

import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = MusicInfoApplication.class)
@AutoConfigureMockMvc
class MockMvcTests {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private SongRepository songRepo;

    @Autowired
    private DataInitializer dataInitializer;

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

    }

}
