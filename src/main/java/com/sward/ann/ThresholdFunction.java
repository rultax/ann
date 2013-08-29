/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sward.ann;

import java.util.Collection;

/**
 *
 * @author scottw
 */
public interface ThresholdFunction {
    
    public float calculateThreshold(Collection<Float> input);
    
}
