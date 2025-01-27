package com.bytedance.pangle.e;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.protocol.HTTP;

/* loaded from: classes.dex */
public final class h implements Closeable {

    /* renamed from: a */
    private final FileInputStream f6061a;

    /* renamed from: b */
    private a f6062b;

    /* renamed from: c */
    private b[] f6063c;

    /* renamed from: d */
    private c[] f6064d;

    /* renamed from: e */
    private final Map<String, c> f6065e = new HashMap();

    static class a {

        /* renamed from: a */
        public final byte[] f6066a;

        /* renamed from: b */
        public final short f6067b;

        /* renamed from: c */
        public final short f6068c;

        /* renamed from: d */
        public final int f6069d;

        /* renamed from: e */
        public final long f6070e;

        /* renamed from: f */
        public final long f6071f;

        /* renamed from: g */
        public final long f6072g;

        /* renamed from: h */
        public final int f6073h;

        /* renamed from: i */
        public final short f6074i;

        /* renamed from: j */
        public final short f6075j;
        public final short k;
        public final short l;
        public final short m;
        public final short n;

        /* synthetic */ a(FileChannel fileChannel, byte b2) {
            this(fileChannel);
        }

        private a(FileChannel fileChannel) {
            byte[] bArr = new byte[16];
            this.f6066a = bArr;
            fileChannel.position(0L);
            fileChannel.read(ByteBuffer.wrap(bArr));
            if (bArr[0] != Byte.MAX_VALUE || bArr[1] != 69 || bArr[2] != 76 || bArr[3] != 70) {
                throw new IOException(String.format("bad elf magic: %x %x %x %x.", Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3])));
            }
            h.a(bArr[4], 2, "bad elf class: " + ((int) bArr[4]));
            h.a(bArr[5], 2, "bad elf data encoding: " + ((int) bArr[5]));
            ByteBuffer allocate = ByteBuffer.allocate(bArr[4] == 1 ? 36 : 48);
            allocate.order(bArr[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
            h.b(fileChannel, allocate, "failed to read rest part of ehdr.");
            this.f6067b = allocate.getShort();
            this.f6068c = allocate.getShort();
            int i2 = allocate.getInt();
            this.f6069d = i2;
            h.a(i2, 1, "bad elf version: " + i2);
            byte b2 = bArr[4];
            if (b2 == 1) {
                this.f6070e = allocate.getInt();
                this.f6071f = allocate.getInt();
                this.f6072g = allocate.getInt();
            } else {
                if (b2 != 2) {
                    throw new IOException("Unexpected elf class: " + ((int) bArr[4]));
                }
                this.f6070e = allocate.getLong();
                this.f6071f = allocate.getLong();
                this.f6072g = allocate.getLong();
            }
            this.f6073h = allocate.getInt();
            this.f6074i = allocate.getShort();
            this.f6075j = allocate.getShort();
            this.k = allocate.getShort();
            this.l = allocate.getShort();
            this.m = allocate.getShort();
            this.n = allocate.getShort();
        }
    }

    static class b {

        /* renamed from: a */
        public final int f6076a;

        /* renamed from: b */
        public final int f6077b;

        /* renamed from: c */
        public final long f6078c;

        /* renamed from: d */
        public final long f6079d;

        /* renamed from: e */
        public final long f6080e;

        /* renamed from: f */
        public final long f6081f;

        /* renamed from: g */
        public final long f6082g;

        /* renamed from: h */
        public final long f6083h;

        /* synthetic */ b(ByteBuffer byteBuffer, int i2, byte b2) {
            this(byteBuffer, i2);
        }

