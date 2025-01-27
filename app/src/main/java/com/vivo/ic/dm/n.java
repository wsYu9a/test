package com.vivo.ic.dm;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.SystemClock;
import android.text.TextUtils;
import com.vivo.ic.VLog;
import com.vivo.ic.dm.DownloadInfo;
import com.vivo.ic.dm.Downloads;
import com.vivo.ic.dm.network.IHttpDownload;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.apache.http.HttpHeaders;

/* loaded from: classes4.dex */
class n {

    /* renamed from: a */
    protected static final int f28499a = 0;

    /* renamed from: b */
    protected static final int f28500b = 1;

    /* renamed from: c */
    protected static final int f28501c = 2;

    /* renamed from: d */
    private static final long f28502d = 1048576;

    /* renamed from: e */
    private static final String f28503e = Constants.PRE_TAG + "ChildDownloadManager";

    /* renamed from: f */
    private static final int f28504f = 200;
    private boolean A;

    /* renamed from: g */
    private final Context f28505g;

    /* renamed from: h */
    private final DownloadInfo f28506h;

    /* renamed from: i */
    private List<c> f28507i;

    /* renamed from: j */
    private IHttpDownload f28508j;
    protected long k;
    int l;
    private com.vivo.ic.dm.network.b m;
    private HandlerThread p;
    private Handler q;
    private d[] s;
    private c[] t;
    private CountDownLatch u;
    private Exception v;
    private long w;
    private long y;
    private com.vivo.ic.dm.network.a z;
    private boolean r = false;
    private long x = 0;
    private f n = f.b();
    private l o = l.j();

    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            c cVar = (c) message.obj;
            int i2 = message.what;
            if (i2 != 0) {
                if (i2 == 1) {
                    n.this.m.b(cVar.f28404b, "mSyncHandler FINISH mDownloadInfo " + n.this.f28506h);
                    n.this.u.countDown();
                    n.this.z.c(cVar);
                    return;
                }
                if (i2 != 2) {
                    return;
                }
                if (n.this.f28506h.getStatus() != cVar.f28411i) {
                    n.this.f28506h.setStatus(cVar.f28411i);
                    n.this.a(cVar.f28412j);
                    return;
                }
                VLog.i(n.f28503e, "current download has changed " + cVar.f28411i);
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            n.this.f28506h.setLastTime(elapsedRealtime);
            if (elapsedRealtime - n.this.w < n.this.y) {
                n.this.m.b(cVar.f28404b, "update process too frequently");
                return;
            }
            if (Downloads.Impl.isStatusCompleted(n.this.f28506h.getStatus())) {
                n.this.m.b(cVar.f28404b, "mSyncHandler PROGRESS StatusCompleted ");
                return;
            }
            n.this.n();
            n.this.r = true;
            int writeToDatabase = n.this.f28506h.writeToDatabase("DOWNLOAD_PROGRESS_MESSAGE");
            n.this.m.a("mSyncHandler PROGRESS writeToDatabase rows: " + writeToDatabase + " mDownloadInfo: " + n.this.f28506h);
            if (writeToDatabase > 0) {
                n.this.n.a(n.this.f28506h, n.this.f28506h.getCurrentBytes(), n.this.f28506h.getTotalBytes(), n.this.f28506h.getSpeed());
            } else {
                n.this.f28506h.setStatus(Downloads.Impl.STATUS_CANCELED);
                n.this.f28506h.setErrorMsg("Download deleted or missing by progress!");
            }
        }
    }

    n(Context context, DownloadInfo downloadInfo) {
        boolean z = false;
        this.f28505g = context;
        this.f28506h = downloadInfo;
        HandlerThread handlerThread = new HandlerThread("ChildManagerSyncThread-" + downloadInfo.getId());
        this.p = handlerThread;
        handlerThread.start();
        com.vivo.ic.dm.network.b bVar = new com.vivo.ic.dm.network.b(f28503e, downloadInfo.getId());
        this.m = bVar;
        bVar.b("ChildDownloadManager Constructor OK");
        this.y = l.j().i();
        if (l.j().q() && downloadInfo.getRecomNetType() == 0) {
            z = true;
        }
        this.A = z;
    }

    private boolean i() {
        if (j() && this.f28506h.getStatus() == 200) {
            return true;
        }
        int i2 = 0;
        while (true) {
            c[] cVarArr = this.t;
            if (i2 >= cVarArr.length) {
                return true;
            }
            c cVar = cVarArr[i2];
            if (cVar.f28407e != cVar.f28410h) {
                this.m.b("isAllChildComplete() some child is not complete");
                return false;
            }
            i2++;
        }
    }

    private boolean j() {
        return this.l == 1;
    }

    private void k() throws StopRequestException {
        try {
            this.z.c();
            int size = this.f28507i.size();
            this.m.b("startChildDownload index  end: " + size);
            for (int i2 = 0; i2 < size; i2++) {
                c cVar = this.f28507i.get(i2);
                if (!cVar.o) {
                    this.s[i2] = new d(this.f28505g, this.f28506h, cVar, this.q);
                    this.t[i2] = cVar;
                    long j2 = cVar.f28405c + cVar.f28407e;
                    long j3 = cVar.f28406d;
                    if ((j3 - j2) + 1 > 0 || j3 <= 0) {
                        this.z.a(cVar);
                        this.m.a("childInfo: " + cVar.toString());
                        com.vivo.ic.dm.q.d.b().a(this.s[i2]);
                    } else {
                        this.m.a("childInfo: " + cVar.toString() + " have downloaded");
                        this.u.countDown();
                    }
                }
            }
        } catch (StopRequestException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new StopRequestException(Downloads.Impl.STATUS_UNKNOWN_ERROR, "start Child Download error :" + e3.getLocalizedMessage());
        }
    }

    private void m() {
        if (this.t == null) {
            return;
        }
        long j2 = 0;
        int i2 = 0;
        while (true) {
            c[] cVarArr = this.t;
            if (i2 >= cVarArr.length) {
                this.f28506h.setCurrentBytes(j2);
                return;
            }
            c cVar = cVarArr[i2];
            if (cVar != null) {
                this.m.a(cVar.f28404b, "syncMemoryToDbProgress(): childInfo:" + cVar);
                j2 += cVar.f28407e;
            }
            i2++;
        }
    }

    public void n() {
        if (this.t != null) {
            int i2 = 0;
            long j2 = 0;
            while (true) {
                c[] cVarArr = this.t;
                if (i2 >= cVarArr.length) {
                    break;
                }
                c cVar = cVarArr[i2];
                if (cVar != null) {
                    this.m.a(cVar.f28404b, "syncMemoryToDbProgress(): childInfo:" + cVar);
                    com.vivo.ic.dm.network.c.a(cVar);
                    j2 += cVar.f28407e;
                }
                i2++;
            }
            this.f28506h.setCurrentBytes(j2);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j3 = ((j2 - this.k) * 1000) / (elapsedRealtime - this.w);
            long j4 = this.x;
            if (j4 == 0) {
                this.x = j3;
            } else {
                this.x = ((j4 * 3) + j3) / 4;
            }
            this.f28506h.setSpeed(this.x);
            this.k = j2;
            this.w = elapsedRealtime;
        }
    }

    void l() {
        if (a(this.f28505g)) {
            this.f28506h.setUnCheckWifiError();
            a(Downloads.Impl.STATUS_PAUSED_BY_APP, this.f28506h.getErrorMsg());
            return;
        }
        this.m.b("startDownload() mDownloadInfo: " + this.f28506h);
        PowerManager.WakeLock wakeLock = null;
        PowerManager powerManager = (PowerManager) this.f28505g.getSystemService("power");
        try {
            try {
                b();
                PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, f28503e);
                newWakeLock.acquire();
                this.n.b(this.f28506h);
                DownloadInfo downloadInfo = this.f28506h;
                downloadInfo.setRequestUri(downloadInfo.getUri());
                this.m.b("currentBytes from db: " + this.f28506h.getCurrentBytes());
                if (this.f28506h.getCurrentBytes() <= 0) {
                    this.f28506h.setResume(false);
                } else {
                    if (this.f28506h.getCurrentBytes() == this.f28506h.getTotalBytes()) {
                        this.f28506h.setStatus(200);
                        e();
                        this.z.b();
                        newWakeLock.release();
                        this.p.getLooper().quit();
                        this.m.b("ChildDownloadManager is over, mDownloadInfo.mStatus: " + this.f28506h.getStatus());
                        return;
                    }
                    this.f28506h.setResume(true);
                }
                g(this.f28506h);
                IHttpDownload e2 = e(this.f28506h);
                c(this.f28506h);
                a(e2, this.f28506h.getTotalBytes());
                this.f28506h.writeToDatabase("startDetectDownload");
                k();
                this.f28506h.writeToDatabase("startDownload");
                this.m.b("mCountDownLatch.await() begin ......");
                this.u.await();
                this.m.b("mCountDownLatch.await() finish !!!!!!");
                if (this.u.getCount() == 0) {
                    if (i() && a(this.f28506h)) {
                        f();
                        this.m.b("Download Successfully");
                    } else {
                        com.vivo.ic.dm.network.c.a(this.t);
                    }
                }
                e();
                this.z.b();
                newWakeLock.release();
                this.p.getLooper().quit();
                this.m.b("ChildDownloadManager is over, mDownloadInfo.mStatus: " + this.f28506h.getStatus());
            } catch (StopRequestException e3) {
                a(e3);
                e();
                this.z.b();
                if (0 != 0) {
                    wakeLock.release();
                }
                this.p.getLooper().quit();
                this.m.b("ChildDownloadManager is over, mDownloadInfo.mStatus: " + this.f28506h.getStatus());
            } catch (Exception e4) {
                this.m.a("get a Exception", e4);
                this.f28506h.setStatus(Downloads.Impl.STATUS_UNKNOWN_ERROR);
                a(e4);
                e();
                this.z.b();
                if (0 != 0) {
                    wakeLock.release();
                }
                this.p.getLooper().quit();
                this.m.b("ChildDownloadManager is over, mDownloadInfo.mStatus: " + this.f28506h.getStatus());
            }
        } catch (Throwable th) {
            e();
            this.z.b();
            if (0 != 0) {
                wakeLock.release();
            }
            this.p.getLooper().quit();
            this.m.b("ChildDownloadManager is over, mDownloadInfo.mStatus: " + this.f28506h.getStatus());
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(com.vivo.ic.dm.DownloadInfo r21, com.vivo.ic.dm.network.IHttpDownload r22) throws com.vivo.ic.dm.StopRequestException {
        /*
            Method dump skipped, instructions count: 499
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.ic.dm.n.b(com.vivo.ic.dm.DownloadInfo, com.vivo.ic.dm.network.IHttpDownload):void");
    }

    private void c(DownloadInfo downloadInfo) {
        h();
        this.f28508j = null;
        if (downloadInfo.getDownloadType() != 0) {
            this.l = downloadInfo.getDownloadType();
        } else {
            this.l = this.o.e();
        }
        if (!g()) {
            this.l = 1;
        }
        List<c> a2 = a(this.f28506h, this.l);
        this.f28507i = a2;
        if (this.l != a2.size()) {
            this.l = 1;
        }
        if (this.l > 1 && !a(this.f28507i)) {
            try {
                this.f28508j = a(this.f28505g, downloadInfo, this.f28507i.get(1));
            } catch (StopRequestException e2) {
                e2.printStackTrace();
                IHttpDownload iHttpDownload = this.f28508j;
                if (iHttpDownload != null) {
                    iHttpDownload.close();
                    this.f28508j = null;
                }
                this.l = 1;
            }
        }
        this.f28506h.setDownloadType(this.l);
        int i2 = this.l;
        this.s = new d[i2];
        this.t = new c[i2];
        this.u = new CountDownLatch(this.l);
        this.m.b("initChild()  mDownloadType: " + downloadInfo.getDownloadType() + ",mSupportBreakPoint: " + downloadInfo.isSupportBreakPoint() + ",mCoreSize: " + this.l);
    }

    private void d() {
        c[] cVarArr = this.t;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                if (cVar != null) {
                    cVar.f28407e = 0L;
                    cVar.f28408f = 0L;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0171, code lost:
    
        com.vivo.ic.VLog.i(com.vivo.ic.dm.n.f28503e, " processResponseHeaders Content-Range:" + r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0187, code lost:
    
        if (r6 <= 0) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x018d, code lost:
    
        if (android.text.TextUtils.isEmpty(r5) != false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0197, code lost:
    
        throw new com.vivo.ic.dm.StopRequestException(2000, "url is not support multdownload");
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0198, code lost:
    
        b(r17, r4);
        r17.setRedirectUrl(r2);
        r16.m.b("writing to " + r17.getFileName());
        r16.n.a(r16.f28506h);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01bf, code lost:
    
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.vivo.ic.dm.network.IHttpDownload e(com.vivo.ic.dm.DownloadInfo r17) throws com.vivo.ic.dm.StopRequestException {
        /*
            Method dump skipped, instructions count: 532
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.ic.dm.n.e(com.vivo.ic.dm.DownloadInfo):com.vivo.ic.dm.network.IHttpDownload");
    }

    private void f(DownloadInfo downloadInfo) {
        downloadInfo.setResume(false);
        downloadInfo.setCurrentBytes(0L);
        d();
        c();
        com.vivo.ic.dm.network.c.a(downloadInfo.getId());
    }

    private void g(DownloadInfo downloadInfo) throws StopRequestException {
        this.m.a("setupDestinationFile");
        if (this.f28506h.isResume()) {
            this.m.a("setupDestinationFile, have download before, and mFilename: " + downloadInfo.getFileName());
            File file = new File(downloadInfo.getActualPath());
            if (!file.exists()) {
                this.m.b("setupDestinationFile, have download before, but file not exists");
                f(this.f28506h);
                return;
            }
            this.m.a("setupDestinationFile, resuming download mFileName: " + downloadInfo.getFileName());
            long length = file.length();
            if (length > 0) {
                this.m.a("setupDestinationFile, resuming download, and starting with file of length: " + length);
                return;
            }
            this.m.a("setupDestinationFile, found fileLength=0, deleting " + downloadInfo.getFileName());
            file.delete();
            f(this.f28506h);
        }
    }

    private void h() {
        a aVar = new a(this.p.getLooper());
        this.q = aVar;
        this.z = new com.vivo.ic.dm.network.a(aVar, this.f28506h, this.A);
    }

    private boolean a(List<c> list) {
        int size = list.size();
        for (int i2 = 1; i2 < size; i2++) {
            if (list.get(i2).f28407e > 0) {
                return true;
            }
        }
        return false;
    }

    private boolean d(DownloadInfo downloadInfo) {
        return downloadInfo.getTotalBytes() == downloadInfo.getCurrentBytes() && !Downloads.Impl.isStatusError(downloadInfo.getStatus());
    }

    private void f() {
        this.m.a("handleDownloadSuccess()");
        synchronized (this.f28506h) {
            this.f28506h.setStatus(200);
            this.f28506h.setLastMod(System.currentTimeMillis());
        }
    }

    public void a(int i2, String str) {
        int status = this.f28506h.getStatus();
        this.f28506h.setStatus(i2);
        this.f28506h.writeToDatabase(str);
        if (status != i2) {
            this.n.d(this.f28506h);
        }
    }

    private boolean a(Context context) {
        boolean b2 = com.vivo.ic.dm.network.h.a().b(context);
        boolean f2 = com.vivo.ic.dm.p.a.b().f(context);
        if (b2) {
            if (f2) {
                this.f28506h.setRecomNetType(2);
                this.A = false;
            }
            return false;
        }
        this.A = false;
        if (!f2) {
            this.f28506h.setRecomNetType(1);
        }
        return f2;
    }

    private boolean g() {
        this.m.b("hasTotalBytes() mDownloadInfo.mTotalBytes:" + this.f28506h.getTotalBytes());
        return this.f28506h.getTotalBytes() != -1;
    }

    private void a(IHttpDownload iHttpDownload, long j2) throws StopRequestException {
        IHttpDownload iHttpDownload2;
        this.m.b("startChildDownload totalSize " + j2 + " mCoreSize: " + this.l);
        int i2 = 0;
        try {
            if (j2 <= 0) {
                try {
                    if (!j()) {
                        this.m.b("invalid file total size");
                        throw new StopRequestException(Downloads.Impl.STATUS_UNKNOWN_ERROR, "invalid file total size");
                    }
                } catch (StopRequestException e2) {
                    e = e2;
                    throw new StopRequestException(e.a(), e.getMessage());
                } catch (Exception e3) {
                    e = e3;
                    throw new StopRequestException(Downloads.Impl.STATUS_UNKNOWN_ERROR, "start Child Download error :" + e.getLocalizedMessage());
                }
            }
            o.b(this.f28505g, this.o.g(), j2);
            List<c> a2 = a(this.f28506h, this.l);
            this.f28507i = a2;
            int size = a2.size();
            int i3 = 0;
            while (i2 < size) {
                try {
                    c cVar = this.f28507i.get(i2);
                    if (cVar.o) {
                        this.s[i2] = new d(this.f28505g, this.f28506h, cVar, this.q);
                        this.t[i2] = cVar;
                        long j3 = cVar.f28405c + cVar.f28407e;
                        long j4 = cVar.f28406d;
                        if ((j4 - j3) + 1 <= 0 && j4 > 0) {
                            this.m.a("childInfo: " + cVar.toString() + " have downloaded");
                            this.u.countDown();
                        } else {
                            if (i2 == 1 && (iHttpDownload2 = this.f28508j) != null) {
                                this.s[i2].a(iHttpDownload2);
                            } else if (iHttpDownload != null && i2 == 0) {
                                this.m.a("childInfo: " + cVar.toString() + " ;client: " + iHttpDownload);
                                this.s[i2].a(iHttpDownload);
                                i3 = 1;
                            } else {
                                this.m.a("childInfo: " + cVar.toString());
                            }
                            com.vivo.ic.dm.q.d.b().a(this.s[i2]);
                        }
                    }
                    i2++;
                } catch (StopRequestException e4) {
                    e = e4;
                    throw new StopRequestException(e.a(), e.getMessage());
                } catch (Exception e5) {
                    e = e5;
                    throw new StopRequestException(Downloads.Impl.STATUS_UNKNOWN_ERROR, "start Child Download error :" + e.getLocalizedMessage());
                } catch (Throwable th) {
                    th = th;
                    i2 = i3;
                    if (i2 == 0 && iHttpDownload != null) {
                        try {
                            iHttpDownload.close();
                        } catch (Exception e6) {
                            VLog.w(f28503e, "close error", e6);
                        }
                    }
                    throw th;
                }
            }
            if (i3 != 0 || iHttpDownload == null) {
                return;
            }
            try {
                iHttpDownload.close();
            } catch (Exception e7) {
                VLog.w(f28503e, "close error", e7);
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void c() {
        this.f28506h.setCurrentBytes(0L);
    }

    private void b() throws StopRequestException {
        DownloadInfo.NetworkState checkCanUseNetwork = this.f28506h.checkCanUseNetwork();
        if (checkCanUseNetwork != DownloadInfo.NetworkState.OK) {
            if (checkCanUseNetwork == DownloadInfo.NetworkState.MOBILE) {
                throw new StopRequestException(196, "QUEUED_FOR_WIFI, current net:" + checkCanUseNetwork.name() + " allowedNetType:" + this.f28506h.getAllowedNetType());
            }
            this.m.c("checkConnectivity failed because of networkUsable " + checkCanUseNetwork);
            throw new StopRequestException(Downloads.Impl.STATUS_WAITING_FOR_NETWORK, "WAITING_FOR_NETWORK, current net:" + checkCanUseNetwork.name() + " allowedNetType:" + this.f28506h.getAllowedNetType());
        }
    }

    private List<c> a(DownloadInfo downloadInfo, int i2) {
        long totalBytes = downloadInfo.getTotalBytes();
        long j2 = totalBytes / i2;
        long[] a2 = com.vivo.ic.dm.network.c.a(downloadInfo, i2);
        int i3 = 0;
        if (i2 == 1) {
            a2[0] = downloadInfo.getCurrentBytes();
        }
        ArrayList arrayList = new ArrayList();
        long j3 = j2;
        long j4 = 0;
        while (i3 < i2) {
            c cVar = new c();
            cVar.f28403a = downloadInfo.getId();
            cVar.f28404b = i3;
            cVar.f28405c = j4;
            cVar.f28406d = i3 == i2 + (-1) ? totalBytes - 1 : j3;
            String requestUri = downloadInfo.getRequestUri();
            if (TextUtils.isEmpty(requestUri)) {
                requestUri = downloadInfo.getUri();
            }
            cVar.f28409g = requestUri;
            cVar.f28407e = 0L;
            cVar.f28410h = (cVar.f28406d - cVar.f28405c) + 1;
            cVar.l = downloadInfo.isResume();
            cVar.f28407e = a2[i3];
            cVar.f28408f = a2[i3];
            cVar.n = downloadInfo.getRecomNetType();
            arrayList.add(cVar);
            j4 = j3 + 1;
            j3 = j4 + j2;
            i3++;
        }
        this.z.a(arrayList);
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0139 A[Catch: all -> 0x01bd, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0009, B:7:0x00c2, B:9:0x00d7, B:11:0x00e3, B:14:0x00ec, B:16:0x00f8, B:17:0x0118, B:19:0x0122, B:21:0x0128, B:22:0x0131, B:24:0x0139, B:25:0x013e, B:26:0x0182, B:35:0x01b8, B:41:0x01bc, B:42:0x0105, B:43:0x0109, B:44:0x0012, B:46:0x0016, B:48:0x001f, B:49:0x0024, B:51:0x005f, B:52:0x006f, B:53:0x0065, B:54:0x00a6, B:28:0x0183, B:30:0x0193, B:33:0x01b0, B:34:0x01b7), top: B:3:0x0003, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0183 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e() {
        /*
            Method dump skipped, instructions count: 448
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.ic.dm.n.e():void");
    }

    private void b(DownloadInfo downloadInfo) {
        this.m.b("cleanupDestination, if status != success cleanup file");
        if (downloadInfo.getFileName() != null) {
            if (Downloads.Impl.isStatusByReset(downloadInfo.getStatus()) || Downloads.Impl.isCancle(downloadInfo.getStatus())) {
                this.m.a("cleanupDestination() deleting " + downloadInfo.getFileName());
                synchronized (m.f28495c) {
                    new File(downloadInfo.getFileName()).delete();
                    new File(downloadInfo.getActualPath()).delete();
                }
            }
        }
    }

    private void a(DownloadInfo downloadInfo, IHttpDownload iHttpDownload) throws StopRequestException {
        int i2;
        this.m.a("handleServiceUnavailable");
        String header = iHttpDownload.getHeader(HttpHeaders.RETRY_AFTER);
        if (header != null) {
            try {
                this.m.b("Retry-After :" + header);
                int parseInt = Integer.parseInt(header);
                if (parseInt >= 0) {
                    if (parseInt < 30) {
                        parseInt = 30;
                    } else if (parseInt > 86400) {
                        parseInt = 86400;
                    }
                    i2 = (parseInt + m.f28498f.nextInt(31)) * 1000;
                } else {
                    i2 = 0;
                }
                downloadInfo.setRetryAfter(i2);
                this.m.b("info.mRetryAfter:" + i2);
            } catch (NumberFormatException unused) {
            }
        }
        throw new StopRequestException(Downloads.Impl.STATUS_WAITING_TO_RETRY, "got 503 Service Unavailable, will retry later");
    }

    public void a(Exception exc) {
        this.m.a("setException() exception of ", exc);
        this.v = exc;
    }

    private boolean a(DownloadInfo downloadInfo) throws StopRequestException {
        this.m.a("checkFinalFile()");
        if (downloadInfo.getActualPath() == null) {
            return true;
        }
        File file = new File(downloadInfo.getActualPath());
        if (!file.exists()) {
            throw new StopRequestException(Downloads.Impl.STATUS_FILE_ERROR, "final file may be deleted");
        }
        if (downloadInfo.getTotalBytes() != -1 && file.length() != downloadInfo.getTotalBytes()) {
            throw new StopRequestException(Downloads.Impl.STATUS_HTTP_DATA_ERROR, "Content length mismatch");
        }
        String checkSum = downloadInfo.getCheckSum();
        if (!TextUtils.isEmpty(checkSum) && !checkSum.equals(com.vivo.ic.dm.util.c.a(file))) {
            throw new StopRequestException(Downloads.Impl.STATUS_UNKNOW_FILE_ERROR, "check sum error");
        }
        String fileName = downloadInfo.getFileName();
        if (!TextUtils.isEmpty(fileName)) {
            try {
                if (fileName.equals(downloadInfo.getActualPath())) {
                    return true;
                }
                File file2 = new File(fileName);
                synchronized (m.f28495c) {
                    if (file2.exists()) {
                        file2.delete();
                    }
                    file.renameTo(file2);
                }
                return true;
            } catch (Exception e2) {
                throw new StopRequestException(Downloads.Impl.STATUS_FILE_ERROR, "rename error ", e2);
            }
        }
        throw new StopRequestException(Downloads.Impl.STATUS_FILE_ERROR, "rename error by actual file may be deleted");
    }

    private static IHttpDownload a(Context context, DownloadInfo downloadInfo, String str, c cVar) throws StopRequestException {
        IHttpDownload a2 = com.vivo.ic.dm.network.e.a();
        a2.attachDownloadInfo(context, downloadInfo, str, cVar.n);
        a2.addRequestHeaders();
        a2.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "gzip");
        long j2 = cVar.f28405c + cVar.f28407e;
        if (downloadInfo.getDownloadType() != 1) {
            a2.addRequestProperty(HttpHeaders.RANGE, "bytes=" + j2 + "-" + cVar.f28406d);
            VLog.i(f28503e, " addRequestHeaders() childInfo.mStartBytes:" + cVar.f28405c + ",childInfo.mEndBytes:" + cVar.f28406d + ",currentStart:" + j2);
        } else if (j2 > 0) {
            a2.addRequestProperty(HttpHeaders.RANGE, "bytes=" + j2 + "-");
            VLog.i(f28503e, " addRequestHeaders() single thread download, just start from:" + j2 + ",no endBytes");
        }
        a2.sendRequest();
        return a2;
    }

    public static IHttpDownload a(Context context, DownloadInfo downloadInfo, c cVar) throws StopRequestException {
        URL url;
        String str = cVar.f28409g;
        IHttpDownload iHttpDownload = null;
        int i2 = 0;
        IHttpDownload iHttpDownload2 = null;
        while (true) {
            int i3 = i2 + 1;
            if (i2 < 7) {
                try {
                    try {
                        url = new URL(str);
                        a(iHttpDownload2);
                    } catch (Throwable th) {
                        th = th;
                        iHttpDownload = iHttpDownload2;
                        a(iHttpDownload);
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                    iHttpDownload = iHttpDownload2;
                }
                try {
                    try {
                        iHttpDownload2 = a(context, downloadInfo, str, cVar);
                        int responseCode = iHttpDownload2.getResponseCode();
                        String str2 = f28503e;
                        VLog.i(str2, " openResponseEntity statusCode:" + responseCode);
                        if (responseCode != 301 && responseCode != 302 && responseCode != 303 && responseCode != 307) {
                            if (downloadInfo.getDownloadType() != 1) {
                                String header = iHttpDownload2.getHeader("Transfer-Encoding");
                                if (!TextUtils.isEmpty(header) && header.equalsIgnoreCase("chunked")) {
                                    VLog.i(str2, "Transfer-encoding is chunked, not support break point download");
                                    throw new StopRequestException(2000, "url is not support multdownload");
                                }
                                String header2 = iHttpDownload2.getHeader("Content-Range");
                                String header3 = iHttpDownload2.getHeader("Content-Length");
                                VLog.i(str2, " openResponseEntity Content-Range:" + header2 + " ; Content-Length " + header3);
                                if (!TextUtils.isEmpty(header2) && !TextUtils.isEmpty(header3)) {
                                    a(cVar, header3, header2);
                                } else {
                                    throw new StopRequestException(2000, "url is not support multdownload");
                                }
                            }
                            return iHttpDownload2;
                        }
                        String header4 = iHttpDownload2.getHeader(HttpHeaders.LOCATION);
                        if (!TextUtils.isEmpty(header4)) {
                            VLog.i(str2, "statusCode: " + responseCode + " Location :" + header4);
                            try {
                                str = new URL(url, header4).toString();
                                cVar.f28409g = str;
                                i2 = i3;
                            } catch (Exception e3) {
                                VLog.e(f28503e, "Couldn't resolve redirect URI " + header4 + " for " + str, e3);
                                throw new StopRequestException(Downloads.Impl.STATUS_HTTP_DATA_ERROR, "Couldn't resolve redirect URI : " + header4);
                            }
                        } else {
                            throw new StopRequestException(Downloads.Impl.STATUS_HTTP_DATA_ERROR, "got a redirect without location info");
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        a(iHttpDownload);
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                    throw new StopRequestException(StopRequestException.a(downloadInfo), "http error " + e);
                }
            } else {
                throw new StopRequestException(Downloads.Impl.STATUS_TOO_MANY_REDIRECTS, "too many redirects");
            }
        }
    }

    private static void a(c cVar, String str, String str2) throws StopRequestException {
        int parseInt = Integer.parseInt(str);
        long j2 = cVar.f28405c + cVar.f28407e;
        long j3 = cVar.f28406d;
        if ((j3 - j2) + 1 == parseInt) {
            String str3 = str2.split("/")[0];
            if (("bytes " + j2 + "-" + j3).equals(str3)) {
                return;
            }
            throw new StopRequestException(2000, "url is not support multdownload by targetRange " + str3);
        }
        throw new StopRequestException(2000, "url is not support multdownload by len error " + parseInt);
    }

    private static void a(IHttpDownload iHttpDownload) {
        if (iHttpDownload != null) {
            iHttpDownload.close();
            VLog.e(f28503e, "client close");
        }
    }
}
