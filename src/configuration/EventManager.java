/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package configuration;

import entity.Event;
import entity.EventType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cliente
 */
public class EventManager {
    private static List<Event> events = new ArrayList<>();
    
    public static boolean isEmpty(){
        return events.isEmpty();
    }
    
    public static void add(String msg,EventType type){
        Event event = new Event((long) events.size()+1,msg,type);
        events.add(event);
    }
    
    public static Event top(){
        return events.getFirst();
    }
    
    public static Event delete(){
        return events.removeFirst();
    }
}
