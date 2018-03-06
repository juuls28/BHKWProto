/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bhkwproto;

import java.util.TimeZone;

/**
 *
 * @author Julius
 */
public class MyTimestamp {
    public static String getTimestamp(){
        java.sql.Timestamp time = new java.sql.Timestamp(System.currentTimeMillis());
        return time.toString();
    }
    
    public static String getTimestampZone(){
        String time = getTimestamp();
        TimeZone timezone = TimeZone.getTimeZone( "CET" );
        return time + " " +timezone.getID();
    }
}
