package OrderFood.ute.udn.vn.ltdtdd_nhom1.SharePreferences;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ramotion.paperonboarding.PaperOnboardingEngine;
import com.ramotion.paperonboarding.PaperOnboardingPage;

import java.util.ArrayList;

import OrderFood.ute.udn.vn.ltdtdd_nhom1.R;

public class OnboardingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding_main_layout);

        PaperOnboardingEngine engine = new PaperOnboardingEngine(findViewById(R.id.onboardingRootView),
                getPaperOnBoardingPageData(), this);
    }

    private ArrayList<PaperOnboardingPage> getPaperOnBoardingPageData() {
        PaperOnboardingPage scr1 = new PaperOnboardingPage("Tìm quán ăn gần bạn",
                "với hơn 3000 cửa hàng",
                Color.parseColor("#f96400"), R.drawable.splash1, R.drawable.key);
        PaperOnboardingPage scr2 = new PaperOnboardingPage("Giao hàng nhanh nhất",
                "Chất lượng tốt nhất",
                Color.parseColor("#f96400"), R.drawable.splsh2, R.drawable.wallet);
        PaperOnboardingPage scr3 = new PaperOnboardingPage("Thanh toán tiện dụng",
                "Bảo mật với nhiều phương thức thanh toán",
                Color.parseColor("#f96400"), R.drawable.splash3, R.drawable.shopping_cart);

        ArrayList<PaperOnboardingPage> elements = new ArrayList<>();
        elements.add(scr1);
        elements.add(scr2);
        elements.add(scr3);

        return elements;
    }
    private void startActivity(Class<?> cls){
        Intent intent = new Intent(this,cls);
        startActivity(intent);
        finish();
    }
}