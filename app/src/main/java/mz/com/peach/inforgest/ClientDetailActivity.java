package mz.com.peach.inforgest;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import mz.com.peach.inforgest.model.clients.Client;
import mz.com.peach.inforgest.rest.JSONParser;
import mz.com.peach.inforgest.rest.RestAPI;

public class ClientDetailActivity extends ActionBarActivity {

    TextView code, name, balance;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_detail);
        context = this;
        code = (TextView) findViewById(R.id.txtCliDetCode);
        name = (TextView) findViewById(R.id.txtCliDetName);
        balance = (TextView) findViewById(R.id.txtCliDetBalance);

        Intent intent = getIntent();
        String message = intent.getStringExtra(ClientListActivity.CLIENT_EXTRA_MESSAGE);
        new AsyncClientDetails().execute(message);
    }

    protected class AsyncClientDetails extends
            AsyncTask<String, Void, Client> {

        @Override
        protected Client doInBackground(String... params) {
            Client clientTable = null;
            RestAPI api = new RestAPI();

            try {
                JSONParser parser = new JSONParser();
                JSONObject jsonObj = api.GetClientDetais(params[0]);
                // executa apenas se GetClientDetails não retorna objectos
                if(jsonObj.getJSONArray("Value").length() == 0) {
                    jsonObj = api.GetClientCode(params[0]);
                    clientTable = parser.parseClientCode(jsonObj);
                }
                else {
                    clientTable = parser.parseClientDetails(jsonObj);
                }
            } catch (Exception e) {
                Log.d("AsyncClientDetails", e.getMessage());
                Toast.makeText(context, R.string.error_message, Toast.LENGTH_LONG).show();
            }

            return clientTable;
        }

        @Override
        protected void onPostExecute(Client result) {
            double localBalance = result.getSaldo();
            code.setText(result.getCod_cli());
            name.setText(result.getNome());
            String bal = localBalance + "MT";
            balance.setText(bal);
        }

    }
}
