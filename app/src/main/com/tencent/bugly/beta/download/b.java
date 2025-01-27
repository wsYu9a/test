package com.tencent.bugly.beta.download;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.beta.ui.BetaNotifyManager;
import com.tencent.bugly.beta.ui.UiManager;
import com.tencent.bugly.beta.ui.UpgradeDialog;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import java.io.File;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Intent f22083a;

    /* renamed from: b */
    final /* synthetic */ Context f22084b;

    /* renamed from: c */
    final /* synthetic */ BetaReceiver f22085c;

    public b(BetaReceiver betaReceiver, Intent intent, Context context) {
        this.f22085c = betaReceiver;
        this.f22083a = intent;
        this.f22084b = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        UpgradeDialog upgradeDialog;
        try {
            if (this.f22083a.getAction().equals(BetaReceiver.CONNECTIVITY_CHANGE)) {
                int i10 = BetaReceiver.netStatus;
                BetaReceiver.netStatus = com.tencent.bugly.beta.global.a.a(this.f22084b);
                Iterator<d> it = BetaReceiver.netListeners.values().iterator();
                while (it.hasNext()) {
                    it.next().a(i10, BetaReceiver.netStatus);
                }
                return;
            }
            if (this.f22083a.getAction().equals(BetaNotifyManager.instance.intentFilter)) {
                int intExtra = this.f22083a.getIntExtra("request", -1);
                if (intExtra != 1) {
                    if (intExtra != 2) {
                        Log.v("", "do nothing");
                        return;
                    } else {
                        UiManager.show(BetaNotifyManager.instance.fragment, true, true, 0L);
                        return;
                    }
                }
                DownloadTask downloadTask = BetaNotifyManager.instance.task;
                if (downloadTask == null) {
                    return;
                }
                int status = downloadTask.getStatus();
                if (status != 0) {
                    if (status == 1) {
                        com.tencent.bugly.beta.global.a.a(e.f22100b.f22126v, downloadTask.getSaveFile(), downloadTask.getMD5());
                    } else if (status == 2) {
                        BetaReceiver.netListeners.remove(downloadTask.getDownloadUrl());
                        downloadTask.stop();
                    } else if (status != 3 && status != 4 && status != 5) {
                    }
                    if (com.tencent.bugly.beta.upgrade.d.f22149a.f22153e == null || (upgradeDialog = UpgradeDialog.instance) == null) {
                    }
                    upgradeDialog.updateBtn(downloadTask);
                    return;
                }
                File saveFile = downloadTask.getSaveFile();
                if (saveFile != null && saveFile.exists() && saveFile.getName().endsWith(".apk")) {
                    String a10 = ca.a(saveFile, "MD5");
                    if (TextUtils.isEmpty(downloadTask.getMD5()) || !TextUtils.equals(downloadTask.getMD5().toUpperCase(), a10)) {
                        BetaReceiver.addTask(downloadTask);
                        downloadTask.download();
                    } else {
                        com.tencent.bugly.beta.global.a.a(e.f22100b.f22126v, downloadTask.getSaveFile(), downloadTask.getMD5());
                    }
                } else {
                    BetaReceiver.addTask(downloadTask);
                    downloadTask.download();
                }
                if (com.tencent.bugly.beta.upgrade.d.f22149a.f22153e == null) {
                }
            }
        } catch (Exception e10) {
            if (X.a(e10)) {
                return;
            }
            e10.printStackTrace();
        }
    }
}
