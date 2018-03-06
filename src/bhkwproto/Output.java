/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bhkwproto;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julius
 */
public class Output {
    String value;

    public Output(String value) {
        this.value = value;
    }
    
    public void elektrLeistung(){
        String csvFile ="..\\Dateien\\elektrLeistung.csv";
        try (FileWriter writer = new FileWriter(csvFile)) {
            //CSVWriter.writeLine(writer, Arrays.asList("Timestamp", "BHKW elektrische Leistung"));
            CSVWriter.writeLine(writer, Arrays.asList(MyTimestamp.getTimestampZone(),value));
            
            writer.flush();
        } catch (IOException ex) {
            Logger.getLogger(BHKWProto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void speicherstand(){
        String csvFile ="..\\Dateien\\speicherstand.csv";
        try (FileWriter writer = new FileWriter(csvFile)) {
            //CSVWriter.writeLine(writer, Arrays.asList("Timestamp", "Speicherfuellstand"));
            CSVWriter.writeLine(writer, Arrays.asList(MyTimestamp.getTimestampZone(),value));
            
            writer.flush();
        } catch (IOException ex) {
            Logger.getLogger(BHKWProto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void ausspeicherleistung(){
        String csvFile ="..\\Dateien\\ausspeicherleistung.csv";
        try (FileWriter writer = new FileWriter(csvFile)) {
            //CSVWriter.writeLine(writer, Arrays.asList("Timestamp", "Auspeicherleistung"));
            CSVWriter.writeLine(writer, Arrays.asList(MyTimestamp.getTimestampZone(),value));
            
            writer.flush();
        } catch (IOException ex) {
            Logger.getLogger(BHKWProto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
