package com.vivo.mobilead.util.b1.a;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.vivo.mobilead.model.VivoAdError;
import com.vivo.mobilead.util.x0;
import com.vivo.mobilead.util.z;
import java.io.File;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public class a implements Callable<com.vivo.mobilead.model.c> {

    /* renamed from: a */
    d f30539a;

    /* renamed from: b */
    List<com.vivo.mobilead.util.b1.a.c.a> f30540b = new Vector();

    /* renamed from: com.vivo.mobilead.util.b1.a.a$a */
    class C0663a extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ com.vivo.mobilead.util.b1.a.c.a f30541a;

        /* renamed from: b */
        final /* synthetic */ Bitmap f30542b;

        C0663a(com.vivo.mobilead.util.b1.a.c.a aVar, Bitmap bitmap) {
            this.f30541a = aVar;
            this.f30542b = bitmap;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            this.f30541a.a(a.this.f30539a.f30550a, this.f30542b);
        }
    }

    class b extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ com.vivo.mobilead.util.b1.a.c.a f30544a;

        /* renamed from: b */
        final /* synthetic */ byte[] f30545b;

        /* renamed from: c */
        final /* synthetic */ File f30546c;

        b(com.vivo.mobilead.util.b1.a.c.a aVar, byte[] bArr, File file) {
            this.f30544a = aVar;
            this.f30545b = bArr;
            this.f30546c = file;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            this.f30544a.a(a.this.f30539a.f30550a, this.f30545b, this.f30546c);
        }
    }

    class c extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ com.vivo.mobilead.util.b1.a.c.a f30548a;

        /* renamed from: b */
        final /* synthetic */ VivoAdError f30549b;

        c(a aVar, com.vivo.mobilead.util.b1.a.c.a aVar2, VivoAdError vivoAdError) {
            this.f30548a = aVar2;
            this.f30549b = vivoAdError;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            this.f30548a.a(this.f30549b);
        }
    }

    public static class d {

        /* renamed from: a */
        @NonNull
        private String f30550a;

        /* renamed from: b */
        private com.vivo.mobilead.util.b1.a.c.a f30551b;

        public d(String str) {
            a(str);
        }

        public d a(String str) {
            this.f30550a = str;
            return this;
        }

        public d a(com.vivo.mobilead.util.b1.a.c.a aVar) {
            this.f30551b = aVar;
            return this;
        }

        public a a() {
            return new a(this);
        }
    }

    protected a(d dVar) {
        this.f30539a = dVar;
        if (dVar.f30551b != null) {
            this.f30540b.add(dVar.f30551b);
        }
    }

    public void a(com.vivo.mobilead.util.b1.a.c.a aVar) {
        this.f30540b.add(aVar);
    }

    public void a(Bitmap bitmap) {
        try {
            for (com.vivo.mobilead.util.b1.a.c.a aVar : this.f30540b) {
                if (aVar != null) {
                    a(new C0663a(aVar, bitmap));
                }
            }
            this.f30540b.clear();
        } catch (Exception e2) {
            x0.b("ImageRequestCallable", e2.getMessage());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0077, code lost:
    
        r5.f29563a = com.vivo.mobilead.h.b.a().a(r1);
     */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.vivo.mobilead.model.c call() {
        /*
            r7 = this;
            java.lang.String r0 = "下载广告素材失败，请检查网络是否良好，是否具有文件存储权限"
            com.vivo.mobilead.util.b1.a.a$d r1 = r7.f30539a
            java.lang.String r1 = com.vivo.mobilead.util.b1.a.a.d.b(r1)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            r3 = 1
            if (r2 != 0) goto L19
            java.lang.String r2 = ".gif"
            boolean r2 = r1.endsWith(r2)
            if (r2 == 0) goto L19
            r2 = 1
            goto L1a
        L19:
            r2 = 0
        L1a:
            com.vivo.mobilead.h.b r4 = com.vivo.mobilead.h.b.a()
            boolean r4 = r4.f(r1)
            com.vivo.mobilead.model.c r5 = new com.vivo.mobilead.model.c
            r5.<init>()
            if (r4 != 0) goto L75
            com.vivo.mobilead.i.h r4 = new com.vivo.mobilead.i.h
            r6 = 0
            r4.<init>(r1, r6)
            com.vivo.mobilead.i.b r6 = new com.vivo.mobilead.i.b
            r6.<init>(r4)
            r4 = 40214(0x9d16, float:5.6352E-41)
            java.lang.Object r3 = r6.a(r3)     // Catch: com.vivo.mobilead.i.c -> L52
            boolean r6 = r3 instanceof com.vivo.mobilead.i.h.a     // Catch: com.vivo.mobilead.i.c -> L52
            if (r6 == 0) goto L75
            com.vivo.mobilead.i.h$a r3 = (com.vivo.mobilead.i.h.a) r3     // Catch: com.vivo.mobilead.i.c -> L52
            java.lang.Boolean r3 = r3.f28897a     // Catch: com.vivo.mobilead.i.c -> L52
            boolean r3 = r3.booleanValue()     // Catch: com.vivo.mobilead.i.c -> L52
            if (r3 == 0) goto L4a
            goto L75
        L4a:
            com.vivo.mobilead.model.VivoAdError r1 = new com.vivo.mobilead.model.VivoAdError     // Catch: com.vivo.mobilead.i.c -> L52
            r1.<init>(r0, r4)     // Catch: com.vivo.mobilead.i.c -> L52
            r5.f29566d = r1     // Catch: com.vivo.mobilead.i.c -> L52
            return r5
        L52:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "bitmap request error"
            r2.append(r3)
            java.lang.String r1 = r1.getMessage()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = "ImageRequestCallable"
            com.vivo.mobilead.util.x0.b(r2, r1)
            com.vivo.mobilead.model.VivoAdError r1 = new com.vivo.mobilead.model.VivoAdError
            r1.<init>(r0, r4)
            r5.f29566d = r1
            return r5
        L75:
            if (r2 != 0) goto L82
            com.vivo.mobilead.h.b r0 = com.vivo.mobilead.h.b.a()
            android.graphics.Bitmap r0 = r0.a(r1)
            r5.f29563a = r0
            goto L9d
        L82:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 28
            if (r0 < r2) goto L93
            com.vivo.mobilead.h.b r0 = com.vivo.mobilead.h.b.a()
            java.io.File r0 = r0.d(r1)
            r5.f29565c = r0
            goto L9d
        L93:
            com.vivo.mobilead.h.b r0 = com.vivo.mobilead.h.b.a()
            byte[] r0 = r0.c(r1)
            r5.f29564b = r0
        L9d:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.mobilead.util.b1.a.a.call():com.vivo.mobilead.model.c");
    }

    public void a(byte[] bArr, File file) {
        try {
            for (com.vivo.mobilead.util.b1.a.c.a aVar : this.f30540b) {
                if (aVar != null) {
                    a(new b(aVar, bArr, file));
                }
            }
            this.f30540b.clear();
        } catch (Exception e2) {
            x0.b("ImageRequestCallable", e2.getMessage());
        }
    }

    public void a(VivoAdError vivoAdError) {
        for (com.vivo.mobilead.util.b1.a.c.a aVar : this.f30540b) {
            if (aVar != null) {
                a(new c(this, aVar, vivoAdError));
            }
        }
        this.f30540b.clear();
    }

    private void a(com.vivo.mobilead.util.f1.b bVar) {
        z.b().a(bVar);
    }
}
