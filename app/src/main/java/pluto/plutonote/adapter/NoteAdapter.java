package pluto.plutonote.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import pluto.plutonote.bean.NoteEntity;

/**
 * Created by Pluto  on 2016/5/9.
 */
public class NoteAdapter extends BaseAdapter {

    private Context context;
    private List<NoteEntity> list = new ArrayList<NoteEntity>();

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
