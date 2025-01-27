package com.martian.mibook.lib.account.request;

/* loaded from: classes3.dex */
public abstract class TYAuthoptParams extends TYHttpGetParams {
    public abstract String getAuthoptMethod();

    @Override // u8.b
    public String getRequestMethod() {
        String authoptMethod = getAuthoptMethod();
        if (authoptMethod.startsWith("/")) {
            return "authopt" + authoptMethod;
        }
        return "authopt/" + authoptMethod;
    }
}
