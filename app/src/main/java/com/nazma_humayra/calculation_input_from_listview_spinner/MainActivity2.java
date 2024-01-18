package com.nazma_humayra.calculation_input_from_listview_spinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    TextView editTextText,editTextText2,editTextText3,editTextText4;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
button= findViewById(R.id.button);
        editTextText = findViewById(R.id.editTextText);
        editTextText2 = findViewById(R.id.editTextText2);
        editTextText3 = findViewById(R.id.editTextText3);
        editTextText4 = findViewById(R.id.editTextText4);

        Intent ii = getIntent();
        String editText6Value = ii.getStringExtra("editText6Value");
        editTextText.setText(editText6Value);
        String editText7Value = ii.getStringExtra("editText7Value");
        editTextText2.setText(editText7Value);
        String editText8Value = ii.getStringExtra("editText8Value");
        editTextText3.setText(editText8Value);

        int value7 = Integer.parseInt(editText7Value);
        int value8 = Integer.parseInt(editText8Value);

        int result = value7 * value8;

        editTextText4.setText(String.valueOf(result));

button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent ii = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(ii);
    }
});
    }
}