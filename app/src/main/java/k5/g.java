package k5;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import javax.annotation.CheckForNull;

@p
@a5.c
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a */
    public static final int f27644a = 8192;

    /* renamed from: b */
    public static final int f27645b = 524288;

    /* renamed from: c */
    public static final int f27646c = 2147483639;

    /* renamed from: d */
    public static final int f27647d = 20;

    /* renamed from: e */
    public static final OutputStream f27648e = new a();

    public class a extends OutputStream {
        public String toString() {
            return "ByteStreams.nullOutputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i10) {
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            b5.u.E(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) {
            b5.u.E(bArr);
            b5.u.f0(i10, i11 + i10, bArr.length);
        }
    }

    public static byte[] a(Queue<byte[]> queue, int i10) {
        if (queue.isEmpty()) {
            return new byte[0];
        }
        byte[] remove = queue.remove();
        if (remove.length == i10) {
            return remove;
        }
        int length = i10 - remove.length;
        byte[] copyOf = Arrays.copyOf(remove, i10);
        while (length > 0) {
            byte[] remove2 = queue.remove();
            int min = Math.min(length, remove2.length);
            System.arraycopy(remove2, 0, copyOf, i10 - length, min);
            length -= min;
        }
        return copyOf;
    }

    @CanIgnoreReturnValue
    public static long b(InputStream inputStream, OutputStream outputStream) throws IOException {
        b5.u.E(inputStream);
        b5.u.E(outputStream);
        byte[] d10 = d();
        long j10 = 0;
        while (true) {
            int read = inputStream.read(d10);
            if (read == -1) {
                return j10;
            }
            outputStream.write(d10, 0, read);
            j10 += read;
        }
    }

    @CanIgnoreReturnValue
    public static long c(ReadableByteChannel readableByteChannel, WritableByteChannel writableByteChannel) throws IOException {
        b5.u.E(readableByteChannel);
        b5.u.E(writableByteChannel);
        long j10 = 0;
        if (!(readableByteChannel instanceof FileChannel)) {
            ByteBuffer wrap = ByteBuffer.wrap(d());
            while (readableByteChannel.read(wrap) != -1) {
                s.b(wrap);
                while (wrap.hasRemaining()) {
                    j10 += writableByteChannel.write(wrap);
                }
                s.a(wrap);
            }
            return j10;
        }
        FileChannel fileChannel = (FileChannel) readableByteChannel;
        long position = fileChannel.position();
        long j11 = position;
        while (true) {
            long transferTo = fileChannel.transferTo(j11, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED, writableByteChannel);
            j11 += transferTo;
            fileChannel.position(j11);
            if (transferTo <= 0 && j11 >= fileChannel.size()) {
                return j11 - position;
            }
        }
    }

    public static byte[] d() {
        return new byte[8192];
    }

    @CanIgnoreReturnValue
    @a5.a
    public static long e(InputStream inputStream) throws IOException {
        byte[] d10 = d();
        long j10 = 0;
        while (true) {
            long read = inputStream.read(d10);
            if (read == -1) {
                return j10;
            }
            j10 += read;
        }
    }

    @a5.a
    public static InputStream f(InputStream inputStream, long j10) {
        return new d(inputStream, j10);
    }

    @a5.a
    public static k5.b g(ByteArrayInputStream byteArrayInputStream) {
        return new b((ByteArrayInputStream) b5.u.E(byteArrayInputStream));
    }

    @a5.a
    public static k5.b h(byte[] bArr) {
        return g(new ByteArrayInputStream(bArr));
    }

    @a5.a
    public static k5.b i(byte[] bArr, int i10) {
        b5.u.d0(i10, bArr.length);
        return g(new ByteArrayInputStream(bArr, i10, bArr.length - i10));
    }

    @a5.a
    public static k5.c j() {
        return l(new ByteArrayOutputStream());
    }

    @a5.a
    public static k5.c k(int i10) {
        if (i10 >= 0) {
            return l(new ByteArrayOutputStream(i10));
        }
        throw new IllegalArgumentException(String.format("Invalid size: %s", Integer.valueOf(i10)));
    }

    @a5.a
    public static k5.c l(ByteArrayOutputStream byteArrayOutputStream) {
        return new c((ByteArrayOutputStream) b5.u.E(byteArrayOutputStream));
    }

    @a5.a
    public static OutputStream m() {
        return f27648e;
    }

    @CanIgnoreReturnValue
    @a5.a
    public static int n(InputStream inputStream, byte[] bArr, int i10, int i11) throws IOException {
        int i12 = 0;
        b5.u.E(inputStream);
        b5.u.E(bArr);
        if (i11 < 0) {
            throw new IndexOutOfBoundsException(String.format("len (%s) cannot be negative", Integer.valueOf(i11)));
        }
        b5.u.f0(i10, i10 + i11, bArr.length);
        while (i12 < i11) {
            int read = inputStream.read(bArr, i10 + i12, i11 - i12);
            if (read == -1) {
                break;
            }
            i12 += read;
        }
        return i12;
    }

    @a5.a
    @a0
    @CanIgnoreReturnValue
    public static <T> T o(InputStream inputStream, k5.d<T> dVar) throws IOException {
        int read;
        b5.u.E(inputStream);
        b5.u.E(dVar);
        byte[] d10 = d();
        do {
            read = inputStream.read(d10);
            if (read == -1) {
                break;
            }
        } while (dVar.b(d10, 0, read));
        return dVar.a();
    }

    @a5.a
    public static void p(InputStream inputStream, byte[] bArr) throws IOException {
        q(inputStream, bArr, 0, bArr.length);
    }

    @a5.a
    public static void q(InputStream inputStream, byte[] bArr, int i10, int i11) throws IOException {
        int n10 = n(inputStream, bArr, i10, i11);
        if (n10 == i11) {
            return;
        }
        StringBuilder sb2 = new StringBuilder(81);
        sb2.append("reached end of stream after reading ");
        sb2.append(n10);
        sb2.append(" bytes; ");
        sb2.append(i11);
        sb2.append(" bytes expected");
        throw new EOFException(sb2.toString());
    }

    @a5.a
    public static void r(InputStream inputStream, long j10) throws IOException {
        long t10 = t(inputStream, j10);
        if (t10 >= j10) {
            return;
        }
        StringBuilder sb2 = new StringBuilder(100);
        sb2.append("reached end of stream after skipping ");
        sb2.append(t10);
        sb2.append(" bytes; ");
        sb2.append(j10);
        sb2.append(" bytes expected");
        throw new EOFException(sb2.toString());
    }

    public static long s(InputStream inputStream, long j10) throws IOException {
        int available = inputStream.available();
        if (available == 0) {
            return 0L;
        }
        return inputStream.skip(Math.min(available, j10));
    }

    public static long t(InputStream inputStream, long j10) throws IOException {
        byte[] bArr = null;
        long j11 = 0;
        while (j11 < j10) {
            long j12 = j10 - j11;
            long s10 = s(inputStream, j12);
            if (s10 == 0) {
                int min = (int) Math.min(j12, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
                if (bArr == null) {
                    bArr = new byte[min];
                }
                s10 = inputStream.read(bArr, 0, min);
                if (s10 == -1) {
                    break;
                }
            }
            j11 += s10;
        }
        return j11;
    }

    public static byte[] u(InputStream inputStream) throws IOException {
        b5.u.E(inputStream);
        return w(inputStream, new ArrayDeque(20), 0);
    }

    public static byte[] v(InputStream inputStream, long j10) throws IOException {
        b5.u.p(j10 >= 0, "expectedSize (%s) must be non-negative", j10);
        if (j10 > 2147483639) {
            StringBuilder sb2 = new StringBuilder(62);
            sb2.append(j10);
            sb2.append(" bytes is too large to fit in a byte array");
            throw new OutOfMemoryError(sb2.toString());
        }
        int i10 = (int) j10;
        byte[] bArr = new byte[i10];
        int i11 = i10;
        while (i11 > 0) {
            int i12 = i10 - i11;
            int read = inputStream.read(bArr, i12, i11);
            if (read == -1) {
                return Arrays.copyOf(bArr, i12);
            }
            i11 -= read;
        }
        int read2 = inputStream.read();
        if (read2 == -1) {
            return bArr;
        }
        ArrayDeque arrayDeque = new ArrayDeque(22);
        arrayDeque.add(bArr);
        arrayDeque.add(new byte[]{(byte) read2});
        return w(inputStream, arrayDeque, i10 + 1);
    }

    public static byte[] w(InputStream inputStream, Queue<byte[]> queue, int i10) throws IOException {
        int min = Math.min(8192, Math.max(128, Integer.highestOneBit(i10) * 2));
        while (i10 < 2147483639) {
            int min2 = Math.min(min, f27646c - i10);
            byte[] bArr = new byte[min2];
            queue.add(bArr);
            int i11 = 0;
            while (i11 < min2) {
                int read = inputStream.read(bArr, i11, min2 - i11);
                if (read == -1) {
                    return a(queue, i10);
                }
                i11 += read;
                i10 += read;
            }
            min = l5.f.u(min, min < 4096 ? 4 : 2);
        }
        if (inputStream.read() == -1) {
            return a(queue, f27646c);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    public static class b implements k5.b {

        /* renamed from: b */
        public final DataInput f27649b;

        public b(ByteArrayInputStream byteArrayInputStream) {
            this.f27649b = new DataInputStream(byteArrayInputStream);
        }

        @Override // k5.b, java.io.DataInput
        public boolean readBoolean() {
            try {
                return this.f27649b.readBoolean();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // k5.b, java.io.DataInput
        public byte readByte() {
            try {
                return this.f27649b.readByte();
            } catch (EOFException e10) {
                throw new IllegalStateException(e10);
            } catch (IOException e11) {
                throw new AssertionError(e11);
            }
        }

        @Override // k5.b, java.io.DataInput
        public char readChar() {
            try {
                return this.f27649b.readChar();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // k5.b, java.io.DataInput
        public double readDouble() {
            try {
                return this.f27649b.readDouble();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // k5.b, java.io.DataInput
        public float readFloat() {
            try {
                return this.f27649b.readFloat();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // k5.b, java.io.DataInput
        public void readFully(byte[] bArr) {
            try {
                this.f27649b.readFully(bArr);
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // k5.b, java.io.DataInput
        public int readInt() {
            try {
                return this.f27649b.readInt();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // k5.b, java.io.DataInput
        @CheckForNull
        public String readLine() {
            try {
                return this.f27649b.readLine();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // k5.b, java.io.DataInput
        public long readLong() {
            try {
                return this.f27649b.readLong();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // k5.b, java.io.DataInput
        public short readShort() {
            try {
                return this.f27649b.readShort();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // k5.b, java.io.DataInput
        public String readUTF() {
            try {
                return this.f27649b.readUTF();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // k5.b, java.io.DataInput
        public int readUnsignedByte() {
            try {
                return this.f27649b.readUnsignedByte();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // k5.b, java.io.DataInput
        public int readUnsignedShort() {
            try {
                return this.f27649b.readUnsignedShort();
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // k5.b, java.io.DataInput
        public int skipBytes(int i10) {
            try {
                return this.f27649b.skipBytes(i10);
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }

        @Override // k5.b, java.io.DataInput
        public void readFully(byte[] bArr, int i10, int i11) {
            try {
                this.f27649b.readFully(bArr, i10, i11);
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }
    }

    public static class c implements k5.c {

        /* renamed from: b */
        public final DataOutput f27650b;

        /* renamed from: c */
        public final ByteArrayOutputStream f27651c;

        public c(ByteArrayOutputStream byteArrayOutputStream) {
            this.f27651c = byteArrayOutputStream;
            this.f27650b = new DataOutputStream(byteArrayOutputStream);
        }

        @Override // k5.c
        public byte[] a() {
            return this.f27651c.toByteArray();
        }

        @Override // k5.c, java.io.DataOutput
        public void write(int i10) {
            try {
                this.f27650b.write(i10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // k5.c, java.io.DataOutput
        public void writeBoolean(boolean z10) {
            try {
                this.f27650b.writeBoolean(z10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // k5.c, java.io.DataOutput
        public void writeByte(int i10) {
            try {
                this.f27650b.writeByte(i10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // k5.c, java.io.DataOutput
        public void writeBytes(String str) {
            try {
                this.f27650b.writeBytes(str);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // k5.c, java.io.DataOutput
        public void writeChar(int i10) {
            try {
                this.f27650b.writeChar(i10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // k5.c, java.io.DataOutput
        public void writeChars(String str) {
            try {
                this.f27650b.writeChars(str);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // k5.c, java.io.DataOutput
        public void writeDouble(double d10) {
            try {
                this.f27650b.writeDouble(d10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // k5.c, java.io.DataOutput
        public void writeFloat(float f10) {
            try {
                this.f27650b.writeFloat(f10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // k5.c, java.io.DataOutput
        public void writeInt(int i10) {
            try {
                this.f27650b.writeInt(i10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // k5.c, java.io.DataOutput
        public void writeLong(long j10) {
            try {
                this.f27650b.writeLong(j10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // k5.c, java.io.DataOutput
        public void writeShort(int i10) {
            try {
                this.f27650b.writeShort(i10);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // k5.c, java.io.DataOutput
        public void writeUTF(String str) {
            try {
                this.f27650b.writeUTF(str);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // k5.c, java.io.DataOutput
        public void write(byte[] bArr) {
            try {
                this.f27650b.write(bArr);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // k5.c, java.io.DataOutput
        public void write(byte[] bArr, int i10, int i11) {
            try {
                this.f27650b.write(bArr, i10, i11);
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }
    }

    public static final class d extends FilterInputStream {

        /* renamed from: b */
        public long f27652b;

        /* renamed from: c */
        public long f27653c;

        public d(InputStream inputStream, long j10) {
            super(inputStream);
            this.f27653c = -1L;
            b5.u.E(inputStream);
            b5.u.e(j10 >= 0, "limit must be non-negative");
            this.f27652b = j10;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int available() throws IOException {
            return (int) Math.min(((FilterInputStream) this).in.available(), this.f27652b);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int i10) {
            ((FilterInputStream) this).in.mark(i10);
            this.f27653c = this.f27652b;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            if (this.f27652b == 0) {
                return -1;
            }
            int read = ((FilterInputStream) this).in.read();
            if (read != -1) {
                this.f27652b--;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() throws IOException {
            if (!((FilterInputStream) this).in.markSupported()) {
                throw new IOException("Mark not supported");
            }
            if (this.f27653c == -1) {
                throw new IOException("Mark not set");
            }
            ((FilterInputStream) this).in.reset();
            this.f27652b = this.f27653c;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j10) throws IOException {
            long skip = ((FilterInputStream) this).in.skip(Math.min(j10, this.f27652b));
            this.f27652b -= skip;
            return skip;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) throws IOException {
            long j10 = this.f27652b;
            if (j10 == 0) {
                return -1;
            }
            int read = ((FilterInputStream) this).in.read(bArr, i10, (int) Math.min(i11, j10));
            if (read != -1) {
                this.f27652b -= read;
            }
            return read;
        }
    }
}
