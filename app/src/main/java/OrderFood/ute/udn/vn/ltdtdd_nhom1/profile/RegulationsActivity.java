package OrderFood.ute.udn.vn.ltdtdd_nhom1.profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import OrderFood.ute.udn.vn.ltdtdd_nhom1.R;
import OrderFood.ute.udn.vn.ltdtdd_nhom1.activity.ProfileActivity;

public class RegulationsActivity extends AppCompatActivity {
    Button btnback;
    ListView listView;
    String mTitle[] ={"Hướng dẫn thanh toán", "Chính sách bảo mật", "Quy chế", "Điều khoản sử dụng", "Chính sách giải quyết tranh chấp"};
    int images [] = {R.drawable.payment,R.drawable.security, R.drawable.regulation, R.drawable.terms, R.drawable.policy_document};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regulations);
        //getSupportActionBar().hide();

        listView = findViewById(R.id.lvRegulations);
        btnback = (Button) findViewById(R.id.back5);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegulationsActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        MyAdapter adapter = new MyAdapter(this, mTitle, images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {

                }
                if (position ==  1) {

                }
                if (position ==  2) {

                }
                if (position ==  3) {

                }
                if (position ==  4) {

                }
            }
        });
    }
    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String rTitle[];
        int rImgs[];

        MyAdapter(Context c, String title[], int imgs[]) {
            super(c, R.layout.row, R.id.TextView1, title);
            this.context = c;
            this.rTitle = title;
            this.rImgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.TextView1);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);

            return row;
        }
    }
}