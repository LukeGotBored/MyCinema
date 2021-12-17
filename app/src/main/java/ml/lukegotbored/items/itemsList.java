package ml.lukegotbored.items;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;


// il codice di riferimento è stato preso da
public class itemsList extends AppCompatActivity {
    ListView lvfilm;
    Button btnEsci;
    String film[] = {"Spiderman: Far from home", "Red Notice", "Free Guy"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_list);

        // ↓ questo ancora non l'abbiamo ancora fatto //
            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle("Lista Film");
            // assert actionBar != null;
            // actionBar.setDisplayHomeAsUpEnabled(true);
        // ------------------------------------------//


        lvfilm = (ListView)findViewById(R.id.lvFilm);
        ArrayAdapter<String> aaFilm = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, film);
        lvfilm.setAdapter(aaFilm);

        lvfilm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String titolo = (String)lvfilm.getItemAtPosition(i);
                Intent intent = new Intent(getApplicationContext(), movieDetails.class);
                intent.putExtra("numeroFilm", i);
                intent.putExtra("titolo", titolo);

                startActivity(intent);
                Log.d("click_procedura", "Hai cliccato sulla " + i + " voce");
            }
        });

    }
}