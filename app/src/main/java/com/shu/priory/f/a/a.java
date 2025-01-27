package com.shu.priory.f.a;

import com.shu.priory.f.a.c;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes3.dex */
public class a extends c.a {
    public a(f fVar, c.b bVar, long j10, int i10) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(bVar.f17043a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j11 = j10 + (i10 * 8);
        this.f17041a = fVar.c(allocate, j11);
        this.f17042b = fVar.c(allocate, j11 + 4);
    }
}
