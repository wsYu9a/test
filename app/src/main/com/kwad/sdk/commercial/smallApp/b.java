package com.kwad.sdk.commercial.smallApp;

import com.ksad.json.annotation.KsJson;
import java.net.URL;

@KsJson
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String arD;
    public String arK;
    public String ash;
    public String asi;
    public String asj;
    public int status;
    public String url;

    private b(JumpFrom jumpFrom) {
        if (jumpFrom != null) {
            this.asj = jumpFrom.getValue();
        }
    }

    public static b a(JumpFrom jumpFrom) {
        return new b(jumpFrom);
    }

    public final b cT(String str) {
        this.url = str;
        try {
            URL url = new URL(str);
            this.arD = url.getHost();
            this.arK = url.getPath();
        } catch (Throwable unused) {
        }
        return this;
    }

    public final b cU(String str) {
        this.ash = str;
        return this;
    }

    public final b cV(String str) {
        this.asi = str;
        return this;
    }

    public final b cn(int i10) {
        this.status = i10;
        return this;
    }
}
