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
    public static final String MICHAEL_JACKSON = "Michael Jackson";
    public static final String JOHN_DENVER = "John Denver";
    private SongRepository songRepository;

    public void initData() {
        songRepository.saveAll(getSongStream().collect(Collectors.toList()));
    }

    public static Stream<Song> getSongStream() {
        return Stream.of(
                new Song(null, "12345", "Beat It", MICHAEL_JACKSON,
                        new HashSet<>(Arrays.asList(
                                new Musician(null, MICHAEL_JACKSON, "Singer")))),
                new Song(null, "12344", "Thunder Struck", "AC/DC",
                        new HashSet<>(Arrays.asList(
                                new Musician(null, "Brian Johnson", "Singer"),
                                new Musician(null, "Angus Young", "Lead Guitar"),
                                new Musician(null, "Malcom Young", "Rhythm Guitar"),
                                new Musician(null, "Phil Rudd", "Drummer")))),
                new Song(null, "12343", "Take Me Home, Country Roads", JOHN_DENVER,
                        new HashSet<>(Arrays.asList(
                                new Musician(null, JOHN_DENVER, "Singer"),
                                new Musician(null, JOHN_DENVER, "Guitar")))),
                new Song(null, "12342", "Smooth Criminal", MICHAEL_JACKSON,
                        new HashSet<>(Arrays.asList(
                                new Musician(null, MICHAEL_JACKSON, "Singer")))),
                new Song(null, "12341", "Billie Jean", MICHAEL_JACKSON,
                        new HashSet<>(Arrays.asList(
                                new Musician(null, MICHAEL_JACKSON, "Singer")))),
                new Song(null, "12340", "Bad", MICHAEL_JACKSON,
                        new HashSet<>(Arrays.asList(
                                new Musician(null, MICHAEL_JACKSON, "Singer")))),
                new Song(null, "12339", "Chicago", MICHAEL_JACKSON,
                        new HashSet<>(Arrays.asList(
                                new Musician(null, MICHAEL_JACKSON, "Singer"))))

        );
    }
}
