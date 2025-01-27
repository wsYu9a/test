package com.opos.exoplayer.core.a;

import android.annotation.TargetApi;
import android.media.AudioAttributes;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a */
    public static final b f17521a = new a().a();

    /* renamed from: b */
    public final int f17522b;

    /* renamed from: c */
    public final int f17523c;

    /* renamed from: d */
    public final int f17524d;

    /* renamed from: e */
    private AudioAttributes f17525e;

    public static final class a {

        /* renamed from: a */
        private int f17526a = 0;

        /* renamed from: b */
        private int f17527b = 0;

        /* renamed from: c */
        private int f17528c = 1;

        public b a() {
            return new b(this.f17526a, this.f17527b, this.f17528c);
        }
    }

    private b(int i2, int i3, int i4) {
        this.f17522b = i2;
        this.f17523c = i3;
        this.f17524d = i4;
    }

    /* synthetic */ b(int i2, int i3, int i4, AnonymousClass1 anonymousClass1) {
        this(i2, i3, i4);
    }

    @TargetApi(21)
    AudioAttributes a() {
        if (this.f17525e == null) {
            this.f17525e = new AudioAttributes.Builder().setContentType(this.f17522b).setFlags(this.f17523c).setUsage(this.f17524d).build();
        }
        return this.f17525e;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f17522b != bVar.f17522b || this.f17523c != bVar.f17523c || this.f17524d != bVar.f17524d) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return ((((this.f17522b + 527) * 31) + this.f17523c) * 31) + this.f17524d;
    }
}
