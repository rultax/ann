/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sward.ann;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author scottw
 */
public class Connection {
    
    private float weight;    
    private BlockingQueue<Float> output;
    
    public Connection(float weight, BlockingQueue<Float> output) {
        this.weight = weight;
        this.output = output;
    }   
    
    public void sendInput(float input){
        float value = input * weight;
        output.add(value);
    }
}
