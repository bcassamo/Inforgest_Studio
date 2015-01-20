package mz.com.peach.inforgest;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import mz.com.peach.inforgest.dao.InforgestDAO;
import mz.com.peach.inforgest.model.archive.ProductFamily;


public class NewProductFamilyActivity extends ActionBarActivity {

    private InforgestDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_product_family);
        dao = new InforgestDAO(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_product_family, menu);
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
        EditText productFamilyDescription = (EditText) findViewById(R.id.product_family_description);

        switch (item.getItemId()) {
            case R.id.action_save_product_family:
                saveProductFamily(productFamilyDescription);
                finish();
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void saveProductFamily(EditText prodFamilyDesc){
        String description = prodFamilyDesc.getEditableText().toString();
        ProductFamily family = new ProductFamily();
        family.setDescription(description);
        Log.d("Salvando a familia", family.getDescription());
        dao.saveProductFamily(family);
    }
}
