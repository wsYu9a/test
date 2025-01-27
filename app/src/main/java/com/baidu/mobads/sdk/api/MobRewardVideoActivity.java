package com.baidu.mobads.sdk.api;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.internal.bq;

/* loaded from: classes.dex */
public class MobRewardVideoActivity extends Activity {
    private static IActivityImpl tempRewardVideo;
    private IActivityImpl mRewardVideo;

    public static void setActivityImp(IActivityImpl iActivityImpl) {
        tempRewardVideo = iActivityImpl;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        IActivityImpl iActivityImpl = this.mRewardVideo;
        if (iActivityImpl != null) {
            iActivityImpl.onAttachedToWindow();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        IActivityImpl iActivityImpl = this.mRewardVideo;
        if (iActivityImpl != null ? iActivityImpl.onBackPressed() : false) {
            return;
        }
        super.onBackPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        IActivityImpl iActivityImpl = this.mRewardVideo;
        if (iActivityImpl != null) {
            iActivityImpl.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        IActivityImpl iActivityImpl = tempRewardVideo;
        if (iActivityImpl != null && this.mRewardVideo == null) {
            this.mRewardVideo = iActivityImpl;
            tempRewardVideo = null;
        }
        IActivityImpl iActivityImpl2 = this.mRewardVideo;
        if (iActivityImpl2 != null) {
            iActivityImpl2.setActivity(this);
            this.mRewardVideo.onCreate(bundle);
        }
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        IActivityImpl iActivityImpl = this.mRewardVideo;
        if (iActivityImpl != null) {
            iActivityImpl.onDestroy();
            this.mRewardVideo = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        IActivityImpl iActivityImpl = this.mRewardVideo;
        if (iActivityImpl != null) {
            iActivityImpl.onDetachedFromWindow();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        IActivityImpl iActivityImpl = tempRewardVideo;
        if (iActivityImpl != null && this.mRewardVideo == null) {
            this.mRewardVideo = iActivityImpl;
            tempRewardVideo = null;
        }
        IActivityImpl iActivityImpl2 = this.mRewardVideo;
        if (iActivityImpl2 != null) {
            iActivityImpl2.onNewIntent(intent);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        IActivityImpl iActivityImpl = this.mRewardVideo;
        if (iActivityImpl != null) {
            iActivityImpl.onPause();
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(@NonNull Bundle bundle) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            if (classLoader != null) {
                bundle.setClassLoader(classLoader);
                Bundle bundle2 = bundle.getBundle("android:viewHierarchyState");
                if (bundle2 != null) {
                    bundle2.setClassLoader(classLoader);
                }
            }
            super.onRestoreInstanceState(bundle);
            IActivityImpl iActivityImpl = this.mRewardVideo;
            if (iActivityImpl != null) {
                iActivityImpl.onRestoreInstanceState(bundle);
            }
        } catch (Throwable th) {
            bq.a().c(th.getMessage());
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        IActivityImpl iActivityImpl = this.mRewardVideo;
        if (iActivityImpl != null) {
            iActivityImpl.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        IActivityImpl iActivityImpl = this.mRewardVideo;
        if (iActivityImpl != null) {
            iActivityImpl.onSaveInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        IActivityImpl iActivityImpl = this.mRewardVideo;
        if (iActivityImpl != null) {
            iActivityImpl.onStop();
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IActivityImpl iActivityImpl = this.mRewardVideo;
        if (iActivityImpl != null ? iActivityImpl.onTouchEvent(motionEvent) : false) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        IActivityImpl iActivityImpl = this.mRewardVideo;
        if (iActivityImpl != null) {
            iActivityImpl.onWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i2, int i3) {
        super.overridePendingTransition(i2, i3);
        IActivityImpl iActivityImpl = this.mRewardVideo;
        if (iActivityImpl != null) {
            iActivityImpl.overridePendingTransition(i2, i3);
        }
    }
}
