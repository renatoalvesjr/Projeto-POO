package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {
    private static Pessoa pessoaLogada = null;
    
    public static String dataAgora(){
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
    }

    public static Pessoa getPessoaLogada() {
        return pessoaLogada;
    }

    public static void setPessoaLogada(Pessoa pessoaLogada) {
        Utils.pessoaLogada = pessoaLogada;
    }
    
    
}
