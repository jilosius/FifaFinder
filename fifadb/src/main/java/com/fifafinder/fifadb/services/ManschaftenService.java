package com.fifafinder.fifadb.services;


import com.fifafinder.fifadb.entities.Mannschaften;
import com.fifafinder.fifadb.repositories.MannschaftenRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
@Slf4j
public class ManschaftenService {
    private final MannschaftenRepository mannschaftenRepository;

    @Autowired
    public ManschaftenService(MannschaftenRepository mannschaftenRepository)
    {
        this.mannschaftenRepository = mannschaftenRepository;
    }

    public Mannschaften getManschaftenByID(int id)
    {
        return mannschaftenRepository.findById(id);
    }
}
