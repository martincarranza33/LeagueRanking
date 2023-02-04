package com.league.controller;

import com.league.view.processor.model.IInputModel;
import com.league.view.processor.model.InputModel;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Test class for league manager flow
 */
public class LeagueManagerTest {

    /**
     * ByteArrayOutputStream that will catch System.out PrintStream
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    /**
     * ByteArrayOutputStream that will catch System.err PrintStream
     */
    private final ByteArrayOutputStream err = new ByteArrayOutputStream();
    /**
     * PrintStream that will hold System.out
     */
    private final PrintStream originalOut = System.out;
    /**
     * PrintStream that will hold System.err
     */
    private final PrintStream originalErr = System.err;

    /**
     * IManager instance
     */
    private IManager manager;

    /**
     * Method that executes before the tests
     */
    @Before
    public void initSetStreams(){
        System.setOut(new PrintStream(out));
        System.setErr(new PrintStream(err));
    }

    /**
     * Method that executes after the tests are completed
     */
    @After
    public void restoreStreams(){
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    /**
     * Test that the manager processes the addition of a result
     * Two assertions one for the output and the second one that the teams
     * are processed and stored as expected
     */
    @Test
    public void testAddMatches() {
        manager = new LeagueManager();
        IInputModel i1 = new InputModel("Team1", "Team2", 1, 2);
        IInputModel i2 = new InputModel("Team1", "Team3", 1, 2);
        IInputModel i3 = new InputModel("Team2", "Team3", 1, 2);
        manager.addResult(i1);
        manager.addResult(i2);
        manager.addResult(i3);
        manager.printTable();
        Assert.assertEquals("1. Team3, 6 pts\n2. Team2, 3 pts\n3. Team1, 0 pts\n", out.toString());
        Assert.assertEquals(manager.getTeams().entrySet().size(), 3);
    }
}
