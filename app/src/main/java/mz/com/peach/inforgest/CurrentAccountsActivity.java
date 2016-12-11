package mz.com.peach.inforgest;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;

import mz.com.peach.inforgest.adapter.customer.CustomerCurrentAccountsAdapter;
import mz.com.peach.inforgest.model.documents.Clidoc;
import mz.com.peach.inforgest.rest.JSONParser;
import mz.com.peach.inforgest.rest.RestAPI;

public class CurrentAccountsActivity extends ActionBarActivity {

    public final static String CLIENT_EXTRA_MESSAGE = "mz.com.peach.inforgest.CLIENT_MESSAGE";
    public final static String CLIENT_EXTRA_MESSAGE_CODE = "mz.com.peach.inforgest.CLIENT_MESSAGE_CODE";

    Context context;
    String message;
    String messageCode;
    //ArrayAdapter<String> adapter;
    CustomerCurrentAccountsAdapter customerCurrentAccountsAdapter;
    ListView listv;
    //ArrayList<String> data;
    ArrayList<String> tvDate;
    ArrayList<String> orDoc;
    ArrayList<String> tvBalance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_accounts);

        //data = new ArrayList<String>();
        tvDate = new ArrayList<String>();
        orDoc = new ArrayList<String>();
        tvBalance = new ArrayList<String>();

        listv = (ListView) findViewById(R.id.lvCustomerCurrentAccounts);
        context = this;

        /*adapter = new ArrayAdapter<String>(this, R.layout.current_accounts_list, data);
        listv.setAdapter(adapter);*/


        customerCurrentAccountsAdapter = new CustomerCurrentAccountsAdapter(this, tvDate, orDoc, tvBalance);


        listv.setAdapter(customerCurrentAccountsAdapter);


        Intent intent = getIntent();
        message = intent.getStringExtra(ClientDetailActivity.CLIENT_EXTRA_MESSAGE);
        messageCode = intent.getStringExtra(ClientDetailActivity.CLIENT_EXTRA_MESSAGE_CODE);

        if(MainActivity.isDeviceOnline(context)){
            new AsyncLoadCustomerCurrentAccounts().execute(messageCode);
        } else {
            startActivity(new Intent(context, MainActivity.class));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                Intent intent = new Intent(context, ClientDetailActivity.class);
                intent.putExtra(CLIENT_EXTRA_MESSAGE, message);
                intent.putExtra(CLIENT_EXTRA_MESSAGE_CODE, messageCode);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected class AsyncLoadCustomerCurrentAccounts extends
            AsyncTask<String, JSONObject, ArrayList<Clidoc>>{
        ArrayList<Clidoc> pendentClidoc = null;


        @Override
        protected ArrayList<Clidoc> doInBackground(String... params) {
            RestAPI api = new RestAPI();
            try {
                JSONObject jsonObject = api.GetCustomerCurrentAccounts(params[0]);
                JSONParser parser = new JSONParser();

                pendentClidoc = parser.parseCustomerCurrentAccounts(jsonObject);
            }catch (Exception e){
                Log.d("AsyncLoadCust_Cur_Acc", e.getMessage());
                Toast.makeText(context, R.string.error_message,Toast.LENGTH_LONG).show();
            }
            return pendentClidoc;
        }

        @Override
        protected void onPostExecute(ArrayList<Clidoc> clidocs) {

            double valorPago = 0;
            double vlorFactura = 0;
            double valorAPagar = 0;
            for (int i = 0; i < clidocs.size(); i++) {
                vlorFactura = clidocs.get(0).getDebito();
                tvDate.add(clidocs.get(i).getData());
                orDoc.add(clidocs.get(i).getOrig_doc());

                valorPago = valorPago + clidocs.get(i).getCredito();

                valorAPagar = vlorFactura - valorPago;
                tvBalance.add("" + valorAPagar);

                Log.v("Divida", ""+valorAPagar);


                // Quando precisar de valor pago

                //tvValorPago.add("" + valorPago);

                /*Toast.makeText(context, i + " - " + clidocs.get(i).getData() + " - " + clidocs.get(i).getOrig_doc() + " - " + valorAPagar,Toast.LENGTH_SHORT).show();
                Log.v("Data", "" + clidocs.get(i).getData());
                Log.v("cod_cli", "" + clidocs.get(i).getCod_cli());
                Log.v("ndoc", "" + clidocs.get(i).getNdoc());
                Log.v("orig_doc", "" + clidocs.get(i).getOrig_doc());
                Log.v("debito", "" + clidocs.get(i).getDebito());
                Log.v("credito", "" + clidocs.get(i).getCredito());
                Log.v("ValorAPagar", "" + valorAPagar);
                Log.v("Data", "" + clidocs.get(i).getValor_pago());*/
            }

            customerCurrentAccountsAdapter.notifyDataSetChanged();

            //Toast.makeText(context, R.string.load_complete,Toast.LENGTH_SHORT).show();
        }
    }
}
