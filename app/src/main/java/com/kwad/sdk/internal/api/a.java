package com.kwad.sdk.internal.api;

import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;

@KsJson
/* loaded from: classes2.dex */
public class a extends com.kwad.sdk.core.response.kwai.a {
    public int aaM;
    public int aaN;
    public String aaO;
    public String aaP;
    public String aaQ;
    public String aaR;
    public String aaS;
    public long aaT;

    public final boolean AA() {
        return this.aaM == 0 && this.aaN == 0 && TextUtils.isEmpty(this.aaO);
    }

    public final boolean AB() {
        return TextUtils.isEmpty(this.aaP) && TextUtils.isEmpty(this.aaQ) && TextUtils.isEmpty(this.aaS) && TextUtils.isEmpty(this.aaR);
    }
}
