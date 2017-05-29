package com.resnick;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ) {
        logger.debug("main() started");

        StateInput in = new StateInput("aabbc");

        State s = States.Init;
        while ((s != null) && (s != States.Fail))
        {
            s = s.next(in);
            logger.debug("new state = {}", s);
        }

        if (s == null)
        {
            logger.debug("Valid!");
        }
        else
        {
            logger.debug("Failed");
        }


    }
}
