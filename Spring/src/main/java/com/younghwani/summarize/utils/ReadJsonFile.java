package com.younghwani.summarize.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadJsonFile {
    public static void main(String[] args) throws IOException, ParseException {

        JSONParser parser = new JSONParser();

        Reader reader = new FileReader("/Users/kyh/Desktop/test.json");
        JSONObject jsonObject = (JSONObject) parser.parse(reader);

        JSONArray documents = (JSONArray) jsonObject.get("documents");

        for (int i=0; i < documents.size(); i++) {
            JSONObject document = (JSONObject) documents.get(i);
//            System.out.println(document);

            // 생성요약
            JSONArray abstractive = (JSONArray) document.get("abstractive");
            String strAbstractive = (String) abstractive.get(0);
//            System.out.println(strAbstractive);

            // 원본
            JSONArray jsonText = (JSONArray) document.get("text");
            jsonText = (JSONArray) jsonText.get(0);
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < jsonText.size(); j++) {
                JSONObject text = (JSONObject) jsonText.get(j);
                String sentence = (String) text.get("sentence");
                sb.append(sentence + " ");
//                System.out.println(sentence);
            }
            String originalText = sb.toString();
//            System.out.println(originalText);
        }
    }
}
