package comapps.com.thegingerman.beers;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import comapps.com.thegingerman.R;

/**
 * Created by me on 9/29/2015.
 */
public class BeerListViewFragmentDraughts extends ListFragment {

    static final String TAG = "GINGERMANAPP";

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
        Log.i(TAG, "The sent location is " + sentLocation);

        List<ParseObject> ob;

        try {
            // Locate the class table named "stansbeers" in Parse.com
            ParseQuery<ParseObject> query = new ParseQuery<>(sentLocation + "drinks").fromLocalDatastore();
            // Locate the column named "name" in Parse.com and order list
            // by ascending


            query.whereEqualTo("group", "DRAUGHT");

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
    public void onListItemClick(ListView l, View v, int position, long id) {

        x = x + 1;

        if (x == 10) {

            x = 0;

        }

        String[] toastSort = new String[10];
        toastSort[0] = "Sorted by style Ascending";
        toastSort[1] = "by style descending";
        toastSort[2] = "by A.B.V ascending";
        toastSort[3] = "by A.B.V descending";
        toastSort[4] = "by where from ascending";
        toastSort[5] = "by where from descending";
        toastSort[6] = "by price ascending";
        toastSort[7] = "by price descending";
        toastSort[8] = "by name ascending";
        toastSort[9] = "by name descending";

        String tm = toastSort[x];

        Toast sort = Toast.makeText(getActivity(), tm, Toast.LENGTH_LONG);
        sort.setGravity(Gravity.CENTER, 0, 0);
        sort.show();

        Bundle bundle = this.getArguments();
        String sentLocation = bundle.getString("location", "");
        Log.i(TAG, "The sent location is " + sentLocation);

        List<ParseObject> ob;

        try {
            // Locate the class table named "stansbeers" in Parse.com
            ParseQuery<ParseObject> query = new ParseQuery<>(
                    sentLocation + "drinks").fromLocalDatastore();
            // Locate the column named "name" in Parse.com and order list
            // by ascending

            query.whereEqualTo("group", "DRAUGHT");



            switch (x) {
                case 0:
                    query.orderByAscending("style");
                    break;
                case 1:
                    query.orderByDescending("style");
                    break;
                case 2:
                    query.orderByAscending("abv");
                    break;
                case 3:
                    query.orderByDescending("abv");
                    break;
                case 4:
                    query.orderByAscending("wherefrom");
                    break;
                case 5:
                    query.orderByDescending("wherefrom");
                    break;
                case 6:
                    query.orderByAscending("price");
                    break;
                case 7:
                    query.orderByDescending("price");
                    break;
                case 8:
                    query.orderByAscending("name");
                    break;
                case 9:
                    query.orderByDescending("name");
                    break;
            }


            ob = query.find();



            beerObject = new ArrayList<>();

            for (ParseObject beers : ob) {
                // Locate images in flag column

                //   ParseFile image = (ParseFile) stansbeers.get("image");



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

        adapter.notifyDataSetChanged();


    }



    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getListView().setDivider(new ColorDrawable(Color.WHITE));
        getListView().setDividerHeight(5);
    }


    }





