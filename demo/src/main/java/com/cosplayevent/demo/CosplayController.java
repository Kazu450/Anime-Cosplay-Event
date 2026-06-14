package com.cosplayevent.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CosplayController {

    @Autowired CosplayService cosplayService;

    @PostMapping("/cosplay/add/event") //  http://localhost:8080/cosplay/add/event?name=Kawaii Cosplay&location=Bulacan&date=08/06/2026
    public Event addEvent(@RequestParam String name,@RequestParam String location,@RequestParam String date){
        return cosplayService.addEvent(name,location,date);
    }

    @PostMapping("/cosplay/add/costume") //  http://localhost:8080/cosplay/add/costume?name=Earl&character=Mona&event=1
    public Costume addCostume(@RequestParam String name, @RequestParam String character, @RequestParam int event){
        return cosplayService.addCostume(name,character,event);
    }

    @GetMapping("/cosplay/event/list") //  http://localhost:8080/cosplay/event/list
    public List<Event> eventList(){
        return cosplayService.eventList();
    }

    @GetMapping("/cosplay/event/list/{id}") //  http://localhost:8080/cosplay/event/list/1
    public Event eventListID(@PathVariable int id){
        return cosplayService.eventListID(id);
    }

    @GetMapping("/cosplay/costume/list/{id}") //  http://localhost:8080/cosplay/costume/list/1
    public List<Costume> costumeListID(@PathVariable int id){
        return cosplayService.costumeListID(id);
    }

    @PutMapping("/cosplay/event/update/{id}")  //  http://localhost:8080/cosplay/event/update/1?date=08/06/2027
    public Event updateEvent(@PathVariable int id, @RequestParam String date){
        return cosplayService.updateEvent(id,date);

    }

    @DeleteMapping("/cosplay/event/delete/{id}")
    public void deleteEvent(@PathVariable int id){
       cosplayService.deleteEvent(id);
    }



}
