package pemrogramanmobile.ubg.tugas5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class biodata extends AppCompatActivity {
    private TextView tvNim, tvNama, tvNoHp, tvEmail, tvJk, tvJurusan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata);

        setTitle("Biodata");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tvNim = findViewById(R.id.hasilNIM);
        tvNama = findViewById(R.id.hasilNama);
        tvNoHp = findViewById(R.id.hasilNoHp);
        tvEmail = findViewById(R.id.hasilEmail);
        tvJk = findViewById(R.id.hasilJk);
        tvJurusan = findViewById(R.id.hasilJurusan);

        Intent i = getIntent();
        tvNim.setText(String.valueOf(i.getStringExtra("nim")));
        tvNama.setText(String.valueOf(i.getStringExtra("nama")));
        tvNoHp.setText(String.valueOf(i.getStringExtra("nohp")));
        tvEmail.setText(String.valueOf(i.getStringExtra("email")));
        tvJk.setText(String.valueOf(i.getStringExtra("jk")));
        tvJurusan.setText(String.valueOf(i.getStringExtra("jurusan")));

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
