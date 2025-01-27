package com.vivo.ic.dm;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.vivo.ic.dm.Downloads;
import com.vivo.ic.dm.network.IHttpDownload;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

/* loaded from: classes4.dex */
public class d implements Runnable {

    /* renamed from: a */
    private static final String f28413a = Constants.PRE_TAG + "ChildDownloadThread";

    /* renamed from: b */
    public static final int f28414b = 5;

    /* renamed from: c */
    private static final float f28415c = 1.1f;

    /* renamed from: d */
    private final DownloadInfo f28416d;

    /* renamed from: e */
    private Context f28417e;

    /* renamed from: f */
    private c f28418f;

    /* renamed from: g */
    private Handler f28419g;

    /* renamed from: h */
    private InputStream f28420h;

    /* renamed from: j */
    private com.vivo.ic.dm.network.b f28422j;
    private IHttpDownload k = null;
    private boolean l = false;

    /* renamed from: i */
    private long f28421i = l.j().i();

    public d(Context context, DownloadInfo downloadInfo, c cVar, Handler handler) {
        this.f28416d = downloadInfo;
        this.f28417e = context;
        this.f28418f = cVar;
        this.f28419g = handler;
        this.f28422j = new com.vivo.ic.dm.network.b(f28413a, downloadInfo.getId(), cVar.f28404b);
    }

    private void b(c cVar) {
        long lastTime = this.f28416d.getLastTime();
        if (lastTime != -1 && SystemClock.elapsedRealtime() - lastTime > this.f28421i) {
            this.f28416d.setLastTime(-1L);
            a(0, cVar);
        }
    }

    private void c() throws StopRequestException {
        synchronized (this.f28416d) {
            if (this.f28416d.getStatus() == 194) {
                throw new StopRequestException(Downloads.Impl.STATUS_WAITING_TO_RETRY, "waiting to retry, maybe other thread has exception");
            }
        }
    }

    public void a(IHttpDownload iHttpDownload) {
        this.k = iHttpDownload;
        this.l = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        int i2;
        Process.setThreadPriority(10);
        try {
            try {
                try {
                    this.f28418f.m = 0;
                    do {
                        try {
                            if (this.k == null) {
                                this.l = false;
                                this.k = n.a(this.f28417e, this.f28416d, this.f28418f);
                                this.f28422j.b(this.f28418f.f28404b, " addRequestHeaders() mInfo.mDownloadType:" + this.f28416d.getDownloadType() + " ChildDownloadThread executeDownload");
                            }
                            a(this.f28418f, this.k);
                            this.f28418f.m = 0;
                        } catch (StopRequestException e2) {
                            if (e2.a() != 194) {
                                throw e2;
                            }
                            c cVar2 = this.f28418f;
                            cVar2.m++;
                            a(this.k, cVar2, this.f28420h);
                            this.k = null;
                            this.f28420h = null;
                        }
                        cVar = this.f28418f;
                        i2 = cVar.m;
                        if (i2 <= 0) {
                            break;
                        }
                    } while (i2 < 5);
                    a(this.k, cVar, this.f28420h);
                    a(1, this.f28418f);
                    this.f28422j.b(" child thread is over, status: " + this.f28416d.getStatus());
                } catch (Throwable th) {
                    a(this.k, this.f28418f, this.f28420h);
                    a(1, this.f28418f);
                    this.f28422j.b(" child thread is over, status: " + this.f28416d.getStatus());
                    throw th;
                }
            } catch (StopRequestException e3) {
                a(e3.a(), e3);
                a(this.k, this.f28418f, this.f28420h);
                a(1, this.f28418f);
                this.f28422j.b(" child thread is over, status: " + this.f28416d.getStatus());
            }
        } catch (Exception e4) {
            a(Downloads.Impl.STATUS_UNKNOWN_ERROR, e4);
            a(this.k, this.f28418f, this.f28420h);
            a(1, this.f28418f);
            this.f28422j.b(" child thread is over, status: " + this.f28416d.getStatus());
        }
    }

