package com.leontev.klavafunapi.service;

import com.leontev.klavafunapi.model.Keyboard;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class KeyboardService implements IKeyboardService {

    private static final Keyboard RUSSIAN = new Keyboard();
    private static final Keyboard ENGLISH = new Keyboard();

    static {

        Map<String, String> russianKeys = new HashMap<>();

        russianKeys.put("Backquote", ">");
        russianKeys.put("Digit1", "1");
        russianKeys.put("Digit2", "2");
        russianKeys.put("Digit3", "3");
        russianKeys.put("Digit4", "4");
        russianKeys.put("Digit5", "5");
        russianKeys.put("Digit6", "6");
        russianKeys.put("Digit7", "7");
        russianKeys.put("Digit8", "8");
        russianKeys.put("Digit9", "9");
        russianKeys.put("Digit0", "0");
        russianKeys.put("Minus", "-");
        russianKeys.put("Equal", "=");
        russianKeys.put("Backspace", "backspase");
        russianKeys.put("Tab", "tab");
        russianKeys.put("KeyQ", "Й");
        russianKeys.put("KeyW", "Ц");
        russianKeys.put("KeyE", "У");
        russianKeys.put("KeyR", "К");
        russianKeys.put("KeyT", "Е");
        russianKeys.put("KeyY", "Н");
        russianKeys.put("KeyU", "Г");
        russianKeys.put("KeyI", "Ш");
        russianKeys.put("KeyO", "Щ");
        russianKeys.put("KeyP", "З");
        russianKeys.put("BracketLeft", "Х");
        russianKeys.put("BracketRight", "Ъ");
        russianKeys.put("Enter", "enter");
        russianKeys.put("CapsLock", "caps");
        russianKeys.put("KeyA", "Ф");
        russianKeys.put("KeyS", "Ы");
        russianKeys.put("KeyD", "В");
        russianKeys.put("KeyF", "А");
        russianKeys.put("KeyG", "П");
        russianKeys.put("KeyH", "Р");
        russianKeys.put("KeyJ", "О");
        russianKeys.put("KeyK", "Л");
        russianKeys.put("KeyL", "Д");
        russianKeys.put("Semicolon", "Ж");
        russianKeys.put("Quote", "Э");
        russianKeys.put("Backslash", "Ё");
        russianKeys.put("ShiftLeft", "shift");
        russianKeys.put("IntlBackslash", "]");
        russianKeys.put("KeyZ", "Я");
        russianKeys.put("KeyX", "Ч");
        russianKeys.put("KeyC", "С");
        russianKeys.put("KeyV", "М");
        russianKeys.put("KeyB", "И");
        russianKeys.put("KeyN", "Т");
        russianKeys.put("KeyM", "Ь");
        russianKeys.put("Comma", "Б");
        russianKeys.put("Period", "Ю");
        russianKeys.put("Slash", "/");
        russianKeys.put("ShiftRight", "shift");
        russianKeys.put("fn", "fn");
        russianKeys.put("ControlLeft", "control");
        russianKeys.put("AltLeft", "option");
        russianKeys.put("MetaLeft", "command");
        russianKeys.put("Space", "space");
        russianKeys.put("MetaRight", "command");
        russianKeys.put("AltRight", "option");
        russianKeys.put("ArrowLeft", "<");
        russianKeys.put("ArrowUp", "^");
        russianKeys.put("ArrowRight", ">");

        Map<String, String> englishKeys = new HashMap<>();

        englishKeys.put("Backquote", "§");
        englishKeys.put("Digit1", "1");
        englishKeys.put("Digit2", "2");
        englishKeys.put("Digit3", "3");
        englishKeys.put("Digit4", "4");
        englishKeys.put("Digit5", "5");
        englishKeys.put("Digit6", "6");
        englishKeys.put("Digit7", "7");
        englishKeys.put("Digit8", "8");
        englishKeys.put("Digit9", "9");
        englishKeys.put("Digit0", "0");
        englishKeys.put("Minus", "-");
        englishKeys.put("Equal", "=");
        englishKeys.put("Backspace", "backspase");
        englishKeys.put("Tab", "tab");
        englishKeys.put("KeyQ", "Q");
        englishKeys.put("KeyW", "W");
        englishKeys.put("KeyE", "E");
        englishKeys.put("KeyR", "R");
        englishKeys.put("KeyT", "T");
        englishKeys.put("KeyY", "Y");
        englishKeys.put("KeyU", "U");
        englishKeys.put("KeyI", "I");
        englishKeys.put("KeyO", "O");
        englishKeys.put("KeyP", "P");
        englishKeys.put("BracketLeft", "[");
        englishKeys.put("BracketRight", "]");
        englishKeys.put("Enter", "enter");
        englishKeys.put("CapsLock", "caps");
        englishKeys.put("KeyA", "A");
        englishKeys.put("KeyS", "S");
        englishKeys.put("KeyD", "D");
        englishKeys.put("KeyF", "F");
        englishKeys.put("KeyG", "G");
        englishKeys.put("KeyH", "H");
        englishKeys.put("KeyJ", "J");
        englishKeys.put("KeyK", "K");
        englishKeys.put("KeyL", "L");
        englishKeys.put("Semicolon", ";");
        englishKeys.put("Quote", "'");
        englishKeys.put("Backslash", "\\");
        englishKeys.put("ShiftLeft", "shift");
        englishKeys.put("IntlBackslash", "`");
        englishKeys.put("KeyZ", "Z");
        englishKeys.put("KeyX", "X");
        englishKeys.put("KeyC", "C");
        englishKeys.put("KeyV", "V");
        englishKeys.put("KeyB", "B");
        englishKeys.put("KeyN", "N");
        englishKeys.put("KeyM", "M");
        englishKeys.put("Comma", ",");
        englishKeys.put("Period", ".");
        englishKeys.put("Slash", "/");
        englishKeys.put("ShiftRight", "shift");
        englishKeys.put("fn", "fn");
        englishKeys.put("ControlLeft", "control");
        englishKeys.put("AltLeft", "option");
        englishKeys.put("MetaLeft", "command");
        englishKeys.put("Space", "space");
        englishKeys.put("MetaRight", "command");
        englishKeys.put("AltRight", "option");
        englishKeys.put("ArrowLeft", "<");
        englishKeys.put("ArrowUp", "^");
        englishKeys.put("ArrowRight", ">");

        RUSSIAN.setKeys(russianKeys);
        ENGLISH.setKeys(englishKeys);
    }

    @Override
    public Keyboard getKeyboard(String lang) {

        if (lang.equals("ru"))
            return RUSSIAN;
        if (lang.equals("en"))
            return ENGLISH;

        return null;
    }
}
