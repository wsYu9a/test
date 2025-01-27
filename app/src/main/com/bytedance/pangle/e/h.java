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

/* loaded from: classes2.dex */
public final class h implements Closeable {

    /* renamed from: a */
    private final FileInputStream f7558a;

    /* renamed from: b */
    private a f7559b;

    /* renamed from: c */
    private b[] f7560c;

    /* renamed from: d */
    private c[] f7561d;

    /* renamed from: e */
    private final Map<String, c> f7562e = new HashMap();

    public static class a {

        /* renamed from: a */
        public final byte[] f7563a;

        /* renamed from: b */
        public final short f7564b;

        /* renamed from: c */
        public final short f7565c;

        /* renamed from: d */
        public final int f7566d;

        /* renamed from: e */
        public final long f7567e;

        /* renamed from: f */
        public final long f7568f;

        /* renamed from: g */
        public final long f7569g;

        /* renamed from: h */
        public final int f7570h;

        /* renamed from: i */
        public final short f7571i;

        /* renamed from: j */
        public final short f7572j;

        /* renamed from: k */
        public final short f7573k;

        /* renamed from: l */
        public final short f7574l;

        /* renamed from: m */
        public final short f7575m;

        /* renamed from: n */
        public final short f7576n;

        public /* synthetic */ a(FileChannel fileChannel, byte b10) {
            this(fileChannel);
        }

        private a(FileChannel fileChannel) {
            byte[] bArr = new byte[16];
            this.f7563a = bArr;
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
            this.f7564b = allocate.getShort();
            this.f7565c = allocate.getShort();
            int i10 = allocate.getInt();
            this.f7566d = i10;
            h.a(i10, 1, "bad elf version: " + i10);
            byte b10 = bArr[4];
            if (b10 == 1) {
                this.f7567e = allocate.getInt();
                this.f7568f = allocate.getInt();
                this.f7569g = allocate.getInt();
            } else {
                if (b10 != 2) {
                    throw new IOException("Unexpected elf class: " + ((int) bArr[4]));
                }
                this.f7567e = allocate.getLong();
                this.f7568f = allocate.getLong();
                this.f7569g = allocate.getLong();
            }
            this.f7570h = allocate.getInt();
            this.f7571i = allocate.getShort();
            this.f7572j = allocate.getShort();
            this.f7573k = allocate.getShort();
            this.f7574l = allocate.getShort();
            this.f7575m = allocate.getShort();
            this.f7576n = allocate.getShort();
        }
    }

    public static class b {

        /* renamed from: a */
        public final int f7577a;

        /* renamed from: b */
        public final int f7578b;

        /* renamed from: c */
        public final long f7579c;

        /* renamed from: d */
        public final long f7580d;

        /* renamed from: e */
        public final long f7581e;

        /* renamed from: f */
        public final long f7582f;

        /* renamed from: g */
        public final long f7583g;

        /* renamed from: h */
        public final long f7584h;

        public /* synthetic */ b(ByteBuffer byteBuffer, int i10, byte b10) {
            this(byteBuffer, i10);
        }

