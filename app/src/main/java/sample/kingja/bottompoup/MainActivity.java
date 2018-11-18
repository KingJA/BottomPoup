package sample.kingja.bottompoup;

import android.animation.Animator;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_pop;
    private LinearLayout ll_pop;
    private boolean show;
    private TranslateAnimation mShowAction;
    private TranslateAnimation mHiddenAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_pop = findViewById(R.id.tv_pop);
        ll_pop = findViewById(R.id.ll_pop);
//        LayoutTransition transition = new LayoutTransition();
//        // 子View添加到mContainer时的动画
//        Animator appearAnim = ObjectAnimator
//                .ofFloat(null, "translationY", 90, 0)
//                .setDuration(transition.getDuration(LayoutTransition.APPEARING));
//        transition.setAnimator(LayoutTransition.APPEARING, appearAnim);
//        // 子Veiw从mContainer中移除时的动画
//        Animator disappearAnim = ObjectAnimator
//                .ofFloat(null, "translationY", 0, 90)
//                .setDuration(transition.getDuration(LayoutTransition.DISAPPEARING));
//        transition.setAnimator(LayoutTransition.DISAPPEARING, disappearAnim);
//
//        ll_pop.setLayoutTransition(transition);



//        ll_pop.setAnimation(AnimationUtils.loadAnimation(this,R.anim.pop_enter_anim));

        mShowAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                2.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        mShowAction.setDuration(500);

        mHiddenAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                2.0f);
        mHiddenAction.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ll_pop.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mHiddenAction.setDuration(500);


    }

    public void open(View view) {
//        BottomPopup bottomPopup = new BottomPopup(this,tv_pop);
//        bottomPopup.showPopupAbove();
        show = !show;
//        ll_pop.setVisibility(show ? View.VISIBLE : View.GONE);

        if (show) {
            ll_pop.startAnimation(mShowAction);
            ll_pop.setVisibility(View.VISIBLE);
        }else{
            ll_pop.startAnimation(mHiddenAction);

        }

    }


}
