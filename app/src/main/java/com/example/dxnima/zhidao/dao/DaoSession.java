package com.example.dxnima.zhidao.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.dxnima.zhidao.bean.table.User;
import com.example.dxnima.zhidao.bean.table.GetMsg;
import com.example.dxnima.zhidao.bean.table.Msg;

import com.example.dxnima.zhidao.dao.UserDao;
import com.example.dxnima.zhidao.dao.GetMsgDao;
import com.example.dxnima.zhidao.dao.MsgDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userDaoConfig;
    private final DaoConfig getMsgDaoConfig;
    private final DaoConfig msgDaoConfig;

    private final UserDao userDao;
    private final GetMsgDao getMsgDao;
    private final MsgDao msgDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        getMsgDaoConfig = daoConfigMap.get(GetMsgDao.class).clone();
        getMsgDaoConfig.initIdentityScope(type);

        msgDaoConfig = daoConfigMap.get(MsgDao.class).clone();
        msgDaoConfig.initIdentityScope(type);

        userDao = new UserDao(userDaoConfig, this);
        getMsgDao = new GetMsgDao(getMsgDaoConfig, this);
        msgDao = new MsgDao(msgDaoConfig, this);

        registerDao(User.class, userDao);
        registerDao(GetMsg.class, getMsgDao);
        registerDao(Msg.class, msgDao);
    }
    
    public void clear() {
        userDaoConfig.getIdentityScope().clear();
        getMsgDaoConfig.getIdentityScope().clear();
        msgDaoConfig.getIdentityScope().clear();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public GetMsgDao getGetMsgDao() {
        return getMsgDao;
    }

    public MsgDao getMsgDao() {
        return msgDao;
    }

}