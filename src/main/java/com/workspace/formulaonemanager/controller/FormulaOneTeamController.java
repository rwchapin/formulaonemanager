package com.workspace.formulaonemanager.controller;

import com.workspace.formulaonemanager.models.FormulaOneDriver;
import com.workspace.formulaonemanager.models.FormulaOneTeam;
import com.workspace.formulaonemanager.repositories.FormulaOneTeamRepository;
import com.workspace.formulaonemanager.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/f1teams")
@CrossOrigin(origins = "http://localhost:4200")
public class FormulaOneTeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping
    public Iterable<FormulaOneTeam> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/{id}")
    public FormulaOneTeam getTeamById(@PathVariable("id") Long id){
        return teamService.getTeamById(id);
    }

    @PostMapping
    public FormulaOneTeam createTeam(@RequestBody FormulaOneTeam team){
        return teamService.createTeam(team);
    }

    @PutMapping("/{id}")
    public FormulaOneTeam updateTeam(@PathVariable("id") Long id, @RequestBody FormulaOneTeam team){
        return teamService.updateTeam(id, team);
    }

    @DeleteMapping("/{id}")
    public FormulaOneTeam deleteTeam(@PathVariable("id") Long id){
        return teamService.deleteTeam(id);
    }

    @GetMapping("/search")
    public List<FormulaOneTeam> searchTeams(@RequestParam(required = false) String name,
                                            @RequestParam(required = false) String engine){
        return teamService.searchTeams(name, engine);


    }
}
