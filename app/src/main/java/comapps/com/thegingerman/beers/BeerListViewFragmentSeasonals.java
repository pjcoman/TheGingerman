package comapps.com.thegingerman.beers;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import comapps.com.thegingerman.R;

/**
 * Created by me on 9/29/2015.
 */
public class BeerListViewFragmentSeasonals extends ListFragment {

    public static final String DEFAULT = "N/A";

    int x = 0;
    private List<BeerListObject> beerObject;
    BeerListViewAdapter adapter;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        return inflater.inflate(R.layout.beerlistfragment, null, false);
    }


    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle bundle = this.getArguments();
        String sentLocation = bundle.getString("location", "");



        List<ParseObject> ob;

        try {
            // Locate the class table named "stansbeers" in Parse.com
            ParseQuery<ParseObject> query = new ParseQuery<>(sentLocation + "drinks").fromLocalDatastore();
            // Locate the column named "name" in Parse.com and order list
            // by ascending


            query.orderByAscending("name").whereEqualTo("group", "SEASONALS");

            ob = query.find();



            beerObject = new ArrayList<>();

            for (ParseObject beers : ob) {
                // Locate images in flag column



                BeerListObject beer = new BeerListObject();
                beer.setBeerName((String) beers.get("name"));
                beer.setBeerABV(beers.getDouble("abv"));
                beer.setGroup((String) beers.get("group"));
                beer.setBeerStyle((String) beers.get("style"));
                beer.setBeerWhereFrom((String) beers.get("wherefrom"));
                beer.setBeerPrice(beers.getDouble("price"));
                beerObject.add(beer);
            }


        } catch (ParseException e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        adapter = new BeerListViewAdapter(getActivity(), beerObject);
        setListAdapter(adapter);


    }



    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getListView().setDivider(new ColorDrawable(Color.WHITE));
        getListView().setDividerHeight(5);
    }


}

