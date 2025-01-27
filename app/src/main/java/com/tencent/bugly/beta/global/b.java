package com.tencent.bugly.beta.global;

import android.app.Activity;
import android.os.Process;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.download.BetaReceiver;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.ui.BaseDialogFrag;
import com.tencent.bugly.beta.ui.HotfixDialog;
import com.tencent.bugly.beta.ui.UpgradeDialog;
import com.tencent.bugly.proguard.B;
import com.tencent.bugly.proguard.C0912p;
import com.tencent.bugly.proguard.C0921z;
import com.tencent.bugly.proguard.X;

/* loaded from: classes4.dex */
public class b implements View.OnClickListener {

    /* renamed from: a */
    final int f24614a;

    /* renamed from: b */
    final Object[] f24615b;

    public b(int i2, Object... objArr) {
        this.f24614a = i2;
        this.f24615b = objArr;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            switch (this.f24614a) {
                case 1:
                    if (((ViewGroup) this.f24615b[1]).getChildCount() <= 0) {
                        ((Activity) this.f24615b[0]).finish();
                        X.c("BetaAct closed by empty view", new Object[0]);
                        return;
                    }
                    return;
                case 2:
                    ((BaseDialogFrag) this.f24615b[0]).close();
                    return;
                case 3:
                    Object[] objArr = this.f24615b;
                    if (objArr[1] != null) {
                        ((DownloadTask) objArr[1]).download();
                    }
                    ((BaseDialogFrag) this.f24615b[0]).close();
                    return;
                case 4:
                    try {
                        UpgradeDialog upgradeDialog = (UpgradeDialog) this.f24615b[0];
                        DownloadTask downloadTask = upgradeDialog.strategyTask;
                        B b2 = upgradeDialog.strategyDetail;
                        BetaReceiver.addTask(downloadTask);
                        Runnable runnable = upgradeDialog.upgradeRunnable;
                        if (runnable != null) {
                            runnable.run();
                        }
                        if (downloadTask.getStatus() == 1 && a.a(e.f24621b.v, downloadTask.getSaveFile(), b2.k.f25177b)) {
                            C0912p.f25111a.a(new C0921z("install", System.currentTimeMillis(), (byte) 0, 0L, b2.f24932j, b2.r, b2.u, null));
                        } else {
                            downloadTask.download();
                        }
                        if (b2.l != 2) {
                            upgradeDialog.close();
                        }
                        upgradeDialog.updateBtn(downloadTask);
                        return;
                    } catch (Exception e2) {
                        e = e2;
                        break;
                    }
                case 5:
                    UpgradeDialog upgradeDialog2 = (UpgradeDialog) this.f24615b[0];
                    DownloadTask downloadTask2 = upgradeDialog2.strategyTask;
                    BetaReceiver.netListeners.remove(downloadTask2.getDownloadUrl());
                    downloadTask2.stop();
                    upgradeDialog2.updateBtn(downloadTask2);
                    return;
                case 6:
                    UpgradeDialog upgradeDialog3 = (UpgradeDialog) this.f24615b[0];
                    Runnable runnable2 = upgradeDialog3.cancelRunnable;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                    upgradeDialog3.close();
                    return;
                case 7:
                    Process.killProcess(Process.myPid());
                    System.exit(0);
                    return;
                case 8:
                    ((HotfixDialog) this.f24615b[0]).close();
                    return;
                case 9:
                    Beta.installApk(Beta.getStrategyTask().getSaveFile());
                    Beta.saveInstallEvent(true);
                    return;
                default:
                    return;
            }
        } catch (Exception e3) {
            e = e3;
        }
        if (X.a(e)) {
            return;
        }
        e.printStackTrace();
    }
}
