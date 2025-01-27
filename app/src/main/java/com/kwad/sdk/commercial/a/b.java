package com.kwad.sdk.commercial.a;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.net.URL;

@KsJson
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String arD;
    public String arE;
    public String arF;
    public long arG;
    public long arH;
    public int arI;
    public int arJ;
    public String downloadId;
    public long downloadTime;
    public int status;
    public String url;

    public static b Ch() {
        return new b();
    }

    public final b al(long j10) {
        this.downloadTime = j10;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: bi */
    public final b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        AdInfo eb2 = e.eb(adTemplate);
        this.url = e.ee(adTemplate);
        try {
            this.arD = new URL(this.url).getHost();
        } catch (Throwable unused) {
        }
        this.downloadId = eb2.downloadId;
        AdInfo.AdBaseInfo adBaseInfo = eb2.adBaseInfo;
        this.arE = adBaseInfo.appPackageName;
        this.arF = adBaseInfo.appName;
        this.arG = eb2.totalBytes;
        this.arH = eb2.soFarBytes;
        return this;
    }

    public final b cd(int i10) {
        this.status = i10;
        return this;
    }

    public final b ce(int i10) {
        this.arI = i10;
        return this;
    }

    public final b cf(int i10) {
        this.arJ = i10;
        return this;
    }
}
