package com.fifafinder.fifadb.controllers;

import com.fifafinder.fifadb.dto.MannschaftenDto;
import com.fifafinder.fifadb.entities.Mannschaften;
import com.fifafinder.fifadb.services.MannschaftenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//Author: Levi, Enes
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

    public Mannschaften findMannschaftenByID(int id)
    {
        return mannschaftenService.getMannschaftenByID(id);
    }
    public Mannschaften getMannschaftenByName(String name)
    {
        return mannschaftenService.getMannschaftenByName(name);
    }
   @GetMapping("/mannschaften/{id}")
    public MannschaftenDto getMannschaftenWithDetails(@PathVariable Integer id) {
        return mannschaftenService.findMannschaftenWithDetails(id);
    }
}
