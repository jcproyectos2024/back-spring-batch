package com.backSpringBatch.Util;

import com.backSpringBatch.dto.RegistroMarcacionesDTO;
import com.backSpringBatch.dto.RegistroMarcacionesEntraSalida;
import com.backSpringBatch.postgres.entity.AsistNow;
import com.backSpringBatch.postgres.models.MarcacionIdentificacionDto;
import com.backSpringBatch.postgres.repository.PostGresRepository;
import com.diosmar.GenericExceptionUtils;
import com.diosmar.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.LocalTime;
import java.time.Duration;
import java.util.stream.Collectors;

@Component
public class Utily {
    @Autowired
    private PostGresRepository postGresRepository;
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


    public  String horasTrabajadas(String fechaMayor, String fechaMenor) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String horasMinutosSegundos = "00:00:00";
        try {
            Date now = df.parse(fechaMenor);
            Date date = df.parse(fechaMayor);
            long l = now.getTime() - date.getTime();
            long day = l / (24 * 60 * 60 * 1000);
            long hour = (l / (60 * 60 * 1000) - day * 24);
            long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
            long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
            DecimalFormat dfFormat = new DecimalFormat("00");
            horasMinutosSegundos = dfFormat.format(hour) + ":" + dfFormat.format(min) + ":" + dfFormat.format(s);
           // System.out.println("horasMinutosSegundos"+horasMinutosSegundos);
           // System.out.println("  DIAS:" + day + "   HORAS:" + hour + "  MINUTOS:" + min + "   SEGUNDOS:" + s + "");
        } catch (ParseException e) {
            e.printStackTrace();
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
    public boolean validarEntradaAtrasada(String horarioEntrada,String marcaEntrada)
    {
        boolean marcacionAtiempo=false;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        try {
            Date horaEntrada = sdf.parse(horarioEntrada);
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

    public boolean validarSalidaAnteDelHorario(String horarioSalida ,String marcaSalida)
    {
        boolean marcacionSalida=false;
        try
        {
           // String horarioSalida = "05:00:00";
            //String marcaSalida = "05:30:00";
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            Date salidaEsperada = sdf.parse(horarioSalida);
            Date marcaSalidaTime = sdf.parse(marcaSalida);

            if (marcaSalidaTime.after(salidaEsperada))
            {
                System.out.println("El empleado marcó la salida después del horario establecido.");
                marcacionSalida=true;
            } else if (marcaSalidaTime.before(salidaEsperada))
            {
                System.out.println("El empleado marcó la salida antes del horario establecido.");
                marcacionSalida=false;
            } else {
                System.out.println("El empleado marcó la salida en el horario correcto.");
                marcacionSalida=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  marcacionSalida;
    }

    public String  restarHoras(String horaOriginal , String tiempoARestar) {
        try
        {
          // Parsear las cadenas de tiempo a objetos LocalTime
            LocalTime horaOriginalTime = LocalTime.parse(horaOriginal, DateTimeFormatter.ofPattern("HH:mm:ss"));
            LocalTime tiempoARestarTime = LocalTime.parse(tiempoARestar, DateTimeFormatter.ofPattern("HH:mm:ss"));

            // Restar el tiempo
            LocalTime resultado = horaOriginalTime.minusHours(tiempoARestarTime.getHour())
                    .minusMinutes(tiempoARestarTime.getMinute())
                    .minusSeconds(tiempoARestarTime.getSecond());

            // Imprimir el resultado
            System.out.println("El resultado es: " + resultado.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
            return  resultado.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        } catch (Exception e)
        {
            e.printStackTrace();
            return "";
        }
    }

    public  long convertirHorasAMilisegundos(String horaMinutosSegundo)
    {
        long milisegundos=0L;
        try
        {
            // Parsear la cadena de tiempo a un objeto LocalTime
            LocalTime localTime = LocalTime.parse(horaMinutosSegundo);
            // Calcular la cantidad de milisegundos
            System.out.println(horaMinutosSegundo + " es igual a " + milisegundos + " milisegundos.");
            return  milisegundos = localTime.toNanoOfDay() / 1000000;
        }
        catch (Exception e)
        {
            return 0L;
        }
    }

    public Object[] nuevesHorasMediaTrabajadas(String fechaEntradaS ,String fechaSalidaS)
    {
        Object[] salida=new Object[2];
        String nuevesHorasMediaTrabajadas="";
        try
        {
            //String fechaEntradaStr = "2023-11-01 20:00:00";
            //String fechaSalidaStr = "2023-11-02 08:22:58";
            String tiempoPerdidoStr = "PT1H30M";

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime fechaEntrada = LocalDateTime.parse(fechaEntradaS, formatter);
            LocalDateTime fechaSalida = LocalDateTime.parse(fechaSalidaS, formatter);
            Duration tiempoPerdido = Duration.parse(tiempoPerdidoStr);

            Duration duracionTrabajo = Duration.between(fechaEntrada, fechaSalida).minus(tiempoPerdido);
            Duration duracionTrabajoo = Duration.between(fechaEntrada, fechaSalida);

            long horasTrabajadas = duracionTrabajo.toHours();
            long minutosTrabajados = duracionTrabajo.toMinutes() % 60;
            long horasTrabajadass = duracionTrabajoo.toHours();
            long minutosTrabajadoss= duracionTrabajoo.toMinutes() % 60;
            System.out.println("Horas trabajadas: " + horasTrabajadass + " horas y " + minutosTrabajadoss + " minutos.");

            System.out.println("Horas trabajadas (descontando tiempo perdido): " + horasTrabajadas + " horas y " + minutosTrabajados + " minutos.");

            // Verificar si se han cumplido 9 horas y 30 minutos
            Duration duracionEsperada = Duration.ofHours(8).plusMinutes(00);

            if (duracionTrabajo.compareTo(duracionEsperada) >= 0) {
                // Calcular la fecha y hora en la que se cumplieron las 9 horas y 30 minutos
                LocalDateTime fechaCumplimiento = fechaEntrada.plus(duracionEsperada);

                System.out.println("Se han cumplido 8 horas y 00 minutos de trabajo (descontando tiempo perdido) en: " +
                        fechaCumplimiento.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                 nuevesHorasMediaTrabajadas= fechaCumplimiento.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                salida[0]=nuevesHorasMediaTrabajadas;
                salida[1]=true;
            } else {
                System.out.println("No se han cumplido 9 horas y 30 minutos de trabajo (descontando tiempo perdido).");
                salida[0]=nuevesHorasMediaTrabajadas;
                salida[1]=false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  salida;
    }

    public   String[]  convertirStringFechaHMS(String fechaString )
    {
        try
        {
            ///String fechaString = "2023-11-10 05:30:00";
            // Crear un DateTimeFormatter para el formato dado
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            // Parsear la cadena a LocalDateTime
            LocalDateTime fecha = LocalDateTime.parse(fechaString, formatter);
            // Formatear y mostrar solo la parte de la hora
            DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
             String horaMs = fecha.format(formatoHora);
            System.out.println("Hora: " + horaMs);
            return stringSplit(horaMs,":");

        }
        catch (Exception e)
        {
            return null;
        }

    }

    public  String sumarHoras(String fechaStr ,String tiempoASumarStr)
    {
        try
        {
           // String fechaStr = "2023-11-09 05:30:00";
            //String tiempoASumarStr = "01:09:00";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime fecha = LocalDateTime.parse(fechaStr, formatter);
            // Analizar el tiempo a sumar
            String[] partesTiempo = tiempoASumarStr.split(":");
            int horasASumar = Integer.parseInt(partesTiempo[0]);
            int minutosASumar = Integer.parseInt(partesTiempo[1]);
            int segundosASumar = Integer.parseInt(partesTiempo[2]);

            // Sumar el tiempo a la fecha
            LocalDateTime nuevaFecha = fecha.plusHours(horasASumar)
                    .plusMinutes(minutosASumar)
                    .plusSeconds(segundosASumar);

            System.out.println("La nueva fecha y hora después de sumar " + tiempoASumarStr + ": " + nuevaFecha.format(formatter));
            return  nuevaFecha.format(formatter);
        }
        catch (Exception e)
        {
            return null;
        }
    }


    public  List<RegistroMarcacionesDTO> conversioRegistroMarcacionesDTO( String biometrico ,List<AsistNow> list)
    {
        System.out.println("biometrico"+biometrico);
        int cont = 0;
        List<RegistroMarcacionesDTO> registroMarcacionesDTOList = new ArrayList<>();
        for (AsistNow registroMarcaciones : list) {
            cont++;
            RegistroMarcacionesDTO registroMarcacionesDTO = new RegistroMarcacionesDTO();
            registroMarcacionesDTO.setIdRegistroMarcaciones(cont);
            registroMarcacionesDTO.setAsisId(registroMarcaciones.getId().getAsisId() == null ? "" : registroMarcaciones.getId().getAsisId());
            registroMarcacionesDTO.setAsisFecha(registroMarcaciones.getAsisFecha() == null ? null : (Date) registroMarcaciones.getAsisFecha());
            registroMarcacionesDTO.setIdentificacion(registroMarcaciones.getIdentificacion() == null ? "" : (String) registroMarcaciones.getIdentificacion());
            registroMarcacionesDTO.setApellidos(registroMarcaciones.getApellidos() == null ? "" : (String) registroMarcaciones.getApellidos());
            registroMarcacionesDTO.setNombres(registroMarcaciones.getNombres() == null ? "" : (String) registroMarcaciones.getNombres());
            registroMarcacionesDTO.setZona(registroMarcaciones.getBiometrico().getNombreBiometrico() == null ? "" : (String) registroMarcaciones.getBiometrico().getNombreBiometrico());
            registroMarcacionesDTO.setHoraEntrada(registroMarcaciones.getAsisHora() == null ? null : (String) registroMarcaciones.getAsisHora());
            registroMarcacionesDTO.setFechaEntrada(registroMarcaciones.getId().getAsisIng() == null ? null : (Date) registroMarcaciones.getId().getAsisIng());
            String[] horas = horasMinutosSegundosSplit(registroMarcaciones.getAsisHora());
            if (biometrico.equalsIgnoreCase("GARITA"))
            {
                //System.out.println("biometrico"+biometrico);
                if (Integer.parseInt(horas[0]) >= 16)
                {
                    String asisFecha = convertirDateStringAnosMesDias(registroMarcaciones.getAsisFecha());
                    String fechaTurnoNche = sumarUnDia(asisFecha);
                    List<AsistNow> asistNowNoche = postGresRepository.consultarMarcacioneSalida(registroMarcaciones.getIdentificacion(), fechaTurnoNche, fechaTurnoNche, registroMarcaciones.getBiometrico().getNombreBiometrico(), registroMarcaciones.getEmpresa(), "SALIDA");
                    //Utils.console("asistNowNoche", Utils.toJson(asistNowNoche));
                    registroMarcacionesDTO.setHoraSalida(asistNowNoche.isEmpty() || asistNowNoche == null ? null : asistNowNoche.get(0).getAsisHora());
                    registroMarcacionesDTO.setFechaSalida(asistNowNoche.isEmpty() || asistNowNoche == null ? null : asistNowNoche.get(0).getId().getAsisIng());
                }
                if (Integer.parseInt(horas[0]) <= 16)
                {
                String asisFecha = convertirDateStringAnosMesDias(registroMarcaciones.getAsisFecha());
                List<AsistNow> asistNowNoche = postGresRepository.consultarMarcacioneSalida(registroMarcaciones.getIdentificacion(), asisFecha, asisFecha, registroMarcaciones.getBiometrico().getNombreBiometrico(), registroMarcaciones.getEmpresa(), "SALIDA");
                registroMarcacionesDTO.setHoraSalida(asistNowNoche.isEmpty() || asistNowNoche == null ? null : asistNowNoche.get(0).getAsisHora());
                registroMarcacionesDTO.setFechaSalida(asistNowNoche.isEmpty() || asistNowNoche == null ? null : asistNowNoche.get(0).getId().getAsisIng());
                }

        }else
        {
            //System.out.println("biometrico"+biometrico);
            String asisFecha = convertirDateStringAnosMesDias(registroMarcaciones.getAsisFecha());
            List<AsistNow> asistNowNoche = postGresRepository.consultarMarcacioneSalida(registroMarcaciones.getIdentificacion(), asisFecha, asisFecha, registroMarcaciones.getBiometrico().getNombreBiometrico(), registroMarcaciones.getEmpresa(), "SALIDA");
            registroMarcacionesDTO.setHoraSalida(asistNowNoche.isEmpty() || asistNowNoche == null ? null : asistNowNoche.get(0).getAsisHora());
            registroMarcacionesDTO.setFechaSalida(asistNowNoche.isEmpty() || asistNowNoche == null ? null : asistNowNoche.get(0).getId().getAsisIng());

        }
            registroMarcacionesDTO.setEmpresa(registroMarcaciones.getEmpresa() == null ? null : (String) registroMarcaciones.getEmpresa() );
            if (registroMarcacionesDTO.getHoraEntrada()==null)
            {
                registroMarcacionesDTO.setEditado("INGRESO");
            }
            if (registroMarcacionesDTO.getHoraSalida()==null)
            {
                registroMarcacionesDTO.setEditado("SALIDA");
            }
            registroMarcacionesDTOList.add(registroMarcacionesDTO);

        }
        return registroMarcacionesDTOList;
    }

    public  List<RegistroMarcacionesEntraSalida> conversioRegistroMarcacionesEntraSalida(List<Object[]> list)
    {

        List<RegistroMarcacionesEntraSalida> registroMarcacionesDTOList = new ArrayList<>();
        for (Object[] registroMarcaciones : list)
        {
            RegistroMarcacionesEntraSalida  registroMarcacionesDTO= new RegistroMarcacionesEntraSalida();
            registroMarcacionesDTO.setAsisId(registroMarcaciones[0] == null ? "": (String) registroMarcaciones[0]);
            registroMarcacionesDTO.setAsisFecha(registroMarcaciones[1] == null ? null : (Date) registroMarcaciones[1]);
            registroMarcacionesDTO.setIdentificacion(registroMarcaciones[2] == null ? "" : (String) registroMarcaciones[2]);
            registroMarcacionesDTO.setApellidos(registroMarcaciones[3] == null ? "" : (String) registroMarcaciones[3]);
            registroMarcacionesDTO.setNombres(registroMarcaciones[4] == null ? "" : (String) registroMarcaciones[4]);
            registroMarcacionesDTO.setAsisTipo(registroMarcaciones[5] == null ? "" : (String) registroMarcaciones[5]);
            registroMarcacionesDTO.setZona(registroMarcaciones[6] == null ? "" : (String) registroMarcaciones[6]);
            registroMarcacionesDTO.setAsisHora(registroMarcaciones[7] == null ? null : (String) registroMarcaciones[7]);
            registroMarcacionesDTO.setAsisIng(registroMarcaciones[8] == null ? null : (Date) registroMarcaciones[8]);
            registroMarcacionesDTO.setEmpresa(registroMarcaciones[9] == null ? null : (String) registroMarcaciones[9]);
            registroMarcacionesDTOList.add(registroMarcacionesDTO);

        }
        return registroMarcacionesDTOList;
    }


    public List<Date> recorrerDosRangosFechas(Date fechaInicio, Date fechaFin) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(fechaInicio);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(fechaFin);
        List<Date> listaFechas = new ArrayList<>();
        while (!c1.after(c2)) {
            listaFechas.add(c1.getTime());
            c1.add(Calendar.DAY_OF_MONTH, 1);
        }
        return listaFechas;
    }

    public Date convertirStringDate(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return formatter.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    public String convertirDateStringAnosMesDias(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaComoCadena = sdf.format(date);
        return fechaComoCadena;
    }

    public  List<MarcacionIdentificacionDto> conversioMarcacionIdentificacion(List<Object[]> list)
    {

        List<MarcacionIdentificacionDto> registroMarcacionesDTOList = new ArrayList<>();
        for (Object[] registroMarcaciones : list)
        {
            MarcacionIdentificacionDto  registroMarcacionesDTO= new MarcacionIdentificacionDto();
            registroMarcacionesDTO.setAsisId(registroMarcaciones[0] == null ? "": (String) registroMarcaciones[0]);
            registroMarcacionesDTO.setIdentificacion(registroMarcaciones[1] == null ? "" : (String) registroMarcaciones[1]);
            registroMarcacionesDTO.setApellidos(registroMarcaciones[2] == null ? "" : (String) registroMarcaciones[2]);
            registroMarcacionesDTO.setNombres(registroMarcaciones[3] == null ? "" : (String) registroMarcaciones[3]);
            registroMarcacionesDTO.setEmpresa(registroMarcaciones[4] == null ? null : (String) registroMarcaciones[4]);
            registroMarcacionesDTO.setIdentificacionApellidos(registroMarcacionesDTO.getIdentificacion()+" - "+registroMarcacionesDTO.getApellidos());
            registroMarcacionesDTOList.add(registroMarcacionesDTO);

        }
        return registroMarcacionesDTOList;
    }


}
