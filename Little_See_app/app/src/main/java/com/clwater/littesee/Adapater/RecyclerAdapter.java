package com.clwater.littesee.Adapater;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.clwater.littesee.Config.AppConfig;
import com.clwater.littesee.MainActivity;
import com.clwater.littesee.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by gengzhibo on 16/11/1.
 */



public  class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ListViewHolder> implements View.OnClickListener {

    private List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
    private Context mContext;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public RecyclerAdapter(Context context, List<Map<String, Object>> list){
        this.mContext = context;
        this.list = list;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.listview_main_image_title, parent, false);
        ListViewHolder holder = new ListViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(v,(String)v.getTag());
        }
    }

    public void onBindViewHolder(ListViewHolder holder, int position) {
        holder.title.setText(list.get(position).get("title").toString());
        String url_image = (String) list.get(position).get("title_image");
        holder.isread = (int) list.get(position).get("isread");
        if (holder.isread != 0) {
            holder.title.setTextColor(Color.parseColor("#666666"));
        }

        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(MainActivity.context));
        ImageLoader.getInstance().displayImage(url_image, holder.image, AppConfig.imageOptions());

        holder.itemView.setTag(list.get(position).get("id").toString());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView image;
        int isread;

        public ListViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.listview_main_text);
            image = (ImageView) view.findViewById(R.id.listview_main_image);
        }
    }

    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view , String data);
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}