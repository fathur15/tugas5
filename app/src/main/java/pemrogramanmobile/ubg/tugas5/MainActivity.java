package pemrogramanmobile.ubg.tugas5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText nim, nama, nohp, email;
    private RadioGroup rgJk;
    private Spinner jurusan;
    private String dataJurusan [] = {
            "S1 Ilkom",
            "S1 Gizi",
            "S1 Hukum",
            "S1 DKV",
            "S1 Farmasi",
            "S1 TI",
            "S1 Manajemen",
            "S1 Sastra Inggris",
            "S1 Akuntansi",
            "D3 SI",
            "D3 RPL",
            "D3 Bahasa Inggris"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nim = findViewById(R.id.inputNim);
        nama = findViewById(R.id.inputNama);
        nohp = findViewById(R.id.inputNoHp);
        email = findViewById(R.id.inputEmail);
        rgJk = findViewById(R.id.rgJK);
        jurusan = findViewById(R.id.jurusan);

        ArrayAdapter<String> jurusanAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, dataJurusan);
        jurusanAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        jurusan.setAdapter(jurusanAdapter);
    }

    public void tampilkanData(View v){
        int id = rgJk.getCheckedRadioButtonId();
        if(TextUtils.isEmpty((nim.getText()))
            || TextUtils.isEmpty((nama.getText()))
            || TextUtils.isEmpty((email.getText()))
            || TextUtils.isEmpty((nohp.getText()))
            || id == -1

        ){
            if(TextUtils.isEmpty((nim.getText()))){
                nim.setError("NIM Belum diisi");
            }
            if(TextUtils.isEmpty((nama.getText()))){
                nama.setError("Nama Belum diisi");
            }
            if(TextUtils.isEmpty((nohp.getText()))){
                nohp.setError("Nomer Hp Belum diisi");
            }
            if(TextUtils.isEmpty((email.getText()))){
                email.setError("Email Belum diisi");
            }
            if(id == -1){
                Toast.makeText(this, "Jenis Kelaimn Belum Dipilih", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Intent biodata = new Intent(this, pemrogramanmobile.ubg.tugas5.biodata.class);
            biodata.putExtra("nim", nim.getText().toString());
            biodata.putExtra("nama", nama.getText().toString());
            biodata.putExtra("nohp", nohp.getText().toString());
            biodata.putExtra("email", email.getText().toString());
            biodata.putExtra("jurusan", jurusan.getSelectedItem().toString());
            RadioButton jk = findViewById(id);
            biodata.putExtra("jk", jk.getText().toString());
            startActivity(biodata);
        }


    }
}
