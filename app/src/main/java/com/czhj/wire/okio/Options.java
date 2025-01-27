package com.czhj.wire.okio;

import java.util.AbstractList;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class Options extends AbstractList<ByteString> implements RandomAccess {

    /* renamed from: a */
    public final ByteString[] f8943a;

    public Options(ByteString[] byteStringArr) {
        this.f8943a = byteStringArr;
    }

    public static Options of(ByteString... byteStringArr) {
        return new Options((ByteString[]) byteStringArr.clone());
    }

    @Override // java.util.AbstractList, java.util.List
    public ByteString get(int i10) {
        return this.f8943a[i10];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f8943a.length;
    }
}
