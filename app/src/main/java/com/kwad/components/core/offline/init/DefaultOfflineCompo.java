package com.kwad.components.core.offline.init;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.sdk.components.d;
import com.kwad.sdk.utils.ao;

/* loaded from: classes2.dex */
public abstract class DefaultOfflineCompo extends d implements IOfflineCompo {
    private final IOfflineCompo mOfflineComponents;

    public DefaultOfflineCompo(@NonNull IOfflineCompo iOfflineCompo) {
        ao.checkNotNull(iOfflineCompo);
        this.mOfflineComponents = iOfflineCompo;
    }

    @Override // com.kwad.sdk.components.a
    public void init(Context context) {
        this.mOfflineComponents.init(context);
    }

    @Override // com.kwad.sdk.components.d, com.kwad.sdk.components.a
    public int priority() {
        return this.mOfflineComponents.priority();
    }
}
