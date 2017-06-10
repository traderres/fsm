package com.stuff;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main( String[] args )
    {
        logger.debug("main() started");

        StateInput stateInput = new StateInput(Permission.GUEST, StateAction.REPORT_ADDED);

        State s = States.INIT;
        while ((s != States.COMPLETE) && (s != States.FAIL))
        {
            s = s.next(stateInput);
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
