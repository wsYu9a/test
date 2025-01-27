package com.vivo.ic.dm;

import java.io.RandomAccessFile;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    public long f28403a;

    /* renamed from: b */
    public int f28404b;

    /* renamed from: c */
    public long f28405c;

    /* renamed from: d */
    public long f28406d;

    /* renamed from: g */
    protected String f28409g;

    /* renamed from: i */
    protected int f28411i;

    /* renamed from: j */
    protected Exception f28412j;
    protected RandomAccessFile k;
    protected boolean l;
    public int m;

    /* renamed from: e */
    public long f28407e = 0;

    /* renamed from: f */
    public long f28408f = 0;

    /* renamed from: h */
    protected long f28410h = 0;
    public int n = 1;
    public boolean o = false;

    public String toString() {
        return "ChildDownloadInfo{mTid=" + this.f28404b + ", mStartBytes=" + this.f28405c + ", mEndBytes=" + this.f28406d + ", mCurrentBytes=" + this.f28407e + ", mLastDownloadBytes=" + this.f28408f + ", mTotalBytes=" + this.f28410h + ", mResume=" + this.l + ", recomNetType=" + this.n + ", isDetect=" + this.o + '}';
    }
}
