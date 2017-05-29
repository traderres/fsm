package com.resnick;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by adam on 5/29/2017.
 */
public class StateInput
{
    private String input;
    private int current;

    private static final Logger logger = LoggerFactory.getLogger(StateInput.class);


    /*************************************************************************
     * StateInput()   Consturctor
     *
     * @param aInput
     *************************************************************************/
    public StateInput(String aInput)
    {
        this.input = aInput;
    }

    char read()
    {
        if (this.current >= this.input.length())
        {
            return '\0';
        }
        else
        {
            char ch = this.input.charAt(current);
            this.current++;

            logger.debug("read() returns {}", ch);
            return ch;
        }
    }

}
