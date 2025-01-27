package com.kwad.sdk.ranger;

import okhttp3.EventListener;

/* loaded from: classes2.dex */
public class c implements EventListener.Factory {
    public static final String TAG = "Ranger_" + c.class.getSimpleName();
    EventListener axQ;
    a axR;

    public interface a {
    }

    public c(Object obj, a aVar) {
        this.axQ = (EventListener) obj;
        this.axR = aVar;
    }
}
