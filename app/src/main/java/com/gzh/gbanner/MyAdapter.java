package com.gzh.gbanner;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @ClassName: MyAdapter
 * @Description: 描述类的作用
 * @author: GZH
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    String[] anims;

    public MyAdapter(Context context, String[] anims) {
        this.anims = anims;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, android.R.layout.simple_list_item_1, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.mTextView.setText("切换动画 - " + anims[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.OnItemClick(v, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return anims.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(android.R.id.text1);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    OnItemClickListener mOnItemClickListener;

    interface OnItemClickListener {
        void OnItemClick(View v, int position);
    }
}
