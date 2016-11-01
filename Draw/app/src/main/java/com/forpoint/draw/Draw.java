package com.forpoint.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/10/16.
 */
public class Draw  extends View {
    public Draw(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

           //设置画布背景色
        canvas.drawColor(Color.GRAY);

        Paint paint=new Paint();

        //画笔颜色
        paint.setColor(Color.BLUE);

        //设置填充类型
        paint.setStyle(Paint.Style.STROKE);

        //设置画笔宽度
        paint.setStrokeWidth(5);

        //绘制普通矩形
        canvas.drawRect(20, 20, 150, 100, paint);

        //绘制三角形，内部填充
        Path path=new Path();
        path.moveTo(250, 400);
        path.lineTo(200, 120);
        path.lineTo(100, 200);
        path.close();
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPath(path, paint);

        Path pathText=new Path();
        pathText.addCircle(200,300,80, Path.Direction.CCW);

   //     canvas.drawTextOnPath("Draw the text, with origin at (x,y), using the specified paint, along the specified path.",pathText,0,10,paint);
    }
}


