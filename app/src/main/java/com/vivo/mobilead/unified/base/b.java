package com.vivo.mobilead.unified.base;

import com.vivo.ad.model.AdError;
import com.vivo.mobilead.i.h;
import com.vivo.mobilead.unified.base.callback.f;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes4.dex */
public class b extends com.vivo.mobilead.util.f1.b {

    /* renamed from: a */
    private long f29712a;

    /* renamed from: b */
    private com.vivo.ad.model.b f29713b;

    /* renamed from: c */
    private CountDownLatch f29714c;

    /* renamed from: d */
    private com.vivo.mobilead.i.c f29715d;

    /* renamed from: f */
    private List<String> f29717f;

    /* renamed from: g */
    private f f29718g;

    /* renamed from: e */
    private int f29716e = 0;

    /* renamed from: h */
    private boolean f29719h = true;

    class a extends com.vivo.mobilead.util.f1.b {
        a() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            b.this.f29718g.b(new AdError(40219, "没有广告素材，建议重试", null, null));
        }
    }

    /* renamed from: com.vivo.mobilead.unified.base.b$b */
    class C0610b extends com.vivo.mobilead.util.f1.b {
        C0610b() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            b.this.f29718g.a(b.this.f29713b);
        }
    }

    class c extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ String f29722a;

        c(String str) {
            this.f29722a = str;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            try {
                try {
                    new com.vivo.mobilead.i.b(new h(this.f29722a, null)).a(1);
                    b.c(b.this);
                } catch (com.vivo.mobilead.i.c e2) {
                    b.this.f29715d = e2;
                }
            } finally {
                b.this.f29714c.countDown();
            }
        }
    }

    class d extends com.vivo.mobilead.util.f1.b {
        d() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            b.this.f29718g.a(b.this.f29713b);
        }
    }

    class e extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ AdError f29725a;

        e(AdError adError) {
            this.f29725a = adError;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            b.this.f29718g.b(this.f29725a);
        }
    }

    static /* synthetic */ int c(b bVar) {
        int i2 = bVar.f29716e;
        bVar.f29716e = i2 + 1;
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c1, code lost:
    
        if (r11.f29719h != false) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x012e, code lost:
    
        r0.run();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0126, code lost:
    
        com.vivo.mobilead.util.z.b().a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00fc, code lost:
    
        if (r11.f29719h != false) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0174, code lost:
    
        r1.run();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0177, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x016c, code lost:
    
        com.vivo.mobilead.util.z.b().a(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0124, code lost:
    
        if (r11.f29719h != false) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x016a, code lost:
    
        if (r11.f29719h != false) goto L185;
     */
    @Override // com.vivo.mobilead.util.f1.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void safelyRun() {
        /*
            Method dump skipped, instructions count: 506
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.mobilead.unified.base.b.safelyRun():void");
    }

    public b a(f fVar) {
        this.f29718g = fVar;
        return this;
    }

    public b a(long j2) {
        this.f29712a = j2;
        return this;
    }

    public b a(com.vivo.ad.model.b bVar) {
        this.f29713b = bVar;
        return this;
    }

    public b a(List<String> list) {
        this.f29717f = list;
        return this;
    }

    public b a(boolean z) {
        this.f29719h = z;
        return this;
    }

    public static b a() {
        return new b();
    }
}
