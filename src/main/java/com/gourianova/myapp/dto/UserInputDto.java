package com.gourianova.myapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
public class UserInputDto implements Serializable {

    private Integer taskNumber;
    private Integer lengthOfWord;
    private String letter;
    private String wordStart;
    private String wordEnd ;

}
