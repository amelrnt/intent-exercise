package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.ConfirmPassword;
import com.mobsandgeeks.saripaar.annotation.Domain;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.util.List;

public class RegisterActivity extends AppCompatActivity implements Validator.ValidationListener {
    @NotEmpty
    private EditText fullname;
    @NotEmpty
    @Domain
    private EditText homepage;
    @NotEmpty
    private EditText aboutYou;
    @NotEmpty
    @Email
    private EditText email;
    @Password
    private EditText password;
    @ConfirmPassword
    private EditText confirmPassword;
    protected Validator validator;
    private ImageView gb1;
    private static final int GALLERY_REQUEST_CODE = 1;
    public static final String FULLNAME_KEY = "username";
    public static final String EMAIL_KEY = "aaa@gmail.com";
    public static final String PASSWORD_KEY = "1234";
    public static final String ABOUTYOU_KEY = "asdfghjkl";
    public static final String HOMEPAGE_KEY = "polinema.ac.id";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        validator = new Validator(this);
        validator.setValidationListener(this);
        gb1 = findViewById(R.id.image_profile);
        fullname = findViewById(R.id.text_fullname);
        email = findViewById(R.id.text_email);
        homepage = findViewById(R.id.text_homepage);
        password = findViewById(R.id.text_password);
        confirmPassword = findViewById(R.id.text_confirm_password);
        aboutYou = findViewById(R.id.text_about);
        homepage = findViewById(R.id.text_homepage);
    }

    public void handleSave(View view) {
        validator.validate();
        validator.setValidationMode(Validator.Mode.IMMEDIATE);
        Intent intent = new Intent(this, ProfileActivity.class);
        String namaLengkap = fullname.getText().toString();
        String mail = email.getText().toString();
        intent.putExtra(FULLNAME_KEY,namaLengkap);
        intent.putExtra(EMAIL_KEY,mail);
        intent.putExtra(PASSWORD_KEY,password.getText().toString());
        intent.putExtra(PASSWORD_KEY,confirmPassword.getText().toString());
        intent.putExtra(ABOUTYOU_KEY,aboutYou.getText().toString());
        intent.putExtra(HOMEPAGE_KEY,homepage.getText().toString());
        startActivity(intent);
    }

    @Override
    public void onValidationSucceeded() {

    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);

            // Display error messages ;)
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }
        }
    }

    public void handlePhoto(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, GALLERY_REQUEST_CODE);

    }
}

