package com.kwad.components.core.offline.init.kwai;

import com.kwad.components.offline.api.core.api.IEncrypt;
import com.kwad.sdk.utils.ad;
import java.io.File;
import java.io.IOException;

/* loaded from: classes2.dex */
final class c implements IEncrypt {
    c() {
    }

    @Override // com.kwad.components.offline.api.core.api.IEncrypt
    public final String getFileMD5(File file) {
        return com.kwad.sdk.utils.a.getFileMD5(file);
    }

    @Override // com.kwad.components.offline.api.core.api.IEncrypt
    public final byte[] getFileMD5Digest(File file) {
        try {
            return com.kwad.sdk.utils.a.getFileMD5Digest(file);
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // com.kwad.components.offline.api.core.api.IEncrypt
    public final String getMD5(String str) {
        return ad.eC(str);
    }

    @Override // com.kwad.components.offline.api.core.api.IEncrypt
    public final String getResponseData(String str) {
        return com.kwad.sdk.core.kwai.d.getResponseData(str);
    }
}
