package com.clwater.littlesee.weight;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by yszsyf on 17/3/18.
 */

public class ItemDecoration extends RecyclerView.ItemDecoration
{
    private static final int[] ATTRS = {android.R.attr.listDivider};
    private Drawable mDivider;
    public ItemDecoration(Context context)
    {
        TypedArray array = context.obtainStyledAttributes(ATTRS);
        // 获取分隔条
        mDivider = array.getDrawable(0);
        array.recycle();
    }
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state)
    {
        super.onDrawOver(c, parent, state);
        int count = parent.getChildCount();
        int left = parent.getPaddingLeft();
        int right = parent.getWidth()-parent.getPaddingRight();
        for(int i = 0; i < count; i++)
        {
            View v = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) v.getLayoutParams();
            int top = v.getBottom() + params.bottomMargin;
            int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left,top,right,bottom);
            mDivider.draw(c);
        }
    }
}