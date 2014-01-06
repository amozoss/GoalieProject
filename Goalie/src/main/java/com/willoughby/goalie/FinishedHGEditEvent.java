package com.willoughby.goalie;

import com.willoughby.goalie.db.gen.HabitualGoal;

/**
 * Created by dan on 1/5/14.
 */
public class FinishedHGEditEvent {
    public HabitualGoal getHabitualGoal() {
        return habitualGoal;
    }

    private HabitualGoal habitualGoal;

    public FinishedHGEditEvent(HabitualGoal habitualGoal){
        this.habitualGoal = habitualGoal;
    }

}
