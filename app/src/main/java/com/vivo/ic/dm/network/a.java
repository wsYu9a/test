package com.vivo.ic.dm.network;

import android.os.Handler;
import com.vivo.ic.VLog;
import com.vivo.ic.dm.DownloadInfo;
import com.vivo.ic.dm.Downloads;
import com.vivo.ic.dm.StopRequestException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private static final long f28510a = 5000;

    /* renamed from: b */
    private static final long f28511b = 2;

    /* renamed from: c */
    private static final String f28512c = "DownloadDetect";

    /* renamed from: e */
    private Handler f28514e;

    /* renamed from: f */
    private boolean f28515f;
    private DownloadInfo k;
    private Runnable l;

    /* renamed from: g */
    private int f28516g = 0;

    /* renamed from: h */
    private int f28517h = 0;
    private boolean m = false;

    /* renamed from: d */
    private Semaphore f28513d = new Semaphore(0, true);

    /* renamed from: i */
    private List<com.vivo.ic.dm.c> f28518i = new ArrayList();

    /* renamed from: j */
    private List<com.vivo.ic.dm.c> f28519j = new ArrayList();

    /* renamed from: com.vivo.ic.dm.network.a$a */
    class RunnableC0568a implements Runnable {
        RunnableC0568a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a();
        }
    }

    public a(Handler handler, DownloadInfo downloadInfo, boolean z) {
        this.f28514e = handler;
        this.f28515f = z;
        this.k = downloadInfo;
    }

    private int b(int i2) {
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }

    private void b(com.vivo.ic.dm.c cVar) throws StopRequestException {
        if (this.m) {
            return;
        }
        this.m = true;
        if (this.f28519j.size() != 2) {
            VLog.i(f28512c, "start download is ignore by detectDownloadInfos");
            return;
        }
        com.vivo.ic.dm.c cVar2 = this.f28519j.get(0);
        com.vivo.ic.dm.c cVar3 = this.f28519j.get(1);
        int i2 = cVar.n;
        if (i2 == 1 || i2 == 2) {
            return;
        }
        int size = this.f28518i.size();
        int size2 = this.f28519j.size() + size;
        long j2 = cVar2.f28407e;
        long j3 = cVar2.f28408f;
        long j4 = j2 - j3;
        long j5 = cVar3.f28407e - j3;
        if (j4 <= 0) {
            j4 = 0;
        }
        if (j5 <= 0) {
            j5 = 0;
        }
        VLog.i(f28512c, "calculateNetType by mainLen = " + j4 + " extLen = " + j5);
        float f2 = (float) size2;
        float f3 = (((float) j5) / ((float) (j4 + j5))) * f2;
        if (j4 == 0 && j5 == 0) {
            VLog.i(f28512c, "calculateNetType by mainLen = " + size + " extLen = " + j5);
            int i3 = 1;
            this.k.setRecomNetType(1);
            int i4 = 0;
            while (i4 < size) {
                com.vivo.ic.dm.c cVar4 = this.f28518i.get(i4);
                cVar4.n = i3;
                VLog.i(f28512c, "index  = " + i4 + " recomNetType = " + cVar4.n + " childinfo = " + cVar4);
                i4++;
                i3 = 1;
            }
            return;
        }
        if (f3 < 0.5f) {
            VLog.i(f28512c, "calculateNetType by extLen = " + j5 + " extNetCountf = " + f3);
            this.k.setRecomNetType(1);
            throw new StopRequestException(Downloads.Impl.STATUS_WAITING_TO_RETRY, "ext net too low");
        }
        if (f2 - f3 < 0.5f) {
            VLog.i(f28512c, "calculateNetType by mainLen = " + j5 + " dAllCount = " + size2 + " extNetCountf = " + f3);
            this.k.setRecomNetType(2);
            throw new StopRequestException(Downloads.Impl.STATUS_WAITING_TO_RETRY, "mainLen net too low");
        }
        int i5 = (int) f3;
        int min = Math.min(i5, size) - this.f28516g;
        VLog.i(f28512c, "extNetCountf = " + f3 + " availableExt  = " + min + " extNetCount = " + i5 + " waitD = " + size + " mExtDownloadingCount = " + this.f28516g);
        for (int i6 = 0; i6 < size; i6++) {
            com.vivo.ic.dm.c cVar5 = this.f28518i.get(i6);
            if (i6 < min) {
                cVar5.n = 2;
            } else {
                cVar5.n = 1;
            }
            VLog.i(f28512c, "index  = " + i6 + " recomNetType = " + cVar5.n + " childinfo = " + cVar5);
        }
    }

    private int c(int i2) {
        if (i2 == 0) {
            return 2;
        }
        return i2;
    }

    public void c() {
        if (!this.f28515f) {
            VLog.i(f28512c, "startDownload ignore by mIsNeedDetect is false");
            return;
        }
        RunnableC0568a runnableC0568a = new RunnableC0568a();
        this.l = runnableC0568a;
        this.f28514e.postDelayed(runnableC0568a, 5000L);
    }

    public void a(boolean z) {
        this.f28515f = z;
    }

    public void a(List<com.vivo.ic.dm.c> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        int size = list.size();
        if (this.f28515f) {
            this.f28518i.clear();
            this.f28519j.clear();
            this.f28516g = 0;
            for (int i2 = 0; i2 < size; i2++) {
                com.vivo.ic.dm.c cVar = list.get(i2);
                long j2 = (cVar.f28406d - (cVar.f28405c + cVar.f28407e)) + 1;
                int size2 = this.f28519j.size();
                if (j2 > 0 || cVar.f28406d <= 0) {
                    if (size2 < 2) {
                        cVar.o = true;
                        if (size2 == 0) {
                            cVar.n = b(this.k.getRecomNetType());
                            this.f28517h++;
                        } else if (size2 == 1) {
                            cVar.n = c(this.k.getRecomNetType());
                            this.f28516g++;
                        }
                        this.f28519j.add(cVar);
                    } else {
                        this.f28518i.add(cVar);
                    }
                }
            }
            if (this.f28519j.size() <= 0) {
                this.f28515f = false;
            }
            VLog.i(f28512c, "preDetectDownload complete by mDetectDownloadInfos => " + this.f28519j.size());
        }
    }

    public void c(com.vivo.ic.dm.c cVar) {
        if (this.f28515f) {
            int i2 = cVar.n;
            if (i2 == 1) {
                this.f28517h--;
            } else if (i2 == 2) {
                this.f28516g--;
            }
            if (cVar.o) {
                VLog.i(f28512c, "dect info " + cVar + " download suc");
                a(1);
            }
        }
    }

    public void a(com.vivo.ic.dm.c cVar) throws StopRequestException {
        if (!this.f28515f) {
            VLog.i(f28512c, "acquireDownload ignore by mIsNeedDetect is false");
            return;
        }
        VLog.i(f28512c, "acquire download " + cVar);
        try {
            this.f28513d.tryAcquire(5000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        b(cVar);
        VLog.i(f28512c, "start normal download " + cVar);
    }

    public void b() {
        Runnable runnable = this.l;
        if (runnable != null) {
            this.f28514e.removeCallbacks(runnable);
        }
    }

    public void a() {
        int size = this.f28518i.size();
        VLog.i(f28512c, "dect info complete by wait => " + size);
        if (size > 0) {
            a(size);
        }
    }

    private void a(int i2) {
        this.f28513d.release(i2);
    }
}
