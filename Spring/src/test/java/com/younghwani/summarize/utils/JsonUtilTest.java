package com.younghwani.summarize.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JsonUtilTest {

    @Test
    void main() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Reader reader = new FileReader("/Users/kyh/Desktop/test.json");
        JSONObject jsonObject = (JSONObject) parser.parse(reader);
        JSONArray documents = (JSONArray) jsonObject.get("documents");

        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < documents.size(); i++) {
            ArrayList<String> temp = new ArrayList<>();
            JSONObject document = (JSONObject) documents.get(i);
            // 생성요약
            JSONArray abstractive = (JSONArray) document.get("abstractive");
            String strAbstractive = (String) abstractive.get(0);
            // 원본
            JSONArray jsonText = (JSONArray) document.get("text");
            jsonText = (JSONArray) jsonText.get(0);
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < jsonText.size(); j++) {
                JSONObject text = (JSONObject) jsonText.get(j);
                String sentence = (String) text.get("sentence");
                sb.append(sentence + " ");
            }
            String originalText = sb.toString();

            temp.add(originalText);
            temp.add(strAbstractive);
            result.add(temp);

            String progress = String.format("%.0f", (((i + 1) / (double) documents.size()) * 100));
            System.out.println(progress + "%");
        }

        System.out.println(result);
    }

}