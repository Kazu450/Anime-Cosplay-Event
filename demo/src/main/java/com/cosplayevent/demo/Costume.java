package com.cosplayevent.demo;

import jakarta.persistence.*;

@Entity
public class Costume {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
   private int id;
    private String name,costumeCharacter;
    @ManyToOne
    private Event event;


    public Costume(String name, String costumeCharacter, Event event) {
        this.name = name;
        this.costumeCharacter = costumeCharacter;
        this.event = event;
    }

    public Costume(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCostumeCharacter() {
        return costumeCharacter;
    }

    public void setCostumeCharacter(String costumeCharacter) {
        this.costumeCharacter = costumeCharacter;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
