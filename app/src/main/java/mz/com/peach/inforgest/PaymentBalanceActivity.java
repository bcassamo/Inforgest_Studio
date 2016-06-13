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

import mz.com.peach.inforgest.model.documents.Clidoc;
import mz.com.peach.inforgest.rest.JSONParser;
import mz.com.peach.inforgest.rest.RestAPI;

public class PaymentBalanceActivity extends ActionBarActivity {

    TextView documentNumber, name, date, totalValue, payedValue, balance, valueToPay;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_balance);
        context = this;
        documentNumber = (TextView) findViewById(R.id.txtDocumentNumber);
        name = (TextView) findViewById(R.id.txtDocumentCliName);
        date = (TextView) findViewById(R.id.txtDocumentDate);
        totalValue = (TextView) findViewById(R.id.txtDocumentTotalValue);
        payedValue = (TextView) findViewById(R.id.txtDocumentPayed);
        balance = (TextView) findViewById(R.id.txtDocumentBalance);
        valueToPay = (TextView) findViewById(R.id.edtDocumentToPay);

        Intent intent = getIntent();
        String message = intent.getStringExtra(Intent.EXTRA_TEXT);
        new AsyncPaymentBalance().execute(message);
    }

    protected class AsyncPaymentBalance extends AsyncTask<String, Void, Clidoc> {

        @Override
        protected Clidoc doInBackground(String... params) {
            Clidoc document = null;
            RestAPI api = new RestAPI();

            try{
                JSONParser parser = new JSONParser();
                JSONObject jsonObj = api.GetPendentDocument(params[0]);
                document = parser.parsePaymentBalance(jsonObj);
            } catch (Exception e) {
                Log.d("AsyncPaymentBalance", e.getMessage());
                Toast.makeText(context, R.string.error_message, Toast.LENGTH_LONG).show();
            }

            return document;
        }

        @Override
        protected void onPostExecute(Clidoc document) {
            String localDate = document.getData();
            double localTotalValue = document.getTotaldoc();
            double localPayedValue = document.getValor_pago();
            double localBalance = document.getValor_a_pagar();

            String localTV = localTotalValue + "MT";
            String localPV = localPayedValue + "MT";
            String localB = localBalance + "MT";

            documentNumber.setText(document.getNdoc());
            name.setText(document.getNome_cli());
            date.setText(localDate);
            totalValue.setText(localTV);
            payedValue.setText(localPV);
            balance.setText(localB);
        }
    }
}
