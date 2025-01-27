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
    public static int f22099a;

    /* renamed from: b */
    public static e f22100b = new e();
    public PackageInfo C;
    public SharedPreferences D;
    public DisplayMetrics E;
    public BetaUploadStrategy H;
    public File I;
    public File J;
    public File K;
    public BetaPatchListener Y;

    /* renamed from: fa */
    public boolean f22110fa;

    /* renamed from: i */
    public int f22113i;

    /* renamed from: j */
    public int f22114j;

    /* renamed from: k */
    public int f22115k;

    /* renamed from: l */
    public int f22116l;

    /* renamed from: m */
    public int f22117m;

    /* renamed from: n */
    public UILifecycleListener<UpgradeInfo> f22118n;

    /* renamed from: o */
    public File f22119o;

    /* renamed from: r */
    public int f22122r;

    /* renamed from: s */
    public com.tencent.bugly.beta.download.c f22123s;

    /* renamed from: t */
    public DownloadListener f22124t;

    /* renamed from: u */
    public File f22125u;

    /* renamed from: v */
    public Context f22126v;

    /* renamed from: w */
    public File f22127w;

    /* renamed from: x */
    public String f22128x;

    /* renamed from: y */
    public String f22129y;

    /* renamed from: c */
    public long f22103c = 3000;

    /* renamed from: d */
    public long f22105d = 0;

    /* renamed from: e */
    public boolean f22107e = true;

    /* renamed from: f */
    public boolean f22109f = false;

    /* renamed from: g */
    public boolean f22111g = false;

    /* renamed from: h */
    public boolean f22112h = true;

    /* renamed from: p */
    public final List<Class<? extends Activity>> f22120p = new ArrayList();

    /* renamed from: q */
    public final List<Class<? extends Activity>> f22121q = new ArrayList();

    /* renamed from: z */
    public int f22130z = Integer.MIN_VALUE;
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

    /* renamed from: aa */
    public boolean f22101aa = true;

    /* renamed from: ba */
    public boolean f22102ba = false;

    /* renamed from: ca */
    public final List<String> f22104ca = new ArrayList();

    /* renamed from: da */
    public boolean f22106da = false;

    /* renamed from: ea */
    public boolean f22108ea = false;

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0151, code lost:
    
        if (r11.f22125u.mkdirs() == false) goto L251;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01d7 A[Catch: all -> 0x002b, TryCatch #1 {all -> 0x002b, blocks: (B:4:0x0004, B:6:0x0012, B:8:0x0026, B:9:0x0030, B:11:0x0038, B:12:0x003e, B:14:0x0052, B:16:0x0056, B:17:0x005c, B:19:0x0060, B:21:0x006a, B:23:0x007a, B:25:0x008b, B:27:0x0091, B:28:0x009a, B:30:0x00b5, B:33:0x00bc, B:34:0x0118, B:38:0x0126, B:40:0x0130, B:42:0x0138, B:45:0x0143, B:47:0x014b, B:49:0x0199, B:51:0x01d7, B:52:0x01dc, B:54:0x01e2, B:55:0x01ea, B:57:0x01f8, B:64:0x0190, B:66:0x0196, B:67:0x0153, B:69:0x0157, B:71:0x0161, B:73:0x016b, B:75:0x0171, B:77:0x0175, B:79:0x017b, B:81:0x017f, B:83:0x0189, B:85:0x00f5, B:88:0x0071, B:90:0x0077), top: B:3:0x0004, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01e2 A[Catch: all -> 0x002b, TryCatch #1 {all -> 0x002b, blocks: (B:4:0x0004, B:6:0x0012, B:8:0x0026, B:9:0x0030, B:11:0x0038, B:12:0x003e, B:14:0x0052, B:16:0x0056, B:17:0x005c, B:19:0x0060, B:21:0x006a, B:23:0x007a, B:25:0x008b, B:27:0x0091, B:28:0x009a, B:30:0x00b5, B:33:0x00bc, B:34:0x0118, B:38:0x0126, B:40:0x0130, B:42:0x0138, B:45:0x0143, B:47:0x014b, B:49:0x0199, B:51:0x01d7, B:52:0x01dc, B:54:0x01e2, B:55:0x01ea, B:57:0x01f8, B:64:0x0190, B:66:0x0196, B:67:0x0153, B:69:0x0157, B:71:0x0161, B:73:0x016b, B:75:0x0171, B:77:0x0175, B:79:0x017b, B:81:0x017f, B:83:0x0189, B:85:0x00f5, B:88:0x0071, B:90:0x0077), top: B:3:0x0004, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01f8 A[Catch: all -> 0x002b, TRY_LEAVE, TryCatch #1 {all -> 0x002b, blocks: (B:4:0x0004, B:6:0x0012, B:8:0x0026, B:9:0x0030, B:11:0x0038, B:12:0x003e, B:14:0x0052, B:16:0x0056, B:17:0x005c, B:19:0x0060, B:21:0x006a, B:23:0x007a, B:25:0x008b, B:27:0x0091, B:28:0x009a, B:30:0x00b5, B:33:0x00bc, B:34:0x0118, B:38:0x0126, B:40:0x0130, B:42:0x0138, B:45:0x0143, B:47:0x014b, B:49:0x0199, B:51:0x01d7, B:52:0x01dc, B:54:0x01e2, B:55:0x01ea, B:57:0x01f8, B:64:0x0190, B:66:0x0196, B:67:0x0153, B:69:0x0157, B:71:0x0161, B:73:0x016b, B:75:0x0171, B:77:0x0175, B:79:0x017b, B:81:0x017f, B:83:0x0189, B:85:0x00f5, B:88:0x0071, B:90:0x0077), top: B:3:0x0004, inners: #0, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void a(android.content.Context r12) {
        /*
            Method dump skipped, instructions count: 515
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.global.e.a(android.content.Context):void");
    }
}
