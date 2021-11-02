package com.workspace.formulaonemanager.controller;

import com.workspace.formulaonemanager.models.FormulaOneDriver;
import com.workspace.formulaonemanager.models.FormulaOneTeam;
import com.workspace.formulaonemanager.repositories.FormulaOneTeamRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/f1teams")
@CrossOrigin(origins = "http://localhost:4200")
public class FormulaOneTeamController {

    private FormulaOneTeamRepository fOneRepository;

    public FormulaOneTeamController(FormulaOneTeamRepository fOneRepository) {
        this.fOneRepository = fOneRepository;
    }

    @GetMapping
    public Iterable<FormulaOneTeam> getAllTeams() {
        return this.fOneRepository.findAll();
    }

    @GetMapping("/{id}")
    public FormulaOneTeam getTeamById(@PathVariable("id") Long id){
        Optional<FormulaOneTeam> teamById = this.fOneRepository.findById(id);
        if(!teamById.isPresent()){
            return null;
        }
        FormulaOneTeam foundTeam = teamById.get();
        return foundTeam;
    }

    @PostMapping
    public FormulaOneTeam createTeam(@RequestBody FormulaOneTeam team){
        FormulaOneTeam newTeam = this.fOneRepository.save(team);
        return newTeam;
    }

    @PutMapping("/{id}")
    public FormulaOneTeam updateTeam(@PathVariable("id") Long id, @RequestBody FormulaOneTeam team){
        System.out.println("***Update Start");
        Optional<FormulaOneTeam> teamToUpdateOptional = this.fOneRepository.findById(id);
        if(!teamToUpdateOptional.isPresent()){
            return null;
        }
        FormulaOneTeam teamToUpdate = teamToUpdateOptional.get();
        if(team.getTeamName() != null){
            System.out.println("***team name update");
            teamToUpdate.setTeamName(team.getTeamName());
        }
        if(team.getEngineManufacturer() != null){
            System.out.println("***engine update");
            teamToUpdate.setEngineManufacturer(team.getEngineManufacturer());
        }
        if(team.getConstructorPoints() != null){
            System.out.println("***con points update");
            teamToUpdate.setConstructorPoints(team.getConstructorPoints());
        }
        if(team.getDrivers() != null){
            System.out.println("***drivers update");
            teamToUpdate.setDrivers(team.getDrivers());
        }
        if(team.getChassis() != null){
            System.out.println("***chassis update");
            teamToUpdate.setChassis(team.getChassis());
        }
        if(team.getImgSrc() != null){
            System.out.println("***img update");
            teamToUpdate.setImgSrc(team.getImgSrc());
        }
        FormulaOneTeam updatedTeam = this.fOneRepository.save(teamToUpdate);
        return updatedTeam;
    }

    @DeleteMapping("/{id}")
    public FormulaOneTeam deleteTeam(@PathVariable("id") Long id){
        Optional<FormulaOneTeam> teamToDeleteOptional = this.fOneRepository.findById(id);
        if(!teamToDeleteOptional.isPresent()){
            return null;
        }
        FormulaOneTeam deleteTeam = teamToDeleteOptional.get();
        this.fOneRepository.delete(deleteTeam);
        return deleteTeam;
    }
}
