package com.gourianova.myapp.task;

import com.gourianova.texthandler.chainparser.SentenceParser;
import com.gourianova.texthandler.entity.TextComponent;
import com.gourianova.texthandler.entity.TextComposite;
import com.gourianova.texthandler.service.MarksRemover;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static com.gourianova.texthandler.entity.ComponentType.TEXT;

public class TaskEleven {
    private String result;

    public String getResult() {
        return result;
    }

    public TaskEleven(ArrayList<TextComponent> arrayList, String wordStart, String wordEnd) {


        Iterator<TextComponent> iter = arrayList.iterator();
        SentenceParser sentenceParser;
        sentenceParser = new SentenceParser();
        Set<String> set = new HashSet<>();

        while (iter.hasNext()) {

            ArrayList<TextComponent> NextSentence = sentenceParser.parse(iter.next().toString(), new TextComposite(TEXT)).getComponents();

            String str = NextSentence.toString();

            int start = str.toLowerCase().indexOf(wordStart.toLowerCase());
            int end = str.toLowerCase().lastIndexOf(wordEnd.toLowerCase());
            String str2 = str.substring(start, end);

            str = str.replace(str2, "");
            set.add(str);


        }
        this.result = new MarksRemover().remove(set.toString());
    }
}