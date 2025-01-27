package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mobads.sdk.internal.bw;

/* loaded from: classes.dex */
class by extends Handler {

    /* renamed from: a */
    final /* synthetic */ bw f5680a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    by(bw bwVar, Looper looper) {
        super(looper);
        this.f5680a = bwVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        bq bqVar;
        boolean z;
        Context context;
        bq bqVar2;
        boolean z2;
        boolean p;
        String string = message.getData().getString(bw.n);
        bu buVar = (bu) message.getData().getParcelable(bw.m);
        if (!bw.k.equals(string)) {
            bqVar = this.f5680a.z;
            bqVar.a(bw.f5668a, "mOnApkDownloadCompleted: download failed, code: " + string);
            this.f5680a.a(false);
            z = this.f5680a.A;
            if (z) {
                this.f5680a.A = false;
                this.f5680a.a(false, "Refused to download remote for version...");
                return;
            }
            return;
        }
        String e2 = buVar.e();
        context = this.f5680a.y;
        bp bpVar = new bp(e2, context, buVar);
        try {
            try {
                bw bwVar = this.f5680a;
                if (bwVar.u == bw.t) {
                    bpVar.a();
                    bpVar.a(bw.f());
                    if (bw.p != null) {
                        bw.p.f5609b = buVar.b();
                    }
                    this.f5680a.l();
                    z2 = this.f5680a.A;
                    if (z2) {
                        this.f5680a.A = false;
                        bw bwVar2 = this.f5680a;
                        p = bwVar2.p();
                        bwVar2.a(p, "load remote file just downloaded");
                    }
                } else {
                    bwVar.a(bpVar);
                    bpVar.a(bw.f());
                    this.f5680a.a(true);
                }
            } catch (bw.a e3) {
                String str = "download apk file failed: " + e3.toString();
                this.f5680a.a(false);
                bqVar2 = this.f5680a.z;
                bqVar2.a(bw.f5668a, str);
            }
        } finally {
            bpVar.delete();
        }
    }
}
