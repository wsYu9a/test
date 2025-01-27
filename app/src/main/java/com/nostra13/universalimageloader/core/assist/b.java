package com.nostra13.universalimageloader.core.assist;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public class b extends FilterInputStream {
    public b(InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j2) throws IOException {
        long j3 = 0;
        while (j3 < j2) {
            long skip = ((FilterInputStream) this).in.skip(j2 - j3);
            if (skip == 0) {
                if (read() < 0) {
                    break;
                }
                skip = 1;
            }
            j3 += skip;
        }
        return j3;
    }
}
