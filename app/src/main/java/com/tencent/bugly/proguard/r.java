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
    public static r f22838a = new r();

    /* renamed from: b */
    public BetaGrayStrategy f22839b;

    /* renamed from: c */
    public DownloadTask f22840c;

    /* renamed from: g */
    private com.tencent.bugly.beta.global.d f22844g;

    /* renamed from: h */
    private boolean f22845h;

    /* renamed from: d */
    public final Handler f22841d = new Handler(Looper.getMainLooper());

    /* renamed from: e */
    private DownloadListener f22842e = new com.tencent.bugly.beta.download.a(4, this, 0);

    /* renamed from: f */
    private com.tencent.bugly.beta.upgrade.a f22843f = null;

    /* renamed from: i */
    private final Object f22846i = new Object();

    public void a(boolean z10, boolean z11, int i10) {
        BetaGrayStrategy betaGrayStrategy;
        B b10;
        long j10;
        synchronized (this.f22846i) {
            if (i10 != 3 || z10) {
                betaGrayStrategy = null;
            } else {
                try {
                    betaGrayStrategy = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("hotfix.strategy.bch", BetaGrayStrategy.CREATOR);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            com.tencent.bugly.beta.upgrade.a aVar = this.f22843f;
            if (aVar != null && !aVar.f22145d && this.f22845h == z10) {
                synchronized (aVar) {
                    this.f22843f.f22144c[0] = Boolean.valueOf(z10);
                    this.f22843f.f22144c[1] = Boolean.valueOf(z11);
                }
                this.f22844g.f22098b[0] = Boolean.FALSE;
            }
            this.f22845h = z10;
            if (aVar != null) {
                aVar.f22145d = true;
            }
            com.tencent.bugly.beta.upgrade.a aVar2 = new com.tencent.bugly.beta.upgrade.a(1, 804, Boolean.valueOf(z10), Boolean.valueOf(z11), betaGrayStrategy);
            this.f22843f = aVar2;
            this.f22844g = new com.tencent.bugly.beta.global.d(12, Boolean.FALSE, aVar2);
            String str = "";
            if (betaGrayStrategy != null) {
                try {
                    b10 = betaGrayStrategy.f22135a;
                } catch (Throwable th3) {
                    if (!X.a(th3)) {
                        th3.printStackTrace();
                    }
                }
                if (b10 != null) {
                    str = b10.f22570r;
                    j10 = b10.f22572t;
                    long j11 = j10;
                    String str2 = str;
                    HashMap hashMap = new HashMap();
                    hashMap.put("G16", com.tencent.bugly.beta.global.e.f22100b.N);
                    com.tencent.bugly.beta.upgrade.b.f22146a.a(804, i10, M.a((AbstractC0868m) new C(z10 ? 1 : 0, str2, j11, hashMap)), this.f22843f, z10, com.tencent.bugly.beta.global.e.f22100b.H.f22140a.f22857h);
                }
            }
            j10 = 0;
            long j112 = j10;
            String str22 = str;
            HashMap hashMap2 = new HashMap();
            hashMap2.put("G16", com.tencent.bugly.beta.global.e.f22100b.N);
            com.tencent.bugly.beta.upgrade.b.f22146a.a(804, i10, M.a((AbstractC0868m) new C(z10 ? 1 : 0, str22, j112, hashMap2)), this.f22843f, z10, com.tencent.bugly.beta.global.e.f22100b.H.f22140a.f22857h);
        }
    }

    public synchronized void a(int i10, B b10, boolean z10) {
        C0878x a10;
        File file;
        this.f22840c = null;
        BetaGrayStrategy a11 = a(b10);
        this.f22839b = a11;
        if (i10 == 0 && a11 != null) {
            B b11 = a11.f22135a;
            if (b11 == null || b11.f22563k == null || (file = com.tencent.bugly.beta.global.e.f22100b.I) == null || !file.exists() || !com.tencent.bugly.beta.global.a.a(file, this.f22839b.f22135a.f22563k.f22889b, "SHA")) {
                if (b10 != null) {
                    if (com.tencent.bugly.beta.global.e.f22100b.Y != null && (a10 = this.f22839b.f22135a.a()) != null) {
                        this.f22841d.post(new RunnableC0872q(this, a10));
                    }
                    com.tencent.bugly.beta.global.e eVar = com.tencent.bugly.beta.global.e.f22100b;
                    if ((eVar.f22101aa || z10) && eVar.f22102ba) {
                        a();
                    }
                }
                return;
            }
            X.c("patch has downloaded!", new Object[0]);
            com.tencent.bugly.beta.global.e eVar2 = com.tencent.bugly.beta.global.e.f22100b;
            if (!eVar2.P && eVar2.Q <= 3) {
                X.c("patch has downloaded but not patched execute patch!", new Object[0]);
                com.tencent.bugly.beta.global.e eVar3 = com.tencent.bugly.beta.global.e.f22100b;
                int i11 = eVar3.Q + 1;
                eVar3.Q = i11;
                com.tencent.bugly.beta.global.a.b("PATCH_MAX_TIMES", String.valueOf(i11));
                com.tencent.bugly.beta.global.a.a(file, com.tencent.bugly.beta.global.e.f22100b.J);
                TinkerManager.getInstance().onDownloadSuccess(com.tencent.bugly.beta.global.e.f22100b.J.getAbsolutePath(), com.tencent.bugly.beta.global.e.f22100b.X);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v14 */
    public BetaGrayStrategy a(B b10) {
        B b11;
        int i10;
        Map<String, String> map;
        int i11;
        B b12 = b10;
        BetaGrayStrategy betaGrayStrategy = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("hotfix.strategy.bch", BetaGrayStrategy.CREATOR);
        if (betaGrayStrategy == null || betaGrayStrategy.f22135a == null) {
            com.tencent.bugly.beta.global.a.a("hotfix.strategy.bch");
            betaGrayStrategy = null;
        }
        if (b12 != null) {
            if (b12.f22571s != 1 && betaGrayStrategy != null && !TextUtils.isEmpty(betaGrayStrategy.f22135a.f22570r) && TextUtils.equals(b12.f22570r, betaGrayStrategy.f22135a.f22570r)) {
                C0871p c0871p = C0871p.f22799a;
                long currentTimeMillis = System.currentTimeMillis();
                B b13 = betaGrayStrategy.f22135a;
                c0871p.a(new C0880z("recall", currentTimeMillis, (byte) 0, 0L, null, b13.f22570r, b13.f22573u, null));
                com.tencent.bugly.beta.global.a.a("hotfix.strategy.bch");
                com.tencent.bugly.beta.global.e eVar = com.tencent.bugly.beta.global.e.f22100b;
                DownloadTask a10 = eVar.f22123s.a(betaGrayStrategy.f22135a.f22563k.f22890c, eVar.K.getAbsolutePath(), null, betaGrayStrategy.f22135a.f22563k.f22889b);
                a10.setDownloadType(3);
                a10.delete(true);
                File file = com.tencent.bugly.beta.global.e.f22100b.J;
                if (file != null && file.exists() && file.delete()) {
                    X.c("delete tmpPatchFile", new Object[0]);
                }
                File file2 = com.tencent.bugly.beta.global.e.f22100b.I;
                if (file2 != null && file2.exists() && file2.delete()) {
                    i11 = 0;
                    X.c("delete patchFile", new Object[0]);
                } else {
                    i11 = 0;
                }
                com.tencent.bugly.beta.global.a.b("IS_PATCH_ROLL_BACK", true);
                X.c("patch rollback", new Object[i11]);
                if (!ca.b(com.tencent.bugly.beta.global.e.f22100b.f22126v)) {
                    TinkerManager.getInstance().onPatchRollback(true);
                } else {
                    TinkerManager.getInstance().onPatchRollback(i11);
                }
                betaGrayStrategy = null;
            }
            if (b12.f22571s != 1) {
                b12 = null;
            }
        }
        if (b12 == null) {
            if (betaGrayStrategy == null || (b11 = betaGrayStrategy.f22135a) == null || b11.f22573u != 3) {
                return null;
            }
            return betaGrayStrategy;
        }
        BetaGrayStrategy betaGrayStrategy2 = new BetaGrayStrategy();
        betaGrayStrategy2.f22135a = b12;
        betaGrayStrategy2.f22139e = System.currentTimeMillis();
        if (betaGrayStrategy != null && (!TextUtils.equals(betaGrayStrategy.f22135a.f22563k.f22890c, b12.f22563k.f22890c) || ((map = b12.f22569q) != null && TextUtils.equals(map.get("H1"), "false")))) {
            com.tencent.bugly.beta.global.e.f22100b.O = b12.f22569q.get("H2");
            com.tencent.bugly.beta.global.e eVar2 = com.tencent.bugly.beta.global.e.f22100b;
            DownloadTask a11 = eVar2.f22123s.a(betaGrayStrategy.f22135a.f22563k.f22890c, eVar2.K.getAbsolutePath(), null, null);
            a11.setDownloadType(3);
            a11.delete(true);
            if (betaGrayStrategy.f22135a.f22573u == 3) {
                File file3 = com.tencent.bugly.beta.global.e.f22100b.J;
                if (file3 != null && file3.exists() && file3.delete()) {
                    X.c("delete tmpPatchFile", new Object[0]);
                }
                File file4 = com.tencent.bugly.beta.global.e.f22100b.I;
                if (file4 != null && file4.exists() && file4.delete()) {
                    com.tencent.bugly.beta.global.e.f22100b.N = "";
                    i10 = 0;
                    X.c("delete patchFile", new Object[0]);
                } else {
                    i10 = 0;
                }
                com.tencent.bugly.beta.global.e.f22100b.Q = i10;
                com.tencent.bugly.beta.global.a.b("PATCH_MAX_TIMES", "0");
            }
        }
        a(betaGrayStrategy2);
        X.c("onUpgradeReceived: %s [type: %d]", b12, Integer.valueOf(b12.f22573u));
        return betaGrayStrategy2;
    }

    private void a() {
        BetaGrayStrategy betaGrayStrategy = this.f22839b;
        if (betaGrayStrategy == null) {
            return;
        }
        if (this.f22840c == null) {
            com.tencent.bugly.beta.global.e eVar = com.tencent.bugly.beta.global.e.f22100b;
            DownloadTask a10 = eVar.f22123s.a(betaGrayStrategy.f22135a.f22563k.f22890c, eVar.K.getAbsolutePath(), null, this.f22839b.f22135a.f22563k.f22889b);
            this.f22840c = a10;
            a10.setDownloadType(3);
        }
        DownloadTask downloadTask = this.f22840c;
        if (downloadTask == null) {
            return;
        }
        downloadTask.addListener(this.f22842e);
        this.f22840c.setNeededNotify(false);
        this.f22840c.download();
    }

    private void a(BetaGrayStrategy betaGrayStrategy) {
        B b10 = betaGrayStrategy.f22135a;
        if (b10 == null || b10.f22573u != 3) {
            return;
        }
        com.tencent.bugly.beta.global.a.a("hotfix.strategy.bch", betaGrayStrategy);
    }
}
