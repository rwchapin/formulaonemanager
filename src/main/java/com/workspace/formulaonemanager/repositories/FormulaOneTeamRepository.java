package com.workspace.formulaonemanager.repositories;

import com.workspace.formulaonemanager.models.FormulaOneDriver;
import com.workspace.formulaonemanager.models.FormulaOneTeam;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FormulaOneTeamRepository extends CrudRepository<FormulaOneTeam, Long> {

    List<FormulaOneTeam> findByTeamName(String teamName);
    List<FormulaOneTeam> findByEngineManufacturer(String engineManufacturer);

}
