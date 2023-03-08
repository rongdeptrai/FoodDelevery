package OrderFood.ute.udn.vn.ltdtdd_nhom1.adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Nearby_Frament extends FragmentPagerAdapter {
private final List<Fragment> fragmentList= new ArrayList<>();
private final  List<String> stringList= new ArrayList<>();

   public Nearby_Frament( FragmentManager fragmentManager){
       super(fragmentManager);

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
    public  void AddFragment(Fragment fragment,String title){
       fragmentList.add(fragment);
       stringList.add(title);
    }
}
