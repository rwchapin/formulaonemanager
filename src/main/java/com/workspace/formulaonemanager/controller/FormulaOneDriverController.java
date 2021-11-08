package com.workspace.formulaonemanager.controller;

import com.workspace.formulaonemanager.models.FormulaOneDriver;
import com.workspace.formulaonemanager.repositories.FormulaOneDriverRepository;
import com.workspace.formulaonemanager.repositories.FormulaOneTeamRepository;
import com.workspace.formulaonemanager.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/f1drivers")
public class FormulaOneDriverController {

    @Autowired
    private DriverService driverService;

    @GetMapping
    public Iterable<FormulaOneDriver> getAllDrivers() {
        return driverService.getAllDrivers();
    }

    @GetMapping("/{id}")
    public FormulaOneDriver getOneDriver(@PathVariable("id") Long id){
        return driverService.getOneDriver(id);
    }

    @PostMapping
    public FormulaOneDriver createDriver(@RequestBody FormulaOneDriver driver){
        return driverService.createDriver(driver);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public FormulaOneDriver updateDriver(@PathVariable("id") Long id, @RequestBody FormulaOneDriver driver){
        return driverService.updateDriver(id, driver);
    }

    @DeleteMapping("/{id}")
    public FormulaOneDriver deleteDriver(@PathVariable("id") Long id){
        return driverService.deleteDriver(id);
    }


}
