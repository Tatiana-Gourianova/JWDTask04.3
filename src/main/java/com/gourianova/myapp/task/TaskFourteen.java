package com.gourianova.myapp.task;

import com.gourianova.texthandler.entity.TextComponent;
import com.gourianova.texthandler.entity.TextComposite;
import com.gourianova.texthandler.service.MarksRemover;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static com.gourianova.texthandler.entity.ComponentType.TEXT;
import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class TaskFourteen {
    private String result;

    public String getResult() {
        return result;
    }

    public TaskFourteen(ArrayList<TextComponent> arrayList) {


        TextComposite textComposite = new TextComposite(TEXT);
        TextComposite letters = new TextComposite(TEXT);
        MarksRemover marksRemover = new MarksRemover();
        for (TextComponent words : arrayList) {
            textComposite.addComponent(words);

            Iterator iterator = words.getComponents().iterator();

            while (iterator.hasNext()) {
                TextComponent lexemeComposite = (TextComponent) iterator.next();
                letters.addComponent(lexemeComposite);
                log.println(lexemeComposite);
            }
        }
        log.println(letters);
        String input = letters.toString().toLowerCase();
        input = marksRemover.remove(input);
        input = input.replaceAll(" ", "");
        input = input.replaceAll("\\\\n", "\n");
        input = input.replaceAll("\n", "");

        Set<String> palindromes = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j <= input.length(); j++) {
                if (new StringBuilder(input.substring(i, j)).reverse().toString().equals(input.substring(i, j))) {


                    palindromes.add(input.substring(i, j));
                }
            }
        }

         String result;
        if (palindromes != null) {
            String max = "";
            for (String palindrome : palindromes) {
                if (palindrome.length() > max.length()) max = palindrome;

            }
            result = max;
        } else result = "None palindromes";
        this.result = result;
    }
}
