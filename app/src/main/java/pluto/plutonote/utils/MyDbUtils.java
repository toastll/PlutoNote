package pluto.plutonote.utils;

import android.content.Context;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;

import java.text.SimpleDateFormat;
import java.util.Date;

import pluto.plutonote.bean.NoteEntity;
import pluto.plutonote.database.DbNotes;

/**
 * Created by Pluto  on 2016/5/6.
 */
public class MyDbUtils {

//    /**
//     * 保存笔记
//     *
//     * @param noteEntity 笔记实例
//     * @return
//     */
//    public boolean saveNote(NoteEntity noteEntity,Context context) {
//
//        DbNotes mDbNotes = getDbNotes(noteEntity);
//        DbUtils dbUtils = configDbUtils(context);
//
//        try {
//            dbUtils.saveOrUpdate(mDbNotes);
//        } catch (DbException e) {
//            e.printStackTrace();
//            return false;
//        }
//
//        return true;
//    }

    /**
     * 获取DbNote实例,将实例对象封装为数据库对象
     *
     * @param noteEntity
     * @return DbNotes实例
     */
    public static DbNotes getDbNotes(NoteEntity noteEntity) {
        DbNotes mDbNotes = new DbNotes();
        mDbNotes.setId(noteEntity.getId());
        mDbNotes.setNoteTitle(noteEntity.getNoteTitle());
        mDbNotes.setNoteContent(noteEntity.getNoteContent());
        mDbNotes.setCreateDate(noteEntity.getCreateDate());
        mDbNotes.setSort(noteEntity.getSort());
        return mDbNotes;
    }

    /*获取entity实例，即将数据库对象转换为entity对象*/

//    /**
//     * 配置DbUtils
//     * @param context
//     * @return
//     */
//    public static DbUtils configDbUtils(Context context){
//        DbUtils.DaoConfig config = new DbUtils.DaoConfig(context);
//        config.setDbName(Constant.DBNAME);
//        config.setDbVersion(1);/*设置数据库的版本号为1*/
//        DbUtils dbUtils = DbUtils.create(config);
//
//        return dbUtils;
//    }

    /* 获取当前时间*/
    public static Date getTimeAsDate(){
        Date curDate    =   new    Date(System.currentTimeMillis());//获取当前时间
        return curDate;
    }

    public static String getTimeAsString(Date date){
        SimpleDateFormat formatter    =   new    SimpleDateFormat    ("yyyy-MM-dd HH:mm");
        return formatter.format(date);
    }
}
