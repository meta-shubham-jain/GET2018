package com.metacube.training;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {

    @Autowired
    private SpellChecker spellChecker;

    @Autowired
    private String string;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public SpellChecker getSpellChecker() {
        return spellChecker;
    }

    public void setSpellChecker(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }

    public void spellCheck() {
        getSpellChecker().checkSpelling();
        System.out.println(getString());
    }

}
