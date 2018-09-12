package com.metacube.training;

public class TextEditor {
    private SpellChecker spellChecker1;
    private SpellChecker spellChecker2;

    public TextEditor(SpellChecker spellChecker1) {
        this.spellChecker1 = spellChecker1;
        System.out.println("Inside Constructor");
    }

    public SpellChecker getSpellChecker1() {
        return spellChecker1;
    }

    public SpellChecker getSpellChecker2() {
        return spellChecker2;
    }

    public void setSpellChecker2(SpellChecker spellChecker2) {
        this.spellChecker2 = spellChecker2;
        System.out.println("Inside Setter");
    }

    public void spellCheck() {
        getSpellChecker1().checkSpelling();
        getSpellChecker2().checkSpelling();
    }

}
