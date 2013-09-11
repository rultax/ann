package com.sward.ann;

import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ActivationFunction activationFunction = new SigmoidActivationFunction();
        
        NeuralNetworkFactory factory = new NeuralNetworkFactory(activationFunction);
        NeuralNetwork network = factory.createRandomNeuralNetwork(1, 2, 2);
        
        List<Float> input = Arrays.asList(1f, 0f);
        List<Float> result = network.calculatePass(input);
        System.out.println(result.toString());        
    }
}
