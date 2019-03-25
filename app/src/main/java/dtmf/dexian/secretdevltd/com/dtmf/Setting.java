package dtmf.dexian.secretdevltd.com.dtmf;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Setting extends AppCompatActivity {

    EditText ET_settingPhonenumber;
    Button btn_settingSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        ET_settingPhonenumber = findViewById(R.id.ET_settingPhonenumber);
        btn_settingSave = findViewById(R.id.btn_settingSave);


        btn_settingSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String number = ET_settingPhonenumber.getText().toString();

                if(number.length() >=11){
                    storeNumber(number);
                }else{
                    Toast.makeText(getApplicationContext(),"Number not valid",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void storeNumber(String number){
        SharedPreferences mSharedPreferences = getSharedPreferences("PhoneNumber", MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        mEditor.putString("number",number);
        mEditor.apply();
    }

    private String getNumber(){
        String num;
        SharedPreferences mSharedPreferences = getSharedPreferences("PhoneNumber", MODE_PRIVATE);
        num =  mSharedPreferences.getString("number","Null");
        return num;
    }

}

