package com.workspace.formulaonemanager.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "FORMULA_ONE_DRIVERS")
public class FormulaOneDriver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DRIVER_NUMBER")
    private Integer driverNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "formula_one_team_id", referencedColumnName = "id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private FormulaOneTeam formulaOneTeam;
    @Column(name = "NATIONALITY")
    private String nationality;
    @Column(name = "DRIVERS_POINTS")
    private Double driverPoints;
    @Column(name = "TEAM_NAME")
    private String teamName;

    public FormulaOneDriver(String name, Integer driverNumber, String nationality) {
        this.name = name;
        this.driverNumber = driverNumber;
        this.nationality = nationality;
    }

    public FormulaOneDriver() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDriverNumber() {
        return driverNumber;
    }

    public void setDriverNumber(Integer driverNumber) {
        this.driverNumber = driverNumber;
    }

    public FormulaOneTeam getFormulaOneTeam() {
        return formulaOneTeam;
    }

    public void setFormulaOneTeam(FormulaOneTeam formulaOneTeam) {
        this.formulaOneTeam = formulaOneTeam;
        this.setTeamName(formulaOneTeam.getTeamName());
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Double getDriverPoints() {
        return driverPoints;
    }

    public void setDriverPoints(Double driverPoints) {
        this.driverPoints = driverPoints;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
