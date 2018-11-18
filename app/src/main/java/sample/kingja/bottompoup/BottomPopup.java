package sample.kingja.bottompoup;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

/**
 * Description:TODO
 * Create Time:2018/11/18 23:00
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class BottomPopup extends PopupWindow {
    private View parentView;

    public BottomPopup(Context context, View parentView) {
        super(context);
        this.parentView = parentView;
        setContentView(View.inflate(context, R.layout.pop, null));
        setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        setBackgroundDrawable(new ColorDrawable());
        setFocusable(true);
        setOutsideTouchable(true);
        setAnimationStyle(R.style.popwin_anim_style);
    }

    public void showPopupAbove() {
        if (!this.isShowing()) {
//            this.showAtLocation(parentView, Gravity.BOTTOM, 0, 0);
            int[] location = new int[2];
            parentView.getLocationOnScreen(location);
            int measuredHeight = parentView.getMeasuredHeight();
            showAtLocation(parentView, Gravity.BOTTOM,0, measuredHeight);
//            showAtLocation(parentView, Gravity.NO_GRAVITY, location[0], location[1]+getHeight());
        }


    }
}
