package com.mrisa.command.generic;

public abstract class MaplenuGeneric {
    private String code;
    private String wording;

    public MaplenuGeneric(String wording) {
        this.code = GenericCode.generateCode();
        this.wording = wording;
    }

    public MaplenuGeneric(String code, String wording) {
        this.code = code;
        this.wording = wording;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getWording() {
        return wording;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }
}
