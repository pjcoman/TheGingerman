package comapps.com.thegingerman.menu;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import comapps.com.thegingerman.R;


public class MenuListViewAdapter extends BaseAdapter {


    Context context;
    List<MenuListObject> menuObject;


    public MenuListViewAdapter(Context context, List<MenuListObject> menuObject) {

        this.context = context;
        this.menuObject = menuObject;

    }


    @Override
    public int getCount() {
        return menuObject.size();
    }

    @Override
    public Object getItem(int position) {
        return menuObject.get(position);
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
            view = inflater.inflate(R.layout.menulistrow, parent, false);

            holder = new ViewHolder();
            holder.item = (TextView) view.findViewById(R.id.itemTxt);
            holder.decsription = (TextView) view.findViewById(R.id.descTxt);
            holder.price = (TextView) view.findViewById(R.id.priceTxt);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // S
        //
        MenuListObject object = menuObject.get(position);

        holder.item.setText(object.getItem());
        holder.decsription.setText(object.getDescription());
        holder.price.setText(object.getPrice());

        Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/Garamond-Premier-Pro_19595.ttf");
        holder.item.setTypeface(font);
        holder.decsription.setTypeface(font);
        holder.price.setTypeface(font);

        String checkForNull = object.getPrice();
        if ( checkForNull == null ) {
            holder.price.setVisibility(View.GONE);
        } else {
            holder.price.setVisibility(View.VISIBLE);
        }



        String text = object.getGroup();


        switch (text) {
            case ("CHEESEPLATES"):
                holder.item.setTextColor(Color.YELLOW);
              //  holder.other.setVisibility(View.GONE);
                break;
            case ("SALADS"):
                holder.item.setTextColor(Color.GREEN);

                break;
            case ("MENUSPECIALS"):
                holder.item.setTextColor(Color.RED);
                break;

            default:
             //   holder.item.setTextColor(Color.YELLOW);

        }


        return view;


    }


    public class ViewHolder {
        TextView item;
        TextView price;
        TextView decsription;


    }


}