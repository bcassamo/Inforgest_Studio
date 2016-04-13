package mz.com.peach.inforgest;

import android.content.Context;
import android.content.Intent;
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
        Toast.makeText(this, R.string.load_start, Toast.LENGTH_SHORT).show();
        new AsyncLoadClientList().execute();
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView textView = (TextView) view;
        String mensagem = (String) textView.getText();
        Toast.makeText(getApplicationContext(), mensagem,
                Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, ClientDetailActivity.class));
    }


    protected class AsyncLoadClientList extends
            AsyncTask<Void, JSONObject, ArrayList<Client>> {
        ArrayList<Client> deptTable = null;

        @Override
        protected ArrayList<Client> doInBackground(Void... params) {

            RestAPI api = new RestAPI();
            try {

                JSONObject jsonObj = api.GetClientList();

                JSONParser parser = new JSONParser();

                deptTable = parser.parseClientList(jsonObj);

            } catch (Exception e) {
                Log.d("AsyncLoadClientList", e.getMessage());
                Toast.makeText(context, R.string.error_message,Toast.LENGTH_LONG).show();
            }

            return deptTable;
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
