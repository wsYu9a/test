package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.metadata.Metadata;
import com.vivo.google.android.exoplayer3.metadata.scte35.PrivateCommand;
import com.vivo.google.android.exoplayer3.metadata.scte35.SpliceInsertCommand;
import com.vivo.google.android.exoplayer3.metadata.scte35.SpliceNullCommand;
import com.vivo.google.android.exoplayer3.metadata.scte35.SpliceScheduleCommand;
import com.vivo.google.android.exoplayer3.metadata.scte35.TimeSignalCommand;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class k3 implements f3 {

    /* renamed from: a */
    public final n6 f27574a = new n6();

    /* renamed from: b */
    public final m6 f27575b = new m6();

    /* renamed from: c */
    public u6 f27576c;

    @Override // com.vivo.google.android.exoplayer3.f3
    public Metadata a(h3 h3Var) {
        u6 u6Var = this.f27576c;
        if (u6Var == null || h3Var.f27479f != u6Var.a()) {
            u6 u6Var2 = new u6(h3Var.f28193d);
            this.f27576c = u6Var2;
            u6Var2.a(h3Var.f28193d - h3Var.f27479f);
        }
        ByteBuffer byteBuffer = h3Var.f28192c;
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.f27574a.a(array, limit);
        m6 m6Var = this.f27575b;
        m6Var.f27770a = array;
        m6Var.f27771b = 0;
        m6Var.f27772c = 0;
        m6Var.f27773d = limit;
        m6Var.c(39);
        long a2 = (this.f27575b.a(1) << 32) | this.f27575b.a(32);
        this.f27575b.c(20);
        int a3 = this.f27575b.a(12);
        int a4 = this.f27575b.a(8);
        Metadata.Entry entry = null;
        this.f27574a.e(14);
        if (a4 == 0) {
            entry = new SpliceNullCommand();
        } else if (a4 == 255) {
            entry = PrivateCommand.a(this.f27574a, a3, a2);
        } else if (a4 == 4) {
            entry = SpliceScheduleCommand.a(this.f27574a);
        } else if (a4 == 5) {
            entry = SpliceInsertCommand.a(this.f27574a, a2, this.f27576c);
        } else if (a4 == 6) {
            n6 n6Var = this.f27574a;
            u6 u6Var3 = this.f27576c;
            long a5 = TimeSignalCommand.a(n6Var, a2);
            entry = new TimeSignalCommand(a5, u6Var3.b(a5));
        }
        return entry == null ? new Metadata(new Metadata.Entry[0]) : new Metadata(entry);
    }
}
