package com.workspace.formulaonemanager.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Formula_One_Team")
public class FormulaOneTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "TEAM_NAME")
    private String teamName;
    @Column(name = "ENGINE_MANUFACTURER")
    private String engineManufacturer;
    @Column(name = "CONSTRUCTOR_POINTS")
    private Double constructorPoints;
    @Column(name = "CHASSIS")
    private String chassis;
    @OneToMany(mappedBy = "formulaOneTeam", cascade = CascadeType.ALL)
    private List<FormulaOneDriver> drivers = new ArrayList<>();
    @Column(name = "Image_Source")
    private String imgSrc;

    public FormulaOneTeam(String teamName, String engineManufacturer, Double constructorPoints, String chassis) {
        this.teamName = teamName;
        this.engineManufacturer = engineManufacturer;
        this.constructorPoints = constructorPoints;
        this.chassis = chassis;
    }

    public FormulaOneTeam() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getEngineManufacturer() {
        return engineManufacturer;
    }

    public void setEngineManufacturer(String engineManufacturer) {
        this.engineManufacturer = engineManufacturer;
    }

    public Double getConstructorPoints() {
        return constructorPoints;
    }

    public void setConstructorPoints(Double constructorPoints) {
        this.constructorPoints = constructorPoints;
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public List<FormulaOneDriver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<FormulaOneDriver> drivers) {
        this.drivers = drivers;

        for(FormulaOneDriver d : drivers){
            d.setFormulaOneTeam(this);
        }
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
}
