package com.workspace.formulaonemanager.service;

import com.workspace.formulaonemanager.models.FormulaOneTeam;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TeamService {

   Iterable<FormulaOneTeam> getAllTeams();
   FormulaOneTeam getTeamById(Long id);
   FormulaOneTeam createTeam(FormulaOneTeam team);
   FormulaOneTeam updateTeam(Long id, FormulaOneTeam team);
   FormulaOneTeam deleteTeam(Long id);
   List<FormulaOneTeam> searchTeams(String name, String engine);

}
