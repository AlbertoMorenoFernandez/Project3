package android.example.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StartActivity extends AppCompatActivity {

    Button startButton;
    EditText nameText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        startButton= (Button) findViewById(R.id.button_start);
        nameText=(EditText)findViewById(R.id.edittext_name);
    }

    public void OnClickButton(View view) {
        if(view.getId()==R.id.button_start){
            Intent intent= new Intent(this,SecondActivity.class);
            intent.putExtra("name", nameText.getText().toString());
            startActivity(intent);
        }
    }
}
