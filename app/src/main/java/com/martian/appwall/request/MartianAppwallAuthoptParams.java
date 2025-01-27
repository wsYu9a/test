package com.martian.appwall.request;

import com.martian.appwall.request.auth.MartianAppwallHttpPostParams;

/* loaded from: classes2.dex */
public abstract class MartianAppwallAuthoptParams extends MartianAppwallHttpPostParams {
    public abstract String getAuthMethod();

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        String authMethod = getAuthMethod();
        if (authMethod.startsWith("/")) {
            return "/authopt" + authMethod;
        }
        return "/authopt/" + authMethod;
    }
}
