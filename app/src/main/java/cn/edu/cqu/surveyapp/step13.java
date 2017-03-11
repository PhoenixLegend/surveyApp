package cn.edu.cqu.surveyapp;


import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class step13 extends AppCompatActivity {
    String text;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step13);

        Bundle bundle=getIntent().getExtras();
        data =bundle.getString("data");

    }

    public void button_14(View v) {

        Intent intent = new Intent();
        //设置Intent的class属性，跳转到SecondActivity
        intent.setClass(step13.this, stepf.class);

        data = data +"+"+text;
        intent.putExtra("data",data);

        startActivity(intent);
        finish();
    }

    public void button_14b(View v) {

        writeTextFile(data);
        Toast.makeText(getBaseContext(),"write successfully", Toast.LENGTH_SHORT).show();

        finish();
    }
    public void writeTextFile(String data){
        File surveyFile = new File("sdcard/"+ "output.txt");
        if (!surveyFile.exists()){
            try{
                surveyFile.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        try{
            BufferedWriter buf = new BufferedWriter(new FileWriter(surveyFile,true));
            buf.write(data);
            buf.write("\r\n");
            buf.close();
        }catch(IOException e){
            e.printStackTrace();
        }

    }


}