package com.stuff;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by adam on 5/29/2017.
 */
public class StateInput
{
    private static final Logger logger = LoggerFactory.getLogger(StateInput.class);

    private Permission permission;
    private StateAction action;

    public Permission getPermission() { return permission; }
    public void setPermission(Permission permission) { this.permission = permission; }

    public StateAction getAction() { return action; }
    public void setAction(StateAction action) { this.action = action; }


    /*************************************************************************
     * StateInput()   Consturctor
     *
     *************************************************************************/
    public StateInput(Permission aPermission, StateAction aAction)
    {
        this.permission = aPermission;
        this.action = aAction;
    }

}
