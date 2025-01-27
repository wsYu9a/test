package com.shu.priory.f.a;

import com.shu.priory.f.a.c;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes3.dex */
public class d extends c.b {

    /* renamed from: j */
    private final f f17057j;

    public d(boolean z10, f fVar) throws IOException {
        this.f17043a = z10;
        this.f17057j = fVar;
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(z10 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f17044b = fVar.d(allocate, 16L);
        this.f17045c = fVar.c(allocate, 28L);
        this.f17046d = fVar.c(allocate, 32L);
        this.f17047e = fVar.d(allocate, 42L);
        this.f17048f = fVar.d(allocate, 44L);
        this.f17049g = fVar.d(allocate, 46L);
        this.f17050h = fVar.d(allocate, 48L);
        this.f17051i = fVar.d(allocate, 50L);
    }

    @Override // com.shu.priory.f.a.c.b
    public c.a a(long j10, int i10) throws IOException {
        return new a(this.f17057j, this, j10, i10);
    }

    @Override // com.shu.priory.f.a.c.b
    public c.AbstractC0555c a(long j10) throws IOException {
        return new g(this.f17057j, this, j10);
    }

    @Override // com.shu.priory.f.a.c.b
    public c.d a(int i10) throws IOException {
        return new i(this.f17057j, this, i10);
    }
}
