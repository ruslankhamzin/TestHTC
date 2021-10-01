package ru.startandroid.develop.testhtc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;

import ru.startandroid.develop.testhtc.utils.NetworkUtils;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv;
    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      tv=(TextView) findViewById(R.id.tv);
      bt = (Button) findViewById(R.id.button);
      bt.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        URL generatedURL=NetworkUtils.getURL();
        String response = null;
        try {
            response = NetworkUtils.getResponseFromURL(generatedURL);
        } catch (IOException e) {
            e.printStackTrace();
        }
        tv.setText(response);
    }
}