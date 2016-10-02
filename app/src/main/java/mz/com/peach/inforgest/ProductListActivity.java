package mz.com.peach.inforgest;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;

import mz.com.peach.inforgest.model.Product;
import mz.com.peach.inforgest.rest.JSONParser;
import mz.com.peach.inforgest.rest.RestAPI;


public class ProductListActivity extends ActionBarActivity implements AdapterView.OnItemClickListener{

    public final static String PRODUCT_EXTRA_MESSAGE = "mz.com.peach.inforgest.PRODUCT_MESSAGE";
    ArrayAdapter<String> adapter;
    ListView listv;
    Context context;
    ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        data = new ArrayList<String>();
        listv = (ListView) findViewById(R.id.lvProduct);
        context = this;

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, data);
        listv.setAdapter(adapter);
        listv.setOnItemClickListener(this);
        /*registerForContextMenu(listv);*/

        Toast.makeText(this, R.string.load_start, Toast.LENGTH_SHORT).show();
        if(MainActivity.isDeviceOnline(context)) {
            new AsyncLoadProductList().execute();
        } else {
            startActivity(new Intent(context, MainActivity.class));
        }
    }

    /*@Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context_product_list, menu);
    }*/



    /*@Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.edit_product:
                //editProduct(info.id);
                return true;
            case R.id.details_product:
                detailsProduct(info.id);
                return true;
            case R.id.prices_product:
                //pricesProduct
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
    private void detailsProduct(long id){
        String a = (String) listv.getItemAtPosition((int)id);
        String [] b = a.split(" - ", 2);

        //Toast.makeText(context, b[1],Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, ProductActivity.class);
        intent.putExtra("desig", b[1]);
        startActivity(intent);
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_product_list, menu);
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

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView textView = (TextView) view;
        int realPosition = position + 1;
        int numberOfCharinSequence = (realPosition + "").length();
        int numberOfCharToRemove = 3 + numberOfCharinSequence;

        String message = (String) textView.getText().subSequence(numberOfCharToRemove, textView.getText().length());
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(context, ProductDetailsActivity.class);
        intent.putExtra(PRODUCT_EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    protected class AsyncLoadProductList extends
            AsyncTask<Void, JSONObject, ArrayList<Product>> {
        ArrayList<Product> productList = null;

        @Override
        protected ArrayList<Product> doInBackground(Void... params) {

            RestAPI api = new RestAPI();
            try {

                JSONObject jsonObj = api.GetProductList();

                JSONParser parser = new JSONParser();

                productList = parser.parseProductList(jsonObj);

            } catch (Exception e) {
                Log.d("AsyncLoadProductList", e.getMessage());
                Toast.makeText(context, R.string.error_message,Toast.LENGTH_LONG).show();
            }

            return productList;
        }

        @Override
        protected void onPostExecute(ArrayList<Product> result) {

            // itera a lista de produtos para apresentar no listview
            for (int i = 0; i < result.size(); i++) {
                data.add((i+1) + " - " + result.get(i).getDesignation());
            }

            adapter.notifyDataSetChanged();

            Toast.makeText(context, R.string.load_complete,Toast.LENGTH_SHORT).show();
        }

    }
}
