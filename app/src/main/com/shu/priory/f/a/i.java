package com.shu.priory.f.a;

import com.shu.priory.f.a.c;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes3.dex */
public class i extends c.d {
    public i(f fVar, c.b bVar, int i10) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(bVar.f17043a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f17056a = fVar.c(allocate, bVar.f17046d + (i10 * bVar.f17049g) + 28);
    }
}
