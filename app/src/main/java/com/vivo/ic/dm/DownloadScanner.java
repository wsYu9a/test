package com.vivo.ic.dm;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.vivo.ic.VLog;
import com.vivo.ic.dm.Downloads;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes4.dex */
class DownloadScanner implements MediaScannerConnection.MediaScannerConnectionClient {
    private static final int SCAN_COMPLETE = 0;
    private static final long SCAN_TIMEOUT = 60000;
    private static final String TAG = Constants.PRE_TAG + "DownloadScanner";
    private final MediaScannerConnection mConnection;
    private final Context mContext;
    private HashMap<String, b> mPending = new HashMap<>();
    private Handler mCompleteHandler = new a();

    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                Uri uri = (Uri) message.obj;
                int i2 = message.arg1;
                if (uri == null || i2 < 0) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(Downloads.Column.MEDIA_SCANNED, (Integer) 1);
                    ContentResolver contentResolver = DownloadScanner.this.mContext.getContentResolver();
                    Uri withAppendedId = ContentUris.withAppendedId(Downloads.Impl.CONTENT_URI, i2);
                    if (contentResolver.update(withAppendedId, contentValues, null, null) == 0) {
                        VLog.w(DownloadScanner.TAG, "onScanCompleted update failed uri is " + withAppendedId);
                        contentResolver.delete(uri, null, null);
                    }
                } catch (NullPointerException unused) {
                    VLog.w(DownloadScanner.TAG, "handleMessage NullPointerException with uri " + uri + ", in id " + i2);
                }
            }
            super.handleMessage(message);
        }
    }

    private static class b {

        /* renamed from: a */
        public final long f28370a;

        /* renamed from: b */
        public final String f28371b;

        /* renamed from: c */
        public final String f28372c;

        /* renamed from: d */
        public final long f28373d = SystemClock.elapsedRealtime();

        public b(long j2, String str, String str2) {
            this.f28370a = j2;
            this.f28371b = str;
            this.f28372c = str2;
        }

        public void a(MediaScannerConnection mediaScannerConnection) {
            try {
                if ("application/octet-stream".equalsIgnoreCase(this.f28372c)) {
                    mediaScannerConnection.scanFile(this.f28371b, null);
                } else {
                    mediaScannerConnection.scanFile(this.f28371b, this.f28372c);
                }
            } catch (Throwable th) {
                VLog.w(DownloadScanner.TAG, "exception in ScanRequest.exec!!!", th);
            }
        }
    }

    public DownloadScanner(Context context) {
        this.mContext = context;
        this.mConnection = new MediaScannerConnection(context, this);
    }

    public boolean hasPendingScans() {
        synchronized (this.mConnection) {
            if (this.mPending.isEmpty()) {
                return false;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator<b> it = this.mPending.values().iterator();
            while (it.hasNext()) {
                if (elapsedRealtime < it.next().f28373d + 60000) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        synchronized (this.mConnection) {
            VLog.i(TAG, "onMediaScannerConnected requestScan() for " + this.mPending);
            Iterator<b> it = this.mPending.values().iterator();
            while (it.hasNext()) {
                it.next().a(this.mConnection);
            }
        }
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        b remove;
        if (TextUtils.isEmpty(str) || uri == null) {
            VLog.w(TAG, "onScanCompleted callback error with path: " + str + ", uri: " + uri);
            return;
        }
        synchronized (this.mConnection) {
            remove = this.mPending.remove(str);
        }
        if (remove == null) {
            return;
        }
        Message obtainMessage = this.mCompleteHandler.obtainMessage(0);
        obtainMessage.arg1 = (int) remove.f28370a;
        obtainMessage.obj = uri;
        this.mCompleteHandler.sendMessage(obtainMessage);
    }

    public void requestScan(DownloadInfo downloadInfo) {
        synchronized (this.mConnection) {
            b bVar = new b(downloadInfo.getId(), downloadInfo.getFileName(), downloadInfo.getMimeType());
            this.mPending.put(bVar.f28371b, bVar);
            if (this.mConnection.isConnected()) {
                VLog.i(TAG, "requestScan() for " + downloadInfo.getFileName() + " mimetype " + downloadInfo.getMimeType());
                bVar.a(this.mConnection);
            } else {
                VLog.i(TAG, "requestScan() for " + downloadInfo.getFileName());
                this.mConnection.connect();
            }
        }
    }

    public void shutdown() {
        this.mConnection.disconnect();
    }
}
