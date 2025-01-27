package androidx.media3.common;

import androidx.media3.common.util.UnstableApi;
import java.io.IOException;

@UnstableApi
/* loaded from: classes.dex */
public interface DataReader {
    int read(byte[] bArr, int i10, int i11) throws IOException;
}
