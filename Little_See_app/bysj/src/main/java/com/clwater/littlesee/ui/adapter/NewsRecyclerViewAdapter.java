package com.clwater.littlesee.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.clwater.littlesee.R;
import com.clwater.littlesee.ui.activity.BaseTextInfoActivity;
import com.clwater.littlesee.utils.Bean.NewsBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yszsyf on 17/3/17.
 */

public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<NewsRecyclerViewAdapter.NormalTextViewHolder> {
    private final LayoutInflater mLayoutInflater;
    private final Context context;
    List<NewsBean.DateBean> list = new ArrayList<NewsBean.DateBean>();

    public NewsRecyclerViewAdapter(Context context , List<NewsBean.DateBean> _list) {
        this.list = _list;
        this.context = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public NormalTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NormalTextViewHolder(mLayoutInflater.inflate(R.layout.adapter_news, parent, false));
    }

    @Override
    public void onBindViewHolder(NormalTextViewHolder holder, int position) {
        holder.textView.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getImage()).into(holder.imageView);
        String indexclass = list.get(position).getIndexclass();
        holder.fromTex.setText(indexclass);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class NormalTextViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textview_adapter_news)
        TextView textView;

        @BindView(R.id.imageview_adapter_image)
        ImageView imageView;

        @BindView(R.id.textview_adapter_from)
        TextView fromTex;

        NormalTextViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("gzb", "onClick--> position = " + getPosition());
                    Intent intent = new Intent(context , BaseTextInfoActivity.class);
                    Bundle bundle=new Bundle();
                    bundle.putSerializable("news", list.get(getPosition()));
                    intent.putExtras(bundle);
                    context.startActivity(intent);

                }
            });
        }
    }
}