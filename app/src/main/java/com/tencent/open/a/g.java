package com.tencent.open.a;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class g implements Iterable<String> {

    /* renamed from: a */
    private ConcurrentLinkedQueue<String> f23168a;

    /* renamed from: b */
    private AtomicInteger f23169b;

    public g() {
        this.f23168a = null;
        this.f23169b = null;
        this.f23168a = new ConcurrentLinkedQueue<>();
        this.f23169b = new AtomicInteger(0);
    }

    public int a(String str) {
        int length = str.length();
        this.f23168a.add(str);
        return this.f23169b.addAndGet(length);
    }

    public void b() {
        this.f23168a.clear();
        this.f23169b.set(0);
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return this.f23168a.iterator();
    }

    public void a(Writer writer, char[] cArr) throws IOException {
        if (writer == null || cArr == null || cArr.length == 0) {
            return;
        }
        int length = cArr.length;
        Iterator<String> it = iterator();
        int i10 = length;
        int i11 = 0;
        while (it.hasNext()) {
            String next = it.next();
            int length2 = next.length();
            int i12 = 0;
            while (length2 > 0) {
                int i13 = i10 > length2 ? length2 : i10;
                int i14 = i12 + i13;
                next.getChars(i12, i14, cArr, i11);
                i10 -= i13;
                i11 += i13;
                length2 -= i13;
                if (i10 == 0) {
                    writer.write(cArr, 0, length);
                    i10 = length;
                    i12 = i14;
                    i11 = 0;
                } else {
                    i12 = i14;
                }
            }
        }
        if (i11 > 0) {
            writer.write(cArr, 0, i11);
        }
        writer.flush();
    }

    public int a() {
        return this.f23169b.get();
    }
}
