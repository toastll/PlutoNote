package pluto.plutonote.database;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.Table;

import java.util.Date;


/**
 * 记事本数据库
 * Created by Pluto  on 2016/5/5.
 */

// 建议加上注解， 混淆后表名不受影响
@Table(name = "DbNotes", execAfterTableCreated = "CREATE UNIQUE INDEX index_name ON parent(name,email)")
/*@Table(name = "DbNotes", execAfterTableCreated = "CREATE UNIQUE INDEX index_name ON parent(name,email)")
    execAfterTableCreated设置创建爱你表时自动运行的代码，双引号“”内的内容为创建索引
*/
public class DbNotes extends EntityBase {

    @Id(column = "id")/*设置id此处为递增*/
    private int id;

    /*标题*/
    @Column(column = "title")// 建议加上注解， 混淆后列名不受影响
    private String noteTitle;

    /*内容*/
    @Column(column = "content")
    private String noteContent;

    /*时间*/
    @Column(column = "date")
    private String createDate;

    /*分类*/
    @Column(column = "sort")
    private int sort;

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    @Override
    public int getId() {
        return id;
    }

    /*不提供setId的方法 todo*/
//    @Override
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    @Override
    public String toString() {
        return "DbNotes{" +
                "id=" + id +
                ", noteTitle='" + noteTitle + '\'' +
                ", noteContent='" + noteContent + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
