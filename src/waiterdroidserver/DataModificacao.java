package waiterdroidserver;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

//Classe com a data da ultima modificação nos produtos
public class DataModificacao implements Serializable{
    private String horaData;
    public DataModificacao(){
        Locale locale = new Locale("pt","BR");
        GregorianCalendar calendar = new GregorianCalendar();
        SimpleDateFormat formatador = new SimpleDateFormat("dd'/'MM'/'yyyy'-'HH':'mm':'ss",locale);
        horaData = formatador.format(calendar.getTime());
    }

    public DataModificacao(String s){
        horaData = s;
    }

    public String getDataMod(){
        return horaData;
    }
}
