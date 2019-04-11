package com.example.dxnima.zhidao.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.dxnima.zhidao.bean.table.GetMsg;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "GET_MSG".
*/
public class GetMsgDao extends AbstractDao<GetMsg, Void> {

    public static final String TABLENAME = "GET_MSG";

    /**
     * Properties of entity GetMsg.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, String.class, "id", false, "ID");
        public final static Property Userid = new Property(1, Integer.class, "userid", false, "USERID");
        public final static Property Msgid = new Property(2, Integer.class, "msgid", false, "MSGID");
        public final static Property Categoryname = new Property(3, String.class, "categoryname", false, "CATEGORYNAME");
        public final static Property Status = new Property(4, Integer.class, "status", false, "STATUS");
    };


    public GetMsgDao(DaoConfig config) {
        super(config);
    }
    
    public GetMsgDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"GET_MSG\" (" + //
                "\"ID\" TEXT," + // 0: id
                "\"USERID\" INTEGER," + // 1: userid
                "\"MSGID\" INTEGER," + // 2: msgid
                "\"CATEGORYNAME\" TEXT," + // 3: categoryname
                "\"STATUS\" INTEGER);"); // 4: status
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"GET_MSG\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, GetMsg entity) {
        stmt.clearBindings();
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
 
        Integer userid = entity.getUserid();
        if (userid != null) {
            stmt.bindLong(2, userid);
        }
 
        Integer msgid = entity.getMsgid();
        if (msgid != null) {
            stmt.bindLong(3, msgid);
        }
 
        String categoryname = entity.getCategoryname();
        if (categoryname != null) {
            stmt.bindString(4, categoryname);
        }
 
        Integer status = entity.getStatus();
        if (status != null) {
            stmt.bindLong(5, status);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, GetMsg entity) {
        stmt.clearBindings();
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
 
        Integer userid = entity.getUserid();
        if (userid != null) {
            stmt.bindLong(2, userid);
        }
 
        Integer msgid = entity.getMsgid();
        if (msgid != null) {
            stmt.bindLong(3, msgid);
        }
 
        String categoryname = entity.getCategoryname();
        if (categoryname != null) {
            stmt.bindString(4, categoryname);
        }
 
        Integer status = entity.getStatus();
        if (status != null) {
            stmt.bindLong(5, status);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public GetMsg readEntity(Cursor cursor, int offset) {
        GetMsg entity = new GetMsg( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // userid
            cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // msgid
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // categoryname
            cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4) // status
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, GetMsg entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setUserid(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setMsgid(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setCategoryname(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setStatus(cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(GetMsg entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(GetMsg entity) {
        return null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
