package com.vivo.google.android.exoplayer3.upstream;

import android.net.Uri;
import com.vivo.google.android.exoplayer3.q5;

/* loaded from: classes4.dex */
public interface DataSource {

    public interface Factory {
        DataSource createDataSource();
    }

    void close();

    Uri getUri();

    long open(q5 q5Var);

    int read(byte[] bArr, int i2, int i3);
}
