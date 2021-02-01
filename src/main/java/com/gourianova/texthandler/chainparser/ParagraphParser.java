package com.gourianova.texthandler.chainparser;

import com.gourianova.texthandler.entity.ComponentType;
import com.gourianova.texthandler.entity.TextComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ParagraphParser implements ChainParser {
    private final String PARAGRAPH_TO_SENTENCE = "\\s*[^.?!]+[.?!]";
    private ChainParser parser = new SentenceParser();

    @Override
    public TextComposite parse(String paragraph, TextComposite paragraphComposite) {
        Pattern pattern = Pattern.compile(PARAGRAPH_TO_SENTENCE);
        Matcher matcher = pattern.matcher(paragraph);
        while (matcher.find()) {
            String sentence = matcher.group();
            TextComposite sentenceComposite = new TextComposite(ComponentType.SENTENCE);
            parser.parse(sentence, sentenceComposite);
            paragraphComposite.addComponent(sentenceComposite);
        }
        return paragraphComposite;
    }
}
