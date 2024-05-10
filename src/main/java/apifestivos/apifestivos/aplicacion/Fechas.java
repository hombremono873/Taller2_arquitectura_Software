package apifestivos.apifestivos.aplicacion;

import java.util.Calendar;
import java.util.Date;

public class Fechas {
    private static int a = 0;
    private static int m = 0;
    private static int d = 0;

    public static Date getDomingoRamos(int año) {
        int a = año % 19;
        int b = año % 4;
        int c = año % 7;
        int d = (19 * a + 24) % 30;
        int dias = d + (2 * b + 4 * c + 6 * d + 5) % 7;
        int dia = 15 + dias;
        int mes = 3;
        if (dia > 31) {
            dia = dia - 31;
            mes = 4;
        }
        return new Date(año - 1900, mes - 1, dia);
    }

    public static Date agregarDias(Date fecha, int dias) {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fecha);
        calendario.add(Calendar.DATE, dias);
        return calendario.getTime();
    }

    public static Date getSiguienteLunes(Date fecha) {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fecha);
        if (calendario.get(Calendar.DAY_OF_WEEK) > calendario.MONDAY) {
            fecha = agregarDias(fecha, 9 - calendario.get(Calendar.DAY_OF_WEEK));
        } else {
            fecha = agregarDias(fecha, 1);
        }
        return fecha;
    }

    public static void fechaEntera(Date fecha) {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fecha);
        a = calendario.get(Calendar.YEAR);
        m = calendario.get(Calendar.MONTH) + 1; // Se suma 1 porque los meses van
        d = calendario.get(Calendar.DAY_OF_MONTH);
    }

    private static String getDiaSanto1(Date diasanto, int anio, int mes, int dia, int flag) {
        fechaEntera(diasanto);
        String mensaje = "";
        if (a == anio && m == mes && d == dia) {
            switch (flag) {
                case 1:
                    mensaje = "Es el festivo Jueves Santo " + diasanto;
                    break;
                case 2:
                    mensaje = "Es el festivo Viernes Santo " + diasanto;
                    break;
                case 3:
                    mensaje = "Es el festivo Domingo de Pascua " + diasanto;
                    break;
                case 4:
                    mensaje = "Es el festivo Domingo de Ramos " + diasanto;
                    break;
                case 5:
                    mensaje = "Es el festivo Ascension del Señor " + diasanto;
                    break;
                case 6:
                    mensaje = "Es el festivo Corpus Christi  " + diasanto;
                    break;
            }

        }
        return mensaje;
    }
    public static Date viernesSanto(int año, int mes, int dia){
        Date domingoRamos = getDomingoRamos(año);
        Date domingoPascua = agregarDias(domingoRamos, 7);
        Date jsanto = agregarDias(domingoPascua, -3);
        Date vsanto = agregarDias(jsanto, 1);
        return vsanto;
    }
    public static Date juevesSanto(int año, int mes, int dia){
        Date domingoRamos = getDomingoRamos(año);
        Date domingoPascua = agregarDias(domingoRamos, 7);
        Date jsanto = agregarDias(domingoPascua, -3);
        return jsanto;
    }
    public static Date domingoRamos(int año, int mes, int dia){
        Date domingoRamos = getDomingoRamos(año);
        return domingoRamos;
    }
    public static Date domingoPascua(int año, int mes, int dia){
        Date domingoRamos = getDomingoRamos(año);
        Date domingoPascua = agregarDias(domingoRamos, 7);
        return domingoPascua;
    }
    public static Date ascensionSeñor(int año, int mes, int dia){
        Date domingoRamos = getDomingoRamos(año);
        Date domingoPascua = agregarDias(domingoRamos, 7);
        Date ascensionSeñor = agregarDias(domingoPascua, 40);
        return ascensionSeñor;
    }
    public static Date corpus(int año, int mes, int dia){
        Date domingoRamos = getDomingoRamos(año);
        Date domingoPascua = agregarDias(domingoRamos, 7);
        Date corpus = agregarDias(domingoPascua, 61);
        return corpus;
    }
    public static Date sagradoCorazon(int año, int mes, int dia){
        Date domingoRamos = getDomingoRamos(año);
        Date domingoPascua = agregarDias(domingoRamos, 7);
        Date sagradocorazon = agregarDias(domingoPascua, 68);
        
        return sagradocorazon;
    }
    public static String getFestivo(int anio, int mes, int dia) {
        Date domingoRamos = getDomingoRamos(anio);
        Date domingoPascua = agregarDias(domingoRamos, 7);
        Date jsanto = agregarDias(domingoPascua, -3);
        Date vsanto = agregarDias(jsanto, 1);
        Date ascensionSeñor = agregarDias(domingoPascua, 40);
        Date corpus = agregarDias(domingoPascua, 61);
        Date sagradocorazon = agregarDias(domingoPascua, 68);

        fechaEntera(jsanto);
        if (a == anio && m == mes && d == dia) {
            return " Jueves Santo " + " " + jsanto;
        }
        fechaEntera(vsanto);
        if (a == anio && m == mes && d == dia) {
            return  " Viernes Santo" + vsanto;
        }
        fechaEntera(domingoPascua);
        if (a == anio && m == mes && d == dia) {
            return " Domingo de Pascua " + domingoPascua;
        }
        fechaEntera(domingoRamos);
        if (a == anio && m == mes && d == dia) {
            return " Domingo de Ramos" + domingoRamos;
        }
        fechaEntera(ascensionSeñor);
        if (a == anio && m == mes && d == dia + 1) {
            ascensionSeñor = getSiguienteLunes(ascensionSeñor);
            return " Ascensión del Señor" + ascensionSeñor;
        }
        fechaEntera(corpus);
        if (a == anio && m == mes && d == dia + 1) {
            corpus = getSiguienteLunes(corpus);
            return " Corpus Christi " + corpus;
        }
        fechaEntera(sagradocorazon);
        if (a == anio && m == mes && d == dia) {
            sagradocorazon = getSiguienteLunes(sagradocorazon);
            return " Sagrado Corazon de Jesús" + sagradocorazon;
        }
        return "";

    }

    public static Date enteroFecha(int anio, int mes, int dia) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, anio);
        calendar.set(Calendar.MONTH, mes - 1); // Los meses en Calendar van de 0 a 11
        calendar.set(Calendar.DAY_OF_MONTH, dia);

        Date fecha = calendar.getTime();
        return fecha;
    }

    public static int getDiaDeLaSemana(int año, int mes, int diaDelMes) {
        Calendar calendario = Calendar.getInstance();
        calendario.set(Calendar.YEAR, año);
        calendario.set(Calendar.MONTH, mes - 1); // Calendar.MONTH es 0-based
        calendario.set(Calendar.DAY_OF_MONTH, diaDelMes); // Configurar el día del mes

        int diaDeLaSemana = calendario.get(Calendar.DAY_OF_WEEK);

        return diaDeLaSemana;
    }
}
