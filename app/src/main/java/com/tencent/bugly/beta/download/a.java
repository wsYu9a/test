package com.tencent.bugly.beta.download;

import android.os.Build;
import android.util.Log;
import com.tencent.bugly.beta.global.ResBean;
import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.beta.global.f;
import com.tencent.bugly.beta.tinker.TinkerManager;
import com.tencent.bugly.beta.ui.UpgradeDialog;
import com.tencent.bugly.beta.upgrade.BetaGrayStrategy;
import com.tencent.bugly.beta.upgrade.UpgradeStateListener;
import com.tencent.bugly.proguard.B;
import com.tencent.bugly.proguard.C0912p;
import com.tencent.bugly.proguard.C0921z;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.r;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
public class a implements DownloadListener {

    /* renamed from: a */
    final int f24602a;

    /* renamed from: b */
    final Object[] f24603b;

    public a(int i2, Object... objArr) {
        this.f24602a = i2;
        this.f24603b = objArr;
    }

    @Override // com.tencent.bugly.beta.download.DownloadListener
    public void onCompleted(DownloadTask downloadTask) {
        try {
            int i2 = this.f24602a;
            if (i2 == 1) {
                synchronized (this.f24603b[0]) {
                    Map map = (Map) this.f24603b[1];
                    if (map.size() == 0) {
                        return;
                    }
                    Iterator it = map.values().iterator();
                    int i3 = 0;
                    while (it.hasNext()) {
                        if (((DownloadTask) it.next()).getStatus() == 1) {
                            i3++;
                        }
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(i3);
                    sb.append(" has completed");
                    X.a(sb.toString(), new Object[0]);
                    if (i3 < map.size()) {
                        return;
                    }
                    for (String str : map.keySet()) {
                        if (((DownloadTask) map.get(str)).getSaveFile() != null && ((DownloadTask) map.get(str)).getSaveFile().exists()) {
                            ResBean.f24609a.a(str, ((DownloadTask) map.get(str)).getSaveFile().getAbsolutePath());
                        }
                    }
                    com.tencent.bugly.beta.global.a.a("rb.bch", ResBean.f24609a);
                    f fVar = (f) this.f24603b[0];
                    fVar.a();
                    fVar.b();
                    return;
                }
            }
            if (i2 == 2) {
                ((UpgradeDialog) this.f24603b[0]).updateBtn(downloadTask);
                return;
            }
            if (i2 != 3) {
                if (i2 != 4) {
                    return;
                }
                Object[] objArr = this.f24603b;
                r rVar = (r) objArr[0];
                Integer num = (Integer) objArr[1];
                BetaGrayStrategy betaGrayStrategy = rVar.f25135b;
                if (betaGrayStrategy == null || betaGrayStrategy.f24634a == null) {
                    return;
                }
                X.c("patch download success !!!", new Object[0]);
                File saveFile = downloadTask.getSaveFile();
                if (!com.tencent.bugly.beta.global.a.a(saveFile, betaGrayStrategy.f24634a.k.f25177b, "SHA")) {
                    if (num.intValue() >= 2) {
                        this.f24603b[1] = 0;
                        onFailed(downloadTask, 2080, "file sha1 verify fail");
                        downloadTask.delete(true);
                        TinkerManager.getInstance().onDownloadFailure("retry download patch too many times.");
                        return;
                    }
                    this.f24603b[1] = Integer.valueOf(num.intValue() + 1);
                    downloadTask.delete(true);
                    e eVar = e.f24621b;
                    DownloadTask a2 = eVar.s.a(betaGrayStrategy.f24634a.k.f25178c, eVar.w.getAbsolutePath(), null, betaGrayStrategy.f24634a.k.f25178c);
                    rVar.f25136c = a2;
                    a2.setDownloadType(3);
                    rVar.f25136c.setNeededNotify(false);
                    rVar.f25136c.addListener(this);
                    BetaReceiver.addTask(rVar.f25136c);
                    rVar.f25136c.download();
                    return;
                }
                this.f24603b[1] = 0;
                if (!com.tencent.bugly.beta.global.a.a(saveFile, e.f24621b.J)) {
                    X.c("copy file failed", new Object[0]);
                    TinkerManager.getInstance().onDownloadFailure("copy file failure.");
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("copy ");
                sb2.append(saveFile.getAbsolutePath());
                sb2.append(" to ");
                sb2.append(e.f24621b.J.getAbsolutePath());
                sb2.append(" success!");
                X.a(sb2.toString(), new Object[0]);
                if (rVar.f25136c != null) {
                    X.a("delete temp file", new Object[0]);
                    rVar.f25136c.delete(true);
                }
                com.tencent.bugly.beta.global.a.b("UPLOAD_PATCH_RESULT", false);
                TinkerManager.getInstance().onDownloadSuccess(e.f24621b.J.getAbsolutePath(), e.f24621b.X);
                return;
            }
            com.tencent.bugly.beta.upgrade.d dVar = (com.tencent.bugly.beta.upgrade.d) this.f24603b[0];
            BetaGrayStrategy betaGrayStrategy2 = dVar.f24649b;
            if (betaGrayStrategy2 != null && betaGrayStrategy2.f24634a != null) {
                UpgradeStateListener upgradeStateListener = dVar.f24653f;
                if (upgradeStateListener != null) {
                    com.tencent.bugly.beta.utils.e.a(new com.tencent.bugly.beta.global.d(18, upgradeStateListener, 3, Boolean.valueOf(dVar.f24654g)));
                }
                X.c("apk download completed", new Object[0]);
                long currentTimeMillis = System.currentTimeMillis();
                long costTime = downloadTask.getCostTime();
                B b2 = betaGrayStrategy2.f24634a;
                C0921z c0921z = new C0921z("download", currentTimeMillis, (byte) 0, costTime, b2.f24932j, b2.r, b2.u, null);
                if (C0912p.f25111a.a(c0921z)) {
                    com.tencent.bugly.beta.upgrade.b.f24645a.a(c0921z, true);
                }
                if (e.f24621b.fa) {
                    File saveFile2 = downloadTask.getSaveFile();
                    Integer num2 = (Integer) this.f24603b[1];
                    if (com.tencent.bugly.beta.global.a.a(e.f24621b.v, saveFile2, betaGrayStrategy2.f24634a.k.f25177b)) {
                        this.f24603b[1] = 0;
                        C0912p c0912p = C0912p.f25111a;
                        long currentTimeMillis2 = System.currentTimeMillis();
                        B b3 = betaGrayStrategy2.f24634a;
                        c0912p.a(new C0921z("install", currentTimeMillis2, (byte) 0, 0L, b3.f24932j, b3.r, b3.u, null));
                        return;
                    }
                    if (num2.intValue() >= 2) {
                        this.f24603b[1] = 0;
                        onFailed(downloadTask, 2080, "file md5 verify fail");
                        downloadTask.delete(true);
                        return;
                    }
                    if (Build.VERSION.SDK_INT >= 24) {
                        this.f24603b[1] = 0;
                        onFailed(downloadTask, 2080, "安装失败，请检查您的App是否兼容7.0设备");
                        downloadTask.delete(true);
                        return;
                    }
                    this.f24603b[1] = Integer.valueOf(num2.intValue() + 1);
                    downloadTask.delete(true);
                    e eVar2 = e.f24621b;
                    DownloadTask a3 = eVar2.s.a(betaGrayStrategy2.f24634a.k.f25178c, eVar2.w.getAbsolutePath(), null, betaGrayStrategy2.f24634a.k.f25178c);
                    dVar.f24650c = a3;
                    a3.setDownloadType(1);
                    UpgradeDialog.instance.setUpgradeInfo(betaGrayStrategy2.f24634a, dVar.f24650c);
                    dVar.f24650c.addListener(this);
                    BetaReceiver.addTask(dVar.f24650c);
                    dVar.f24650c.download();
                }
            }
        } catch (Exception e2) {
            if (X.a(e2)) {
                return;
            }
            e2.printStackTrace();
        }
    }

    @Override // com.tencent.bugly.beta.download.DownloadListener
    public void onFailed(DownloadTask downloadTask, int i2, String str) {
        try {
            int i3 = this.f24602a;
            if (i3 == 1) {
                synchronized (this.f24603b[0]) {
                    f fVar = (f) this.f24603b[0];
                    fVar.a();
                    fVar.b();
                }
                return;
            }
            if (i3 == 2) {
                ((UpgradeDialog) this.f24603b[0]).updateBtn(downloadTask);
                return;
            }
            if (i3 == 3) {
                com.tencent.bugly.beta.upgrade.d dVar = (com.tencent.bugly.beta.upgrade.d) this.f24603b[0];
                if (downloadTask != null) {
                    C0912p c0912p = C0912p.f25111a;
                    long currentTimeMillis = System.currentTimeMillis();
                    long costTime = downloadTask.getCostTime();
                    B b2 = dVar.f24649b.f24634a;
                    c0912p.a(new C0921z("download", currentTimeMillis, (byte) 1, costTime, b2.f24932j, b2.r, b2.u, null));
                }
                X.b("upgrade failed：(%d)%s", Integer.valueOf(i2), str);
                Log.e(X.f25019b, "download fail, please try later");
                return;
            }
            if (i3 != 4) {
                return;
            }
            r rVar = (r) this.f24603b[0];
            if (downloadTask != null) {
                C0912p c0912p2 = C0912p.f25111a;
                long currentTimeMillis2 = System.currentTimeMillis();
                long costTime2 = downloadTask.getCostTime();
                B b3 = rVar.f25135b.f24634a;
                c0912p2.a(new C0921z("download", currentTimeMillis2, (byte) 1, costTime2, b3.f24932j, b3.r, b3.u, null));
            }
            X.b("hotfix download failed：(%d)%s", Integer.valueOf(i2), str);
            TinkerManager.getInstance().onDownloadFailure(str);
        } catch (Exception e2) {
            if (X.a(e2)) {
                return;
            }
            e2.printStackTrace();
        }
    }

    @Override // com.tencent.bugly.beta.download.DownloadListener
    public void onReceive(DownloadTask downloadTask) {
        if (this.f24602a != 2) {
            return;
        }
        ((UpgradeDialog) this.f24603b[0]).updateBtn(downloadTask);
    }
}
