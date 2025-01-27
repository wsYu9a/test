package com.czhj.sdk.common.network;

import com.czhj.volley.toolbox.HurlStack;

/* loaded from: classes2.dex */
class PlayServicesUrlRewriter implements HurlStack.UrlRewriter {

    /* renamed from: a */
    public static final String f8548a = "mp_tmpl_advertising_id";

    /* renamed from: b */
    public static final String f8549b = "mp_tmpl_do_not_track";

    @Override // com.czhj.volley.toolbox.HurlStack.UrlRewriter
    public String rewriteUrl(String str) {
        if (!str.contains(f8548a)) {
            str.contains(f8549b);
        }
        return str;
    }
}
