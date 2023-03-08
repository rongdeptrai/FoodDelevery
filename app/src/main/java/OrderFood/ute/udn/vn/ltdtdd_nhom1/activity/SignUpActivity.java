package OrderFood.ute.udn.vn.ltdtdd_nhom1.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import OrderFood.ute.udn.vn.ltdtdd_nhom1.R;


public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = "TAG";
    private Button btnRegister;
    private EditText edtFullName, edtPhoneNum, edtEmail, edtPassword, edtLocation, edtDOB;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;
    private FirebaseFirestore firebaseFirestore;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this);

        edtEmail = findViewById(R.id.edt_email);
        edtFullName = findViewById(R.id.edt_full_name);
        edtPassword = findViewById(R.id.edt_password);
        edtPhoneNum = findViewById(R.id.edt_phone);
        edtLocation = findViewById(R.id.edt_address);
        edtDOB = findViewById(R.id.edt_dob);

        progressBar = findViewById(R.id.progress_bar_register);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRegister:
                registerUser();
        }
    }

    private void registerUser() {
        final String fullName = edtFullName.getText().toString();
        final String email = edtEmail.getText().toString().trim();
        final String DOB = edtDOB.getText().toString();
        final String location = edtLocation.getText().toString();
        final String password = edtPassword.getText().toString().trim();
        final String phoneNum = edtPhoneNum.getText().toString();

        if (fullName.isEmpty()) {
            edtFullName.setError("Nhập họ tên");
            edtFullName.requestFocus();
            return;
        }
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
        if (password.length() <= 6) {
            edtPassword.setError("Mật khẩu phải dài hơn 6 kí tự");
            edtPassword.requestFocus();
            return;
        }
        if (phoneNum.isEmpty()) {
            edtPhoneNum.setError("Nhập vào số điện thoại");
            edtPhoneNum.requestFocus();
            return;
        }
        if (location.isEmpty()) {
            edtLocation.setError("Nhập vào địa chỉ");
            edtLocation.requestFocus();
            return;
        }
        if (DOB.isEmpty()) {
            edtDOB.setError("Nhập ngày tháng năm sinh");
            edtDOB.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    //Dang ki tai khoan va luu du lieu nguoi dung
                    userID = mAuth.getCurrentUser().getUid();
                    DocumentReference documentReference = firebaseFirestore.collection("user").document(userID);
                    Map<String, Object> user = new HashMap<>();
                    user.put("fullName", fullName);
                    user.put("email", email);
                    user.put("phone", phoneNum);
                    user.put("address", location);
                    user.put("dob", DOB);
                    documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Log.d("Đăng kí", "DocumentSnapshot added with ID: ");
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w("TAG", "Error adding document", e);
                        }
                    });

                    Toast.makeText(SignUpActivity.this, "Đăng kí thành công", Toast.LENGTH_LONG);
                    startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                } else {
                    Toast.makeText(SignUpActivity.this, "Đăng kí thất bại", Toast.LENGTH_LONG);
                    progressBar.setVisibility(View.GONE);
                }
            }
        });

    }

    public void back_login_activity(View view) {
        startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
        finish();
    }
}
