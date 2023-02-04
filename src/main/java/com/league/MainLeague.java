package com.league;

import com.league.view.IView;
import com.league.view.LeagueView;

/**
 * Main class for LeagueRanking project, Initializes and invokes the methods from the view to
 * get the input and process it
 */
public class MainLeague {
    /**
     * Main method its invoked to execute the application
     * @param args
     */
    public static void main(String[] args) {
        IView lv = new LeagueView();
        lv.readInputAndProcess();
        lv.printResult();
    }
}
