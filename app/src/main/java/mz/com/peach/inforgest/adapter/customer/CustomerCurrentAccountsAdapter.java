package mz.com.peach.inforgest.adapter.customer;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import mz.com.peach.inforgest.R;

/**
 * Created by peach on 9/26/16.
 */

public class CustomerCurrentAccountsAdapter extends BaseAdapter {

    Activity context;
    ArrayList<String> tvDate;
    ArrayList<String> orDoc;
    ArrayList<String> tvBalance;

    public CustomerCurrentAccountsAdapter(Activity context, ArrayList<String> orDoc) {
        this.context = context;
        this.orDoc = orDoc;
    }


    public CustomerCurrentAccountsAdapter(Activity context, ArrayList<String> tvDate, ArrayList<String> orDoc, ArrayList<String> tvBalance) {
        this.context = context;
        this.tvDate = tvDate;
        this.orDoc = orDoc;
        this.tvBalance = tvBalance;
    }

    @Override
    public int getCount() {
        return orDoc.size();
    }

    @Override
    public Object getItem(int position) {
        return orDoc.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        LayoutInflater inflater =  context.getLayoutInflater();

        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.current_accounts_list, null);
            holder = new ViewHolder();
            holder.txtViewDate = (TextView) convertView.findViewById(R.id.tvDate);
            holder.txtViewOrDoc = (TextView) convertView.findViewById(R.id.tvOrDoc);
            holder.textViewBalance = (TextView) convertView.findViewById(R.id.tvBalance);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtViewDate.setText(tvDate.get(position));
        holder.txtViewOrDoc.setText(orDoc.get(position));
        holder.textViewBalance.setText(tvBalance.get(position));

        return convertView;
    }

    private class ViewHolder {
        TextView txtViewDate;
        TextView txtViewOrDoc;
        TextView textViewBalance;
    }
}
