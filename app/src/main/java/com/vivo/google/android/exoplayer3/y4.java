package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.text.Cue;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class y4 implements y3 {

    /* renamed from: a */
    public final List<Cue> f28300a;

    public y4(List<Cue> list) {
        this.f28300a = Collections.unmodifiableList(list);
    }

    @Override // com.vivo.google.android.exoplayer3.y3
    public int a() {
        return 1;
    }

    @Override // com.vivo.google.android.exoplayer3.y3
    public int a(long j2) {
        return j2 < 0 ? 0 : -1;
    }

    @Override // com.vivo.google.android.exoplayer3.y3
    public long a(int i2) {
        g1.a(i2 == 0);
        return 0L;
    }

    @Override // com.vivo.google.android.exoplayer3.y3
    public List<Cue> b(long j2) {
        return j2 >= 0 ? this.f28300a : Collections.emptyList();
    }
}
