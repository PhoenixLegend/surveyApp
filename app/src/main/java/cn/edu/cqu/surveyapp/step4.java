package cn.edu.cqu.surveyapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class step4 extends AppCompatActivity {
    int checkedFlag = 0;
    String text;
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step4);

        Bundle bundle=getIntent().getExtras();
        data =bundle.getString("data");

        CheckBox a = (CheckBox)this.findViewById(R.id.checkBox4_1);
        CheckBox b = (CheckBox)this.findViewById(R.id.checkBox4_2);
        CheckBox c = (CheckBox)this.findViewById(R.id.checkBox4_3);
        CheckBox d = (CheckBox)this.findViewById(R.id.checkBox4_4);
        CheckBox e = (CheckBox)this.findViewById(R.id.checkBox4_5);
        CheckBox f = (CheckBox)this.findViewById(R.id.checkBox4_6);

        a.setOnCheckedChangeListener(checkboxlistener);
        b.setOnCheckedChangeListener(checkboxlistener);
        c.setOnCheckedChangeListener(checkboxlistener);
        d.setOnCheckedChangeListener(checkboxlistener);
        e.setOnCheckedChangeListener(checkboxlistener);
        f.setOnCheckedChangeListener(checkboxlistener);

        checkBoxList.add(a);
        checkBoxList.add(b);
        checkBoxList.add(c);
        checkBoxList.add(d);
        checkBoxList.add(e);
        checkBoxList.add(f);


    }
    private List<CheckBox> checkBoxList = new ArrayList<CheckBox>();

    public CheckBox.OnCheckedChangeListener checkboxlistener = new CheckBox.OnCheckedChangeListener(){
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (buttonView.isChecked()) {
                checkedFlag++;

            } else {
                checkedFlag--;
            }
            if(checkedFlag>0){
                Button bt =(Button)findViewById(R.id.button_5);
                bt.setText("continue");
                bt.setEnabled(true);
            }else {
                Button bt =(Button)findViewById(R.id.button_5);
                bt.setText("What do you think?");

            }

        }
    };
    public void button_5(View v) {

        StringBuffer sb = new StringBuffer();
        //遍历集合中的checkBox,判断是否选择，获取选中的文本
        for (CheckBox checkbox : checkBoxList) {
            if (checkbox.isChecked()){
                sb.append(checkbox.getText().toString() + " ");
            }
        }

        text = sb.toString();

        Intent intent = new Intent();
        //设置Intent的class属性，跳转到SecondActivity
        intent.setClass(step4.this, step5.class);

        data = data +"+"+text;
        intent.putExtra("data",data);
        //Toast.makeText(getBaseContext(),data, Toast.LENGTH_SHORT).show();
        startActivity(intent);
        finish();
    }

}





