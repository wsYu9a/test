package com.opos.exoplayer.core.metadata.scte35;

import com.opos.exoplayer.core.i.l;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.s;
import com.opos.exoplayer.core.metadata.Metadata;
import com.opos.exoplayer.core.metadata.d;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class a implements com.opos.exoplayer.core.metadata.a {

    /* renamed from: a */
    private final m f19181a = new m();

    /* renamed from: b */
    private final l f19182b = new l();

    /* renamed from: c */
    private s f19183c;

    @Override // com.opos.exoplayer.core.metadata.a
    public Metadata a(d dVar) {
        s sVar = this.f19183c;
        if (sVar == null || dVar.f19097d != sVar.c()) {
            s sVar2 = new s(dVar.f17740c);
            this.f19183c = sVar2;
            sVar2.c(dVar.f17740c - dVar.f19097d);
        }
        ByteBuffer byteBuffer = dVar.f17739b;
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.f19181a.a(array, limit);
        this.f19182b.a(array, limit);
        this.f19182b.b(39);
        long c2 = (this.f19182b.c(1) << 32) | this.f19182b.c(32);
        this.f19182b.b(20);
        int c3 = this.f19182b.c(12);
        int c4 = this.f19182b.c(8);
        this.f19181a.d(14);
        Metadata.Entry a2 = c4 != 0 ? c4 != 255 ? c4 != 4 ? c4 != 5 ? c4 != 6 ? null : TimeSignalCommand.a(this.f19181a, c2, this.f19183c) : SpliceInsertCommand.a(this.f19181a, c2, this.f19183c) : SpliceScheduleCommand.a(this.f19181a) : PrivateCommand.a(this.f19181a, c3, c2) : new SpliceNullCommand();
        return a2 == null ? new Metadata(new Metadata.Entry[0]) : new Metadata(a2);
    }
}
