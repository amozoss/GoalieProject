package com.willoughby.goalie.db.generated;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig habitualGoalDaoConfig;
    private final DaoConfig dailyGoalDaoConfig;
    private final DaoConfig reminderDaoConfig;
    private final DaoConfig repeatDayDaoConfig;
    private final DaoConfig weeklyGoalDaoConfig;

    private final HabitualGoalDao habitualGoalDao;
    private final DailyGoalDao dailyGoalDao;
    private final ReminderDao reminderDao;
    private final RepeatDayDao repeatDayDao;
    private final WeeklyGoalDao weeklyGoalDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        habitualGoalDaoConfig = daoConfigMap.get(HabitualGoalDao.class).clone();
        habitualGoalDaoConfig.initIdentityScope(type);

        dailyGoalDaoConfig = daoConfigMap.get(DailyGoalDao.class).clone();
        dailyGoalDaoConfig.initIdentityScope(type);

        reminderDaoConfig = daoConfigMap.get(ReminderDao.class).clone();
        reminderDaoConfig.initIdentityScope(type);

        repeatDayDaoConfig = daoConfigMap.get(RepeatDayDao.class).clone();
        repeatDayDaoConfig.initIdentityScope(type);

        weeklyGoalDaoConfig = daoConfigMap.get(WeeklyGoalDao.class).clone();
        weeklyGoalDaoConfig.initIdentityScope(type);

        habitualGoalDao = new HabitualGoalDao(habitualGoalDaoConfig, this);
        dailyGoalDao = new DailyGoalDao(dailyGoalDaoConfig, this);
        reminderDao = new ReminderDao(reminderDaoConfig, this);
        repeatDayDao = new RepeatDayDao(repeatDayDaoConfig, this);
        weeklyGoalDao = new WeeklyGoalDao(weeklyGoalDaoConfig, this);

        registerDao(HabitualGoal.class, habitualGoalDao);
        registerDao(DailyGoal.class, dailyGoalDao);
        registerDao(Reminder.class, reminderDao);
        registerDao(RepeatDay.class, repeatDayDao);
        registerDao(WeeklyGoal.class, weeklyGoalDao);
    }
    
    public void clear() {
        habitualGoalDaoConfig.getIdentityScope().clear();
        dailyGoalDaoConfig.getIdentityScope().clear();
        reminderDaoConfig.getIdentityScope().clear();
        repeatDayDaoConfig.getIdentityScope().clear();
        weeklyGoalDaoConfig.getIdentityScope().clear();
    }

    public HabitualGoalDao getHabitualGoalDao() {
        return habitualGoalDao;
    }

    public DailyGoalDao getDailyGoalDao() {
        return dailyGoalDao;
    }

    public ReminderDao getReminderDao() {
        return reminderDao;
    }

    public RepeatDayDao getRepeatDayDao() {
        return repeatDayDao;
    }

    public WeeklyGoalDao getWeeklyGoalDao() {
        return weeklyGoalDao;
    }

}
