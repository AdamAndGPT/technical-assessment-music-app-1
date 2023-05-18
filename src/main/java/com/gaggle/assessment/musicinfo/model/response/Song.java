package com.gaggle.assessment.musicinfo.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Song {
    private String isrc;
    private String title;
    private String artist;
    private Links _links;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Links {
        private Link self;
        private Link song;
        private Link musicianList;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Link {
            private String href;
        }
    }
}

