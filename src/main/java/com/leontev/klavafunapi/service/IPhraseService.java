package com.leontev.klavafunapi.service;

import com.leontev.klavafunapi.model.Phrase;

import java.util.List;

public interface IPhraseService {
    List<Integer> LEVELS = List.of(1, 2, 3, 4, 5);
    List<String> LANGUAGES = List.of("ru", "en");
    Phrase generateRandom(String lang, Integer level);
}
