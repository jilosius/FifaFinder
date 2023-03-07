package com.fifafinder.fifadb.controllers;


import com.fifafinder.fifadb.entities.FifaVersion;
import com.fifafinder.fifadb.services.FifaService;
import org.springframework.web.bind.annotation.RestController;

//Author: Enes
@RestController
public class FifaController {
    private final FifaService fifaService;

    public FifaController(FifaService fifaService)
    {
        this.fifaService = fifaService;
    }

    public FifaVersion getVersionByID(int version)
    {
      return fifaService.getVersionByID(version);
    }
}
