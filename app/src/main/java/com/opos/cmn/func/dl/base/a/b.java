package com.opos.cmn.func.dl.base.a;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.func.dl.base.DownloadRequest;
import com.opos.cmn.func.dl.base.c.d;
import java.io.File;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a */
    public Context f17251a;

    /* renamed from: b */
    int f17252b;

    /* renamed from: c */
    public int f17253c;

    /* renamed from: d */
    String f17254d;

    /* renamed from: e */
    public String f17255e;

    /* renamed from: f */
    public String f17256f;

    /* renamed from: g */
    String f17257g;

    /* renamed from: h */
    public String f17258h;

    /* renamed from: i */
    public File f17259i;

    /* renamed from: j */
    public File f17260j;
    public long k;
    public long l;
    public boolean m;
    boolean n;
    public boolean o;
    com.opos.cmn.func.dl.base.d p;
    public DownloadRequest q;
    public d.a r;
    public AtomicLong s = new AtomicLong();
    private File t;
    private int u;
    private int v;

    public b(DownloadRequest downloadRequest, com.opos.cmn.func.dl.base.d dVar) {
        this.q = downloadRequest;
        this.p = dVar;
        this.f17255e = downloadRequest.f17191a;
        this.f17254d = downloadRequest.f17195e;
        this.f17252b = downloadRequest.f17194d;
        this.f17253c = downloadRequest.f17196f;
        this.f17258h = downloadRequest.f17193c;
        this.f17257g = downloadRequest.f17192b;
        this.o = downloadRequest.f17197g;
        this.f17251a = dVar.f();
        this.r = dVar.h();
        this.v = dVar.b();
        this.u = dVar.a();
        String a2 = com.opos.cmn.func.dl.base.h.a.a(this.f17255e);
        this.f17259i = new File(this.f17257g, a2 + ".pos");
        this.f17260j = new File(this.f17257g, a2 + ".tmp");
    }

    public final File a() {
        File file = this.t;
        if (file != null) {
            return file;
        }
        if (TextUtils.isEmpty(this.f17258h)) {
            this.f17258h = com.opos.cmn.func.dl.base.h.a.d(this.f17255e);
        }
        File file2 = new File(this.f17257g, this.f17258h);
        this.t = file2;
        return file2;
    }

    public final void a(long j2) {
        this.s.set(j2);
    }

    public final String toString() {
        return "DownloadInfo{mContext=" + this.f17251a + ", priority=" + this.f17252b + ", downloadId=" + this.f17253c + ", mMd5='" + this.f17254d + "', mUrl='" + this.f17255e + "', mRedrictUrl='" + this.f17256f + "', mDirPath='" + this.f17257g + "', mFileName='" + this.f17258h + "', mPosFile=" + this.f17259i + ", mTempFile=" + this.f17260j + ", mTotalLength=" + this.k + ", mStartLenght=" + this.l + ", writeThreadCount=" + this.v + ", isAcceptRange=" + this.m + ", allowDownload=" + this.n + ", mManager=" + this.p + ", mRequest=" + this.q + ", mConnFactory=" + this.r + ", mCurrentLength=" + this.s + '}';
    }
}
