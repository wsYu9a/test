package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.tinker.TinkerManager;
import com.tencent.bugly.beta.upgrade.BetaGrayStrategy;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class r {

    /* renamed from: a */
    public static r f25134a = new r();

    /* renamed from: b */
    public BetaGrayStrategy f25135b;

    /* renamed from: c */
    public DownloadTask f25136c;

    /* renamed from: g */
    private com.tencent.bugly.beta.global.d f25140g;

    /* renamed from: h */
    private boolean f25141h;

    /* renamed from: d */
    public final Handler f25137d = new Handler(Looper.getMainLooper());

    /* renamed from: e */
    private DownloadListener f25138e = new com.tencent.bugly.beta.download.a(4, this, 0);

    /* renamed from: f */
    private com.tencent.bugly.beta.upgrade.a f25139f = null;

    /* renamed from: i */
    private final Object f25142i = new Object();

    public void a(boolean z, boolean z2, int i2) {
        B b2;
        long j2;
        synchronized (this.f25142i) {
            BetaGrayStrategy betaGrayStrategy = (i2 != 3 || z) ? null : (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("hotfix.strategy.bch", BetaGrayStrategy.CREATOR);
            com.tencent.bugly.beta.upgrade.a aVar = this.f25139f;
            if (aVar != null && !aVar.f24644d && this.f25141h == z) {
                synchronized (aVar) {
                    this.f25139f.f24643c[0] = Boolean.valueOf(z);
                    this.f25139f.f24643c[1] = Boolean.valueOf(z2);
                }
                this.f25140g.f24619b[0] = Boolean.FALSE;
            }
            this.f25141h = z;
            if (aVar != null) {
                aVar.f24644d = true;
            }
            com.tencent.bugly.beta.upgrade.a aVar2 = new com.tencent.bugly.beta.upgrade.a(1, 804, Boolean.valueOf(z), Boolean.valueOf(z2), betaGrayStrategy);
            this.f25139f = aVar2;
            this.f25140g = new com.tencent.bugly.beta.global.d(12, Boolean.FALSE, aVar2);
            String str = "";
            if (betaGrayStrategy != null) {
                try {
                    b2 = betaGrayStrategy.f24634a;
                } catch (Throwable th) {
                    if (!X.a(th)) {
                        th.printStackTrace();
                    }
                }
                if (b2 != null) {
                    str = b2.r;
                    j2 = b2.t;
                    String str2 = str;
                    HashMap hashMap = new HashMap();
                    hashMap.put("G16", com.tencent.bugly.beta.global.e.f24621b.N);
                    com.tencent.bugly.beta.upgrade.b.f24645a.a(804, i2, M.a((AbstractC0909m) new C(z ? 1 : 0, str2, j2, hashMap)), this.f25139f, z, com.tencent.bugly.beta.global.e.f24621b.H.f24639a.f25153h);
                }
            }
            j2 = 0;
            String str22 = str;
            HashMap hashMap2 = new HashMap();
            hashMap2.put("G16", com.tencent.bugly.beta.global.e.f24621b.N);
            com.tencent.bugly.beta.upgrade.b.f24645a.a(804, i2, M.a((AbstractC0909m) new C(z ? 1 : 0, str22, j2, hashMap2)), this.f25139f, z, com.tencent.bugly.beta.global.e.f24621b.H.f24639a.f25153h);
        }
    }

    public synchronized void a(int i2, B b2, boolean z) {
        C0919x a2;
        File file;
        this.f25136c = null;
        BetaGrayStrategy a3 = a(b2);
        this.f25135b = a3;
        if (i2 == 0 && a3 != null) {
            B b3 = a3.f24634a;
            if (b3 == null || b3.k == null || (file = com.tencent.bugly.beta.global.e.f24621b.I) == null || !file.exists() || !com.tencent.bugly.beta.global.a.a(file, this.f25135b.f24634a.k.f25177b, "SHA")) {
                if (b2 != null) {
                    if (com.tencent.bugly.beta.global.e.f24621b.Y != null && (a2 = this.f25135b.f24634a.a()) != null) {
                        this.f25137d.post(new RunnableC0913q(this, a2));
                    }
                    com.tencent.bugly.beta.global.e eVar = com.tencent.bugly.beta.global.e.f24621b;
                    if ((eVar.aa || z) && eVar.ba) {
                        a();
                    }
                }
                return;
            }
            X.c("patch has downloaded!", new Object[0]);
            com.tencent.bugly.beta.global.e eVar2 = com.tencent.bugly.beta.global.e.f24621b;
            if (!eVar2.P && eVar2.Q <= 3) {
                X.c("patch has downloaded but not patched execute patch!", new Object[0]);
                com.tencent.bugly.beta.global.e eVar3 = com.tencent.bugly.beta.global.e.f24621b;
                int i3 = eVar3.Q + 1;
                eVar3.Q = i3;
                com.tencent.bugly.beta.global.a.b("PATCH_MAX_TIMES", String.valueOf(i3));
                com.tencent.bugly.beta.global.a.a(file, com.tencent.bugly.beta.global.e.f24621b.J);
                TinkerManager.getInstance().onDownloadSuccess(com.tencent.bugly.beta.global.e.f24621b.J.getAbsolutePath(), com.tencent.bugly.beta.global.e.f24621b.X);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v36 */
    public BetaGrayStrategy a(B b2) {
        B b3;
        int i2;
        r rVar;
        Map<String, String> map;
        int i3;
        B b4 = b2;
        BetaGrayStrategy betaGrayStrategy = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("hotfix.strategy.bch", BetaGrayStrategy.CREATOR);
        if (betaGrayStrategy == null || betaGrayStrategy.f24634a == null) {
            com.tencent.bugly.beta.global.a.a("hotfix.strategy.bch");
            betaGrayStrategy = null;
        }
        if (b4 != null) {
            if (b4.s != 1 && betaGrayStrategy != null && !TextUtils.isEmpty(betaGrayStrategy.f24634a.r) && TextUtils.equals(b4.r, betaGrayStrategy.f24634a.r)) {
                C0912p c0912p = C0912p.f25111a;
                long currentTimeMillis = System.currentTimeMillis();
                B b5 = betaGrayStrategy.f24634a;
                c0912p.a(new C0921z("recall", currentTimeMillis, (byte) 0, 0L, null, b5.r, b5.u, null));
                com.tencent.bugly.beta.global.a.a("hotfix.strategy.bch");
                com.tencent.bugly.beta.global.e eVar = com.tencent.bugly.beta.global.e.f24621b;
                DownloadTask a2 = eVar.s.a(betaGrayStrategy.f24634a.k.f25178c, eVar.K.getAbsolutePath(), null, betaGrayStrategy.f24634a.k.f25177b);
                a2.setDownloadType(3);
                a2.delete(true);
                File file = com.tencent.bugly.beta.global.e.f24621b.J;
                if (file != null && file.exists() && file.delete()) {
                    X.c("delete tmpPatchFile", new Object[0]);
                }
                File file2 = com.tencent.bugly.beta.global.e.f24621b.I;
                if (file2 != null && file2.exists() && file2.delete()) {
                    i3 = 0;
                    X.c("delete patchFile", new Object[0]);
                } else {
                    i3 = 0;
                }
                com.tencent.bugly.beta.global.a.b("IS_PATCH_ROLL_BACK", true);
                X.c("patch rollback", new Object[i3]);
                if (!ca.b(com.tencent.bugly.beta.global.e.f24621b.v)) {
                    TinkerManager.getInstance().onPatchRollback(true);
                } else {
                    TinkerManager.getInstance().onPatchRollback(i3);
                }
                betaGrayStrategy = null;
            }
            if (b4.s != 1) {
                b4 = null;
            }
        }
        if (b4 == null) {
            if (betaGrayStrategy == null || (b3 = betaGrayStrategy.f24634a) == null || b3.u != 3) {
                return null;
            }
            return betaGrayStrategy;
        }
        BetaGrayStrategy betaGrayStrategy2 = new BetaGrayStrategy();
        betaGrayStrategy2.f24634a = b4;
        betaGrayStrategy2.f24638e = System.currentTimeMillis();
        if (betaGrayStrategy != null) {
            if (!TextUtils.equals(betaGrayStrategy.f24634a.k.f25178c, b4.k.f25178c) || ((map = b4.q) != null && TextUtils.equals(map.get("H1"), "false"))) {
                com.tencent.bugly.beta.global.e.f24621b.O = b4.q.get("H2");
                com.tencent.bugly.beta.global.e eVar2 = com.tencent.bugly.beta.global.e.f24621b;
                DownloadTask a3 = eVar2.s.a(betaGrayStrategy.f24634a.k.f25178c, eVar2.K.getAbsolutePath(), null, null);
                a3.setDownloadType(3);
                a3.delete(true);
                if (betaGrayStrategy.f24634a.u == 3) {
                    File file3 = com.tencent.bugly.beta.global.e.f24621b.J;
                    if (file3 != null && file3.exists() && file3.delete()) {
                        X.c("delete tmpPatchFile", new Object[0]);
                    }
                    File file4 = com.tencent.bugly.beta.global.e.f24621b.I;
                    if (file4 != null && file4.exists() && file4.delete()) {
                        com.tencent.bugly.beta.global.e.f24621b.N = "";
                        i2 = 0;
                        X.c("delete patchFile", new Object[0]);
                    } else {
                        i2 = 0;
                    }
                    com.tencent.bugly.beta.global.e.f24621b.Q = i2;
                    com.tencent.bugly.beta.global.a.b("PATCH_MAX_TIMES", "0");
                    rVar = this;
                    rVar.a(betaGrayStrategy2);
                    Object[] objArr = new Object[2];
                    objArr[i2] = b4;
                    objArr[1] = Integer.valueOf(b4.u);
                    X.c("onUpgradeReceived: %s [type: %d]", objArr);
                    return betaGrayStrategy2;
                }
            } else {
                rVar = this;
                i2 = 0;
                rVar.a(betaGrayStrategy2);
                Object[] objArr2 = new Object[2];
                objArr2[i2] = b4;
                objArr2[1] = Integer.valueOf(b4.u);
                X.c("onUpgradeReceived: %s [type: %d]", objArr2);
                return betaGrayStrategy2;
            }
        }
        i2 = 0;
        rVar = this;
        rVar.a(betaGrayStrategy2);
        Object[] objArr22 = new Object[2];
        objArr22[i2] = b4;
        objArr22[1] = Integer.valueOf(b4.u);
        X.c("onUpgradeReceived: %s [type: %d]", objArr22);
        return betaGrayStrategy2;
    }

    private void a() {
        BetaGrayStrategy betaGrayStrategy = this.f25135b;
        if (betaGrayStrategy == null) {
            return;
        }
        if (this.f25136c == null) {
            com.tencent.bugly.beta.global.e eVar = com.tencent.bugly.beta.global.e.f24621b;
            DownloadTask a2 = eVar.s.a(betaGrayStrategy.f24634a.k.f25178c, eVar.K.getAbsolutePath(), null, this.f25135b.f24634a.k.f25177b);
            this.f25136c = a2;
            a2.setDownloadType(3);
        }
        DownloadTask downloadTask = this.f25136c;
        if (downloadTask == null) {
            return;
        }
        downloadTask.addListener(this.f25138e);
        this.f25136c.setNeededNotify(false);
        this.f25136c.download();
    }

    private void a(BetaGrayStrategy betaGrayStrategy) {
        B b2 = betaGrayStrategy.f24634a;
        if (b2 == null || b2.u != 3) {
            return;
        }
        com.tencent.bugly.beta.global.a.a("hotfix.strategy.bch", betaGrayStrategy);
    }
}
