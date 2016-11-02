package com.foepoint.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class MainActivity extends AppCompatActivity {

    ListView list;
    private final static String NAME = "name";
    private final static String ACLAS = "class";
    private final static String ID = "id";
    private final static String PHONE = "phone";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.listView);
        String[] name = {"张三","李四","王五"};
        String[] clas = {"计科1401","软工1402","网工1403"};
        String[] id = {"001","002","003"};
        String[] phone = {"110","120","119"};
        List<Map<String,Object>> items=new ArrayList<Map<String,Object>>();


        for(int i=0;i<name.length;i++) {
            Map<String,Object> item=new HashMap<String,Object>();
            item.put(NAME , name[i]);
            item.put(ACLAS , clas[i]);
            item.put(ID , id[i]);
            item.put(PHONE , phone[i]);
            items.add(item);
            SimpleAdapter adapter=new SimpleAdapter(this,items,R.layout.item,new String[]{NAME,ACLAS,ID,PHONE},
                    new int[]{R.id.txtName,R.id.txtClass,R.id.txtId,R.id.txtPhone});

            list.setAdapter(adapter);

        }


    }
}
