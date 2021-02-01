package com.gourianova.myapp.task;

import com.gourianova.service.SortByComparator;
import com.gourianova.texthandler.chainparser.SentenceParser;
import com.gourianova.texthandler.entity.TextComponent;
import com.gourianova.texthandler.entity.TextComposite;
import com.gourianova.texthandler.service.MarksRemover;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static com.gourianova.texthandler.entity.ComponentType.TEXT;

public class TaskNine {

    private String result;

    public String getResult() {
        return result;}

    public TaskNine(ArrayList<TextComponent> arrayList, String letter) {
    String letterTask9=letter;
    Iterator<TextComponent> iter = arrayList.iterator();
    SentenceParser sentenceParser;
    sentenceParser = new SentenceParser();


    Map<String,Integer> map=new HashMap<>();

                                while (iter.hasNext()) {
        ArrayList<TextComponent> NextSentence = sentenceParser.parse(iter.next().toString(), new TextComposite(TEXT)).getComponents();

        int count;
        for (TextComponent words : NextSentence) {
               if(words.toString().contains(letterTask9)) {
                String[] mas=words.toString().split(letterTask9);
                map.put(words.toString(),mas.length);}
        }
    }

    String result= SortByComparator.sortByComparator(map).keySet().toString();
    result=new MarksRemover().remove(result);
    this.result=result;
    }

}
