package ru.geekbrains;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Task3 
{
 public static void main(String[] args){
    String path="/home/vladimir/Документы/Java/BasicJava/HomeWork2/Task/src/main/java/ru/geekbrains/data.json";
    try{
        JSONArray jsonObject=FileReaderJSON(path);
        ParseData(jsonObject);
        }
    catch(NullPointerException e){
        System.out.println("Файл не найден");
        }
    }

static JSONArray FileReaderJSON(String path){
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader(path)){
        JSONArray jsonObject = (JSONArray) parser.parse(reader);
        return jsonObject;
    }
    catch (IOException | ParseException ex) {
        return null;
        }
    }
static void ParseData(JSONArray jsonObject){
        StringBuilder builder=new StringBuilder();
        for (int i = 0; i < jsonObject.size(); i++) {
            JSONObject str = (JSONObject) jsonObject.get(i);
            builder.append("Студент "+str.get("фамилия")).
                    append(" получил "+str.get("оценка")).
                    append(" по предмету "+str.get("предмет").
                    toString().toLowerCase());
            System.out.println(builder);
            builder.setLength(0);
        }
    }
}