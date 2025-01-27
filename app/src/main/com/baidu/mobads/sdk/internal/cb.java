package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mobads.sdk.internal.bz;

/* loaded from: classes2.dex */
class cb extends Handler {

    /* renamed from: a */
    final /* synthetic */ bz f7014a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cb(bz bzVar, Looper looper) {
        super(looper);
        this.f7014a = bzVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        bt btVar;
        boolean z10;
        Context context;
        bt btVar2;
        boolean z11;
        boolean p10;
        String string = message.getData().getString(bz.f6996n);
        bx bxVar = (bx) message.getData().getParcelable(bz.f6995m);
        if (!bz.f6993k.equals(string)) {
            btVar = this.f7014a.f7008z;
            btVar.a(bz.f6983a, "mOnApkDownloadCompleted: download failed, code: " + string);
            this.f7014a.a(false);
            z10 = this.f7014a.A;
            if (z10) {
                this.f7014a.A = false;
                this.f7014a.a(false, "Refused to download remote for version...");
                return;
            }
            return;
        }
        String e10 = bxVar.e();
        context = this.f7014a.f7007y;
        bs bsVar = new bs(e10, context, bxVar);
        try {
            try {
                bz bzVar = this.f7014a;
                if (bzVar.f7004u == bz.f7002t) {
                    bsVar.a();
                    bsVar.a(bz.f());
                    if (bz.f6998p != null) {
                        bz.f6998p.f6920b = bxVar.b();
                    }
                    this.f7014a.l();
                    z11 = this.f7014a.A;
                    if (z11) {
                        this.f7014a.A = false;
                        bz bzVar2 = this.f7014a;
                        p10 = bzVar2.p();
                        bzVar2.a(p10, "load remote file just downloaded");
                    }
                } else {
                    bzVar.a(bsVar);
                    bsVar.a(bz.f());
                    this.f7014a.a(true);
                }
            } catch (bz.a e11) {
                String str = "download apk file failed: " + e11.toString();
                this.f7014a.a(false);
                btVar2 = this.f7014a.f7008z;
                btVar2.a(bz.f6983a, str);
            }
            bsVar.delete();
        } catch (Throwable th2) {
            bsVar.delete();
            throw th2;
        }
    }
}
