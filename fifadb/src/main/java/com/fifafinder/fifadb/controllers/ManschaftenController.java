package com.fifafinder.fifadb.controllers;

import com.fifafinder.fifadb.entities.Mannschaften;
import com.fifafinder.fifadb.services.ManschaftenService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManschaftenController {
    private final ManschaftenService manschaftenService;

    public ManschaftenController(ManschaftenService manschaftenService)
    {
        this.manschaftenService = manschaftenService;
    }

    public Mannschaften findManschaftenByID(int id)
    {
        return manschaftenService.getManschaftenByID(id);
    }

    public Mannschaften findManschaftenByName(String name) {return manschaftenService.getManschaftenByName(name);}
}
