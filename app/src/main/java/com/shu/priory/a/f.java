package com.shu.priory.a;

import android.media.AudioRecord;
import com.shu.priory.a.b;
import com.shu.priory.a.m;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public interface f {

    public static abstract class a implements f {

        /* renamed from: a */
        final g f16804a;

        /* renamed from: b */
        final c f16805b;

        /* renamed from: c */
        private final j f16806c = new j();

        /* renamed from: com.shu.priory.a.f$a$1 */
        public class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ com.shu.priory.a.b f16807a;

            public AnonymousClass1(com.shu.priory.a.b bVar) {
                bVar = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f16805b.a(bVar);
            }
        }

        public a(g gVar, c cVar) {
            this.f16804a = gVar;
            this.f16805b = cVar;
        }

        @Override // com.shu.priory.a.f
        public void a() {
            this.f16804a.a(false);
            this.f16804a.d().stop();
            this.f16804a.d().release();
        }

        @Override // com.shu.priory.a.f
        public g b() {
            return this.f16804a;
        }

        public void a(AudioRecord audioRecord, int i10, OutputStream outputStream) throws IOException {
        }

        public void a(com.shu.priory.a.b bVar) {
            this.f16806c.a(new Runnable() { // from class: com.shu.priory.a.f.a.1

                /* renamed from: a */
                final /* synthetic */ com.shu.priory.a.b f16807a;

                public AnonymousClass1(com.shu.priory.a.b bVar2) {
                    bVar = bVar2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.this.f16805b.a(bVar);
                }
            });
        }

        @Override // com.shu.priory.a.f
        public void a(OutputStream outputStream) throws IOException {
            a(this.f16804a.c(), this.f16804a.a(), outputStream);
        }
    }

    public static final class b extends a {

        /* renamed from: c */
        private final m f16809c;

        public b(g gVar, c cVar) {
            this(gVar, cVar, new m.a());
        }

        @Override // com.shu.priory.a.f.a
        public void a(AudioRecord audioRecord, int i10, OutputStream outputStream) throws IOException {
            b.a aVar = new b.a(new byte[i10]);
            while (this.f16804a.b()) {
                aVar.a(audioRecord.read(aVar.a(), 0, i10));
                if (-3 != aVar.b() && -2 != aVar.b()) {
                    if (this.f16805b != null) {
                        a(aVar);
                    }
                    this.f16809c.a(aVar, outputStream);
                }
            }
        }

        public b(g gVar, c cVar, m mVar) {
            super(gVar, cVar);
            this.f16809c = mVar;
        }
    }

    public interface c {
        void a(com.shu.priory.a.b bVar);
    }

    void a();

    void a(OutputStream outputStream) throws IOException;

    g b();
}
