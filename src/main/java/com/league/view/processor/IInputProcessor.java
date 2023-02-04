package com.league.view.processor;

import com.league.exceptions.MalformedStringMatch;
import com.league.view.processor.model.IInputModel;

import java.util.List;

/**
 * Interface that defines the behaviour for an Input Processor
 */
public interface IInputProcessor {

    /**
     * Method that processes the input string and returns a list
     * with the matches in form of an input Model
     * @param inputStrings input strings with the data provided by the user
     * @return List of input models
     */
    public IInputModel processInput(String inputStrings) throws MalformedStringMatch;

}
