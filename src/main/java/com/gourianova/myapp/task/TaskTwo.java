package com.gourianova.myapp.task;

import com.gourianova.service.SortByComparator;
import com.gourianova.texthandler.chainparser.SentenceParser;
import com.gourianova.texthandler.entity.TextComponent;
import com.gourianova.texthandler.entity.TextComposite;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.gourianova.texthandler.entity.ComponentType.LEXEME;

public class TaskTwo {
    @Getter
    private final ArrayList<String> arrayList;

    public TaskTwo(ArrayList<TextComponent> arrayList) {
        Map<String, Integer> map = new HashMap<>();
        for (TextComponent sentence : arrayList) {
            SentenceParser sentenceParser = new SentenceParser();
            map.put(sentence.toString(), sentenceParser.parse(sentence.toString(), new TextComposite(LEXEME)).getComponents().size());
        }
        this.arrayList = new ArrayList<>(SortByComparator.sortByComparator(map).keySet());
    }
}