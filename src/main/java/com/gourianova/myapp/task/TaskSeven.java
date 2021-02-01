package com.gourianova.myapp.task;

import com.gourianova.service.SortByComparator;
import com.gourianova.texthandler.entity.TextComponent;
import com.gourianova.texthandler.service.MarksRemover;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TaskSeven {
    private ArrayList<String> result ;//=  new ArrayList<>();
    public ArrayList<String> getResult() {
        return  result;}
    public TaskSeven(ArrayList<TextComponent> arrayList) {
        ArrayList<String> lexems = new ArrayList<>();

        String vowelsEnglish="aeiouy";
        Map< Double,String> map = new HashMap<Double, String >();
        for (
                TextComponent sentenceComponent: arrayList) {
            Iterator iterator = sentenceComponent.getComponents().iterator();
            while (iterator.hasNext()) {
                TextComponent lexemeComposite = (TextComponent) iterator.next();//слова
                int vowelCount=0;
                String wordWithVowel=lexemeComposite.toString();
                for (char vowel: vowelsEnglish.toLowerCase().toCharArray()){
                    if (wordWithVowel.contains(vowel+"")){
                        int i=wordWithVowel.indexOf(vowel);
                        wordWithVowel.substring(i,i+1);
                        vowelCount++;
                    }

                    if (vowelCount>0){ map.put((double)vowelCount/lexemeComposite.toString().length(),lexemeComposite.toString());}
                }

            }
        }

        ArrayList<String> sorted = new ArrayList<>();
        MarksRemover marksRemover=new MarksRemover();

        for (Double numbers : SortByComparator.sortByComparatorD(map).keySet()) {
            String value = map.get(numbers).toString();
            value=marksRemover.remove(value);
            sorted.add(value);

        }

        this.result=sorted;    }

}
