package com.cosplayevent.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CosplayService {

@Autowired EventRepository eventRepository;
@Autowired CostumeRepository costumeRepository;

    public Event addEvent(String name, String location, String date){
        return eventRepository.save(new Event(name,location,date));
    }

    public Costume addCostume(String name, String character, int eventID){
        Event event = eventRepository.findById(eventID).orElse(null);
                return costumeRepository.save(new Costume(name,character,event));
    }

    public List<Event> eventList(){
        return eventRepository.findAll();

    }

    public Event eventListID(int id){
        Event listID = eventRepository.findById(id).orElse(null);
        return listID;
    }

    public List<Costume> costumeListID(int id){
        Event event = eventRepository.findById(id).orElse(null);
        return costumeRepository.findByEvent(event);
    }

    public Event updateEvent(int id, String date){
        Event event = eventRepository.findById(id).orElse(null);
        event.setDate(date);
        return eventRepository.save(event);
    }

    public void  deleteEvent(int id){
        eventRepository.deleteById(id);
    }
}
