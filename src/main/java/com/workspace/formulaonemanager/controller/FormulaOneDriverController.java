package com.workspace.formulaonemanager.controller;

import com.workspace.formulaonemanager.models.FormulaOneDriver;
import com.workspace.formulaonemanager.repositories.FormulaOneDriverRepository;
import com.workspace.formulaonemanager.repositories.FormulaOneTeamRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/f1drivers")
public class FormulaOneDriverController {

    private FormulaOneDriverRepository fOneDriverRepository;

    private FormulaOneTeamRepository fOneTeamRepository;

    public FormulaOneDriverController(FormulaOneDriverRepository fOneDriverRepository, FormulaOneTeamRepository fOneTeamRepository){
        this.fOneDriverRepository = fOneDriverRepository;
        this.fOneTeamRepository = fOneTeamRepository;
    }

    @GetMapping
    public Iterable<FormulaOneDriver> getAllDrivers() {
        return this.fOneDriverRepository.findAll();
    }

    @GetMapping("/{id}")
    public FormulaOneDriver getOneDriver(@PathVariable("id") Long id){
        Optional<FormulaOneDriver> driverOptional = this.fOneDriverRepository.findById(id);
        if(!driverOptional.isPresent()) {
            return null;
        }
        FormulaOneDriver foundDriver = driverOptional.get();
        return foundDriver;
    }

    @PostMapping
    public FormulaOneDriver createDriver(@RequestBody FormulaOneDriver driver){
        FormulaOneDriver newDriver = this.fOneDriverRepository.save(driver);
        return newDriver;
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public FormulaOneDriver updateDriver(@PathVariable("id") Long id, @RequestBody FormulaOneDriver driver){
        Optional<FormulaOneDriver> driverUpdateOptional = this.fOneDriverRepository.findById(id);
        if(!driverUpdateOptional.isPresent()){
            return null;
        }
        FormulaOneDriver driverToUpdate = driverUpdateOptional.get();
        if(driver.getName() != null){
            driverToUpdate.setName(driver.getName());
        }
        if(driver.getDriverNumber() != null){
            driverToUpdate.setDriverNumber(driver.getDriverNumber());
        }
        if(driver.getNationality() != null){
            driverToUpdate.setNationality(driver.getNationality());
        }
        if(driver.getDriverPoints() != null){
            driverToUpdate.setDriverPoints(driver.getDriverPoints());
        }
        FormulaOneDriver updatedDriver = this.fOneDriverRepository.save(driverToUpdate);
        return updatedDriver;
    }


}
