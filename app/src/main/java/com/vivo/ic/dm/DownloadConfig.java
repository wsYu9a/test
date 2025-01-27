package com.vivo.ic.dm;

import android.text.TextUtils;
import com.vivo.ic.BaseLib;
import com.vivo.ic.dm.datareport.DataReportListener;
import com.vivo.ic.dm.impl.DownloadIntercepter;
import com.vivo.ic.dm.impl.DownloadNotiDealer;
import java.net.Proxy;

/* loaded from: classes4.dex */
public class DownloadConfig {
    boolean mAutoStartDownload;
    int mBufferSize;
    int mConcurrentNum;
    int mConnectTimeoutMs;
    int mCoreSize;
    DataReportListener mDataReportListener;
    String mDownloadDir;
    boolean mDownloadInMobile;
    DownloadIntercepter mDownloadIntercepter;
    DownloadNotiDealer mDownloadNotiDealer;
    DownloadNotifier mDownloadNotification;
    int mDownloadProgressGapMs;
    boolean mEnableOKhttp;
    boolean mIsDetect;
    boolean mIsKeepProcess;
    Proxy mNetProxy;
    int mReadTimeoutMs;
    boolean mShutDownInMobileNotification;

    public static class Builder {
        private int mConcurrentNum;
        private DataReportListener mDataReportListener;
        private String mDownloadDir;
        private DownloadIntercepter mDownloadIntercepter;
        private DownloadNotiDealer mDownloadNotiDealer;
        private DownloadNotifier mDownloadNotification;
        private boolean mDownloadInMobile = true;
        private boolean mAutoStartDownload = false;
        private int mDownloadProgressGapMs = 500;
        private boolean mShutDownInMobileNotification = false;
        private Proxy mNetProxy = null;
        private int mConnectTimeoutMs = 30000;
        private int mReadTimeoutMs = Constants.DEFAULT_READ_TIMEOUT;
        private int mCoreSize = 5;
        private int mBufferSize = 8192;
        boolean mIsKeepProcess = true;
        boolean mEnableOKhttp = false;
        private boolean mIsDetect = true;

        public Builder(String str) {
            this.mDownloadDir = str;
        }

        public DownloadConfig build() {
            if (this.mConcurrentNum <= 0) {
                this.mConcurrentNum = 2;
            }
            if (TextUtils.isEmpty(this.mDownloadDir)) {
                this.mDownloadDir = Constants.DEFAULT_DL_PARENT;
            }
            if (this.mDownloadNotiDealer == null) {
                this.mDownloadNotiDealer = new i();
            }
            if (this.mDownloadNotification == null) {
                this.mDownloadNotification = new e(BaseLib.getContext());
            }
            this.mDownloadIntercepter = new h(BaseLib.getContext(), this.mDownloadIntercepter, this.mDownloadNotification);
            return new DownloadConfig(this);
        }

        public Builder setAllowDownloadInMobile(boolean z) {
            this.mDownloadInMobile = z;
            return this;
        }

        public Builder setAutoStartDownload(boolean z) {
            this.mAutoStartDownload = z;
            return this;
        }

        public Builder setBufferSize(int i2) {
            this.mBufferSize = i2;
            return this;
        }

        public Builder setConcurrentNum(int i2) {
            if (i2 > 0) {
                this.mConcurrentNum = i2;
            }
            if (this.mConcurrentNum > 5) {
                this.mConcurrentNum = 5;
            }
            return this;
        }

        public Builder setConnectTimeoutMs(int i2) {
            if (i2 > 0) {
                this.mConnectTimeoutMs = i2;
            }
            return this;
        }

        public Builder setCoreSize(int i2) {
            this.mCoreSize = i2;
            return this;
        }

        public Builder setDataReportListener(DataReportListener dataReportListener) {
            this.mDataReportListener = dataReportListener;
            return this;
        }

        public Builder setDetect(boolean z) {
            this.mIsDetect = z;
            return this;
        }

        public Builder setDownloadIntercepter(DownloadIntercepter downloadIntercepter) {
            this.mDownloadIntercepter = downloadIntercepter;
            return this;
        }

        public Builder setDownloadNotiDealer(DownloadNotiDealer downloadNotiDealer) {
            this.mDownloadNotiDealer = downloadNotiDealer;
            return this;
        }

        public Builder setDownloadNotification(DownloadNotifier downloadNotifier) {
            this.mDownloadNotification = downloadNotifier;
            return this;
        }

        public Builder setDownloadProgressGapMs(int i2) {
            this.mDownloadProgressGapMs = i2;
            return this;
        }

        public Builder setEnableOKHttp(boolean z) {
            this.mEnableOKhttp = z;
            return this;
        }

        public Builder setIsKeepProcess(boolean z) {
            this.mIsKeepProcess = z;
            return this;
        }

        public Builder setNetProxy(Proxy proxy) {
            this.mNetProxy = proxy;
            return this;
        }

        public Builder setReadTimeoutMs(int i2) {
            if (i2 > 0) {
                this.mReadTimeoutMs = i2;
            }
            return this;
        }

        public Builder setShutDownInMobileNotification(boolean z) {
            this.mShutDownInMobileNotification = z;
            return this;
        }

        public void setmDownloadIntercepter(DownloadIntercepter downloadIntercepter) {
            this.mDownloadIntercepter = downloadIntercepter;
        }
    }

    /* synthetic */ DownloadConfig(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public String toString() {
        return "DownloadConfig==>mConcurrentNum:" + this.mConcurrentNum + " mDownloadDir:" + this.mDownloadDir + " mDownloadInMobile:" + this.mDownloadInMobile + " mAutoStartDownload:" + this.mAutoStartDownload + " mDownloadProgressGapMs:" + this.mDownloadProgressGapMs;
    }

    private DownloadConfig(Builder builder) {
        this.mConcurrentNum = builder.mConcurrentNum;
        this.mDownloadDir = builder.mDownloadDir;
        this.mDownloadInMobile = builder.mDownloadInMobile;
        this.mDownloadNotiDealer = builder.mDownloadNotiDealer;
        this.mDownloadNotification = builder.mDownloadNotification;
        this.mDownloadIntercepter = builder.mDownloadIntercepter;
        this.mDataReportListener = builder.mDataReportListener;
        this.mAutoStartDownload = builder.mAutoStartDownload;
        this.mShutDownInMobileNotification = builder.mShutDownInMobileNotification;
        this.mConnectTimeoutMs = builder.mConnectTimeoutMs;
        this.mReadTimeoutMs = builder.mReadTimeoutMs;
        this.mCoreSize = builder.mCoreSize;
        this.mBufferSize = builder.mBufferSize;
        this.mNetProxy = builder.mNetProxy;
        this.mIsKeepProcess = builder.mIsKeepProcess;
        this.mEnableOKhttp = builder.mEnableOKhttp;
        this.mIsDetect = builder.mIsDetect;
        this.mDownloadProgressGapMs = builder.mDownloadProgressGapMs;
    }
}
