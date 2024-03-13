package com.example;

public class Main{
    static public void main(String[] args) {
        MyLog log = new MyLog("src\\main\\java\\com\\example\\config.txt");
        log.WriteLog("Hahahahah");
        log.ReadFile();
    } 
}


