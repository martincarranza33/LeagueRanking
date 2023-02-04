package com.league.view;

/**
 * Interface that provides behaviour to the View used to retrieve the input
 *
 */
public interface IView {

    /**
     * Method that will provide an implementation to get an input from the user
     */
    public void readInputAndProcess();

    /**
     * Method that will print the result
     */
    public void printResult();
}
