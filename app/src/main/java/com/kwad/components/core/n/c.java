package com.kwad.components.core.n;

import androidx.annotation.NonNull;
import com.kwad.components.core.response.model.AdResultData;

/* loaded from: classes2.dex */
public class c extends b {
    @Override // com.kwad.components.core.n.b
    public void a(int i2, String str, boolean z) {
        onError(i2, str);
    }

    @Override // com.kwad.components.core.n.i
    public void a(@NonNull AdResultData adResultData) {
    }

    @Override // com.kwad.components.core.n.b
    public void a(@NonNull AdResultData adResultData, boolean z) {
        a(adResultData);
    }

    @Override // com.kwad.components.core.n.i
    public void onError(int i2, String str) {
    }
}
