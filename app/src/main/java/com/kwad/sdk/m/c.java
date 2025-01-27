package com.kwad.sdk.m;

import com.ksad.json.annotation.KsJson;
import java.util.List;

@KsJson
/* loaded from: classes3.dex */
public class c extends com.kwad.sdk.core.response.a.a {
    public List<String> aRD;
    public List<a> aRE;
    public List<com.kwad.sdk.m.a.a> aRF;
    public long funcSwitch;
    public long byteCount = 1000;
    public double sampleRate = 1.0d;

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public String aRG;
        public String aRH;
    }

    private boolean eb(int i10) {
        return (Mo() || (this.funcSwitch & ((long) i10)) == 0) ? false : true;
    }

    public final boolean Mo() {
        return (this.funcSwitch & 1) == 0;
    }

    public final boolean Mp() {
        return eb(4);
    }

    public final boolean Mq() {
        return eb(16);
    }
}
