package comapps.com.thegingerman.drinks;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
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

public class DrinkListViewAdapter extends BaseAdapter {


    Context context;
    List<DrinkListObject> drinkObject;


    public DrinkListViewAdapter(Context context, List<DrinkListObject> drinkObject) {

        this.context = context;
        this.drinkObject = drinkObject;

    }


    @Override
    public int getCount() {
        return drinkObject.size();
    }

    @Override
    public Object getItem(int position) {
        return drinkObject.get(position);
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
            view = inflater.inflate(R.layout.drinklistrow, parent, false);

            holder = new ViewHolder();

            holder.drinkname = (TextView) view.findViewById(R.id.nameTxt);
            holder.drinkwherefrom = (TextView) view.findViewById(R.id.wherefromTxt);
            holder.drinkabv = (TextView) view.findViewById(R.id.abvTxt);
            holder.drinkstyle = (TextView) view.findViewById(R.id.styleTxt);
            holder.drinkprice = (TextView) view.findViewById(R.id.priceTxt);

            //holder.drinkimage = (ImageView) view.findViewById(R.id.drinkimage);

            view.setTag(holder);

        } else {

            holder = (ViewHolder) view.getTag();

        }


        // Set the results into TextViews
        DrinkListObject object = drinkObject.get(position);

        holder.drinkname.setText(object.getDrinkName());
        holder.drinkwherefrom.setText(object.getDrinkWhereFrom());
        holder.drinkstyle.setText(object.getDrinkStyle());
        holder.drinkabv.setText("a.b.v. " + object.getDrinkABV().toString());


        if (object.getDrinkStyle().toString().equals("none")) {
            holder.drinkabv.setVisibility(View.GONE);
            holder.drinkstyle.setVisibility(View.GONE);
            holder.drinkwherefrom.setVisibility(View.GONE);
        } else {
            holder.drinkabv.setVisibility(View.VISIBLE);
            holder.drinkstyle.setVisibility(View.VISIBLE);
            holder.drinkwherefrom.setVisibility(View.VISIBLE);
        }

        if (object.getDrinkABV().toString().equals("0.0")) {
            holder.drinkabv.setVisibility(View.GONE);

        }

        Double pricetemp = object.getDrinkPrice();
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        String pricetemp2 = format.format(pricetemp);


        if (object.getDrinkName().contains("(white)")) {
            holder.drinkname.setTextColor(Color.WHITE);
            holder.drinkabv.setTextColor(Color.WHITE);
            holder.drinkwherefrom.setTextColor(Color.WHITE);
            holder.drinkstyle.setTextColor(Color.WHITE);

        } else if (object.getDrinkName().contains("(red)")) {
            holder.drinkname.setTextColor(Color.RED);
            holder.drinkabv.setTextColor(Color.RED);
            holder.drinkwherefrom.setTextColor(Color.RED);
            holder.drinkstyle.setTextColor(Color.RED);

        } else if (object.getDrinkName().contains("(porto)")) {
            holder.drinkname.setTextColor(Color.parseColor("#FF0080"));
            holder.drinkabv.setTextColor(Color.parseColor("#FF0080"));
            holder.drinkwherefrom.setTextColor(Color.parseColor("#FF0080"));
            holder.drinkstyle.setTextColor(Color.parseColor("#FF0080"));

        } else if (object.getDrinkName().contains("(sparkling)")) {
            holder.drinkname.setTextColor(Color.parseColor("#F7E7CE"));
            holder.drinkabv.setTextColor(Color.parseColor("#F7E7CE"));
            holder.drinkwherefrom.setTextColor(Color.parseColor("#F7E7CE"));
            holder.drinkstyle.setTextColor(Color.parseColor("#F7E7CE"));

        } else if (object.getGroup().contains("CIDER")) {
            holder.drinkname.setTextColor(Color.parseColor("#EDD768"));
            holder.drinkabv.setTextColor(Color.parseColor("#EDD768"));
            holder.drinkwherefrom.setTextColor(Color.parseColor("#EDD768"));
            holder.drinkstyle.setTextColor(Color.parseColor("#EDD768"));

         } else if (object.getGroup().contains("NONALCOHOLIC")) {
            holder.drinkname.setTextColor(Color.WHITE);
            holder.drinkabv.setTextColor(Color.WHITE);
            holder.drinkwherefrom.setTextColor(Color.WHITE);
            holder.drinkstyle.setTextColor(Color.WHITE);

    }

        holder.drinkprice.setText(pricetemp2);




        Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/Garamond-Premier-Pro_19595.ttf");
        holder.drinkname.setTypeface(font);
        holder.drinkwherefrom.setTypeface(font);
        holder.drinkabv.setTypeface(font);
        holder.drinkprice.setTypeface(font);
        holder.drinkstyle.setTypeface(font);

      //  Picasso.with(context).load(object.getDrinkImage()).resize(200, 400).into(holder.drinkimage);

        return view;


    }



    private static class ViewHolder {
        TextView drinkname;
        TextView drinkwherefrom;
        TextView drinkabv;
        TextView drinkstyle;
        TextView drinkprice;


    }


}