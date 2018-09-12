package com.metacube.training;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {
    private SpellChecker spellChecker1;

    @Autowired
    public TextEditor(SpellChecker spellChecker1) {
        this.spellChecker1 = spellChecker1;
    }

    public void spellCheck() {
        spellChecker1.checkSpelling();
    }
}