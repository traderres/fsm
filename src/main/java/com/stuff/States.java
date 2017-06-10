package com.stuff;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by adam on 5/29/2017.
 */
public enum States implements State
{
        INIT
        {
            @Override
            public State next(StateInput aStateInput)
            {
                logger.debug("In INIT:  action()={}", aStateInput.getAction() );
                return ANALYST_REVIEWS_REPORT;
            }
        },
        ANALYST_REVIEWS_REPORT
        {
            @Override
            public State next(StateInput aStateInput)
            {
                logger.debug("In ANALYST_REVIEWS_REPORT:  action={}", aStateInput.getAction() );
                State nextState = FAIL;

                if ((aStateInput.getAction() == StateAction.COUNTERMASURER_EXPEDITED) ||
                    (aStateInput.getAction() == StateAction.COUNTERMEASURE_RECOMMENDED))
                {
                    nextState = REVIEW_INDICATORS;
                }

                logger.debug("  Going to {}", nextState);
                return nextState;
            }
        },
        REVIEW_INDICATORS
        {
            @Override
            public State next(StateInput aStateInput)
            {
                logger.debug("In REVIEW_INDICATORS:  action={}", aStateInput.getAction() );
                State nextState = FAIL;

                if (aStateInput.getAction() == StateAction.YES_COUNTERMEASURE_RECOMMENDED)
                {
                    nextState = SELECT_TOOL;
                }

                logger.debug("  Going to {}", nextState);
                return nextState;
            }
        },
        SELECT_TOOL
        {
            @Override
            public State next(StateInput aStateInput)
            {
                logger.debug("In SELECT_TOOL:  action={}", aStateInput.getAction() );
                State nextState = FAIL;

                if (aStateInput.getAction() == StateAction.WCF_TOOL_SELECTED)
                {
                    nextState = WCF_SME_REVIEW;
                }
                else if (aStateInput.getAction() == StateAction.IP_TOOL_SELECTED);
                {
                    nextState = ACL_SME_REVIEW;
                }
                logger.debug("  Going to {}", nextState);
                return nextState;
            }
        },
        WCF_SME_REVIEW
        {
            @Override
            public State next(StateInput aStateInput)
            {
                logger.debug("In WCF_SME_REVIEW:  action={}", aStateInput.getAction() );
                State nextState = COMPLETE;

                logger.debug("  Going to {}", nextState);
                return nextState;
            }
        },
        ACL_SME_REVIEW
        {
            @Override
            public State next(StateInput aStateInput)
            {
                logger.debug("In ACL_SME_REVIEW:  action={}", aStateInput.getAction() );
                State nextState = COMPLETE;

                logger.debug("  Going to {}", nextState);
                return nextState;
            }
        },
        COMPLETE
        {
            @Override
            public State next(StateInput word)
            {
                logger.debug("In COMPLETE");
                return COMPLETE;
            }
        },
        FAIL
        {
            @Override
            public State next(StateInput word)
            {
                logger.debug("In COMPLETE");
                return FAIL;
            }
        };


    public abstract State next(StateInput word);

    private static final Logger logger = LoggerFactory.getLogger(States.class);
}
