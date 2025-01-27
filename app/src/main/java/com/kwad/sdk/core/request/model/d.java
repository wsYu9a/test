package com.kwad.sdk.core.request.model;

import android.content.Context;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.ba;

@KsJson
/* loaded from: classes3.dex */
public class d extends com.kwad.sdk.core.response.a.a {
    public String aDR;
    public String aDS;
    public int aDT;
    public int aDU;

    public static d GJ() {
        d dVar = new d();
        try {
            Context MA = ServiceProvider.MA();
            dVar.aDR = ba.cP(MA);
            dVar.aDS = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).zF();
            dVar.aDT = al.cC(MA);
            dVar.aDU = al.d(MA, ba.cS(MA), az.Ok());
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
        return dVar;
    }

    public static d GK() {
        d dVar = new d();
        dVar.aDT = al.cC(ServiceProvider.getContext());
        return dVar;
    }
}
