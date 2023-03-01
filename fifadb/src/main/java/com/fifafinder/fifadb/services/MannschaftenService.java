package com.fifafinder.fifadb.services;

import com.fifafinder.fifadb.entities.Mannschaften;
import com.fifafinder.fifadb.repositories.MannschaftenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MannschaftenService {
    private final MannschaftenRepository mannschaftenRepository;

    @Autowired
    public MannschaftenService(MannschaftenRepository mannschaftenRepository){
        this.mannschaftenRepository = mannschaftenRepository;
    }

    public List<Mannschaften> getClubs(){
        return mannschaftenRepository.findByOrderByClubNameAsc();
    }
}
