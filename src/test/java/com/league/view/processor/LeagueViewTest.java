package com.league.view.processor;

import com.league.view.IView;
import com.league.view.LeagueView;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.*;

/**
 * Test class for league view flow
 */
@RunWith(MockitoJUnitRunner.class)
public class LeagueViewTest {

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
     * Method that tests the flow for a run on the league manager view
     * @throws IOException in case IOException ocurrs while reading input
     */
    @Test
    public void voidTestView() throws IOException {
        final BufferedReader reader = Mockito.mock(BufferedReader.class);
        Mockito.when(reader.readLine())
                .thenReturn("Lions 3, Snakes 3")
                .thenReturn("Tarantulas 1, FC Awesome 0")
                .thenReturn("Lions 1, FC Awesome 1")
                .thenReturn("Tarantulas 3, Snakes 1")
                .thenReturn("Lions 4, Grouches 0")
                .thenReturn("");
        IView lv = new LeagueView(){
            @Override
            protected BufferedReader createBufferedReader(InputStreamReader in){
                return reader;
            }
        };
        lv.readInputAndProcess();
        lv.printResult();
        Assert.assertEquals("Please enter you input, place and empty line to stop...\n1. Tarantulas, 6 pts\n2. Lions, 5 pts\n3. FCAwesome, 1 pt\n3. Snakes, 1 pt\n5. Grouches, 0 pts\n", out.toString());
    }
}
