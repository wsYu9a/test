package com.vivo.ic.dm;

import android.os.Build;
import com.vivo.ic.BaseLib;
import com.vivo.ic.dm.datareport.DataReportListener;
import com.vivo.ic.dm.impl.DownloadIntercepter;
import com.vivo.ic.dm.impl.DownloadNotiDealer;
import java.net.Proxy;

/* loaded from: classes4.dex */
public class l {

    /* renamed from: a */
    public static final l f28491a = new l();

    /* renamed from: b */
    private DownloadConfig f28492b;

    private l() {
    }

    public static l j() {
        return f28491a;
    }

    void a(Proxy proxy) {
        DownloadConfig downloadConfig = this.f28492b;
        if (downloadConfig == null) {
            return;
        }
        synchronized (downloadConfig) {
            this.f28492b.mNetProxy = proxy;
        }
    }

    public int b() {
        DownloadConfig downloadConfig = this.f28492b;
        if (downloadConfig != null) {
            return downloadConfig.mBufferSize;
        }
        return 8192;
    }

    int c() {
        DownloadConfig downloadConfig = this.f28492b;
        if (downloadConfig != null) {
            return downloadConfig.mConcurrentNum;
        }
        return 2;
    }

    public int d() {
        DownloadConfig downloadConfig = this.f28492b;
        if (downloadConfig != null) {
            return downloadConfig.mConnectTimeoutMs;
        }
        return 30000;
    }

    public int e() {
        DownloadConfig downloadConfig = this.f28492b;
        if (downloadConfig != null) {
            return downloadConfig.mCoreSize;
        }
        return 5;
    }

    public DataReportListener f() {
        DownloadConfig downloadConfig = this.f28492b;
        if (downloadConfig != null) {
            return downloadConfig.mDataReportListener;
        }
        return null;
    }

    String g() {
        DownloadConfig downloadConfig = this.f28492b;
        return downloadConfig != null ? downloadConfig.mDownloadDir : Constants.DEFAULT_DL_PARENT;
    }

    DownloadIntercepter h() {
        DownloadConfig downloadConfig = this.f28492b;
        if (downloadConfig != null) {
            return downloadConfig.mDownloadIntercepter;
        }
        return null;
    }

    public int i() {
        DownloadConfig downloadConfig = this.f28492b;
        if (downloadConfig != null) {
            return downloadConfig.mDownloadProgressGapMs;
        }
        return 500;
    }

    public Proxy k() {
        DownloadConfig downloadConfig = this.f28492b;
        if (downloadConfig != null) {
            return downloadConfig.mNetProxy;
        }
        return null;
    }

    DownloadNotiDealer l() {
        DownloadConfig downloadConfig = this.f28492b;
        return downloadConfig != null ? downloadConfig.mDownloadNotiDealer : new i();
    }

    public DownloadNotifier m() {
        DownloadConfig downloadConfig = this.f28492b;
        return downloadConfig != null ? downloadConfig.mDownloadNotification : new e(BaseLib.getContext());
    }

    public int n() {
        DownloadConfig downloadConfig = this.f28492b;
        return downloadConfig != null ? downloadConfig.mReadTimeoutMs : Constants.DEFAULT_READ_TIMEOUT;
    }

    public boolean o() {
        DownloadConfig downloadConfig = this.f28492b;
        return downloadConfig == null || downloadConfig.mDownloadInMobile;
    }

    boolean p() {
        DownloadConfig downloadConfig = this.f28492b;
        return downloadConfig != null && downloadConfig.mAutoStartDownload;
    }

    public boolean q() {
        DownloadConfig downloadConfig = this.f28492b;
        if (downloadConfig != null) {
            return downloadConfig.mIsDetect;
        }
        return true;
    }

    public boolean r() {
        DownloadConfig downloadConfig = this.f28492b;
        return downloadConfig != null && downloadConfig.mIsKeepProcess;
    }

    public boolean s() {
        return Build.VERSION.SDK_INT >= 26;
    }

    boolean t() {
        DownloadConfig downloadConfig = this.f28492b;
        return downloadConfig != null && downloadConfig.mShutDownInMobileNotification;
    }

    void a(DownloadConfig downloadConfig) {
        this.f28492b = downloadConfig;
    }

    public boolean a() {
        DownloadConfig downloadConfig = this.f28492b;
        return downloadConfig != null && downloadConfig.mEnableOKhttp;
    }
}
