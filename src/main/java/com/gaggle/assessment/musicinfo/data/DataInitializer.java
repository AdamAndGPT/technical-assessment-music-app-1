package com.gaggle.assessment.musicinfo.data;

import com.gaggle.assessment.musicinfo.model.Musician;
import com.gaggle.assessment.musicinfo.model.Song;
import com.gaggle.assessment.musicinfo.repository.SongRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class DataInitializer {
    private SongRepository songRepository;

    public void initData() {
        songRepository.saveAll(Stream.of(
                new Song(null, "12345", "Beat It", "Michael Jackson",
                        new HashSet<>(Arrays.asList(
                                new Musician(null, "Michael Jackson", "Singer")))),
                new Song(null, "12344", "Thunder Struck", "AC/DC",
                        new HashSet<>(Arrays.asList(
                                new Musician(null, "Brian Johnson", "Singer"),
                                new Musician(null, "Angus Young", "Lead Guitar"),
                                new Musician(null, "Malcom Young", "Rhythm Guitar"),
                                new Musician(null, "Phil Rudd", "Drummer")))),
                new Song(null, "12343", "Take Me Home, Country Roads", "John Denver",
                        new HashSet<>(Arrays.asList(
                                new Musician(null, "John Denver", "Singer"),
                                new Musician(null, "John Denver", "Guitar")))),
                new Song(null, "12342", "Smooth Criminal", "Michael Jackson",
                        new HashSet<>(Arrays.asList(
                                new Musician(null, "Michael Jackson", "Singer")))),
                new Song(null, "12341", "Billie Jean", "Michael Jackson",
                        new HashSet<>(Arrays.asList(
                                new Musician(null, "Michael Jackson", "Singer")))),
                new Song(null, "12340", "Bad", "Michael Jackson",
                        new HashSet<>(Arrays.asList(
                                new Musician(null, "Michael Jackson", "Singer")))),
                new Song(null, "12339", "Chicago", "Michael Jackson",
                        new HashSet<>(Arrays.asList(
                                new Musician(null, "Michael Jackson", "Singer"))))

        ).collect(Collectors.toList()));
    }
}
