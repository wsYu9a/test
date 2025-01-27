package com.shu.priory.f.a;

import com.shu.priory.f.a.c;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes3.dex */
public class e extends c.b {

    /* renamed from: j */
    private final f f17058j;

    public e(boolean z10, f fVar) throws IOException {
        this.f17043a = z10;
        this.f17058j = fVar;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(z10 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f17044b = fVar.d(allocate, 16L);
        this.f17045c = fVar.b(allocate, 32L);
        this.f17046d = fVar.b(allocate, 40L);
        this.f17047e = fVar.d(allocate, 54L);
        this.f17048f = fVar.d(allocate, 56L);
        this.f17049g = fVar.d(allocate, 58L);
        this.f17050h = fVar.d(allocate, 60L);
        this.f17051i = fVar.d(allocate, 62L);
    }

    @Override // com.shu.priory.f.a.c.b
    public c.a a(long j10, int i10) throws IOException {
        return new b(this.f17058j, this, j10, i10);
    }

    @Override // com.shu.priory.f.a.c.b
    public c.AbstractC0555c a(long j10) throws IOException {
        return new h(this.f17058j, this, j10);
    }

    @Override // com.shu.priory.f.a.c.b
    public c.d a(int i10) throws IOException {
        return new j(this.f17058j, this, i10);
    }
}
