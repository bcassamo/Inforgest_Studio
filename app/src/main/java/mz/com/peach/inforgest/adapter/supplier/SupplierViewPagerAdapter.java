package mz.com.peach.inforgest.adapter.supplier;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import mz.com.peach.inforgest.fragment.supplier.OrdersToSupplierFragment;
import mz.com.peach.inforgest.fragment.supplier.SuppFilesFragment;
import mz.com.peach.inforgest.fragment.supplier.SupplierDocFragment;

/**
 * Created by peach on 12/27/14.
 */
public class SupplierViewPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private String[] titles;

    public SupplierViewPagerAdapter(FragmentManager fm, String[] titles) {
        super(fm);
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                SuppFilesFragment supplier_files = new SuppFilesFragment();
                return supplier_files;
            case 1:
                SupplierDocFragment documents = new SupplierDocFragment();
                return documents;
            case 2:
                OrdersToSupplierFragment orders = new OrdersToSupplierFragment();
                return orders;
            default:return null;
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
