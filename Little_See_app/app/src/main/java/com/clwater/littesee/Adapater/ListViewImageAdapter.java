package com.clwater.littesee.Adapater;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.clwater.littesee.Config.AppConfig;
import com.clwater.littesee.MainActivity;
import com.clwater.littesee.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;
import java.util.Map;

/**
 * Created by gengzhibo on 16/10/14.
 */

public class ListViewImageAdapter  extends BaseAdapter {

    private List<Map<String, Object>> data;
    private LayoutInflater layoutInflater;
    private Context context;
    public ListViewImageAdapter(Context context, List<Map<String, Object>> data){
        this.context=context;
        this.data=data;
        this.layoutInflater= LayoutInflater.from(context);
    }
    /**
     * 组件集合，对应list.xml中的控件
     * @author Administrator
     */
    public final class Zujian{
        public ImageView image;
        public TextView title;
//        public String address;
        public int isread;
    }

    @Override
    public int getCount() {
        return data.size();
    }
    /**
     * 获得某一位置的数据
     */
    @Override
    public Object getItem(int position) {
        return data.get(position);
    }
    /**
     * 获得唯一标识
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Zujian zujian=null;
        if(convertView==null){
            zujian=new Zujian();
            //获得组件，实例化组件
            convertView=layoutInflater.inflate(R.layout.listview_text, null);
            zujian.image=(ImageView)convertView.findViewById(R.id.listview_main_image);
            zujian.title=(TextView)convertView.findViewById(R.id.listview_main_text);


            convertView.setTag(zujian);
        }else{
            zujian=(Zujian)convertView.getTag();
        }



        zujian.title.setText((String) data.get(position).get("title"));
        String url_image = (String) data.get(position).get("title_image");
        zujian.isread = (int) data.get(position).get("isread");
        if (zujian.isread != 0){
            zujian.title.setTextColor(Color.parseColor("#666666"));
        }

        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(MainActivity.context));
        ImageLoader.getInstance().displayImage(url_image ,zujian.image, AppConfig.imageOptions());
        return convertView;
    }




}