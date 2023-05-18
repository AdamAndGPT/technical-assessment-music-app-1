package com.gaggle.assessment.musicinfo.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MusicianResponse {
    private Integer id;
    private String name;
    private String contribution;
    private Links _links;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Links {
        private Link self;
        private Link musician;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Link {
            private String href;
        }
    }
}

