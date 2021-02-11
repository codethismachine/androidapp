package edu.gatech.seclass.converter_6300_sample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioButton radioButtonFromKm;
    private RadioButton radioButtonFromMiles;
    private EditText textValue;
    private EditText textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //R contains information about the widgets
        //findViewById can be used to get an object from an id, cast to the right object type
        radioButtonFromKm = (RadioButton) findViewById(R.id.rbFromKm);
        radioButtonFromMiles = (RadioButton) findViewById(R.id.rbFromMiles);
        textValue = (EditText) findViewById(R.id.value);
        textResult= (EditText) findViewById(R.id.result);
    }
    //When a widget onClick is called it is passed to a handler as a View object
    public void handleClick(View view){
        switch (view.getId()){
            case R.id.buttonConvert:
                String result;
                String value = textValue.getText().toString();
                //Error check if value is empty then show a message to the user
                //Toast is like a message box
                if (value.length() == 0){
                    Context context = getApplicationContext();
                    CharSequence text = "Error: empty value!";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }else{
                    if (radioButtonFromMiles.isChecked()){
                        result = milesToKM(value);
                    }
                    else{
                        result = kmToMiles(value);
                    }
                    textResult.setText(result);
                }
                break;
            case R.id.buttonReset:
                radioButtonFromKm.setChecked(true);
                radioButtonFromMiles.setChecked(false);
                textValue.setText("");
                textResult.setText("");
                break;
        }
    }
    private String milesToKM(String miles) {
        double m_value = Double.parseDouble((miles));
        double km_value = m_value * 1.609;
        return String.valueOf(km_value);
    }

    private String kmToMiles(String km){
        double k_value = Double.parseDouble(km);
        double m_value = k_value / 1.609;
        return String.valueOf(m_value);
    }
}