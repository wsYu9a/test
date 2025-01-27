package com.umeng.commonsdk.service;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.utils.UMUtils;

/* loaded from: classes4.dex */
public class UMGlobalContext {
    private static final String TAG = "UMGlobalContext";
    private String mAppVersion;
    private String mAppkey;
    private Context mApplicationContext;
    private String mChannel;
    private String mProcessName;

    public static class a {

        /* renamed from: a */
        private static final UMGlobalContext f24556a = new UMGlobalContext();

        private a() {
        }
    }

    public /* synthetic */ UMGlobalContext(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static Context getAppContext(Context context) {
        if (a.f24556a.mApplicationContext == null && context != null) {
            a.f24556a.mApplicationContext = context.getApplicationContext();
        }
        return a.f24556a.mApplicationContext;
    }

    public static UMGlobalContext getInstance(Context context) {
        if (a.f24556a.mApplicationContext == null && context != null) {
            a.f24556a.mApplicationContext = context;
        }
        return a.f24556a;
    }

    public String getAppVersion() {
        if (TextUtils.isEmpty(this.mAppVersion)) {
            this.mAppVersion = UMUtils.getAppVersionName(this.mApplicationContext);
        }
        return this.mAppVersion;
    }

    public String getAppkey() {
        if (TextUtils.isEmpty(this.mAppkey)) {
            this.mAppkey = UMConfigure.sAppkey;
        }
        return this.mAppkey;
    }

    public String getChannel() {
        if (TextUtils.isEmpty(this.mChannel)) {
            this.mChannel = UMConfigure.sChannel;
        }
        return this.mChannel;
    }

    public String getProcessName(Context context) {
        if (TextUtils.isEmpty(this.mProcessName)) {
            if (context != null) {
                Context context2 = a.f24556a.mApplicationContext;
                if (context2 != null) {
                    this.mProcessName = UMFrUtils.getCurrentProcessName(context2);
                } else {
                    this.mProcessName = UMFrUtils.getCurrentProcessName(context);
                }
            } else {
                this.mProcessName = UMFrUtils.getCurrentProcessName(a.f24556a.mApplicationContext);
            }
        }
        return this.mProcessName;
    }

    public boolean isMainProcess(Context context) {
        return UMUtils.isMainProgress(context);
    }

    public String toString() {
        if (a.f24556a.mApplicationContext == null) {
            return "uninitialized.";
        }
        StringBuilder sb2 = new StringBuilder("[");
        sb2.append("appkey:" + this.mAppkey + ",");
        sb2.append("channel:" + this.mChannel + ",");
        sb2.append("procName:" + this.mProcessName + "]");
        return sb2.toString();
    }

    private UMGlobalContext() {
        this.mProcessName = "";
    }

    public static Context getAppContext() {
        return a.f24556a.mApplicationContext;
    }
}
