package com.gourianova.myapp.service;

import com.gourianova.myapp.dto.TextDto;
import com.gourianova.myapp.task.*;
import com.gourianova.texthandler.entity.TextComponent;
import com.gourianova.texthandler.service.MarksRemover;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
@Slf4j
public class TaskHandlerService {

    public static void handleTaskOne(TextDto dto, ArrayList<TextComponent> arrayList) {
        TaskOne taskOne = new TaskOne(arrayList);
        String textResult = "";
        String result = taskOne.getResult();

        if (result != null) {
            textResult = textResult.concat("\n\n\t SENTENCE WITH THE LARGEST AMOUNT OF REAPEATED WORDS:\n")
                    .concat("\n\t ****************************************************\n")
                    .concat(" \n\t" + result + "\n\n");
        } else {
            textResult = "\n\t NONE SENTENCES WITH REPEATED WORDS \n";
        }
        dto.setText(textResult);
    }

    public static void handleTaskTwo(TextDto dto, ArrayList<TextComponent> arrayList) {
        TaskTwo task = new TaskTwo(arrayList);
        String textResult = "";
        ArrayList<String> result = task.getArrayList();
        if (!result.isEmpty()) {
            textResult = textResult.concat("\n \t SENTENCES IN ORDER:\n")
                    .concat("\n\t  ******************\n");
            for (String sentence : result) {
                textResult = textResult.concat("\n\t" + sentence + "\n");
            }
        } else {
            textResult = "\n\t NONE SENTENCES WITH REPEATED WORDS \n";
        }
        dto.setText(textResult);
    }

    public static void handleTaskThree(TextDto dto, ArrayList<TextComponent> arrayList) {
        TaskThree task = new TaskThree(arrayList);
        String textResult = "";
        String result = task.getResult();
        if (!result.isEmpty()) {
            textResult = textResult.concat("\n \tDIFFERENT WORDS THAT NOT REPEATED AT ANOTHER SENTENCES\n")
                    .concat("\n\t ****************************************************\n")
                    .concat("\n\t" + result + "\n");//different words
        } else {

            textResult = "\n\t ALL WORDS REPEATED AT ANOTHER SENTENCES \n\n";

        }
        dto.setText(textResult);
    }

    public static void handleTaskFour(TextDto dto, ArrayList<TextComponent> arrayList) {
        //TODO: user input rewrite
        int lengthOfWord = 5;
        TaskFour task = new TaskFour(arrayList, lengthOfWord);
        String result = task.getResult();
        String textResult = "";
        if (!result.isEmpty()) {
            textResult = textResult.concat("\n\n\t WORDS IN ORDER WITH LENGTH " + lengthOfWord + ":\n" + result + "\n\n");

        } else {
            textResult = "\n\t NONE WORDS OF SUCH A LENGTH \n\n";

        }
        dto.setText(textResult);
    }

    public static void handleTaskFive(TextDto dto, ArrayList<TextComponent> arrayList) {
        TaskFive task = new TaskFive(arrayList);
        String textResult = "";
        String result = task.getResult();
        if (!result.isEmpty()) {
            textResult = textResult.concat("\n\n\t REVERSED SENTENCES:\n")
                    .concat("\n ******************\n")
                    .concat("\n" + result + "\n");

        } else {
            textResult = "\n\t NONE SENTENCE TO REVERSE \n\n";
        }
        dto.setText(textResult);
    }

    public static void handleTaskSix(TextDto dto, ArrayList<TextComponent> arrayList) {
        TaskSix task = new TaskSix(arrayList);
        String textResult = "";
        ArrayList<String> lexems = task.getLexems();
        if (!lexems.isEmpty()) {
            textResult = textResult.concat("\n\n WORD AT ALPHABTICAL ORDER:\n");

            for (String words : lexems) {
                textResult = textResult.concat("\n\n" + words + "\n");

            }
        } else {
            textResult = "NONE";
        }
        dto.setText(textResult);
    }

    public static void handleTaskSeven(TextDto dto, ArrayList<TextComponent> arrayList) {
        TaskSeven task = new TaskSeven(arrayList);

        ArrayList<String> sorted = new ArrayList<>();
        sorted = task.getResult();
        String textResult = "";
        if (!sorted.isEmpty()) {
            for (String words : sorted) {
                textResult = textResult.concat("\n\n" + words + "\t");
            }
        } else {
            textResult = "NONE";
        }
        dto.setText(textResult);

    }

