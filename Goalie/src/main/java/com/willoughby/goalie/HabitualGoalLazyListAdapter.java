package com.willoughby.goalie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.willoughby.goalie.db.gen.HabitualGoal;

import de.greenrobot.dao.query.LazyList;

/**
 * Created by dan on 1/5/14.
 */
public class HabitualGoalLazyListAdapter extends GreenDaoListAdapter<HabitualGoal> {
    public HabitualGoalLazyListAdapter(Context context, LazyList<HabitualGoal> lazyList) {
        super(context, lazyList);
    }

    @Override
    public View newView(Context context, HabitualGoal item, ViewGroup parent) {
        if (item == null) return null;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return inflater.inflate(R.layout.hg_list_view_cell, parent, false);
    }

    @Override
    public void bindView(View view, Context context, HabitualGoal item) {
        ((TextView)view).setText(item.getTitle());

    }
}
