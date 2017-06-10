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

        // Advancing from Init -> ANALYST_REVIEWS_REPORT
        s = s.next(stateInput);
        endOnStateIsFailOrComplete(s);

        // Advancing from ANALYST_REVIEWS_REPORT -> REVIEW_INDICATORS
        stateInput.setAction(StateAction.COUNTERMASURER_EXPEDITED);
        s = s.next(stateInput);
        endOnStateIsFailOrComplete(s);

        // Advancing from REVIEW_INDICATORS -> SELECT_TOOL
        stateInput.setAction(StateAction.YES_COUNTERMEASURE_RECOMMENDED);
        s = s.next(stateInput);
        endOnStateIsFailOrComplete(s);


        // Advancing from SELECT_TOOL -> WCF_SME_REVIEW
        stateInput.setAction(StateAction.WCF_TOOL_SELECTED);
        s = s.next(stateInput);
        endOnStateIsFailOrComplete(s);

        // Advancing from SELECT_TOOL -> WCF_SME_REVIEW
        stateInput.setAction(StateAction.WCF_TOOL_SELECTED);
        s = s.next(stateInput);
        endOnStateIsFailOrComplete(s);

        // Advancing from WCF_SME_REVIEW -> WCF_SME_REVIEW
        s = s.next(stateInput);
        endOnStateIsFailOrComplete(s);

    }


    private static void endOnStateIsFailOrComplete(State aState)
    {
        String sStateName = aState.toString();
        if (sStateName.equalsIgnoreCase("FAIL"))
        {
            logger.error("State is FAIL.  Stopping here.");
            System.exit(1);
        }
        else if (sStateName.equalsIgnoreCase("COMPLETE"))
        {
            logger.info("State is COMPLETE.  Stopping here.");
            System.exit(0);
        }
    }


}