    private void a(c cVar, IHttpDownload iHttpDownload) throws StopRequestException {
        this.f28422j.a(" executeDownload() childInfo: " + cVar);
        try {
            int responseCode = iHttpDownload.getResponseCode();
            f.b().a(this.f28416d, iHttpDownload);
            if (responseCode != 206 && responseCode != 200) {
                a(responseCode);
            }
            this.f28420h = iHttpDownload.openResponseEntity();
            a(cVar, new byte[l.j().b()], this.f28420h);
        } catch (IOException e2) {
            this.f28422j.a(cVar.f28404b, " openResponseEntity IOException", e2);
            throw new StopRequestException(StopRequestException.a(this.f28416d), "while getting entity: " + e2.toString(), e2);
        }
    }

    private void b() throws StopRequestException {
        synchronized (this.f28416d) {
            if (this.f28416d.getControl() != 1) {
                if (this.f28416d.getStatus() != 490) {
                    int status = this.f28416d.getStatus();
                    if (status != 2000) {
                        if (Downloads.Impl.isStatusError(status)) {
                            throw new StopRequestException(status, this.f28416d.getErrorMsg());
                        }
                        if (status == 190) {
                            throw new StopRequestException(Downloads.Impl.STATUS_PENDING, " pending download");
                        }
                    } else {
                        throw new StopRequestException(2000, " can not support break point download");
                    }
                } else {
                    this.f28422j.b(" checkPausedOrCanceledOrError STATUS_CANCELED");
                    throw new StopRequestException(Downloads.Impl.STATUS_CANCELED, "download canceled");
                }
            } else {
                this.f28422j.b(" checkPausedOrCanceledOrError CONTROL_PAUSED");
                throw new StopRequestException(Downloads.Impl.STATUS_PAUSED_BY_APP, "download paused by owner or  network change");
            }
        }
    }

    private void a(int i2) throws StopRequestException {
        if (i2 == 503 && this.f28416d.getNumFailed() < 30) {
            throw new StopRequestException(Downloads.Impl.STATUS_WAITING_TO_RETRY, "downloading got 503 Service Unavailable, will retry later");
        }
        throw new StopRequestException(StopRequestException.a(i2), "check error response code : " + i2);
    }

    private void a(c cVar, byte[] bArr, InputStream inputStream) throws StopRequestException {
        this.f28422j.b(" transferData, childInfo = " + cVar.toString());
        try {
            if (TextUtils.isEmpty(this.f28416d.getFileName())) {
                this.f28422j.b("mFileName is null, reset by default");
                String g2 = l.j().g();
                if (!TextUtils.isEmpty(this.f28416d.getTitle())) {
                    this.f28416d.setFileName(g2 + this.f28416d.getTitle());
                } else {
                    this.f28416d.setFileName(g2 + Constants.DEFAULT_DL_FILENAME);
                }
                File file = new File(g2);
                if (!file.exists()) {
                    file.mkdirs();
                }
            }
            if (cVar.k == null) {
                try {
                    synchronized (this.f28416d) {
                        File file2 = new File(this.f28416d.getActualPath());
                        if (!file2.exists()) {
                            file2.createNewFile();
                        }
                    }
                } catch (Exception e2) {
                    this.f28422j.b("check file err " + this.f28416d.getActualPath(), e2);
                }
                cVar.k = new RandomAccessFile(this.f28416d.getActualPath(), "rw");
            }
            this.f28422j.a(cVar.f28404b, "transferData() mStartBytes:" + cVar.f28405c + ",mCurrentBytes:" + cVar.f28407e);
            long j2 = cVar.f28405c + cVar.f28407e;
            this.f28422j.a(cVar.f28404b, "getFilePointer() before seek:" + cVar.k.getFilePointer());
            cVar.k.seek(j2);
            this.f28422j.a(cVar.f28404b, "getFilePointer() after seek:" + cVar.k.getFilePointer());
            if (this.l) {
                long j3 = cVar.f28406d;
                if (j3 > 0) {
                    long j4 = (j3 - j2) + 1;
                    if (j4 == 0) {
                        a(cVar);
                        return;
                    }
                    byte[] bArr2 = ((long) bArr.length) > j4 ? new byte[(int) j4] : bArr;
                    int length = bArr2.length;
                    while (true) {
                        long j5 = length;
                        if (j4 < j5) {
                            return;
                        }
                        int a2 = a(bArr2, inputStream);
                        if (a2 == -1) {
                            a(cVar);
                            return;
                        }
                        a(cVar, bArr2, a2);
                        long j6 = a2;
                        cVar.f28407e += j6;
                        b(cVar);
                        b();
                        c();
                        a();
                        j4 -= j6;
                        if (j4 == 0) {
                            a(cVar);
                            return;
                        }
                        if (j4 < j5) {
                            length = (int) j4;
                            bArr2 = new byte[length];
                        } else if (j4 < 0) {
                            throw new StopRequestException(Downloads.Impl.STATUS_HTTP_DATA_ERROR, "check zone error " + j4);
                        }
                    }
                }
            }
            while (true) {
                int a3 = a(bArr, inputStream);
                if (a3 == -1) {
                    a(cVar);
                    return;
                }
                a(cVar, bArr, a3);
                cVar.f28407e += a3;
                b(cVar);
                b();
                c();
                a();
            }
        } catch (Exception e3) {
            this.f28422j.a("transferData() mRandomAccessFile initial error:", e3);
            throw new StopRequestException(Downloads.Impl.STATUS_FILE_ERROR, "RandomAccessFile initial error : " + e3.getLocalizedMessage(), e3);
        }
    }

