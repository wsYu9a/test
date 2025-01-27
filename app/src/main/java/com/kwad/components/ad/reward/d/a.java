package com.kwad.components.ad.reward.d;

/* loaded from: classes.dex */
public abstract class a implements f {
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        return getPriority() - fVar.getPriority();
    }

    @Override // com.kwad.components.ad.reward.d.f
    public int getPriority() {
        return 0;
    }
}
