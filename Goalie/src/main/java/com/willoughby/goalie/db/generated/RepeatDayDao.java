package com.willoughby.goalie.db.generated;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table REPEAT_DAY.
*/
public class RepeatDayDao extends AbstractDao<RepeatDay, Long> {

    public static final String TABLENAME = "REPEAT_DAY";

    /**
     * Properties of entity RepeatDay.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property DayOfTheWeek = new Property(1, Integer.class, "dayOfTheWeek", false, "DAY_OF_THE_WEEK");
        public final static Property HabitualGoalId = new Property(2, long.class, "habitualGoalId", false, "HABITUAL_GOAL_ID");
        public final static Property ReminderId = new Property(3, long.class, "reminderId", false, "REMINDER_ID");
    };

    private DaoSession daoSession;

    private Query<RepeatDay> habitualGoal_RepeatDaysQuery;
    private Query<RepeatDay> reminder_RepeatDaysQuery;

    public RepeatDayDao(DaoConfig config) {
        super(config);
    }
    
    public RepeatDayDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'REPEAT_DAY' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'DAY_OF_THE_WEEK' INTEGER," + // 1: dayOfTheWeek
                "'HABITUAL_GOAL_ID' INTEGER NOT NULL ," + // 2: habitualGoalId
                "'REMINDER_ID' INTEGER NOT NULL );"); // 3: reminderId
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'REPEAT_DAY'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, RepeatDay entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Integer dayOfTheWeek = entity.getDayOfTheWeek();
        if (dayOfTheWeek != null) {
            stmt.bindLong(2, dayOfTheWeek);
        }
        stmt.bindLong(3, entity.getHabitualGoalId());
        stmt.bindLong(4, entity.getReminderId());
    }

    @Override
    protected void attachEntity(RepeatDay entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public RepeatDay readEntity(Cursor cursor, int offset) {
        RepeatDay entity = new RepeatDay( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // dayOfTheWeek
            cursor.getLong(offset + 2), // habitualGoalId
            cursor.getLong(offset + 3) // reminderId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, RepeatDay entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setDayOfTheWeek(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setHabitualGoalId(cursor.getLong(offset + 2));
        entity.setReminderId(cursor.getLong(offset + 3));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(RepeatDay entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(RepeatDay entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "repeatDays" to-many relationship of HabitualGoal. */
    public List<RepeatDay> _queryHabitualGoal_RepeatDays(long habitualGoalId) {
        synchronized (this) {
            if (habitualGoal_RepeatDaysQuery == null) {
                QueryBuilder<RepeatDay> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.HabitualGoalId.eq(null));
                queryBuilder.orderRaw("DAY_OF_THE_WEEK ASC");
                habitualGoal_RepeatDaysQuery = queryBuilder.build();
            }
        }
        Query<RepeatDay> query = habitualGoal_RepeatDaysQuery.forCurrentThread();
        query.setParameter(0, habitualGoalId);
        return query.list();
    }

    /** Internal query to resolve the "repeatDays" to-many relationship of Reminder. */
    public List<RepeatDay> _queryReminder_RepeatDays(long reminderId) {
        synchronized (this) {
            if (reminder_RepeatDaysQuery == null) {
                QueryBuilder<RepeatDay> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.ReminderId.eq(null));
                queryBuilder.orderRaw("DAY_OF_THE_WEEK ASC");
                reminder_RepeatDaysQuery = queryBuilder.build();
            }
        }
        Query<RepeatDay> query = reminder_RepeatDaysQuery.forCurrentThread();
        query.setParameter(0, reminderId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getHabitualGoalDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getReminderDao().getAllColumns());
            builder.append(" FROM REPEAT_DAY T");
            builder.append(" LEFT JOIN HABITUAL_GOAL T0 ON T.'HABITUAL_GOAL_ID'=T0.'_id'");
            builder.append(" LEFT JOIN REMINDER T1 ON T.'REMINDER_ID'=T1.'_id'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected RepeatDay loadCurrentDeep(Cursor cursor, boolean lock) {
        RepeatDay entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        HabitualGoal habitualGoal = loadCurrentOther(daoSession.getHabitualGoalDao(), cursor, offset);
         if(habitualGoal != null) {
            entity.setHabitualGoal(habitualGoal);
        }
        offset += daoSession.getHabitualGoalDao().getAllColumns().length;

        Reminder reminder = loadCurrentOther(daoSession.getReminderDao(), cursor, offset);
         if(reminder != null) {
            entity.setReminder(reminder);
        }

        return entity;    
    }

    public RepeatDay loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<RepeatDay> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<RepeatDay> list = new ArrayList<RepeatDay>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<RepeatDay> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<RepeatDay> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
