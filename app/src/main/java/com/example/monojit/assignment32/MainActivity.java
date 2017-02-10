package com.example.monojit.assignment32;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final int CONTACT_REQUEST=99;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void showContact(View view) {
        Intent showContactIntent = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
        showContactIntent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
        startActivityForResult(showContactIntent,CONTACT_REQUEST);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CONTACT_REQUEST){
            if(resultCode==RESULT_OK){
                Toast.makeText(this, "Contact Select ", Toast.LENGTH_SHORT).show();
            }else
                Toast.makeText(this, "Contact selection was aborted..", Toast.LENGTH_SHORT).show();

        }

    }

}
