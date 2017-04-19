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
import com.clwater.littlesee.utils.Bean.DiaryBean;
import com.clwater.littlesee.utils.Bean.ImageBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yszsyf on 17/3/17.
 */

public class ImageRecyclerViewAdapter extends RecyclerView.Adapter<ImageRecyclerViewAdapter.NormalTextViewHolder> {
    private final LayoutInflater mLayoutInflater;
    private final Context context;
    List<ImageBean.DateBean> list = new ArrayList<ImageBean.DateBean>();

    public ImageRecyclerViewAdapter(Context context , List<ImageBean.DateBean> _list) {
        this.list = _list;
        this.context = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public NormalTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NormalTextViewHolder(mLayoutInflater.inflate(R.layout.adapter_image, parent, false));
    }

    @Override
    public void onBindViewHolder(NormalTextViewHolder holder, int position) {
        holder.textView.setText(list.get(position).getText());
        String address = list.get(position).getAddress();
        address = address + "_640x480.jpg";
        Glide.with(context).load(address).into(holder.imageView);
        String indexclass = list.get(position).getIndexclass();
        holder.fromtext.setText(indexclass);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class NormalTextViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textview_image_text)
        TextView textView;

        @BindView(R.id.imageview_image_image)
        ImageView imageView;

        @BindView(R.id.textview_image_from)
        TextView fromtext;


        NormalTextViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("gzb", "onClick--> position = " + getPosition());
                    Log.d("gzb" , "address" + list.get(getPosition()).getAddress());
//                    Intent intent = new Intent(context , BaseTextInfoActivity.class);
//                    intent.putExtra("index" , "diary");
//                    Bundle bundle=new Bundle();
//                    bundle.putSerializable("class", list.get(getPosition()));
//                    intent.putExtras(bundle);
//                    context.startActivity(intent);

                }
            });
        }
    }
}