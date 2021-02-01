package com.gourianova.texthandler.chainparser;


import com.gourianova.texthandler.entity.ComponentType;
import com.gourianova.texthandler.entity.TextComposite;
import com.gourianova.texthandler.interpreter.RPNCalculator;
import com.gourianova.texthandler.interpreter.RPNConverter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements ChainParser {
    private final String SENTENCE_TO_MATH = "\\s?([\\d-+*/(])+([\\d-+*/()ij \\n])+([\\d-+*/)ij])+";
    private final String SENTENCE_TO_LEXEME = "\\s*'?[a-zA-Z-]+[',;:\\-.?!]*\\d?";
    private final int i = 4;
    private final int j = 5;
    private ChainParser parser = new LexemeParser();
    private RPNConverter converter = new RPNConverter();

    @Override
    public TextComposite parse(String sentence, TextComposite sentenceComposite) {
        Pattern pattern = Pattern.compile(SENTENCE_TO_MATH + "|" + SENTENCE_TO_LEXEME);
        Matcher matcher = pattern.matcher(sentence);
        while (matcher.find()) {
            String lexemeString = matcher.group();
            if (lexemeString.matches(SENTENCE_TO_MATH)) {
                RPNCalculator calculator = new RPNCalculator(converter.convert(lexemeString.trim(), i, j));
                String math = calculator.calculate().toString();
                TextComposite lexemeComposite = new TextComposite(ComponentType.MATH);
                parser.parse(math, lexemeComposite);
                sentenceComposite.addComponent(lexemeComposite);
            } else if (lexemeString.matches(SENTENCE_TO_LEXEME)) {
                TextComposite lexemeComposite = new TextComposite(ComponentType.LEXEME);
                parser.parse(lexemeString, lexemeComposite);
                sentenceComposite.addComponent(lexemeComposite);
            }
        }
        return sentenceComposite;
    }
}
