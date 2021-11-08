package com.workspace.formulaonemanager.service;

import com.workspace.formulaonemanager.models.FormulaOneTeam;
import com.workspace.formulaonemanager.repositories.FormulaOneTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService{

    @Autowired
    private FormulaOneTeamRepository fOneTeamRepository;

    @Override
    public Iterable<FormulaOneTeam> getAllTeams() {
        return fOneTeamRepository.findAll();
    }

    @Override
    public FormulaOneTeam getTeamById(Long id) {
        Optional<FormulaOneTeam> teamById = fOneTeamRepository.findById(id);
        if(!teamById.isPresent()){
            return null;
        }
        FormulaOneTeam foundTeam = teamById.get();
        return foundTeam;
    }

    @Override
    public FormulaOneTeam createTeam(FormulaOneTeam team) {
        return fOneTeamRepository.save(team);
    }

    @Override
    public FormulaOneTeam updateTeam(Long id, FormulaOneTeam team) {
        Optional<FormulaOneTeam> teamToUpdateOptional = fOneTeamRepository.findById(id);
        if(!teamToUpdateOptional.isPresent()){
            return null;
        }
        FormulaOneTeam teamToUpdate = teamToUpdateOptional.get();
        if(team.getTeamName() != null){
            teamToUpdate.setTeamName(team.getTeamName());
        }
        if(team.getEngineManufacturer() != null){
            teamToUpdate.setEngineManufacturer(team.getEngineManufacturer());
        }
        if(team.getConstructorPoints() != null){
            teamToUpdate.setConstructorPoints(team.getConstructorPoints());
        }
        if(team.getDrivers() != null){
            teamToUpdate.setDrivers(team.getDrivers());
        }
        if(team.getChassis() != null){
            teamToUpdate.setChassis(team.getChassis());
        }
        if(team.getImgSrc() != null){
            teamToUpdate.setImgSrc(team.getImgSrc());
        }
        FormulaOneTeam updatedTeam = fOneTeamRepository.save(teamToUpdate);
        return updatedTeam;
    }

    @Override
    public FormulaOneTeam deleteTeam(Long id) {
        Optional<FormulaOneTeam> teamToDeleteOptional = fOneTeamRepository.findById(id);
        if(!teamToDeleteOptional.isPresent()){
            return null;
        }
        FormulaOneTeam deleteTeam = teamToDeleteOptional.get();
        fOneTeamRepository.delete(deleteTeam);
        return deleteTeam;
    }

    @Override
    public List<FormulaOneTeam> searchTeams(String name, String engine) {
        if(Objects.nonNull(name)){
            return fOneTeamRepository.findByTeamName(name);
        } else if(Objects.nonNull(engine)){
            return fOneTeamRepository.findByEngineManufacturer(engine);
        } else {
            throw new NullPointerException("Try Again");
        }
    }
}
