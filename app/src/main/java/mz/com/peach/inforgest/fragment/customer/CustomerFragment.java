package mz.com.peach.inforgest.fragment.customer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Field;

import mz.com.peach.inforgest.R;

/**
 * Created by peach on 12/27/14.
 */
public class CustomerFragment extends Fragment{
    String[] titles;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /*View view = inflater.inflate(R.layout.viewpager_main, container, false);

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        titles = getResources().getStringArray(R.array.client_tab_titles);

        viewPager.setAdapter(new ClientViewPagerAdapter(getChildFragmentManager(), titles));
        return view;*/
        return inflater.inflate(R.layout.fragment_customer, container, false);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        try{
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);
        } catch (NoSuchFieldException e){
            throw new RuntimeException(e);
        } catch (IllegalAccessException e){
            throw new RuntimeException(e);
        }
    }
}
