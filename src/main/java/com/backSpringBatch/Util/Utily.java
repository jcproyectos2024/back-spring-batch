package com.backSpringBatch.Util;

import com.diosmar.GenericExceptionUtils;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.LocalTime;
import java.time.Duration;
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
    
    public String obtenerFechaActual(Date fechaReg) {
        SimpleDateFormat formateo=new SimpleDateFormat("yyyy-MM-dd");
    	return formateo.format(fechaReg);

    }
    
    public String obtenerFechaMenosDias(int dias, Date fechaReg) throws ParseException {
    	String exit="";
        SimpleDateFormat formateo=new SimpleDateFormat("yyyy-MM-dd");
    	String fechaActual = formateo.format(fechaReg);
    	Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechaActual);
    	Calendar calendario = Calendar.getInstance();
    	calendario.setTime(fecha);
    	calendario.add(Calendar.DAY_OF_MONTH, -dias);
    	exit = new SimpleDateFormat("yyyy-MM-dd").format(calendario.getTime());
    	return exit;
    }


    public Integer segundosMilisegundos(String segundos) {
    	return Integer.parseInt(segundos)*1000;
    }
    
    public Integer minutosMilisengundos(String minutos) {
    	return Integer.parseInt(minutos)*60000;
    }
    
    public Integer horasMilisegundos(String horas) {
    	return Integer.parseInt(horas)*3600000;
    }
    
    public Integer horasMilisegundosGeneral(String hora) {
    	String[] horaSep=hora.split(":");
    	return segundosMilisegundos(horaSep[2])+minutosMilisengundos(horaSep[1])+horasMilisegundos(horaSep[0]);
    }
    
    
    public Date concatenaHoraFechaActual(String horaPendienteFormat) throws ParseException {
    	 SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
         Calendar calendar = Calendar.getInstance();

         Date dateObj = calendar.getTime();
         String formattedDate = dtf.format(dateObj);



         SimpleDateFormat fechaHora= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
         Date fh= fechaHora.parse(formattedDate+" "+horaPendienteFormat);
         return fh;

    }
    
    public Date concatenaHoraFechaActual(String horaPendienteFormat, int dia) throws ParseException {
   	 SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        
            	calendar.add(Calendar.DAY_OF_MONTH, +dia);

        Date dateObj = calendar.getTime();
        String formattedDate = dtf.format(dateObj);



        SimpleDateFormat fechaHora= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date fh= fechaHora.parse(formattedDate+" "+horaPendienteFormat);
        return fh;

   }
    

   public String horasTrabajadas(String fechaMayor, String fechaMenor){

        System.out.println("fechaMayor"+fechaMayor);
       System.out.println("fechaMenor"+fechaMenor);
       DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

       String horasMinutosSegundos = null;
       try
       {
           java.util.Date now = df.parse(fechaMenor);
           java.util.Date date=df.parse( fechaMayor);/*NO ME ANDE HACKEANDO*/
           long l=now.getTime()-date.getTime();
           long day=l/(24*60*60*1000);
           long hour=(l/(60*60*1000)-day*24);
           long min=((l/(60*1000))-day*24*60-hour*60);
           long s=(l/1000-day*24*60*60-hour*60*60-min*60);
           horasMinutosSegundos= hour+":"+min+":"+s;
          System.out.println ("  DIAS:" +day + "   HORAS:" +hour + "  MINUTOS:" + min + "   SEGUNDOS:" + s + "");
       }
       catch (Exception e)
       {

       }
       return horasMinutosSegundos;
   }

    public  String[] horasMinutosSegundosSplit(String horasMinutosSegundosEntradaNocturno)
    {
        try
        {
            String[] horasMinutosSegundosSplit = horasMinutosSegundosEntradaNocturno.split(":");
            return  horasMinutosSegundosSplit;
        }
        catch (Exception e)
        {
            return null;
        }
    }



    public   String empresa( String codigoEmpresa )
    {
        String empresa="PROCAMARONEX";
        switch(codigoEmpresa) {
            case "GD10":
                empresa="PROCAMARONEX";
                break;
            case "GD00":
                empresa="GRUPO DIOSMAR"; break;

            case "GD08":
                empresa="FAHDI S.A";
                break;

        }
        return empresa;
    }



    public  Date convertirStringDate(String fecha)
    {
        try
        {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
            Date fechaDate = formato.parse(fecha);
            return  fechaDate;
        }
        catch (Exception e)
        {
        }

        return null;
    }


    public   String  convertirDateString (Date date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaComoCadena = sdf.format(date);
       // System.out.println(fechaComoCadena);
        return   fechaComoCadena;
    }

    public   String  convertirDateStringSinHhMnSs (Date date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaComoCadena = sdf.format(date);
       // System.out.println(fechaComoCadena);
        return   fechaComoCadena;
    }


    public Date concatenaHoraFechaEntradaSalidaMarcacion(Date fecha ,String horaPendienteFormat) throws ParseException {
        SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dtf.format(fecha);
        SimpleDateFormat fechaHora= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date fh= fechaHora.parse(formattedDate+" "+horaPendienteFormat);
        return fh;

    }

    public String[] fechaPeriodoSplit(String periodo) {
        try {
            String[] horasMinutosSegundosSplit = periodo.split("_");
            return horasMinutosSegundosSplit;
        } catch (Exception e) {
            return null;
        }
    }

    public  Integer horasSplit(String horasMinutosSegundosEntradaNocturno)
    {
        try
        {
            String[] horasMinutosSegundosSplit = horasMinutosSegundosEntradaNocturno.split(":");
            return  Integer.parseInt(horasMinutosSegundosSplit[0]);
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public String  sumarUnDia( String fechaOriginal)
    {
        String resultado="";
        try
        {
            // Convertir la cadena de fecha a LocalDate
            LocalDate fecha = LocalDate.parse(fechaOriginal);
            // Restar un día
            LocalDate fechaMenosUnDia = fecha.plusDays(1);
            // Opción 2: Convertir a cadena con formato específico
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return resultado = fechaMenosUnDia.format(formatter);
        } catch (Exception ex)
        {
            throw new GenericExceptionUtils(ex);
        }
    }
    public boolean validarEntradaAtrasada(String horarioEntrada ,String horarioSalida ,String marcaEntrada)
    {
        boolean marcacionAtiempo=false;
       // String horarioEntrada = "19:30:00";
        //String horarioSalida = "05:00:00";
        // Ejemplo de marca de entrada
        //String marcaEntrada = "17:30:00";
        // Puedes cambiar la marca de entrada para probar diferentes escenarios
        // String marcaEntrada = "20:30:00";
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        try {
            Date horaEntrada = sdf.parse(horarioEntrada);
           // Date horaSalida = sdf.parse(horarioSalida);
            Date marca = sdf.parse(marcaEntrada);

            if (marca.before(horaEntrada))
            {
                System.out.println("El empleado está marcando antes de su horario de entrada.");
                marcacionAtiempo=true;
            } else if
                //(marca.after(horaEntrada) && marca.before(horaSalida)) {
            (marca.equals(horaEntrada)) {
                System.out.println("El empleado está marcando en el horario correcto.");
                marcacionAtiempo=true;
            } else {
                System.out.println("El empleado está marcando después de su horario de entrada.");
                marcacionAtiempo=false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  marcacionAtiempo;
    }
    public  String[] stringSplit(String string ,String split)
    {
        try
        {
            String[] stringSplit = string.split(split);
            return  stringSplit;
        }
        catch (Exception e)
        {
            return null;
        }
    }

}
