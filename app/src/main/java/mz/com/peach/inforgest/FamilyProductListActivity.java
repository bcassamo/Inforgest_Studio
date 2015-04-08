package mz.com.peach.inforgest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import mz.com.peach.inforgest.dao.InforgestDAO;
import mz.com.peach.inforgest.model.archive.ProductFamily;


public class FamilyProductListActivity extends ActionBarActivity implements AdapterView.OnItemClickListener{

    private InforgestDAO dao;

    ArrayAdapter<String> adapter;
    ListView listv;
    Context context;
    ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_product_list);

        dao = new InforgestDAO(this);

        List<ProductFamily> productFamilys = dao.listProductFamily();
        List<String> lista =  new ArrayList<String>();
        for (ProductFamily productFamily : productFamilys) {
            lista.add(productFamily.getDescription());
        }

        ListView listView = (ListView) findViewById(R.id.list_prod_fam);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista));
        //setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista));

        /*data = new ArrayList<String>();
        listv = (ListView) findViewById(R.id.list_prod_fam);
        context = this;

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, data);
        listv.setAdapter(adapter);
        Toast.makeText(this, "Loading Please Wait..", Toast.LENGTH_SHORT).show();
        new AsyncLoadProductFamilyDetails().execute();*/

    }


    /*protected class AsyncLoadProductFamilyDetails extends
            AsyncTask<Void, JSONObject, ArrayList<ProductFamily>> {
        ArrayList<ProductFamily> deptTable = null;

        @Override
        protected ArrayList<ProductFamily> doInBackground(Void... params) {
            // TODO Auto-generated method stub

            RestAPI api = new RestAPI();
            try {

                JSONObject jsonObj = api.GetProdFamiliaDetails();

                JSONParser parser = new JSONParser();

                deptTable = parser.parseProductFamilyList(jsonObj);

            } catch (Exception e) {
                // TODO Auto-generated catch block
                Log.d("AsyncLoadDeptDetails", e.getMessage());

            }

            return deptTable;
        }

        @Override
        protected void onPostExecute(ArrayList<ProductFamily> result) {
            // TODO Auto-generated method stub

            for (int i = 0; i < result.size(); i++) {
                data.add(result.get(i).getId() + " " + result.get(i).getDescription());
            }

            adapter.notifyDataSetChanged();

            Toast.makeText(context,"Loading Completed",Toast.LENGTH_SHORT).show();
        }

    }*/

    @Override
    protected void onResume() {
        dao = new InforgestDAO(this);
        super.onResume();
        List<ProductFamily> productFamilys = dao.listProductFamily();
        List<String> lista =  new ArrayList<String>();
        for (ProductFamily productFamily : productFamilys) {
            lista.add(productFamily.getDescription());
        }

        ListView listView = (ListView) findViewById(R.id.list_prod_fam);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista));
        //setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista));

        /*data = new ArrayList<String>();
        listv = (ListView) findViewById(R.id.list_prod_fam);
        context = this;

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, data);
        listv.setAdapter(adapter);
        Toast.makeText(this, "Loading Please Wait..", Toast.LENGTH_SHORT).show();
        new AsyncLoadProductFamilyDetails().execute();*/
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_family_product_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);*/
        switch (item.getItemId()) {
            case R.id.action_prod_family_new:
                startActivity(new Intent(this, NewProductFamilyActivity.class));
                return true;
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
