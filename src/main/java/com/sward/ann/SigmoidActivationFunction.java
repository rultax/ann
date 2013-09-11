/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sward.ann;

/**
 *
 * @author scottw
 */
public class SigmoidActivationFunction implements ActivationFunction{

    @Override
    public float applyActivationFunction(float inputSum) {
        return 1.0f / (1.0f + (float)Math.exp(-1.0f * inputSum));
    }
    
}
