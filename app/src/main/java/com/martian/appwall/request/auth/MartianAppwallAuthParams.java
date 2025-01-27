package com.martian.appwall.request.auth;

import android.text.TextUtils;
import com.martian.appwall.request.MartianAppwallHttpGetParams;

/* loaded from: classes3.dex */
public abstract class MartianAppwallAuthParams extends MartianAppwallHttpGetParams {
    public abstract String getAuthMethod();

    @Override // u8.b
    public String getRequestMethod() {
        String authMethod = getAuthMethod();
        if (TextUtils.isEmpty(authMethod) || !authMethod.startsWith("/")) {
            return "/auth/" + authMethod;
        }
        return "/auth" + authMethod;
    }
}
