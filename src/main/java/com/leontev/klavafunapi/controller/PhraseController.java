package com.leontev.klavafunapi.controller;

import com.leontev.klavafunapi.model.Phrase;
import com.leontev.klavafunapi.service.IPhraseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/phrase")
@CrossOrigin
@Slf4j
public class PhraseController {

    private final IPhraseService phraseService;

    public PhraseController(IPhraseService phraseService) {
        this.phraseService = phraseService;
    }

    @GetMapping("/new")
    public ResponseEntity<Phrase> getRandomPhrase(@RequestParam("lang") String lang, @RequestParam("lvl") String level) {

        int intLevel;

        try {
            intLevel = Integer.parseInt(level);
        } catch (NumberFormatException ex) {
            log.error("Wrong level value received.");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (!phraseService.LEVELS.contains(intLevel) ||
                !phraseService.LANGUAGES.contains(lang)) {
            log.error("Wrong language or level value received.");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(
                phraseService.generateRandom(lang, intLevel),
                HttpStatus.OK
        );
    }
}
