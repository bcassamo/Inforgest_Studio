package mz.com.peach.inforgest.fragment.archive;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mz.com.peach.inforgest.R;

/**
 * Created by peach on 12/26/14.
 */
public class ArchDocFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_documents, container, false);
    }
}
