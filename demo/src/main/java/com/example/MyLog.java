package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class MyLog {
    private String path;
    public MyLog(String path){
        this.path = path;
    }
    public void WriteLog(String mes){    
        try (FileWriter fw = new FileWriter(path, true); 
            BufferedWriter br = new BufferedWriter(fw)
        ) {
            Date date = new Date();
            br.newLine();
            fw.write(date +": "+ mes);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void ReadFile(){
        try {
            FileReader fis = new FileReader(this.path);
            BufferedReader reader = new BufferedReader(fis);
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
