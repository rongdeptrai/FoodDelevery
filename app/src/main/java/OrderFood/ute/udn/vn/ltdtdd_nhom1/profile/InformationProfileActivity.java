package OrderFood.ute.udn.vn.ltdtdd_nhom1.profile;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import OrderFood.ute.udn.vn.ltdtdd_nhom1.InformationProfile.EmailChangeActivity;
import OrderFood.ute.udn.vn.ltdtdd_nhom1.InformationProfile.PassChangeActivity;
import OrderFood.ute.udn.vn.ltdtdd_nhom1.InformationProfile.PhoneNumberChangeActivity;
import OrderFood.ute.udn.vn.ltdtdd_nhom1.InformationProfile.UsernameChangeActivity;
import OrderFood.ute.udn.vn.ltdtdd_nhom1.R;
import OrderFood.ute.udn.vn.ltdtdd_nhom1.activity.ProfileActivity;
import gun0912.tedbottompicker.TedBottomPicker;

public class InformationProfileActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private Button btnBack;
    private RelativeLayout password;
    private RelativeLayout usernameinfo;
    private RelativeLayout phonenumber;
    private RelativeLayout email;
    private RelativeLayout dob;
    private TextView tvDate;
    TextView tvFullName, tvEmail, tvDOB, tvPass, tvPhone;
    ImageView change_image, imguser;
    DatePickerDialog.OnDateSetListener setListener;

    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_profile);
        //getSupportActionBar().hide();
        anhXaView();

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();


        hienthiTTProfile();

        change_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermission();

            }
        });

        btnBack = findViewById(R.id.back3);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InformationProfileActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        password = findViewById(R.id.password);
        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InformationProfileActivity.this, PassChangeActivity.class);
                startActivity(intent);
            }
        });

        usernameinfo = findViewById(R.id.username);
        usernameinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InformationProfileActivity.this, UsernameChangeActivity.class);
                startActivity(intent);
            }
        });

        phonenumber = findViewById(R.id.phone);
        phonenumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InformationProfileActivity.this, PhoneNumberChangeActivity.class);
                startActivity(intent);
            }
        });

        email = findViewById(R.id.email);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InformationProfileActivity.this, EmailChangeActivity.class);
                startActivity(intent);
            }
        });

        tvDate = findViewById(R.id.tv_date1);
        dob = findViewById(R.id.BOD);
        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
    }

    public void requestPermission() {
        PermissionListener permissionlistener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                openImagePicker();
            }

            @Override
            public void onPermissionDenied(List<String> deniedPermissions) {
                Toast.makeText(InformationProfileActivity.this, "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
            }
        };
        TedPermission.with(this)
                .setPermissionListener(permissionlistener)
                .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                .setPermissions(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE)
                .check();

    }

    private void openImagePicker() {
        TedBottomPicker.OnImageSelectedListener listener = new TedBottomPicker.OnImageSelectedListener() {
            @Override
            public void onImageSelected(Uri uri) {
                Bitmap bitmap = null;
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                    imguser.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        };

        TedBottomPicker tedBottomPicker = new TedBottomPicker.Builder(InformationProfileActivity.this)
                .setOnImageSelectedListener(listener)
                .create();
        tedBottomPicker.show(getSupportFragmentManager());

    }

    private void sendData() {
        Intent theIntent = new Intent(InformationProfileActivity.this, ProfileActivity.class);
        theIntent.putExtra("fullname", (Parcelable) tvFullName);
        theIntent.putExtra("email", (Parcelable) tvEmail);
        startActivity(theIntent);

    }

    private void anhXaView() {
        tvFullName = findViewById(R.id.tv_fullName1);
        tvEmail = findViewById(R.id.tv_email1);
        tvDOB = findViewById(R.id.tv_date1);
        tvPass = findViewById(R.id.tv_pass1);
        tvPhone = findViewById(R.id.tv_phone1);
        change_image = findViewById(R.id.change_image);
        imguser = findViewById(R.id.img_user2);
    }


    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = dayOfMonth + "/" + month + "/" + year;
        tvDate.setText(date);
    }

    private void hienthiTTProfile() {
        if (firebaseAuth.getCurrentUser() != null) {
            userID = firebaseAuth.getCurrentUser().getUid();
            DocumentReference documentReference = firebaseFirestore.collection("user").document(userID);
            documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
                @Override
                public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                    if (value.exists()) {
                        tvFullName.setText(value.getString("fullName"));
                        tvDate.setText(value.getString("dob"));
                        tvEmail.setText(value.getString("email"));
                        tvPhone.setText(value.getString("phone"));

                    } else {
                        Log.d("tag", "onEvent: Document do not exists");
                    }
                }
            });
        }
    }
}