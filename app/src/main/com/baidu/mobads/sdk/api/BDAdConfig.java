package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.aa;
import com.baidu.mobads.sdk.internal.ay;
import com.baidu.mobads.sdk.internal.bc;
import com.baidu.mobads.sdk.internal.cq;
import com.baidu.mobads.sdk.internal.e;
import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BDAdConfig {
    private Context mAppContext;
    private String mAppName;
    private String mAppsid;
    private BDAdInitListener mBDAdInitListener;
    private String mChannelId;
    private boolean mCloseShake;
    private JSONObject mConfigObj;
    private boolean mDebug;
    private JSONObject mDialogParams;
    private JSONObject mExtraParams;
    private boolean mHttps;
    private boolean mLpMultiProcess;
    private boolean mMtjSwitch;
    private boolean mSplashLog;
    private boolean mUseActivityDialog;
    private int mVideoCacheCapacityMb;
    private String mWXAPPid;

    /* renamed from: com.baidu.mobads.sdk.api.BDAdConfig$1 */
    class AnonymousClass1 implements aa.a {
        public AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.internal.aa.a
        public void onFailure() {
            if (BDAdConfig.this.mBDAdInitListener != null) {
                BDAdConfig.this.mBDAdInitListener.fail();
            }
        }

        @Override // com.baidu.mobads.sdk.internal.aa.a
        public void onSuccess() {
            IXAdContainerFactory c10 = aa.a().c();
            if (c10 != null) {
                c10.initConfig(BDAdConfig.this.mConfigObj);
                c10.onTaskDistribute(bc.f6856a, MobadsPermissionSettings.getPermissionInfo());
            }
            if (BDAdConfig.this.mBDAdInitListener != null) {
                BDAdConfig.this.mBDAdInitListener.success();
            }
        }
    }

    /* renamed from: com.baidu.mobads.sdk.api.BDAdConfig$2 */
    class AnonymousClass2 implements aa.a {
        public AnonymousClass2() {
        }

        @Override // com.baidu.mobads.sdk.internal.aa.a
        public void onFailure() {
            if (BDAdConfig.this.mBDAdInitListener != null) {
                BDAdConfig.this.mBDAdInitListener.fail();
            }
        }

        @Override // com.baidu.mobads.sdk.internal.aa.a
        public void onSuccess() {
            aa.a().c();
            if (BDAdConfig.this.mBDAdInitListener != null) {
                BDAdConfig.this.mBDAdInitListener.success();
            }
        }
    }

    public interface BDAdInitListener {
        void fail();

        void success();
    }

    public static class Builder {
        private String mAppName;
        private String mAppsid;
        private BDAdInitListener mBDAdInitListener;
        private String mChannelId;
        private JSONObject mDialogParams;
        private JSONObject mExtraParams;
        private boolean mLpSupportMultiProcess;
        private int mVideoCacheCapacityMb;
        private String mWXAPPid;
        private boolean mHttps = true;
        private boolean mUseActivityDialog = true;
        private boolean mMtjSwitch = true;
        private boolean mCloseShake = false;
        private boolean mDebug = false;
        private boolean mSplashLog = false;

        public BDAdConfig build(Context context) {
            return new BDAdConfig(context, this);
        }

        public Builder putExtraParam(String str, String str2) {
            if (this.mExtraParams == null) {
                this.mExtraParams = new JSONObject();
            }
            try {
                this.mExtraParams.put(str, str2);
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
            return this;
        }

        public Builder setAppName(String str) {
            this.mAppName = str;
            return this;
        }

        public Builder setAppsid(String str) {
            this.mAppsid = str;
            return this;
        }

        public Builder setBDAdInitListener(BDAdInitListener bDAdInitListener) {
            this.mBDAdInitListener = bDAdInitListener;
            return this;
        }

        public Builder setChannelId(String str) {
            this.mChannelId = str;
            return this;
        }

        public Builder setCloseShake(boolean z10) {
            this.mCloseShake = z10;
            return this;
        }

        public Builder setDebug(boolean z10) {
            this.mDebug = z10;
            return this;
        }

        public Builder setDialogParams(BDDialogParams bDDialogParams) {
            this.mDialogParams = bDDialogParams.toJson();
            return this;
        }

        public Builder setHttps(boolean z10) {
            this.mHttps = z10;
            return this;
        }

        public Builder setLpMultiProcess(boolean z10) {
            this.mLpSupportMultiProcess = z10;
            return this;
        }

        public Builder setMtjSwitch(boolean z10) {
            this.mMtjSwitch = z10;
            return this;
        }

        public Builder setSplashLog(boolean z10) {
            this.mSplashLog = z10;
            return this;
        }

        public Builder setVideoCacheCapacityMb(int i10) {
            this.mVideoCacheCapacityMb = i10;
            return this;
        }

        public Builder setWXAppid(String str) {
            this.mWXAPPid = str;
            return this;
        }

        @Deprecated
        public Builder useActivityDialog(Boolean bool) {
            this.mUseActivityDialog = bool.booleanValue();
            return this;
        }
    }

    public /* synthetic */ BDAdConfig(Context context, Builder builder, AnonymousClass1 anonymousClass1) {
        this(context, builder);
    }

    public static void clearMemoryCache() {
        try {
            aa.a().c().onTaskDistribute(bc.f6858c, null);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private void initConfig() {
        try {
            if (this.mConfigObj == null) {
                this.mConfigObj = new JSONObject();
            }
            this.mConfigObj.put("https", "" + this.mHttps);
            this.mConfigObj.put("appName", this.mAppName);
            this.mConfigObj.put("videoCacheSize", "" + this.mVideoCacheCapacityMb);
            this.mConfigObj.put("appsid", this.mAppsid);
            this.mConfigObj.put(URLPackage.KEY_CHANNEL_ID, this.mChannelId);
            this.mConfigObj.put("lpMultiProcess", "" + this.mLpMultiProcess);
            this.mConfigObj.put("useActivityDialog", "" + this.mUseActivityDialog);
            this.mConfigObj.put("dialog_params", this.mDialogParams);
            this.mConfigObj.put("mtj_switch", this.mMtjSwitch);
            this.mConfigObj.put("sp_shake", this.mCloseShake);
            this.mConfigObj.put("sdk_debug", this.mDebug);
            this.mConfigObj.put("splashLog", this.mSplashLog);
            this.mConfigObj.put("extras", this.mExtraParams);
            if (!TextUtils.isEmpty(this.mWXAPPid)) {
                this.mConfigObj.put("wxAppid", this.mWXAPPid);
            }
            cq.a().a(this.mLpMultiProcess);
            cq.a().b(this.mHttps);
            ay.a(this.mDebug);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void init() {
        initConfig();
        JSONObject jSONObject = this.mConfigObj;
        if (jSONObject != null) {
            try {
                jSONObject.put("gmss", e.a());
                this.mConfigObj.put("toss", e.b());
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
        aa.a().a(this.mAppContext, new aa.a() { // from class: com.baidu.mobads.sdk.api.BDAdConfig.1
            public AnonymousClass1() {
            }

            @Override // com.baidu.mobads.sdk.internal.aa.a
            public void onFailure() {
                if (BDAdConfig.this.mBDAdInitListener != null) {
                    BDAdConfig.this.mBDAdInitListener.fail();
                }
            }

            @Override // com.baidu.mobads.sdk.internal.aa.a
            public void onSuccess() {
                IXAdContainerFactory c10 = aa.a().c();
                if (c10 != null) {
                    c10.initConfig(BDAdConfig.this.mConfigObj);
                    c10.onTaskDistribute(bc.f6856a, MobadsPermissionSettings.getPermissionInfo());
                }
                if (BDAdConfig.this.mBDAdInitListener != null) {
                    BDAdConfig.this.mBDAdInitListener.success();
                }
            }
        });
    }

    public void preInit() {
        try {
            initConfig();
            aa.a().a(this.mAppContext, new aa.a() { // from class: com.baidu.mobads.sdk.api.BDAdConfig.2
                public AnonymousClass2() {
                }

                @Override // com.baidu.mobads.sdk.internal.aa.a
                public void onFailure() {
                    if (BDAdConfig.this.mBDAdInitListener != null) {
                        BDAdConfig.this.mBDAdInitListener.fail();
                    }
                }

                @Override // com.baidu.mobads.sdk.internal.aa.a
                public void onSuccess() {
                    aa.a().c();
                    if (BDAdConfig.this.mBDAdInitListener != null) {
                        BDAdConfig.this.mBDAdInitListener.success();
                    }
                }
            });
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private BDAdConfig(Context context, Builder builder) {
        this.mUseActivityDialog = true;
        this.mDebug = false;
        this.mSplashLog = false;
        this.mHttps = builder.mHttps;
        this.mAppContext = context;
        this.mVideoCacheCapacityMb = builder.mVideoCacheCapacityMb;
        this.mAppName = builder.mAppName;
        this.mAppsid = builder.mAppsid;
        this.mChannelId = builder.mChannelId;
        this.mLpMultiProcess = builder.mLpSupportMultiProcess;
        this.mUseActivityDialog = builder.mUseActivityDialog;
        this.mDialogParams = builder.mDialogParams;
        this.mMtjSwitch = builder.mMtjSwitch;
        this.mCloseShake = builder.mCloseShake;
        this.mDebug = builder.mDebug;
        this.mWXAPPid = builder.mWXAPPid;
        this.mBDAdInitListener = builder.mBDAdInitListener;
        this.mSplashLog = builder.mSplashLog;
        this.mExtraParams = builder.mExtraParams;
    }
}
