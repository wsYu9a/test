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
import com.tencent.bugly.proguard.C0871p;
import com.tencent.bugly.proguard.C0880z;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.r;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
public class a implements DownloadListener {

    /* renamed from: a */
    final int f22081a;

    /* renamed from: b */
    final Object[] f22082b;

    public a(int i10, Object... objArr) {
        this.f22081a = i10;
        this.f22082b = objArr;
    }

    @Override // com.tencent.bugly.beta.download.DownloadListener
    public void onCompleted(DownloadTask downloadTask) {
        try {
            int i10 = this.f22081a;
            if (i10 == 1) {
                synchronized (this.f22082b[0]) {
                    try {
                        Map map = (Map) this.f22082b[1];
                        if (map.size() == 0) {
                            return;
                        }
                        Iterator it = map.values().iterator();
                        int i11 = 0;
                        while (it.hasNext()) {
                            if (((DownloadTask) it.next()).getStatus() == 1) {
                                i11++;
                            }
                        }
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(i11);
                        sb2.append(" has completed");
                        X.a(sb2.toString(), new Object[0]);
                        if (i11 < map.size()) {
                            return;
                        }
                        for (String str : map.keySet()) {
                            if (((DownloadTask) map.get(str)).getSaveFile() != null && ((DownloadTask) map.get(str)).getSaveFile().exists()) {
                                ResBean.f22088a.a(str, ((DownloadTask) map.get(str)).getSaveFile().getAbsolutePath());
                            }
                        }
                        com.tencent.bugly.beta.global.a.a("rb.bch", ResBean.f22088a);
                        f fVar = (f) this.f22082b[0];
                        fVar.a();
                        fVar.b();
                        return;
                    } finally {
                    }
                }
            }
            if (i10 == 2) {
                ((UpgradeDialog) this.f22082b[0]).updateBtn(downloadTask);
                return;
            }
            if (i10 != 3) {
                if (i10 != 4) {
                    return;
                }
                Object[] objArr = this.f22082b;
                r rVar = (r) objArr[0];
                Integer num = (Integer) objArr[1];
                BetaGrayStrategy betaGrayStrategy = rVar.f22839b;
                if (betaGrayStrategy == null || betaGrayStrategy.f22135a == null) {
                    return;
                }
                X.c("patch download success !!!", new Object[0]);
                File saveFile = downloadTask.getSaveFile();
                if (!com.tencent.bugly.beta.global.a.a(saveFile, betaGrayStrategy.f22135a.f22563k.f22889b, "SHA")) {
                    if (num.intValue() >= 2) {
                        this.f22082b[1] = 0;
                        onFailed(downloadTask, 2080, "file sha1 verify fail");
                        downloadTask.delete(true);
                        TinkerManager.getInstance().onDownloadFailure("retry download patch too many times.");
                        return;
                    }
                    this.f22082b[1] = Integer.valueOf(num.intValue() + 1);
                    downloadTask.delete(true);
                    e eVar = e.f22100b;
                    DownloadTask a10 = eVar.f22123s.a(betaGrayStrategy.f22135a.f22563k.f22890c, eVar.f22127w.getAbsolutePath(), null, betaGrayStrategy.f22135a.f22563k.f22890c);
                    rVar.f22840c = a10;
                    a10.setDownloadType(3);
                    rVar.f22840c.setNeededNotify(false);
                    rVar.f22840c.addListener(this);
                    BetaReceiver.addTask(rVar.f22840c);
                    rVar.f22840c.download();
                    return;
                }
                this.f22082b[1] = 0;
                if (!com.tencent.bugly.beta.global.a.a(saveFile, e.f22100b.J)) {
                    X.c("copy file failed", new Object[0]);
                    TinkerManager.getInstance().onDownloadFailure("copy file failure.");
                    return;
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("copy ");
                sb3.append(saveFile.getAbsolutePath());
                sb3.append(" to ");
                sb3.append(e.f22100b.J.getAbsolutePath());
                sb3.append(" success!");
                X.a(sb3.toString(), new Object[0]);
                if (rVar.f22840c != null) {
                    X.a("delete temp file", new Object[0]);
                    rVar.f22840c.delete(true);
                }
                com.tencent.bugly.beta.global.a.b("UPLOAD_PATCH_RESULT", false);
                TinkerManager.getInstance().onDownloadSuccess(e.f22100b.J.getAbsolutePath(), e.f22100b.X);
                return;
            }
            com.tencent.bugly.beta.upgrade.d dVar = (com.tencent.bugly.beta.upgrade.d) this.f22082b[0];
            BetaGrayStrategy betaGrayStrategy2 = dVar.f22150b;
            if (betaGrayStrategy2 != null && betaGrayStrategy2.f22135a != null) {
                UpgradeStateListener upgradeStateListener = dVar.f22154f;
                if (upgradeStateListener != null) {
                    com.tencent.bugly.beta.utils.e.a(new com.tencent.bugly.beta.global.d(18, upgradeStateListener, 3, Boolean.valueOf(dVar.f22155g)));
                }
                X.c("apk download completed", new Object[0]);
                long currentTimeMillis = System.currentTimeMillis();
                long costTime = downloadTask.getCostTime();
                B b10 = betaGrayStrategy2.f22135a;
                C0880z c0880z = new C0880z("download", currentTimeMillis, (byte) 0, costTime, b10.f22562j, b10.f22570r, b10.f22573u, null);
                if (C0871p.f22799a.a(c0880z)) {
                    com.tencent.bugly.beta.upgrade.b.f22146a.a(c0880z, true);
                }
                if (e.f22100b.f22110fa) {
                    File saveFile2 = downloadTask.getSaveFile();
                    Integer num2 = (Integer) this.f22082b[1];
                    if (com.tencent.bugly.beta.global.a.a(e.f22100b.f22126v, saveFile2, betaGrayStrategy2.f22135a.f22563k.f22889b)) {
                        this.f22082b[1] = 0;
                        C0871p c0871p = C0871p.f22799a;
                        long currentTimeMillis2 = System.currentTimeMillis();
                        B b11 = betaGrayStrategy2.f22135a;
                        c0871p.a(new C0880z("install", currentTimeMillis2, (byte) 0, 0L, b11.f22562j, b11.f22570r, b11.f22573u, null));
                        return;
                    }
                    if (num2.intValue() >= 2) {
                        this.f22082b[1] = 0;
                        onFailed(downloadTask, 2080, "file md5 verify fail");
                        downloadTask.delete(true);
                        return;
                    }
                    if (Build.VERSION.SDK_INT >= 24) {
                        this.f22082b[1] = 0;
                        onFailed(downloadTask, 2080, "安装失败，请检查您的App是否兼容7.0设备");
                        downloadTask.delete(true);
                        return;
                    }
                    this.f22082b[1] = Integer.valueOf(num2.intValue() + 1);
                    downloadTask.delete(true);
                    e eVar2 = e.f22100b;
                    DownloadTask a11 = eVar2.f22123s.a(betaGrayStrategy2.f22135a.f22563k.f22890c, eVar2.f22127w.getAbsolutePath(), null, betaGrayStrategy2.f22135a.f22563k.f22890c);
                    dVar.f22151c = a11;
                    a11.setDownloadType(1);
                    UpgradeDialog.instance.setUpgradeInfo(betaGrayStrategy2.f22135a, dVar.f22151c);
                    dVar.f22151c.addListener(this);
                    BetaReceiver.addTask(dVar.f22151c);
                    dVar.f22151c.download();
                }
            }
        } catch (Exception e10) {
            if (X.a(e10)) {
                return;
            }
            e10.printStackTrace();
        }
    }

    @Override // com.tencent.bugly.beta.download.DownloadListener
    public void onFailed(DownloadTask downloadTask, int i10, String str) {
        try {
            int i11 = this.f22081a;
            if (i11 == 1) {
                synchronized (this.f22082b[0]) {
                    f fVar = (f) this.f22082b[0];
                    fVar.a();
                    fVar.b();
                }
                return;
            }
            if (i11 == 2) {
                ((UpgradeDialog) this.f22082b[0]).updateBtn(downloadTask);
                return;
            }
            if (i11 == 3) {
                com.tencent.bugly.beta.upgrade.d dVar = (com.tencent.bugly.beta.upgrade.d) this.f22082b[0];
                if (downloadTask != null) {
                    C0871p c0871p = C0871p.f22799a;
                    long currentTimeMillis = System.currentTimeMillis();
                    long costTime = downloadTask.getCostTime();
                    B b10 = dVar.f22150b.f22135a;
                    c0871p.a(new C0880z("download", currentTimeMillis, (byte) 1, costTime, b10.f22562j, b10.f22570r, b10.f22573u, null));
                }
                X.b("upgrade failed：(%d)%s", Integer.valueOf(i10), str);
                Log.e(X.f22679b, "download fail, please try later");
                return;
            }
            if (i11 != 4) {
                return;
            }
            r rVar = (r) this.f22082b[0];
            if (downloadTask != null) {
                C0871p c0871p2 = C0871p.f22799a;
                long currentTimeMillis2 = System.currentTimeMillis();
                long costTime2 = downloadTask.getCostTime();
                B b11 = rVar.f22839b.f22135a;
                c0871p2.a(new C0880z("download", currentTimeMillis2, (byte) 1, costTime2, b11.f22562j, b11.f22570r, b11.f22573u, null));
            }
            X.b("hotfix download failed：(%d)%s", Integer.valueOf(i10), str);
            TinkerManager.getInstance().onDownloadFailure(str);
        } catch (Exception e10) {
            if (X.a(e10)) {
                return;
            }
            e10.printStackTrace();
        }
    }

    @Override // com.tencent.bugly.beta.download.DownloadListener
    public void onReceive(DownloadTask downloadTask) {
        if (this.f22081a != 2) {
            return;
        }
        ((UpgradeDialog) this.f22082b[0]).updateBtn(downloadTask);
    }
}
