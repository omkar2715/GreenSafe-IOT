package Hardwarecode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import gnu.io.CommPortIdentifier; 
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent; 
import gnu.io.SerialPortEventListener; 
import java.util.Enumeration;


import java.util.Properties;
import javax.sound.midi.MidiDevice.Info;

import com.sun.corba.se.impl.protocol.AddressingDispositionException;

import food.com.services.*;

public class ArduinoConnection implements SerialPortEventListener {
SerialPort serialPort;
    /** The port we're normally going to use. */
private static final String PORT_NAMES[] = {"/dev/tty.usbserial-A9007UX1", // Mac OS X
        "/dev/ttyUSB0", // Linux
        "COM3", // Windows
};

static String vehicleid;
static String lat;
static String lon;
static int temp;
static int humidity;
static int mq135;
static int mq136;
static String addedDate;
static String addedTime;
static BufferedReader input;
private static OutputStream output;
private static final int TIME_OUT = 2000;
private static final int DATA_RATE = 9600;
Properties prop = new Properties();
public void initialize() {
	
    CommPortIdentifier portId = null;
    Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

    //First, Find an instance of serial port as set in PORT_NAMES.
    while (portEnum.hasMoreElements()) {
        CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
        for (String portName : PORT_NAMES) {
            if (currPortId.getName().equals(portName)) {
                portId = currPortId;
                break;
            }
        }
    }
    if (portId == null) {
        System.out.println("Could not find COM port...");
        return;
    }

    try {
        serialPort = (SerialPort) portId.open(this.getClass().getName(),
                TIME_OUT);
        serialPort.setSerialPortParams(DATA_RATE,
                SerialPort.DATABITS_8,
                SerialPort.STOPBITS_1,
                SerialPort.PARITY_NONE);

        // open the streams
        input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
        output = serialPort.getOutputStream();
//        output=serialPort.getOutputBufferSize();

        
       
        
        serialPort.addEventListener(this);
        serialPort.notifyOnDataAvailable(true);
        
        
    } catch (Exception e) {
        System.err.println(e.toString());
    }
}


public synchronized void close() {
    if (serialPort != null) {
        serialPort.removeEventListener();
        serialPort.close();
    }
}

public synchronized void serialEvent(SerialPortEvent oEvent) {
	
    if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
    	
    	 try {
         
           if(input.ready())
        	   
        	  // Thread.sleep(500);
           vehicleid=input.readLine();
           System.out.println("vehicle number = "+vehicleid);
           Thread.sleep(1000);
           
           lat=input.readLine();
           System.out.println("latitude = "+lat);
           Thread.sleep(1000);
           lon=input.readLine();
           System.out.println("longitude = "+lon);
           Thread.sleep(1000);
         
           humidity=input.read();
           System.out.println("Humidity = "+humidity);
           Thread.sleep(1000);
           
           temp=input.read();           
           System.out.println("Temperature = "+temp);
           Thread.sleep(1000);
           mq135=input.read();
           
           
           //int mq_135=Integer.parseInt(mq135);
           System.out.println("mq135 = "+mq135);
           Thread.sleep(1000);
           
           mq136=input.read();
          // int mq_136=Integer.parseInt(mq136);

           System.out.println("mq136 = "+mq136);
           Thread.sleep(1000);
           
           
        	Connection conn=ConnectionDB.getCon();
	 	         
		      
        	PreparedStatement ps = conn.prepareStatement("UPDATE vehicle_tbl SET Lat=? , Lon=? , Temp=?, Humidity=?, MQ135=?, MQ136=?  where vehicle_no=?");
 	 	      
 	 	        ps.setString(1,lat);
 	 	        ps.setString(2,lon);
 	 	        ps.setInt(3,temp);
 	 	        ps.setInt(4,humidity);
 	 	        ps.setInt(5,mq135);
 	 	        ps.setInt(6,mq136);
 	 	        ps.setString(7,vehicleid);
 	 	
 	 	        ps.executeUpdate();
 	 	        
 	 	      
 	 	        
				if(temp>32 || mq135>250 || mq136>250)
				{
					DateTimeFormatter dtf1=DateTimeFormatter.ofPattern("yyyy-MM-dd");
					LocalDateTime now1=LocalDateTime.now();
					DateTimeFormatter dtf2=DateTimeFormatter.ofPattern("HH-mm-ss");
					LocalDateTime now2=LocalDateTime.now();
					addedDate=dtf1.format(now1);
					addedTime=dtf2.format(now2);
					
					PreparedStatement ps2 = conn.prepareStatement("insert into vehicle_logs values(?,?,?,?,?,?,?,?,?,?)");
		 	        ps2.setInt(1,0);
		 	        ps2.setString(2,vehicleid);
		 	        ps2.setString(3,lat);
		 	        ps2.setString(4,lon);
		 	        ps2.setInt(5,temp);
		 	       ps2.setInt(6,humidity);
		 	      ps2.setInt(7,mq135);
		 	     ps2.setInt(8,mq136);
		 	        ps2.setString(9,addedDate);
		 	        ps2.setString(10,addedTime);
		 	
		 	       int i1 = ps2.executeUpdate();
		 	       if(i1>0)
		 	       {
		 	    	   System.out.println("Log Added..!!");
		 	       }
				}
        	 	
        }
    	 catch(Exception e)
    	 {
    		 System.err.println(e);
    		 e.printStackTrace();
    	 }
           
            
        }
   
    
    }
    

  
    // Ignore all the other eventTypes, but you should consider the other ones.


private Object open(String inputLine, String string) {
	
	// TODO Auto-generated method stub
	return null;
}
public static void main(String[] args) throws SQLException {
	 
	ArduinoConnection main = new ArduinoConnection();
 
    
   main.initialize();
  
        
    Thread t=new Thread() {
        public void run() {
            //the following line will keep this app alive for 1000    seconds,
            //waiting for events to occur and responding to them    (printing incoming messages to console).
            try {Thread.sleep(1000000);} catch (InterruptedException    ie) {}
        }
    };

    
    
   
 
          t.start();
    
    System.out.println("Server Started");
    
    
   
}
}

