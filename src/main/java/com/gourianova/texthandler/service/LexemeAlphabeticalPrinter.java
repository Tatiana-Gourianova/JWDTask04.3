package com.gourianova.texthandler.service;

import com.gourianova.texthandler.entity.TextComponent;
import com.gourianova.texthandler.entity.TextComposite;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

@Slf4j
public class LexemeAlphabeticalPrinter {//task6

    public void lexemeAlphabeticalPrinter(TextComposite textComposite) {
        TreeMap<Character, ArrayList<String>> lexems = addSymbols();
        for (TextComponent paragraphComponent : textComposite.getComponents()) {
            for (TextComponent sentenceComponent : paragraphComponent.getComponents()) {
                for (TextComponent lexemeComponent : sentenceComponent.getComponents()) {
                    String lexem = lexemeComponent.toString().trim();
                    char firstSymbol = lexem.toLowerCase().charAt(0);
                    if (Character.isLetter(firstSymbol)) {
                        lexems.get(firstSymbol).add(lexem);
                    }
                }
            }
        }
        for (Map.Entry<Character, ArrayList<String>> entry : lexems.entrySet()) {
            entry.getValue().sort(Comparator.naturalOrder());
            if (!entry.getValue().isEmpty()) {
                log.info(entry.getKey() + " " + entry.getValue());

            }
        }
    }

    private TreeMap<Character, ArrayList<String>> addSymbols() {
        TreeMap<Character, ArrayList<String>> lexems = new TreeMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            lexems.put(c, new ArrayList<>());
        }
        return lexems;
    }
}
