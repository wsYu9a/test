package com.alipay.apmobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.a.a;
import com.alipay.apmobilesecuritysdk.otherid.UtdidWrapper;
import java.util.HashMap;
import java.util.Map;
import z2.b;

/* loaded from: classes.dex */
public class TMNTokenClient {

    /* renamed from: a */
    public static TMNTokenClient f6472a;

    /* renamed from: b */
    public Context f6473b;

    /* renamed from: com.alipay.apmobilesecuritysdk.face.TMNTokenClient$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Map f6474a;

        /* renamed from: b */
        public final /* synthetic */ InitResultListener f6475b;

        /* renamed from: c */
        public final /* synthetic */ String f6476c;

        public AnonymousClass1(Map map, InitResultListener initResultListener, String str) {
            hashMap = map;
            initResultListener = initResultListener;
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            int a10 = new a(TMNTokenClient.this.f6473b).a(hashMap);
            InitResultListener initResultListener = initResultListener;
            if (initResultListener == null) {
                return;
            }
            if (a10 != 0) {
                initResultListener.onResult("", a10);
            } else {
                initResultListener.onResult(a.a(TMNTokenClient.this.f6473b, str), 0);
            }
        }
    }

    public interface InitResultListener {
        void onResult(String str, int i10);
    }

    public TMNTokenClient(Context context) {
        this.f6473b = null;
        if (context == null) {
            throw new IllegalArgumentException("TMNTokenClient initialization error: context is null.");
        }
        this.f6473b = context;
    }

    public static TMNTokenClient getInstance(Context context) {
        if (f6472a == null) {
            synchronized (TMNTokenClient.class) {
                try {
                    if (f6472a == null) {
                        f6472a = new TMNTokenClient(context);
                    }
                } finally {
                }
            }
        }
        return f6472a;
    }

    public void intiToken(String str, String str2, String str3, InitResultListener initResultListener) {
        if (t3.a.c(str) && initResultListener != null) {
            initResultListener.onResult("", 2);
        }
        if (t3.a.c(str2) && initResultListener != null) {
            initResultListener.onResult("", 3);
        }
        HashMap hashMap = new HashMap();
        hashMap.put(b.f33622g, UtdidWrapper.getUtdid(this.f6473b));
        hashMap.put("tid", "");
        hashMap.put("userId", "");
        hashMap.put("appName", str);
        hashMap.put("appKeyClient", str2);
        hashMap.put("appchannel", "openapi");
        hashMap.put("sessionId", str3);
        hashMap.put("rpcVersion", "8");
        com.alipay.apmobilesecuritysdk.f.b.a().a(new Runnable() { // from class: com.alipay.apmobilesecuritysdk.face.TMNTokenClient.1

            /* renamed from: a */
            public final /* synthetic */ Map f6474a;

            /* renamed from: b */
            public final /* synthetic */ InitResultListener f6475b;

            /* renamed from: c */
            public final /* synthetic */ String f6476c;

            public AnonymousClass1(Map hashMap2, InitResultListener initResultListener2, String str4) {
                hashMap = hashMap2;
                initResultListener = initResultListener2;
                str = str4;
            }

            @Override // java.lang.Runnable
            public void run() {
                int a10 = new a(TMNTokenClient.this.f6473b).a(hashMap);
                InitResultListener initResultListener2 = initResultListener;
                if (initResultListener2 == null) {
                    return;
                }
                if (a10 != 0) {
                    initResultListener2.onResult("", a10);
                } else {
                    initResultListener.onResult(a.a(TMNTokenClient.this.f6473b, str), 0);
                }
            }
        });
    }
}