    public static void handleTaskEight(TextDto dto, ArrayList<TextComponent> arrayList) {

        TaskEight task = new TaskEight(arrayList);
        ArrayList<String> sorted = new ArrayList<>();
        sorted = task.getResult();
        String textResult = "";
        MarksRemover marksRemover = new MarksRemover();
        if (!sorted.isEmpty()) {
            for (String wordsWithBeginVowels : sorted) {
                textResult = textResult.concat("\n\n" + marksRemover.remove(wordsWithBeginVowels) + "\t");
            }
        } else {
            textResult = "NONE";
        }
        dto.setText(textResult);

    }
    public static void handleTaskNine(TextDto dto, ArrayList<TextComponent> arrayList) {
        //TODO: user input rewrite
        //TODO: alphabetical order
       String letter="a";
        TaskNine task = new TaskNine(arrayList, letter);
        String result = task.getResult();
        String textResult = "";
        if (!result.isEmpty()) {
            textResult = textResult.concat("\n\n\t WORDS IN ORDER OF AMOUNT OF " + letter + ":\n" + result + "\n\n");

        } else {
            textResult = "\n\t NONE WORDS WITH "+letter+" \n\n";

        }
        dto.setText(textResult);
    }
    public static void handleTaskTen(TextDto dto, ArrayList<TextComponent> arrayList) {
        //TODO: user input rewrite
        ArrayList<String> list=new ArrayList<String>(Arrays.asList(new String[]{"Dad", "Madam", "Adam", "pull"}));
        TaskTen task = new TaskTen(arrayList, list);
        String result = task.getResult();
        String textResult = "";
        if (!result.isEmpty()) {
            textResult = textResult.concat("\n\n\t WORDS IN REVERSE ORDER OF AMOUNT\n" +  result + "\n\n");

        } else {
            textResult = "\n\t NONE WORDS IN TEXT  \n\n";

        }
        dto.setText(textResult);
    }
    public static void handleTaskEleven(TextDto dto, ArrayList<TextComponent> arrayList) {
        //TODO: user input rewrite
        //TODO: redo
        String wordStart = "Adam";
        String wordEnd = "pull";
        TaskEleven task = new TaskEleven(arrayList,  wordStart , wordEnd);
        String result = task.getResult();
        String textResult = "";
        if (!result.isEmpty()) {
            textResult = textResult.concat("\n\n\t SENTENCE WITHOUT MAXIMAL SUBSTRINGS BEGIN WITH " + wordStart+", END WITH "+ wordEnd+"\n"+ result + "\n\n");

        } else {
            textResult = "\n\t NONE WORDS IN TEXT  \n\n";

        }
        dto.setText(textResult);
    }
    public static void handleTaskTwelve(TextDto dto, ArrayList<TextComponent> arrayList) {
        //TODO: user input rewrite
        int lengthOfWord = 5;
        TaskTwelve task = new TaskTwelve(arrayList, lengthOfWord);
        String result = task.getResult();
        String textResult = "";
        if (!result.isEmpty()) {
            textResult = textResult.concat("\n\n\t TEXT WITHOUT WORDS" + lengthOfWord + "BEGINS ON CONSTANT:\n" + result + "\n\n");

        } else {
            textResult = "\n\t NONE WORDS OF SUCH A LENGTH \n\n";

        }
        dto.setText(textResult);
    }
    public static void handleTaskThirteen(TextDto dto, ArrayList<TextComponent> arrayList) {
        //TODO: user input rewrite
        //TODO: alphabetical order
        String letter="a";
        TaskNine task = new TaskNine(arrayList, letter);
        String result = task.getResult();
        String textResult = "";
        if (!result.isEmpty()) {
            textResult = textResult.concat("\n\n\t WORDS IN ORDER OF AMOUNT OF " + letter + ":\n" + result + "\n\n");

        } else {
            textResult = "\n\t NONE WORDS WITH "+letter+" \n\n";

        }
        dto.setText(textResult);
    }
    public static void handleTaskFourteen(TextDto dto, ArrayList<TextComponent> arrayList) {

        TaskFourteen task = new TaskFourteen(arrayList);
        String largestPalindrom = task.getResult();
        String textResult = "";
        if (!largestPalindrom.isEmpty()) {
            textResult = textResult.concat("\n\n The Largest palindrom is:  \n" + largestPalindrom + "\n");

        } else {
            textResult = "NONE";
        }
        dto.setText(textResult);

    }

}
