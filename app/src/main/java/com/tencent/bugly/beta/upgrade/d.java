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
import com.tencent.bugly.proguard.C0871p;
import com.tencent.bugly.proguard.C0878x;
import com.tencent.bugly.proguard.C0879y;
import com.tencent.bugly.proguard.C0880z;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import com.tencent.bugly.proguard.ra;
import com.tencent.bugly.proguard.sa;
import java.io.File;
import java.util.Map;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    public static d f22149a = new d();

    /* renamed from: b */
    public BetaGrayStrategy f22150b;

    /* renamed from: c */
    public DownloadTask f22151c;

    /* renamed from: d */
    public DownloadListener f22152d;

    /* renamed from: e */
    public UpgradeListener f22153e;

    /* renamed from: f */
    public UpgradeStateListener f22154f;

    /* renamed from: g */
    public boolean f22155g;

    /* renamed from: h */
    public boolean f22156h;

    /* renamed from: i */
    public com.tencent.bugly.beta.global.d f22157i;

    /* renamed from: j */
    public com.tencent.bugly.beta.global.d f22158j;

    /* renamed from: k */
    public int f22159k;

    /* renamed from: l */
    private final Object f22160l = new Object();

    /* renamed from: m */
    private final Object f22161m = new Object();

    /* renamed from: n */
    private DownloadListener f22162n = new com.tencent.bugly.beta.download.a(3, this, 0);

    /* renamed from: o */
    private a f22163o = null;

    /* renamed from: p */
    private com.tencent.bugly.beta.global.d f22164p;

    /* renamed from: q */
    private boolean f22165q;

    /* renamed from: r */
    private int f22166r;

    private B b() {
        BetaGrayStrategy betaGrayStrategy = this.f22150b;
        if (betaGrayStrategy == null) {
            return null;
        }
        return betaGrayStrategy.f22135a;
    }

    private DownloadTask c() {
        B b10 = b();
        if (b10 == null) {
            return null;
        }
        if (this.f22151c == null) {
            e eVar = e.f22100b;
            DownloadTask a10 = eVar.f22123s.a(b10.f22563k.f22890c, eVar.f22127w.getAbsolutePath(), null, this.f22150b.f22135a.f22563k.f22889b);
            this.f22151c = a10;
            a10.setDownloadType(1);
        }
        return this.f22151c;
    }

    private void b(boolean z10) {
        new Handler(Looper.getMainLooper()).post(new c(this, z10));
    }

    public BetaGrayStrategy a(B b10) {
        BetaGrayStrategy betaGrayStrategy;
        BetaGrayStrategy betaGrayStrategy2;
        C0879y c0879y;
        int i10;
        e eVar;
        int i11;
        B b11;
        C0879y c0879y2;
        int i12;
        e eVar2;
        int i13;
        C0878x c0878x;
        B b12 = b10;
        synchronized (this.f22160l) {
            try {
                BetaGrayStrategy betaGrayStrategy3 = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
                betaGrayStrategy = null;
                if (betaGrayStrategy3 != null && betaGrayStrategy3.f22135a == null) {
                    com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch");
                    betaGrayStrategy3 = null;
                }
                if (betaGrayStrategy3 != null && (b11 = betaGrayStrategy3.f22135a) != null && ((i12 = (c0879y2 = b11.f22562j).f22897d) < (i13 = (eVar2 = e.f22100b).f22130z) || ((i12 == i13 && c0879y2.f22899f <= eVar2.f22122r) || b11.f22571s != 1 || ((c0878x = b11.f22563k) != null && TextUtils.equals(eVar2.f22129y, c0878x.f22889b))))) {
                    com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch");
                    this.f22151c = null;
                    betaGrayStrategy3 = null;
                }
                if (b12 != null && ((i10 = (c0879y = b12.f22562j).f22897d) < (i11 = (eVar = e.f22100b).f22130z) || (i10 == i11 && c0879y.f22899f <= eVar.f22122r))) {
                    X.c("versionCode is too small, discard remote strategy: [new: %d buildno: %d] [current: %d buildno: %d]", Integer.valueOf(i10), Integer.valueOf(b12.f22562j.f22899f), Integer.valueOf(e.f22100b.f22130z), Integer.valueOf(e.f22100b.f22122r));
                    b12 = null;
                }
                if (b12 != null) {
                    if (b12.f22571s == 2 && betaGrayStrategy3 != null && betaGrayStrategy3.f22135a != null && !TextUtils.isEmpty(b12.f22570r) && !TextUtils.isEmpty(betaGrayStrategy3.f22135a.f22570r) && TextUtils.equals(b12.f22570r, betaGrayStrategy3.f22135a.f22570r)) {
                        X.c("撤回 strategy: %s", b12.f22570r);
                        betaGrayStrategy3 = null;
                    }
                    if (b12.f22571s != 1) {
                        X.c("invalid strategy: %s", b12.f22570r);
                        b12 = null;
                    }
                }
                if (b12 != null) {
                    if (betaGrayStrategy3 == null || betaGrayStrategy3.f22135a == null || TextUtils.isEmpty(b12.f22570r) || TextUtils.isEmpty(betaGrayStrategy3.f22135a.f22570r) || !TextUtils.equals(b12.f22570r, betaGrayStrategy3.f22135a.f22570r)) {
                        betaGrayStrategy2 = new BetaGrayStrategy();
                    } else {
                        BetaGrayStrategy betaGrayStrategy4 = new BetaGrayStrategy(ca.d(ca.a(betaGrayStrategy3)));
                        X.c("same strategyId:[new: %s] [current: %s] keep has popup times: %d, interval: %d", b12.f22570r, betaGrayStrategy3.f22135a.f22570r, Integer.valueOf(betaGrayStrategy4.f22136b), Long.valueOf(b12.f22566n));
                        betaGrayStrategy2 = betaGrayStrategy4;
                    }
                    betaGrayStrategy2.f22135a = b12;
                    betaGrayStrategy2.f22139e = System.currentTimeMillis();
                    if (betaGrayStrategy3 != null && !betaGrayStrategy3.f22135a.f22563k.f22890c.equals(b12.f22563k.f22890c)) {
                        DownloadTask downloadTask = this.f22151c;
                        if (downloadTask == null) {
                            e eVar3 = e.f22100b;
                            DownloadTask a10 = eVar3.f22123s.a(betaGrayStrategy3.f22135a.f22563k.f22890c, eVar3.f22127w.getAbsolutePath(), null, null);
                            this.f22151c = a10;
                            a10.setDownloadType(1);
                            this.f22151c.delete(true);
                            for (File file : e.f22100b.f22127w.listFiles()) {
                                if (!file.delete()) {
                                    X.b("cannot deleteCache file:%s", file.getAbsolutePath());
                                }
                            }
                            this.f22151c = null;
                        } else {
                            BetaReceiver.netListeners.remove(downloadTask.getDownloadUrl());
                            this.f22151c.delete(true);
                            this.f22151c = null;
                        }
                    }
                    a(betaGrayStrategy2);
                    X.c("onUpgradeReceived: %s [type: %d]", b12, Integer.valueOf(b12.f22564l));
                    C0871p.f22799a.a(new C0880z("rcv", System.currentTimeMillis(), (byte) 0, 0L, b12.f22562j, b12.f22570r, b12.f22573u, null));
                    betaGrayStrategy = betaGrayStrategy2;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return betaGrayStrategy;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0064, code lost:
    
        if ((r11.f22135a.f22565m - r11.f22136b) <= 0) goto L261;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01a2, code lost:
    
        if (r4.f22564l != 3) goto L332;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r17, boolean r18, int r19, com.tencent.bugly.proguard.B r20, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 519
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.upgrade.d.a(boolean, boolean, int, com.tencent.bugly.proguard.B, java.lang.String):void");
    }

    private void a() {
        B b10 = b();
        if (b10 == null) {
            return;
        }
        if (this.f22151c == null) {
            this.f22151c = c();
        }
        if (this.f22151c == null) {
            return;
        }
        a(this.f22150b);
        BetaReceiver.addTask(this.f22151c);
        if (this.f22151c.getStatus() == 1 && !this.f22156h) {
            if (this.f22155g && com.tencent.bugly.beta.global.a.a(e.f22100b.f22126v, this.f22151c.getSaveFile(), b10.f22563k.f22889b)) {
                C0871p.f22799a.a(new C0880z("install", System.currentTimeMillis(), (byte) 0, 0L, b10.f22562j, b10.f22570r, b10.f22573u, null));
                return;
            } else {
                b(this.f22155g);
                return;
            }
        }
        this.f22151c.download();
    }

    public void a(boolean z10) {
        B b10 = b();
        if (b10 == null) {
            return;
        }
        if (System.currentTimeMillis() <= b10.b() - 86400000) {
            X.b(System.currentTimeMillis() + "ms", new Object[0]);
            return;
        }
        f.f22131a.a(e.f22100b.f22123s, b10.f22569q);
        if (this.f22151c == null) {
            this.f22151c = c();
        }
        DownloadTask downloadTask = this.f22151c;
        if (downloadTask == null) {
            return;
        }
        if (!z10 && downloadTask.getStatus() == 2) {
            X.c("Task is downloading %s %s", b10.f22570r, this.f22151c.getDownloadUrl());
            return;
        }
        this.f22151c.addListener(this.f22162n);
        DownloadListener downloadListener = this.f22152d;
        if (downloadListener != null) {
            this.f22151c.addListener(downloadListener);
        }
        UpgradeDialog upgradeDialog = UpgradeDialog.instance;
        upgradeDialog.setUpgradeInfo(b10, this.f22151c);
        upgradeDialog.upgradeRunnable = new com.tencent.bugly.beta.global.d(3, this.f22150b, this.f22151c);
        upgradeDialog.cancelRunnable = new com.tencent.bugly.beta.global.d(4, this.f22150b, this.f22151c, Boolean.valueOf(z10));
        this.f22150b.f22137c = System.currentTimeMillis();
        a(this.f22150b);
        if (z10) {
            f.f22131a.a(new com.tencent.bugly.beta.global.d(2, upgradeDialog, Boolean.valueOf(z10)), 3000);
        } else {
            f.f22131a.a(new com.tencent.bugly.beta.global.d(2, upgradeDialog, Boolean.valueOf(z10 || b10.f22564l == 2)));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x0074, code lost:
    
        if (r4 == null) goto L254;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0076, code lost:
    
        r5 = r4.f22135a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0078, code lost:
    
        if (r5 == null) goto L254;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x007c, code lost:
    
        if (r5.f22573u != 3) goto L254;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0085 A[Catch: all -> 0x0034, TryCatch #1 {, blocks: (B:5:0x001c, B:8:0x002b, B:10:0x0081, B:12:0x0085, B:14:0x0089, B:16:0x008d, B:19:0x0092, B:23:0x00a8, B:26:0x016b, B:27:0x0177, B:31:0x0163, B:33:0x0167, B:38:0x00b4, B:39:0x00b5, B:41:0x00bb, B:42:0x00bd, B:59:0x0154, B:61:0x015a, B:69:0x003c, B:71:0x0046, B:73:0x004e, B:76:0x0054, B:78:0x0058, B:83:0x0076, B:85:0x007a, B:90:0x0063, B:94:0x006a, B:21:0x0093, B:22:0x00a7, B:63:0x00eb, B:65:0x00ef, B:47:0x00ff, B:49:0x0106, B:51:0x010d, B:53:0x011c, B:55:0x0133), top: B:4:0x001c, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x015f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bb A[Catch: all -> 0x0034, TryCatch #1 {, blocks: (B:5:0x001c, B:8:0x002b, B:10:0x0081, B:12:0x0085, B:14:0x0089, B:16:0x008d, B:19:0x0092, B:23:0x00a8, B:26:0x016b, B:27:0x0177, B:31:0x0163, B:33:0x0167, B:38:0x00b4, B:39:0x00b5, B:41:0x00bb, B:42:0x00bd, B:59:0x0154, B:61:0x015a, B:69:0x003c, B:71:0x0046, B:73:0x004e, B:76:0x0054, B:78:0x0058, B:83:0x0076, B:85:0x007a, B:90:0x0063, B:94:0x006a, B:21:0x0093, B:22:0x00a7, B:63:0x00eb, B:65:0x00ef, B:47:0x00ff, B:49:0x0106, B:51:0x010d, B:53:0x011c, B:55:0x0133), top: B:4:0x001c, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r17, boolean r18, int r19) {
        /*
            Method dump skipped, instructions count: 379
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.upgrade.d.a(boolean, boolean, int):void");
    }

    public void a(sa saVar) {
        e eVar = e.f22100b;
        if (eVar.H == null) {
            eVar.H = new BetaUploadStrategy();
        }
        if (saVar != null) {
            BetaUploadStrategy betaUploadStrategy = e.f22100b.H;
            long j10 = betaUploadStrategy.f22141b;
            long j11 = saVar.f22860k;
            if (j10 == j11) {
                return;
            }
            betaUploadStrategy.f22141b = j11;
            sa saVar2 = betaUploadStrategy.f22140a;
            saVar2.f22854e = saVar.f22854e;
            saVar2.f22855f = saVar.f22855f;
            saVar2.f22860k = j11;
            if (ca.c(saVar.f22856g)) {
                e.f22100b.H.f22140a.f22856g = saVar.f22856g;
            }
            if (ca.c(saVar.f22857h)) {
                e.f22100b.H.f22140a.f22857h = saVar.f22857h;
            }
            ra raVar = saVar.f22858i;
            if (raVar != null && !TextUtils.isEmpty(raVar.f22847a)) {
                e.f22100b.H.f22140a.f22858i.f22847a = saVar.f22858i.f22847a;
            }
            Map<String, String> map = saVar.f22859j;
            if (map != null && map.size() > 0) {
                e.f22100b.H.f22140a.f22859j = saVar.f22859j;
            }
            if (ca.c(saVar.f22861l)) {
                e.f22100b.H.f22140a.f22861l = saVar.f22861l;
            }
            if (ca.c(saVar.f22862m)) {
                e.f22100b.H.f22140a.f22862m = saVar.f22862m;
            }
            com.tencent.bugly.beta.global.a.a("us.bch", e.f22100b.H);
        }
    }

    private void a(BetaGrayStrategy betaGrayStrategy) {
        B b10 = betaGrayStrategy.f22135a;
        if (b10 == null || b10.f22573u != 1) {
            return;
        }
        com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch", betaGrayStrategy);
    }
}
