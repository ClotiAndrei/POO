package com.company;

public abstract class AbstractEntity {
    Long id;

    public AbstractEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
