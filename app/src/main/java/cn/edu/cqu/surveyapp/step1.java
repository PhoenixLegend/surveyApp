package cn.edu.cqu.surveyapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class step1 extends AppCompatActivity {
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step1);

        final RadioGroup group = (RadioGroup)this.findViewById(R.id.g1);
        //绑定一个匿名监听器
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) step1.this.findViewById(radioButtonId);

                text = rb.getText().toString();
                //更新文本内容，以符合选中项


                Button bt =(Button)findViewById(R.id.button_2);
                bt.setText("continue");
                bt.setEnabled(true);


            }
        });
    }
    public void button_2(View v) {

        Intent intent = new Intent();
        //设置Intent的class属性，跳转到SecondActivity
        intent.setClass(step1.this, step2.class);
        intent.putExtra("data",text);
        startActivity(intent);
        //启动Activity
        finish();
    }
}