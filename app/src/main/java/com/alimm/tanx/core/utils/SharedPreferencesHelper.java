package com.alimm.tanx.core.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.utils.ThreadUtils;

/* loaded from: classes.dex */
public class SharedPreferencesHelper implements NotConfused {
    public static final String KEY_DEBUG_URL_SWITCH = "KEY_DEBUG_URL_SWITCH";
    public static final String KEY_ENCRYPT_SWITCH = "KEY_ENCRYPT_SWITCH";
    public static final String KEY_HTTPS_SWITCH = "KEY_HTTPS_SWITCH";
    public static final String KEY_ORANGE = "KEY_ORANGE";
    public static final String KEY_SETTING = "KEY_SETTING";
    public static final String KEY_SPLASH_AD_COUNT = "key_splash_ad_count";
    public static final String KEY_SPLASH_AD_RT_DOWN_VIDEO = "key_splash_ad_rt_down_video";
    public static final String KEY_SPLASH_COVER = "KEY_SPLASH_COVER";
    public static final String KEY_SPLASH_COVER_H_RATIO = "key_splash_cover_h_ratio";
    public static final String KEY_SPLASH_COVER_TIME = "key_splash_cover_time";
    public static final String KEY_SPLASH_COVER_TIME_DURATION = "key_splash_cover_time_duration";
    public static final String KEY_SPLASH_COVER_W_RATIO = "key_splash_cover_w_ratio";
    public static final String KEY_SPLASH_PRELOAD_SWITCH = "KEY_SPLASH_PRELOAD_SWITCH";
    public static final String REWARD_URL = "RewardUrl";
    private static final String TAG = "SharedPreferencesHelper";
    private static SharedPreferencesHelper mInstance;
    private final SharedPreferences mPrefs;

    /* renamed from: com.alimm.tanx.core.utils.SharedPreferencesHelper$1 */
    public class AnonymousClass1 extends ThreadUtils.SimpleTask<Object> {
        final /* synthetic */ String val$k;
        final /* synthetic */ String val$v;

        public AnonymousClass1(String str, String str2) {
            str = str;
            str2 = str2;
        }

        @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
        public Object doInBackground() throws Throwable {
            SharedPreferences.Editor edit = SharedPreferencesHelper.this.mPrefs.edit();
            edit.putString(str, str2);
            edit.apply();
            return null;
        }

        @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
        public void onSuccess(Object obj) {
        }
    }

    /* renamed from: com.alimm.tanx.core.utils.SharedPreferencesHelper$2 */
    public class AnonymousClass2 extends ThreadUtils.SimpleTask<Object> {
        final /* synthetic */ String val$k;
        final /* synthetic */ float val$v;

        public AnonymousClass2(String str, float f10) {
            str = str;
            f10 = f10;
        }

        @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
        public Object doInBackground() throws Throwable {
            SharedPreferences.Editor edit = SharedPreferencesHelper.this.mPrefs.edit();
            edit.putFloat(str, f10);
            edit.apply();
            return null;
        }

        @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
        public void onSuccess(Object obj) {
        }
    }

    /* renamed from: com.alimm.tanx.core.utils.SharedPreferencesHelper$3 */
    public class AnonymousClass3 extends ThreadUtils.SimpleTask<Object> {
        final /* synthetic */ String val$k;
        final /* synthetic */ Integer val$v;

        public AnonymousClass3(String str, Integer num) {
            str = str;
            num = num;
        }

        @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
        public Object doInBackground() throws Throwable {
            SharedPreferences.Editor edit = SharedPreferencesHelper.this.mPrefs.edit();
            edit.putInt(str, num.intValue());
            edit.apply();
            return null;
        }

        @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
        public void onSuccess(Object obj) {
        }
    }

    /* renamed from: com.alimm.tanx.core.utils.SharedPreferencesHelper$4 */
    public class AnonymousClass4 extends ThreadUtils.SimpleTask<Object> {
        final /* synthetic */ boolean val$v;

