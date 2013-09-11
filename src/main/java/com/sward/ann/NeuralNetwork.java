
package com.sward.ann;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author scottw
 */
public class NeuralNetwork {
    private List<List<Neuron>> layers;
    
    public NeuralNetwork(List<List<Neuron>> layers){
        this.layers = layers;
    }
    
    public List<Float> calculatePass(List<Float> input){
        List<Float> results = new ArrayList<>();
        
        for(Iterator<List<Neuron>> it = layers.iterator(); it.hasNext();){
            List<Neuron> layer = it.next();
            boolean onOutputLayer = !it.hasNext();
            
            for(Neuron neuron : layer){
                float neuronValue = neuron.calculateValue();
                if(onOutputLayer)
                    results.add(neuronValue);
            }
        }
        
        return results;
    }
}
