package com.leontev.klavafunapi.service;

import com.leontev.klavafunapi.model.Keyboard;

public interface IKeyboardService {
    Keyboard getKeyboard(String lang);
}
