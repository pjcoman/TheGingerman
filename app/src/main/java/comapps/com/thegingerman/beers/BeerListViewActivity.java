package comapps.com.thegingerman.beers;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import comapps.com.thegingerman.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by me on 9/29/2015.
 */
public class BeerListViewActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beerlist_with_fragment);


    }





    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));

    }


}

