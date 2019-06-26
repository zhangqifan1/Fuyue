package com.zqf.base.greendao;

import com.ping.greendao.gen.UserInfoDao;
import com.zqf.base.application.BaseApplication;

import java.util.List;

/**
 * Created by Administrator on 2017/9/14.
 * 例子
 */

public class GreenDaoUtils_UserInfo {
    /**
     * 添加数据，如果有重复则覆盖
     *
     */
    public static void insertUserInfo(UserInfo userInfo) {
        BaseApplication.getDaoInstant().getUserInfoDao().insertOrReplace(userInfo);
    }

    /**
     * 删除数据
     */
    public static void deleteAllUserInfo() {
        BaseApplication.getDaoInstant().getUserInfoDao().deleteAll();
    }

    /**
     * 更新数据
     *
     */
    public static void updateUserInfo(UserInfo userInfo) {
        BaseApplication.getDaoInstant().getUserInfoDao().update(userInfo);
    }

//    /**
//     * 查询条件为Type=TYPE_LOVE的数据
//     *
//     * @return
//     */
//    public static LocalMusic queryMusic(int uid) {
//        LocalMusic localMusic = BaseApplication.getDaoInstant().getLocalMusicDao().queryBuilder().where(LocalMusicDao.Properties.Uid.eq(uid)).uniqueOrThrow();
//        return localMusic;
//    }

    /**
     * 查询全部数据
     */
    public static UserInfo queryAll() {
        List<UserInfo> userInfos = BaseApplication.getDaoInstant().getUserInfoDao().loadAll();
        if(userInfos.size()==0){
            return null;
        }
        return userInfos.get(0);
    }

    /**
     * 查询条件为Type=TYPE_LOVE的数据
     *
     * @return
     */
//    public static LocalMusic queryIdMusic(Long id) {
//        LocalMusic localMusic = BaseApplication.getDaoInstant().getLocalMusicDao().queryBuilder().where(LocalMusicDao.Properties.Id.eq(id)).uniqueOrThrow();
//        return localMusic;
//    }

    /**
     * 查询全部数据
     */
    public static int queryUserid (){
        return BaseApplication.getDaoInstant().getUserInfoDao().queryBuilder().where(UserInfoDao.Properties.Id.eq(1L)).uniqueOrThrow().getUserid();
    }
}
