package com.willoughby.goalie;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.willoughby.goalie.db.generated.DaoMaster;
import com.willoughby.goalie.db.generated.DaoSession;
import com.willoughby.goalie.db.generated.HabitualGoal;
import com.willoughby.goalie.db.generated.HabitualGoalDao;

/**
 * A fragment representing a single Goal detail screen.
 * This fragment is either contained in a {@link GoalListActivity}
 * in two-pane mode (on tablets) or a {@link GoalDetailActivity}
 * on handsets.
 */
public class GoalDetailFragment extends Fragment {

    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private HabitualGoalDao habitualGoalDao;

    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    private HabitualGoal newlyCreatedOrBeingEditedHabitualGoal;
    private View rootView;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public GoalDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        daoMaster = ((GoalieApp)this.getActivity().getApplication()).daoMaster;
        daoSession = ((GoalieApp)this.getActivity().getApplication()).daoSession;

        habitualGoalDao = daoSession.getHabitualGoalDao();

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            newlyCreatedOrBeingEditedHabitualGoal = habitualGoalDao.load(getArguments().getLong(ARG_ITEM_ID));
        }
    }

    @Override
    public void onPause() {
      super.onPause();
      //String strValue = editText.getText().toString();
      //newlyCreatedOrBeingEditedHabitualGoal.setTitle(strValue);
      newlyCreatedOrBeingEditedHabitualGoal.update();
      Log.d("test", "updated in pause");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_goal_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (newlyCreatedOrBeingEditedHabitualGoal != null) {
            //editText.setText(newlyCreatedOrBeingEditedHabitualGoal.getTitle(), TextView.BufferType.EDITABLE);
        }

        return rootView;
    }
}

