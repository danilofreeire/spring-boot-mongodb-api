package com.social.workshop.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class URL {
    public static final String DECOD_PARAM(String text){
        return URLDecoder.decode(text, StandardCharsets.UTF_8);
    }
}
