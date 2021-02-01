package com.gourianova.texthandler.service;

import com.gourianova.texthandler.entity.TextComponent;
import com.gourianova.texthandler.entity.TextComposite;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LexemeSorter {

    public List<String> sorter(TextComposite textComposite, CharSequence symbol) {
        ArrayList<String> lexems = new ArrayList<>();
        for (TextComponent paragraphComponent : textComposite.getComponents()) {
            for (TextComponent sentenceComponent : paragraphComponent.getComponents()) {
                for (TextComponent lexemeComponent : sentenceComponent.getComponents()) {
                    lexems.add(lexemeComponent.toString().trim());
                }
            }
        }
        List<String> sorted = lexems.stream().sorted(Comparator.comparingInt((String word) -> StringUtils.countMatches(word, symbol)).reversed().thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
        // System.out.println(sorted);
        return sorted;
    }
}
