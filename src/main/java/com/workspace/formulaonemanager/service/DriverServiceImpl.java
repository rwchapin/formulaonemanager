package com.workspace.formulaonemanager.service;

import com.workspace.formulaonemanager.models.FormulaOneDriver;
import com.workspace.formulaonemanager.repositories.FormulaOneDriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService{

    @Autowired
    private FormulaOneDriverRepository fOneDriverRepository;

    @Override
    public Iterable<FormulaOneDriver> getAllDrivers() {
        return fOneDriverRepository.findAll();
    }

    @Override
    public FormulaOneDriver getOneDriver(Long id) {
        Optional<FormulaOneDriver> driverOptional = fOneDriverRepository.findById(id);
        if(!driverOptional.isPresent()) {
            return null;
        }
        FormulaOneDriver foundDriver = driverOptional.get();
        return foundDriver;
    }

    @Override
    public FormulaOneDriver createDriver(FormulaOneDriver driver) {
        return fOneDriverRepository.save(driver);
    }

    @Override
    public FormulaOneDriver updateDriver(Long id, FormulaOneDriver driver) {
        Optional<FormulaOneDriver> driverUpdateOptional = fOneDriverRepository.findById(id);
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
        FormulaOneDriver updatedDriver = fOneDriverRepository.save(driverToUpdate);
        return updatedDriver;
    }

    @Override
    public FormulaOneDriver deleteDriver(Long id) {
        Optional<FormulaOneDriver> driverToDeleteOptional = fOneDriverRepository.findById(id);
        if(!driverToDeleteOptional.isPresent()){
            return null;
        }
        FormulaOneDriver deleteDriver = driverToDeleteOptional.get();
        fOneDriverRepository.delete(deleteDriver);
        return deleteDriver;
    }
}
