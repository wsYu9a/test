package com.kwad.components.core.n.b.a;

import com.kwad.components.offline.api.core.api.IZipper;
import com.kwad.sdk.utils.cb;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes3.dex */
final class q implements IZipper {
    @Override // com.kwad.components.offline.api.core.api.IZipper
    public final boolean unZip(InputStream inputStream, String str) {
        return cb.unZip(inputStream, str);
    }

    @Override // com.kwad.components.offline.api.core.api.IZipper
    public final boolean zip(File file, File file2) {
        return cb.zip(file, file2);
    }

    @Override // com.kwad.components.offline.api.core.api.IZipper
    public final void zipFile(File file) {
        cb.zipFile(file);
    }
}
