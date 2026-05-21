package kr.ac.kopo.menutest1;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    LinearLayout linear;
    EditText edit;
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top,
                    systemBars.right, systemBars.bottom);
            return insets;
        });

        linear = findViewById(R.id.main);
        edit = findViewById(R.id.edit);
        img = findViewById(R.id.img);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        int rotationDegree = 0;
        if(item.getItemId() == R.id.img_rotate){
            rotationDegree = Integer.parseInt(edit.getText().toString());
            img.setRotation(rotationDegree);
            return true;
        }
        else if (item.getItemId() == R.id.item_puppy) {
            img.setImageResource(R.drawable.puppy1);
            item.setChecked(true);
            return true;
        } else if (item.getItemId() == R.id.item_cat) {
            img.setImageResource(R.drawable.cat);
            item.setChecked(true);
            return true;
        } else if (item.getItemId() == R.id.item_panda) {
            img.setImageResource(R.drawable.panda);
            item.setChecked(true);
            return true;
        }
        return false;
    }
}