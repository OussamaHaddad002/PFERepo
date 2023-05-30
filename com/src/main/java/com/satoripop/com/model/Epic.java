package com.satoripop.com.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Epic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "deadline")
    private int deadline;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    @Column(name = "created_date")
    private int createdDate;

    @Column(name = "last_modified_date")
    private int lastModifiedDate;

    @OneToMany(mappedBy = "epic")
    @JsonIgnoreProperties(value = { "assignedTo", "epic" }, allowSetters = true)
    private Set<Action> actions = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = { "resourcesPlanning", "projects", "changes", "responsable", "bu" }, allowSetters = true)
    private Projet epic;

    public Epic() {
    }

    public Epic(Long id, String name, int deadline, String createdBy, String lastModifiedBy, int createdDate, int lastModifiedDate) {
        this.id = id;
        this.name = name;
        this.deadline = deadline;
        this.createdBy = createdBy;
        this.lastModifiedBy = lastModifiedBy;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
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

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
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

    public Set<Action> getActions() {
        return actions;
    }

    public void setActions(Set<Action> actions) {
        if (this.actions != null) {
            this.actions.forEach(i -> i.setEpic(null));
        }
        if (actions != null) {
            actions.forEach(i -> i.setEpic(this));
        }
        this.actions = actions;
    }

    public Epic actions(Set<Action> actions) {
        this.setActions(actions);
        return this;
    }

    public Epic addActions(Action action) {
        this.actions.add(action);
        action.setEpic(this);
        return this;
    }

    public Epic removeActions(Action action) {
        this.actions.remove(action);
        action.setEpic(null);
        return this;
    }

    public Projet getEpic() {
        return this.epic;
    }

    public void setEpic(Projet project) {
        this.epic = project;
    }

    public Epic epic(Projet project) {
        this.setEpic(project);
        return this;
    }


}
