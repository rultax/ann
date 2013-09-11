/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sward.ann;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author scottw
 */
public class NeuralNetworkFactory {
    
    private ActivationFunction activationFunction;
    private Random random;
    
    public NeuralNetworkFactory(ActivationFunction activationFunction){
        this.activationFunction = activationFunction;
        random = new Random();
    }
    
    public NeuralNetwork createRandomNeuralNetwork(int hiddenLayers, int inputs, int outputs){
        List<List<Neuron>> layers = new ArrayList<>();
        layers.add(createLayer(inputs));
        
        for(int i = 0; i < hiddenLayers; i++){            
            int neuronsInLayer = 1 + random.nextInt(9);
            layers.add(createLayer(neuronsInLayer));
        }
        
        layers.add(createLayer(outputs));
        
        for(int i = 0; i < layers.size() - 1; i++){
            List<Neuron> layer = layers.get(i);                    
            for(int j = 0; j < layer.size(); j++){
                Connection c = createConnection();
                layer.get(j).addOutputConnection(c);
                for(Neuron n : layers.get(i + 1)){
                    n.addInputConnection(c);
                }
            }
        }
        
        return new NeuralNetwork(layers);
    }
    
    private List<Neuron> createLayer(int numberOfNeurons){
        List<Neuron> result = new ArrayList<>(numberOfNeurons);
        for(int i = 0; i < numberOfNeurons; i++){
            result.add(new Neuron(activationFunction));
        }
        return result;
    }
    
    private Connection createConnection(){
        return new SimpleWeightConnection(random.nextFloat() - 0.5f);
    }
}
