package mz.com.peach.inforgest.fragment.product;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mz.com.peach.inforgest.R;

/**
 * Created by peach on 12/27/14.
 */
public class ProductFilesFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_product_files, container, false);
    }
}
