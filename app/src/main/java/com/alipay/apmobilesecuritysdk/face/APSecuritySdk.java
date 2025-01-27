package com.alipay.apmobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.a.a;
import com.alipay.apmobilesecuritysdk.e.d;
import com.alipay.apmobilesecuritysdk.e.g;
import com.alipay.apmobilesecuritysdk.e.h;
import com.alipay.apmobilesecuritysdk.e.i;
import com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper;
import com.alipay.apmobilesecuritysdk.otherid.UtdidWrapper;
import e2.f;
import java.util.HashMap;
import java.util.Map;
import z2.b;

/* loaded from: classes.dex */
public class APSecuritySdk implements f {

    /* renamed from: a */
    public static APSecuritySdk f6464a;
    public static APSecBgCheckerInterface bgChecker;

    /* renamed from: c */
    public static IDeviceInfo f6465c;

    /* renamed from: d */
    public static Object f6466d = new Object();

    /* renamed from: b */
    public Context f6467b;

    /* renamed from: com.alipay.apmobilesecuritysdk.face.APSecuritySdk$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Map f6468a;

        /* renamed from: b */
        public final /* synthetic */ InitResultListener f6469b;

        public AnonymousClass1(Map map, InitResultListener initResultListener) {
            hashMap = map;
            initResultListener = initResultListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            new a(APSecuritySdk.this.f6467b).a(hashMap);
            InitResultListener initResultListener = initResultListener;
            if (initResultListener != null) {
                initResultListener.onResult(APSecuritySdk.this.getTokenResult());
            }
        }
    }

    public interface InitResultListener {
        void onResult(TokenResult tokenResult);
    }

    public class TokenResult {
        public String apdid;
        public String apdidToken;
        public String clientKey;
        public String umidToken;

        public TokenResult() {
        }
    }

    public APSecuritySdk(Context context) {
        this.f6467b = context;
    }

    public static IDeviceInfo getDeviceInfo() {
        return f6465c;
    }

    public static APSecuritySdk getInstance(Context context) {
        if (f6464a == null) {
            synchronized (f6466d) {
                try {
                    if (f6464a == null) {
                        f6464a = new APSecuritySdk(context);
                    }
                } finally {
                }
            }
        }
        return f6464a;
    }

    public static String getUtdid(Context context) {
        return UtdidWrapper.getUtdid(context);
    }

    public static void registerBgChecker(APSecBgCheckerInterface aPSecBgCheckerInterface) {
        bgChecker = aPSecBgCheckerInterface;
    }

    public static void registerDeviceInfo(IDeviceInfo iDeviceInfo) {
        f6465c = iDeviceInfo;
    }

    @Override // e2.f
    public String getAndroidId() {
        IDeviceInfo iDeviceInfo = f6465c;
        if (iDeviceInfo != null) {
            return iDeviceInfo.getAndroidId();
        }
        return null;
    }

    public String getApdidToken() {
        String a10 = a.a(this.f6467b, "");
        if (t3.a.c(a10)) {
            initToken(0, new HashMap(), null);
        }
        return a10;
    }

    public String getSdkName() {
        return "APPSecuritySDK-ALIPAYSDK";
    }

    public String getSdkVersion() {
        return "3.4.0.202311031119";
    }

    @Override // e2.f
    public String getSubscriberId() {
        IDeviceInfo iDeviceInfo = f6465c;
        if (iDeviceInfo != null) {
            return iDeviceInfo.getSubscriberId();
        }
        return null;
    }

    public synchronized TokenResult getTokenResult() {
        TokenResult tokenResult;
        tokenResult = new TokenResult();
        try {
            tokenResult.apdidToken = a.a(this.f6467b, "");
            tokenResult.clientKey = h.f(this.f6467b);
            tokenResult.apdid = a.a(this.f6467b);
            tokenResult.umidToken = UmidSdkWrapper.getSecurityToken(this.f6467b);
            if (t3.a.c(tokenResult.apdid) || t3.a.c(tokenResult.apdidToken) || t3.a.c(tokenResult.clientKey)) {
                initToken(0, new HashMap(), null);
            }
        } catch (Throwable unused) {
        }
        return tokenResult;
    }

    public void initToken(int i10, Map<String, String> map, InitResultListener initResultListener) {
        com.alipay.apmobilesecuritysdk.b.a.a().a(i10);
        String b10 = h.b(this.f6467b);
        String c10 = com.alipay.apmobilesecuritysdk.b.a.a().c();
        if (t3.a.f(b10) && !t3.a.d(b10, c10)) {
            com.alipay.apmobilesecuritysdk.e.a.a(this.f6467b);
            d.a(this.f6467b);
            g.a(this.f6467b);
            i.h();
        }
        if (!t3.a.d(b10, c10)) {
            h.c(this.f6467b, c10);
        }
        String b11 = t3.a.b(map, b.f33622g, "");
        String b12 = t3.a.b(map, "tid", "");
        String b13 = t3.a.b(map, "userId", "");
        if (t3.a.c(b11)) {
            b11 = UtdidWrapper.getUtdid(this.f6467b);
        }
        HashMap hashMap = new HashMap();
        hashMap.put(b.f33622g, b11);
        hashMap.put("tid", b12);
        hashMap.put("userId", b13);
        hashMap.put("appName", "");
        hashMap.put("appKeyClient", "");
        hashMap.put("appchannel", "");
        hashMap.put("rpcVersion", "8");
        com.alipay.apmobilesecuritysdk.f.b.a().a(new Runnable() { // from class: com.alipay.apmobilesecuritysdk.face.APSecuritySdk.1

            /* renamed from: a */
            public final /* synthetic */ Map f6468a;

            /* renamed from: b */
            public final /* synthetic */ InitResultListener f6469b;

            public AnonymousClass1(Map hashMap2, InitResultListener initResultListener2) {
                hashMap = hashMap2;
                initResultListener = initResultListener2;
            }

            @Override // java.lang.Runnable
            public void run() {
                new a(APSecuritySdk.this.f6467b).a(hashMap);
                InitResultListener initResultListener2 = initResultListener;
                if (initResultListener2 != null) {
                    initResultListener2.onResult(APSecuritySdk.this.getTokenResult());
                }
            }
        });
    }

    @Override // e2.f
    public boolean isBackgroundRunning() {
        APSecBgCheckerInterface aPSecBgCheckerInterface = bgChecker;
        if (aPSecBgCheckerInterface != null) {
            return aPSecBgCheckerInterface.isBackgroundRunning();
        }
        return false;
    }
}
