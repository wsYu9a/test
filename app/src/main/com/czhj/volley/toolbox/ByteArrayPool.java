package com.czhj.volley.toolbox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes2.dex */
public class ByteArrayPool {
    protected static final Comparator<byte[]> BUF_COMPARATOR = new Comparator<byte[]>() { // from class: com.czhj.volley.toolbox.ByteArrayPool.1
        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    };

    /* renamed from: c, reason: collision with root package name */
    public final int f8756c;

    /* renamed from: a, reason: collision with root package name */
    public final List<byte[]> f8754a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final List<byte[]> f8755b = new ArrayList(64);

    /* renamed from: d, reason: collision with root package name */
    public int f8757d = 0;

    public ByteArrayPool(int i10) {
        this.f8756c = i10;
    }

    public final synchronized void a() {
        while (this.f8757d > this.f8756c) {
            byte[] remove = this.f8754a.remove(0);
            this.f8755b.remove(remove);
            this.f8757d -= remove.length;
        }
    }

    public synchronized byte[] getBuf(int i10) {
        for (int i11 = 0; i11 < this.f8755b.size(); i11++) {
            byte[] bArr = this.f8755b.get(i11);
            if (bArr.length >= i10) {
                this.f8757d -= bArr.length;
                this.f8755b.remove(i11);
                this.f8754a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i10];
    }

    public synchronized void returnBuf(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f8756c) {
                this.f8754a.add(bArr);
                int binarySearch = Collections.binarySearch(this.f8755b, bArr, BUF_COMPARATOR);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f8755b.add(binarySearch, bArr);
                this.f8757d += bArr.length;
                a();
            }
        }
    }
}
