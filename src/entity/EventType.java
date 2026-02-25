/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package entity;

/**
 *
 * @author Henrique Rigoni Nunes
 */
// Identifica qual é a ação
public enum EventType {
    CREATE(1),
    UPDATE(2),
    DELETE(3);
    
    private int type;
    
    private EventType(int type){
        this.type = type;
    }
    
    public int get(){
        return this.type;
    }
}
