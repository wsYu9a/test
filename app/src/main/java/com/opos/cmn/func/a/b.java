package com.opos.cmn.func.a;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    public final boolean f17045a;

    /* renamed from: b */
    public final long f17046b;

    /* renamed from: c */
    public final int f17047c;

    /* renamed from: d */
    public final long f17048d;

    /* renamed from: e */
    public final String f17049e;

    public static class a {

        /* renamed from: a */
        private boolean f17050a = false;

        /* renamed from: b */
        private long f17051b = -1;

        /* renamed from: c */
        private int f17052c = -1;

        /* renamed from: d */
        private long f17053d = -1;

        /* renamed from: e */
        private String f17054e = "";

        public a a(int i2) {
            this.f17052c = i2;
            return this;
        }

        public a a(int i2, String str) {
            if (this.f17052c == -1) {
                this.f17052c = i2;
                this.f17054e = str;
            }
            return this;
        }

        public a a(long j2) {
            this.f17051b = j2;
            return this;
        }

        public a a(String str) {
            this.f17054e = str;
            return this;
        }

        public a a(boolean z) {
            this.f17050a = z;
            return this;
        }

        public b a() {
            return new b(this);
        }

        public a b(long j2) {
            this.f17053d = j2;
            return this;
        }
    }

    public b(a aVar) {
        this.f17045a = aVar.f17050a;
        this.f17046b = aVar.f17051b;
        this.f17047c = aVar.f17052c;
        this.f17048d = aVar.f17053d;
        this.f17049e = aVar.f17054e;
    }

    public String toString() {
        return "DownloadResponse{success=" + this.f17045a + ", contentLength=" + this.f17046b + ", errorCode=" + this.f17047c + ", traffic=" + this.f17048d + ", message=" + this.f17049e + '}';
    }
}