        public AnonymousClass4(boolean z10) {
            z10 = z10;
        }

        @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
        public Object doInBackground() throws Throwable {
            SharedPreferences.Editor edit = SharedPreferencesHelper.this.mPrefs.edit();
            edit.putBoolean(SharedPreferencesHelper.KEY_DEBUG_URL_SWITCH, z10);
            edit.apply();
            return null;
        }

        @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
        public void onSuccess(Object obj) {
        }
    }

    /* renamed from: com.alimm.tanx.core.utils.SharedPreferencesHelper$5 */
    public class AnonymousClass5 extends ThreadUtils.SimpleTask<Object> {
        final /* synthetic */ String val$key;
        final /* synthetic */ Boolean val$v;

        public AnonymousClass5(String str, Boolean bool) {
            str = str;
            bool = bool;
        }

        @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
        public Object doInBackground() throws Throwable {
            SharedPreferences.Editor edit = SharedPreferencesHelper.this.mPrefs.edit();
            edit.putBoolean(str, bool.booleanValue());
            edit.apply();
            return null;
        }

        @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
        public void onSuccess(Object obj) {
        }
    }

    private SharedPreferencesHelper(Context context) {
        this.mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static SharedPreferencesHelper getInstance() {
        return getInstance(TanxCoreSdk.getApplication());
    }

    public boolean getBoolean(String str, Boolean bool) {
        return this.mPrefs.getBoolean(str, bool.booleanValue());
    }

    public boolean getDebugUrlBoolean() {
        boolean z10 = this.mPrefs.getBoolean(KEY_DEBUG_URL_SWITCH, false);
        LogUtils.d2print(TAG, "now deBugUrl Switch ->" + z10);
        return z10;
    }

    public boolean getEncryptBoolean() {
        boolean z10 = getBoolean(KEY_ENCRYPT_SWITCH, Boolean.TRUE);
        LogUtils.d(TAG, "now encryptSwitch ->" + z10);
        return z10;
    }

    public float getFloat(String str) {
        return this.mPrefs.getFloat(str, 0.0f);
    }

    public boolean getHttpsBoolean() {
        boolean z10 = getBoolean(KEY_HTTPS_SWITCH, Boolean.FALSE);
        LogUtils.d2print(TAG, "now httpsSwitch ->" + z10);
        return z10;
    }

    public int getInt(String str) {
        return this.mPrefs.getInt(str, 0);
    }

    public boolean getSplashPreloadBoolean() {
        boolean z10 = getBoolean(KEY_SPLASH_PRELOAD_SWITCH, Boolean.TRUE);
        LogUtils.d(TAG, "now splashPreload ->" + z10);
        return z10;
    }

    public String getString(String str) {
        return this.mPrefs.getString(str, "");
    }

    public boolean isOpenSplashCover() {
        return this.mPrefs.getBoolean(KEY_SPLASH_COVER, false);
    }

    public void putBoolean(String str, Boolean bool) {
        ThreadUtils.executeByIo(new ThreadUtils.SimpleTask<Object>() { // from class: com.alimm.tanx.core.utils.SharedPreferencesHelper.5
            final /* synthetic */ String val$key;
            final /* synthetic */ Boolean val$v;

            public AnonymousClass5(String str2, Boolean bool2) {
                str = str2;
                bool = bool2;
            }

            @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
            public Object doInBackground() throws Throwable {
                SharedPreferences.Editor edit = SharedPreferencesHelper.this.mPrefs.edit();
                edit.putBoolean(str, bool.booleanValue());
                edit.apply();
                return null;
            }

            @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
            public void onSuccess(Object obj) {
            }
        });
    }

    public void putDebugUrlBoolean(boolean z10) {
        ThreadUtils.executeByIo(new ThreadUtils.SimpleTask<Object>() { // from class: com.alimm.tanx.core.utils.SharedPreferencesHelper.4
            final /* synthetic */ boolean val$v;

            public AnonymousClass4(boolean z102) {
                z10 = z102;
            }

            @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
            public Object doInBackground() throws Throwable {
                SharedPreferences.Editor edit = SharedPreferencesHelper.this.mPrefs.edit();
                edit.putBoolean(SharedPreferencesHelper.KEY_DEBUG_URL_SWITCH, z10);
                edit.apply();
                return null;
            }

            @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
            public void onSuccess(Object obj) {
            }
        });
    }

    public void putEncryptBoolean(boolean z10) {
        putBoolean(KEY_ENCRYPT_SWITCH, Boolean.valueOf(z10));
    }

    public void putFloat(String str, float f10) {
        ThreadUtils.executeByIo(new ThreadUtils.SimpleTask<Object>() { // from class: com.alimm.tanx.core.utils.SharedPreferencesHelper.2
            final /* synthetic */ String val$k;
            final /* synthetic */ float val$v;

            public AnonymousClass2(String str2, float f102) {
                str = str2;
                f10 = f102;
            }

            @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
            public Object doInBackground() throws Throwable {
                SharedPreferences.Editor edit = SharedPreferencesHelper.this.mPrefs.edit();
                edit.putFloat(str, f10);
                edit.apply();
                return null;
            }

            @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
            public void onSuccess(Object obj) {
            }
        });
    }

    public void putHttpsBoolean(boolean z10) {
        putBoolean(KEY_HTTPS_SWITCH, Boolean.valueOf(z10));
    }

    public void putInt(String str, Integer num) {
        ThreadUtils.executeByIo(new ThreadUtils.SimpleTask<Object>() { // from class: com.alimm.tanx.core.utils.SharedPreferencesHelper.3
            final /* synthetic */ String val$k;
            final /* synthetic */ Integer val$v;

            public AnonymousClass3(String str2, Integer num2) {
                str = str2;
                num = num2;
            }

            @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
            public Object doInBackground() throws Throwable {
                SharedPreferences.Editor edit = SharedPreferencesHelper.this.mPrefs.edit();
                edit.putInt(str, num.intValue());
                edit.apply();
                return null;
            }

            @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
            public void onSuccess(Object obj) {
            }
        });
    }

    public void putSplashPreloadBoolean(boolean z10) {
        putBoolean(KEY_SPLASH_PRELOAD_SWITCH, Boolean.valueOf(z10));
    }

    public void putString(String str, String str2) {
        ThreadUtils.executeByIo(new ThreadUtils.SimpleTask<Object>() { // from class: com.alimm.tanx.core.utils.SharedPreferencesHelper.1
            final /* synthetic */ String val$k;
            final /* synthetic */ String val$v;

            public AnonymousClass1(String str3, String str22) {
                str = str3;
                str2 = str22;
            }

            @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
            public Object doInBackground() throws Throwable {
                SharedPreferences.Editor edit = SharedPreferencesHelper.this.mPrefs.edit();
                edit.putString(str, str2);
                edit.apply();
                return null;
            }

            @Override // com.alimm.tanx.core.utils.ThreadUtils.Task
            public void onSuccess(Object obj) {
            }
        });
    }

    public void switchSplashCover(boolean z10) {
        SharedPreferences.Editor edit = this.mPrefs.edit();
        edit.putBoolean(KEY_SPLASH_COVER, z10);
        edit.apply();
    }

    public static SharedPreferencesHelper getInstance(Context context) {
        if (mInstance == null) {
            synchronized (SharedPreferencesHelper.class) {
                try {
                    if (mInstance == null) {
                        mInstance = new SharedPreferencesHelper(context);
                    }
                } finally {
                }
            }
        }
        return mInstance;
    }

    public int getInt(String str, int i10) {
        return this.mPrefs.getInt(str, i10);
    }
}
