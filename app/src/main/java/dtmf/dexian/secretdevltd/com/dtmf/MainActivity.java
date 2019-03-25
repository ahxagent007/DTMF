package dtmf.dexian.secretdevltd.com.dtmf;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {


    private static final int REQUEST_PHONE_CALL = 1;
    private static final int REQUEST_SEND_SMS = 1;
    private static final String TAG = "XIAN";

    ImageView IV_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String number = "01673398900";
        final String dtmfTones = "1";

        IV_menu = findViewById(R.id.IV_menu);




    }

    public void btnSendMessage(View v){
        switch (v.getId()){
            case R.id.btn_lock:
                //sendSMS(number,"TESTING MESSAGE FROM APP");
                break;
        }
    }
    public void btnSendCall(View v){
        switch (v.getId()){
            case R.id.btn_call0:
                //sendSMS(number,"TESTING MESSAGE FROM APP");
                break;
            case R.id.btn_call1:
                //sendSMS(number,"TESTING MESSAGE FROM APP");
                break;
            case R.id.btn_call2:
                //sendSMS(number,"TESTING MESSAGE FROM APP");
                break;
            case R.id.btn_call3:
                //sendSMS(number,"TESTING MESSAGE FROM APP");
                break;
            case R.id.btn_call4:
                //sendSMS(number,"TESTING MESSAGE FROM APP");
                break;
            case R.id.btn_call5:
                //sendSMS(number,"TESTING MESSAGE FROM APP");
                break;
            case R.id.btn_call6:
                //sendSMS(number,"TESTING MESSAGE FROM APP");
                break;
            case R.id.btn_call7:
                //sendSMS(number,"TESTING MESSAGE FROM APP");
                break;
            case R.id.btn_call8:
                //sendSMS(number,"TESTING MESSAGE FROM APP");
                break;
            case R.id.btn_call9:
                //sendSMS(number,"TESTING MESSAGE FROM APP");
                break;
            case R.id.btn_call_star:
                //sendSMS(number,"TESTING MESSAGE FROM APP");
                break;
            case R.id.btn_call_hash:
                //sendSMS(number,"TESTING MESSAGE FROM APP");
                break;
        }
    }

    private void sendSMS(String Number, String message){

        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS},REQUEST_SEND_SMS);
            return;
        }

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(Number, null, message, null, null);
    }

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.main_menu, popup.getMenu());
        popup.show();

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.setting:
                        //your code
                        // EX : call intent if you want to swich to other activity
                        Log.i(TAG,"setting");
                        return true;
                    case R.id.about:
                        Log.i(TAG,"about");
                        //your code
                        return true;
                    default:
                        return false;
                }

            }
        });
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu); // set your file name
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {

        switch (item.getItemId()) {
            case R.id.fuck:
                //your code
                // EX : call intent if you want to swich to other activity
                Log.i(TAG,"FUCK");
                return true;
            case R.id.fuck2:
                Log.i(TAG,"FUCK");
                //your code
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/

    private void DTMFcall(String number, String dtmfTones){

        Intent i = new Intent(Intent.ACTION_CALL,
                Uri.parse("tel://" + number + "," + dtmfTones));
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
            return;
        }
        startActivity(i);

    }


}
