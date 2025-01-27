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
import com.tencent.bugly.proguard.C0871p;
import com.tencent.bugly.proguard.C0880z;
import com.tencent.bugly.proguard.X;

/* loaded from: classes4.dex */
public class b implements View.OnClickListener {

    /* renamed from: a */
    final int f22093a;

    /* renamed from: b */
    final Object[] f22094b;

    public b(int i10, Object... objArr) {
        this.f22093a = i10;
        this.f22094b = objArr;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            switch (this.f22093a) {
                case 1:
                    if (((ViewGroup) this.f22094b[1]).getChildCount() <= 0) {
                        ((Activity) this.f22094b[0]).finish();
                        X.c("BetaAct closed by empty view", new Object[0]);
                        return;
                    }
                    return;
                case 2:
                    ((BaseDialogFrag) this.f22094b[0]).close();
                    return;
                case 3:
                    Object obj = this.f22094b[1];
                    if (obj != null) {
                        ((DownloadTask) obj).download();
                    }
                    ((BaseDialogFrag) this.f22094b[0]).close();
                    return;
                case 4:
                    try {
                        UpgradeDialog upgradeDialog = (UpgradeDialog) this.f22094b[0];
                        DownloadTask downloadTask = upgradeDialog.strategyTask;
                        B b10 = upgradeDialog.strategyDetail;
                        BetaReceiver.addTask(downloadTask);
                        Runnable runnable = upgradeDialog.upgradeRunnable;
                        if (runnable != null) {
                            runnable.run();
                        }
                        if (downloadTask.getStatus() == 1 && a.a(e.f22100b.f22126v, downloadTask.getSaveFile(), b10.f22563k.f22889b)) {
                            C0871p.f22799a.a(new C0880z("install", System.currentTimeMillis(), (byte) 0, 0L, b10.f22562j, b10.f22570r, b10.f22573u, null));
                        } else {
                            downloadTask.download();
                        }
                        if (b10.f22564l != 2) {
                            upgradeDialog.close();
                        }
                        upgradeDialog.updateBtn(downloadTask);
                        return;
                    } catch (Exception e10) {
                        e = e10;
                        break;
                    }
                case 5:
                    UpgradeDialog upgradeDialog2 = (UpgradeDialog) this.f22094b[0];
                    DownloadTask downloadTask2 = upgradeDialog2.strategyTask;
                    BetaReceiver.netListeners.remove(downloadTask2.getDownloadUrl());
                    downloadTask2.stop();
                    upgradeDialog2.updateBtn(downloadTask2);
                    return;
                case 6:
                    UpgradeDialog upgradeDialog3 = (UpgradeDialog) this.f22094b[0];
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
                    ((HotfixDialog) this.f22094b[0]).close();
                    return;
                case 9:
                    Beta.installApk(Beta.getStrategyTask().getSaveFile());
                    Beta.saveInstallEvent(true);
                    return;
                default:
                    return;
            }
        } catch (Exception e11) {
            e = e11;
        }
        if (X.a(e)) {
            return;
        }
        e.printStackTrace();
    }
}
