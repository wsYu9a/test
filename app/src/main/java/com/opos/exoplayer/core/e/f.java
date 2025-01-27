package com.opos.exoplayer.core.e;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.opos.exoplayer.core.Format;
import com.vivo.google.android.exoplayer3.C;
import java.io.IOException;

/* loaded from: classes4.dex */
public interface f {

    public static final class a {

        /* renamed from: a */
        @Nullable
        private final Handler f18427a;

        /* renamed from: b */
        @Nullable
        private final f f18428b;

        /* renamed from: c */
        private final long f18429c;

        /* renamed from: com.opos.exoplayer.core.e.f$a$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ com.opos.exoplayer.core.h.i f18430a;

            /* renamed from: b */
            final /* synthetic */ int f18431b;

            /* renamed from: c */
            final /* synthetic */ int f18432c;

            /* renamed from: d */
            final /* synthetic */ Format f18433d;

            /* renamed from: e */
            final /* synthetic */ int f18434e;

            /* renamed from: f */
            final /* synthetic */ Object f18435f;

            /* renamed from: g */
            final /* synthetic */ long f18436g;

            /* renamed from: h */
            final /* synthetic */ long f18437h;

            /* renamed from: i */
            final /* synthetic */ long f18438i;

            AnonymousClass1(com.opos.exoplayer.core.h.i iVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4) {
                iVar = iVar;
                i2 = i2;
                i3 = i3;
                format = format;
                i4 = i4;
                obj = obj;
                j2 = j2;
                j3 = j3;
                j4 = j4;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f18428b.a(iVar, i2, i3, format, i4, obj, a.this.a(j2), a.this.a(j3), j4);
            }
        }

        /* renamed from: com.opos.exoplayer.core.e.f$a$2 */
        class AnonymousClass2 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ com.opos.exoplayer.core.h.i f18440a;

            /* renamed from: b */
            final /* synthetic */ int f18441b;

            /* renamed from: c */
            final /* synthetic */ int f18442c;

            /* renamed from: d */
            final /* synthetic */ Format f18443d;

            /* renamed from: e */
            final /* synthetic */ int f18444e;

            /* renamed from: f */
            final /* synthetic */ Object f18445f;

            /* renamed from: g */
            final /* synthetic */ long f18446g;

            /* renamed from: h */
            final /* synthetic */ long f18447h;

            /* renamed from: i */
            final /* synthetic */ long f18448i;

            /* renamed from: j */
            final /* synthetic */ long f18449j;
            final /* synthetic */ long k;

