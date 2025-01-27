package com.martian.mibook.lib.account.request.auth;

import com.martian.mibook.lib.account.request.TYHttpGetParams;

/* loaded from: classes3.dex */
public abstract class TYAuthParams extends TYHttpGetParams {
    public abstract String getAuthMethod();

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        String authMethod = getAuthMethod();
        if (authMethod.startsWith("/")) {
            return "auth" + authMethod;
        }
        return "auth/" + authMethod;
    }
}
