package com.mrisa.command.model;


import com.mrisa.command.generic.MaplenuGeneric;

public class Category extends MaplenuGeneric {
    public Category(String wording) {
        super(wording);
    }

    public Category(String code, String wording) {
        super(code, wording);
    }
}
