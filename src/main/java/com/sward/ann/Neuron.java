
package com.sward.ann;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author scottw
 */
public class Neuron {
    
    private ActivationFunction thresholdFunction;
    private Collection<Connection> inputs;
    private Collection<Connection> outputs;    
    
    public Neuron(ActivationFunction activationFunction){
        this.thresholdFunction = activationFunction;
        inputs = new ArrayList<>();
        outputs = new ArrayList<>();
    }
    
    void addInputConnection(Connection input){
        inputs.add(input);
    }
    
    void addOutputConnection(Connection output){
        outputs.add(output);
    }
    
    float calculateValue(){
        
        float inputSum = 0;
        
        for(Connection c : inputs){
            inputSum += c.calculateSignalStrength();
        }
        
        float neuronValue = thresholdFunction.applyActivationFunction(inputSum);
        
        if(outputs != null && outputs.size() > 0){
            for(Connection c : outputs){
                c.sendSignal(neuronValue);
            }
        }
        
        return neuronValue;
    }    
}
