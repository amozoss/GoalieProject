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
 * DAO for table DAILY_GOAL.
*/
public class DailyGoalDao extends AbstractDao<DailyGoal, Long> {

    public static final String TABLENAME = "DAILY_GOAL";

    /**
     * Properties of entity DailyGoal.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Completed = new Property(1, Integer.class, "completed", false, "COMPLETED");
        public final static Property Goal = new Property(2, Integer.class, "goal", false, "GOAL");
        public final static Property IsCompleted = new Property(3, Boolean.class, "isCompleted", false, "IS_COMPLETED");
        public final static Property Date = new Property(4, java.util.Date.class, "date", false, "DATE");
        public final static Property HabitualGoalId = new Property(5, long.class, "habitualGoalId", false, "HABITUAL_GOAL_ID");
    };

    private DaoSession daoSession;

    private Query<DailyGoal> habitualGoal_DailyGoalsQuery;

    public DailyGoalDao(DaoConfig config) {
        super(config);
    }
    
    public DailyGoalDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'DAILY_GOAL' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'COMPLETED' INTEGER," + // 1: completed
                "'GOAL' INTEGER," + // 2: goal
                "'IS_COMPLETED' INTEGER," + // 3: isCompleted
                "'DATE' INTEGER," + // 4: date
                "'HABITUAL_GOAL_ID' INTEGER NOT NULL );"); // 5: habitualGoalId
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'DAILY_GOAL'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, DailyGoal entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Integer completed = entity.getCompleted();
        if (completed != null) {
            stmt.bindLong(2, completed);
        }
 
        Integer goal = entity.getGoal();
        if (goal != null) {
            stmt.bindLong(3, goal);
        }
 
        Boolean isCompleted = entity.getIsCompleted();
        if (isCompleted != null) {
            stmt.bindLong(4, isCompleted ? 1l: 0l);
        }
 
        java.util.Date date = entity.getDate();
        if (date != null) {
            stmt.bindLong(5, date.getTime());
        }
        stmt.bindLong(6, entity.getHabitualGoalId());
    }

    @Override
    protected void attachEntity(DailyGoal entity) {
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
    public DailyGoal readEntity(Cursor cursor, int offset) {
        DailyGoal entity = new DailyGoal( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // completed
            cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // goal
            cursor.isNull(offset + 3) ? null : cursor.getShort(offset + 3) != 0, // isCompleted
            cursor.isNull(offset + 4) ? null : new java.util.Date(cursor.getLong(offset + 4)), // date
            cursor.getLong(offset + 5) // habitualGoalId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, DailyGoal entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setCompleted(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setGoal(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setIsCompleted(cursor.isNull(offset + 3) ? null : cursor.getShort(offset + 3) != 0);
        entity.setDate(cursor.isNull(offset + 4) ? null : new java.util.Date(cursor.getLong(offset + 4)));
        entity.setHabitualGoalId(cursor.getLong(offset + 5));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(DailyGoal entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(DailyGoal entity) {
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
    
    /** Internal query to resolve the "dailyGoals" to-many relationship of HabitualGoal. */
    public List<DailyGoal> _queryHabitualGoal_DailyGoals(long habitualGoalId) {
        synchronized (this) {
            if (habitualGoal_DailyGoalsQuery == null) {
                QueryBuilder<DailyGoal> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.HabitualGoalId.eq(null));
                queryBuilder.orderRaw("DATE DESC");
                habitualGoal_DailyGoalsQuery = queryBuilder.build();
            }
        }
        Query<DailyGoal> query = habitualGoal_DailyGoalsQuery.forCurrentThread();
        query.setParameter(0, habitualGoalId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getHabitualGoalDao().getAllColumns());
            builder.append(" FROM DAILY_GOAL T");
            builder.append(" LEFT JOIN HABITUAL_GOAL T0 ON T.'HABITUAL_GOAL_ID'=T0.'_id'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected DailyGoal loadCurrentDeep(Cursor cursor, boolean lock) {
        DailyGoal entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        HabitualGoal habitualGoal = loadCurrentOther(daoSession.getHabitualGoalDao(), cursor, offset);
         if(habitualGoal != null) {
            entity.setHabitualGoal(habitualGoal);
        }

        return entity;    
    }

    public DailyGoal loadDeep(Long key) {
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
    public List<DailyGoal> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<DailyGoal> list = new ArrayList<DailyGoal>(count);
        
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
    
    protected List<DailyGoal> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<DailyGoal> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
