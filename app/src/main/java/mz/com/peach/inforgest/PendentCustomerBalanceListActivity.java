package mz.com.peach.inforgest;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;

import mz.com.peach.inforgest.fragment.treasury.TreasuryFragment;
import mz.com.peach.inforgest.model.clients.Client;
import mz.com.peach.inforgest.rest.JSONParser;
import mz.com.peach.inforgest.rest.RestAPI;

public class PendentCustomerBalanceListActivity extends ActionBarActivity implements AdapterView.OnItemClickListener{

    ArrayAdapter<String> adapter;
    ListView listv;
    Context context;
    ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendent_customer_balance_list);

        data = new ArrayList<String>();
        listv = (ListView) findViewById(R.id.lvPendentCustomerBalance);
        context = this;

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        listv.setAdapter(adapter);
        listv.setOnItemClickListener(this);
        Toast.makeText(context, R.string.load_start, Toast.LENGTH_SHORT).show();
        new AsyncLoadPendentCustomerBalance().execute();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String itemTouched = adapter.getItem(position);
        int size = itemTouched.length();
        String message = (String) itemTouched.subSequence(4, size);
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(context, PaymentBalanceActivity.class).putExtra(Intent.EXTRA_TEXT, message);
        startActivity(intent);
    }

    protected class AsyncLoadPendentCustomerBalance extends AsyncTask<Void, JSONObject, ArrayList<Client>>{
        ArrayList<Client> customerPendentBalanceList = null;


        @Override
        protected ArrayList<Client> doInBackground(Void... params) {
            RestAPI api = new RestAPI();

            try {
                JSONObject jsonObject = api.GetPendentCustomer();
                JSONParser parser = new JSONParser();
                customerPendentBalanceList = parser.parseCustomerPendentBalance(jsonObject);
            }catch (Exception e){
                Log.d("AsyncLoadPdentCtomerBal", e.getMessage());
                Toast.makeText(context, R.string.error_message,Toast.LENGTH_LONG).show();
            }

            return customerPendentBalanceList;
        }

        @Override
        protected void onPostExecute(ArrayList<Client> clients) {
            // itera a lista de clientes para apresentar no listview
            /*for (int i = 0; i < clients.size(); i++) {
                data.add((i+1) + " - " + clients.get(i).getNome() + " - " + clients.get(i).getSaldo() + "MT");
            }*/

            for (int i = 0; i < clients.size(); i++) {
                data.add((i+1) + " - " + clients.get(i).getNome());
            }

            adapter.notifyDataSetChanged();

            Toast.makeText(context, R.string.load_complete,Toast.LENGTH_SHORT).show();
        }
    }
}
