package com.fifafinder.fifadb.controllers;

import com.fifafinder.fifadb.entities.Mannschaften;
import com.fifafinder.fifadb.services.MannschaftenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clubs")
public class MannschaftenController {

    private final MannschaftenService mannschaftenService;

    @Autowired
    public MannschaftenController(MannschaftenService mannschaftenService){
        this.mannschaftenService = mannschaftenService;
    }

    @GetMapping
    public List<Mannschaften> getClubs(){
        return mannschaftenService.getClubs();
    }
}
