package com.as.fuyue.customview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.PopupWindow;

import com.as.fuyue.R;


/**'
 *简单popwindow 使用 建议一直用
 */
public class Popup {
    public PopupWindow mPopupWindow;
    @SuppressLint("PrivateResource")
    public Popup(Context context, View view) {
        this.mPopupWindow = new PopupWindow(context);
        this.mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        this.mPopupWindow.setWidth(-1);
        this.mPopupWindow.setHeight(-1);
        this.mPopupWindow.setTouchable(true);
        this.mPopupWindow.setFocusable(true);
        this.mPopupWindow.setOutsideTouchable(true);
        this.mPopupWindow.setAnimationStyle(R.style.showPopupAnimation);
        this.mPopupWindow.setContentView(view);
        this.mPopupWindow.getContentView().setOnTouchListener((v, event) -> {
            Popup.this.mPopupWindow.setFocusable(false);
            Popup.this.mPopupWindow.dismiss();
            return true;
        });
    }

    public void dismiss() {
        if(this.mPopupWindow != null && this.mPopupWindow.isShowing()) {
            this.mPopupWindow.dismiss();
        }
    }

    public void showPopup(View rootView) {
        this.mPopupWindow.showAtLocation(rootView, 80, 0, 0);
    }
}
