package com.gourianova.texthandler.service;

import com.gourianova.texthandler.entity.TextComponent;
import com.gourianova.texthandler.entity.TextComposite;

import java.util.Iterator;


public class LexemeRemover {
    public void remove(TextComposite textComposite, int lexemeLength, char firstSymbol) {
        for (TextComponent paragraphComponent: textComposite.getComponents()) {
            for (TextComponent sentenceComponent: paragraphComponent.getComponents()) {
                Iterator iterator = sentenceComponent.getComponents().iterator();
                while (iterator.hasNext()){
                    TextComponent lexemeComposite = (TextComponent) iterator.next();
                    if (lexemeComposite.toString().length() == lexemeLength && lexemeComposite.toString().trim().charAt(0) == firstSymbol) {
                        iterator.remove();
                    }
                }
            }
        }
    }
}
