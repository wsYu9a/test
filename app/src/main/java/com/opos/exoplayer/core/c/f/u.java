package com.opos.exoplayer.core.c.f;

import android.util.SparseArray;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public interface u {

    public static final class a {

        /* renamed from: a */
        public final String f18274a;

        /* renamed from: b */
        public final int f18275b;

        /* renamed from: c */
        public final byte[] f18276c;

        public a(String str, int i2, byte[] bArr) {
            this.f18274a = str;
            this.f18275b = i2;
            this.f18276c = bArr;
        }
    }

    public static final class b {

        /* renamed from: a */
        public final int f18277a;

        /* renamed from: b */
        public final String f18278b;

        /* renamed from: c */
        public final List<a> f18279c;

        /* renamed from: d */
        public final byte[] f18280d;

        public b(int i2, String str, List<a> list, byte[] bArr) {
            this.f18277a = i2;
            this.f18278b = str;
            this.f18279c = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
            this.f18280d = bArr;
        }
    }

    public interface c {
        SparseArray<u> a();

        u a(int i2, b bVar);
    }

    public static final class d {

        /* renamed from: a */
        private final String f18281a;

        /* renamed from: b */
        private final int f18282b;

        /* renamed from: c */
        private final int f18283c;

        /* renamed from: d */
        private int f18284d;

        /* renamed from: e */
        private String f18285e;

        public d(int i2, int i3) {
            this(Integer.MIN_VALUE, i2, i3);
        }

        public d(int i2, int i3, int i4) {
            String str;
            if (i2 != Integer.MIN_VALUE) {
                str = i2 + "/";
            } else {
                str = "";
            }
            this.f18281a = str;
            this.f18282b = i3;
            this.f18283c = i4;
            this.f18284d = Integer.MIN_VALUE;
        }

        private void d() {
            if (this.f18284d == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }

        public void a() {
            int i2 = this.f18284d;
            this.f18284d = i2 == Integer.MIN_VALUE ? this.f18282b : i2 + this.f18283c;
            this.f18285e = this.f18281a + this.f18284d;
        }

        public int b() {
            d();
            return this.f18284d;
        }

        public String c() {
            d();
            return this.f18285e;
        }
    }

    void a();

    void a(com.opos.exoplayer.core.i.m mVar, boolean z);

    void a(com.opos.exoplayer.core.i.s sVar, com.opos.exoplayer.core.c.g gVar, d dVar);
}
