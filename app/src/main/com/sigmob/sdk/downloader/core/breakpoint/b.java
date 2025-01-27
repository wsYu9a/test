package com.sigmob.sdk.downloader.core.breakpoint;

import android.database.Cursor;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    public final int f19001a;

    /* renamed from: b */
    public final long f19002b;

    /* renamed from: c */
    public final long f19003c;

    /* renamed from: d */
    public final long f19004d;

    public b(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex(f.f19046h);
        this.f19001a = columnIndex >= 0 ? cursor.getInt(columnIndex) : 0;
        this.f19002b = cursor.getColumnIndex(f.f19048j) >= 0 ? cursor.getInt(r0) : 0L;
        this.f19003c = cursor.getColumnIndex(f.f19049k) >= 0 ? cursor.getInt(r0) : 0L;
        this.f19004d = cursor.getColumnIndex(f.f19050l) >= 0 ? cursor.getInt(r0) : 0L;
    }

    public int a() {
        return this.f19001a;
    }

    public long b() {
        return this.f19003c;
    }

    public long c() {
        return this.f19004d;
    }

    public long d() {
        return this.f19002b;
    }

    public a e() {
        return new a(this.f19002b, this.f19003c, this.f19004d);
    }
}
