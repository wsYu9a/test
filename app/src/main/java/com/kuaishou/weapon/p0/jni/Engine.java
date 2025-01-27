package com.kuaishou.weapon.p0.jni;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.bh;
import com.kuaishou.weapon.p0.bp;
import com.kuaishou.weapon.p0.bq;
import com.kuaishou.weapon.p0.ck;
import com.kuaishou.weapon.p0.df;
import com.kuaishou.weapon.p0.h;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import java.lang.reflect.Member;
import java.util.HashMap;
import p1.b;

/* loaded from: classes2.dex */
public class Engine {
    private static volatile Engine instance = null;
    public static volatile int loadSoCount = 0;
    public static volatile boolean loadSuccess = false;
    public static volatile String soPath;
    public static volatile String soVersion;

    public static native String abc();

    public static native String bcd();

    public static synchronized Engine getInstance(Context context) {
        synchronized (Engine.class) {
            try {
                if (!TextUtils.isEmpty(soVersion) && !loadSuccess && instance == null) {
                    if (instance == null) {
                        instance = new Engine();
                    }
                    h a10 = h.a(context, "re_po_rt");
                    try {
                    } catch (Throwable th2) {
                        loadSuccess = false;
                        try {
                            HashMap hashMap = new HashMap();
                            hashMap.put(e.TAG, th2.getMessage());
                            hashMap.put("v", soVersion);
                            hashMap.put(t.f11204d, ck.f10917m);
                            bh.a(context, ck.f10905a, hashMap);
                        } catch (Exception unused) {
                        }
                    }
                    if (!bp.a(context, bq.f10840d + soVersion.replace(b.f29697h, "") + ".so")) {
                        loadSuccess = false;
                        return instance;
                    }
                    String b10 = a10.b(df.f11052f, "");
                    if (TextUtils.isEmpty(b10)) {
                        b10 = soVersion;
                        a10.c(df.f11052f, b10, false);
                    }
                    loadSoCount = a10.c(df.f11044bg);
                    if (!TextUtils.equals(b10, soVersion)) {
                        String str = soVersion;
                        loadSoCount = 0;
                        a10.c(df.f11052f, str, false);
                    }
                    if (loadSoCount + 1 < 10) {
                        loadSoCount++;
                        a10.d(df.f11044bg, loadSoCount);
                        System.loadLibrary(bq.f10840d + soVersion.replace(b.f29697h, ""));
                        bcd();
                        loadSoCount = 0;
                        loadSuccess = true;
                    }
                    a10.d(df.f11044bg, loadSoCount);
                }
                return instance;
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public static native int mmo(Member member, int i10, int i11);

    public static native int mqc(Member member, int i10);

    public static native int off();

    public static native String tao(int i10, long j10, Object obj);

    public native byte[] ac(byte[] bArr, byte[] bArr2);

    public native byte[] ar(byte[] bArr, byte[] bArr2);

    public native String cde();

    public native byte[] dc(byte[] bArr, byte[] bArr2);

    public native String def();

    public native byte[] dr(byte[] bArr, byte[] bArr2);

    public native String efg();

    public native String eopq(int i10, int i11, int i12, String str);

    public native String fgh();

    public native String ghi();

    public native String hij();

    public native String klm(int i10, String str);

    public native String nop();

    public native String pqr(int i10, int i11, int i12, String str);

    public native String qrs();

    public native String stu(int i10, int i11, int i12, int i13, String str);
}
