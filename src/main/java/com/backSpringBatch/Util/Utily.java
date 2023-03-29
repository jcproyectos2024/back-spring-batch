package com.backSpringBatch.Util;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
@Component
public class Utily {



//     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd h:mm");
//     SimpleDateFormat sdfResult = new SimpleDateFormat("HH:mm:ss");
//     SimpleDateFormat sdfResultMinutos = new SimpleDateFormat("m" );
//
//        Date difference = getDifferenceBetwenDates(sdf.parse("2018-11-01 9:31"), sdf.parse("2018-11-01 9:33"));
////        System.out.println(sdfResult.format(difference)); //00:02:00
////        System.out.println(sdfResultMinutos.format(difference) + " Minutos"); //2 Minutos
//
//        Date difference2 = getDifferenceBetwenDates(sdf.parse("2018-11-01 9:31"), sdf.parse("2018-11-01 11:28"));

//        System.out.println(sdfResult.format(difference2)); //01:57:00
//        System.out.println(sdfResultMinutos.format(difference2) + " Minutos"); //57 Minutos
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd h:mm");
    public Date getDifferenceBetwenDates (Date dateInicio, Date dateFinal) {
//        Date difference = utily.getDifferenceBetwenDates(sdf.parse(dateInicio, sdf.parse(dateFinal);
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
}
