package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.text.Cue;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class d4 extends x implements y3 {

    /* renamed from: c */
    public y3 f27293c;

    /* renamed from: d */
    public long f27294d;

    @Override // com.vivo.google.android.exoplayer3.y3
    public int a() {
        return this.f27293c.a();
    }

    @Override // com.vivo.google.android.exoplayer3.y3
    public int a(long j2) {
        return this.f27293c.a(j2 - this.f27294d);
    }

    @Override // com.vivo.google.android.exoplayer3.y3
    public long a(int i2) {
        return this.f27293c.a(i2) + this.f27294d;
    }

    @Override // com.vivo.google.android.exoplayer3.y3
    public List<Cue> b(long j2) {
        return this.f27293c.b(j2 - this.f27294d);
    }

    public abstract void b();
}
