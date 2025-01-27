package com.kwad.sdk.oaid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.e;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;

@Keep
/* loaded from: classes2.dex */
public class OADIDSDKHelper {
    private static final String SUB_TAG = "OADIDSDKHelper:";
    private static final String TAG = "KSAdSDK";
    private static boolean mIsRequestIng = false;
    private static boolean sGetOaidFail = false;

    @Keep
    static class IIdentifierListenerImpl implements IIdentifierListener {
        private final a mOaidListener;
        private final long mStartTime;

        public IIdentifierListenerImpl(long j2, a aVar) {
            this.mStartTime = j2;
            this.mOaidListener = aVar;
        }

        public void onSupport(IdSupplier idSupplier) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            if (idSupplier != null) {
                String oaid = idSupplier.getOAID();
                if (TextUtils.isEmpty(oaid)) {
                    boolean unused = OADIDSDKHelper.sGetOaidFail = true;
                } else {
                    Log.d(OADIDSDKHelper.TAG, "OADIDSDKHelper:oaid time=" + currentTimeMillis + "--OAID:" + oaid);
                    this.mOaidListener.cw(oaid);
                }
            }
            boolean unused2 = OADIDSDKHelper.mIsRequestIng = false;
        }
    }

    public interface a {
        void cw(String str);
    }

    public static void getOAId(Context context, a aVar) {
        if (context == null || sGetOaidFail) {
            return;
        }
        if (!isSupport()) {
            sGetOaidFail = true;
            return;
        }
        if (mIsRequestIng) {
            return;
        }
        mIsRequestIng = true;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            int InitSdk = MdidSdkHelper.InitSdk(context.getApplicationContext(), true, new IIdentifierListenerImpl(currentTimeMillis, aVar));
            Log.d(TAG, "OADIDSDKHelper:sdk init time=" + (System.currentTimeMillis() - currentTimeMillis) + "--result=" + InitSdk);
        } catch (Throwable unused) {
            Log.d(TAG, "OADIDSDKHelper:oaid sdk not find ");
            mIsRequestIng = false;
            sGetOaidFail = true;
        }
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public static boolean isSupport() {
        String str;
        if (Build.VERSION.SDK_INT < 16) {
            return false;
        }
        try {
            new IIdentifierListener() { // from class: com.kwad.sdk.oaid.OADIDSDKHelper.1
                public final void onSupport(IdSupplier idSupplier) {
                }
            }.onSupport((IdSupplier) null);
            try {
                Log.d(TAG, "OADIDSDKHelper:oaidVersion" + e.a());
            } catch (Throwable unused) {
                str = "OADIDSDKHelper:oaidVersion fail";
            }
        } catch (Throwable unused2) {
            str = "OADIDSDKHelper:isSupport oaid sdk not find ";
        }
        try {
            Class.forName("com.bun.miitmdid.core.MdidSdkHelper", false, OADIDSDKHelper.class.getClassLoader());
            return true;
        } catch (Throwable unused3) {
            str = "OADIDSDKHelper:com.bun.miitmdid.core.MdidSdkHelper oaid sdk not find ";
            Log.d(TAG, str);
            return false;
        }
    }
}
