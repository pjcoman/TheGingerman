package comapps.com.thegingerman.beers;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import comapps.com.thegingerman.R;

/**
 * Created by me on 9/29/2015.
 */
public class BeerListViewAdapter extends BaseAdapter {


    Context context;
    List<BeerListObject> beerObject;


    public BeerListViewAdapter(Context context, List<BeerListObject> beerObject) {

        this.context = context;
        this.beerObject = beerObject;

    }


    @Override
    public int getCount() {
        return beerObject.size();
    }

    @Override
    public Object getItem(int position) {
        return beerObject.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;


        if (view == null) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.beerlistrow, parent, false);

            holder = new ViewHolder();
            holder.name = (TextView) view.findViewById(R.id.nameTxt);
            holder.style = (TextView) view.findViewById(R.id.styleTxt);
            holder.wherefrom = (TextView) view.findViewById(R.id.wherefromTxt);
            holder.abv = (TextView) view.findViewById(R.id.abvTxt);
            holder.price = (TextView) view.findViewById(R.id.priceTxt);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }



        BeerListObject object = beerObject.get(position);

        holder.name.setText(object.getBeerName());
        holder.style.setText(object.getBeerStyle());
        holder.wherefrom.setText(object.getBeerWhereFrom());


        if (object.getBeerABV() == 0.0) {
            holder.abv.setText("a.b.v varies");
        } else {
            holder.abv.setText("a.b.v " + object.getBeerABV().toString());
        }

        Double pricetemp = object.getBeerPrice();
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        String pricetemp2 = format.format(pricetemp);


        if ( pricetemp == 0.0 ) {
            holder.price.setVisibility(View.GONE);

        } else {

            holder.price.setText(pricetemp2);
            holder.price.setVisibility(View.VISIBLE);

        }

        //holder.price.setText("$" + String.format("%.2f", pricetemp));

        Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/Garamond-Premier-Pro_19595.ttf");
        holder.name.setTypeface(font);
        holder.style.setTypeface(font);
        holder.wherefrom.setTypeface(font);
        holder.abv.setTypeface(font);
        holder.price.setTypeface(font);


     //   Picasso.with(context).load(object.getImage()).resize(200, 400).into(holder.image);

        return view;


    }


    public static class ViewHolder {
        TextView name;
        TextView style;
        TextView wherefrom;
        TextView abv;
        TextView price;
    }


}