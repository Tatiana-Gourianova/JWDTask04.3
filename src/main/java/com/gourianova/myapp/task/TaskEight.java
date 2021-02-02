package com.gourianova.myapp.task;

import com.gourianova.service.SortByComparator;
import com.gourianova.texthandler.chainparser.SentenceParser;
import com.gourianova.texthandler.entity.TextComponent;
import com.gourianova.texthandler.entity.TextComposite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

import static com.gourianova.texthandler.entity.ComponentType.TEXT;

public class TaskEight {
    private ArrayList<String> result;
    public ArrayList<String> getResult() {
        return result;}

    public TaskEight(ArrayList<TextComponent> arrayList) {
        Iterator<TextComponent> iter = arrayList.iterator();
        SentenceParser sentenceParser;
        sentenceParser = new SentenceParser();




        TreeMap<String, String> map = new TreeMap<>();

        String vowels;
        String partOfWord;
        ArrayList<String> wordsWithVowels = new ArrayList<>();
        while (iter.hasNext()) {
            ArrayList<TextComponent> NextSentence = sentenceParser.parse(iter.next().toString(), new TextComposite(TEXT)).getComponents();

            for (TextComponent words : NextSentence) {
                vowels = "";
                partOfWord = "";
                partOfWord += words.toString();
                boolean isBeginWithVowel=false;

                //TODO: vowels += partOfWord.charAt(0); change for sb.append(vowels);
                while (partOfWord.toLowerCase().matches("^(?i:[aeiouy]).*")) {
                    isBeginWithVowel=true;
                    vowels += partOfWord.charAt(0);
                    partOfWord = partOfWord.substring(1);

                }
                if (isBeginWithVowel) {
                    wordsWithVowels.add(vowels + partOfWord.trim());
                    map.put(partOfWord, vowels);
                } else if (partOfWord.toLowerCase().matches("\\s+(?i:[aeiouy]).*")) {
                    isBeginWithVowel=true;
                    partOfWord = words.toString().toString();
                    //String vowelsRussian = "аоуэиыеёяю";
                    String vowelsEnglish = "aeiouy";

                    while (vowelsEnglish.indexOf(Character.toLowerCase(partOfWord.charAt(0))) != -1) {
                        vowels += partOfWord.charAt(0);
                        partOfWord = partOfWord.substring(1);

                    }
                    if (isBeginWithVowel) {
                        wordsWithVowels.add(vowels + partOfWord.trim());
                        map.put(partOfWord, vowels);
                    }
                }
            }
        }

        ArrayList<String> sorted = new ArrayList<>();

        for (String words : SortByComparator.sortByComparatorS(map).keySet()) {
            String key = words.toString();
            String value = map.get(words).toString();
            sorted.add(value+key);
        }

        this.result=sorted;    }
}
