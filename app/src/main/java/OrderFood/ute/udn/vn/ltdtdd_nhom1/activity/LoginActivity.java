package OrderFood.ute.udn.vn.ltdtdd_nhom1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import OrderFood.ute.udn.vn.ltdtdd_nhom1.R;

public class LoginActivity extends AppCompatActivity implements FirebaseAuth.AuthStateListener{
    Button btnLogin;
    EditText edtEmail, edtPassword;
    ProgressBar progressBarLogin;
    FirebaseAuth mAuth;
    TextView tvRegister;
    GoogleSignInClient googleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = findViewById(R.id.edtMail);
        edtPassword = findViewById(R.id.edt_password_login);
        progressBarLogin = findViewById(R.id.progress_bar_login);
        mAuth = FirebaseAuth.getInstance();

        btnLogin = findViewById(R.id.btnLogin);
        tvRegister = findViewById(R.id.edt_sign_up);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
        googleLogin();
    }

    private void googleLogin() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        googleSignInClient = GoogleSignIn.getClient(this, gso);


    }

    private void register() {
        startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
        finish();
    }

    private void login() {
        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        if (email.isEmpty()) {
            edtEmail.setError("Nhập địa chỉ email");
            edtEmail.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            edtPassword.setError("Nhập vào mật khẩu");
            edtPassword.requestFocus();
            return;
        }
        progressBarLogin.setVisibility(View.VISIBLE);
        //Xu ly dang nhap
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                } else {
                    Toast.makeText(LoginActivity.this, "Sai tên đăng nhập hoặc mật khẩu", Toast.LENGTH_LONG).show();
                    progressBarLogin.setVisibility(View.GONE);
                }
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser =mAuth.getCurrentUser();
        mAuth.addAuthStateListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
       mAuth.removeAuthStateListener(this);
    }
    public void open_activity_sign_up(View view) {
        register();
    }

    @Override
    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
        FirebaseUser currentUser =mAuth.getCurrentUser();
        if(currentUser!=null) {
            Toast.makeText(LoginActivity.this, "Đã đăng nhập với " + currentUser.getEmail(), Toast.LENGTH_SHORT).show();
            Intent iTrangChu=new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(iTrangChu);
            finish();
        }
    }

}
