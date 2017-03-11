package cn.edu.cqu.surveyapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class step12 extends ListActivity {

    String text;
    String data;

    String[] myStringArray = new String[] {
            "America 美国,美洲",
            "Arab 阿拉伯人",
            "Australia澳洲,澳大利亚",
            "Austria 奥地利",
            "Britain英国",
            "Canada 加拿大",
            "China 中国",
            "Egypt 埃及",
            "England英国",
            "France 法国",
            "Germany德国",
            "Greece  希腊",
            "Holland 荷兰",
            "India 印度",
            "Ireland  爱尔兰",
            "Italy 意大利",
            "Japan日本",
            "Spain  西班牙",
            "Sweden 瑞典",
            "Swiss 瑞士人",
            "Switzerland瑞士",
            "Brazil巴西",
            "Finland芬兰",
            "Norway 挪威",
            "Russia 俄国",
            "Belgium 比利时"};

    TextView Country;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step12);

        Bundle bundle=getIntent().getExtras();
        data =bundle.getString("data");

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                myStringArray));

        //Get the activity`s listView, use getListView()
        ListView myListView = getListView();

        Country = (TextView)this.findViewById(R.id.country);

        //Handle click events

        myListView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Do something based on user clicked
                s = (String)parent.getItemAtPosition(position);

                Country.setText(s+"?");
                if(Country!=null){
                    Button bt =(Button)findViewById(R.id.button_13);
                    bt.setText("continue");
                    bt.setEnabled(true);
                }

            }
        });

    }    public void button_13(View v) {

        text = s;

        Intent intent = new Intent();
        //设置Intent的class属性，跳转到SecondActivity
        intent.setClass(step12.this, step13.class);

        data = data +"+"+text;
        intent.putExtra("data",data);

        startActivity(intent);
        finish();
    }
}
