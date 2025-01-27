package com.heytap.msp.mobad.api.params;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class SplashSkipView extends FrameLayout {
    private ISplashSkipCountDown mISplashSkipCountDown;

    public interface ISplashSkipCountDown {
        void onSkipCountDownSecond(int i2);
    }

    public SplashSkipView(Context context) {
        super(context);
    }

    public SplashSkipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SplashSkipView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void onSkipCountDown(int i2) {
        ISplashSkipCountDown iSplashSkipCountDown = this.mISplashSkipCountDown;
        if (iSplashSkipCountDown != null) {
            iSplashSkipCountDown.onSkipCountDownSecond(i2);
        }
    }

    public void setSkipCountDownCallBack(ISplashSkipCountDown iSplashSkipCountDown) {
        this.mISplashSkipCountDown = iSplashSkipCountDown;
    }
}
