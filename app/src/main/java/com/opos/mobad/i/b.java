package com.opos.mobad.i;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    public final boolean f21012a;

    /* renamed from: b */
    public final long f21013b;

    public static class a {

        /* renamed from: a */
        private boolean f21014a = false;

        /* renamed from: b */
        private long f21015b = -1;

        public a a(long j2) {
            this.f21015b = j2;
            return this;
        }

        public a a(boolean z) {
            this.f21014a = z;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    public b(a aVar) {
        this.f21012a = aVar.f21014a;
        this.f21013b = aVar.f21015b;
    }

    public String toString() {
        return "DownloadResponse{success=" + this.f21012a + ", contentLength=" + this.f21013b + '}';
    }
}
