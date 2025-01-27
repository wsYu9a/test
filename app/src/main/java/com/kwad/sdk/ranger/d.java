package com.kwad.sdk.ranger;

import com.ksad.json.annotation.KsJson;
import java.util.List;

@KsJson
/* loaded from: classes2.dex */
public class d extends com.kwad.sdk.core.response.kwai.a {
    public long axS;
    public List<String> axT;
    public List<a> axU;
    public long axV = 1000;
    public double axW = 1.0d;
    public List<com.kwad.sdk.ranger.kwai.a> axX;

    @KsJson
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public String axY;
        public String axZ;
    }

    private boolean cd(int i2) {
        return (Cm() || (this.axS & ((long) i2)) == 0) ? false : true;
    }

    public final boolean Cm() {
        return (this.axS & 1) == 0;
    }

    public final boolean Cn() {
        return cd(2);
    }

    public final boolean Co() {
        return cd(4);
    }

    public final boolean Cp() {
        return cd(16);
    }
}
