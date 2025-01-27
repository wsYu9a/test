package com.tencent.bugly.beta.download;

import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.beta.ui.NetNotifyDialog;
import com.tencent.bugly.beta.ui.UiManager;
import com.tencent.bugly.proguard.A;
import com.tencent.bugly.proguard.C0871p;
import com.tencent.bugly.proguard.X;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    final int f22086a;

    /* renamed from: b */
    final Object[] f22087b;

    public d(int i10, Object... objArr) {
        this.f22086a = i10;
        this.f22087b = objArr;
    }

    public synchronized void a(int i10, int i11) {
        try {
            int i12 = this.f22086a;
            if (i12 != 1) {
                if (i12 == 2) {
                    Object[] objArr = this.f22087b;
                    DownloadTask downloadTask = (DownloadTask) objArr[0];
                    NetNotifyDialog netNotifyDialog = (NetNotifyDialog) objArr[2];
                    if (i11 == 1) {
                        downloadTask.download();
                        X.a("continue download", new Object[0]);
                        this.f22087b[1] = Boolean.FALSE;
                        netNotifyDialog.close();
                    } else if (i10 == 1 || ((Boolean) objArr[1]).booleanValue()) {
                        e eVar = e.f22100b;
                        if (!eVar.U && !eVar.V) {
                            downloadTask.stop();
                            X.a("wifi network change to mobile network, stop download", new Object[0]);
                            this.f22087b[1] = Boolean.TRUE;
                            if (com.tencent.bugly.crashreport.common.info.b.c(e.f22100b.f22126v) != null) {
                                UiManager.show(netNotifyDialog, true);
                                this.f22087b[1] = Boolean.FALSE;
                            }
                        }
                    }
                }
            } else if (i11 == 1 || i11 == 3 || i11 == 4) {
                ArrayList arrayList = (ArrayList) C0871p.f22799a.b();
                if (arrayList != null && !arrayList.isEmpty()) {
                    com.tencent.bugly.beta.upgrade.b.f22146a.a(new A(arrayList), true);
                }
            }
        } catch (Exception e10) {
            if (!X.a(e10)) {
                e10.printStackTrace();
            }
        } finally {
        }
    }
}
