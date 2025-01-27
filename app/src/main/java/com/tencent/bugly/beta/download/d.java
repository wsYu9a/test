package com.tencent.bugly.beta.download;

import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.beta.ui.NetNotifyDialog;
import com.tencent.bugly.beta.ui.UiManager;
import com.tencent.bugly.proguard.A;
import com.tencent.bugly.proguard.C0912p;
import com.tencent.bugly.proguard.X;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    final int f24607a;

    /* renamed from: b */
    final Object[] f24608b;

    public d(int i2, Object... objArr) {
        this.f24607a = i2;
        this.f24608b = objArr;
    }

    public synchronized void a(int i2, int i3) {
        try {
            int i4 = this.f24607a;
            if (i4 != 1) {
                if (i4 == 2) {
                    Object[] objArr = this.f24608b;
                    DownloadTask downloadTask = (DownloadTask) objArr[0];
                    NetNotifyDialog netNotifyDialog = (NetNotifyDialog) objArr[2];
                    if (i3 == 1) {
                        downloadTask.download();
                        X.a("continue download", new Object[0]);
                        this.f24608b[1] = Boolean.FALSE;
                        netNotifyDialog.close();
                    } else if (i2 == 1 || ((Boolean) objArr[1]).booleanValue()) {
                        e eVar = e.f24621b;
                        if (!eVar.U && !eVar.V) {
                            downloadTask.stop();
                            X.a("wifi network change to mobile network, stop download", new Object[0]);
                            this.f24608b[1] = Boolean.TRUE;
                            if (com.tencent.bugly.crashreport.common.info.b.c(e.f24621b.v) != null) {
                                UiManager.show(netNotifyDialog, true);
                                this.f24608b[1] = Boolean.FALSE;
                            }
                        }
                    }
                }
            } else if (i3 == 1 || i3 == 3 || i3 == 4) {
                ArrayList arrayList = (ArrayList) C0912p.f25111a.b();
                if (arrayList != null && !arrayList.isEmpty()) {
                    com.tencent.bugly.beta.upgrade.b.f24645a.a(new A(arrayList), true);
                }
            }
        } catch (Exception e2) {
            if (!X.a(e2)) {
                e2.printStackTrace();
            }
        }
    }
}
