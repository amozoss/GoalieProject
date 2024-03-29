package com.willoughby.goalie.db.generated;

import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table WEEKLY_GOAL.
 */
public class WeeklyGoal {

    private Long id;
    private Integer completed;
    private Integer goal;
    private java.util.Date weekEnd;
    private java.util.Date weekStart;
    private long habitualGoalId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient WeeklyGoalDao myDao;

    private HabitualGoal habitualGoal;
    private Long habitualGoal__resolvedKey;


    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public WeeklyGoal() {
    }

    public WeeklyGoal(Long id) {
        this.id = id;
    }

    public WeeklyGoal(Long id, Integer completed, Integer goal, java.util.Date weekEnd, java.util.Date weekStart, long habitualGoalId) {
        this.id = id;
        this.completed = completed;
        this.goal = goal;
        this.weekEnd = weekEnd;
        this.weekStart = weekStart;
        this.habitualGoalId = habitualGoalId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getWeeklyGoalDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCompleted() {
        return completed;
    }

    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

    public Integer getGoal() {
        return goal;
    }

    public void setGoal(Integer goal) {
        this.goal = goal;
    }

    public java.util.Date getWeekEnd() {
        return weekEnd;
    }

    public void setWeekEnd(java.util.Date weekEnd) {
        this.weekEnd = weekEnd;
    }

    public java.util.Date getWeekStart() {
        return weekStart;
    }

    public void setWeekStart(java.util.Date weekStart) {
        this.weekStart = weekStart;
    }

    public long getHabitualGoalId() {
        return habitualGoalId;
    }

    public void setHabitualGoalId(long habitualGoalId) {
        this.habitualGoalId = habitualGoalId;
    }

    /** To-one relationship, resolved on first access. */
    public HabitualGoal getHabitualGoal() {
        long __key = this.habitualGoalId;
        if (habitualGoal__resolvedKey == null || !habitualGoal__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            HabitualGoalDao targetDao = daoSession.getHabitualGoalDao();
            HabitualGoal habitualGoalNew = targetDao.load(__key);
            synchronized (this) {
                habitualGoal = habitualGoalNew;
            	habitualGoal__resolvedKey = __key;
            }
        }
        return habitualGoal;
    }

    public void setHabitualGoal(HabitualGoal habitualGoal) {
        if (habitualGoal == null) {
            throw new DaoException("To-one property 'habitualGoalId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.habitualGoal = habitualGoal;
            habitualGoalId = habitualGoal.getId();
            habitualGoal__resolvedKey = habitualGoalId;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}
