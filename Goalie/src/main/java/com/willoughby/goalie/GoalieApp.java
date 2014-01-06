package com.willoughby.goalie;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.willoughby.goalie.db.generated.DaoMaster;
import com.willoughby.goalie.db.generated.DaoSession;

import de.greenrobot.event.EventBus;

/**
 * Created by dan on 1/3/14.
 */
public class GoalieApp extends Application {

    public DaoMaster daoMaster;
    public DaoSession daoSession;
    public SQLiteDatabase db;

    public EventBus eventBus;

   @Override
    public void onCreate () {
       DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "goals-db", null);
       // Access the database using the helper
       db = helper.getWritableDatabase();
       // Construct the DaoMaster which brokers DAOs for the Domain Objects
       daoMaster = new DaoMaster(db);
       // Create the session which is a container for the DAO layer and has a cache which will return handles to the same object across multiple queries
       daoSession = daoMaster.newSession();
       eventBus = new EventBus();

    }
}
