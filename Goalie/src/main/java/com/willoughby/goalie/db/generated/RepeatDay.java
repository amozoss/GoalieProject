package com.willoughby.goalie.db.generated;

import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table REPEAT_DAY.
 */
public class RepeatDay {

    private Long id;
    private Integer dayOfTheWeek;
    private long habitualGoalId;
    private long reminderId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient RepeatDayDao myDao;

    private HabitualGoal habitualGoal;
    private Long habitualGoal__resolvedKey;

    private Reminder reminder;
    private Long reminder__resolvedKey;


    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public RepeatDay() {
    }

    public RepeatDay(Long id) {
        this.id = id;
    }

    public RepeatDay(Long id, Integer dayOfTheWeek, long habitualGoalId, long reminderId) {
        this.id = id;
        this.dayOfTheWeek = dayOfTheWeek;
        this.habitualGoalId = habitualGoalId;
        this.reminderId = reminderId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getRepeatDayDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public void setDayOfTheWeek(Integer dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public long getHabitualGoalId() {
        return habitualGoalId;
    }

    public void setHabitualGoalId(long habitualGoalId) {
        this.habitualGoalId = habitualGoalId;
    }

    public long getReminderId() {
        return reminderId;
    }

    public void setReminderId(long reminderId) {
        this.reminderId = reminderId;
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

    /** To-one relationship, resolved on first access. */
    public Reminder getReminder() {
        long __key = this.reminderId;
        if (reminder__resolvedKey == null || !reminder__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ReminderDao targetDao = daoSession.getReminderDao();
            Reminder reminderNew = targetDao.load(__key);
            synchronized (this) {
                reminder = reminderNew;
            	reminder__resolvedKey = __key;
            }
        }
        return reminder;
    }

    public void setReminder(Reminder reminder) {
        if (reminder == null) {
            throw new DaoException("To-one property 'reminderId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.reminder = reminder;
            reminderId = reminder.getId();
            reminder__resolvedKey = reminderId;
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
