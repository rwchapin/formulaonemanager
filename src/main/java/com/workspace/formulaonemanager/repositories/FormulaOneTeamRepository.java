package com.workspace.formulaonemanager.repositories;

import com.workspace.formulaonemanager.models.FormulaOneDriver;
import com.workspace.formulaonemanager.models.FormulaOneTeam;
import org.springframework.data.repository.CrudRepository;

public interface FormulaOneTeamRepository extends CrudRepository<FormulaOneTeam, Long> {

}
