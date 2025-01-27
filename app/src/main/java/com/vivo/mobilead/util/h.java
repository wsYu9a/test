package com.vivo.mobilead.util;

import android.graphics.Bitmap;

/* loaded from: classes4.dex */
public class h extends com.vivo.mobilead.util.f1.b {

    /* renamed from: a */
    private String f30632a;

    /* renamed from: b */
    private int f30633b;

    /* renamed from: c */
    private com.vivo.mobilead.unified.base.callback.c f30634c;

    /* renamed from: d */
    private boolean f30635d = false;

    class a extends com.vivo.mobilead.util.f1.b {
        a() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            h.this.a((Bitmap) null);
        }
    }

    class b extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ Bitmap f30637a;

        b(Bitmap bitmap) {
            this.f30637a = bitmap;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            h.this.f30634c.a(h.this.f30632a, this.f30637a);
            h.this.f30634c = null;
        }
    }

    public h(String str, int i2, com.vivo.mobilead.unified.base.callback.c cVar) {
        this.f30632a = str;
        this.f30633b = i2;
        this.f30634c = cVar;
    }

    @Override // com.vivo.mobilead.util.f1.b
    public void safelyRun() {
        a();
        a(com.vivo.mobilead.h.b.a().a(this.f30632a, this.f30633b));
    }

    private void a() {
        z.b().a(new a(), 100L);
    }

    public synchronized void a(Bitmap bitmap) {
        if (this.f30634c != null && !this.f30635d) {
            this.f30635d = true;
            z.b().a(new b(bitmap));
        }
    }
}
