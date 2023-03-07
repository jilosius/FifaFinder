package com.fifafinder.fifadb.services;

import com.fifafinder.fifadb.entities.FifaVersion;
import com.fifafinder.fifadb.repositories.FifaVersionRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//Author: Enes
@Service
@Transactional
@Slf4j
public class FifaService {
    private final FifaVersionRepository fifaVersionRepository;
    @Autowired
    public FifaService(FifaVersionRepository fifaVersionRepository){
        this.fifaVersionRepository = fifaVersionRepository;

    }

    public FifaVersion getVersionByID(int version)
    {
        return fifaVersionRepository.findById(version);
    }
}
