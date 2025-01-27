package com.kwad.components.offline.b;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.obiwan.IObiwanLogcat;
import com.kwad.components.offline.api.obiwan.IObiwanOfflineCompo;

/* loaded from: classes3.dex */
public class a implements com.kwad.components.core.n.a.c.a {
    private final IObiwanOfflineCompo afQ;

    public a(@NonNull IObiwanOfflineCompo iObiwanOfflineCompo) {
        this.afQ = iObiwanOfflineCompo;
    }

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return a.class;
    }

    public final IObiwanLogcat getLog() {
        return this.afQ.getLog();
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.b
    public final int priority() {
        return this.afQ.priority();
    }

    public final void updateConfigs() {
        this.afQ.updateConfigs();
    }
}
