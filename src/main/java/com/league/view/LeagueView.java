package com.league.view;

import com.league.controller.IManager;
import com.league.controller.LeagueManager;
import com.league.exceptions.MalformedStringMatch;
import com.league.view.processor.IInputProcessor;
import com.league.view.processor.InputProcessor;
import com.league.view.processor.model.IInputModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class that provides an interface to for the user to place its input
 * Implements @IView
 */
public class LeagueView implements IView {

    /**
     * IManager Instance that will process the user input
     */
    private IManager manager;

    /**
     * Constructor that initializes the league manager and
     */
    public LeagueView() {
        manager = new LeagueManager();
    }
    /**
     * Method that provides an implementation to get an input from the user
     */
    @Override
    public void readInputAndProcess() {
        System.out.println("Please enter you input, place and empty line to stop...");
        try (InputStreamReader in = new InputStreamReader(System.in)) {
            BufferedReader reader = createBufferedReader(in);
            String line;
            IInputProcessor processor = new InputProcessor();
            while(!(line = reader.readLine()).equals("")) {
                IInputModel input = processor.processInput(line);
                manager.addResult(input);
            }
        } catch (IOException e) {
            System.out.format("IOException while reading the input: %s\n", e.getMessage());
        } catch (MalformedStringMatch e){
            System.out.format("MalformedStringMatch while reading a match input match not taken into consideration: %s\n", e.getMessage());
        }
    }

    /**
     * Method that creates a bufferedreader from an InputStreamReader
     * @param in Inputstream reader to initialice the buffered reader
     * @return @BufferedReader instance
     */
    protected BufferedReader createBufferedReader(InputStreamReader in){
        return new BufferedReader(in);
    }

    /**
     * View method to print the manager response
     */
    @Override
    public void printResult() {
        manager.printTable();
    }
}

