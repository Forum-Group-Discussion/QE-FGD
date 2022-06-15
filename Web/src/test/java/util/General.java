package util;

import java.util.Random;

    public class General {
    Random rand = new Random();

    public String randomUsername(){
        return "tester" + + rand.nextInt(1000);
    }

    public String randomEmail(){
        return "kelompokcaps" + + rand.nextInt(1000) + "@gmail.com";
    }
}

