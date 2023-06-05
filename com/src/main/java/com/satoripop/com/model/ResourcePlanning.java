package com.satoripop.com.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.satoripop.com.model.enumeration.Regime;
import com.satoripop.com.model.enumeration.Res;
import com.satoripop.com.model.enumeration.Role;
import com.satoripop.com.model.enumeration.bus;
import jakarta.persistence.*;

@Entity
public class ResourcePlanning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(name = "regime")
    private Regime regime;

    @Column(name = "start_date")
    private int startDate;

    @Column(name = "end_date")
    private int endDate;

    @Column(name = "effort")
    private Float effort;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Res status;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    @Column(name = "created_date")
    private int createdDate;

    @Column(name = "last_modified_date")
    private int lastModifiedDate;

    @Column(name = "bu")
    private bus bu;

    @Column(name = "TeamMember")
    private String TeamMember;

    @Column(name = "duration")
    private Float duration;

    @ManyToOne
    private UserInfo user;

    @JsonIgnoreProperties(value = { "resourcesPlanning", "projects", "changes", "responsable", "bu" }, allowSetters = true)
    @OneToOne(mappedBy = "resourcesPlanning")
    private Projet project;


    public ResourcePlanning() {
    }

    public ResourcePlanning(Long id,String name ,Role role,bus bu ,Regime regime, int startDate, int endDate, Float effort, Res status, String createdBy, String lastModifiedBy, int createdDate, int lastModifiedDate, Float duration) {
        this.id = id;
        this.role = role;
        this.regime = regime;
        this.startDate = startDate;
        this.endDate = endDate;
        this.effort = effort;
        this.status = status;
        this.createdBy = createdBy;
        this.lastModifiedBy = lastModifiedBy;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.bu=bu;
        this.TeamMember=name;
        this.duration=duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Regime getRegime() {
        return regime;
    }

    public void setRegime(Regime regime) {
        this.regime = regime;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

    public Float getEffort() {
        return effort;
    }

    public void setEffort(Float effort) {
        this.effort = effort;
    }

    public Res getStatus() {
        return status;
    }

    public void setStatus(Res status) {
        this.status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public int getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(int createdDate) {
        this.createdDate = createdDate;
    }

    public int getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(int lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public UserInfo getUser() {
        return this.user;
    }

    public void setUser(UserInfo userInfo) {
        this.user = userInfo;
    }

    public ResourcePlanning user(UserInfo userInfo) {
        this.setUser(userInfo);
        return this;
    }

    public Projet getProject() {
        return this.project;
    }

    public void setProject(Projet project) {
        if (this.project != null) {
            this.project.setResourcesPlanning(null);
        }
        if (project != null) {
            project.setResourcesPlanning(this);
        }
        this.project = project;
    }

    public ResourcePlanning project(Projet project) {
        this.setProject(project);
        return this;
    }

    public bus getBu() {
        return bu;
    }

    public void setBu(bus bu) {
        this.bu = bu;
    }

    public String getTeamMember() {
        return TeamMember;
    }

    public void setTeamMember(String teamMember) {
        TeamMember = teamMember;
    }

    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }
}
