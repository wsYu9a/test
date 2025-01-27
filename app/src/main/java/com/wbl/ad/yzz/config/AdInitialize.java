package com.wbl.ad.yzz.config;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.wbl.ad.yzz.adit.f;
import com.wbl.ad.yzz.adit.h;
import com.wbl.ad.yzz.config.PageOptions;

/* loaded from: classes.dex */
public class AdInitialize {
    private static final String TAG = "AdInitialize";
    private final f mApi;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a */
        public static final AdInitialize f31808a = new AdInitialize();
    }

    public AdInitialize() {
        f fVar;
        try {
            fVar = h.a();
        } catch (Throwable th) {
            com.wbl.ad.yzz.config.a aVar = new com.wbl.ad.yzz.config.a();
            a(th);
            fVar = aVar;
        }
        this.mApi = fVar;
    }

    public static AdInitialize getInstance() {
        return a.f31808a;
    }

    public static String sdkVersionName() {
        return "5.1.0";
    }

    public final void a(Throwable th) {
        if (th != null) {
            Log.e(TAG, "" + th.getMessage());
        }
    }

    public void checkNextChapter(Activity activity, int i2, int i3, int i4, int i5, String str, int i6, CheckNextChapterCallback checkNextChapterCallback) {
        try {
            checkNextChapter(activity, 0, i2, i3, i4, i5, str, i6, checkNextChapterCallback);
        } catch (Throwable th) {
            a(th);
        }
    }

    public void debugLog(String str) {
        try {
            this.mApi.c(str);
        } catch (Throwable th) {
            a(th);
        }
    }

    public boolean enableDebugToast() {
        try {
            return this.mApi.b();
        } catch (Throwable th) {
            a(th);
            return false;
        }
    }

    public void enableLog(boolean z) {
        try {
            this.mApi.c(z);
        } catch (Throwable th) {
            a(th);
        }
    }

    public void initialize(Application application) {
        try {
            initialize(application, null);
        } catch (Throwable th) {
            a(th);
        }
    }

    public boolean isEnableLog() {
        try {
            return this.mApi.a();
        } catch (Throwable th) {
            a(th);
            return false;
        }
    }

    public void membershipApplySucceed() {
        membershipApplySucceed(null);
    }

    public void openWalletPage(Activity activity) {
        openWalletPage(activity, null);
    }

    public void requestPermission(Context context) {
        try {
            this.mApi.a(context);
        } catch (Throwable th) {
            a(th);
        }
    }

    public void setAdEventListener(IAdEventListener iAdEventListener) {
        try {
            this.mApi.a(iAdEventListener);
        } catch (Throwable th) {
            a(th);
        }
    }

    public void setAppChannel(String str) {
        try {
            this.mApi.b(str);
        } catch (Throwable th) {
            a(th);
        }
    }

    public void setAutoPlayMuted(boolean z) {
        try {
            this.mApi.b(z);
        } catch (Throwable th) {
            a(th);
        }
    }

    public void setEnableDebugToast(boolean z) {
        try {
            this.mApi.a(z);
        } catch (Throwable th) {
            a(th);
        }
    }

    public void setOnAdClickListener(OnAdClickListener onAdClickListener) {
        try {
            this.mApi.a(onAdClickListener);
        } catch (Throwable th) {
            a(th);
        }
    }

    public void setPersonalAdSettingListener(IPersonalAdSettingListener iPersonalAdSettingListener) {
        try {
            this.mApi.a(iPersonalAdSettingListener);
        } catch (Throwable th) {
            a(th);
        }
    }

    public void setUserType(int i2) {
        try {
            this.mApi.a(i2);
        } catch (Throwable th) {
            a(th);
        }
    }

    public void setupAdFilter(IConfigAdFilter iConfigAdFilter) {
        try {
            this.mApi.a(iConfigAdFilter);
        } catch (Throwable th) {
            a(th);
        }
    }

    public void startAdPage(Activity activity, PageOptions pageOptions, RewardCallback rewardCallback) {
        if (pageOptions != null && rewardCallback != null) {
            try {
                pageOptions.setRewardCallback(rewardCallback);
            } catch (Throwable th) {
                a(th);
                return;
            }
        }
        this.mApi.c(activity, pageOptions);
    }

    public void turningUpADPage(Activity activity, int i2, int i3, int i4, int i5, String str, int i6, FreeTimeCallBack freeTimeCallBack) {
        try {
            turningUpADPage(activity, 0, i2, i3, i4, i5, str, i6, freeTimeCallBack);
        } catch (Throwable th) {
            a(th);
        }
    }

    public void willShowAd() {
        try {
            this.mApi.c();
        } catch (Throwable th) {
            a(th);
        }
    }

    public void membershipApplySucceed(String str) {
        try {
            this.mApi.a(str);
        } catch (Throwable th) {
            a(th);
        }
    }

    public void openWalletPage(Activity activity, String str) {
        try {
            this.mApi.a(activity, str);
        } catch (Throwable th) {
            a(th);
        }
    }

    public void checkNextChapter(Activity activity, int i2, int i3, int i4, int i5, int i6, String str, int i7, CheckNextChapterCallback checkNextChapterCallback) {
        try {
            this.mApi.b(activity, new PageOptions.Builder().gender(i2).bgType(i3).isInNoAdTime(i4).isActiveCall(i5).isDarkMode(i6).bookId(str).chapterNo(i7).checkNextChapterCallback(checkNextChapterCallback).build());
        } catch (Throwable th) {
            a(th);
        }
    }

    public void enableLog(boolean z, String str) {
        try {
            this.mApi.a(z, str);
        } catch (Throwable th) {
            a(th);
        }
    }

    public void initialize(Application application, AdInitConfig adInitConfig) {
        try {
            this.mApi.a(application, adInitConfig);
        } catch (Throwable th) {
            a(th);
        }
    }

    public void turningUpADPage(Activity activity, int i2, int i3, int i4, int i5, int i6, String str, int i7, FreeTimeCallBack freeTimeCallBack) {
        try {
            this.mApi.a(activity, new PageOptions.Builder().gender(i2).bgType(i3).isInNoAdTime(i4).isActiveCall(i5).isDarkMode(i6).bookId(str).chapterNo(i7).freeTimeCallBack(freeTimeCallBack).build());
        } catch (Throwable th) {
            a(th);
        }
    }

    public void checkNextChapter(Activity activity, PageOptions pageOptions, CheckNextChapterCallback checkNextChapterCallback) {
        if (pageOptions != null && checkNextChapterCallback != null) {
            try {
                pageOptions.setCheckNextChapterCallback(checkNextChapterCallback);
            } catch (Throwable th) {
                a(th);
                return;
            }
        }
        this.mApi.b(activity, pageOptions);
    }

    public void turningUpADPage(Activity activity, PageOptions pageOptions, FreeTimeCallBack freeTimeCallBack) {
        if (pageOptions != null && freeTimeCallBack != null) {
            try {
                pageOptions.setFreeTimeCallBack(freeTimeCallBack);
            } catch (Throwable th) {
                a(th);
                return;
            }
        }
        this.mApi.a(activity, pageOptions);
    }
}
