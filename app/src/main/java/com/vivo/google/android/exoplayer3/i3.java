package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.metadata.Metadata;
import com.vivo.google.android.exoplayer3.metadata.emsg.EventMessage;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class i3 implements f3 {
    @Override // com.vivo.google.android.exoplayer3.f3
    public Metadata a(h3 h3Var) {
        ByteBuffer byteBuffer = h3Var.f28192c;
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        n6 n6Var = new n6(array, limit);
        String j2 = n6Var.j();
        String j3 = n6Var.j();
        long m = n6Var.m();
        n6Var.e(4);
        return new Metadata(new EventMessage(j2, j3, (n6Var.m() * 1000) / m, n6Var.m(), Arrays.copyOfRange(array, n6Var.f27875b, limit)));
    }
}
