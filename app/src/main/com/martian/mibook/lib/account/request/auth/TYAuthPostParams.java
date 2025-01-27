package com.martian.mibook.lib.account.request.auth;

import com.martian.mibook.lib.account.request.TYHttpPostParams;
import x2.b;

/* loaded from: classes3.dex */
public abstract class TYAuthPostParams extends TYHttpPostParams {
    public abstract String getAuthMethod();

    @Override // u8.b
    public String getRequestMethod() {
        String authMethod = getAuthMethod();
        if (authMethod.startsWith("/")) {
            return b.f31793n + authMethod;
        }
        return "auth/" + authMethod;
    }
}
