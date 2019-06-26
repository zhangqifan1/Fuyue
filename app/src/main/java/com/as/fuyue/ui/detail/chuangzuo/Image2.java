package com.as.fuyue.ui.detail.chuangzuo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.as.fuyue.R;

public class Image2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image2);
        ImageView iv0 = findViewById(R.id.iv0);
        ImageView iv1 = findViewById(R.id.iv1);
        ImageView iv2 = findViewById(R.id.iv2);
        ImageView iv3 = findViewById(R.id.iv3);
        ImageView iv4 = findViewById(R.id.iv4);
        left(iv1);
        right(iv2);
        leftx(iv4);


        Bitmap reverseBitmapById = getReverseBitmapById(Image2.this, R.drawable.image0, 0.9f);
        iv3.setImageBitmap(reverseBitmapById);
        TranslateAnimation animation = new TranslateAnimation(0,100,0,100);
        animation.setFillAfter(true);
        iv3.setAnimation(animation);

    }

    private void left(ImageView iv1) {
        //获取资源图片
        Bitmap bm = BitmapFactory.decodeResource(getResources(),R.drawable.image0);

        //处理
        Bitmap modBm = Bitmap.createBitmap(bm.getWidth(),bm.getHeight(),bm.getConfig());

        //处理画布  重新绘制图形  形成镜像
        Canvas canvas = new Canvas(modBm);

        Paint paint = new Paint();
//        paint.setColor(Color.BLACK);
//        paint.setAntiAlias(true);

        //绘制矩阵  Matrix主要用于对平面进行平移(Translate)，缩放(Scale)，旋转(Rotate)以及斜切(Skew)操作。
        Matrix matrix = new Matrix();
//        matrix.setRotate(90,bm.getWidth()/2,bm.getHeight());
//        matrix.setTranslate(20,20);
        //镜子效果：
        matrix.setScale(-1,1);//翻转
        matrix.postTranslate(bm.getWidth(),0);

        canvas.drawBitmap(bm,matrix,paint);
        iv1.setImageBitmap(modBm);
    }
    private void right(ImageView iv2) {
        //获取资源图片
        Bitmap bm = BitmapFactory.decodeResource(getResources(),R.drawable.image0);

        //处理
        Bitmap modBm = Bitmap.createBitmap(bm.getWidth(),bm.getHeight(),bm.getConfig());

        //处理画布  重新绘制图形  形成镜像
        Canvas canvas = new Canvas(modBm);

        Paint paint = new Paint();
//        paint.setColor(Color.BLACK);
//        paint.setAntiAlias(true);

        //绘制矩阵  Matrix主要用于对平面进行平移(Translate)，缩放(Scale)，旋转(Rotate)以及斜切(Skew)操作。
        Matrix matrix = new Matrix();
//        matrix.setRotate(90,bm.getWidth()/2,bm.getHeight());
//        matrix.setTranslate(20,20);
        //镜子效果：
        matrix.setScale(-1,1);//翻转
        matrix.postTranslate(bm.getWidth(),0);

        canvas.drawBitmap(bm,matrix,paint);
        iv2.setImageBitmap(modBm);
//        ObjectAnimator animator = ObjectAnimator.ofFloat(iv2, "rotationX", 0f, 180f);
//        animator.setDuration(1000);
//        animator.start();
        RotateAnimation animation = new RotateAnimation(0,180, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        animation.setFillAfter(true);
        iv2.setAnimation(animation);
    }

    /**
     * @param context 上下文
     * @param resId   图片id
     * @param percent 倒影的深度
     * @return Bitmap
     */
    public Bitmap getReverseBitmapById(Context context, int resId, float percent) {
        // 获取原始位图
        Bitmap srcBitmap = BitmapFactory.decodeResource(context.getResources(), resId);

        // 运用Matrix类反转像素
        Matrix matrix = new Matrix();
        matrix.setScale(1, -1);

        //创建倒影位图
        Bitmap rvsBitmap = Bitmap.createBitmap(srcBitmap, 0, (int) (srcBitmap.getHeight() * (1 - percent)),
                srcBitmap.getWidth(), (int) (srcBitmap.getHeight() * percent), matrix, false);

        // 根据上面原始位图和倒影位图高度+相隔20的高度创建新位图
        Bitmap comBitmap = Bitmap.createBitmap(srcBitmap.getWidth(),
                srcBitmap.getHeight() + rvsBitmap.getHeight() + 20, srcBitmap.getConfig());

        //绘制出原始位图和倒影位图
        Canvas gCanvas = new Canvas(comBitmap);
        gCanvas.drawBitmap(srcBitmap, 0, 0, null);
        gCanvas.drawBitmap(rvsBitmap, 0, srcBitmap.getHeight() + 20, null);


        Paint paint = new Paint();

        //LinearGradient,我们可以将之译为线型渐变、线型渲染等
        //Shader.TileMode.CLAMP,这种模式表示重复最后一种颜色直到该View结束的地方
        LinearGradient shader = new LinearGradient(0, srcBitmap.getHeight() + 20, 0, comBitmap.getHeight(),
                Color.BLACK, Color.TRANSPARENT, Shader.TileMode.CLAMP);
        paint.setShader(shader);

        //setXfermode图像混合
        //DST_IN为显示上方覆盖内容
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));

        gCanvas.drawRect(0, srcBitmap.getHeight() + 20, srcBitmap.getWidth(), comBitmap.getHeight(), paint);
        return comBitmap;
    }
    private void leftx(ImageView iv4) {
        //获取资源图片
        Bitmap bm = BitmapFactory.decodeResource(getResources(),R.drawable.image0);
        iv4.setImageBitmap(bm);

        RotateAnimation animation = new RotateAnimation(0,180, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        animation.setFillAfter(true);
        iv4.setAnimation(animation);
    }
}
