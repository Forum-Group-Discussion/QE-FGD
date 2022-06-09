package utils;

import java.util.Random;

public class General {
    Random rand = new Random();
    public String randomEmail(){
        return "forumGroup" + + rand.nextInt(100000) + "@gmail.com";
    }



}
