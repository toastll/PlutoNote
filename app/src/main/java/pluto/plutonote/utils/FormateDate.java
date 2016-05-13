package pluto.plutonote.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Pluto  on 2016/5/7.
 */
public class FormateDate {


    SimpleDateFormat formatter    =   new    SimpleDateFormat    ("yyyy年MM月dd日    HH:mm:ss     ");
    Date curDate    =   new    Date(System.currentTimeMillis());//获取当前时间
    String    str    =    formatter.format(curDate);
}
