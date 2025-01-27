package com.martian.appwall.request.auth;

import com.martian.appwall.request.MartianAppwallHttpGetParams;

/* loaded from: classes2.dex */
public abstract class MartianAppwallAuthParams extends MartianAppwallHttpGetParams {
    public abstract String getAuthMethod();

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        String authMethod = getAuthMethod();
        if (authMethod.startsWith("/")) {
            return "/auth" + authMethod;
        }
        return "/auth/" + authMethod;
    }
}
