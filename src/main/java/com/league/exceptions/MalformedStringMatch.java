package com.league.exceptions;

/**
 * Custom exception to notify when a string is incorrect
 * it has the wrong structure to hold a match for the league
 */
public class MalformedStringMatch extends Exception {

    /**
     * Constructor that initialices detailedMessage from Exception super class
     * @param errorMessage Specified Error message
     */
    public MalformedStringMatch(String errorMessage) {
        super(errorMessage);
    }
}
