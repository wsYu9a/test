package com.kwad.components.core.o;

import com.kwad.sdk.api.core.SpeedLimitApi;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class a implements SpeedLimitApi {
    @Override // com.kwad.sdk.api.core.SpeedLimitApi
    public InputStream wrapInputStream(InputStream inputStream) {
        b.pm();
        return b.wrapInputStream(inputStream);
    }
}
