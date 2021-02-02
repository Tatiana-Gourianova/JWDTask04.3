package com.gourianova.myapp.service;


import com.gourianova.myapp.dto.TextDto;
import com.gourianova.texthandler.chainparser.ParagraphParser;
import com.gourianova.texthandler.entity.TextComponent;
import com.gourianova.texthandler.entity.TextComposite;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

import static com.gourianova.myapp.service.TaskHandlerService.*;
import static com.gourianova.texthandler.entity.ComponentType.LEXEME;
@Slf4j
public class TextHandlerService {

    public static void handle(TextDto dto) {
        ParagraphParser paragraphParser = new ParagraphParser();
        ArrayList<TextComponent> arrayList = paragraphParser.parse(dto.getText(), new TextComposite(LEXEME)).getComponents();

        switch (dto.getTaskNumber()) {
            case (1):
                handleTaskOne(dto, arrayList);
                break;
            case (2):
                handleTaskTwo(dto, arrayList);
                break;
            case (3):
                handleTaskThree(dto, arrayList);
                break;
            case (4):
                handleTaskFour(dto, arrayList);
                break;
            case (5):
                handleTaskFive(dto, arrayList);
                break;
            case (6):
                handleTaskSix(dto, arrayList);
                break;
            case (7):
                handleTaskSeven(dto, arrayList);
                break;
            case (8):
                handleTaskEight(dto, arrayList);
                break;
            case (9):
                handleTaskNine(dto, arrayList);
                break;
            case (10):
                handleTaskTen(dto, arrayList);
                break;
            case (11):
                handleTaskEleven(dto, arrayList);
                break;
            case (12):
                handleTaskTwelve(dto, arrayList);
                break;
            case (13):
                handleTaskThirteen(dto, arrayList);
                break;
            case (14):
                handleTaskFourteen(dto, arrayList);
                break;
            case (15):
                handleTaskFifteen(dto, arrayList);

            default:
                //TODO: to correct
                //TODO: to test all tasks
                log.info("Please, don't use tasks 15,16; tasks 4, 9-13 are under construction. Try type a number 1-3, 5-8 or 14");

            break;
        }
    }

}
