package mz.com.peach.inforgest;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;

import mz.com.peach.inforgest.model.clients.Client;
import mz.com.peach.inforgest.rest.JSONParser;
import mz.com.peach.inforgest.rest.RestAPI;


public class ClientListActivity extends ActionBarActivity implements AdapterView.OnItemClickListener{

    public final static String CLIENT_EXTRA_MESSAGE = "mz.com.peach.inforgest.CLIENT_MESSAGE";
    ArrayAdapter<String> adapter;
    ListView listv;
    Context context;
    ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_list);

        data = new ArrayList<String>();
        listv = (ListView) findViewById(R.id.lvClient);
        context = this;

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, data);
        listv.setAdapter(adapter);
        listv.setOnItemClickListener(this);
        Toast.makeText(context, R.string.load_start, Toast.LENGTH_SHORT).show();
        if(MainActivity.isDeviceOnline(context)) {
            new AsyncLoadClientList().execute();
        }
        else {
            startActivity(new Intent(context, MainActivity.class));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_client_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id){
            case android.R.id.home:
                startActivity(new Intent(context, MainActivity.class));
                return true;

            case R.id.action_settings:
                return true;
        }
        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String itemTouched = adapter.getItem(position);
        int size = itemTouched.length();
        int realPosition = position + 1;
        int numberOfCharinSequence = (realPosition + "").length();
        int numberOfCharToRemove = 3 + numberOfCharinSequence;

        String message = (String) itemTouched.subSequence(numberOfCharToRemove, size);
        //String message = (String) textView.getText().subSequence(4, textView.getText().length());
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(context, ClientDetailActivity.class);
        intent.putExtra(CLIENT_EXTRA_MESSAGE, message);
        startActivity(intent);
    }


    protected class AsyncLoadClientList extends
            AsyncTask<Void, JSONObject, ArrayList<Client>> {
        ArrayList<Client> clientList = null;

        @Override
        protected ArrayList<Client> doInBackground(Void... params) {

            RestAPI api = new RestAPI();
            try {
                JSONObject jsonObj = api.GetClientList();
                JSONParser parser = new JSONParser();

                clientList = parser.parseClientList(jsonObj);
            } catch (Exception e) {
                Log.d("AsyncLoadClientList", e.getMessage());
                Toast.makeText(context, R.string.error_message,Toast.LENGTH_LONG).show();
            }

            return clientList;
        }

        @Override
        protected void onPostExecute(ArrayList<Client> result) {
            // itera a lista de clientes para apresentar no listview
            for (int i = 0; i < result.size(); i++) {
                data.add((i+1) + " - " + result.get(i).getNome());
            }

            adapter.notifyDataSetChanged();

            Toast.makeText(context, R.string.load_complete,Toast.LENGTH_SHORT).show();
        }

    }

}
