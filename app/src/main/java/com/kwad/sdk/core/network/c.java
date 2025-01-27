package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public final class c {
    public int azs = -1;
    public Exception azt;
    public String azu;
    public int code;

    public final boolean Fr() {
        return this.code == 200;
    }

    @NonNull
    public final String toString() {
        return "BaseResponse{code=" + this.code + ", rawCode=" + this.azs + ", rawException=" + this.azt + ", body='" + this.azu + "'}";
    }
}
