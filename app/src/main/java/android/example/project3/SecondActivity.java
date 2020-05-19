package android.example.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class SecondActivity extends AppCompatActivity {

    TextView welcomeText;
    CheckBox checkBoxImage;
    CheckBox checkBoxNoImage;
    ImageView imageToShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        imageToShow= (ImageView) findViewById(R.id.image_view_internet);
        welcomeText = (TextView) findViewById(R.id.text_view_welcome);
        checkBoxImage= (CheckBox)findViewById(R.id.check_box_imagen);
        checkBoxNoImage=(CheckBox)findViewById(R.id.check_box_no_imagen);
        Bundle extras = getIntent().getExtras();
        String name= extras.getString("name");
        welcomeText.setText(name);

    }

    public void OnClickCheckBox(View view) {
        int selectedCheckBox = view.getId();
        if(selectedCheckBox== R.id.check_box_imagen){
            if(checkBoxImage.isChecked()){
                DrawableCrossFadeFactory factory =
                        new DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build();


                //Load imagen from url with glided
                Glide.with(this)
                        .load("https://tse2.mm.bing.net/th?id=OIP.WyeBUNyXwKYtzUkFvjQZlAHaE7&pid=Api&P=0&w=259&h=173")
                        .placeholder(R.drawable.ic_camera_blue_100dp)
                        .transition(withCrossFade(factory))
                        .into(imageToShow);
            }
            else{
                imageToShow.setImageResource(R.drawable.ic_camera_blue_100dp);

            }
        }
        else{
            if(checkBoxNoImage.isChecked()){
                Toast.makeText(this,"Ha seleccionado no mostrar imagen.", Toast.LENGTH_SHORT).show();
            }

        }

    }
}
