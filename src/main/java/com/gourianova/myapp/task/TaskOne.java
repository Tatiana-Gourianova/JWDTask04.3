package com.gourianova.myapp.task;

import com.gourianova.service.SortByComparator;
import com.gourianova.texthandler.chainparser.SentenceParser;
import com.gourianova.texthandler.entity.TextComponent;
import com.gourianova.texthandler.entity.TextComposite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static com.gourianova.texthandler.entity.ComponentType.TEXT;

public class TaskOne {
    public String result;

    public String getResult() {
        return result;
    }

    public TaskOne(ArrayList<TextComponent> arrayList) {

        HashMap<String, Integer> sentencesWithRepeatedWords = new HashMap<>();
        HashSet<TextComponent> differentSentences = new HashSet<>(arrayList);
        SentenceParser sentenceParser = new SentenceParser();

        for (TextComponent sentence : differentSentences) {
            ArrayList<TextComponent> wordsInSentence;
            HashSet<String> differentWordsInSentence = new HashSet<>();
            wordsInSentence = sentenceParser.parse(sentence.toString(), new TextComposite(TEXT)).getComponents();
            for (TextComponent words : wordsInSentence) {
                differentWordsInSentence.add(words.toString().trim());
            }

            if (differentWordsInSentence.size() < wordsInSentence.size()) {
                TextComposite sentenceWithRepeatedWords = new TextComposite(TEXT);
                for (TextComponent words : wordsInSentence) {
                    sentenceWithRepeatedWords.addComponent(words);
                }
                sentencesWithRepeatedWords.put(sentenceWithRepeatedWords.toString(), wordsInSentence.size());
            }

        }
        int i = sentencesWithRepeatedWords.size() - 1;
        String result = SortByComparator.sortByComparator(sentencesWithRepeatedWords).keySet().toArray()[i].toString();
        result = result.replace("[", "");
        result = result.replace("]", "");
        this.result = result;
    }
}
