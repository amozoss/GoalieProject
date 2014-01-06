package com.willoughby.goalie;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.willoughby.goalie.db.gen.DaoMaster;
import com.willoughby.goalie.db.gen.DaoSession;
import com.willoughby.goalie.db.gen.HabitualGoal;
import com.willoughby.goalie.db.gen.HabitualGoalDao;

import de.greenrobot.event.EventBus;

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
    private EditText editText;
    private View rootView;
    private EventBus eventBus;

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
        eventBus = ((GoalieApp)this.getActivity().getApplication()).eventBus;

        EventBus.getDefault().register(this);

        habitualGoalDao = daoSession.getHabitualGoalDao();

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            newlyCreatedOrBeingEditedHabitualGoal = habitualGoalDao.load(getArguments().getLong(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_goal_detail, container, false);
        editText = ((EditText) rootView.findViewById(R.id.goal_detail));

        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String strValue = editText.getText().toString();
                    newlyCreatedOrBeingEditedHabitualGoal.setTitle(strValue);
                    habitualGoalDao.update(newlyCreatedOrBeingEditedHabitualGoal);
                    eventBus.post(new FinishedHGEditEvent(newlyCreatedOrBeingEditedHabitualGoal));

                    //System.out.println("************************: " + strValue);
                }
            }
        });

        // Show the dummy content as text in a TextView.
        if (newlyCreatedOrBeingEditedHabitualGoal != null) {
            editText.setText(newlyCreatedOrBeingEditedHabitualGoal.getTitle(), TextView.BufferType.EDITABLE);
        }

        return rootView;
    }
}

