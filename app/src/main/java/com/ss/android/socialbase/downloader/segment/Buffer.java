package com.ss.android.socialbase.downloader.segment;

/* loaded from: classes4.dex */
public final class Buffer {
    public final byte[] data;
    public Buffer next;
    IOutput output;
    public int size;

    public Buffer(int i10) {
        this.data = new byte[i10];
    }
}
