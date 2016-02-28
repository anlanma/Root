package com.tl.demos.java.exception;

/**
 * Created by tanglin on 16/2/28.
 */
public class NullPointException {

    public static void main(String[] args) {
        Cards cards = null;
        try {
            cards.play();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("catch null");
    }

}

class Cards{
    public void play(){
        System.out.println("Play cards");
    }
}
