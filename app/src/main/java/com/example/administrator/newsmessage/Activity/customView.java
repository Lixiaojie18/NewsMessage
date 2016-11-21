package com.example.administrator.newsmessage.Activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by ${Administrator} on 2016/11/17 0017.
 */

public class customView extends ImageView {

    /**    * 画笔    */
    private Paint mPaint;
    /**    * 原型图    */
    private Bitmap src;
    /**    * 遮罩层    */
    private Bitmap mask;
    public customView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // 初始化画笔
          mPaint = new Paint();
        mPaint.setAntiAlias(true);
        // 拿到原型图
        // src = BitmapFactory.decodeResource(getResources(), R.drawable.ml);
        }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        // 图片的遮罩，为什么要在这里面初始化遮罩层呢？因为在这个方法里Width()和Height()才被初始化了
        mask = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Config.ARGB_4444);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 设置画布的颜色为透明
        canvas.drawColor(Color.TRANSPARENT);
        // 划出你要显示的圆
         Canvas cc = new Canvas(mask);
        cc.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, getMeasuredHeight() / 2, mPaint);
        // 这个方法相当于PS新建图层，下面你要做的事就在这个图层上操作
        canvas.saveLayer(0, 0, getMeasuredWidth(), getMeasuredHeight(), null, Canvas.ALL_SAVE_FLAG);
        // 先绘制遮罩层
        canvas.drawBitmap(mask, 0, 0, mPaint);
        // 设置混合模式
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        // 再绘制src源图
         canvas.drawBitmap(src, 0, 0, mPaint);
        // 还原混合模式
        mPaint.setXfermode(null);
        // 还原画布，相当于Ps的合并图层
          canvas.restore();   }
    }