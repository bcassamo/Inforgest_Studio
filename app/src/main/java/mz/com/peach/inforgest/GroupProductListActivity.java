package mz.com.peach.inforgest;

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
import mz.com.peach.inforgest.model.archive.ProductGroup;


public class GroupProductListActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    private InforgestDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_product_list);

        dao = new InforgestDAO(this);

        List<ProductGroup> productGroups = dao.listProductGroup();
        List<String> lista = new ArrayList<String>();

        for (ProductGroup productGroup : productGroups) {
            lista.add(productGroup.getDescription());
        }

        ListView listView = (ListView) findViewById(R.id.list_prod_grp);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista));

        //setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista));

        /*if(savedInstanceState == null){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            Floatin
        }*/
    }

    @Override
    protected void onResume() {
        dao = new InforgestDAO(this);
        super.onResume();
        List<ProductGroup> productGroups = dao.listProductGroup();
        List<String> lista = new ArrayList<String>();

        for (ProductGroup productGroup : productGroups) {
            lista.add(productGroup.getDescription());
        }

        ListView listView = (ListView) findViewById(R.id.list_prod_grp);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_group_product_list, menu);
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
            case R.id.action_prod_group_new:
                startActivity(new Intent(this, NewProductGroupActivity.class));
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
