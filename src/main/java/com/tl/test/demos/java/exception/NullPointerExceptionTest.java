package com.tl.test.demos.java.exception;

/**
 * Created by tanglin on 16/2/28.
 */
public class NullPointerExceptionTest {

    public static void main(String[] args) {
        Cards cards = new Cards();
        try {
            cards.play2();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("catch null");
    }

}
class Cards{
    public void play(){
        throw new NullPointerException();
    }
    public void play2(){
        play();
    }
}
