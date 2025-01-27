package com.vivo.google.android.exoplayer3;

import android.util.SparseArray;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public interface x2 {

    public static final class a {

        /* renamed from: a */
        public final String f28262a;

        /* renamed from: b */
        public final byte[] f28263b;

        public a(String str, int i2, byte[] bArr) {
            this.f28262a = str;
            this.f28263b = bArr;
        }
    }

    public static final class b {

        /* renamed from: a */
        public final int f28264a;

        /* renamed from: b */
        public final String f28265b;

        /* renamed from: c */
        public final List<a> f28266c;

        /* renamed from: d */
        public final byte[] f28267d;

        public b(int i2, String str, List<a> list, byte[] bArr) {
            this.f28264a = i2;
            this.f28265b = str;
            this.f28266c = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
            this.f28267d = bArr;
        }
    }

    public interface c {
        SparseArray<x2> a();

        x2 a(int i2, b bVar);
    }

    public static final class d {

        /* renamed from: a */
        public final String f28268a;

        /* renamed from: b */
        public final int f28269b;

        /* renamed from: c */
        public final int f28270c;

        /* renamed from: d */
        public int f28271d;

        /* renamed from: e */
        public String f28272e;

        public d(int i2, int i3, int i4) {
            String str;
            if (i2 != Integer.MIN_VALUE) {
                str = i2 + "/";
            } else {
                str = "";
            }
            this.f28268a = str;
            this.f28269b = i3;
            this.f28270c = i4;
            this.f28271d = Integer.MIN_VALUE;
        }

        public void a() {
            int i2 = this.f28271d;
            this.f28271d = i2 == Integer.MIN_VALUE ? this.f28269b : i2 + this.f28270c;
            this.f28272e = this.f28268a + this.f28271d;
        }

        public String b() {
            if (this.f28271d != Integer.MIN_VALUE) {
                return this.f28272e;
            }
            throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
        }

        public int c() {
            int i2 = this.f28271d;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
        }
    }

    void a();

    void a(n6 n6Var, boolean z);

    void a(u6 u6Var, i0 i0Var, d dVar);
}
