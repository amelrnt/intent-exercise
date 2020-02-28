package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    private TextView fullname;
    private TextView aboutMe;
    private TextView email;
    private TextView homepage;
    private ImageView pictProfile;
    private Button homePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        fullname = findViewById(R.id.label_fullname);
        aboutMe = findViewById(R.id.label_about);
        email = findViewById(R.id.label_email);
        homepage = findViewById(R.id.label_homepage);
        pictProfile = findViewById(R.id.image_profile);
        homePage = findViewById(R.id.button_homepage);

        Bundle extras = getIntent().getExtras();
        final String home = extras.getString(RegisterActivity.HOMEPAGE_KEY);
        if (extras!=null){
            String name = extras.getString(RegisterActivity.FULLNAME_KEY);
            String about = extras.getString(RegisterActivity.ABOUTYOU_KEY);
            String mail = extras.getString(RegisterActivity.EMAIL_KEY);
            Bitmap bitmap = (Bitmap) extras.get("picture");
            pictProfile.setImageBitmap(bitmap);
            fullname.setText(name);
            aboutMe.setText(about);
            email.setText(mail);
            homepage.setText(home);
        }


        homePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse(home);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }

            }
        });


    }


}
