package com.gaggle.assessment.musicinfo.model.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SongPostRequest {
    private Integer id;
    private String isrc;
    private String title;
    private String artist;
    private List<String> musicianList;
}

