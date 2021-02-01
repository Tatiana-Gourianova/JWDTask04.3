package com.gourianova.texthandler.service;

import com.gourianova.texthandler.chainparser.LexemeParser;
import com.gourianova.texthandler.entity.TextComponent;
import com.gourianova.texthandler.entity.TextComposite;



public class MarksRemover {
    private String result=" ";

    public String getResult() {
        return result;
    }
    public MarksRemover(){

    }

    public String remove(TextComposite textComposite, char  symbolToRemove) {

      //  LexemeParser lexemeParser=new LexemeParser();
        //TextComposite textComposite1=lexemeParser.parse(textComposite.toString(),  new TextComposite(LEXEME));

        String result=textComposite.toString();

        result = result.replace(symbolToRemove, ' ');


        return result; }
        public String remove(String st){
        String result;
          result=st.replace("?","");
            result=result.replace(".","");
            result=result.replace(",","");
            result=result.replace("!","");
            result=result.replace(":","");
            result=result.replace("]","");
            result=result.replace("[","");
            result=result.replace("\u0013\u0010","");

          //  result=result.replace("~","");

        return result;
        }
}
