package com.tencent.bugly.beta.global;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.util.DisplayMetrics;
import com.tencent.bugly.beta.UpgradeInfo;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.interfaces.BetaPatchListener;
import com.tencent.bugly.beta.ui.UILifecycleListener;
import com.tencent.bugly.beta.upgrade.BetaUploadStrategy;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a */
    public static int f24620a;

    /* renamed from: b */
    public static e f24621b = new e();
    public PackageInfo C;
    public SharedPreferences D;
    public DisplayMetrics E;
    public BetaUploadStrategy H;
    public File I;
    public File J;
    public File K;
    public BetaPatchListener Y;
    public boolean fa;

    /* renamed from: i */
    public int f24628i;

    /* renamed from: j */
    public int f24629j;
    public int k;
    public int l;
    public int m;
    public UILifecycleListener<UpgradeInfo> n;
    public File o;
    public int r;
    public com.tencent.bugly.beta.download.c s;
    public DownloadListener t;
    public File u;
    public Context v;
    public File w;
    public String x;
    public String y;

    /* renamed from: c */
    public long f24622c = 3000;

    /* renamed from: d */
    public long f24623d = 0;

    /* renamed from: e */
    public boolean f24624e = true;

    /* renamed from: f */
    public boolean f24625f = false;

    /* renamed from: g */
    public boolean f24626g = false;

    /* renamed from: h */
    public boolean f24627h = true;
    public final List<Class<? extends Activity>> p = new ArrayList();
    public final List<Class<? extends Activity>> q = new ArrayList();
    public int z = Integer.MIN_VALUE;
    public String A = "";
    public String B = "";
    public boolean F = true;
    public boolean G = false;
    public String L = "";
    public String M = "";
    public String N = "";
    public String O = "";
    public boolean P = false;
    public int Q = 0;
    public String R = "";
    public boolean S = false;
    public boolean T = true;
    public boolean U = false;
    public boolean V = false;
    public boolean W = true;
    public boolean X = true;
    public boolean Z = false;
    public boolean aa = true;
    public boolean ba = false;
    public final List<String> ca = new ArrayList();
    public boolean da = false;
    public boolean ea = false;

    /* JADX WARN: Code restructure failed: missing block: B:45:0x013e, code lost:
    
        if (r8.w.mkdirs() != false) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x014e, code lost:
    
        if (r8.u.mkdirs() != false) goto L172;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01d5 A[Catch: all -> 0x01ff, TryCatch #2 {, blocks: (B:3:0x0001, B:5:0x000f, B:7:0x0023, B:8:0x0027, B:10:0x002f, B:11:0x0035, B:13:0x0049, B:15:0x004d, B:16:0x0053, B:18:0x0057, B:20:0x0061, B:22:0x0072, B:24:0x0083, B:26:0x0089, B:27:0x0092, B:29:0x00ad, B:32:0x00b4, B:33:0x0110, B:40:0x0126, B:42:0x0130, B:44:0x0138, B:46:0x0140, B:48:0x0148, B:50:0x0197, B:52:0x01d5, B:53:0x01da, B:55:0x01e0, B:56:0x01e8, B:58:0x01f6, B:64:0x018e, B:66:0x0194, B:67:0x0150, B:69:0x0154, B:71:0x015e, B:73:0x0168, B:75:0x016e, B:77:0x0172, B:79:0x0178, B:81:0x017c, B:83:0x0186, B:86:0x00ed, B:88:0x0069, B:90:0x006f), top: B:2:0x0001, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01e0 A[Catch: all -> 0x01ff, TryCatch #2 {, blocks: (B:3:0x0001, B:5:0x000f, B:7:0x0023, B:8:0x0027, B:10:0x002f, B:11:0x0035, B:13:0x0049, B:15:0x004d, B:16:0x0053, B:18:0x0057, B:20:0x0061, B:22:0x0072, B:24:0x0083, B:26:0x0089, B:27:0x0092, B:29:0x00ad, B:32:0x00b4, B:33:0x0110, B:40:0x0126, B:42:0x0130, B:44:0x0138, B:46:0x0140, B:48:0x0148, B:50:0x0197, B:52:0x01d5, B:53:0x01da, B:55:0x01e0, B:56:0x01e8, B:58:0x01f6, B:64:0x018e, B:66:0x0194, B:67:0x0150, B:69:0x0154, B:71:0x015e, B:73:0x0168, B:75:0x016e, B:77:0x0172, B:79:0x0178, B:81:0x017c, B:83:0x0186, B:86:0x00ed, B:88:0x0069, B:90:0x006f), top: B:2:0x0001, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01f6 A[Catch: all -> 0x01ff, TRY_LEAVE, TryCatch #2 {, blocks: (B:3:0x0001, B:5:0x000f, B:7:0x0023, B:8:0x0027, B:10:0x002f, B:11:0x0035, B:13:0x0049, B:15:0x004d, B:16:0x0053, B:18:0x0057, B:20:0x0061, B:22:0x0072, B:24:0x0083, B:26:0x0089, B:27:0x0092, B:29:0x00ad, B:32:0x00b4, B:33:0x0110, B:40:0x0126, B:42:0x0130, B:44:0x0138, B:46:0x0140, B:48:0x0148, B:50:0x0197, B:52:0x01d5, B:53:0x01da, B:55:0x01e0, B:56:0x01e8, B:58:0x01f6, B:64:0x018e, B:66:0x0194, B:67:0x0150, B:69:0x0154, B:71:0x015e, B:73:0x0168, B:75:0x016e, B:77:0x0172, B:79:0x0178, B:81:0x017c, B:83:0x0186, B:86:0x00ed, B:88:0x0069, B:90:0x006f), top: B:2:0x0001, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0120  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void a(android.content.Context r9) {
        /*
            Method dump skipped, instructions count: 514
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.global.e.a(android.content.Context):void");
    }
}
