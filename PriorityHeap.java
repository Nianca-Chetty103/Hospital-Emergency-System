/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dja.project;

/**
 *
 * @author nianc
 */
//-------------2.2-----------------------------

import java.util.ArrayList;
import java .util.Collections;

public class PriorityHeap {
    private ArrayList<Patient> heap;

    public PriorityHeap() {
        this.heap = new ArrayList<>();
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

   
    public void add(Patient patient) {
        heap.add(patient);
        int currentIndex = heap.size() - 1;

        while (currentIndex > 0 && heap.get(currentIndex).getPriority() > heap.get(parent(currentIndex)).getPriority()) {
            Collections.swap(heap, currentIndex, parent(currentIndex));
            currentIndex = parent(currentIndex);
        }
    }

    
    public Patient poll() {
        if (heap.isEmpty()) {
            return null;
        }

        Patient highest = heap.get(0);
        Patient last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            bubbleDown(0);
        }

        return highest;
    }

    
   
    private void bubbleDown(int currentIndex) {
        while (true) {
            int left = leftChild(currentIndex);
            int right = rightChild(currentIndex);
            int largest = currentIndex;

            if (left < heap.size() && heap.get(left).getPriority() > heap.get(largest).getPriority()) {
                largest = left;
            }

            if (right < heap.size() && heap.get(right).getPriority() > heap.get(largest).getPriority()) {
                largest = right;
            }

            if (largest == currentIndex) {
                break;
            }

            Collections.swap(heap, currentIndex, largest);
            currentIndex = largest;
        }
    }

    
    public void displayHeap() {
        System.out.println(heap);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
    
     //--------------2.4------------------------------
    public Patient nextPatient(){
        return poll();
    }
    
}
    