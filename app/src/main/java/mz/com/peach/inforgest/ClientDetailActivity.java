package mz.com.peach.inforgest;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;

import mz.com.peach.inforgest.model.clients.Client;
import mz.com.peach.inforgest.rest.JSONParser;
import mz.com.peach.inforgest.rest.RestAPI;

public class ClientDetailActivity extends ActionBarActivity {

    TextView name, balance;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_detail);
        context = this;
        name = (TextView) findViewById(R.id.txtName);
        balance = (TextView) findViewById(R.id.txtBalance);
    }

    protected class AsyncClientDetails extends
            AsyncTask<Void, JSONObject, ArrayList<Client>> {
        ArrayList<Client> deptTable = null;

        @Override
        protected ArrayList<Client> doInBackground(Void... params) {

            RestAPI api = new RestAPI();
            try {

                JSONObject jsonObj = api.GetClientCurrentAccount();

                JSONParser parser = new JSONParser();

                deptTable = parser.parseClientList(jsonObj);

            } catch (Exception e) {
                Log.d("AsyncClientDetails", e.getMessage());
                Toast.makeText(context, R.string.error_message, Toast.LENGTH_LONG).show();
            }

            return deptTable;
        }



    }
}
