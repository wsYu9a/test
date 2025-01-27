package com.kwad.sdk.commercial.g;

import com.ksad.json.annotation.KsJson;
import java.net.URL;

@KsJson
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public int Qq;
    public String arD;
    public String arK;
    public int status;
    public String url;

    public static b Cn() {
        return new b();
    }

    public final b cN(String str) {
        this.url = str;
        try {
            URL url = new URL(str);
            this.arD = url.getHost();
            this.arK = url.getPath();
        } catch (Throwable unused) {
        }
        return this;
    }

    public final b cl(int i10) {
        this.status = i10;
        return this;
    }

    public final b cm(int i10) {
        this.Qq = i10;
        return this;
    }
}
