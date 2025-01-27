package com.vivo.mobilead.util.b1.a;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.vivo.mobilead.model.VivoAdError;
import com.vivo.mobilead.util.a1;
import com.vivo.mobilead.util.b1.a.a;
import com.vivo.mobilead.util.z;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: c */
    private static volatile b f30552c;

    /* renamed from: d */
    private static ConcurrentHashMap<String, com.vivo.mobilead.util.b1.a.a> f30553d = new ConcurrentHashMap<>();

    /* renamed from: a */
    private HandlerThread f30554a;

    /* renamed from: b */
    private Handler f30555b;

    class a extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ com.vivo.mobilead.util.b1.a.c.a f30556a;

        a(b bVar, com.vivo.mobilead.util.b1.a.c.a aVar) {
            this.f30556a = aVar;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            com.vivo.mobilead.util.b1.a.c.a aVar = this.f30556a;
            if (aVar != null) {
                aVar.a(new VivoAdError("没有广告素材，建议重试", 40219));
            }
        }
    }

    /* renamed from: com.vivo.mobilead.util.b1.a.b$b */
    class C0664b extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ String f30557a;

        /* renamed from: b */
        final /* synthetic */ com.vivo.mobilead.util.b1.a.c.a f30558b;

        /* renamed from: com.vivo.mobilead.util.b1.a.b$b$a */
        class a extends com.vivo.mobilead.util.f1.b {
            a() {
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                com.vivo.mobilead.util.b1.a.a aVar = (com.vivo.mobilead.util.b1.a.a) b.f30553d.get(C0664b.this.f30557a);
                if (aVar != null) {
                    aVar.a(C0664b.this.f30558b);
                } else {
                    C0664b c0664b = C0664b.this;
                    b.this.a(c0664b.f30557a, c0664b.f30558b);
                }
            }
        }

        /* renamed from: com.vivo.mobilead.util.b1.a.b$b$b */
        class C0665b extends com.vivo.mobilead.util.f1.b {
            C0665b() {
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                b.f30553d.remove(C0664b.this.f30557a);
            }
        }

        /* renamed from: com.vivo.mobilead.util.b1.a.b$b$c */
        class c extends com.vivo.mobilead.util.f1.b {

            /* renamed from: a */
            final /* synthetic */ byte[] f30562a;

            /* renamed from: b */
            final /* synthetic */ File f30563b;

            /* renamed from: c */
            final /* synthetic */ Bitmap f30564c;

            c(byte[] bArr, File file, Bitmap bitmap) {
                this.f30562a = bArr;
                this.f30563b = file;
                this.f30564c = bitmap;
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                C0664b c0664b = C0664b.this;
                com.vivo.mobilead.util.b1.a.c.a aVar = c0664b.f30558b;
                if (aVar != null) {
                    byte[] bArr = this.f30562a;
                    if (bArr == null && this.f30563b == null) {
                        aVar.a(c0664b.f30557a, this.f30564c);
                    } else {
                        aVar.a(c0664b.f30557a, bArr, this.f30563b);
                    }
                }
            }
        }

        C0664b(String str, com.vivo.mobilead.util.b1.a.c.a aVar) {
            this.f30557a = str;
            this.f30558b = aVar;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            File file;
            byte[] bArr;
            Bitmap bitmap = null;
            if (!this.f30557a.endsWith(".gif")) {
                file = null;
                bitmap = com.vivo.mobilead.h.b.a().a(this.f30557a);
                bArr = null;
            } else if (Build.VERSION.SDK_INT >= 28) {
                file = com.vivo.mobilead.h.b.a().d(this.f30557a);
                bArr = null;
            } else {
                bArr = com.vivo.mobilead.h.b.a().c(this.f30557a);
                file = null;
            }
            if (bitmap != null || bArr != null || file != null) {
                z.b().a(new c(bArr, file, bitmap));
                return;
            }
            if (((com.vivo.mobilead.util.b1.a.a) b.f30553d.get(this.f30557a)) != null && this.f30558b != null) {
                b.this.f30555b.post(new a());
                return;
            }
            com.vivo.mobilead.util.b1.a.a a2 = new a.d(this.f30557a).a(this.f30558b).a();
            b.f30553d.put(this.f30557a, a2);
            try {
                com.vivo.mobilead.model.c cVar = (com.vivo.mobilead.model.c) a1.a(a2).get(10000L, TimeUnit.MILLISECONDS);
                VivoAdError vivoAdError = cVar.f29566d;
                if (vivoAdError != null) {
                    a2.a(vivoAdError);
                } else if (this.f30557a.endsWith(".gif")) {
                    a2.a(cVar.f29564b, cVar.f29565c);
                } else {
                    a2.a(cVar.f29563a);
                }
            } catch (Exception unused) {
                if (a2 != null) {
                    a2.a(new VivoAdError("素材加载超时", 402110));
                }
            } finally {
                b.this.f30555b.post(new C0665b());
            }
        }
    }

    private b() {
        HandlerThread handlerThread = new HandlerThread("VivoImageloader");
        this.f30554a = handlerThread;
        handlerThread.start();
        this.f30555b = new Handler(this.f30554a.getLooper());
    }

    public static b b() {
        if (f30552c == null) {
            synchronized (b.class) {
                if (f30552c == null) {
                    f30552c = new b();
                }
            }
        }
        return f30552c;
    }

    public void a(String str) {
        a(str, null);
    }

    public void a(String str, com.vivo.mobilead.util.b1.a.c.a aVar) {
        if (TextUtils.isEmpty(str)) {
            z.b().a(new a(this, aVar));
        } else {
            a1.c(new C0664b(str, aVar));
        }
    }
}
