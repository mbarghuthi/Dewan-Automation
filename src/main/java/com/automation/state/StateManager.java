package com.automation.state;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class StateManager {

    private Map<String, Object> resourceMap;

    public StateManager() {
        resourceMap = new HashMap<>();
    }

    public void put(String key, Object object) {
        resourceMap.put(key, object);
    }

    public Object get(String key) {
        return resourceMap.get(key);
    }

    public void clear() {
        resourceMap.clear();
    }
}