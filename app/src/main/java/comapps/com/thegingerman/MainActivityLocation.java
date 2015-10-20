package comapps.com.thegingerman;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivityLocation extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Garamond-Premier-Pro_19595.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());

        setContentView(R.layout.activity_main_location);








 /*       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });  */
    }







    public void lakewood(View v) {

        Intent intentLakewood = new Intent();
        intentLakewood.setClass(this, MainActivity.class);
        intentLakewood.putExtra("location", "lakewood");
        overridePendingTransition(R.anim.fadeoutanimation,
                R.anim.fadeinanimation);
        startActivity(intentLakewood);
    }

    public void uptown(View v) {

        Intent intentUptown = new Intent();
        intentUptown.setClass(this, MainActivity.class);
        intentUptown.putExtra("location", "uptown");
        overridePendingTransition(R.anim.fadeoutanimation,
                R.anim.fadeinanimation);
        startActivity(intentUptown);
    }



    public void plano(View v) {

        Intent intentPlano = new Intent();
        intentPlano.setClass(this, MainActivity.class);
        intentPlano.putExtra("location", "plano");
        overridePendingTransition(R.anim.fadeoutanimation,
                R.anim.fadeinanimation);
        startActivity(intentPlano);
    }

    public void southlake(View v) {

        Intent intentSouthlake = new Intent();
        intentSouthlake.setClass(this, MainActivity.class);
        intentSouthlake.putExtra("location", "southlake");
        startActivity(intentSouthlake);
    }

    public void ftworth(View v) {

        Intent intentFtworth = new Intent();
        intentFtworth.setClass(this, MainActivity.class);
        intentFtworth.putExtra("location", "ftworth");
        overridePendingTransition(R.anim.fadeoutanimation,
                R.anim.fadeinanimation);
        startActivity(intentFtworth);
    }


    public void austin(View v) {

        Intent intentAustin = new Intent();
        intentAustin.setClass(this, MainActivity.class);
        intentAustin.putExtra("location", "austin");
        overridePendingTransition(R.anim.fadeoutanimation,
                R.anim.fadeinanimation);
        startActivity(intentAustin);
    }

    public void houston(View v) {

        Intent intentHtown = new Intent();
        intentHtown.setClass(this, MainActivity.class);
        intentHtown.putExtra("location", "houston");
        overridePendingTransition(R.anim.fadeoutanimation,
                R.anim.fadeinanimation);
        startActivity(intentHtown);
    }

    @Override
    protected void attachBaseContext(Context newBase) {

        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));

    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        finish();
        System.exit(0);
    }

}
