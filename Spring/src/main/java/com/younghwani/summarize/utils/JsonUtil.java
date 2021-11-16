package com.younghwani.summarize.utils;

import lombok.experimental.UtilityClass;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;

@UtilityClass
public class JsonUtil {
    public ArrayList<ArrayList<String>> ReadJsonFile(String path) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Reader reader = new FileReader(path);
        JSONObject jsonObject = (JSONObject) parser.parse(reader);
        JSONArray documents = (JSONArray) jsonObject.get("documents");

        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        System.out.println("Read Start!!!!");
        for (int i=0; i < documents.size(); i++) {
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
        System.out.println("Read End!!!!");

        return result;
    }

    public void writeTsvFile(String path, ArrayList<ArrayList<String>> docs) {
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter(path, true));

            for (ArrayList<String> doc : docs) {
                String originalText = (String) doc.get(0);
                String abstractiveText = (String) doc.get(1);
                fw.write(originalText + "\t" + abstractiveText);
                fw.newLine();
            }
            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, ParseException {
        ArrayList<ArrayList<String>> trains = ReadJsonFile("/Users/kyh/Desktop/law/train_original.json");
        writeTsvFile("/Users/kyh/Desktop/law/train.tsv", trains);

        ArrayList<ArrayList<String>> valids = ReadJsonFile("/Users/kyh/Desktop/law/valid_original.json");
        writeTsvFile("/Users/kyh/Desktop/law/valid.tsv", valids);
    }
}
