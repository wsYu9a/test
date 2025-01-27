package com.kuaishou.weapon.p0.jni;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.bg;
import com.kuaishou.weapon.p0.bo;
import com.kuaishou.weapon.p0.bp;
import com.kuaishou.weapon.p0.cj;
import com.kuaishou.weapon.p0.de;
import com.kuaishou.weapon.p0.h;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.ranger.e;
import java.lang.reflect.Member;
import java.util.HashMap;

/* loaded from: classes.dex */
public class Engine {
    private static volatile Engine instance;
    public static volatile int loadSoCount;
    public static volatile boolean loadSuccess;
    public static volatile String soPath;
    public static volatile String soVersion;

    public static native String abc();

    public static native String bcd();

    public static Engine getInstance(Context context) {
        if (!TextUtils.isEmpty(soVersion) && !loadSuccess && instance == null) {
            synchronized (Engine.class) {
                if (instance == null) {
                    instance = new Engine();
                }
                h a2 = h.a(context, "re_po_rt");
                try {
                } catch (Throwable th) {
                    loadSuccess = false;
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put(e.TAG, th.getMessage());
                        hashMap.put("v", soVersion);
                        hashMap.put(t.f9404d, cj.k);
                        bg.a(context, cj.f9188a, hashMap);
                    } catch (Exception unused) {
                    }
                }
                if (!bo.a(context, bp.f9126d + soVersion.replace(".", "") + ".so")) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put(t.f9404d, cj.l);
                    bg.a(context, cj.f9188a, hashMap2);
                    loadSuccess = false;
                    return instance;
                }
                String b2 = a2.b(de.f9284f, "");
                if (TextUtils.isEmpty(b2)) {
                    b2 = soVersion;
                    a2.c(de.f9284f, b2, false);
                }
                loadSoCount = a2.c(de.aY);
                if (!TextUtils.equals(b2, soVersion)) {
                    String str = soVersion;
                    loadSoCount = 0;
                    a2.c(de.f9284f, str, false);
                }
                if (loadSoCount + 1 < 10) {
                    loadSoCount++;
                    a2.d(de.aY, loadSoCount);
                    System.loadLibrary(bp.f9126d + soVersion.replace(".", ""));
                    bcd();
                    HashMap hashMap3 = new HashMap();
                    StringBuilder sb = new StringBuilder();
                    sb.append(loadSoCount);
                    hashMap3.put("c", sb.toString());
                    hashMap3.put("v", soVersion);
                    hashMap3.put(t.f9404d, "s");
                    bg.a(context, "1003001", hashMap3);
                    loadSoCount = 0;
                    loadSuccess = true;
                }
                a2.d(de.aY, loadSoCount);
            }
        }
        return instance;
    }

    public static native int mmo(Member member, int i2, int i3);

    public static native int mqc(Member member, int i2);

    public static native int off();

    public static native String tao(int i2, long j2, Object obj);

    public native byte[] ac(byte[] bArr, byte[] bArr2);

    public native byte[] ar(byte[] bArr, byte[] bArr2);

    public native String cde();

    public native byte[] dc(byte[] bArr, byte[] bArr2);

    public native String def();

    public native byte[] dr(byte[] bArr, byte[] bArr2);

    public native String efg();

    public native String eopq(int i2, int i3, int i4, String str);

    public native String fgh();

    public native String ghi();

    public native String hij();

    public native String klm(int i2, String str);

    public native String nop();

    public native String pqr(int i2, int i3, int i4, String str);

    public native String qrs();

    public native String stu(int i2, int i3, int i4, int i5, String str);
}
