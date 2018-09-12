package com.metacube.training;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Text Editor class
 */
public class TextEditor {

    @Autowired
    private SpellChecker spellChecker1;

    @Autowired
    private SpellChecker spellChecker2;

    public TextEditor(SpellChecker spellChecker1) {
        System.out.println("Inside Constructor");
        this.spellChecker1 = spellChecker1;
    }

    public SpellChecker getSpellChecker1() {
        return spellChecker1;
    }

    public void setSpellChecker2(SpellChecker spellChecker2) {
        System.out.println("Inside Setter");
        this.spellChecker2 = spellChecker2;
    }

    public SpellChecker getSpellChecker2() {
        return spellChecker2;
    }

    public void spellCheck() {
        spellChecker1.checkSpelling();
        spellChecker2.checkSpelling();
    }
}