package com.shu.priory.f.a;

import com.shu.priory.f.a.c;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes3.dex */
public class h extends c.AbstractC0555c {
    public h(f fVar, c.b bVar, long j10) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(bVar.f17043a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j11 = bVar.f17045c + (j10 * bVar.f17047e);
        this.f17052a = fVar.c(allocate, j11);
        this.f17053b = fVar.b(allocate, 8 + j11);
        this.f17054c = fVar.b(allocate, 16 + j11);
        this.f17055d = fVar.b(allocate, j11 + 40);
    }
}
