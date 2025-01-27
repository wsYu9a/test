package com.martian.appwall.request;

import android.text.TextUtils;
import com.martian.appwall.request.auth.MartianAppwallHttpPostParams;

/* loaded from: classes3.dex */
public abstract class MartianAppwallAuthoptParams extends MartianAppwallHttpPostParams {
    public abstract String getAuthMethod();

    @Override // u8.b
    public String getRequestMethod() {
        String authMethod = getAuthMethod();
        if (TextUtils.isEmpty(authMethod) || !authMethod.startsWith("/")) {
            return "/authopt/" + authMethod;
        }
        return "/authopt" + authMethod;
    }
}
