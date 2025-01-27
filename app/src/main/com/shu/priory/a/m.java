package com.shu.priory.a;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public interface m {

    public static final class a implements m {
        @Override // com.shu.priory.a.m
        public void a(b bVar, OutputStream outputStream) throws IOException {
            outputStream.write(bVar.a());
        }
    }

    void a(b bVar, OutputStream outputStream) throws IOException;
}
