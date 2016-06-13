package mz.com.peach.inforgest.rest;

import android.text.format.Time;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import mz.com.peach.inforgest.model.Product;
import mz.com.peach.inforgest.model.clients.Client;
import mz.com.peach.inforgest.model.documents.Clidoc;

/**
 * Created by peach on 2/18/15.
 */
public class JSONParser {
    public JSONParser()
    {
        super();
    }

    public ArrayList<Client> parseClientList(JSONObject object)
    {
        ArrayList<Client> arrayList = new ArrayList<Client>();
        try {
            JSONArray jsonArray = object.getJSONArray("Value");
            JSONObject jsonObj = null;
            for(int i = 0; i < jsonArray.length(); i++)
            {
                jsonObj = jsonArray.getJSONObject(i);
                arrayList.add(new Client(jsonObj.getString("cod_cli"), jsonObj.getString("nome")));
            }

        } catch (JSONException e) {
            Log.d("ParseClientList =>", e.getMessage());
        }
        return arrayList;
    }

    public ArrayList<Client> parseCustomerPendentBalance(JSONObject jsonObject) {
        ArrayList<Client> arrayList = new ArrayList<Client>();
        try {
            JSONArray jsonArray = jsonObject.getJSONArray("Value");
            JSONObject jsonObj = null;
            for(int i = 0;i < jsonArray.length(); i++)
            {
                jsonObj = jsonArray.getJSONObject(i);
                arrayList.add(new Client(jsonObj.getString("cod_cli"), jsonObj.getString("nome"), jsonObj.getDouble("saldo")));
            }

        } catch (JSONException e) {
            Log.d("parseCtomerPdentBal =>", e.getMessage());
        }
        return arrayList;
    }

    public Client parseClientDetails(JSONObject object){
        Client client = new Client();
        try {
            JSONObject jsonObj=object.getJSONArray("Value").getJSONObject(0);

            client.setCod_cli(jsonObj.getString("cod_cli"));
            client.setNome(jsonObj.getString("nome"));
            client.setSaldo(jsonObj.getDouble("saldo"));
        } catch (JSONException e) {
            Log.d("ParseClientDetails =>", e.getMessage());
        }

        return client;
    }

    public Client parseClientCode(JSONObject object){
        Client client = new Client();
        try {
            JSONObject jsonObj=object.getJSONArray("Value").getJSONObject(0);

            client.setCod_cli(jsonObj.getString("cod_cli"));
            client.setNome(jsonObj.getString("nome"));
        } catch (JSONException e) {
            Log.d("ParseClientDetails =>", e.getMessage());
        }

        return client;
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
            Log.d("ParseProductList =>", e.getMessage());
        }
        return arrayList;
    }

    public Product parseProductDetails(JSONObject object)
    {
        Product productDetail = new Product();

        try {
            JSONObject jsonObj=object.getJSONArray("Value").getJSONObject(0);

            productDetail.setCod_prod(jsonObj.getString("cod_prod"));
            productDetail.setDesignation(jsonObj.getString("designation"));
            productDetail.setSpecification(jsonObj.getString("specification"));
            productDetail.setPvp_uni(jsonObj.getDouble("pvp_uni"));
            productDetail.setIva(jsonObj.getDouble("iva"));
            productDetail.setPvp_iva(jsonObj.getDouble("pvp_iva"));
            productDetail.setStk_prev(jsonObj.getInt("stk_prev"));
            productDetail.setUni_cx(jsonObj.getInt("uni_cx"));

        } catch (JSONException e) {
            Log.d("ParseProductDetails =>", e.getMessage());
        }

        return productDetail;
    }

    private String getReadableDateString(long time){
        SimpleDateFormat shortenedDateFormat = new SimpleDateFormat("dd MMM yyyy");
        return shortenedDateFormat.format(time);
    }

    public Clidoc parsePaymentBalance(JSONObject object){
        Clidoc document = new Clidoc();
        try {
            JSONObject jsonObject = object.getJSONArray("Value").getJSONObject(0);

            document.setNdoc(jsonObject.getString("ndoc"));
            document.setNome_cli(jsonObject.getString("nome_cli"));

            Time dayTime = new Time();
            int day = Integer.parseInt(jsonObject.getString("data").substring(9, 10));
            int month = Integer.parseInt(jsonObject.getString("data").substring(6, 7));
            int year = Integer.parseInt(jsonObject.getString("data").substring(0, 4));
            dayTime.set(day, (month - 1), year);

            document.setData(getReadableDateString(dayTime.toMillis(true)));
            document.setTotaldoc(jsonObject.getDouble("totaldoc"));
            document.setValor_pago(jsonObject.getDouble("valor_pago"));
            document.setValor_a_pagar(jsonObject.getDouble("valor_a_pagar"));
        }catch (JSONException e){
            Log.d("parsePaymentBalance =>", e.getMessage());
        }

        return document;
    }
}
