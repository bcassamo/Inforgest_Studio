package mz.com.peach.inforgest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import mz.com.peach.inforgest.R;

/**
 * Created by peach on 12/26/14.
 */
public class MenuListAdapter extends BaseAdapter{

    Context context;
    String[] mTitle;
    int[] mIcon;
    LayoutInflater inflater;

    public MenuListAdapter(Context context, String[] mTitle, int[] mIcon) {
        this.context = context;
        this.mTitle = mTitle;
        this.mIcon = mIcon;
    }

    @Override
    public int getCount() {
        return mTitle.length;
    }

    @Override
    public Object getItem(int position) {
        return mTitle[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView txtTitle;
        ImageView imgIcon;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.drawer_list_item, parent, false);

        txtTitle = (TextView) itemView.findViewById(R.id.title);
        imgIcon = (ImageView) itemView.findViewById(R.id.icon);

        txtTitle.setText(mTitle[position]);
        imgIcon.setImageResource(mIcon[position]);

        return itemView;
    }
}
