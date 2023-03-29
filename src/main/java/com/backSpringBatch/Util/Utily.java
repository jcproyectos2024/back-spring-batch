package com.backSpringBatch.Util;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
@Component
public class Utily {



    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd h:mm");
    public static SimpleDateFormat sdfResult = new SimpleDateFormat("HH:mm:ss");
    public static SimpleDateFormat sdfResultMinutos = new SimpleDateFormat("m");

    public  void main(String[] args) throws ParseException {
        Date difference = getDifferenceBetwenDates(sdf.parse("2018-11-01 9:31"), sdf.parse("2018-11-01 9:33"));
        System.out.println(sdfResult.format(difference)); //00:02:00
        System.out.println(sdfResultMinutos.format(difference) + " Minutos"); //2 Minutos

        Date difference2 = getDifferenceBetwenDates(sdf.parse("2018-11-01 9:31"), sdf.parse("2018-11-01 11:28"));

        System.out.println(sdfResult.format(difference2)); //01:57:00
        System.out.println(sdfResultMinutos.format(difference2) + " Minutos"); //57 Minutos
    }
    public Date getDifferenceBetwenDates (Date dateInicio, Date dateFinal) {

        long milliseconds = dateFinal.getTime() - dateInicio.getTime();
        int seconds = (int) (milliseconds / 1000) % 60;
        int minutes = (int) ((milliseconds / (1000 * 60)) % 60);
        int hours = (int) ((milliseconds / (1000 * 60 * 60)) % 24);
        Calendar c = Calendar.getInstance();
        c.set(Calendar.SECOND, seconds);
        c.set(Calendar.MINUTE, minutes);
        c.set(Calendar.HOUR_OF_DAY, hours);
        return c.getTime();
    }


    public String getHourNow() {
        String hora = DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now());
        return hora;
    }
}
