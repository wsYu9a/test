package com.oplus.quickgame.sdk.engine.b;

import java.nio.charset.Charset;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private byte[] f16185a;

    public static class b {

        /* renamed from: c */
        static final /* synthetic */ boolean f16186c = true;

        /* renamed from: a */
        private int f16187a;

        /* renamed from: b */
        private byte[] f16188b;

        private b() {
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        public b a(int i2) {
            this.f16187a = i2;
            return this;
        }

        public b a(byte[] bArr) {
            this.f16188b = bArr;
            return this;
        }

        public c a() {
            if (f16186c || this.f16187a <= 0 || this.f16188b == null) {
                return new c(this);
            }
            throw new AssertionError();
        }
    }

    private c(b bVar) {
        int unused = bVar.f16187a;
        this.f16185a = bVar.f16188b;
    }

    /* synthetic */ c(b bVar, a aVar) {
        this(bVar);
    }

    public static b b() {
        return new b();
    }

    public String a() {
        return new String(this.f16185a, Charset.defaultCharset());
    }
}
