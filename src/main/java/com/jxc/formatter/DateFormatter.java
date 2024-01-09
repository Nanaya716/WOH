package com.jxc.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatter implements Formatter<Date> {
    private SimpleDateFormat sdf;

    public DateFormatter(String pattern) {
        this.sdf = new SimpleDateFormat(pattern);
        sdf.setLenient(false);
    }

    @Override
    public Date parse(String s, Locale locale) throws IllegalArgumentException {
        try {
            return this.sdf.parse(s);
        } catch (ParseException e) {
            throw new IllegalArgumentException("invalid date format. Please use this pattern\"" + this.sdf.toPattern() + "\"");
        }
    }

    @Override
    public String print(Date date, Locale locale) {
        return this.sdf.format(date);
    }
}