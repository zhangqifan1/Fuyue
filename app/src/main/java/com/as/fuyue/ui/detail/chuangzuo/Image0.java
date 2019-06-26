

package com.as.fuyue.ui.detail.chuangzuo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.widget.ImageView;

import com.as.fuyue.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

public class Image0 extends AppCompatActivity {

    private Bitmap bgBitmap0, bgBitmap1;
    private Canvas mCanvas0, mCanvas1;
    private Paint mPaint0, mPaint1;
    private ImageView ivBg0,ivBg1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image0);
        //  https://www.jianshu.com/p/d0c5402f1d2b

        ImageView image0 = findViewById(R.id.image0);
        ImageView image1 = findViewById(R.id.image1);

        ivBg0 = findViewById(R.id.bg0);
        ivBg1 = findViewById(R.id.bg1);



        //首先获取图片的 bitmap
//        image0.setDrawingCacheEnabled(true);
//        Bitmap bitmap0 = Bitmap.createBitmap(image0.getDrawingCache());
//        image0.setDrawingCacheEnabled(false);

//        Bitmap bitmap0 = ((BitmapDrawable) image0.getDrawable()).getBitmap();


        Glide.with(this)
                .asBitmap()
                .load(R.drawable.image0)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        //1.首先是要先根据图片 做背景图
                        Palette.from(resource).generate(new Palette.PaletteAsyncListener() {
                            @Override
                            public void onGenerated(Palette palette) {
                                //记得判空
                                if (palette == null) return;

                                //palette取色不一定取得到某些特定的颜色，这里通过取多种颜色来避免取不到颜色的情况
                                if (palette.getDarkVibrantColor(Color.TRANSPARENT) != Color.TRANSPARENT) {
                                    createLinearGradientBitmap0(palette.getDarkVibrantColor(Color.TRANSPARENT), palette.getVibrantColor(Color.TRANSPARENT));
                                } else if (palette.getDarkMutedColor(Color.TRANSPARENT) != Color.TRANSPARENT) {
                                    createLinearGradientBitmap0(palette.getDarkMutedColor(Color.TRANSPARENT), palette.getMutedColor(Color.TRANSPARENT));
                                } else {
                                    createLinearGradientBitmap0(palette.getLightMutedColor(Color.TRANSPARENT), palette.getLightVibrantColor(Color.TRANSPARENT));
                                }
                            }
                        });

//                        image0.setImageBitmap(getImageToChange(resource));
                        image0.setImageBitmap(handleBimap(resource));

                    }
                });



        Glide.with(this)
                .asBitmap()
                .load(R.drawable.image1)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        //1.首先是要先根据图片 做背景图
                        Palette.from(resource).generate(new Palette.PaletteAsyncListener() {
                            @Override
                            public void onGenerated(Palette palette) {
                                //记得判空
                                if (palette == null) return;

                                //palette取色不一定取得到某些特定的颜色，这里通过取多种颜色来避免取不到颜色的情况
                                if (palette.getDarkVibrantColor(Color.TRANSPARENT) != Color.TRANSPARENT) {
                                    createLinearGradientBitmap1(palette.getDarkVibrantColor(Color.TRANSPARENT), palette.getVibrantColor(Color.TRANSPARENT));
                                } else if (palette.getDarkMutedColor(Color.TRANSPARENT) != Color.TRANSPARENT) {
                                    createLinearGradientBitmap1(palette.getDarkMutedColor(Color.TRANSPARENT), palette.getMutedColor(Color.TRANSPARENT));
                                } else {
                                    createLinearGradientBitmap1(palette.getLightMutedColor(Color.TRANSPARENT), palette.getLightVibrantColor(Color.TRANSPARENT));
                                }
                            }
                        });

