package OrderFood.ute.udn.vn.ltdtdd_nhom1.profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import OrderFood.ute.udn.vn.ltdtdd_nhom1.HelpCenter.*;
import OrderFood.ute.udn.vn.ltdtdd_nhom1.R;
import OrderFood.ute.udn.vn.ltdtdd_nhom1.activity.*;

public class HelpCenterActivity extends AppCompatActivity {
    Button btnback;
    ListView listView;
    EditText edsearch;
    ArrayAdapter<String> adapter;
    String mTitle[] ={"NowFood là gì?", "Làm thế nào để đặt món từ NowFood", "Quán yêu thích là gì?",
            "Quán đối tác là gì?", "Làm thế nào để sử dụng mã khuyến mãi?", "Tôi quên mật khẩu đăng nhập", "Tại sao tôi lại bị khóa tài khoản"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_center);
        //getSupportActionBar().hide();

        listView = findViewById(R.id.lvhelpcenter);
        btnback = (Button) findViewById(R.id.close4);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HelpCenterActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        adapter = new MyAdapter(this, mTitle);
        listView.setAdapter(adapter);

        edsearch = (EditText) findViewById(R.id.edsearch);
        edsearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                HelpCenterActivity.this.adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Intent intent = new Intent(getApplicationContext(), Help1Activity.class);
                    startActivity(intent);
                }
                if (position ==  1) {
                    Intent intent = new Intent(getApplicationContext(), Help2Activity.class);
                    startActivity(intent);
                }
                if (position ==  2) {
                    Intent intent = new Intent(getApplicationContext(), Help3Activity.class);
                    startActivity(intent);
                }
                if (position ==  3) {
                    Intent intent = new Intent(getApplicationContext(), Help4Activity.class);
                    startActivity(intent);
                }
                if (position ==  4) {
                    Intent intent = new Intent(getApplicationContext(), Help5Activity.class);
                    startActivity(intent);
                }
                if (position ==  5) {
                    Intent intent = new Intent(getApplicationContext(), Help6Activity.class);
                    startActivity(intent);
                }
                if (position ==  6) {
                    Intent intent = new Intent(getApplicationContext(), Help7Activity.class);
                    startActivity(intent);
                }
            }
        });
    }


    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String rTitle[];

        MyAdapter(Context c, String title[]) {
            super(c, R.layout.row_list, R.id.TextView, title);
            this.context = c;
            this.rTitle = title;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row_list, parent, false);
            TextView myTitle = row.findViewById(R.id.TextView);
            myTitle.setText(rTitle[position]);

            return row;
        }
    }
}