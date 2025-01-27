package com.opos.exoplayer.core.a;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.opos.exoplayer.core.Format;

/* loaded from: classes4.dex */
public interface e {

    public static final class a {

        /* renamed from: a */
        @Nullable
        private final Handler f17533a;

        /* renamed from: b */
        @Nullable
        private final e f17534b;

        /* renamed from: com.opos.exoplayer.core.a.e$a$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ com.opos.exoplayer.core.b.d f17535a;

            AnonymousClass1(com.opos.exoplayer.core.b.d dVar) {
                dVar = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f17534b.c(dVar);
            }
        }

        /* renamed from: com.opos.exoplayer.core.a.e$a$2 */
        class AnonymousClass2 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ String f17537a;

            /* renamed from: b */
            final /* synthetic */ long f17538b;

            /* renamed from: c */
            final /* synthetic */ long f17539c;

            AnonymousClass2(String str, long j2, long j3) {
                str = str;
                j2 = j2;
                j3 = j3;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f17534b.b(str, j2, j3);
            }
        }

        /* renamed from: com.opos.exoplayer.core.a.e$a$3 */
        class AnonymousClass3 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Format f17541a;

            AnonymousClass3(Format format) {
                format = format;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f17534b.b(format);
            }
        }

        /* renamed from: com.opos.exoplayer.core.a.e$a$4 */
        class AnonymousClass4 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ int f17543a;

            /* renamed from: b */
            final /* synthetic */ long f17544b;

            /* renamed from: c */
            final /* synthetic */ long f17545c;

            AnonymousClass4(int i2, long j2, long j3) {
                i2 = i2;
                j2 = j2;
                j3 = j3;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f17534b.a(i2, j2, j3);
            }
        }

        /* renamed from: com.opos.exoplayer.core.a.e$a$5 */
        class AnonymousClass5 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ com.opos.exoplayer.core.b.d f17547a;

            AnonymousClass5(com.opos.exoplayer.core.b.d dVar) {
                dVar = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                dVar.a();
                a.this.f17534b.d(dVar);
            }
        }

        /* renamed from: com.opos.exoplayer.core.a.e$a$6 */
        class AnonymousClass6 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ int f17549a;

            AnonymousClass6(int i2) {
                i2 = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f17534b.a(i2);
            }
        }

        public a(@Nullable Handler handler, @Nullable e eVar) {
            this.f17533a = eVar != null ? (Handler) com.opos.exoplayer.core.i.a.a(handler) : null;
            this.f17534b = eVar;
        }

        public void a(int i2) {
            if (this.f17534b != null) {
                this.f17533a.post(new Runnable() { // from class: com.opos.exoplayer.core.a.e.a.6

                    /* renamed from: a */
                    final /* synthetic */ int f17549a;

                    AnonymousClass6(int i22) {
                        i2 = i22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.f17534b.a(i2);
                    }
                });
            }
        }

        public void a(int i2, long j2, long j3) {
            if (this.f17534b != null) {
                this.f17533a.post(new Runnable() { // from class: com.opos.exoplayer.core.a.e.a.4

                    /* renamed from: a */
                    final /* synthetic */ int f17543a;

                    /* renamed from: b */
                    final /* synthetic */ long f17544b;

                    /* renamed from: c */
                    final /* synthetic */ long f17545c;

                    AnonymousClass4(int i22, long j22, long j32) {
                        i2 = i22;
                        j2 = j22;
                        j3 = j32;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.f17534b.a(i2, j2, j3);
                    }
                });
            }
        }

        public void a(Format format) {
            if (this.f17534b != null) {
                this.f17533a.post(new Runnable() { // from class: com.opos.exoplayer.core.a.e.a.3

                    /* renamed from: a */
                    final /* synthetic */ Format f17541a;

                    AnonymousClass3(Format format2) {
                        format = format2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.f17534b.b(format);
                    }
                });
            }
        }

        public void a(com.opos.exoplayer.core.b.d dVar) {
            if (this.f17534b != null) {
                this.f17533a.post(new Runnable() { // from class: com.opos.exoplayer.core.a.e.a.1

                    /* renamed from: a */
                    final /* synthetic */ com.opos.exoplayer.core.b.d f17535a;

                    AnonymousClass1(com.opos.exoplayer.core.b.d dVar2) {
                        dVar = dVar2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.f17534b.c(dVar);
                    }
                });
            }
        }

        public void a(String str, long j2, long j3) {
            if (this.f17534b != null) {
                this.f17533a.post(new Runnable() { // from class: com.opos.exoplayer.core.a.e.a.2

                    /* renamed from: a */
                    final /* synthetic */ String f17537a;

                    /* renamed from: b */
                    final /* synthetic */ long f17538b;

                    /* renamed from: c */
                    final /* synthetic */ long f17539c;

                    AnonymousClass2(String str2, long j22, long j32) {
                        str = str2;
                        j2 = j22;
                        j3 = j32;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.f17534b.b(str, j2, j3);
                    }
                });
            }
        }

        public void b(com.opos.exoplayer.core.b.d dVar) {
            if (this.f17534b != null) {
                this.f17533a.post(new Runnable() { // from class: com.opos.exoplayer.core.a.e.a.5

                    /* renamed from: a */
                    final /* synthetic */ com.opos.exoplayer.core.b.d f17547a;

                    AnonymousClass5(com.opos.exoplayer.core.b.d dVar2) {
                        dVar = dVar2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        dVar.a();
                        a.this.f17534b.d(dVar);
                    }
                });
            }
        }
    }

    void a(int i2);

    void a(int i2, long j2, long j3);

    void b(Format format);

    void b(String str, long j2, long j3);

    void c(com.opos.exoplayer.core.b.d dVar);

    void d(com.opos.exoplayer.core.b.d dVar);
}
