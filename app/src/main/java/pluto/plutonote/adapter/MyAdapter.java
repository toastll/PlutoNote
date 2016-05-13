package pluto.plutonote.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pluto.plutonote.R;
import pluto.plutonote.bean.NoteEntity;

/**
 * Created by Pluto  on 2016/5/6.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<NoteEntity> mDataList;/*数据源*/
    private Context mContext;/*上下文*/
    private LayoutInflater mInflater;/*布局解析器*/

    /*todo 声明一个接口，用于实现点击事件*/
    public interface OnItemClickListener{
        void onItemClick(View view,int position);
        void onItemLongClickListener(View view, int position);
    }

    private OnItemClickListener mOnItemClickListener;/*设置接口对象*/

    /*todo 供外部调用*/

    /**
     * 设置点击事件监听器
     * @param mOnItemClickListener
     */
    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }


    /**
     * 构造方法
     * @param dataList 数据源
     * @param mContext 上下文
     */
    public MyAdapter(List<NoteEntity> dataList, Context mContext) {
        this.mDataList = dataList;
        this.mContext = mContext;
        this.mInflater = LayoutInflater.from(mContext);/**/

    }

//    public void addData(NoteEntity noteEntity)
//    {
//
//        mDataList.add(position, "Insert One");
//        mHeights.add( (int) (100 + Math.random() * 300));
//        notifyItemInserted(position);
//    }
//
//    public void removeData(int position)
//    {
//        mDataList.remove(position);
//        notifyItemRemoved(position);
//    }

    /**
     * 创建ViewHolder
     * 【将布局转化为VIew,并传递给RecyclerView封装好的ViewHolder】
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        /*获取itemView*/
        View view = mInflater.inflate(R.layout.rc_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    /**
     * 绑定ViewHolder并进行相应的赋值
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        holder.tv_title.setText(mDataList.get(position).getNoteTitle());
        holder.tv_content.setText(mDataList.get(position).getNoteContent());
        holder.tv_date.setText(mDataList.get(position).getCreateDate().toString());
        switch (mDataList.get(position).getSort()){
            case 0:/*工作*/
                holder.tv_sort.setText("全部");
                break;
            case 1:/*学习*/
                holder.tv_sort.setText("工作");
                break;
            case 2:/*生活*/
                holder.tv_sort.setText("学习");
                break;
            case  3:
                holder.tv_sort.setText("生活");
                break;
        }


        /*todo 为列表项*/
        if (null != mOnItemClickListener){/*外部设置了点击事件监听器*/
             holder.itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {/*v 与 holder.itemView是同一个吗*/
                    int layoutPosition = holder.getLayoutPosition();/*得到布局的position*/
//                     holder.getAdapterPosition()/*todo 与layoutPosition的区别是？*/
                     mOnItemClickListener.onItemClick(holder.itemView, layoutPosition);
                 }
             });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int layoutPosition = holder.getLayoutPosition();/*得到布局的position*/
                    mOnItemClickListener.onItemLongClickListener(holder.itemView, layoutPosition);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_title, tv_content, tv_sort,tv_date;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_content = (TextView) itemView.findViewById(R.id.tv_content);
            tv_sort = (TextView) itemView.findViewById(R.id.tv_sort);
            tv_date = (TextView) itemView.findViewById(R.id.tv_date);
        }
    }


}


