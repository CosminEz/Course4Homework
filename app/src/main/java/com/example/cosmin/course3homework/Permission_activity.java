package com.example.cosmin.course3homework;

        import android.content.pm.PackageManager;
        import android.support.annotation.NonNull;
        import android.support.v4.app.ActivityCompat;
        import android.support.v4.content.ContextCompat;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;

public class Permission_activity extends AppCompatActivity {

    private static final int RECORD_REQUEST_CODE = 1;
    private static final String PHONE_PERMISSION = android.Manifest.permission.CALL_PHONE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission_activity);

        int permission = ContextCompat.checkSelfPermission(this, PHONE_PERMISSION);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            //must have the permission added in manifest     <uses-permission android:name="android.permission.CALL_PHONE"></uses-permission>
            //on new String[]{} you could add many permissions
            ActivityCompat.requestPermissions(this, new String[]{PHONE_PERMISSION}, RECORD_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case RECORD_REQUEST_CODE: {

                if (grantResults.length == 0 || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Log.i("", "Permission has been denied by user");
                } else {
                    Log.i("", "Permission has been granted by user");
                }
            }
        }
    }

}