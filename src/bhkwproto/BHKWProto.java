package bhkwproto;

import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Julius
 */
public class BHKWProto {

    
    public void elektrLeistung(String input, String timestamp){
        String csvFile ="..\\Dateien\\elektrLeistung.csv";
        try (FileWriter writer = new FileWriter(csvFile)) {
            //CSVWriter.writeLine(writer, Arrays.asList("Timestamp", "BHKW elektrische Leistung"));
            CSVWriter.writeLine(writer, Arrays.asList(timestamp,input));
            
            writer.flush();
        } catch (IOException ex) {
            Logger.getLogger(BHKWProto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void speicherstand(String input, String timestamp){
        String csvFile ="..\\Dateien\\speicherstand.csv";
        try (FileWriter writer = new FileWriter(csvFile)) {
            //CSVWriter.writeLine(writer, Arrays.asList("Timestamp", "Speicherfuellstand"));
            CSVWriter.writeLine(writer, Arrays.asList(timestamp,input));
            
            writer.flush();
        } catch (IOException ex) {
            Logger.getLogger(BHKWProto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void ausspeicherleistung(String input, String timestamp){
        String csvFile ="..\\Dateien\\ausspeicherleistung.csv";
        try (FileWriter writer = new FileWriter(csvFile)) {
            //CSVWriter.writeLine(writer, Arrays.asList("Timestamp", "Auspeicherleistung"));
            CSVWriter.writeLine(writer, Arrays.asList(timestamp,input));
            
            writer.flush();
        } catch (IOException ex) {
            Logger.getLogger(BHKWProto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void main(String[] args) {
        BHKWProto bhkw = new BHKWProto();
        CSVWriter csv = new CSVWriter();
        String input = JOptionPane.showInputDialog(null, "Bitte Wert eingeben");

        Timestamp time = new Timestamp(System.currentTimeMillis());
        TimeZone timezone = TimeZone.getTimeZone( "CET" );
        String timestamp = time + " " +timezone.getID();
        System.out.println(timestamp);

        bhkw.elektrLeistung(input, timestamp);
        bhkw.speicherstand(input, timestamp);
        bhkw.ausspeicherleistung(input, timestamp);
    }
    
}
