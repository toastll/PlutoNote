package pluto.plutonote.EventArgs;

/**
 * eventBus传递数据
 * Created by Pluto  on 2016/5/9.
 */
public class NoteActivityArgs {

    /*标题*/
    private String noteTitle;

    /*内容*/
    private String noteContent;

    /*时间*/
    private String createDate;

    /*分类*/
    private int sort;

    private boolean isChange;

    public boolean isChange() {
        return isChange;
    }

    public void setFirst(boolean isChange) {
        isChange = isChange;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public NoteActivityArgs(String noteTitle, String noteContent, String createDate, int sort, boolean isChange) {
        this.noteTitle = noteTitle;
        this.noteContent = noteContent;
        this.createDate = createDate;
        this.sort = sort;
        this.isChange = isChange;
    }
}
