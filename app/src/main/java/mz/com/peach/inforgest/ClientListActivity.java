package mz.com.peach.inforgest;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;

import mz.com.peach.inforgest.model.clients.Client;
import mz.com.peach.inforgest.rest.JSONParser;
import mz.com.peach.inforgest.rest.RestAPI;


public class ClientListActivity extends ActionBarActivity {

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
        Toast.makeText(this, "Loading Please Wait..", Toast.LENGTH_SHORT).show();
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


    protected class AsyncLoadClientList extends
            AsyncTask<Void, JSONObject, ArrayList<Client>> {
        ArrayList<Client> deptTable = null;

        @Override
        protected ArrayList<Client> doInBackground(Void... params) {
            // TODO Auto-generated method stub

            RestAPI api = new RestAPI();
            try {

                JSONObject jsonObj = api.GetClientList();

                JSONParser parser = new JSONParser();

                deptTable = parser.parseClientList(jsonObj);

            } catch (Exception e) {
                // TODO Auto-generated catch block
                Log.d("AsyncLoadClientList", e.getMessage());

            }

            return deptTable;
        }

        @Override
        protected void onPostExecute(ArrayList<Client> result) {
            // TODO Auto-generated method stub

            Toast.makeText(context,"Loading Post",Toast.LENGTH_SHORT).show();

            for (int i = 0; i < result.size(); i++) {
                data.add(result.get(i).getCod_cli() + " " + result.get(i).getNome());
            }

            adapter.notifyDataSetChanged();

            Toast.makeText(context,"Loading Completed",Toast.LENGTH_SHORT).show();
        }

    }

}
