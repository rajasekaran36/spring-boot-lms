package com.kgisl.raja.lms;

import java.io.IOException;
import java.io.OutputStream;
import java.io.FileOutputStream;
public class Dashboard{
    public void manage(){
    try(OutputStream out = new FileOutputStream("dashboard.properties")){
        
        out.flush();
    }
    catch(IOException e){
        
    }
    }
}