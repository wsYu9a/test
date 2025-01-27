package com.kwad.components.offline.api.core.network.adapter;

import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.sdk.core.network.o;

/* loaded from: classes2.dex */
public abstract class NormalRequestAdapter<R extends IOfflineCompoRequest> implements o {
    public abstract R getOfflineCompoRequest();
}
