package com.sample.study;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.transitionseverywhere.AutoTransition;
import com.transitionseverywhere.ChangeText;
import com.transitionseverywhere.Crossfade;
import com.transitionseverywhere.Transition;
import com.transitionseverywhere.TransitionManager;

public class TransUtils {

    private static boolean mSecondText;

    public abstract static class VisibleToggleClickListener implements View.OnClickListener {

        private boolean mVisible;

        @Override
        public void onClick(View v) {
            mVisible = !mVisible;
            changeVisibility(mVisible);
        }

        protected abstract void changeVisibility(boolean visible);

    }

    public abstract static class bgToggleClickListener implements View.OnClickListener {

        private boolean isChanged;

        @Override
        public void onClick(View v) {
            isChanged = !isChanged;
            changeBg(isChanged);
        }

        protected abstract void changeBg(boolean visible);

    }


    /**
     * 改变可见性的转场
     * @param callView
     * @param child
     * @param root
     */
    public static void visibleTrans(View callView, final View child, final View root){
        callView.setOnClickListener(new TransUtils.VisibleToggleClickListener() {
            @Override
            protected void changeVisibility(boolean visible) {
                TransitionManager.beginDelayedTransition((ViewGroup) root, new AutoTransition());
                child.setVisibility(visible ? View.GONE : View.VISIBLE);
            }
        });
    }

    /**
     * 改变颜色的转场
     * @param callView
     * @param child
     * @param root
     */
    public static void colorTrans(View callView, final View child, final View root){
        callView.setOnClickListener(new TransUtils.bgToggleClickListener() {
            @Override
            protected void changeBg(boolean isChanged) {
                Transition transition = new Crossfade();
                transition.setDuration(3000);
                TransitionManager.beginDelayedTransition((ViewGroup) root,transition);
                child.setBackgroundColor(isChanged ? Color.WHITE : Color.BLACK);
            }
        });
    }

    /**
     * 改变文字的转场
     * @param root
     * @param textView
     * @param text1
     * @param text2
     */
    public static void textTrans(View root, TextView textView, String text1, String text2){
        textView.setOnClickListener(v->{
            mSecondText = !mSecondText;
            TransitionManager.beginDelayedTransition((ViewGroup) root,
                    new ChangeText().setChangeBehavior(ChangeText.CHANGE_BEHAVIOR_OUT_IN));
            textView.setText(mSecondText ? text2 : text1);
        });
    }


}
