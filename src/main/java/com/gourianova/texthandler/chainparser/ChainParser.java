package com.gourianova.texthandler.chainparser;


import com.gourianova.texthandler.entity.TextComposite;

public interface ChainParser {
    TextComposite parse(String from, TextComposite to);
}
