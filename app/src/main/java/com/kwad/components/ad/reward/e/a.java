package com.kwad.components.ad.reward.e;

/* loaded from: classes2.dex */
public abstract class a implements g {
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(g gVar) {
        return getPriority() - gVar.getPriority();
    }

    @Override // com.kwad.components.ad.reward.e.g
    public int getPriority() {
        return 0;
    }
}
