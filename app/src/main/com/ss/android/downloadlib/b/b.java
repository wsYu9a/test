package com.ss.android.downloadlib.b;

import androidx.annotation.NonNull;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: com.ss.android.downloadlib.b.b$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ com.ss.android.downloadad.api.a.b f21534a;

        /* renamed from: b */
        final /* synthetic */ g f21535b;

        /* renamed from: com.ss.android.downloadlib.b.b$1$1 */
        public class C06381 implements h {
            public C06381() {
            }

            @Override // com.ss.android.downloadlib.b.h
            public void a(boolean z10) {
                gVar.a(z10);
            }
        }

        public AnonymousClass1(com.ss.android.downloadad.api.a.b bVar, g gVar) {
            bVar = bVar;
            gVar = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (i.a(bVar)) {
                gVar.a(false);
            } else if (f.a(bVar)) {
                f.a(bVar, new h() { // from class: com.ss.android.downloadlib.b.b.1.1
                    public C06381() {
                    }

                    @Override // com.ss.android.downloadlib.b.h
                    public void a(boolean z10) {
                        gVar.a(z10);
                    }
                });
            } else {
                gVar.a(false);
            }
        }
    }

    public void a(@NonNull com.ss.android.downloadad.api.a.b bVar, @NonNull g gVar, int i10) {
        com.ss.android.downloadlib.d.a().a(new Runnable() { // from class: com.ss.android.downloadlib.b.b.1

            /* renamed from: a */
            final /* synthetic */ com.ss.android.downloadad.api.a.b f21534a;

            /* renamed from: b */
            final /* synthetic */ g f21535b;

            /* renamed from: com.ss.android.downloadlib.b.b$1$1 */
            public class C06381 implements h {
                public C06381() {
                }

                @Override // com.ss.android.downloadlib.b.h
                public void a(boolean z10) {
                    gVar.a(z10);
                }
            }

            public AnonymousClass1(com.ss.android.downloadad.api.a.b bVar2, g gVar2) {
                bVar = bVar2;
                gVar = gVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (i.a(bVar)) {
                    gVar.a(false);
                } else if (f.a(bVar)) {
                    f.a(bVar, new h() { // from class: com.ss.android.downloadlib.b.b.1.1
                        public C06381() {
                        }

                        @Override // com.ss.android.downloadlib.b.h
                        public void a(boolean z10) {
                            gVar.a(z10);
                        }
                    });
                } else {
                    gVar.a(false);
                }
            }
        }, i10);
    }
}
