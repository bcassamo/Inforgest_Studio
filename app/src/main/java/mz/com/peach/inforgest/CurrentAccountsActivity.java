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

import mz.com.peach.inforgest.model.documents.Clidoc;
import mz.com.peach.inforgest.rest.JSONParser;
import mz.com.peach.inforgest.rest.RestAPI;

public class CurrentAccountsActivity extends ActionBarActivity {

    public final static String CLIENT_EXTRA_MESSAGE = "mz.com.peach.inforgest.CLIENT_MESSAGE";
    Context context;
    String message;
    ArrayAdapter<String> adapter;
    ListView listv;
    ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_accounts);

        data = new ArrayList<String>();
        listv = (ListView) findViewById(R.id.lvCustomerCurrentAccounts);
        context = this;

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        listv.setAdapter(adapter);

        Intent intent = getIntent();
        message = intent.getStringExtra(ClientDetailActivity.CLIENT_EXTRA_MESSAGE);

        if(MainActivity.isDeviceOnline(context)){
            new AsyncLoadCustomerCurrentAccounts().execute(message);
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

        
    }
}
