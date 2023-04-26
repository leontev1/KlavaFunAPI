package com.leontev.klavafunapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
public class Keyboard {
    private Map<String, String> keys;
    private Map<String, String> shiftKeys;
}