        private b(ByteBuffer byteBuffer, int i10) {
            if (i10 == 1) {
                this.f7577a = byteBuffer.getInt();
                this.f7579c = byteBuffer.getInt();
                this.f7580d = byteBuffer.getInt();
                this.f7581e = byteBuffer.getInt();
                this.f7582f = byteBuffer.getInt();
                this.f7583g = byteBuffer.getInt();
                this.f7578b = byteBuffer.getInt();
                this.f7584h = byteBuffer.getInt();
                return;
            }
            if (i10 != 2) {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i10)));
            }
            this.f7577a = byteBuffer.getInt();
            this.f7578b = byteBuffer.getInt();
            this.f7579c = byteBuffer.getLong();
            this.f7580d = byteBuffer.getLong();
            this.f7581e = byteBuffer.getLong();
            this.f7582f = byteBuffer.getLong();
            this.f7583g = byteBuffer.getLong();
            this.f7584h = byteBuffer.getLong();
        }
    }

    public static class c {

        /* renamed from: a */
        public final int f7585a;

        /* renamed from: b */
        public final int f7586b;

        /* renamed from: c */
        public final long f7587c;

        /* renamed from: d */
        public final long f7588d;

        /* renamed from: e */
        public final long f7589e;

        /* renamed from: f */
        public final long f7590f;

        /* renamed from: g */
        public final int f7591g;

        /* renamed from: h */
        public final int f7592h;

        /* renamed from: i */
        public final long f7593i;

        /* renamed from: j */
        public final long f7594j;

        /* renamed from: k */
        public String f7595k;

        public /* synthetic */ c(ByteBuffer byteBuffer, int i10, byte b10) {
            this(byteBuffer, i10);
        }

        private c(ByteBuffer byteBuffer, int i10) {
            if (i10 == 1) {
                this.f7585a = byteBuffer.getInt();
                this.f7586b = byteBuffer.getInt();
                this.f7587c = byteBuffer.getInt();
                this.f7588d = byteBuffer.getInt();
                this.f7589e = byteBuffer.getInt();
                this.f7590f = byteBuffer.getInt();
                this.f7591g = byteBuffer.getInt();
                this.f7592h = byteBuffer.getInt();
                this.f7593i = byteBuffer.getInt();
                this.f7594j = byteBuffer.getInt();
            } else {
                if (i10 != 2) {
                    throw new IOException("Unexpected elf class: ".concat(String.valueOf(i10)));
                }
                this.f7585a = byteBuffer.getInt();
                this.f7586b = byteBuffer.getInt();
                this.f7587c = byteBuffer.getLong();
                this.f7588d = byteBuffer.getLong();
                this.f7589e = byteBuffer.getLong();
                this.f7590f = byteBuffer.getLong();
                this.f7591g = byteBuffer.getInt();
                this.f7592h = byteBuffer.getInt();
                this.f7593i = byteBuffer.getLong();
                this.f7594j = byteBuffer.getLong();
            }
            this.f7595k = null;
        }
    }

    private h(File file) {
        c[] cVarArr;
        this.f7559b = null;
        this.f7560c = null;
        this.f7561d = null;
        FileInputStream fileInputStream = new FileInputStream(file);
        this.f7558a = fileInputStream;
        FileChannel channel = fileInputStream.getChannel();
        this.f7559b = new a(channel, (byte) 0);
        ByteBuffer allocate = ByteBuffer.allocate(128);
        allocate.limit(this.f7559b.f7572j);
        allocate.order(this.f7559b.f7563a[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        channel.position(this.f7559b.f7568f);
        this.f7560c = new b[this.f7559b.f7573k];
        for (int i10 = 0; i10 < this.f7560c.length; i10++) {
            b(channel, allocate, "failed to read phdr.");
            this.f7560c[i10] = new b(allocate, this.f7559b.f7563a[4], (byte) 0);
        }
        channel.position(this.f7559b.f7569g);
        allocate.limit(this.f7559b.f7574l);
        this.f7561d = new c[this.f7559b.f7575m];
        int i11 = 0;
        while (true) {
            cVarArr = this.f7561d;
            if (i11 >= cVarArr.length) {
                break;
            }
            b(channel, allocate, "failed to read shdr.");
            this.f7561d[i11] = new c(allocate, this.f7559b.f7563a[4], (byte) 0);
            i11++;
        }
        short s10 = this.f7559b.f7576n;
        if (s10 > 0) {
            c cVar = cVarArr[s10];
            ByteBuffer allocate2 = ByteBuffer.allocate((int) cVar.f7590f);
            this.f7558a.getChannel().position(cVar.f7589e);
            b(this.f7558a.getChannel(), allocate2, "failed to read section: " + cVar.f7595k);
            for (c cVar2 : this.f7561d) {
                allocate2.position(cVar2.f7585a);
                String a10 = a(allocate2);
                cVar2.f7595k = a10;
                this.f7562e.put(a10, cVar2);
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
        this.f7558a.close();
        this.f7562e.clear();
        this.f7560c = null;
        this.f7561d = null;
    }

    public static boolean a(File file) {
        try {
            com.bytedance.pangle.util.g.a(new h(file));
            return true;
        } catch (IOException unused) {
            com.bytedance.pangle.util.g.a((Closeable) null);
            return false;
        } catch (Throwable th2) {
            com.bytedance.pangle.util.g.a((Closeable) null);
            throw th2;
        }
    }

    private static String a(ByteBuffer byteBuffer) {
        byte[] array = byteBuffer.array();
        int position = byteBuffer.position();
        while (byteBuffer.hasRemaining() && array[byteBuffer.position()] != 0) {
            byteBuffer.position(byteBuffer.position() + 1);
        }
        byteBuffer.position(byteBuffer.position() + 1);
        return new String(array, position, (byteBuffer.position() - position) - 1, Charset.forName("ASCII"));
    }

    public static /* synthetic */ void a(int i10, int i11, String str) {
        if (i10 <= 0 || i10 > i11) {
            throw new IOException(str);
        }
    }
}