            AnonymousClass2(com.opos.exoplayer.core.h.i iVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6) {
                iVar = iVar;
                i2 = i2;
                i3 = i3;
                format = format;
                i4 = i4;
                obj = obj;
                j2 = j2;
                j3 = j3;
                j4 = j4;
                j5 = j5;
                j6 = j6;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f18428b.a(iVar, i2, i3, format, i4, obj, a.this.a(j2), a.this.a(j3), j4, j5, j6);
            }
        }

        /* renamed from: com.opos.exoplayer.core.e.f$a$3 */
        class AnonymousClass3 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ com.opos.exoplayer.core.h.i f18450a;

            /* renamed from: b */
            final /* synthetic */ int f18451b;

            /* renamed from: c */
            final /* synthetic */ int f18452c;

            /* renamed from: d */
            final /* synthetic */ Format f18453d;

            /* renamed from: e */
            final /* synthetic */ int f18454e;

            /* renamed from: f */
            final /* synthetic */ Object f18455f;

            /* renamed from: g */
            final /* synthetic */ long f18456g;

            /* renamed from: h */
            final /* synthetic */ long f18457h;

            /* renamed from: i */
            final /* synthetic */ long f18458i;

            /* renamed from: j */
            final /* synthetic */ long f18459j;
            final /* synthetic */ long k;

            AnonymousClass3(com.opos.exoplayer.core.h.i iVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6) {
                iVar = iVar;
                i2 = i2;
                i3 = i3;
                format = format;
                i4 = i4;
                obj = obj;
                j2 = j2;
                j3 = j3;
                j4 = j4;
                j5 = j5;
                j6 = j6;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f18428b.b(iVar, i2, i3, format, i4, obj, a.this.a(j2), a.this.a(j3), j4, j5, j6);
            }
        }

        /* renamed from: com.opos.exoplayer.core.e.f$a$4 */
        class AnonymousClass4 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ com.opos.exoplayer.core.h.i f18460a;

            /* renamed from: b */
            final /* synthetic */ int f18461b;

            /* renamed from: c */
            final /* synthetic */ int f18462c;

            /* renamed from: d */
            final /* synthetic */ Format f18463d;

            /* renamed from: e */
            final /* synthetic */ int f18464e;

            /* renamed from: f */
            final /* synthetic */ Object f18465f;

            /* renamed from: g */
            final /* synthetic */ long f18466g;

            /* renamed from: h */
            final /* synthetic */ long f18467h;

            /* renamed from: i */
            final /* synthetic */ long f18468i;

            /* renamed from: j */
            final /* synthetic */ long f18469j;
            final /* synthetic */ long k;
            final /* synthetic */ IOException l;
            final /* synthetic */ boolean m;

            AnonymousClass4(com.opos.exoplayer.core.h.i iVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6, IOException iOException, boolean z) {
                iVar = iVar;
                i2 = i2;
                i3 = i3;
                format = format;
                i4 = i4;
                obj = obj;
                j2 = j2;
                j3 = j3;
                j4 = j4;
                j5 = j5;
                j6 = j6;
                iOException = iOException;
                z = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f18428b.a(iVar, i2, i3, format, i4, obj, a.this.a(j2), a.this.a(j3), j4, j5, j6, iOException, z);
            }
        }

        /* renamed from: com.opos.exoplayer.core.e.f$a$5 */
        class AnonymousClass5 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ int f18470a;

            /* renamed from: b */
            final /* synthetic */ Format f18471b;

            /* renamed from: c */
            final /* synthetic */ int f18472c;

            /* renamed from: d */
            final /* synthetic */ Object f18473d;

            /* renamed from: e */
            final /* synthetic */ long f18474e;

            AnonymousClass5(int i2, Format format, int i3, Object obj, long j2) {
                i2 = i2;
                format = format;
                i3 = i3;
                obj = obj;
                j2 = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f18428b.a(i2, format, i3, obj, a.this.a(j2));
            }
        }

        public a(@Nullable Handler handler, @Nullable f fVar) {
            this(handler, fVar, 0L);
        }

        public a(@Nullable Handler handler, @Nullable f fVar, long j2) {
            this.f18427a = fVar != null ? (Handler) com.opos.exoplayer.core.i.a.a(handler) : null;
            this.f18428b = fVar;
            this.f18429c = j2;
        }

        public long a(long j2) {
            long a2 = com.opos.exoplayer.core.b.a(j2);
            return a2 == C.TIME_UNSET ? C.TIME_UNSET : this.f18429c + a2;
        }

        public void a(int i2, Format format, int i3, Object obj, long j2) {
            Handler handler;
            if (this.f18428b == null || (handler = this.f18427a) == null) {
                return;
            }
            handler.post(new Runnable() { // from class: com.opos.exoplayer.core.e.f.a.5

                /* renamed from: a */
                final /* synthetic */ int f18470a;

                /* renamed from: b */
                final /* synthetic */ Format f18471b;

                /* renamed from: c */
                final /* synthetic */ int f18472c;

                /* renamed from: d */
                final /* synthetic */ Object f18473d;

                /* renamed from: e */
                final /* synthetic */ long f18474e;

                AnonymousClass5(int i22, Format format2, int i32, Object obj2, long j22) {
                    i2 = i22;
                    format = format2;
                    i3 = i32;
                    obj = obj2;
                    j2 = j22;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.this.f18428b.a(i2, format, i3, obj, a.this.a(j2));
                }
            });
        }

        public void a(com.opos.exoplayer.core.h.i iVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4) {
            Handler handler;
            if (this.f18428b == null || (handler = this.f18427a) == null) {
                return;
            }
            handler.post(new Runnable() { // from class: com.opos.exoplayer.core.e.f.a.1

                /* renamed from: a */
                final /* synthetic */ com.opos.exoplayer.core.h.i f18430a;

                /* renamed from: b */
                final /* synthetic */ int f18431b;

                /* renamed from: c */
                final /* synthetic */ int f18432c;

                /* renamed from: d */
                final /* synthetic */ Format f18433d;

                /* renamed from: e */
                final /* synthetic */ int f18434e;

                /* renamed from: f */
                final /* synthetic */ Object f18435f;

                /* renamed from: g */
                final /* synthetic */ long f18436g;

                /* renamed from: h */
                final /* synthetic */ long f18437h;

                /* renamed from: i */
                final /* synthetic */ long f18438i;

                AnonymousClass1(com.opos.exoplayer.core.h.i iVar2, int i22, int i32, Format format2, int i42, Object obj2, long j22, long j32, long j42) {
                    iVar = iVar2;
                    i2 = i22;
                    i3 = i32;
                    format = format2;
                    i4 = i42;
                    obj = obj2;
                    j2 = j22;
                    j3 = j32;
                    j4 = j42;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.this.f18428b.a(iVar, i2, i3, format, i4, obj, a.this.a(j2), a.this.a(j3), j4);
                }
            });
        }

        public void a(com.opos.exoplayer.core.h.i iVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6) {
            Handler handler;
            if (this.f18428b == null || (handler = this.f18427a) == null) {
                return;
            }
            handler.post(new Runnable() { // from class: com.opos.exoplayer.core.e.f.a.2

                /* renamed from: a */
                final /* synthetic */ com.opos.exoplayer.core.h.i f18440a;

                /* renamed from: b */
                final /* synthetic */ int f18441b;

                /* renamed from: c */
                final /* synthetic */ int f18442c;

                /* renamed from: d */
                final /* synthetic */ Format f18443d;

                /* renamed from: e */
                final /* synthetic */ int f18444e;

                /* renamed from: f */
                final /* synthetic */ Object f18445f;

                /* renamed from: g */
                final /* synthetic */ long f18446g;

                /* renamed from: h */
                final /* synthetic */ long f18447h;

                /* renamed from: i */
                final /* synthetic */ long f18448i;

                /* renamed from: j */
                final /* synthetic */ long f18449j;
                final /* synthetic */ long k;

                AnonymousClass2(com.opos.exoplayer.core.h.i iVar2, int i22, int i32, Format format2, int i42, Object obj2, long j22, long j32, long j42, long j52, long j62) {
                    iVar = iVar2;
                    i2 = i22;
                    i3 = i32;
                    format = format2;
                    i4 = i42;
                    obj = obj2;
                    j2 = j22;
                    j3 = j32;
                    j4 = j42;
                    j5 = j52;
                    j6 = j62;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.this.f18428b.a(iVar, i2, i3, format, i4, obj, a.this.a(j2), a.this.a(j3), j4, j5, j6);
                }
            });
        }

        public void a(com.opos.exoplayer.core.h.i iVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6, IOException iOException, boolean z) {
            Handler handler;
            if (this.f18428b == null || (handler = this.f18427a) == null) {
                return;
            }
            handler.post(new Runnable() { // from class: com.opos.exoplayer.core.e.f.a.4

                /* renamed from: a */
                final /* synthetic */ com.opos.exoplayer.core.h.i f18460a;

                /* renamed from: b */
                final /* synthetic */ int f18461b;

                /* renamed from: c */
                final /* synthetic */ int f18462c;

                /* renamed from: d */
                final /* synthetic */ Format f18463d;

                /* renamed from: e */
                final /* synthetic */ int f18464e;

                /* renamed from: f */
                final /* synthetic */ Object f18465f;

                /* renamed from: g */
                final /* synthetic */ long f18466g;

                /* renamed from: h */
                final /* synthetic */ long f18467h;

                /* renamed from: i */
                final /* synthetic */ long f18468i;

                /* renamed from: j */
                final /* synthetic */ long f18469j;
                final /* synthetic */ long k;
                final /* synthetic */ IOException l;
                final /* synthetic */ boolean m;

                AnonymousClass4(com.opos.exoplayer.core.h.i iVar2, int i22, int i32, Format format2, int i42, Object obj2, long j22, long j32, long j42, long j52, long j62, IOException iOException2, boolean z2) {
                    iVar = iVar2;
                    i2 = i22;
                    i3 = i32;
                    format = format2;
                    i4 = i42;
                    obj = obj2;
                    j2 = j22;
                    j3 = j32;
                    j4 = j42;
                    j5 = j52;
                    j6 = j62;
                    iOException = iOException2;
                    z = z2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.this.f18428b.a(iVar, i2, i3, format, i4, obj, a.this.a(j2), a.this.a(j3), j4, j5, j6, iOException, z);
                }
            });
        }

        public void b(com.opos.exoplayer.core.h.i iVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6) {
            Handler handler;
            if (this.f18428b == null || (handler = this.f18427a) == null) {
                return;
            }
            handler.post(new Runnable() { // from class: com.opos.exoplayer.core.e.f.a.3

                /* renamed from: a */
                final /* synthetic */ com.opos.exoplayer.core.h.i f18450a;

                /* renamed from: b */
                final /* synthetic */ int f18451b;

                /* renamed from: c */
                final /* synthetic */ int f18452c;

                /* renamed from: d */
                final /* synthetic */ Format f18453d;

                /* renamed from: e */
                final /* synthetic */ int f18454e;

                /* renamed from: f */
                final /* synthetic */ Object f18455f;

                /* renamed from: g */
                final /* synthetic */ long f18456g;

                /* renamed from: h */
                final /* synthetic */ long f18457h;

                /* renamed from: i */
                final /* synthetic */ long f18458i;

                /* renamed from: j */
                final /* synthetic */ long f18459j;
                final /* synthetic */ long k;

                AnonymousClass3(com.opos.exoplayer.core.h.i iVar2, int i22, int i32, Format format2, int i42, Object obj2, long j22, long j32, long j42, long j52, long j62) {
                    iVar = iVar2;
                    i2 = i22;
                    i3 = i32;
                    format = format2;
                    i4 = i42;
                    obj = obj2;
                    j2 = j22;
                    j3 = j32;
                    j4 = j42;
                    j5 = j52;
                    j6 = j62;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.this.f18428b.b(iVar, i2, i3, format, i4, obj, a.this.a(j2), a.this.a(j3), j4, j5, j6);
                }
            });
        }
    }

    void a(int i2, Format format, int i3, Object obj, long j2);

    void a(com.opos.exoplayer.core.h.i iVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4);

    void a(com.opos.exoplayer.core.h.i iVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6);

    void a(com.opos.exoplayer.core.h.i iVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6, IOException iOException, boolean z);

    void b(com.opos.exoplayer.core.h.i iVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6);
}
