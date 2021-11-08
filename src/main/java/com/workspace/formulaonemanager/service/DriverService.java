package com.workspace.formulaonemanager.service;

import com.workspace.formulaonemanager.models.FormulaOneDriver;

public interface DriverService {
    Iterable<FormulaOneDriver> getAllDrivers();
    FormulaOneDriver getOneDriver(Long id);
    FormulaOneDriver createDriver(FormulaOneDriver driver);
    FormulaOneDriver updateDriver(Long id, FormulaOneDriver driver);
    FormulaOneDriver deleteDriver(Long id);
}
