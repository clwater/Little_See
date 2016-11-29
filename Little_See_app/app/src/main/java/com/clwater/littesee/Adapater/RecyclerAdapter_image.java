package com.clwater.littesee.Adapater;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.clwater.littesee.Config.AppConfig;
import com.clwater.littesee.Fragment.ImageFragment;
import com.clwater.littesee.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by gengzhibo on 16/11/1.
 */



public  class RecyclerAdapter_image extends RecyclerView.Adapter<RecyclerAdapter_image.ListViewHolder> implements View.OnClickListener {

    private List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
    private Context mContext;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public RecyclerAdapter_image(Context context, List<Map<String, Object>> list){
        this.mContext = context;
        this.list = list;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.listview_image, parent, false);
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

    public void onBindViewHolder(final ListViewHolder holder, final int position) {
//
//        String url_image = (String) list.get(position).get("href");
        final ImageAware imageAware = new ImageViewAware(holder.image, false);
//        ImageFragment.imageLoader.displayImage(url_image , imageAware );
//
//        holder.image.setTag(list.get(position).get("href").toString());

        //先设置图片占位符
        holder.image.setImageDrawable(mContext.getDrawable(R.drawable.login_face));
        final String url =  (String) list.get(position).get("href");
        //为imageView设置Tag,内容是该imageView等待加载的图片url
        holder.image.setTag(url);
        AsyncTask asyncTask = new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                String url =  (String) list.get(position).get("href");
                //Bitmap bitmap = BitmapFactory.decodeStream(url.openStream());
                return url;
            }

            @Override
            protected void onPostExecute(String url) {
                super.onPostExecute(url);
                //加载完毕后判断该imageView等待的图片url是不是加载完毕的这张
                //如果是则为imageView设置图片,否则说明imageView已经被重用到其他item
                if(url.equals(holder.image.getTag())) {
                    ImageFragment.imageLoader.displayImage(url , imageAware ,  AppConfig.imageOptions());
                    //ImageLoader.getInstance().displayImage(url, holder.image, AppConfig.imageOptions());
                }
            }
        }.execute();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {

        ImageView image;

        public ListViewHolder(View view) {
            super(view);
            image = (ImageView) view.findViewById(R.id.listview_main_image);
        }
    }

    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, String data);
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}