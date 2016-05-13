package mz.com.peach.inforgest;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import mz.com.peach.inforgest.model.Product;
import mz.com.peach.inforgest.rest.JSONParser;
import mz.com.peach.inforgest.rest.RestAPI;

public class ProductDetailsActivity extends ActionBarActivity {

    TextView code, designation, specification, price, iva;
    TextView pvp_iva, stk_prev, uni_cx;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        context = this;
        code = (TextView) findViewById(R.id.txtProductDetailsCode);
        designation = (TextView) findViewById(R.id.txtProductDetailsDesignation);
        specification = (TextView) findViewById(R.id.txtProductDetailsSpecification);
        price = (TextView) findViewById(R.id.txtProductDetailsPrice);
        iva = (TextView) findViewById(R.id.txtProductDetailsIva);
        pvp_iva = (TextView) findViewById(R.id.txtProductDetailsTotal);
        stk_prev = (TextView) findViewById(R.id.txtProductDetailsQuantity);
        uni_cx = (TextView) findViewById(R.id.txtProductDetailsboxunity);

        Intent intent = getIntent();
        String message = intent.getStringExtra(ProductListActivity.PRODUCT_EXTRA_MESSAGE);
        new AsyncProductDetails().execute(message);
    }

    protected class AsyncProductDetails extends AsyncTask<String, Void, Product>{

        @Override
        protected Product doInBackground(String... params) {
            Product product = null;
            RestAPI api = new RestAPI();

            try {
                JSONParser parser = new JSONParser();
                JSONObject jsonObject = api.GetProductDetails(params[0]);
                product = parser.parseProductDetails(jsonObject);
            }catch (Exception e){
                Log.d("AsyncProductDetails", e.getMessage());
                Toast.makeText(context, R.string.error_message, Toast.LENGTH_LONG).show();
            }

            return product;
        }

        @Override
        protected void onPostExecute(Product product) {
            double localPrice = product.getPvp_uni();
            double localIva = product.getIva();
            double localPvpIva = product.getPvp_iva();

            code.setText(product.getCod_prod());
            designation.setText(product.getDesignation());
            specification.setText(product.getSpecification());
            price.setText(localPrice + "MT");
            iva.setText(localIva + "MT");
            pvp_iva.setText(localPvpIva + "MT");
            stk_prev.setText(product.getStk_prev() + "");
            uni_cx.setText(product.getUni_cx() + "");
        }
    }
}
