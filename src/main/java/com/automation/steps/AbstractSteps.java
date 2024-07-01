package com.automation.steps;

import org.springframework.beans.factory.annotation.Autowired;

import com.automation.state.StateManager;

public abstract class AbstractSteps {

    @Autowired
    protected StateManager stateManager;
}