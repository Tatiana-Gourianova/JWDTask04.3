package com.gourianova.myapp.task;

import com.gourianova.texthandler.chainparser.SentenceParser;
import com.gourianova.texthandler.entity.TextComponent;
import com.gourianova.texthandler.entity.TextComposite;
import com.gourianova.texthandler.service.MarksRemover;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Iterator;

import static com.gourianova.texthandler.entity.ComponentType.TEXT;

@Slf4j
public class TaskTwelve {

    private String result;

    public String getResult() {
        return result;
    }

    public TaskTwelve(ArrayList<TextComponent> arrayList, int lengthOfWord) {

        Iterator<TextComponent> iter = arrayList.iterator();
        SentenceParser sentenceParser = new SentenceParser();
        TextComposite textWithoutWords = new TextComposite(TEXT);
        while (iter.hasNext()) {
            ArrayList<TextComponent> NextSentence = sentenceParser.parse(iter.next().toString(), new TextComposite(TEXT)).getComponents();

            String consonantsEnglish = "qwrtplkjhgfdszxcvbnm";

            for (TextComponent words : NextSentence) {

                String wordStr = words.toString().trim();
                wordStr = new MarksRemover().remove(wordStr);
                if (wordStr.length() == lengthOfWord) {

                    String firstLetter = words.toString().toLowerCase().charAt(0) + "";
                    if (consonantsEnglish.contains(firstLetter)) {
                        continue;
                    }
                }
                textWithoutWords.addComponent(words);
            }
        }
        String result = textWithoutWords.toString();

        this.result = result;
    }
}
