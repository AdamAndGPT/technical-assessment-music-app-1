package com.gaggle.assessment.musicinfo.repository;

import com.gaggle.assessment.musicinfo.model.Musician;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MusicianRepository extends PagingAndSortingRepository<Musician, Integer> {
}
