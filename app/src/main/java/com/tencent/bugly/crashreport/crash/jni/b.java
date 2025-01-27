package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.e;
import com.tencent.bugly.crashreport.crash.h;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ba;
import com.tencent.bugly.proguard.ca;
import java.util.Map;

/* loaded from: classes4.dex */
public class b implements NativeExceptionHandler {

    /* renamed from: a */
    private final Context f24900a;

    /* renamed from: b */
    private final e f24901b;

    /* renamed from: c */
    private final com.tencent.bugly.crashreport.common.info.a f24902c;

    /* renamed from: d */
    private final com.tencent.bugly.crashreport.common.strategy.c f24903d;

    public b(Context context, com.tencent.bugly.crashreport.common.info.a aVar, e eVar, com.tencent.bugly.crashreport.common.strategy.c cVar) {
        this.f24900a = context;
        this.f24901b = eVar;
        this.f24902c = aVar;
        this.f24903d = cVar;
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public void handleNativeException(int i2, int i3, long j2, long j3, String str, String str2, String str3, String str4, int i4, String str5, int i5, int i6, int i7, String str6, String str7) {
        X.c("Native Crash Happen v1", new Object[0]);
        handleNativeException2(i2, i3, j2, j3, str, str2, str3, str4, i4, str5, i5, i6, i7, str6, str7, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0246  */
    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void handleNativeException2(int r28, int r29, long r30, long r32, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, int r38, java.lang.String r39, int r40, int r41, int r42, java.lang.String r43, java.lang.String r44, java.lang.String[] r45) {
        /*
            Method dump skipped, instructions count: 699
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.b.handleNativeException2(int, int, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, int, int, java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public CrashDetailBean packageCrashDatas(String str, String str2, long j2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, byte[] bArr, Map<String, String> map, boolean z, boolean z2) {
        int i2;
        String str12;
        int indexOf;
        boolean i3 = h.g().i();
        if (i3) {
            X.b("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.f24788b = 1;
        crashDetailBean.f24791e = this.f24902c.l();
        com.tencent.bugly.crashreport.common.info.a aVar = this.f24902c;
        crashDetailBean.f24792f = aVar.E;
        crashDetailBean.f24793g = aVar.i();
        crashDetailBean.m = this.f24902c.y();
        crashDetailBean.n = str3;
        crashDetailBean.o = i3 ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        crashDetailBean.p = str4;
        String str13 = str5 != null ? str5 : "";
        crashDetailBean.q = str13;
        crashDetailBean.r = j2;
        crashDetailBean.u = ca.c(str13.getBytes());
        crashDetailBean.A = str;
        crashDetailBean.B = str2;
        crashDetailBean.I = this.f24902c.r();
        crashDetailBean.f24794h = this.f24902c.p();
        crashDetailBean.f24795i = this.f24902c.o();
        crashDetailBean.v = str8;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        String dumpFilePath = nativeCrashHandler != null ? nativeCrashHandler.getDumpFilePath() : null;
        String a2 = c.a(dumpFilePath, str8);
        if (!ca.b(a2)) {
            crashDetailBean.W = a2;
        }
        crashDetailBean.X = c.c(dumpFilePath);
        crashDetailBean.w = c.a(str9, h.f24859e, h.f24862h, h.m);
        crashDetailBean.x = c.a(str10, h.f24859e, null, true);
        crashDetailBean.K = str7;
        crashDetailBean.L = str6;
        crashDetailBean.M = str11;
        crashDetailBean.F = this.f24902c.v();
        crashDetailBean.G = this.f24902c.w();
        crashDetailBean.H = this.f24902c.x();
        if (z) {
            crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.h();
            crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.j();
            crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.g();
            if (crashDetailBean.w == null) {
                crashDetailBean.w = ca.a(this.f24900a, h.f24859e, h.f24862h);
            }
            crashDetailBean.y = ba.b();
            com.tencent.bugly.crashreport.common.info.a aVar2 = this.f24902c;
            crashDetailBean.N = aVar2.f24751d;
            crashDetailBean.O = aVar2.C();
            crashDetailBean.z = ca.a(h.f24860f, false);
            int indexOf2 = crashDetailBean.q.indexOf("java:\n");
            if (indexOf2 > 0 && (i2 = indexOf2 + 6) < crashDetailBean.q.length()) {
                String str14 = crashDetailBean.q;
                String substring = str14.substring(i2, str14.length() - 1);
                if (substring.length() > 0 && crashDetailBean.z.containsKey(crashDetailBean.B) && (indexOf = (str12 = crashDetailBean.z.get(crashDetailBean.B)).indexOf(substring)) > 0) {
                    String substring2 = str12.substring(indexOf);
                    crashDetailBean.z.put(crashDetailBean.B, substring2);
                    crashDetailBean.q = crashDetailBean.q.substring(0, i2);
                    crashDetailBean.q += substring2;
                }
            }
            if (str == null) {
                crashDetailBean.A = this.f24902c.f24755h;
            }
            this.f24901b.d(crashDetailBean);
            crashDetailBean.R = this.f24902c.A();
            crashDetailBean.S = this.f24902c.t();
            crashDetailBean.T = this.f24902c.h();
            crashDetailBean.U = this.f24902c.g();
        } else {
            crashDetailBean.C = -1L;
            crashDetailBean.D = -1L;
            crashDetailBean.E = -1L;
            if (crashDetailBean.w == null) {
                crashDetailBean.w = "this crash is occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
            }
            crashDetailBean.N = -1L;
            crashDetailBean.R = -1;
            crashDetailBean.S = -1;
            crashDetailBean.T = map;
            crashDetailBean.U = this.f24902c.g();
            crashDetailBean.z = null;
            if (str == null) {
                crashDetailBean.A = "unknown(record)";
            }
            if (bArr != null) {
                crashDetailBean.y = bArr;
            }
        }
        return crashDetailBean;
    }
}
