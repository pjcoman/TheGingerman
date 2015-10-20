package comapps.com.thegingerman;

import android.app.Application;

import com.parse.DeleteCallback;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

/**
 * Created by me on 10/6/2015.
 */
public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.enableLocalDatastore(getApplicationContext());

        // Add your initialization code here
        Parse.initialize(this, "ZbYLYTQgssk7QKBtqR2hQ9OGmIIO4asq8hZ6sbB6", "6wLEqg4ItghFlMJ4m7QeR9SLrl8lU44DyPdeLR2x");

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();

        // If you would like all objects to be private by default, remove this line.
        defaultACL.setPublicReadAccess(true);

        ParseACL.setDefaultACL(defaultACL, true);

        //   PushService.setDefaultPushCallback(this, MainActivity.class);


        ParseInstallation.getCurrentInstallation().saveInBackground();



        ParseQuery<ParseObject> queryLakewoodDrinks = new ParseQuery<ParseObject>(
                "lakewooddrinks");
        queryLakewoodDrinks.setLimit(300);

        queryLakewoodDrinks.findInBackground(new FindCallback<ParseObject>() {
            public void done(final List<ParseObject> object, ParseException e) {
                // Remove the previously cached results.
                ParseObject.unpinAllInBackground("lakewooddrinks", new DeleteCallback() {
                    public void done(ParseException e) {
                        // Cache the new results.
                        ParseObject.pinAllInBackground("lakewooddrinks", object);
                    }
                });
            }
        });

        ParseQuery<ParseObject> queryLakewoodMenu = new ParseQuery<ParseObject>(
                "lakewoodmenu");
        // Locate the column named "day" in Parse.com and order list
        // by ascending

        queryLakewoodMenu.findInBackground(new FindCallback<ParseObject>() {
            public void done(final List<ParseObject> object, ParseException e) {
                // Remove the previously cached results.
                ParseObject.unpinAllInBackground("lakewoodmenu", new DeleteCallback() {
                    public void done(ParseException e) {
                        // Cache the new results.
                        ParseObject.pinAllInBackground("lakewoodmenu", object);
                    }
                });
            }
        });

        ParseQuery<ParseObject> queryUptownDrinks = new ParseQuery<ParseObject>(
                "uptowndrinks");
        queryUptownDrinks.setLimit(300);

        queryUptownDrinks.findInBackground(new FindCallback<ParseObject>() {
            public void done(final List<ParseObject> object, ParseException e) {
                // Remove the previously cached results.
                ParseObject.unpinAllInBackground("uptowndrinks", new DeleteCallback() {
                    public void done(ParseException e) {
                        // Cache the new results.
                        ParseObject.pinAllInBackground("uptowndrinks", object);
                    }
                });
            }
        });

        ParseQuery<ParseObject> queryUptownMenu = new ParseQuery<ParseObject>(
                "uptownmenu");
        // Locate the column named "day" in Parse.com and order list
        // by ascending

        queryUptownMenu.findInBackground(new FindCallback<ParseObject>() {
            public void done(final List<ParseObject> object, ParseException e) {
                // Remove the previously cached results.
                ParseObject.unpinAllInBackground("uptownmenu", new DeleteCallback() {
                    public void done(ParseException e) {
                        // Cache the new results.
                        ParseObject.pinAllInBackground("uptownmenu", object);
                    }
                });
            }
        });
        ParseQuery<ParseObject> queryPlanoDrinks = new ParseQuery<ParseObject>(
                "planodrinks");
        queryPlanoDrinks.setLimit(300);

        queryPlanoDrinks.findInBackground(new FindCallback<ParseObject>() {
            public void done(final List<ParseObject> object, ParseException e) {
                // Remove the previously cached results.
                ParseObject.unpinAllInBackground("planoddrinks", new DeleteCallback() {
                    public void done(ParseException e) {
                        // Cache the new results.
                        ParseObject.pinAllInBackground("planodrinks", object);
                    }
                });
            }
        });

        ParseQuery<ParseObject> queryPlanoMenu = new ParseQuery<ParseObject>(
                "planomenu");
        // Locate the column named "day" in Parse.com and order list
        // by ascending

        queryPlanoMenu.findInBackground(new FindCallback<ParseObject>() {
            public void done(final List<ParseObject> object, ParseException e) {
                // Remove the previously cached results.
                ParseObject.unpinAllInBackground("planomenu", new DeleteCallback() {
                    public void done(ParseException e) {
                        // Cache the new results.
                        ParseObject.pinAllInBackground("planomenu", object);
                    }
                });
            }
        });

        ParseQuery<ParseObject> querySouthlakeDrinks = new ParseQuery<ParseObject>(
                "southlakedrinks");
        querySouthlakeDrinks.setLimit(300);

        querySouthlakeDrinks.findInBackground(new FindCallback<ParseObject>() {
            public void done(final List<ParseObject> object, ParseException e) {
                // Remove the previously cached results.
                ParseObject.unpinAllInBackground("southlakedrinks", new DeleteCallback() {
                    public void done(ParseException e) {
                        // Cache the new results.
                        ParseObject.pinAllInBackground("southlakedrinks", object);
                    }
                });
            }
        });

        ParseQuery<ParseObject> querySouthlakeMenu = new ParseQuery<ParseObject>(
                "southlakemenu");
        // Locate the column named "day" in Parse.com and order list
        // by ascending

        querySouthlakeMenu.findInBackground(new FindCallback<ParseObject>() {
            public void done(final List<ParseObject> object, ParseException e) {
                // Remove the previously cached results.
                ParseObject.unpinAllInBackground("southlakemenu", new DeleteCallback() {
                    public void done(ParseException e) {
                        // Cache the new results.
                        ParseObject.pinAllInBackground("southlakemenu", object);
                    }
                });
            }
        });

        ParseQuery<ParseObject> queryFtWorthDrinks = new ParseQuery<ParseObject>(
                "ftworthdrinks");
        queryFtWorthDrinks.setLimit(300);

        queryFtWorthDrinks.findInBackground(new FindCallback<ParseObject>() {
            public void done(final List<ParseObject> object, ParseException e) {
                // Remove the previously cached results.
                ParseObject.unpinAllInBackground("ftworthdrinks", new DeleteCallback() {
                    public void done(ParseException e) {
                        // Cache the new results.
                        ParseObject.pinAllInBackground("ftworthdrinks", object);
                    }
                });
            }
        });

        ParseQuery<ParseObject> queryFtWorthMenu = new ParseQuery<ParseObject>(
                "ftworthmenu");
        // Locate the column named "day" in Parse.com and order list
        // by ascending

        queryFtWorthMenu.findInBackground(new FindCallback<ParseObject>() {
            public void done(final List<ParseObject> object, ParseException e) {
                // Remove the previously cached results.
                ParseObject.unpinAllInBackground("ftworthmenu", new DeleteCallback() {
                    public void done(ParseException e) {
                        // Cache the new results.
                        ParseObject.pinAllInBackground("ftworthmenu", object);
                    }
                });
            }
        });


        ParseQuery<ParseObject> queryAustinDrinks = new ParseQuery<ParseObject>(
                "austindrinks");
        queryAustinDrinks.setLimit(300);

        queryAustinDrinks.findInBackground(new FindCallback<ParseObject>() {
            public void done(final List<ParseObject> object, ParseException e) {
                // Remove the previously cached results.
                ParseObject.unpinAllInBackground("austindrinks", new DeleteCallback() {
                    public void done(ParseException e) {
                        // Cache the new results.
                        ParseObject.pinAllInBackground("austindrinks", object);
                    }
                });
            }
        });

        ParseQuery<ParseObject> queryAustinMenu = new ParseQuery<ParseObject>(
                "austinmenu");
        // Locate the column named "day" in Parse.com and order list
        // by ascending

        queryAustinMenu.findInBackground(new FindCallback<ParseObject>() {
            public void done(final List<ParseObject> object, ParseException e) {
                // Remove the previously cached results.
                ParseObject.unpinAllInBackground("austinmenu", new DeleteCallback() {
                    public void done(ParseException e) {
                        // Cache the new results.
                        ParseObject.pinAllInBackground("austinmenu", object);
                    }
                });
            }
        });

        ParseQuery<ParseObject> queryHoustonDrinks = new ParseQuery<ParseObject>(
                "houstondrinks");
        queryHoustonDrinks.setLimit(300);

        queryHoustonDrinks.findInBackground(new FindCallback<ParseObject>() {
            public void done(final List<ParseObject> object, ParseException e) {
                // Remove the previously cached results.
                ParseObject.unpinAllInBackground("houstondrinks", new DeleteCallback() {
                    public void done(ParseException e) {
                        // Cache the new results.
                        ParseObject.pinAllInBackground("houstondrinks", object);
                    }
                });
            }
        });

        ParseQuery<ParseObject> queryHoustonMenu = new ParseQuery<ParseObject>(
                "houstonmenu");
        // Locate the column named "day" in Parse.com and order list
        // by ascending

        queryHoustonMenu.findInBackground(new FindCallback<ParseObject>() {
            public void done(final List<ParseObject> object, ParseException e) {
                // Remove the previously cached results.
                ParseObject.unpinAllInBackground("houstonmenu", new DeleteCallback() {
                    public void done(ParseException e) {
                        // Cache the new results.
                        ParseObject.pinAllInBackground("houstonmenu", object);
                    }
                });
            }
        });



    }

}
