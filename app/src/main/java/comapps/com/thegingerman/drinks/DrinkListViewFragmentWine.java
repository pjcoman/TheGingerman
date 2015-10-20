package comapps.com.thegingerman.drinks;


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
public class DrinkListViewFragmentWine extends ListFragment {

    static final String TAG = "GINGERMANAPP";

    public static final String DEFAULT = "N/A";


    private List<DrinkListObject> drinkObject;
    DrinkListViewAdapter adapter;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.drinklistfragment, null, false);

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


            query.orderByAscending("name").whereEqualTo("group", "WINE");

            ob = query.find();

            drinkObject = new ArrayList<>();

            for (ParseObject drinks : ob) {
                // Locate images in flag column

                //  ParseFile image = (ParseFile) stansbeers.get("image");

                DrinkListObject drink = new DrinkListObject();
                drink.setDrinkName((String) drinks.get("name"));
                drink.setDrinkWhereFrom((String) drinks.get("wherefrom"));
                drink.setDrinkABV(drinks.getDouble("abv"));
                drink.setGroup((String) drinks.get("group"));
                drink.setDrinkStyle((String) drinks.get("style"));
                drink.setDrinkPrice(drinks.getDouble("price"));

                //   beer.setBeerImage(image.getUrl());
                drinkObject.add(drink);
            }

        } catch (ParseException e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        adapter = new DrinkListViewAdapter(getActivity(), drinkObject);
        setListAdapter(adapter);


    }



    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getListView().setDivider(new ColorDrawable(Color.WHITE));
        getListView().setDividerHeight(5);
    }


}


















