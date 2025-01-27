package com.shu.priory.f.a;

import com.shu.priory.f.a.c;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.UShort;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes3.dex */
public class f implements c, Closeable {

    /* renamed from: a */
    private final int f17059a = 1179403647;

    /* renamed from: b */
    private final FileChannel f17060b;

    public f(File file) throws FileNotFoundException {
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException("File is null or does not exist");
        }
        this.f17060b = new FileInputStream(file).getChannel();
    }

    private long a(c.b bVar, long j10, long j11) throws IOException {
        for (long j12 = 0; j12 < j10; j12++) {
            c.AbstractC0555c a10 = bVar.a(j12);
            if (a10.f17052a == 1) {
                long j13 = a10.f17054c;
                if (j13 <= j11 && j11 <= a10.f17055d + j13) {
                    return (j11 - j13) + a10.f17053b;
                }
            }
        }
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    public long b(ByteBuffer byteBuffer, long j10) throws IOException {
        a(byteBuffer, j10, 8);
        return byteBuffer.getLong();
    }

    public long c(ByteBuffer byteBuffer, long j10) throws IOException {
        a(byteBuffer, j10, 4);
        return byteBuffer.getInt() & 4294967295L;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f17060b.close();
    }

    public int d(ByteBuffer byteBuffer, long j10) throws IOException {
        a(byteBuffer, j10, 2);
        return byteBuffer.getShort() & UShort.MAX_VALUE;
    }

    public short e(ByteBuffer byteBuffer, long j10) throws IOException {
        a(byteBuffer, j10, 1);
        return (short) (byteBuffer.get() & 255);
    }

    public c.b a() throws IOException {
        this.f17060b.position(0L);
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (c(allocate, 0L) != 1179403647) {
            throw new IllegalArgumentException("Invalid ELF Magic!");
        }
        short e10 = e(allocate, 4L);
        boolean z10 = e(allocate, 5L) == 2;
        if (e10 == 1) {
            return new d(z10, this);
        }
        if (e10 == 2) {
            return new e(z10, this);
        }
        throw new IllegalStateException("Invalid class type!");
    }

    public List<String> b() throws IOException {
        long j10;
        this.f17060b.position(0L);
        ArrayList arrayList = new ArrayList();
        c.b a10 = a();
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(a10.f17043a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j11 = a10.f17048f;
        int i10 = 0;
        if (j11 == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            j11 = a10.a(0).f17056a;
        }
        long j12 = 0;
        while (true) {
            if (j12 >= j11) {
                j10 = 0;
                break;
            }
            c.AbstractC0555c a11 = a10.a(j12);
            if (a11.f17052a == 2) {
                j10 = a11.f17053b;
                break;
            }
            j12++;
        }
        if (j10 == 0) {
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        long j13 = 0;
        while (true) {
            c.a a12 = a10.a(j10, i10);
            long j14 = j10;
            long j15 = a12.f17041a;
            if (j15 == 1) {
                arrayList2.add(Long.valueOf(a12.f17042b));
            } else if (j15 == 5) {
                j13 = a12.f17042b;
            }
            i10++;
            if (a12.f17041a == 0) {
                break;
            }
            j10 = j14;
        }
        if (j13 == 0) {
            throw new IllegalStateException("String table offset not found!");
        }
        long a13 = a(a10, j11, j13);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.add(a(allocate, ((Long) it.next()).longValue() + a13));
        }
        return arrayList;
    }

    public String a(ByteBuffer byteBuffer, long j10) throws IOException {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            long j11 = 1 + j10;
            short e10 = e(byteBuffer, j10);
            if (e10 == 0) {
                return sb2.toString();
            }
            sb2.append((char) e10);
            j10 = j11;
        }
    }

    public void a(ByteBuffer byteBuffer, long j10, int i10) throws IOException {
        byteBuffer.position(0);
        byteBuffer.limit(i10);
        long j11 = 0;
        while (j11 < i10) {
            int read = this.f17060b.read(byteBuffer, j10 + j11);
            if (read == -1) {
                throw new EOFException();
            }
            j11 += read;
        }
        byteBuffer.position(0);
    }
}
