package com.willoughby.goalie;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.willoughby.goalie.db.gen.DaoMaster;
import com.willoughby.goalie.db.gen.DaoSession;
import com.willoughby.goalie.db.gen.HabitualGoal;
import com.willoughby.goalie.db.gen.HabitualGoalDao;

import java.util.Date;
import java.util.List;


/**
 * An activity representing a list of Goals. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link GoalDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 * <p>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link GoalListFragment} and the item details
 * (if present) is a {@link GoalDetailFragment}.
 * <p>
 * This activity also implements the required
 * {@link GoalListFragment.Callbacks} interface
 * to listen for item selections.
 */
public class GoalListActivity extends FragmentActivity
        implements GoalListFragment.Callbacks {

    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private List<HabitualGoal> habitualGoals;

    private HabitualGoalDao habitualGoalDao;
    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_list);

        daoMaster = ((GoalieApp)this.getApplication()).daoMaster;
        daoSession = ((GoalieApp)this.getApplication()).daoSession;


        habitualGoalDao= daoSession.getHabitualGoalDao();

        if (findViewById(R.id.goal_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;

            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
            ((GoalListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.goal_list))
                    .setActivateOnItemClick(true);
        }

        // TODO: If exposing deep links into your app, handle intents here.
        // As we are in development we will use the DevOpenHelper which drops the database on a schema update


        String noteText = "My note";
        String comment = "My Comment";
/*
        // [C]reate
        Note note = new Note(null, noteText, comment, new Date());
        noteDao.insert(note);
        System.out.println("Inserted: " + note.getId());
        // [R]ead
        noteDao.load(1l);
        */
        //noteDao.loadAll();
        // [U]pdate
        //note.setComment("This is a new comment");
        //noteDao.update(note);
        // [D]elete
        //noteDao.delete(note);
        //noteDao.deleteAll();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.goal_list_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_tapped:
                //public HabitualGoal(Long id, String color, Integer defaultCellType, java.util.Date dueDate, Integer goal, Float priority, java.util.Date startDate, java.util.Date taskCompleted, String title, String type) {
                HabitualGoal hg = new HabitualGoal(null, String.valueOf(Color.RED), 0, null, 1, 1.0f, new Date(), null, "Floss", "Daily");
                habitualGoalDao.insert(hg);
                //habitualGoals.add(hg);
                System.out.println("Inserted: " + hg.getId());
                onItemSelected(hg.getId());

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Callback method from {@link GoalListFragment.Callbacks}
     * indicating that the item with the given ID was selected.
     * @param id
     */
    @Override
    public void onItemSelected(Long id) {
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putLong(GoalDetailFragment.ARG_ITEM_ID, id);
            GoalDetailFragment fragment = new GoalDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.goal_detail_container, fragment)
                    .commit();

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, GoalDetailActivity.class);
            detailIntent.putExtra(GoalDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }
}
