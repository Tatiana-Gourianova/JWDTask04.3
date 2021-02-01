package com.gourianova.myapp.task;

import com.gourianova.service.SortByComparator;
import com.gourianova.texthandler.chainparser.SentenceParser;
import com.gourianova.texthandler.entity.TextComponent;
import com.gourianova.texthandler.entity.TextComposite;
import com.gourianova.texthandler.service.MarksRemover;

import java.util.*;
import java.util.stream.Collectors;

import static com.gourianova.texthandler.entity.ComponentType.TEXT;

public class TaskTen {
    private String result;

    public String getResult() {
        return result;
    }

    public TaskTen(ArrayList<TextComponent> arrayList, ArrayList<String> list) {

        Iterator<TextComponent> iter = arrayList.iterator();
        SentenceParser sentenceParser;//разбиваем на слова
        sentenceParser = new SentenceParser();
        Map<String, Integer> map = new HashMap<>();
        int count[] = new int[list.size()];
        while (iter.hasNext()) {

            ArrayList<TextComponent> NextSentence = sentenceParser.parse(iter.next().toString(), new TextComposite(TEXT)).getComponents();
            int i = 0;
            for (String words2 : list) {


                for (TextComponent words : NextSentence) {
                    int j = 0;
                    String tmpStr = new MarksRemover().remove(words.toString());
                    if (tmpStr.trim().toLowerCase().contains(words2.trim().toLowerCase()) && (words2.trim().toLowerCase().contains(tmpStr.trim().toLowerCase()))) {
                        j++;
                    }
                    count[i] += j;
                }


                i++;
            }


        }

        int i = 0;
        for (String words2 : list) {
            map.put(words2.toString(), count[i]);
            i++;
        }
        String result = SortByComparator.sortByComparator(map).keySet().toString();
        result = new MarksRemover().remove(result);

        List<String> sorted = Arrays.stream(result.split("\\s+")).collect(Collectors.toList());
        Collections.reverse(sorted);

        this.result = new MarksRemover().remove(sorted.toString());
    }
}
