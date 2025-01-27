package com.opos.exoplayer.core.i;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes4.dex */
final class x implements g {

    /* renamed from: a */
    private final Handler f19088a;

    public x(Handler handler) {
        this.f19088a = handler;
    }

    @Override // com.opos.exoplayer.core.i.g
    public Looper a() {
        return this.f19088a.getLooper();
    }

    @Override // com.opos.exoplayer.core.i.g
    public Message a(int i2, int i3, int i4) {
        return this.f19088a.obtainMessage(i2, i3, i4);
    }

    @Override // com.opos.exoplayer.core.i.g
    public Message a(int i2, int i3, int i4, Object obj) {
        return this.f19088a.obtainMessage(i2, i3, i4, obj);
    }

    @Override // com.opos.exoplayer.core.i.g
    public Message a(int i2, Object obj) {
        return this.f19088a.obtainMessage(i2, obj);
    }

    @Override // com.opos.exoplayer.core.i.g
    public boolean a(int i2) {
        return this.f19088a.sendEmptyMessage(i2);
    }

    @Override // com.opos.exoplayer.core.i.g
    public boolean a(int i2, long j2) {
        return this.f19088a.sendEmptyMessageAtTime(i2, j2);
    }

    @Override // com.opos.exoplayer.core.i.g
    public void b(int i2) {
        this.f19088a.removeMessages(i2);
    }
}
