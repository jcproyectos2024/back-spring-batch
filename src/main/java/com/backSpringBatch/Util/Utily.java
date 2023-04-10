package com.backSpringBatch.Util;

import org.springframework.stereotype.Component;
import java.util.Calendar;
import java.util.Date;
@Component
public class Utily {

    public Date getSumBetwenDates (Date dateInicio, Date dateFinal) {

        int seconds1 = dateInicio.getSeconds();
        int minutes1 = dateInicio.getMinutes();
        int hours1 = dateInicio.getHours();

        int seconds2 = dateFinal.getSeconds();
        int minutes2 = dateFinal.getMinutes();
        int hours2 = dateFinal.getHours();

        int resultsec = seconds1 +seconds2;
        int resultmin = minutes1 + minutes2;
        int resulthour = hours1 + hours2;

        Calendar c = Calendar.getInstance();
        c.set(Calendar.SECOND, resultsec);
        c.set(Calendar.MINUTE, resultmin);
        c.set(Calendar.HOUR_OF_DAY, resulthour);
        return c.getTime();
    }


    public Date getDifferenceBetwenDates (Date dateInicio, Date dateFinal) {

        int seconds1 = dateInicio.getSeconds();
        int minutes1 = dateInicio.getMinutes();
        int hours1 = dateInicio.getHours();

        int seconds2 = dateFinal.getSeconds();
        int minutes2 = dateFinal.getMinutes();
        int hours2 = dateFinal.getHours();

        int resultsec = seconds2 - seconds1;
        int resultmin = minutes2 - minutes1;
        int resulthour = hours2 - hours1;


        if(resulthour < 0 || resultmin < 0 || resultsec < 0 ){
            resulthour = 00;
            resultmin = 00;
            resultsec = 00;
            Calendar c = Calendar.getInstance();
            c.set(Calendar.SECOND, resultsec);
            c.set(Calendar.MINUTE, resultmin);
            c.set(Calendar.HOUR_OF_DAY, resulthour);
            return c.getTime();
        }
        Calendar c = Calendar.getInstance();
        c.set(Calendar.SECOND, resultsec);
        c.set(Calendar.MINUTE, resultmin);
        c.set(Calendar.HOUR_OF_DAY, resulthour);
        return c.getTime();
    }


//    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd h:mm");
//    public static SimpleDateFormat sdfResult = new SimpleDateFormat("HH:mm:ss");
//    public static SimpleDateFormat sdfResultMinutos = new SimpleDateFormat("m");



}
