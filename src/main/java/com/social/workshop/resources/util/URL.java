package com.social.workshop.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class URL {
    public static final String DECOD_PARAM(String text){
        return URLDecoder.decode(text, StandardCharsets.UTF_8);
    }
    public static final LocalDate CONVERT_DATE(String text, LocalDate dateDefault){
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("yyyy-MM-dd").withLocale(Locale.of("GMT"));
        try {
            return LocalDate.parse(text, fmt1);
        }catch (DateTimeParseException e){
            return dateDefault;
        }



    }
}
