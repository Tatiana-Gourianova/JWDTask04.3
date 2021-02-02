package com.gourianova.myapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class TextDto implements Serializable {

    private String text;
    private Integer taskNumber;
    private Integer lengthOfWord;
    private String letter;
    private String wordStart;
    private String wordEnd ;


}
