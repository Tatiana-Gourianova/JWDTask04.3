package com.gourianova.myapp.task;

import com.gourianova.service.SortByComparator;
import com.gourianova.texthandler.chainparser.SentenceParser;
import com.gourianova.texthandler.entity.TextComponent;
import com.gourianova.texthandler.entity.TextComposite;
import com.gourianova.texthandler.service.MarksRemover;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import static com.gourianova.texthandler.entity.ComponentType.TEXT;

public class TaskFour {
    private String result;

    public String getResult() {
        return result;
    }

    public TaskFour(ArrayList<TextComponent> arrayList, int lengthOfWord) {

        HashSet<String> differentSentencesWithQuestionSign = new HashSet<>();

        for (TextComponent sentence : arrayList) {
            if (sentence.toString().contains("?")) {

                differentSentencesWithQuestionSign.add(sentence.toString());
            }
        }

        SentenceParser sentenceParser = new SentenceParser();
        HashMap<String, Integer> differentWords = new HashMap<>();

        for (Iterator<String> iter = differentSentencesWithQuestionSign.iterator(); iter.hasNext(); ) {
            String st = iter.next().toString();

            ArrayList<TextComponent> wordsInSentence = new ArrayList<>();

            wordsInSentence = sentenceParser.parse(st, new TextComposite(TEXT)).getComponents();

            for (TextComponent words : wordsInSentence) {

                if (words.toString().trim().length() == lengthOfWord+1) {
                    differentWords.put(words.toString().trim(), words.toString().length());
                }

            }

        }
        String result = SortByComparator.sortByComparator(differentWords).keySet().toString();
        MarksRemover lexemeRemover = new MarksRemover();
        result = lexemeRemover.remove(result);
        this.result = result;
    }
}
