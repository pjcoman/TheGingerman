package comapps.com.thegingerman.menu;


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
public class MenuListViewFragmentSnacks extends ListFragment {

    static final String TAG = "GINGERMANAPP";

    public static final String DEFAULT = "N/A";


    private List<MenuListObject> menuObject;
    MenuListViewAdapter adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        return inflater.inflate(R.layout.menulistfragment, null, false);
    }


    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle bundle = this.getArguments();
        String sentLocation = bundle.getString("location", "");
        Log.i(TAG, "The sent location is " + sentLocation);




        List<ParseObject> ob;

        try {
            // Locate the class table named "stansbeers" in Parse.com
            ParseQuery<ParseObject> query = new ParseQuery<>(sentLocation + "menu").fromLocalDatastore();
            // Locate the column named "name" in Parse.com and order list
            // by ascending

            query.orderByAscending("sort").whereEqualTo("group", "SNACKS");


            ob = query.find();



            menuObject = new ArrayList<>();

            for (ParseObject menu : ob) {
                // Locate images in flag column



                MenuListObject menuItem = new MenuListObject();
                menuItem.setItem((String) menu.get("item"));
                menuItem.setDescription((String) menu.get("description"));
                menuItem.setGroup((String) menu.get("group"));
                menuItem.setPrice((String) menu.get("price"));
                menuObject.add(menuItem);
            }


        } catch (ParseException e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        adapter = new MenuListViewAdapter(getActivity(), menuObject);
        setListAdapter(adapter);


    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getListView().setDivider(new ColorDrawable(Color.WHITE));
        getListView().setDividerHeight(5);
    }
}



