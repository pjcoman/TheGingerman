package comapps.com.thegingerman.drinks;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerTitleStripV22;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import comapps.com.thegingerman.R;

/**
 * Created by me on 10/6/2015.
 */
public class DrinkViewPager extends AppCompatActivity {

    static final String TAG = "GINGERMANAPP";


    ViewPager viewPager = null;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.viewpagerdrinks);


        Typeface gp = Typeface.createFromAsset(getAssets(), "fonts/Garamond-Premier-Pro_19595.ttf");



        viewPager = (ViewPager) findViewById(R.id.pager);
        PagerTitleStripV22 pts = (PagerTitleStripV22) findViewById(R.id.title);
        pts.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);

        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager.setAdapter(new MyAdapter(fragmentManager));


        Typeface tf = Typeface.createFromAsset(this.getAssets(),
                "fonts/Garamond-Premier-Pro_19595.ttf");


        for (int i = 0; i < pts.getChildCount(); i++) {

            View nextChild = pts.getChildAt(i);
            if (nextChild instanceof TextView) {
                TextView textViewToConvert = (TextView) nextChild;
                textViewToConvert.setTypeface(tf);

            }


        }





    }




    class MyAdapter extends FragmentStatePagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            Bundle location = getIntent().getExtras();
            String sentlocation = location.getString("location");
            Log.i(TAG, "The sent location is " + sentlocation);

            if (position == 0) {

                fragment = new DrinkListViewFragmentCider();
                fragment.setArguments(location);

            }

            if (position == 1) {

                fragment = new DrinkListViewFragmentWine();
                fragment.setArguments(location);
            }
            if (position == 2) {

                fragment = new DrinkListViewFragmentNonAlcoholic();
                fragment.setArguments(location);
            }




            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }


        @Override
        public CharSequence getPageTitle(int position) {

            String[] tabTitles = {"CIDER", "WINE", "NON-ALCOHOLIC"};


            if (position == 0) {

                SpannableStringBuilder sb = new SpannableStringBuilder(" " + tabTitles[position]); // space added before text for convenience
            //    Drawable drawable = getDrawable(R.drawable.beericon);
            //    drawable.setBounds(0, 0, 100, 100);
            //    ImageSpan span = new ImageSpan(drawable, ImageSpan.ALIGN_BASELINE);
            //    sb.setSpan(span, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                return sb;

            }
            if (position == 1) {

                SpannableStringBuilder sb = new SpannableStringBuilder(" " + tabTitles[position]); // space added before text for convenience
             //   Drawable drawable = getDrawable(R.drawable.whiskeyicon);
             //   drawable.setBounds(0, 0, 100, 100);
             //   ImageSpan span = new ImageSpan(drawable, ImageSpan.ALIGN_BASELINE);
             //   sb.setSpan(span, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                return sb;

            }
            if (position == 2) {

                SpannableStringBuilder sb = new SpannableStringBuilder(" " + tabTitles[position]); // space added before text for convenience
             //   Drawable drawable = getDrawable(R.drawable.drinkicon);
             //   drawable.setBounds(0, 0, 100, 100);
             //   ImageSpan span = new ImageSpan(drawable, ImageSpan.ALIGN_BASELINE);
             //   sb.setSpan(span, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                return sb;

            }
            if (position == 3) {

               SpannableStringBuilder sb = new SpannableStringBuilder(" " + tabTitles[position]); // space added before text for convenience
            //    Drawable drawable = getDrawable(R.drawable.menuicon);
            //    drawable.setBounds(0, 0, 100, 100);
            //    ImageSpan span = new ImageSpan(drawable, ImageSpan.ALIGN_BASELINE);
             //   sb.setSpan(span, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                return sb;

            }
            if (position == 4) {

                SpannableStringBuilder sb = new SpannableStringBuilder(" " + tabTitles[position]); // space added before text for convenience
             //   Drawable drawable = getDrawable(R.drawable.specialsicon);
             //   drawable.setBounds(0, 0, 100, 100);
             //   ImageSpan span = new ImageSpan(drawable, ImageSpan.ALIGN_BASELINE);
             //   sb.setSpan(span, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                return sb;

            }
            if (position == 5) {

                SpannableStringBuilder sb = new SpannableStringBuilder(" " + tabTitles[position]); // space added before text for convenience
                //   Drawable drawable = getDrawable(R.drawable.specialsicon);
                //   drawable.setBounds(0, 0, 100, 100);
                //   ImageSpan span = new ImageSpan(drawable, ImageSpan.ALIGN_BASELINE);
                //   sb.setSpan(span, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                return sb;

            }

            if (position == 6) {

                SpannableStringBuilder sb = new SpannableStringBuilder(" " + tabTitles[position]); // space added before text for convenience
                //   Drawable drawable = getDrawable(R.drawable.specialsicon);
                //   drawable.setBounds(0, 0, 100, 100);
                //   ImageSpan span = new ImageSpan(drawable, ImageSpan.ALIGN_BASELINE);
                //   sb.setSpan(span, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                return sb;

            }

            if (position == 7) {

                SpannableStringBuilder sb = new SpannableStringBuilder(" " + tabTitles[position]); // space added before text for convenience
                //   Drawable drawable = getDrawable(R.drawable.specialsicon);
                //   drawable.setBounds(0, 0, 100, 100);
                //   ImageSpan span = new ImageSpan(drawable, ImageSpan.ALIGN_BASELINE);
                //   sb.setSpan(span, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                return sb;

            }

            if (position == 8) {

                SpannableStringBuilder sb = new SpannableStringBuilder(" " + tabTitles[position]); // space added before text for convenience
                //   Drawable drawable = getDrawable(R.drawable.specialsicon);
                //   drawable.setBounds(0, 0, 100, 100);
                //   ImageSpan span = new ImageSpan(drawable, ImageSpan.ALIGN_BASELINE);
                //   sb.setSpan(span, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                return sb;

            }

            return null;
        }


    }


}

