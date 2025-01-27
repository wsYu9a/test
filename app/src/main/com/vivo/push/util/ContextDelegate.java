package com.vivo.push.util;

import android.content.Context;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class ContextDelegate {
    private static final String TAG = "ContextDelegate";
    private static Context mContext = null;
    private static Method mCreateCredentialProtectedStorageContext = null;
    private static Method mCreateDeviceProtectedStorageContext = null;
    private static boolean mDelegateEnable = false;
    private static Boolean mIsFbeProject;

    public static class a {

        /* renamed from: a */
        private static ContextDelegate f25107a = new ContextDelegate();
    }

    private static Context createCredentialProtectedStorageContext(Context context) {
        try {
            if (mCreateCredentialProtectedStorageContext == null) {
                mCreateCredentialProtectedStorageContext = Context.class.getMethod("createCredentialProtectedStorageContext", null);
            }
            return (Context) mCreateCredentialProtectedStorageContext.invoke(context, null);
        } catch (Exception e10) {
            e10.printStackTrace();
            return context;
        }
    }

    private static Context createDeviceProtectedStorageContext(Context context) {
        try {
            if (mCreateDeviceProtectedStorageContext == null) {
                mCreateDeviceProtectedStorageContext = Context.class.getMethod("createDeviceProtectedStorageContext", null);
            }
            return (Context) mCreateDeviceProtectedStorageContext.invoke(context, null);
        } catch (Exception e10) {
            e10.printStackTrace();
            return context;
        }
    }

    public static Context getContext(Context context) {
        if (!isFBEProject() || context == null) {
            return context;
        }
        Context context2 = mContext;
        if (context2 != null) {
            return context2;
        }
        setContext(context);
        return mContext;
    }

    public static ContextDelegate getInstance() {
        return a.f25107a;
    }

    public static boolean isFBEProject() {
        if (mIsFbeProject == null) {
            try {
                mIsFbeProject = Boolean.valueOf(com.sigmob.sdk.base.k.f18193y.equals(j.a("ro.crypto.type", "unknow")));
                p.b(TAG, "mIsFbeProject = " + mIsFbeProject.toString());
            } catch (Exception e10) {
                p.a(TAG, "mIsFbeProject = " + e10.getMessage());
            }
        }
        Boolean bool = mIsFbeProject;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    private static void setAppContext() {
        Context context = mContext;
        if (context == null) {
            return;
        }
        setContext(context);
    }

    private static void setContext(Context context) {
        if (mDelegateEnable) {
            mContext = createDeviceProtectedStorageContext(context);
        } else {
            mContext = createCredentialProtectedStorageContext(context);
        }
    }

    public static void setEnable(boolean z10) {
        mDelegateEnable = z10;
        setAppContext();
    }
}
