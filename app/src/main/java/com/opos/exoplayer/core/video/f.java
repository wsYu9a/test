package com.opos.exoplayer.core.video;

import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.opos.exoplayer.core.Format;

/* loaded from: classes4.dex */
public interface f {

    public static final class a {

        /* renamed from: a */
        @Nullable
        private final Handler f19257a;

        /* renamed from: b */
        @Nullable
        private final f f19258b;

        /* renamed from: com.opos.exoplayer.core.video.f$a$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ com.opos.exoplayer.core.b.d f19259a;

            AnonymousClass1(com.opos.exoplayer.core.b.d dVar) {
                dVar = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f19258b.a(dVar);
            }
        }

        /* renamed from: com.opos.exoplayer.core.video.f$a$2 */
        class AnonymousClass2 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ String f19261a;

            /* renamed from: b */
            final /* synthetic */ long f19262b;

            /* renamed from: c */
            final /* synthetic */ long f19263c;

            AnonymousClass2(String str, long j2, long j3) {
                str = str;
                j2 = j2;
                j3 = j3;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f19258b.a(str, j2, j3);
            }
        }

        /* renamed from: com.opos.exoplayer.core.video.f$a$3 */
        class AnonymousClass3 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Format f19265a;

            AnonymousClass3(Format format) {
                format = format;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f19258b.a(format);
            }
        }

        /* renamed from: com.opos.exoplayer.core.video.f$a$4 */
        class AnonymousClass4 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ int f19267a;

            /* renamed from: b */
            final /* synthetic */ long f19268b;

            AnonymousClass4(int i2, long j2) {
                i2 = i2;
                j2 = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f19258b.a(i2, j2);
            }
        }

        /* renamed from: com.opos.exoplayer.core.video.f$a$5 */
        class AnonymousClass5 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ int f19270a;

            /* renamed from: b */
            final /* synthetic */ int f19271b;

            /* renamed from: c */
            final /* synthetic */ int f19272c;

            /* renamed from: d */
            final /* synthetic */ float f19273d;

            AnonymousClass5(int i2, int i3, int i4, float f2) {
                i2 = i2;
                i3 = i3;
                i4 = i4;
                f2 = f2;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f19258b.a(i2, i3, i4, f2);
            }
        }

        /* renamed from: com.opos.exoplayer.core.video.f$a$6 */
        class AnonymousClass6 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Surface f19275a;

            AnonymousClass6(Surface surface) {
                surface = surface;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f19258b.a(surface);
            }
        }

        /* renamed from: com.opos.exoplayer.core.video.f$a$7 */
        class AnonymousClass7 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ com.opos.exoplayer.core.b.d f19277a;

            AnonymousClass7(com.opos.exoplayer.core.b.d dVar) {
                dVar = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                dVar.a();
                a.this.f19258b.b(dVar);
            }
        }

        public a(@Nullable Handler handler, @Nullable f fVar) {
            this.f19257a = fVar != null ? (Handler) com.opos.exoplayer.core.i.a.a(handler) : null;
            this.f19258b = fVar;
        }

        public void a(int i2, int i3, int i4, float f2) {
            if (this.f19258b != null) {
                this.f19257a.post(new Runnable() { // from class: com.opos.exoplayer.core.video.f.a.5

                    /* renamed from: a */
                    final /* synthetic */ int f19270a;

                    /* renamed from: b */
                    final /* synthetic */ int f19271b;

                    /* renamed from: c */
                    final /* synthetic */ int f19272c;

                    /* renamed from: d */
                    final /* synthetic */ float f19273d;

                    AnonymousClass5(int i22, int i32, int i42, float f22) {
                        i2 = i22;
                        i3 = i32;
                        i4 = i42;
                        f2 = f22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.f19258b.a(i2, i3, i4, f2);
                    }
                });
            }
        }

        public void a(int i2, long j2) {
            if (this.f19258b != null) {
                this.f19257a.post(new Runnable() { // from class: com.opos.exoplayer.core.video.f.a.4

                    /* renamed from: a */
                    final /* synthetic */ int f19267a;

                    /* renamed from: b */
                    final /* synthetic */ long f19268b;

                    AnonymousClass4(int i22, long j22) {
                        i2 = i22;
                        j2 = j22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.f19258b.a(i2, j2);
                    }
                });
            }
        }

        public void a(Surface surface) {
            if (this.f19258b != null) {
                this.f19257a.post(new Runnable() { // from class: com.opos.exoplayer.core.video.f.a.6

                    /* renamed from: a */
                    final /* synthetic */ Surface f19275a;

                    AnonymousClass6(Surface surface2) {
                        surface = surface2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.f19258b.a(surface);
                    }
                });
            }
        }

        public void a(Format format) {
            if (this.f19258b != null) {
                this.f19257a.post(new Runnable() { // from class: com.opos.exoplayer.core.video.f.a.3

                    /* renamed from: a */
                    final /* synthetic */ Format f19265a;

                    AnonymousClass3(Format format2) {
                        format = format2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.f19258b.a(format);
                    }
                });
            }
        }

        public void a(com.opos.exoplayer.core.b.d dVar) {
            if (this.f19258b != null) {
                this.f19257a.post(new Runnable() { // from class: com.opos.exoplayer.core.video.f.a.1

                    /* renamed from: a */
                    final /* synthetic */ com.opos.exoplayer.core.b.d f19259a;

                    AnonymousClass1(com.opos.exoplayer.core.b.d dVar2) {
                        dVar = dVar2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.f19258b.a(dVar);
                    }
                });
            }
        }

        public void a(String str, long j2, long j3) {
            if (this.f19258b != null) {
                this.f19257a.post(new Runnable() { // from class: com.opos.exoplayer.core.video.f.a.2

                    /* renamed from: a */
                    final /* synthetic */ String f19261a;

                    /* renamed from: b */
                    final /* synthetic */ long f19262b;

                    /* renamed from: c */
                    final /* synthetic */ long f19263c;

                    AnonymousClass2(String str2, long j22, long j32) {
                        str = str2;
                        j2 = j22;
                        j3 = j32;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.f19258b.a(str, j2, j3);
                    }
                });
            }
        }

        public void b(com.opos.exoplayer.core.b.d dVar) {
            if (this.f19258b != null) {
                this.f19257a.post(new Runnable() { // from class: com.opos.exoplayer.core.video.f.a.7

                    /* renamed from: a */
                    final /* synthetic */ com.opos.exoplayer.core.b.d f19277a;

                    AnonymousClass7(com.opos.exoplayer.core.b.d dVar2) {
                        dVar = dVar2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        dVar.a();
                        a.this.f19258b.b(dVar);
                    }
                });
            }
        }
    }

    void a(int i2, int i3, int i4, float f2);

    void a(int i2, long j2);

    void a(Surface surface);

    void a(Format format);

    void a(com.opos.exoplayer.core.b.d dVar);

    void a(String str, long j2, long j3);

    void b(com.opos.exoplayer.core.b.d dVar);
}
