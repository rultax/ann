/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sward.ann;

/**
 *
 * @author scottw
 */
public class SimpleWeightConnection implements Connection{
    private float weight;
    private float inputSignal;
    
    public SimpleWeightConnection(float weight){
        this.weight = weight;
    }

    @Override
    public void sendSignal(float inputSignal) {
        this.inputSignal = inputSignal;
    }

    @Override
    public float calculateSignalStrength() {
        return weight * inputSignal;
    }
}
