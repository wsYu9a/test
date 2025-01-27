package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.b;

/* loaded from: classes3.dex */
public final class ct {
    @InvokeBy(invokerClass = gc.class, methodId = "registerHolder")
    public static void Fe() {
        gc.Ff().put(b.a.class, new bl());
        gc.Ff().put(ImpInfo.class, new fj());
    }
}
