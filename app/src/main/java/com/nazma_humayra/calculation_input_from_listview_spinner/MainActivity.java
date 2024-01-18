package com.nazma_humayra.calculation_input_from_listview_spinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Spinner spinner3, spinner4;
    EditText editTextText6,editTextText7,editTextText8;
    TextView tv_1; // This TextView is to display a static text, not related to the ListView
    String[] productName = {"Smartphone", "Water Bottle", "Headphones", "Planner", "Fitness Tracker", "Reusable Cup", "Bluetooth Speaker", "Desk Organizer"};
    ListView lv1;
    Integer[] productprice = {100, 200, 300, 400, 500, 600, 700, 800};
    Integer[] productno = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
 Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner3 = findViewById(R.id.spinner3);
        spinner4 = findViewById(R.id.spinner4);
        lv1 = findViewById(R.id.lv1);
        editTextText6 = findViewById(R.id.editTextText6);
        editTextText7 = findViewById(R.id.editTextText7);
        editTextText8 = findViewById(R.id.editTextText8);
        button2 = findViewById(R.id.button2);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, productName);
        lv1.setAdapter(adapter1);


        lv1.setOnItemClickListener((parent, view, position, id) -> {
            editTextText6.setText(productName[position]);
            Toast.makeText(MainActivity.this, getString(R.string.selecteditem) + " " + productName[position], Toast.LENGTH_SHORT).show();
        });
        ArrayAdapter  <Integer> adapter2;
        adapter2 = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, productprice);
        spinner3.setAdapter(adapter2);

        ArrayAdapter<Integer> adapter3;
        adapter3 = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, productno);
        spinner4.setAdapter(adapter3);

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                editTextText7.setText(String.valueOf(productprice[position]));
                Toast.makeText(MainActivity.this, getString(R.string.selecteditem) + " " + productprice[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle the case when nothing is selected
            }
        });
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                editTextText8.setText(String.valueOf(productno[position]));
                Toast.makeText(MainActivity.this, getString(R.string.selecteditem) + " " + productno[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle the case when nothing is selected
            }
        });

button2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent ii = new Intent(MainActivity.this, MainActivity2.class);

        String editText6Value = editTextText6.getText().toString();
        ii.putExtra("editText6Value", editText6Value);
        String editText7Value = editTextText7.getText().toString();
        ii.putExtra("editText7Value", editText7Value);

        String editText8Value = editTextText8.getText().toString();
        ii.putExtra("editText8Value", editText8Value);


        startActivity(ii);
    }
});


    }
}
