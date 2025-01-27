package com.martian.mibook.lib.account.request.auth;

import com.martian.mibook.lib.account.request.TYHttpPostParams;

/* loaded from: classes.dex */
public abstract class TYAuthPostParams extends TYHttpPostParams {
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
