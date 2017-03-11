package cn.edu.cqu.surveyapp;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class step14 extends AppCompatActivity {
    String text;
    String data;

    TextView email = (TextView)this.findViewById(R.id.email);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step14);

        Bundle bundle=getIntent().getExtras();
        data =bundle.getString("data");

    }

    public void button_f(View v) {

        if(!isEmail(email.getText().toString())){

        Toast.makeText(getBaseContext(),"email error", Toast.LENGTH_SHORT).show();


        }
        else{
            text = email.getText().toString();
            data = data+" "+text;
            writeTextFile(data);
            Toast.makeText(getBaseContext(),"write successfully", Toast.LENGTH_SHORT).show();

            finish();

        }

    }

    public static boolean isEmail(String email){
        if (null==email || "".equals(email)) return false;
        //Pattern p = Pattern.compile("\\w+@(\\w+.)+[a-z]{2,3}"); //简单匹配
        Pattern p =  Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");//复杂匹配
        Matcher m = p.matcher(email);
        return m.matches();
    }

    public void writeTextFile(String data){
        File surveyFile = new File("sdcard/"+ "su.txt");
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