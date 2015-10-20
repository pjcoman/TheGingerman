package comapps.com.thegingerman;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import comapps.com.thegingerman.beers.BeerViewPager;
import comapps.com.thegingerman.drinks.DrinkViewPager;
import comapps.com.thegingerman.menu.MenuViewPager;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    static final String TAG = "GINGERMANAPP";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Garamond-Premier-Pro_19595.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        Bundle location = getIntent().getExtras();
        if ( location == null) {
            return;
        }

        String sentlocation = location.getString("location");
        Log.i(TAG, "The sent location is " + sentlocation);


        LinearLayout ll = (LinearLayout)findViewById(R.id.contentMain);

        switch (sentlocation) {
            case "lakewood":
                ll.setBackgroundResource(R.drawable.frntlakewoodnoname);
                break;
            case "uptown":
                ll.setBackgroundResource(R.drawable.frntuptownnoname);
                break;
            case "plano":
                ll.setBackgroundResource(R.drawable.frntplanononame);
                break;
            case "southlake":
                ll.setBackgroundResource(R.drawable.frntsouthlakenoname);
                break;
            case "ftworth":
                ll.setBackgroundResource(R.drawable.frntftworthnoname);
                break;
            case "austin":
                ll.setBackgroundResource(R.drawable.frntaustinnoname);
                break;
            case "houston":
                ll.setBackgroundResource(R.drawable.frnthoustonnoname);
                break;


        }






 /*       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });  */
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);


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
            Intent callIntent = new Intent(Intent.ACTION_VIEW);

            Bundle location = getIntent().getExtras();
            String sentlocation = location.getString("location");
            Log.i(TAG, "The sent location is " + sentlocation);

            switch (sentlocation) {
                case "lakewood":
                    callIntent.setData(Uri.parse("tel:4696071114"));
                    break;
                case "uptown":
                    callIntent.setData(Uri.parse("tel:2147548771"));
                    break;
                case "plano":
                    callIntent.setData(Uri.parse("tel:4698148299"));
                    break;
                case "southlake":
                    callIntent.setData(Uri.parse("tel:8177788846"));
                    break;
                case "ftworth":
                    callIntent.setData(Uri.parse("tel:8178862327"));
                    break;
                case "austin":
                    callIntent.setData(Uri.parse("tel:5124738801"));
                    break;
                case "houston":
                    callIntent.setData(Uri.parse("tel:7135262770"));
                    break;
            }

            startActivity(callIntent);


            return true;
        }







        if (id == R.id.action_settings2) {
            Intent intent3 = new Intent(android.content.Intent.ACTION_SEND);
            Bundle location = getIntent().getExtras();
            String sentlocation = location.getString("location");
            Log.i(TAG, "The sent location is " + sentlocation);
            switch (sentlocation) {
                case "lakewood":
                    intent3.setType("text/plain");String[] address = {"gm-lakewood@thegingerman.com"};
                    intent3.putExtra(android.content.Intent.EXTRA_EMAIL, address);
                    break;
                case "uptown":
                    intent3.setType("text/plain");String[] address2 = {"gm-dallas@thegingerman.com"};
                    intent3.putExtra(android.content.Intent.EXTRA_EMAIL, address2);
                    break;
                case "plano":
                    intent3.setType("text/plain");String[] address3 = {"gm-plano@thegingerman.com"};
                    intent3.putExtra(android.content.Intent.EXTRA_EMAIL, address3);
                    break;
                case "southlake":
                    intent3.setType("text/plain");String[] address4 = {"gm-southlake@thegingerman.com"};
                    intent3.putExtra(android.content.Intent.EXTRA_EMAIL, address4);
                    break;
                case "ftworth":
                    intent3.setType("text/plain");String[] address5 = {"gm-ftworth@thegingerman.com"};
                    intent3.putExtra(android.content.Intent.EXTRA_EMAIL, address5);
                    break;
                case "austin":
                    intent3.setType("text/plain");String[] address6 = {"gm-austin@thegingerman.com"};
                    intent3.putExtra(android.content.Intent.EXTRA_EMAIL, address6);
                    break;
                case "houston":
                    intent3.setType("text/plain");String[] address7 = {"gm-houston@thegingerman.com"};
                    intent3.putExtra(android.content.Intent.EXTRA_EMAIL, address7);
                    break;
            }

            intent3.putExtra(android.content.Intent.EXTRA_SUBJECT, "subject");
            intent3.putExtra(android.content.Intent.EXTRA_TEXT, "text");
            startActivityForResult((Intent.createChooser(intent3, "Email")), 1);

            return true;
        }

        if (id == R.id.action_settings3) {

            Bundle location = getIntent().getExtras();
            String sentlocation = location.getString("location");
            Log.i(TAG, "The sent location is " + sentlocation);

            switch (sentlocation) {
                case "lakewood":

            try{

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/558295447623408"));
                startActivity(intent);

            }catch(Exception e){

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/558295447623408")));

            }
                    break;

                case "uptown":
                    try{

                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/104427349625373"));
                        startActivity(intent);

                    }catch(Exception e){

                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/104427349625373")));

                    }
                    break;
                case "plano":
                    try{

                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/116505655088895"));
                        startActivity(intent);

                    }catch(Exception e){

                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/116505655088895")));

                    }
                    break;
                case "southlake":
                    try{

                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/141428856257"));
                        startActivity(intent);

                    }catch(Exception e){

                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/141428856257")));

                    }
                    break;
                case "ftworth":
                    try{

                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/415526105168465"));
                        startActivity(intent);

                    }catch(Exception e){

                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/415526105168465")));

                    }
                    break;
                case "austin":
                    try{

                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/661942360500799"));
                        startActivity(intent);

                    }catch(Exception e){

                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/661942360500799")));

                    }
                    break;
                case "houstonn":
                    try{

                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/328246230606205"));
                        startActivity(intent);

                    }catch(Exception e){

                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/328246230606205")));

                    }
                    break;
            }



            return true;
        }



        if (id == R.id.action_settings5) {

            Bundle location = getIntent().getExtras();
            String sentlocation = location.getString("location");
            Log.i(TAG, "The sent location is " + sentlocation);

            Intent intent;
            String username = "";

            switch (sentlocation) {
                case "lakewood":
                    username = "GingerManLW";
                    break;
                case "uptown":
                    username = "GingerManDallas";
                    break;
                case "plano":
                    username = "PlanoGingerMan";
                    break;
                case "southlake":
                    username = "GingerManSL";
                    break;
                case "ftworth":
                    username = "GingerManFW";
                    break;
                case "austin":
                    username = "AustinGingerMan";
                    break;
                case "houston":
                    username = "Gman_Houston";
                    break;
            }

            try {
                // get the Twitter app if possible
                this.getPackageManager().getPackageInfo("com.twitter.android", 0);
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=" + username));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            } catch (Exception e) {
                // no Twitter app, revert to browser
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/" + username));
            }
            this.startActivity(intent);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }



    public void beerlist(View v) {

        Bundle location = getIntent().getExtras();
        if ( location == null) {
            return;
        }

        String sentlocation = location.getString("location");
        Log.i(TAG, "The sent location is " + sentlocation);



        Intent intentBeer = new Intent();
        intentBeer.setClass(this, BeerViewPager.class);
        intentBeer.putExtra("location", sentlocation);
        startActivity(intentBeer);
    }

    public void drinklist(View v) {

        Bundle location = getIntent().getExtras();
        if ( location == null) {
            return;
        }

        String sentlocation = location.getString("location");
        Log.i(TAG, "The sent location is " + sentlocation);


        Intent intentDrink = new Intent();
        intentDrink.setClass(this, DrinkViewPager.class);
        intentDrink.putExtra("location", sentlocation);
        startActivity(intentDrink);
    }



    public void menulist(View v) {

        Bundle location = getIntent().getExtras();
        if ( location == null) {
            return;
        }

        String sentlocation = location.getString("location");
        Log.i(TAG, "The sent location is " + sentlocation);

        Intent intentMenu = new Intent();
        intentMenu.setClass(this, MenuViewPager.class);
        intentMenu.putExtra("location", sentlocation);
        startActivity(intentMenu);
    }

    @Override
    protected void attachBaseContext(Context newBase) {

        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));

    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        finish();


    }

}
