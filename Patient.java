/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.dja.project;

/**
 *
 * @author nianc
 */

//------------2.1-----------------------------------------------------------
public class Patient {
    
    private String name;
    private int Priority;
    
    public Patient(String name, int Priority){
        this.name = name;
        this.Priority = Priority;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setPriority(int priority) {
        this.Priority = Priority;
    }
    
    public int getPriority(){
        return Priority;
    }
    
     @Override
    public String toString(){
        return name + " (Priority: " + Priority + ")";
    }
   
    //--------------2.3------------------------------
    public static void main(String[] args){
         PriorityHeap pq = new PriorityHeap();

        pq.add(new Patient("Alice", 5));
        pq.add(new Patient("Bob", 7));
        pq.add(new Patient("Carol", 2));
        pq.add(new Patient("Dave", 10));
        pq.add(new Patient("Eve", 6));

        System.out.println("Heap after all insertions:");
        pq.displayHeap();

        
        Patient next = pq.nextPatient();
        System.out.println("\nNext patient attended: " + next);
        System.out.println("Heap after removal:");
        pq.displayHeap();
    
    }
}

