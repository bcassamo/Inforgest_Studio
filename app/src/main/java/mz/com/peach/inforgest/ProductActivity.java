package mz.com.peach.inforgest;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import mz.com.peach.inforgest.model.Product;
import mz.com.peach.inforgest.rest.JSONParser;
import mz.com.peach.inforgest.rest.RestAPI;


public class ProductActivity extends ActionBarActivity {

    EditText cod_prod, desig, upc, pmc, pmv, p2, p3, p4, spec, exist;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        cod_prod = (EditText) findViewById(R.id.edttxtcod);
        desig = (EditText) findViewById(R.id.edttxtdesig);
        upc = (EditText) findViewById(R.id.edttxtupc);
        /*pmc = (EditText) findViewById(R.id.edttxtpmc);
        pmv = (EditText) findViewById(R.id.edttxtpmv);
        p2 = (EditText) findViewById(R.id.edttxtp2);
        p3 = (EditText) findViewById(R.id.edttxtp3);
        p4 = (EditText) findViewById(R.id.edttxtp4);
        spec = (EditText) findViewById(R.id.edttxtspec);*/
        //exist = (EditText) findViewById(R.id.edttxtspec);

        Intent intent = getIntent();

        String productDescription = intent.getStringExtra("desig");

        Toast.makeText(this, productDescription, Toast.LENGTH_SHORT).show();

        new AsyncLoadProductDetails().execute(productDescription);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_product, menu);
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


    protected class AsyncLoadProductDetails extends AsyncTask<String, Void, Product>
    {

        @Override
        protected Product doInBackground(String... params) {
            // TODO Auto-generated method stub
            Product productDetail=null;
            RestAPI api = new RestAPI();
            try {

                JSONObject jsonObj = api.GetProductDetails(params[0]);
                JSONParser parser = new JSONParser();
                productDetail = parser.parseProductDetails(jsonObj);

            } catch (Exception e) {
                // TODO Auto-generated catch block
                Log.d("AsyncLoadProductDetails", e.getMessage());

            }

            return productDetail;
        }

        @Override
        protected void onPostExecute(Product result) {
            cod_prod.setText(result.getCod_prod());
            desig.setText(result.getDesignation());
            upc.setText((int) result.getUpc());
            /*pmc.setText((int) result.getPmc());
            pmv.setText((int) result.getPmv());
            p2.setText((int) result.getP2());
            p3.setText((int) result.getP3());
            p4.setText((int) result.getP4());
            spec.setText(result.getEspe());*/
            //exist.setText(result.getExist());
        }

    }
}
