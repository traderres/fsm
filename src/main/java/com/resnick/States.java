package com.resnick;

/**
 * Created by adam on 5/29/2017.
 */
public enum States implements State
{
        Init
        {
            @Override
            public State next(StateInput aWord)
            {
                switch (aWord.read())
                {
                    case 'a':
                        return A;
                    default:
                        return Fail;
                }
            }
        },
        A {
            @Override
            public State next(StateInput word)
            {
                switch(word.read())
                {
                    case 'a': return A;
                    case 'b': return B;
                    case 'c': return C;
                    case '\0': return null;
                    default: return Fail;
                }
            }
        },
        B {
            @Override
            public State next(StateInput word)
            {
                switch(word.read())
                {
                    case 'b': return B;
                    case 'c': return C;
                    case '\0': return null;
                    default: return Fail;
                }
            }
        },
        C {
            @Override
            public State next(StateInput word)
            {
                switch(word.read())
                {
                    case 'c': return C;
                    case '\0': return null;
                    default: return Fail;
                }
            }
        },
        Fail {
            @Override
            public State next(StateInput word)
            {
                return Fail;
            }
        };


    public abstract State next(StateInput word);

 }
