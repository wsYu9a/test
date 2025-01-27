package com.vivo.ic.minidownload;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.vivo.ic.VLog;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.nio.channels.FileChannel;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class MiniDownloadRunable implements Runnable {
    private static final int BUFFER_SIZE = 8192;
    private static final int DEFAULT_TIMEOUT = 20000;
    public static final int ERROR_COPY_EXCEPTION = 6;
    public static final int ERROR_IOEXCEPTION = 4;
    public static final int ERROR_PARAM = 1;
    public static final int ERROR_REDIRECT_TOOMUCH = 5;
    public static final int ERROR_TEMP = 7;
    public static final int ERROR_UNHANDLED_STATUS = 3;
    public static final int ERROR_UNKNOW = 0;
    public static final int ERROR_URLEXCEPTION = 2;
    private static final int HTTP_MOVED_PERM = 301;
    private static final int HTTP_MOVED_TEMP = 302;
    private static final int HTTP_OK = 200;
    private static final int HTTP_PARTIAL = 206;
    private static final int HTTP_SEE_OTHER = 303;
    private static final int HTTP_TEMP_REDIRECT = 307;
    private static final int MAX_REDIRECTS = 3;
    private static final String TAG = "MiniDownloadThread";
    private static final String TEMP_DIR = "downloadopt";
    public static HashMap<String, Integer> sThreadMaps = new HashMap<>();
    private final DownloadCallback mCallback;
    private final Context mContext;
    private final boolean mNeedContinue;
    private final File mTargetFile;
    private final File mTempFile;
    private int mThreadPriority;
    private final String mUrl;

    public interface DownloadCallback {
        void onDownloadError(int i2, String str, Exception exc);

        void onDownloadSuccess(File file);
    }

    public MiniDownloadRunable(Context context, String str, String str2) {
        this(context, str, str2, null, false);
    }

    private void closeSilently(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static void copyFile(File file, File file2) throws IOException {
        FileChannel fileChannel;
        FileChannel fileChannel2 = null;
        try {
            if (!file2.exists()) {
                if (file2.getParentFile() != null) {
                    file2.getParentFile().mkdirs();
                }
                file2.createNewFile();
            }
            FileChannel channel = new FileInputStream(file).getChannel();
            try {
                fileChannel2 = new FileOutputStream(file2).getChannel();
                channel.transferTo(0L, channel.size(), fileChannel2);
                channel.close();
                if (fileChannel2 != null) {
                    fileChannel2.close();
                }
            } catch (Throwable th) {
                FileChannel fileChannel3 = fileChannel2;
                fileChannel2 = channel;
                th = th;
                fileChannel = fileChannel3;
                if (fileChannel2 != null) {
                    fileChannel2.close();
                }
                if (fileChannel != null) {
                    fileChannel.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileChannel = null;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:202)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:61)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:281)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:64)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    private void executeDownload() throws com.vivo.ic.minidownload.MiniDownloadRunable.DownloadException {
        /*
            Method dump skipped, instructions count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.ic.minidownload.MiniDownloadRunable.executeDownload():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.vivo.ic.minidownload.MiniDownloadRunable] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.Closeable, java.io.InputStream] */
    private void transferData(HttpURLConnection httpURLConnection, boolean z) throws DownloadException {
        Throwable th;
        VLog.i(TAG, "start transferData " + z);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                httpURLConnection = httpURLConnection.getInputStream();
            } catch (IOException e2) {
                e = e2;
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = 0;
            }
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(this.mTempFile, z);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        try {
                            int read = httpURLConnection.read(bArr);
                            if (read == -1) {
                                try {
                                    copyFile(this.mTempFile, this.mTargetFile);
                                    closeSilently(httpURLConnection);
                                    closeSilently(fileOutputStream2);
                                    return;
                                } catch (IOException e3) {
                                    throw new DownloadException(6, "failed to copy " + this.mTempFile + " to " + this.mTargetFile, e3);
                                }
                            }
                            fileOutputStream2.write(bArr, 0, read);
                        } catch (IOException e4) {
                            throw new DownloadException(4, "http data error IOException3 ", e4);
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                    if (httpURLConnection != 0) {
                        closeSilently(httpURLConnection);
                    }
                    if (fileOutputStream != null) {
                        closeSilently(fileOutputStream);
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                throw new DownloadException(4, "http data error IOException2 ", e);
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (sThreadMaps.get(this.mUrl) != null) {
            return;
        }
        sThreadMaps.put(this.mUrl, Integer.valueOf(Process.myTid()));
        int i2 = this.mThreadPriority;
        if (i2 > -1) {
            Process.setThreadPriority(i2);
        } else {
            Process.setThreadPriority(10);
        }
        try {
        } catch (Exception e2) {
            if (this.mCallback == null) {
                return;
            }
            if (!this.mNeedContinue) {
                this.mTempFile.delete();
            }
            if (e2 instanceof DownloadException) {
                this.mCallback.onDownloadError(((DownloadException) e2).errorCode, e2.getMessage(), e2);
            } else {
                this.mCallback.onDownloadError(0, e2.getMessage(), e2);
            }
        } finally {
            sThreadMaps.remove(this.mUrl);
        }
        if (TextUtils.isEmpty(this.mUrl)) {
            throw new DownloadException(1, "url or file name empty!");
        }
        if (!this.mTargetFile.exists()) {
            executeDownload();
            DownloadCallback downloadCallback = this.mCallback;
            if (downloadCallback != null) {
                downloadCallback.onDownloadSuccess(this.mTargetFile);
            }
            this.mTempFile.delete();
            VLog.i(TAG, "download success");
            return;
        }
        VLog.w(TAG, "file already exists in " + this.mTargetFile);
        DownloadCallback downloadCallback2 = this.mCallback;
        if (downloadCallback2 != null) {
            downloadCallback2.onDownloadSuccess(this.mTargetFile);
        }
    }

    public void setThreadPriority(int i2) {
        this.mThreadPriority = i2;
    }

    public MiniDownloadRunable(Context context, String str, String str2, DownloadCallback downloadCallback) {
        this(context, str, str2, downloadCallback, false);
    }

    public static class DownloadException extends Exception {
        private static final long serialVersionUID = -4610529235255803492L;
        public int errorCode;

        public DownloadException(int i2, String str, Throwable th) {
            super(str, th);
            this.errorCode = 0;
            this.errorCode = i2;
        }

        public DownloadException(int i2, String str) {
            super(str);
            this.errorCode = 0;
            this.errorCode = i2;
        }
    }

    public MiniDownloadRunable(Context context, String str, String str2, DownloadCallback downloadCallback, boolean z) {
        this.mThreadPriority = -1;
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.mUrl = str;
        this.mTargetFile = new File(str2);
        this.mTempFile = new File(new File(applicationContext.getFilesDir(), TEMP_DIR), String.valueOf(Math.abs(str.hashCode())));
        this.mCallback = downloadCallback;
        this.mNeedContinue = z;
    }
}
