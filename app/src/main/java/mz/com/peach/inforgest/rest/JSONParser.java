package mz.com.peach.inforgest.rest;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import mz.com.peach.inforgest.model.Product;
import mz.com.peach.inforgest.model.clients.Client;

/**
 * Created by peach on 2/18/15.
 */
public class JSONParser {
    public JSONParser()
    {
        super();
    }

    /*public ArrayList<ProductFamily> parseProductFamilyList(JSONObject object)
    {
        ArrayList<ProductFamily> arrayList=new ArrayList<ProductFamily>();
        try {
            JSONArray jsonArray=object.getJSONArray("Value");
            JSONObject jsonObj=null;
            for(int i=0;i<jsonArray.length();i++)
            {
                jsonObj=jsonArray.getJSONObject(i);
                arrayList.add(new ProductFamily(jsonObj.getLong("id_prodfam"), jsonObj.getString("desig")));
            }

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            Log.d("JSONParser => parseProductFamilyList", e.getMessage());
        }
        return arrayList;
    }*/

    public ArrayList<Client> parseClientList(JSONObject object)
    {
        ArrayList<Client> arrayList=new ArrayList<Client>();
        try {
            JSONArray jsonArray=object.getJSONArray("Value");
            JSONObject jsonObj=null;
            for(int i=0;i<jsonArray.length();i++)
            {
                jsonObj=jsonArray.getJSONObject(i);
                arrayList.add(new Client(jsonObj.getString("cod_cli"), jsonObj.getString("nome")));
            }

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            Log.d("JSONParser => parseClientList", e.getMessage());
        }
        return arrayList;
    }

    public ArrayList<Product> parseProductList(JSONObject object)
    {
        ArrayList<Product> arrayList=new ArrayList<Product>();
        try {
            JSONArray jsonArray=object.getJSONArray("Value");
            JSONObject jsonObj=null;
            for(int i=0;i<jsonArray.length();i++)
            {
                jsonObj=jsonArray.getJSONObject(i);
                arrayList.add(new Product(jsonObj.getString("cod_prod"), jsonObj.getString("desig")));
            }

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            Log.d("JSONParser => parseProductList", e.getMessage());
        }
        return arrayList;
    }
}
