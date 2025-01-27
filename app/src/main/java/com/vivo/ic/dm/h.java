package com.vivo.ic.dm;

import android.content.Context;
import com.vivo.ic.VLog;
import com.vivo.ic.dm.impl.DownloadIntercepter;
import com.vivo.ic.dm.impl.DownloadNotification;

/* loaded from: classes4.dex */
class h implements DownloadIntercepter {

    /* renamed from: a */
    private static final String f28476a = Constants.PRE_TAG + "DownloadIntercepterWrapper";

    /* renamed from: b */
    private DownloadIntercepter f28477b;

    /* renamed from: c */
    private g f28478c;

    public h(Context context, DownloadIntercepter downloadIntercepter, DownloadNotification downloadNotification) {
        this.f28477b = downloadIntercepter;
        this.f28478c = new g(context, downloadNotification);
    }

    public void a(DownloadNotification downloadNotification) {
        this.f28478c.a(downloadNotification);
    }

    @Override // com.vivo.ic.dm.impl.DownloadIntercepter
    public boolean handleMediaMounted() {
        if (this.f28477b != null) {
            VLog.i(f28476a, "handleMediaMounted user intercept");
            this.f28477b.handleMediaMounted();
            return true;
        }
        if (this.f28478c == null) {
            return true;
        }
        VLog.i(f28476a, "handleNetChange default intercept");
        return this.f28478c.handleMediaMounted();
    }

    @Override // com.vivo.ic.dm.impl.DownloadIntercepter
    public boolean handleNetChange() {
        if (this.f28477b != null) {
            VLog.i(f28476a, "handleNetChange user intercept");
            this.f28477b.handleNetChange();
            return true;
        }
        if (this.f28478c == null) {
            return true;
        }
        VLog.i(f28476a, "handleNetChange default intercept");
        return this.f28478c.handleNetChange();
    }
}
