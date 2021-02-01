package com.gourianova.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class SimpleDto implements Serializable {

    private String text;
}
