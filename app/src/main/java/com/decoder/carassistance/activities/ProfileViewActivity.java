package in.ezepark.carassistance.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.service.notification.StatusBarNotification;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.rey.material.widget.FloatingActionButton;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import in.ezepark.carassistance.R;
import in.ezepark.carassistance.support.AppUtils;

/**
 * Created by Arun Alo on 7/1/2016.
 */
public class ProfileViewActivity extends AppCompatActivity {

    protected Context mctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profileview);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mctx = getApplicationContext();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            Window window = getWindow();

            // clear FLAG_TRANSLUCENT_STATUS flag:
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

            // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

            // finally change the color
            window.setStatusBarColor(ContextCompat.getColor(mctx, R.color.colorPrimaryDark));
        }


        //---Add user's name to the action bar------

        // for card one
        TextView text1= (TextView)findViewById(R.id.title1);
        TextView email= (TextView)findViewById(R.id.email);
        TextView phoneno= (TextView)findViewById(R.id.phoneno);
        TextView address= (TextView)findViewById(R.id.Address);

        // for card two
        TextView text2= (TextView)findViewById(R.id.title2);
        TextView regdno= (TextView)findViewById(R.id.regdno);
        TextView make= (TextView)findViewById(R.id.make);
        TextView model= (TextView)findViewById(R.id.model);

        //set text for card one
        text1.setText("Contact Details");
        email.setText(Html.fromHtml("<b>Email:</b> ")+"name@gmail.com");
        phoneno.setText(Html.fromHtml("<b>Phone No.:</b> ")+"+919123456780");
        address.setText(Html.fromHtml("<b>Address</b> ")+"KP-5, KIIT University, Bhubaneshwar- 751024");

        //set text for card two
        text2.setText("My Car");
        regdno.setText(Html.fromHtml("<b>Regd. No.:</b> ")+"UA 12B 7021");
        make.setText(Html.fromHtml("<b>Make:</b> ")+ "Lamborghini");
        model.setText(Html.fromHtml("<b>Model:</b> ")+"Aventador");

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mctx, EditProfileActivity.class));
            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(ProfileViewActivity.this, MainActivity.class));
        finish();
    }


}
