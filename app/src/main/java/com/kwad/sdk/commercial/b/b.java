package com.kwad.sdk.commercial.b;

import com.ksad.json.annotation.KsJson;
import java.net.URL;

@KsJson
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String arD;
    public String arK;
    public String arL;
    public int arM;
    public int arN;
    public int status;
    public String url;

    public static b Ci() {
        return new b();
    }

    public final b cD(String str) {
        this.url = str;
        try {
            URL url = new URL(str);
            this.arD = url.getHost();
            this.arK = url.getPath();
        } catch (Throwable unused) {
        }
        return this;
    }

    public final b cE(String str) {
        this.arL = str;
        return this;
    }

    public final b cg(int i10) {
        this.status = i10;
        return this;
    }

    public final b ch(int i10) {
        this.arM = i10;
        return this;
    }

    public final b ci(int i10) {
        this.arN = i10;
        return this;
    }
}
