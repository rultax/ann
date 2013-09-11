/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sward.ann;

/**
 *
 * @author scottw
 */
public interface Connection {

    public void sendSignal(float neuronValue);
    public float calculateSignalStrength();
}
