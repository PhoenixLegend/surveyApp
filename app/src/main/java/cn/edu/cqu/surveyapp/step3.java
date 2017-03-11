package cn.edu.cqu.surveyapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class step3 extends AppCompatActivity {
    String data;
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step3);

        Bundle bundle=getIntent().getExtras();
        data =bundle.getString("data");

        RadioGroup group = (RadioGroup)this.findViewById(R.id.g3);
        //绑定一个匿名监听器
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                // TODO Auto-generated method stub
                //获取变更后的选中项的ID
                int radioButtonId = arg0.getCheckedRadioButtonId();
                //根据ID获取RadioButton的实例
                RadioButton rb = (RadioButton) step3.this.findViewById(radioButtonId);
                //更新文本内容，以符合选中项

                text = rb.getText().toString();

                Button bt =(Button)findViewById(R.id.button_4);
                bt.setText("continue");
                bt.setEnabled(true);

            }
        });
    }
    public void button_4(View v) {

        Intent intent = new Intent();
        //设置Intent的class属性，跳转到SecondActivity
        intent.setClass(step3.this, step4.class);

        data = data +"+"+text;
        intent.putExtra("data",data);

        startActivity(intent);
        finish();

    }
}