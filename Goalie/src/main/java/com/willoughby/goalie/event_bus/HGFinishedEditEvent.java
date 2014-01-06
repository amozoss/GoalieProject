package com.willoughby.goalie.event_bus;

import com.willoughby.goalie.db.generated.HabitualGoal;

/**
 * Created by dan on 1/5/14.
 */
public class HGFinishedEditEvent {
    public HabitualGoal getHabitualGoal() {
        return habitualGoal;
    }

    private HabitualGoal habitualGoal;

    public HGFinishedEditEvent(HabitualGoal habitualGoal){
        this.habitualGoal = habitualGoal;
    }

}
