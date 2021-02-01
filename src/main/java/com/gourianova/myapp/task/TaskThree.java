package com.gourianova.myapp.task;

import com.gourianova.texthandler.chainparser.SentenceParser;
import com.gourianova.texthandler.entity.TextComponent;
import com.gourianova.texthandler.entity.TextComposite;
import com.gourianova.texthandler.service.MarksRemover;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import static com.gourianova.texthandler.entity.ComponentType.TEXT;

public class TaskThree {
    private static String result;

    public static String getResult() {

        return result;
    }

    public TaskThree(ArrayList<TextComponent> arrayList) {
        Iterator<TextComponent> iter = arrayList.iterator();
        SentenceParser sentenceParser;
        sentenceParser = new SentenceParser();

        ArrayList<TextComponent> FirstSentence = new ArrayList<>();
        if (iter.hasNext()) {
            FirstSentence = sentenceParser.parse(iter.next().toString(), new TextComposite(TEXT)).getComponents();
        }

        HashSet<TextComponent> differentWordsInFirstSentence = new HashSet<>();
        for (TextComponent words : FirstSentence) {
            differentWordsInFirstSentence.add(words);
        }

        HashSet<String> differentWordsInOtherSentences = new HashSet<>();
        while (iter.hasNext()) {
            ArrayList<TextComponent> NextSentence = sentenceParser.parse(iter.next().toString(), new TextComposite(TEXT)).getComponents();
            ArrayList<String> wordsInNextSentence = new ArrayList<>();

            for (TextComponent words : NextSentence) {
                differentWordsInOtherSentences.add(words.toString());
            }
        }

        for (String words : differentWordsInOtherSentences) {

            for (Iterator<TextComponent> iter2 = differentWordsInFirstSentence.iterator(); iter2.hasNext(); ) {

                if (iter2.next().toString().contains(words)) {
                    iter2.remove();
                    break;
                }

            }

        }

        ArrayList<String> resultArrayList = new ArrayList<String>();
        TextComposite differentWordsInSentence = new TextComposite(TEXT);
        for (TextComponent words : differentWordsInFirstSentence) {
            differentWordsInSentence.addComponent(words);
        }


        MarksRemover marksRemover = new MarksRemover();
        String result = marksRemover.remove(differentWordsInSentence.toString());

        this.result = result;

    }
}
