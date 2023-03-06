package com.fifafinder.fifadb.services;

import com.fifafinder.fifadb.dto.MannschaftenDto;
import com.fifafinder.fifadb.entities.Mannschaften;
import com.fifafinder.fifadb.repositories.MannschaftenRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@Slf4j
public class MannschaftenService {
    private final MannschaftenRepository mannschaftenRepository;

    @Autowired
    public MannschaftenService(MannschaftenRepository mannschaftenRepository){
        this.mannschaftenRepository = mannschaftenRepository;
    }

    public MannschaftenDto findMannschaftenWithDetails(int id){


        return mannschaftenRepository.findMannschaftenWithDetails(id);
    }

    public List<Mannschaften> getClubs(){
        return mannschaftenRepository.findByOrderByClubNameAsc();
    }

    public Mannschaften getMannschaftenByID(int id)
    {
        return mannschaftenRepository.findById(id);
    }

    public Mannschaften getMannschaftenByName(String name){return mannschaftenRepository.findMannschaftenByClubName(name);}
}
