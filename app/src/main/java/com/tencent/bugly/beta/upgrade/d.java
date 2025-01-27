package com.tencent.bugly.beta.upgrade;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.bugly.beta.download.BetaReceiver;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.beta.global.f;
import com.tencent.bugly.beta.ui.UpgradeDialog;
import com.tencent.bugly.proguard.B;
import com.tencent.bugly.proguard.C0912p;
import com.tencent.bugly.proguard.C0919x;
import com.tencent.bugly.proguard.C0920y;
import com.tencent.bugly.proguard.C0921z;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import com.tencent.bugly.proguard.ra;
import com.tencent.bugly.proguard.sa;
import java.io.File;
import java.util.Map;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    public static d f24648a = new d();

    /* renamed from: b */
    public BetaGrayStrategy f24649b;

    /* renamed from: c */
    public DownloadTask f24650c;

    /* renamed from: d */
    public DownloadListener f24651d;

    /* renamed from: e */
    public UpgradeListener f24652e;

    /* renamed from: f */
    public UpgradeStateListener f24653f;

    /* renamed from: g */
    public boolean f24654g;

    /* renamed from: h */
    public boolean f24655h;

    /* renamed from: i */
    public com.tencent.bugly.beta.global.d f24656i;

    /* renamed from: j */
    public com.tencent.bugly.beta.global.d f24657j;
    public int k;
    private final Object l = new Object();
    private final Object m = new Object();
    private DownloadListener n = new com.tencent.bugly.beta.download.a(3, this, 0);
    private a o = null;
    private com.tencent.bugly.beta.global.d p;
    private boolean q;
    private int r;

    private B b() {
        BetaGrayStrategy betaGrayStrategy = this.f24649b;
        if (betaGrayStrategy == null) {
            return null;
        }
        return betaGrayStrategy.f24634a;
    }

    private DownloadTask c() {
        B b2 = b();
        if (b2 == null) {
            return null;
        }
        if (this.f24650c == null) {
            e eVar = e.f24621b;
            DownloadTask a2 = eVar.s.a(b2.k.f25178c, eVar.w.getAbsolutePath(), null, this.f24649b.f24634a.k.f25177b);
            this.f24650c = a2;
            a2.setDownloadType(1);
        }
        return this.f24650c;
    }

    private void b(boolean z) {
        new Handler(Looper.getMainLooper()).post(new c(this, z));
    }

    public BetaGrayStrategy a(B b2) {
        BetaGrayStrategy betaGrayStrategy;
        BetaGrayStrategy betaGrayStrategy2;
        C0920y c0920y;
        int i2;
        e eVar;
        int i3;
        B b3;
        C0920y c0920y2;
        int i4;
        e eVar2;
        int i5;
        C0919x c0919x;
        B b4 = b2;
        synchronized (this.l) {
            BetaGrayStrategy betaGrayStrategy3 = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
            betaGrayStrategy = null;
            if (betaGrayStrategy3 != null && betaGrayStrategy3.f24634a == null) {
                com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch");
                betaGrayStrategy3 = null;
            }
            if (betaGrayStrategy3 != null && (b3 = betaGrayStrategy3.f24634a) != null && ((i4 = (c0920y2 = b3.f24932j).f25185d) < (i5 = (eVar2 = e.f24621b).z) || ((i4 == i5 && c0920y2.f25187f <= eVar2.r) || b3.s != 1 || ((c0919x = b3.k) != null && TextUtils.equals(eVar2.y, c0919x.f25177b))))) {
                com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch");
                this.f24650c = null;
                betaGrayStrategy3 = null;
            }
            if (b4 != null && ((i2 = (c0920y = b4.f24932j).f25185d) < (i3 = (eVar = e.f24621b).z) || (i2 == i3 && c0920y.f25187f <= eVar.r))) {
                X.c("versionCode is too small, discard remote strategy: [new: %d buildno: %d] [current: %d buildno: %d]", Integer.valueOf(i2), Integer.valueOf(b4.f24932j.f25187f), Integer.valueOf(e.f24621b.z), Integer.valueOf(e.f24621b.r));
                b4 = null;
            }
            if (b4 != null) {
                if (b4.s == 2 && betaGrayStrategy3 != null && betaGrayStrategy3.f24634a != null && !TextUtils.isEmpty(b4.r) && !TextUtils.isEmpty(betaGrayStrategy3.f24634a.r) && TextUtils.equals(b4.r, betaGrayStrategy3.f24634a.r)) {
                    X.c("撤回 strategy: %s", b4.r);
                    betaGrayStrategy3 = null;
                }
                if (b4.s != 1) {
                    X.c("invalid strategy: %s", b4.r);
                    b4 = null;
                }
            }
            if (b4 != null) {
                if (betaGrayStrategy3 == null || betaGrayStrategy3.f24634a == null || TextUtils.isEmpty(b4.r) || TextUtils.isEmpty(betaGrayStrategy3.f24634a.r) || !TextUtils.equals(b4.r, betaGrayStrategy3.f24634a.r)) {
                    betaGrayStrategy2 = new BetaGrayStrategy();
                } else {
                    betaGrayStrategy2 = new BetaGrayStrategy(ca.d(ca.a(betaGrayStrategy3)));
                    X.c("same strategyId:[new: %s] [current: %s] keep has popup times: %d, interval: %d", b4.r, betaGrayStrategy3.f24634a.r, Integer.valueOf(betaGrayStrategy2.f24635b), Long.valueOf(b4.n));
                }
                betaGrayStrategy2.f24634a = b4;
                betaGrayStrategy2.f24638e = System.currentTimeMillis();
                if (betaGrayStrategy3 != null && !betaGrayStrategy3.f24634a.k.f25178c.equals(b4.k.f25178c)) {
                    DownloadTask downloadTask = this.f24650c;
                    if (downloadTask == null) {
                        e eVar3 = e.f24621b;
                        DownloadTask a2 = eVar3.s.a(betaGrayStrategy3.f24634a.k.f25178c, eVar3.w.getAbsolutePath(), null, null);
                        this.f24650c = a2;
                        a2.setDownloadType(1);
                        this.f24650c.delete(true);
                        for (File file : e.f24621b.w.listFiles()) {
                            if (!file.delete()) {
                                X.b("cannot deleteCache file:%s", file.getAbsolutePath());
                            }
                        }
                        this.f24650c = null;
                    } else {
                        BetaReceiver.netListeners.remove(downloadTask.getDownloadUrl());
                        this.f24650c.delete(true);
                        this.f24650c = null;
                    }
                }
                a(betaGrayStrategy2);
                X.c("onUpgradeReceived: %s [type: %d]", b4, Integer.valueOf(b4.l));
                C0912p.f25111a.a(new C0921z("rcv", System.currentTimeMillis(), (byte) 0, 0L, b4.f24932j, b4.r, b4.u, null));
                betaGrayStrategy = betaGrayStrategy2;
            }
        }
        return betaGrayStrategy;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0060, code lost:
    
        if ((r5.f24634a.m - r5.f24635b) <= 0) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01a4, code lost:
    
        if (r5.l != 3) goto L212;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r16, boolean r17, int r18, com.tencent.bugly.proguard.B r19, java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 523
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.upgrade.d.a(boolean, boolean, int, com.tencent.bugly.proguard.B, java.lang.String):void");
    }

    private void a() {
        B b2 = b();
        if (b2 == null) {
            return;
        }
        if (this.f24650c == null) {
            this.f24650c = c();
        }
        if (this.f24650c == null) {
            return;
        }
        a(this.f24649b);
        BetaReceiver.addTask(this.f24650c);
        if (this.f24650c.getStatus() == 1 && !this.f24655h) {
            if (this.f24654g && com.tencent.bugly.beta.global.a.a(e.f24621b.v, this.f24650c.getSaveFile(), b2.k.f25177b)) {
                C0912p.f25111a.a(new C0921z("install", System.currentTimeMillis(), (byte) 0, 0L, b2.f24932j, b2.r, b2.u, null));
                return;
            } else {
                b(this.f24654g);
                return;
            }
        }
        this.f24650c.download();
    }

    public void a(boolean z) {
        B b2 = b();
        if (b2 == null) {
            return;
        }
        if (System.currentTimeMillis() <= b2.b() - 86400000) {
            X.b(System.currentTimeMillis() + "ms", new Object[0]);
            return;
        }
        f.f24630a.a(e.f24621b.s, b2.q);
        if (this.f24650c == null) {
            this.f24650c = c();
        }
        DownloadTask downloadTask = this.f24650c;
        if (downloadTask == null) {
            return;
        }
        if (!z && downloadTask.getStatus() == 2) {
            X.c("Task is downloading %s %s", b2.r, this.f24650c.getDownloadUrl());
            return;
        }
        this.f24650c.addListener(this.n);
        DownloadListener downloadListener = this.f24651d;
        if (downloadListener != null) {
            this.f24650c.addListener(downloadListener);
        }
        UpgradeDialog upgradeDialog = UpgradeDialog.instance;
        upgradeDialog.setUpgradeInfo(b2, this.f24650c);
        upgradeDialog.upgradeRunnable = new com.tencent.bugly.beta.global.d(3, this.f24649b, this.f24650c);
        upgradeDialog.cancelRunnable = new com.tencent.bugly.beta.global.d(4, this.f24649b, this.f24650c, Boolean.valueOf(z));
        this.f24649b.f24636c = System.currentTimeMillis();
        a(this.f24649b);
        if (z) {
            f.f24630a.a(new com.tencent.bugly.beta.global.d(2, upgradeDialog, Boolean.valueOf(z)), 3000);
            return;
        }
        f fVar = f.f24630a;
        Object[] objArr = new Object[2];
        objArr[0] = upgradeDialog;
        objArr[1] = Boolean.valueOf(z || b2.l == 2);
        fVar.a(new com.tencent.bugly.beta.global.d(2, objArr));
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x0070, code lost:
    
        if (r4 == null) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0072, code lost:
    
        r5 = r4.f24634a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0074, code lost:
    
        if (r5 == null) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0078, code lost:
    
        if (r5.u != 3) goto L145;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0083 A[Catch: all -> 0x0175, TryCatch #1 {, blocks: (B:5:0x001a, B:9:0x002b, B:11:0x007e, B:13:0x0083, B:15:0x0087, B:17:0x008b, B:20:0x0090, B:24:0x00a6, B:27:0x0167, B:28:0x0173, B:32:0x015f, B:34:0x0163, B:39:0x00b2, B:40:0x00b3, B:42:0x00b9, B:43:0x00bb, B:58:0x0150, B:60:0x0156, B:67:0x0038, B:69:0x0042, B:71:0x004a, B:74:0x0050, B:76:0x0054, B:81:0x0072, B:83:0x0076, B:89:0x005f, B:93:0x0066, B:22:0x0091, B:23:0x00a5, B:62:0x00eb, B:64:0x00ef, B:47:0x00f9, B:49:0x0101, B:51:0x0108, B:53:0x0117, B:55:0x012e), top: B:4:0x001a, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x015b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b9 A[Catch: all -> 0x0175, TryCatch #1 {, blocks: (B:5:0x001a, B:9:0x002b, B:11:0x007e, B:13:0x0083, B:15:0x0087, B:17:0x008b, B:20:0x0090, B:24:0x00a6, B:27:0x0167, B:28:0x0173, B:32:0x015f, B:34:0x0163, B:39:0x00b2, B:40:0x00b3, B:42:0x00b9, B:43:0x00bb, B:58:0x0150, B:60:0x0156, B:67:0x0038, B:69:0x0042, B:71:0x004a, B:74:0x0050, B:76:0x0054, B:81:0x0072, B:83:0x0076, B:89:0x005f, B:93:0x0066, B:22:0x0091, B:23:0x00a5, B:62:0x00eb, B:64:0x00ef, B:47:0x00f9, B:49:0x0101, B:51:0x0108, B:53:0x0117, B:55:0x012e), top: B:4:0x001a, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r17, boolean r18, int r19) {
        /*
            Method dump skipped, instructions count: 376
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.upgrade.d.a(boolean, boolean, int):void");
    }

    public void a(sa saVar) {
        e eVar = e.f24621b;
        if (eVar.H == null) {
            eVar.H = new BetaUploadStrategy();
        }
        if (saVar != null) {
            BetaUploadStrategy betaUploadStrategy = e.f24621b.H;
            long j2 = betaUploadStrategy.f24640b;
            long j3 = saVar.k;
            if (j2 == j3) {
                return;
            }
            betaUploadStrategy.f24640b = j3;
            sa saVar2 = betaUploadStrategy.f24639a;
            saVar2.f25150e = saVar.f25150e;
            saVar2.f25151f = saVar.f25151f;
            saVar2.k = j3;
            if (ca.c(saVar.f25152g)) {
                e.f24621b.H.f24639a.f25152g = saVar.f25152g;
            }
            if (ca.c(saVar.f25153h)) {
                e.f24621b.H.f24639a.f25153h = saVar.f25153h;
            }
            ra raVar = saVar.f25154i;
            if (raVar != null && !TextUtils.isEmpty(raVar.f25143a)) {
                e.f24621b.H.f24639a.f25154i.f25143a = saVar.f25154i.f25143a;
            }
            Map<String, String> map = saVar.f25155j;
            if (map != null && map.size() > 0) {
                e.f24621b.H.f24639a.f25155j = saVar.f25155j;
            }
            if (ca.c(saVar.l)) {
                e.f24621b.H.f24639a.l = saVar.l;
            }
            if (ca.c(saVar.m)) {
                e.f24621b.H.f24639a.m = saVar.m;
            }
            com.tencent.bugly.beta.global.a.a("us.bch", e.f24621b.H);
        }
    }

    private void a(BetaGrayStrategy betaGrayStrategy) {
        B b2 = betaGrayStrategy.f24634a;
        if (b2 == null || b2.u != 1) {
            return;
        }
        com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch", betaGrayStrategy);
    }
}
