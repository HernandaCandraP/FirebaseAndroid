package com.hernanda.firebaseandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText editnama;
    Spinner spinnerkelas;
    Button buttonadd;

    DatabaseReference databaseanama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseanama = FirebaseDatabase.getInstance().getReference();

        editnama = findViewById(R.id.editnama);
        spinnerkelas = findViewById(R.id.spinnerkelas);
        buttonadd = findViewById(R.id.buttonadd);

        buttonadd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                addNama();
            }
        });
    }

    private void addNama(){
        String nama = editnama.getText().toString().trim();
        String kelas = spinnerkelas.getSelectedItem().toString();

        if (!TextUtils.isEmpty(nama)){
            String id = databaseanama.push().getKey();
            Nama n = new Nama(id, nama, kelas);
            databaseanama.child(id).setValue(n);

            Toast.makeText(this, "Data Add", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "masukkan nama", Toast.LENGTH_SHORT).show();
        }
    }
}