        private b(ByteBuffer byteBuffer, int i2) {
            if (i2 == 1) {
                this.f6076a = byteBuffer.getInt();
                this.f6078c = byteBuffer.getInt();
                this.f6079d = byteBuffer.getInt();
                this.f6080e = byteBuffer.getInt();
                this.f6081f = byteBuffer.getInt();
                this.f6082g = byteBuffer.getInt();
                this.f6077b = byteBuffer.getInt();
                this.f6083h = byteBuffer.getInt();
                return;
            }
            if (i2 != 2) {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i2)));
            }
            this.f6076a = byteBuffer.getInt();
            this.f6077b = byteBuffer.getInt();
            this.f6078c = byteBuffer.getLong();
            this.f6079d = byteBuffer.getLong();
            this.f6080e = byteBuffer.getLong();
            this.f6081f = byteBuffer.getLong();
            this.f6082g = byteBuffer.getLong();
            this.f6083h = byteBuffer.getLong();
        }
    }

    static class c {

        /* renamed from: a */
        public final int f6084a;

        /* renamed from: b */
        public final int f6085b;

        /* renamed from: c */
        public final long f6086c;

        /* renamed from: d */
        public final long f6087d;

        /* renamed from: e */
        public final long f6088e;

        /* renamed from: f */
        public final long f6089f;

        /* renamed from: g */
        public final int f6090g;

        /* renamed from: h */
        public final int f6091h;

        /* renamed from: i */
        public final long f6092i;

        /* renamed from: j */
        public final long f6093j;
        public String k;

        /* synthetic */ c(ByteBuffer byteBuffer, int i2, byte b2) {
            this(byteBuffer, i2);
        }

        private c(ByteBuffer byteBuffer, int i2) {
            if (i2 == 1) {
                this.f6084a = byteBuffer.getInt();
                this.f6085b = byteBuffer.getInt();
                this.f6086c = byteBuffer.getInt();
                this.f6087d = byteBuffer.getInt();
                this.f6088e = byteBuffer.getInt();
                this.f6089f = byteBuffer.getInt();
                this.f6090g = byteBuffer.getInt();
                this.f6091h = byteBuffer.getInt();
                this.f6092i = byteBuffer.getInt();
                this.f6093j = byteBuffer.getInt();
            } else {
                if (i2 != 2) {
                    throw new IOException("Unexpected elf class: ".concat(String.valueOf(i2)));
                }
                this.f6084a = byteBuffer.getInt();
                this.f6085b = byteBuffer.getInt();
                this.f6086c = byteBuffer.getLong();
                this.f6087d = byteBuffer.getLong();
                this.f6088e = byteBuffer.getLong();
                this.f6089f = byteBuffer.getLong();
                this.f6090g = byteBuffer.getInt();
                this.f6091h = byteBuffer.getInt();
                this.f6092i = byteBuffer.getLong();
                this.f6093j = byteBuffer.getLong();
            }
            this.k = null;
        }
    }

    private h(File file) {
        c[] cVarArr;
        this.f6062b = null;
        this.f6063c = null;
        this.f6064d = null;
        FileInputStream fileInputStream = new FileInputStream(file);
        this.f6061a = fileInputStream;
        FileChannel channel = fileInputStream.getChannel();
        this.f6062b = new a(channel, (byte) 0);
        ByteBuffer allocate = ByteBuffer.allocate(128);
        allocate.limit(this.f6062b.f6075j);
        allocate.order(this.f6062b.f6066a[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        channel.position(this.f6062b.f6071f);
        this.f6063c = new b[this.f6062b.k];
        for (int i2 = 0; i2 < this.f6063c.length; i2++) {
            b(channel, allocate, "failed to read phdr.");
            this.f6063c[i2] = new b(allocate, this.f6062b.f6066a[4], (byte) 0);
        }
        channel.position(this.f6062b.f6072g);
        allocate.limit(this.f6062b.l);
        this.f6064d = new c[this.f6062b.m];
        int i3 = 0;
        while (true) {
            cVarArr = this.f6064d;
            if (i3 >= cVarArr.length) {
                break;
            }
            b(channel, allocate, "failed to read shdr.");
            this.f6064d[i3] = new c(allocate, this.f6062b.f6066a[4], (byte) 0);
            i3++;
        }
        short s = this.f6062b.n;
        if (s > 0) {
            c cVar = cVarArr[s];
            ByteBuffer allocate2 = ByteBuffer.allocate((int) cVar.f6089f);
            this.f6061a.getChannel().position(cVar.f6088e);
            b(this.f6061a.getChannel(), allocate2, "failed to read section: " + cVar.k);
            for (c cVar2 : this.f6064d) {
                allocate2.position(cVar2.f6084a);
                String a2 = a(allocate2);
                cVar2.k = a2;
                this.f6065e.put(a2, cVar2);
            }
        }
    }

    public static void b(FileChannel fileChannel, ByteBuffer byteBuffer, String str) {
        byteBuffer.rewind();
        int read = fileChannel.read(byteBuffer);
        if (read == byteBuffer.limit()) {
            byteBuffer.flip();
            return;
        }
        throw new IOException(str + " Rest bytes insufficient, expect to read " + byteBuffer.limit() + " bytes but only " + read + " bytes were read.");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f6061a.close();
        this.f6065e.clear();
        this.f6063c = null;
        this.f6064d = null;
    }

    public static boolean a(File file) {
        try {
            com.bytedance.pangle.util.g.a(new h(file));
            return true;
        } catch (IOException unused) {
            com.bytedance.pangle.util.g.a((Closeable) null);
            return false;
        } catch (Throwable th) {
            com.bytedance.pangle.util.g.a((Closeable) null);
            throw th;
        }
    }

    private static String a(ByteBuffer byteBuffer) {
        byte[] array = byteBuffer.array();
        int position = byteBuffer.position();
        while (byteBuffer.hasRemaining() && array[byteBuffer.position()] != 0) {
            byteBuffer.position(byteBuffer.position() + 1);
        }
        byteBuffer.position(byteBuffer.position() + 1);
        return new String(array, position, (byteBuffer.position() - position) - 1, Charset.forName(HTTP.ASCII));
    }

    static /* synthetic */ void a(int i2, int i3, String str) {
        if (i2 <= 0 || i2 > i3) {
            throw new IOException(str);
        }
    }
}
