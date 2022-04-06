package com.mrisa.command.generic;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public interface GenericCode {

    static String generateCode() {
        List<String> letter = Arrays.asList("AE", "HJ", "ML", "LO", "QW", "KN", "PZ", "FC", "ZZ", "JK", "BTH", "AE", "HJ", "KL", "LO", "QW", "KN", "TH", "FC", "ZZ", "JK", "PH", "JAE", "HJ", "ML", "LO", "YW", "KN", "PZ", "FC", "MZ", "JK", "TH",
                "LE", "AJ", "GL", "LO", "OW", "KN", "AZ", "FC", "ZZ", "JK", "BTH", "MAE", "HJ", "KL", "LO", "QW", "KN", "TH", "FC", "ZZ", "JK", "PH", "JAE", "HJ", "ML", "LO", "YW", "KN", "PZ", "FC", "MZ", "JK", "TH");
        int number = Math.abs(LocalTime.now().hashCode());
        Collections.shuffle(letter);
        String l1 = letter.get(LocalTime.now().getSecond());
        Collections.shuffle(letter);
        String l2 = letter.get(LocalTime.now().getSecond());
        int code = LocalTime.now().getSecond();
        int code2 =(code > 2)? code/2 : code + 2;

        return  number + l1 + LocalTime.now().getNano() + l2;
    }
}
