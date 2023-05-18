package com.gaggle.assessment.musicinfo.repository;

import com.gaggle.assessment.musicinfo.model.entities.Song;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SongRepository extends PagingAndSortingRepository<Song, Integer> {
}
