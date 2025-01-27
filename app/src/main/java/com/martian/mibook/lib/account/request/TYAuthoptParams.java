package com.martian.mibook.lib.account.request;

/* loaded from: classes.dex */
public abstract class TYAuthoptParams extends TYHttpGetParams {
    public abstract String getAuthoptMethod();

    @Override // com.martian.libcomm.http.requests.b
    public String getRequestMethod() {
        String authoptMethod = getAuthoptMethod();
        if (authoptMethod.startsWith("/")) {
            return "authopt" + authoptMethod;
        }
        return "authopt/" + authoptMethod;
    }
}
