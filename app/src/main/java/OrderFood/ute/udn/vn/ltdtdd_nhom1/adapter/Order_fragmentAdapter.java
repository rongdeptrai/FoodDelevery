package OrderFood.ute.udn.vn.ltdtdd_nhom1.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Order_fragmentAdapter extends FragmentPagerAdapter {
    private final List<Fragment> fragmentList= new ArrayList<>();
    private final  List<String> stringList= new ArrayList<>();

    public Order_fragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return  fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return stringList.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return stringList.get(position);
    }
    public  void AddFragment(Fragment fragment, String title){
        fragmentList.add(fragment);
        stringList.add(title);
    }
}
