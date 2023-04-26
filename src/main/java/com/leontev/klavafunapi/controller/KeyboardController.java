package com.leontev.klavafunapi.controller;

import com.leontev.klavafunapi.model.Keyboard;
import com.leontev.klavafunapi.service.IKeyboardService;
import com.leontev.klavafunapi.service.IPhraseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/keyboard")
@CrossOrigin
@Slf4j
public class KeyboardController {

    private final IKeyboardService keyboardService;

    public KeyboardController(IKeyboardService keyboardService) {
        this.keyboardService = keyboardService;
    }

    @GetMapping
    public ResponseEntity<Keyboard> getKeyboard(@RequestParam("lang") String lang) {
        if (!IPhraseService.LANGUAGES.contains(lang)) {
            log.error("Wrong language value received.");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(keyboardService.getKeyboard(lang), HttpStatus.OK);
    }
}
