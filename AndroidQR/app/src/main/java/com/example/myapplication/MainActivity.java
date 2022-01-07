package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {

    private Button buttonQRGenerate, buttonQRScan;
    private TextView textViewQRResult;
    private EditText editTextInput;
    private ImageView imageViewOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        buttonQRScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator intentIntegrator = new IntentIntegrator(MainActivity.this);
                intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
                intentIntegrator.setPrompt("QR Code Scanner by Petrik");
                intentIntegrator.setBeepEnabled(false);
                intentIntegrator.initiateScan();
            }
        });

        buttonQRGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String seged = editTextInput.getText().toString();
                if(seged.isEmpty()){
                    Toast.makeText(MainActivity.this, "Üres a mező", Toast.LENGTH_SHORT).show();
                }
                else{
                    MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                    try {
                        BitMatrix bitMatrix = multiFormatWriter.encode(seged, BarcodeFormat.QR_CODE, 500, 500);
                        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                        Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                        imageViewOutput.setImageBitmap(bitmap);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null){
            if(result.getContents() == null) {
                Toast.makeText(MainActivity.this, "Kiléptél a scannelésből", Toast.LENGTH_SHORT).show();
            }
            else{
                textViewQRResult.setText(result.getContents());
                try {
                    Uri uri = Uri.parse(textViewQRResult.getText().toString());
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                catch (Exception e){
                    Log.d("URI ERROR", e.toString());
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void init(){
        buttonQRGenerate.findViewById(R.id.buttonQRGenerate);
        buttonQRScan.findViewById(R.id.buttonQRScan);
        textViewQRResult.findViewById(R.id.textViewQRResult);
        editTextInput.findViewById(R.id.editTextInput);
        imageViewOutput.findViewById(R.id.imageViewOutput);
    }
}