//                        image0.setImageBitmap(getImageToChange(resource));
                        image1.setImageBitmap(handleBimap(resource));

                    }
                });



    }


    //创建线性渐变背景色
    public void createLinearGradientBitmap1(int darkColor, int color) {
        int bgColors[] = new int[2];
        bgColors[0] = darkColor;
        bgColors[1] = color;

        if (bgBitmap1 == null) {
            bgBitmap1 = Bitmap.createBitmap(ivBg1.getWidth(), ivBg1.getHeight(), Bitmap.Config.ARGB_4444);
        }
        if (mCanvas1 == null) {
            mCanvas1 = new Canvas();
        }
        if (mPaint1 == null) {
            mPaint1 = new Paint();
        }
        mCanvas1.setBitmap(bgBitmap1);
        mCanvas1.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        LinearGradient gradient = new LinearGradient(0, 0, 0, bgBitmap1.getHeight(), bgColors[0], bgColors[1], Shader.TileMode.CLAMP);
        mPaint0.setShader(gradient);
        RectF rectF = new RectF(0, 0, bgBitmap1.getWidth(), bgBitmap1.getHeight());
        // mCanvas.drawRoundRect(rectF,16,16,mPaint); 这个用来绘制圆角的哈
        mCanvas1.drawRect(rectF, mPaint1);
        ivBg1.setImageBitmap(bgBitmap1);
    }


    //创建线性渐变背景色
    public void createLinearGradientBitmap0(int darkColor, int color) {
        int bgColors[] = new int[2];
        bgColors[0] = darkColor;
        bgColors[1] = color;

        if (bgBitmap0 == null) {
            bgBitmap0 = Bitmap.createBitmap(ivBg0.getWidth(), ivBg0.getHeight(), Bitmap.Config.ARGB_4444);
        }
        if (mCanvas0 == null) {
            mCanvas0 = new Canvas();
        }
        if (mPaint0 == null) {
            mPaint0 = new Paint();
        }
        mCanvas0.setBitmap(bgBitmap0);
        mCanvas0.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        LinearGradient gradient = new LinearGradient(0, 0, 0, bgBitmap0.getHeight(), bgColors[0], bgColors[1], Shader.TileMode.CLAMP);
        mPaint0.setShader(gradient);
        RectF rectF = new RectF(0, 0, bgBitmap0.getWidth(), bgBitmap0.getHeight());
        // mCanvas.drawRoundRect(rectF,16,16,mPaint); 这个用来绘制圆角的哈
        mCanvas0.drawRect(rectF, mPaint0);
        ivBg0.setImageBitmap(bgBitmap0);
    }


    //方法1 :修改透明度 性能不咋地
    private Bitmap getImageToChange(Bitmap mBitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(mBitmap.getWidth(), mBitmap.getHeight(), Bitmap.Config.ARGB_4444);
        int mWidth = mBitmap.getWidth();
        int mHeight = mBitmap.getHeight();
        for (int i = 0; i < mHeight; i++) {
            for (int j = 0; j < mWidth; j++) {
                int color = mBitmap.getPixel(j, i);
                int g = Color.green(color);
                int r = Color.red(color);
                int b = Color.blue(color);
                int a = Color.alpha(color);
                //从中间部分开始透明渐变
                float index = i * 1.0f / mHeight;
                if (index > 0.5f) {
                    a = 255 - (int) (i / (mHeight / 2f) * 255);
                }
                color = Color.argb(a, r, g, b);
                createBitmap.setPixel(j, i, color);
            }
        }

        return createBitmap;
    }

    /**
     * 方法2:
     * 通过位移运算来做透渐变，相比之前的方法提高90倍左右
     * @param bitmap
     * @return
     */
    private Bitmap handleBimap(Bitmap bitmap) {
        //透明渐变
        int[] argb = new int[bitmap.getWidth() * bitmap.getHeight()];
        bitmap.getPixels(argb, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());

        //循环开始的下标，设置从什么时候开始改变
        int start = argb.length / 2;
        int end=argb.length;

//        int mid = argb.length;
//        int row = ((mid - start) / bitmap.getHeight()) + 2;


        int width = bitmap.getWidth();
        for (int i = 0; i < bitmap.getHeight()/2+1; i++) {
            for (int j = 0; j < width; j++) {
                int index = start - width + i * width + j;
                if (argb[index] != 0) {
                    argb[index] = ((int) ((1-i/(bitmap.getHeight()/2f)) * 255) << 24) | (argb[index] & 0x00FFFFFF);
                }
            }
        }
//        for (int i = mid; i < argb.length; i++) {
//            argb[i] = (argb[i] & 0x00FFFFFF);
//        }

        return Bitmap.createBitmap(argb, bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);

    }
}
