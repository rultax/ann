
package com.sward.ann;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author scottw
 */
public class Neuron implements Runnable {
    
    private static final Logger logger = LoggerFactory.getLogger(Neuron.class);
    
    private long chargeHoldTime;
    private BlockingQueue<Float> input;
    private ThresholdFunction thresholdFunction;
    private Collection<Connection> outputConnections;
    private boolean running;
    
    public Neuron(  long chargeHoldTime, 
                    BlockingQueue<Float> input, 
                    ThresholdFunction thresholdFunction,
                    Collection<Connection> outputConnections){
        this.chargeHoldTime = chargeHoldTime;
        this.input = input;
        this.thresholdFunction = thresholdFunction;
        this.outputConnections = outputConnections;
        this.running = false;
    }
    
    public void kill(){
        this.running = false;
    }

    @Override
    public void run() {
        while(running){
            
            try {
                Thread.sleep(chargeHoldTime);
            } catch (InterruptedException ex) {
                logger.warn("InturruptedException during sleep", ex);
            }
            
            Collection<Float> inputs = new ArrayList<>();
            input.drainTo(inputs);
            
            float output = thresholdFunction.calculateThreshold(inputs);
            for(Connection c : outputConnections){
                c.sendInput(output);
            }
        }
    }
}
