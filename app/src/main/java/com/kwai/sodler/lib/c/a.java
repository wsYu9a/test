package com.kwai.sodler.lib.c;

import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public final class a implements Comparable<a> {
    public String aKT;
    public boolean qy;
    public String version;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NonNull a aVar) {
        return aVar.version.compareTo(this.version);
    }
}
