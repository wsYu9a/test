package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.text.Cue;
import java.util.List;

/* loaded from: classes4.dex */
public final class m4 implements y3 {

    /* renamed from: a */
    public final List<Cue> f27769a;

    public m4(List<Cue> list) {
        this.f27769a = list;
    }

    @Override // com.vivo.google.android.exoplayer3.y3
    public int a() {
        return 1;
    }

    @Override // com.vivo.google.android.exoplayer3.y3
    public int a(long j2) {
        return -1;
    }

    @Override // com.vivo.google.android.exoplayer3.y3
    public long a(int i2) {
        return 0L;
    }

    @Override // com.vivo.google.android.exoplayer3.y3
    public List<Cue> b(long j2) {
        return this.f27769a;
    }
}
