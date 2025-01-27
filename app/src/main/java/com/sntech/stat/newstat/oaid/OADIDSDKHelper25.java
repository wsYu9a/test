package com.sntech.stat.newstat.oaid;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import com.sntech.stat.newstat.oaid.Cdo;
import nh.b;
import pi.a;

@Keep
/* loaded from: classes4.dex */
public class OADIDSDKHelper25 {
    private static final String TAG = "SNADS.Log";
    private static boolean mIsRequestIng = false;
    private static boolean sGetOaidFail = false;

    @Keep
    public static class IIdentifierListener25 implements IIdentifierListener {
        private final com.sntech.stat.newstat.oaid.Cdo mIdListener;
        private final long mStartTime;

        /* renamed from: com.sntech.stat.newstat.oaid.OADIDSDKHelper25$IIdentifierListener25$do */
        public class Cdo implements Cdo.InterfaceC0629do {

            /* renamed from: do */
            public final /* synthetic */ IdSupplier f20do;

            public Cdo(IdSupplier idSupplier) {
                this.f20do = idSupplier;
            }

            @Override // com.sntech.stat.newstat.oaid.Cdo.InterfaceC0629do
            public final String getAAID() {
                return this.f20do.getAAID();
            }

            @Override // com.sntech.stat.newstat.oaid.Cdo.InterfaceC0629do
            public final String getOAID() {
                return this.f20do.getOAID();
            }

            @Override // com.sntech.stat.newstat.oaid.Cdo.InterfaceC0629do
            public final String getVAID() {
                return this.f20do.getVAID();
            }

            @Override // com.sntech.stat.newstat.oaid.Cdo.InterfaceC0629do
            public final boolean isSupported() {
                return this.f20do.isSupported();
            }
        }

        public IIdentifierListener25(long j10, com.sntech.stat.newstat.oaid.Cdo cdo) {
            this.mStartTime = j10;
            this.mIdListener = cdo;
        }

        @Keep
        public void OnSupport(boolean z10, IdSupplier idSupplier) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
            if (idSupplier != null) {
                String oaid = idSupplier.getOAID();
                if (TextUtils.isEmpty(oaid)) {
                    boolean unused = OADIDSDKHelper25.sGetOaidFail = true;
                } else {
                    Log.d(OADIDSDKHelper25.TAG, "OADIDSDKHelper25:oaid time=" + currentTimeMillis + "--OAID:" + oaid);
                }
                ((a.C0766a) this.mIdListener).a(new Cdo(idSupplier));
            } else {
                ((a.C0766a) this.mIdListener).a(null);
            }
            boolean unused2 = OADIDSDKHelper25.mIsRequestIng = false;
        }

        @Keep
        public void onSupport(IdSupplier idSupplier) {
        }
    }

    public static int getOAId(Context context, Cdo cdo) {
        int i10;
        long currentTimeMillis;
        if (context == null || sGetOaidFail) {
            return 0;
        }
        if (!isSupport()) {
            sGetOaidFail = true;
            return 0;
        }
        if (mIsRequestIng) {
            return 0;
        }
        mIsRequestIng = true;
        try {
            currentTimeMillis = System.currentTimeMillis();
            i10 = MdidSdkHelper.InitSdk(context.getApplicationContext(), true, new IIdentifierListener25(currentTimeMillis, cdo));
        } catch (Throwable th2) {
            th = th2;
            i10 = 0;
        }
        try {
            Log.d(TAG, "OADIDSDKHelper25:sdk init time=" + (System.currentTimeMillis() - currentTimeMillis) + "--result=" + i10);
        } catch (Throwable th3) {
            th = th3;
            StringBuilder a10 = b.a("OADIDSDKHelper25:oaid sdk not find ");
            a10.append(th.getMessage());
            Log.d(TAG, a10.toString());
            mIsRequestIng = false;
            sGetOaidFail = true;
            return i10;
        }
        return i10;
    }

    public static boolean isSupport() {
        String str;
        try {
            Class.forName("com.bun.miitmdid.core.MdidSdkHelper");
        } catch (Throwable unused) {
            str = "OADIDSDKHelper25:com.bun.miitmdid.core.MdidSdkHelper oaid sdk not find ";
        }
        try {
            return Class.forName("com.bun.miitmdid.interfaces.IIdentifierListener").getMethod("onSupport", Boolean.TYPE, IdSupplier.class) != null;
        } catch (Throwable th2) {
            StringBuilder a10 = b.a("OADIDSDKHelper25:isSupport oaid sdk not find ");
            a10.append(th2.getMessage());
            str = a10.toString();
            Log.d(TAG, str);
            return false;
        }
    }
}
