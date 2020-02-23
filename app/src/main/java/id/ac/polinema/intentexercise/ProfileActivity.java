package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    private TextView fullname;
    private TextView aboutMe;
    private TextView email;
    private TextView homepage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        fullname = findViewById(R.id.label_fullname);
        aboutMe = findViewById(R.id.label_about);
        email = findViewById(R.id.label_email);
        homepage = findViewById(R.id.label_homepage);

        Bundle extras = getIntent().getExtras();

        if (extras!=null){
            String name = extras.getString(RegisterActivity.FULLNAME_KEY);
            String about = extras.getString(RegisterActivity.ABOUTYOU_KEY);
            String mail = extras.getString(RegisterActivity.EMAIL_KEY);
            String homePage = extras.getString(RegisterActivity.HOMEPAGE_KEY);

            fullname.setText(name);
            aboutMe.setText(about);
            email.setText(mail);
            homepage.setText(homePage);
        }



    }


}
