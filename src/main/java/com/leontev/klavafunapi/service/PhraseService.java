package com.leontev.klavafunapi.service;

import com.leontev.klavafunapi.model.Phrase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Slf4j
public class PhraseService implements IPhraseService {
    private static final int MINIMAL_PHRASE_LENGTH = 100;
    private static List<String> RUSSIAN_1;
    private static List<String> RUSSIAN_2;
    private static List<String> RUSSIAN_3;
    private static List<String> RUSSIAN_4;
    private static List<String> RUSSIAN_5;
    private static List<String> ENGLISH_1;
    private static List<String> ENGLISH_2;
    private static List<String> ENGLISH_3;
    private static List<String> ENGLISH_4;
    private static List<String> ENGLISH_5;


    static {
        RUSSIAN_1 = scanFile("src/main/resources/files/russian_1.txt");
        log.info("russian 1 level loaded.");
        RUSSIAN_2 = scanFile("src/main/resources/files/russian_2.txt");
        log.info("russian 2 level loaded.");
        RUSSIAN_3 = scanFile("src/main/resources/files/russian_3.txt");
        log.info("russian 3 level loaded.");
        RUSSIAN_4 = scanFile("src/main/resources/files/russian_4.txt");
        log.info("russian 4 level loaded.");
        RUSSIAN_5 = scanFile("src/main/resources/files/russian_5.txt");
        log.info("russian 5 level loaded.");

        ENGLISH_1 = scanFile("src/main/resources/files/english_1.txt");
        log.info("english 1 level loaded.");
        ENGLISH_2 = scanFile("src/main/resources/files/english_2.txt");
        log.info("english 2 level loaded.");
        ENGLISH_3 = scanFile("src/main/resources/files/english_3.txt");
        log.info("english 3 level loaded.");
        ENGLISH_4 = scanFile("src/main/resources/files/english_4.txt");
        log.info("english 4 level loaded.");
        ENGLISH_5 = scanFile("src/main/resources/files/english_5.txt");
        log.info("english 5 level loaded.");
    }

    @Override
    public Phrase generateRandom(String lang, Integer level) {

        String text = "";

        if (lang.equals("ru")) {
            text = switch (level) {
                case 1 -> generate(RUSSIAN_1);
                case 2 -> generate(RUSSIAN_2);
                case 3 -> generate(RUSSIAN_3);
                case 4 -> generate(RUSSIAN_4);
                case 5 -> generate(RUSSIAN_5);
                default -> text;
            };
        } else if (lang.equals("en")) {
            text = switch (level) {
                case 1 -> generate(ENGLISH_1);
                case 2 -> generate(ENGLISH_2);
                case 3 -> generate(ENGLISH_3);
                case 4 -> generate(ENGLISH_4);
                case 5 -> generate(ENGLISH_5);
                default -> text;
            };
        }

        text = text.toLowerCase();

        List<Character> chars = new ArrayList<>();
        for (char c : text.toCharArray()) {
            chars.add(c);
        }

        return new Phrase(chars, convertToKeys(text, lang));
    }

    private static List<String> scanFile(String fileName) {
        List<String> result = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileInputStream(fileName), StandardCharsets.UTF_8)) {
            while (scanner.hasNext()) {
                result.add(scanner.nextLine());
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        return result;
    }

    private String generate(List<String> words) {
        StringBuilder phrase = new StringBuilder();

        while (phrase.length() < MINIMAL_PHRASE_LENGTH) {
            phrase.append(words.get(ThreadLocalRandom.current().nextInt(words.size())));
            phrase.append(" ");
        }

        return phrase.toString().trim();
    }

    private List<String> convertToKeys(String phrase, String lang) {

        if (lang.equals("ru"))
            phrase = transliterate(phrase);

        List<String> result = new ArrayList<>();

        for (Character ch: phrase.toCharArray()) {
            ch = Character.toUpperCase(ch);
            if (Character.isDigit(ch)) {
                result.add("Digit" + ch);
            } else if(Character.isLetter(ch)) {
                result.add("Key" + ch);
            } else if(Character.isWhitespace(ch)) {
                result.add("Space");
            } else if(ch.equals('.')) {
                result.add("Period");
            } else if(ch.equals(',')) {
                result.add("Comma");
            } else if(ch.equals('[')) {
                result.add("BracketLeft");
            } else if(ch.equals(']')) {
                result.add("BracketRight");
            } else if(ch.equals(';')) {
                result.add("Semicolon");
            } else if(ch.equals('\'')) {
                result.add("Quote");
            }
        }

        return result;
    }

    private static String transliterate(String text) {
        StringBuilder result = new StringBuilder();
        String[] russian = {"й", "ц", "у", "к", "е", "н", "г", "ш", "щ", "з", "х", "ъ", "ф", "ы", "в", "а", "п", "р", "о", "л", "д", "ж", "э", "я", "ч", "с", "м", "и", "т", "ь", "б", "ю"};
        String[] english = {"q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "[", "]", "a", "s", "d", "f", "g", "h", "j", "k", "l", ";", "'", "z", "x", "c", "v", "b", "n", "m", ",", "."};
        for (int i = 0; i < text.length(); i++) {
            String symbol = text.substring(i, i + 1);
            for (int j = 0; j < russian.length; j++) {
                if (russian[j].equals(symbol)) {
                    symbol = english[j];
                    break;
                }
            }
            result.append(symbol);
        }
        return result.toString();
    }
}