    private int a(byte[] bArr, InputStream inputStream) throws StopRequestException {
        try {
            return inputStream.read(bArr);
        } catch (IOException e2) {
            throw new StopRequestException(StopRequestException.a(this.f28416d), "while reading response: " + e2.getMessage(), e2);
        }
    }

    private void a(c cVar) throws StopRequestException {
        this.f28422j.b("handleEndOfStream()");
        if (!((this.f28416d.getTotalBytes() == -1 || cVar.f28407e == cVar.f28410h) ? false : true)) {
            if (this.f28416d.getDownloadType() == 1) {
                this.f28416d.setTotalBytes(cVar.f28407e);
                cVar.f28410h = cVar.f28407e;
            }
            a(0, cVar);
            return;
        }
        throw new StopRequestException(Downloads.Impl.STATUS_HTTP_DATA_ERROR, "closed socket before end of file [" + this.f28416d.getTotalBytes() + "," + cVar.f28407e + "," + cVar.f28410h + "]");
    }

    private void a(c cVar, byte[] bArr, int i2) throws StopRequestException {
        try {
            cVar.k.write(bArr, 0, i2);
        } catch (Exception e2) {
            o.a(this.f28417e, l.j().g(), -1L);
            throw new StopRequestException(Downloads.Impl.STATUS_FILE_ERROR, "Failed to write file " + e2.getMessage() + " result = " + cVar, e2);
        }
    }

    private void a() throws StopRequestException {
        synchronized (this.f28416d) {
            if (this.f28416d.getTotalBytes() > 0 && this.f28416d.getCurrentBytes() > this.f28416d.getTotalBytes() * f28415c) {
                this.f28422j.a(" currentBytes larger than totalBytes, mCurrentBytes: " + this.f28416d.getCurrentBytes() + " mTotalBytes: " + this.f28416d.getTotalBytes(), (Throwable) null);
                throw new StopRequestException(Downloads.Impl.STATUS_UNKNOWN_ERROR, "currentBytes larger than totalBytes");
            }
        }
    }

    private void a(IHttpDownload iHttpDownload, c cVar, InputStream inputStream) {
        this.f28422j.a(" closeIO()");
        if (iHttpDownload != null) {
            iHttpDownload.close();
        }
        com.vivo.ic.dm.util.a.a(inputStream);
        RandomAccessFile randomAccessFile = cVar.k;
        if (randomAccessFile != null) {
            com.vivo.ic.dm.util.a.a(randomAccessFile);
            cVar.k = null;
        }
    }

    private void a(int i2, Exception exc) {
        this.f28422j.a(" handleDownFailed() mChildInfo: " + this.f28418f, exc);
        c cVar = this.f28418f;
        cVar.f28411i = i2;
        cVar.f28412j = exc;
        a(2, cVar);
    }

    private void a(int i2, c cVar) {
        Message obtainMessage = this.f28419g.obtainMessage();
        obtainMessage.what = i2;
        obtainMessage.obj = cVar;
        this.f28419g.sendMessage(obtainMessage);
    }
}
