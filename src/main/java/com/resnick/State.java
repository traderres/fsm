package com.resnick;

/**
 * Created by adam on 5/29/2017.
 */
public interface State {
    public State next(StateInput aWord);
}
