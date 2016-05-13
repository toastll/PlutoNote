package pluto.plutonote.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.List;

import pluto.plutonote.R;

/**
 * Created by Pluto  on 2016/5/6.
 */
public class RecycleAdapter  extends RecyclerView.Adapter<RecycleAdapter.ViewHolder>{
    private List<String> mData;

    public RecycleAdapter(List<String> mData) {
        this.mData = mData;
    }

    /* todo 此处的作用是？*/
    public OnItemClickListener itemClickListener;

    /*  todo 作用呢？*/
    public void setItemClickListener(OnItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    /*todo 自定义的接口*/
    private interface OnItemClickListener{
        void onItemClick(View view, int position);
    }


    /**
     *  将布局转化为View并传递给RecycleView封装好的ViewHolder
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /*将布局转化为View并传递给RecycleView封装好的ViewHolder*/
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_item, parent, false);

        return new ViewHolder(view);
    }

    /**
     * 建立起ViewHandler中 视图与数据的关联
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_title.setText(mData.get(position)+position);



    }

    /**
     * 获取子项个数
     * @return
     */
    @Override
    public int getItemCount() {
        return mData.size();
    }




    /**
     * RecycleViewAdapter要求必须在内部写入ViewHolder，该ViewHolder继承自RecyclerView.ViewHolder
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
         private TextView tv_title;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_title = (TextView) itemView;
            tv_title.setOnClickListener(this);
        }

        /*通过接口回调来实现RecycleView的点击事件*/
        @Override
        public void onClick(View v) {
            if ( null != itemClickListener){
                itemClickListener.onItemClick(v, getPosition());
            }
        }
    }


}
