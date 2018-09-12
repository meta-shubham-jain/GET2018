package com.metacube.training;

public class SpellChecker {
    private String word;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void checkSpelling() {
        System.out.println("CheckSpelling " + getWord());
    }

}
