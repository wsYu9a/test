package com.oplus.log.core;

import com.baidu.mobads.sdk.internal.bj;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a */
    String f16113a;

    /* renamed from: b */
    public String f16114b;

    /* renamed from: c */
    String f16115c;

    /* renamed from: d */
    long f16116d;

    /* renamed from: e */
    long f16117e;

    /* renamed from: f */
    long f16118f;

    /* renamed from: g */
    long f16119g;

    /* renamed from: h */
    byte[] f16120h;

    /* renamed from: i */
    byte[] f16121i;

    public static final class a {

        /* renamed from: a */
        public String f16122a;

        /* renamed from: b */
        public String f16123b;

        /* renamed from: e */
        public byte[] f16126e;

        /* renamed from: f */
        public byte[] f16127f;

        /* renamed from: c */
        long f16124c = 2097152;

        /* renamed from: d */
        long f16125d = bj.f5599d;

        /* renamed from: g */
        long f16128g = 52428800;

        /* renamed from: h */
        public String f16129h = "";

        public final a a(long j2) {
            this.f16125d = j2 * 86400000;
            return this;
        }

        public final c b() {
            c cVar = new c((byte) 0);
            cVar.f16113a = this.f16122a;
            cVar.f16114b = this.f16123b;
            cVar.f16116d = this.f16124c;
            cVar.f16119g = this.f16128g;
            cVar.f16117e = this.f16125d;
            cVar.f16120h = this.f16126e;
            cVar.f16121i = this.f16127f;
            cVar.f16115c = this.f16129h;
            return cVar;
        }
    }

    private c() {
        this.f16115c = "";
        this.f16116d = 2097152L;
        this.f16117e = bj.f5599d;
        this.f16118f = 500L;
        this.f16119g = 52428800L;
    }

    /* synthetic */ c(byte b2) {
        this();
    }
}
