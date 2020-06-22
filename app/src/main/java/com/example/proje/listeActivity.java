package com.example.proje;



import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;


public class listeActivity extends AppCompatActivity {

    final List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);

        final ListView listView = findViewById(R.id.listview);
        final TextAdapter adapter = new TextAdapter();

        readInfo();

        adapter.setData(list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog dialog = new AlertDialog.Builder(listeActivity.this)
                        .setTitle("SİLMEK İSTEDİĞİNE EMİN MİSİN ?")
                        .setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                list.remove(position);
                                adapter.setData(list);
                                saveInfo();
                            }
                        })
                        .setNegativeButton("Hayır", null)
                        .create();
                dialog.show();
            }
        });



        final Button newTaskButton = findViewById(R.id.newTaskButton);

        newTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText taskInput = new EditText(listeActivity.this);
                taskInput.setSingleLine();
                AlertDialog dialog = new AlertDialog.Builder(listeActivity.this)
                        .setTitle("Liste")
                        .setMessage("Eksik Malzeme?")
                        .setView(taskInput)
                        .setPositiveButton("Ekle", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                list.add(taskInput.getText().toString());
                                adapter.setData(list);
                                saveInfo();
                            }
                        })
                        .setNegativeButton("Kapat", null)
                        .create();
                dialog.show();
            }
        });

        }


        private void saveInfo(){
        try{
            File file = new File(this.getFilesDir(), "saved");

            FileOutputStream fOut = new FileOutputStream(file);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fOut));

            for(int i = 0; i < list.size(); i++){
                bw.write(list.get(i));
                bw.newLine();
            }
            bw.close();
            fOut.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        }

        private void readInfo(){
        File file = new File(this.getFilesDir(), "saved");
        if(!file.exists()){
            return;
        }
        try{
            FileInputStream is = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line = reader.readLine();
            while(line != null){
                list.add(line);
                line = reader.readLine();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        }


        class TextAdapter extends BaseAdapter{

            List<String> list = new ArrayList<>();

            void setData(List<String> mlist){
                list.clear();
                list.addAll(mlist);
                notifyDataSetChanged();
            }

            @Override
            public int getCount(){
                return list.size();
            }
            @Override
            public Object getItem(int position){
                return null;
            }
            @Override
            public long getItemId(int position){
                return 0;
            }
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                if (convertView == null){
                    LayoutInflater inflater =(LayoutInflater)
                            listeActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    convertView = inflater.inflate(R.layout.item, parent, false);
                }
                final TextView textView = convertView.findViewById(R.id.task);
                textView.setText(list.get(position));
                return convertView;

            }

        }
    }
