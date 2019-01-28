package aquar.aswany.myaquar_eg.Models;

import android.content.Context;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;

public class save_in_file {

    int image ;
String discrption;
List<save_in_file>saveInFiles_list;
    private String filename = "SampleFile.txt";
    private String filepath = "MyFileStorage";
    File myExternalFile;
    String myData = "";

    public save_in_file(int image, String discrption, List<save_in_file> saveInFiles_list) {
        this.image = image;
        this.discrption = discrption;
        this.saveInFiles_list = saveInFiles_list;
    }



    public void read (){
        try {
            FileOutputStream fos = new FileOutputStream(myExternalFile);
           // fos.write(inputText.getText().toString().getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

     }
    public void save(){

        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

/*
        inputText.setText(myData);
        response.setText("SampleFile.txt data retrieved from Internal Storage...");

        */
    }


    }


