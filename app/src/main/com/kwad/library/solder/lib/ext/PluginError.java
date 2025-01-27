package com.kwad.library.solder.lib.ext;

/* loaded from: classes3.dex */
public abstract class PluginError extends Exception {
    public static final int ERROR_BUILD_REMOTE_PLUGIN_INFO = 6001;
    public static final int ERROR_INIT = 5001;
    public static final int ERROR_INS_CAPACITY = 3005;
    public static final int ERROR_INS_INSTALL = 3004;
    public static final int ERROR_INS_INSTALL_PATH = 3006;
    public static final int ERROR_INS_NOT_FOUND = 3001;
    public static final int ERROR_INS_PACKAGE_INFO = 3002;
    public static final int ERROR_INS_SIGNATURE = 3003;
    public static final int ERROR_LOA_CLASS = 4007;
    public static final int ERROR_LOA_CLASSLOADER = 4005;
    public static final int ERROR_LOA_CREATE_PLUGIN = 4011;
    public static final int ERROR_LOA_NOT_FOUND = 4001;
    public static final int ERROR_LOA_NOT_LOADED = 4010;
    public static final int ERROR_LOA_OPT_DIR = 4002;
    public static final int ERROR_LOA_RESOURCES = 4006;
    public static final int ERROR_LOA_SO_DIR = 4003;
    public static final int ERROR_LOA_SO_INSTALL = 4004;
    public static final int ERROR_LOA_SO_MD5_CHECK = 4008;
    private static final int ERROR_OVER_RETRY = 1001;
    public static final int ERROR_UPD_CAPACITY = 2005;
    public static final int ERROR_UPD_EXTRACT = 2004;
    public static final int ERROR_UPD_FAIL = 2002;
    public static final int ERROR_UPD_FILE_NOT_FOUND = 2009;
    public static final int ERROR_UPD_NOT_WIFI_DOWNLOAD = 2007;
    public static final int ERROR_UPD_NO_DOWNLOADER = 2008;
    public static final int ERROR_UPD_NO_TEMP = 2003;
    public static final int ERROR_UPD_PLUGIN_CONNECTION = 2010;
    public static final int ERROR_UPD_PLUGIN_INFO = 2001;
    public static final int ERROR_UPD_REQUEST = 2006;
    private final int mCode;

    public static final class CancelError extends PluginError {
        public CancelError(int i10) {
            super("Operation was canceled.", i10);
        }
    }

    public static final class InstallError extends PluginError {
        public InstallError(String str, int i10) {
            super(str, i10);
        }

        public InstallError(Throwable th2, int i10) {
            super(th2, i10);
        }
    }

    public static final class LoadError extends PluginError {
        public LoadError(String str, int i10) {
            super(str, i10);
        }

        public LoadError(Throwable th2, int i10) {
            super(th2, i10);
            setStackTrace(th2.getStackTrace());
        }
    }

    public static final class NotWifiDownloadError extends PluginError {
        public NotWifiDownloadError(String str, int i10) {
            super(str, i10);
        }

        public NotWifiDownloadError(Throwable th2, int i10) {
            super(th2, i10);
            setStackTrace(th2.getStackTrace());
        }
    }

    public static final class RetryError extends PluginError {
        public RetryError() {
            super("Reach max retry.", 1001);
        }
    }

    public static final class UpdateError extends PluginError {
        public UpdateError(String str, int i10) {
            super(str, i10);
        }

        public UpdateError(Throwable th2, int i10) {
            super(th2, i10);
        }
    }

    public PluginError(String str, int i10) {
        super(str);
        this.mCode = i10;
    }

    public int getCode() {
        return this.mCode;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "PluginError{code=" + this.mCode + ", msg = " + super.toString() + '}';
    }

    public PluginError(Throwable th2, int i10) {
        super(th2);
        this.mCode = i10;
    }

    public PluginError(String str, Throwable th2, int i10) {
        super(str, th2);
        this.mCode = i10;
    }
}
