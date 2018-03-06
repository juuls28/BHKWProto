package bhkwproto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Input extends Thread{
    private String bestTimestamp;
    private double bestValue;

    @Override
    public void run() {
        while(true){
            readCSV();
            Output out = new Output(String.valueOf(bestValue));
            out.ausspeicherleistung();
            out.elektrLeistung();
            out.speicherstand();
            
            try {
                Thread.sleep(15000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

        
    private boolean checkTime(String readTimestamp, String bestTimestampLocal){
        
        boolean better = false;
        
        try {
            readTimestamp = readTimestamp.substring(0, 23);
            
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            Date readDate = formatter.parse(readTimestamp);
            Date currentDate = formatter.parse(MyTimestamp.getTimestamp());
            
            if(currentDate.before(readDate)){
                if(bestTimestampLocal.isEmpty()){
                    better = true;
                    System.out.println("First fitting Timestamp");
                }else{
                    Date bestDate = formatter.parse(bestTimestampLocal);
                    if((bestDate.getTime()-currentDate.getTime())>(readDate.getTime()-currentDate.getTime()))
                        better = true;
                }
            }else{
                System.out.println("Zeitpunkt vorbei!");
            }
            System.out.println(bestTimestamp);
            System.out.println("better: " + better);
        } catch (ParseException ex) {
            Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
        }

        return better;
    }
    
    private void readCSV(){
        String path = "..\\Dateien\\Fahrplan.csv";
        String line = "";
        String csvSplitBy = ";";
        String bestTimestampLocal = "";
        Double bestValueLocal = 0.0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            while ((line = br.readLine()) != null) {

                String[] values = line.split(csvSplitBy);
                if(values[0].contains("CET")){
                    if(checkTime(values[0], bestTimestampLocal)){
                        bestTimestampLocal = values[0];
                        bestValueLocal = Double.parseDouble(values[1]);
                    }
                }
                
            }
            
            this.bestTimestamp = bestTimestampLocal;
            this.bestValue = bestValueLocal;
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBestTimestamp() {
        return bestTimestamp;
    }

    public void setBestTimestamp(String bestTimestamp) {
        this.bestTimestamp = bestTimestamp;
    }

    public double getBestValue() {
        return bestValue;
    }

    public void setBestValue(double bestValue) {
        this.bestValue = bestValue;
    }
}