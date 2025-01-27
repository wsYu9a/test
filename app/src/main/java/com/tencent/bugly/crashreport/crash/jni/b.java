package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.e;
import com.tencent.bugly.crashreport.crash.h;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ba;
import com.tencent.bugly.proguard.ca;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
public class b implements NativeExceptionHandler {

    /* renamed from: a */
    private final Context f22530a;

    /* renamed from: b */
    private final e f22531b;

    /* renamed from: c */
    private final com.tencent.bugly.crashreport.common.info.a f22532c;

    /* renamed from: d */
    private final com.tencent.bugly.crashreport.common.strategy.c f22533d;

    public b(Context context, com.tencent.bugly.crashreport.common.info.a aVar, e eVar, com.tencent.bugly.crashreport.common.strategy.c cVar) {
        this.f22530a = context;
        this.f22531b = eVar;
        this.f22532c = aVar;
        this.f22533d = cVar;
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public void handleNativeException(int i10, int i11, long j10, long j11, String str, String str2, String str3, String str4, int i12, String str5, int i13, int i14, int i15, String str6, String str7) {
        X.c("Native Crash Happen v1", new Object[0]);
        handleNativeException2(i10, i11, j10, j11, str, str2, str3, str4, i12, str5, i13, i14, i15, str6, str7, null);
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public void handleNativeException2(int i10, int i11, long j10, long j11, String str, String str2, String str3, String str4, int i12, String str5, int i13, int i14, int i15, String str6, String str7, String[] strArr) {
        String str8;
        String str9;
        String str10;
        boolean z10;
        boolean z11;
        X.c("Native Crash Happen v2", new Object[0]);
        try {
            String a10 = c.a(str3);
            if (i12 > 0) {
                str9 = str + "(" + str5 + ")";
                str8 = "UNKNOWN";
                str10 = "KERNEL";
            } else {
                String a11 = i13 > 0 ? AppInfo.a(this.f22530a, i13) : "UNKNOWN";
                str8 = a11.equals(String.valueOf(i13)) ? a11 : a11 + "(" + i13 + ")";
                str9 = str;
                str10 = str5;
            }
            HashMap hashMap = new HashMap();
            if (strArr != null) {
                for (int i16 = 0; i16 < strArr.length; i16++) {
                    String str11 = strArr[i16];
                    if (str11 != null) {
                        X.c("Extra message[%d]: %s", Integer.valueOf(i16), str11);
                        String[] split = str11.split("=");
                        if (split.length == 2) {
                            hashMap.put(split[0], split[1]);
                        } else {
                            X.e("bad extraMsg %s", str11);
                        }
                    }
                }
            } else {
                X.a("not found extraMsg", new Object[0]);
            }
            String str12 = (String) hashMap.get("HasPendingException");
            if (str12 == null || !str12.equals("true")) {
                z10 = false;
            } else {
                X.c("Native crash happened with a Java pending exception.", new Object[0]);
                z10 = true;
            }
            String str13 = (String) hashMap.get("ExceptionProcessName");
            if (str13 == null || str13.length() == 0) {
                str13 = this.f22532c.f22296h;
            } else {
                X.a("Name of crash process: %s", str13);
            }
            String str14 = str13;
            String str15 = (String) hashMap.get("ExceptionThreadName");
            if (str15 == null || str15.length() == 0) {
                Thread currentThread = Thread.currentThread();
                str15 = currentThread.getName() + "(" + currentThread.getId() + ")";
            } else {
                X.a("Name of crash thread: %s", str15);
                Iterator<Thread> it = Thread.getAllStackTraces().keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z11 = false;
                        break;
                    }
                    Thread next = it.next();
                    if (next.getName().equals(str15)) {
                        str15 = str15 + "(" + next.getId() + ")";
                        z11 = true;
                        break;
                    }
                }
                if (!z11) {
                    str15 = str15 + "(" + i11 + ")";
                }
            }
            String str16 = str15;
            long j12 = (j10 * 1000) + (j11 / 1000);
            String str17 = (String) hashMap.get("SysLogPath");
            String str18 = (String) hashMap.get("JniLogPath");
            if (!this.f22533d.d()) {
                X.e("no remote but still store!", new Object[0]);
            }
            if (!this.f22533d.c().f22342f && this.f22533d.d()) {
                X.b("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                e.a("NATIVE_CRASH", ca.a(), str14, str16, str9 + "\n" + str2 + "\n" + a10, null);
                ca.a(str4);
                return;
            }
            String str19 = str9;
            try {
                CrashDetailBean packageCrashDatas = packageCrashDatas(str14, str16, j12, str9, str2, a10, str10, str8, str4, str17, str18, str7, null, null, true, z10);
                if (packageCrashDatas == null) {
                    X.b("pkg crash datas fail!", new Object[0]);
                    return;
                }
                e.a("NATIVE_CRASH", ca.a(), str14, str16, str19 + "\n" + str2 + "\n" + a10, packageCrashDatas);
                try {
                    boolean z12 = !this.f22531b.a(packageCrashDatas, i12);
                    NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
                    c.a(true, nativeCrashHandler != null ? nativeCrashHandler.getDumpFilePath() : null);
                    if (z12) {
                        this.f22531b.a(packageCrashDatas, 3000L, true);
                    }
                    this.f22531b.e(packageCrashDatas);
                    h.g().d();
                } catch (Throwable th2) {
                    th = th2;
                    if (X.b(th)) {
                        return;
                    }
                    th.printStackTrace();
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public CrashDetailBean packageCrashDatas(String str, String str2, long j10, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, byte[] bArr, Map<String, String> map, boolean z10, boolean z11) {
        int i10;
        String str12;
        int indexOf;
        boolean i11 = h.g().i();
        if (i11) {
            X.b("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.f22375b = 1;
        crashDetailBean.f22378e = this.f22532c.l();
        com.tencent.bugly.crashreport.common.info.a aVar = this.f22532c;
        crashDetailBean.f22379f = aVar.E;
        crashDetailBean.f22380g = aVar.i();
        crashDetailBean.f22386m = this.f22532c.y();
        crashDetailBean.f22387n = str3;
        crashDetailBean.f22388o = i11 ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        crashDetailBean.f22389p = str4;
        String str13 = str5 != null ? str5 : "";
        crashDetailBean.f22390q = str13;
        crashDetailBean.f22391r = j10;
        crashDetailBean.f22394u = ca.c(str13.getBytes());
        crashDetailBean.A = str;
        crashDetailBean.B = str2;
        crashDetailBean.I = this.f22532c.r();
        crashDetailBean.f22381h = this.f22532c.p();
        crashDetailBean.f22382i = this.f22532c.o();
        crashDetailBean.f22395v = str8;
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        String dumpFilePath = nativeCrashHandler != null ? nativeCrashHandler.getDumpFilePath() : null;
        String a10 = c.a(dumpFilePath, str8);
        if (!ca.b(a10)) {
            crashDetailBean.W = a10;
        }
        crashDetailBean.X = c.c(dumpFilePath);
        crashDetailBean.f22396w = c.a(str9, h.f22466e, h.f22469h, h.f22474m);
        crashDetailBean.f22397x = c.a(str10, h.f22466e, null, true);
        crashDetailBean.K = str7;
        crashDetailBean.L = str6;
        crashDetailBean.M = str11;
        crashDetailBean.F = this.f22532c.v();
        crashDetailBean.G = this.f22532c.w();
        crashDetailBean.H = this.f22532c.x();
        if (z10) {
            crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.h();
            crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.j();
            crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.g();
            if (crashDetailBean.f22396w == null) {
                crashDetailBean.f22396w = ca.a(this.f22530a, h.f22466e, h.f22469h);
            }
            crashDetailBean.f22398y = ba.b();
            com.tencent.bugly.crashreport.common.info.a aVar2 = this.f22532c;
            crashDetailBean.N = aVar2.f22288d;
            crashDetailBean.O = aVar2.C();
            crashDetailBean.f22399z = ca.a(h.f22467f, false);
            int indexOf2 = crashDetailBean.f22390q.indexOf("java:\n");
            if (indexOf2 > 0 && (i10 = indexOf2 + 6) < crashDetailBean.f22390q.length()) {
                String str14 = crashDetailBean.f22390q;
                String substring = str14.substring(i10, str14.length() - 1);
                if (substring.length() > 0 && crashDetailBean.f22399z.containsKey(crashDetailBean.B) && (indexOf = (str12 = crashDetailBean.f22399z.get(crashDetailBean.B)).indexOf(substring)) > 0) {
                    String substring2 = str12.substring(indexOf);
                    crashDetailBean.f22399z.put(crashDetailBean.B, substring2);
                    crashDetailBean.f22390q = crashDetailBean.f22390q.substring(0, i10);
                    crashDetailBean.f22390q += substring2;
                }
            }
            if (str == null) {
                crashDetailBean.A = this.f22532c.f22296h;
            }
            this.f22531b.d(crashDetailBean);
            crashDetailBean.R = this.f22532c.A();
            crashDetailBean.S = this.f22532c.t();
            crashDetailBean.T = this.f22532c.h();
            crashDetailBean.U = this.f22532c.g();
        } else {
            crashDetailBean.C = -1L;
            crashDetailBean.D = -1L;
            crashDetailBean.E = -1L;
            if (crashDetailBean.f22396w == null) {
                crashDetailBean.f22396w = "this crash is occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
            }
            crashDetailBean.N = -1L;
            crashDetailBean.R = -1;
            crashDetailBean.S = -1;
            crashDetailBean.T = map;
            crashDetailBean.U = this.f22532c.g();
            crashDetailBean.f22399z = null;
            if (str == null) {
                crashDetailBean.A = "unknown(record)";
            }
            if (bArr != null) {
                crashDetailBean.f22398y = bArr;
            }
        }
        return crashDetailBean;
    }
}
