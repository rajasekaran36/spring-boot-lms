package com.kgisl.raja.lms.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class PlayList{
    @Id
    private Long id;
    private Long learningResourceId;

    PlayList(){}


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLearningResourceId() {
        return this.learningResourceId;
    }

    public void setLearningResourceId(Long learningResourceId) {
        this.learningResourceId = learningResourceId;
    }


}