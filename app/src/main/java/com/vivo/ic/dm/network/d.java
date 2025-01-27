package com.vivo.ic.dm.network;

import android.content.Context;
import com.vivo.ic.VLog;
import com.vivo.ic.dm.Constants;
import com.vivo.ic.dm.DownloadInfo;
import com.vivo.ic.dm.l;
import java.net.Proxy;

/* loaded from: classes4.dex */
public abstract class d implements IHttpDownload {

    /* renamed from: a */
    private static final String f28528a = Constants.PRE_TAG + "HttpDownloadBase";

    /* renamed from: b */
    public static final String f28529b = "Dm-Method";

    /* renamed from: c */
    public static final String f28530c = "Dm-Body";

    /* renamed from: d */
    protected DownloadInfo f28531d;

    /* renamed from: e */
    protected b f28532e;

    protected Proxy a() {
        Proxy k = l.j().k();
        VLog.d(f28528a, "getNetProxy() Proxy:" + k);
        return k;
    }

    @Override // com.vivo.ic.dm.network.IHttpDownload
    public void attachDownloadInfo(Context context, DownloadInfo downloadInfo, String str, int i2) {
        close();
        this.f28531d = downloadInfo;
    }

    @Override // com.vivo.ic.dm.network.IHttpDownload
    public int getExpectResponseCode() {
        return -1;
    }
}
