package kotlin.io;

import f.b.a.d;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.collections.ByteIterator;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001e\u0010\b\u001a\u00020\u0007*\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0087\b¢\u0006\u0004\b\b\u0010\t\u001a\u0014\u0010\u000b\u001a\u00020\u0007*\u00020\nH\u0087\b¢\u0006\u0004\b\u000b\u0010\f\u001a$\u0010\u000b\u001a\u00020\u0007*\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0087\b¢\u0006\u0004\b\u000b\u0010\u0010\u001a\u001e\u0010\u0013\u001a\u00020\u0000*\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\rH\u0087\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001e\u0010\u0016\u001a\u00020\u0015*\u00020\u00112\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0087\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001e\u0010\u0019\u001a\u00020\u0018*\u00020\u00112\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0087\b¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001e\u0010\u0013\u001a\u00020\u001c*\u00020\u001b2\b\b\u0002\u0010\u0012\u001a\u00020\rH\u0087\b¢\u0006\u0004\b\u0013\u0010\u001d\u001a\u001e\u0010\u001f\u001a\u00020\u001e*\u00020\u001b2\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0087\b¢\u0006\u0004\b\u001f\u0010 \u001a\u001e\u0010\"\u001a\u00020!*\u00020\u001b2\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0087\b¢\u0006\u0004\b\"\u0010#\u001a#\u0010&\u001a\u00020%*\u00020\u00112\u0006\u0010$\u001a\u00020\u001b2\b\b\u0002\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b&\u0010'\u001a\u001d\u0010)\u001a\u00020\n*\u00020\u00112\b\b\u0002\u0010(\u001a\u00020\rH\u0007¢\u0006\u0004\b)\u0010*\u001a\u0013\u0010)\u001a\u00020\n*\u00020\u0011H\u0007¢\u0006\u0004\b)\u0010+¨\u0006,"}, d2 = {"Ljava/io/BufferedInputStream;", "Lkotlin/collections/ByteIterator;", "iterator", "(Ljava/io/BufferedInputStream;)Lkotlin/collections/ByteIterator;", "", "Ljava/nio/charset/Charset;", "charset", "Ljava/io/ByteArrayInputStream;", "byteInputStream", "(Ljava/lang/String;Ljava/nio/charset/Charset;)Ljava/io/ByteArrayInputStream;", "", "inputStream", "([B)Ljava/io/ByteArrayInputStream;", "", "offset", "length", "([BII)Ljava/io/ByteArrayInputStream;", "Ljava/io/InputStream;", "bufferSize", "buffered", "(Ljava/io/InputStream;I)Ljava/io/BufferedInputStream;", "Ljava/io/InputStreamReader;", "reader", "(Ljava/io/InputStream;Ljava/nio/charset/Charset;)Ljava/io/InputStreamReader;", "Ljava/io/BufferedReader;", "bufferedReader", "(Ljava/io/InputStream;Ljava/nio/charset/Charset;)Ljava/io/BufferedReader;", "Ljava/io/OutputStream;", "Ljava/io/BufferedOutputStream;", "(Ljava/io/OutputStream;I)Ljava/io/BufferedOutputStream;", "Ljava/io/OutputStreamWriter;", "writer", "(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)Ljava/io/OutputStreamWriter;", "Ljava/io/BufferedWriter;", "bufferedWriter", "(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)Ljava/io/BufferedWriter;", "out", "", "copyTo", "(Ljava/io/InputStream;Ljava/io/OutputStream;I)J", "estimatedSize", "readBytes", "(Ljava/io/InputStream;I)[B", "(Ljava/io/InputStream;)[B", "kotlin-stdlib"}, k = 2, mv = {1, 4, 0})
@JvmName(name = "ByteStreamsKt")
/* loaded from: classes.dex */
public final class ByteStreamsKt {
    @InlineOnly
    private static final BufferedInputStream buffered(@d InputStream inputStream, int i2) {
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, i2);
    }

    static /* synthetic */ BufferedInputStream buffered$default(InputStream inputStream, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 8192;
        }
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, i2);
    }

    @InlineOnly
    private static final BufferedReader bufferedReader(@d InputStream inputStream, Charset charset) {
        Reader inputStreamReader = new InputStreamReader(inputStream, charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
    }

    static /* synthetic */ BufferedReader bufferedReader$default(InputStream inputStream, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Reader inputStreamReader = new InputStreamReader(inputStream, charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
    }

    @InlineOnly
    private static final BufferedWriter bufferedWriter(@d OutputStream outputStream, Charset charset) {
        Writer outputStreamWriter = new OutputStreamWriter(outputStream, charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
    }

    static /* synthetic */ BufferedWriter bufferedWriter$default(OutputStream outputStream, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Writer outputStreamWriter = new OutputStreamWriter(outputStream, charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
    }

    @InlineOnly
    private static final ByteArrayInputStream byteInputStream(@d String str, Charset charset) {
        if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        return new ByteArrayInputStream(bytes);
    }

    static /* synthetic */ ByteArrayInputStream byteInputStream$default(String str, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        return new ByteArrayInputStream(bytes);
    }

    public static final long copyTo(@d InputStream copyTo, @d OutputStream out, int i2) {
        Intrinsics.checkParameterIsNotNull(copyTo, "$this$copyTo");
        Intrinsics.checkParameterIsNotNull(out, "out");
        byte[] bArr = new byte[i2];
        int read = copyTo.read(bArr);
        long j2 = 0;
        while (read >= 0) {
            out.write(bArr, 0, read);
            j2 += read;
            read = copyTo.read(bArr);
        }
        return j2;
    }

    public static /* synthetic */ long copyTo$default(InputStream inputStream, OutputStream outputStream, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 8192;
        }
        return copyTo(inputStream, outputStream, i2);
    }

    @InlineOnly
    private static final ByteArrayInputStream inputStream(@d byte[] bArr) {
        return new ByteArrayInputStream(bArr);
    }

    @d
    public static final ByteIterator iterator(@d final BufferedInputStream iterator) {
        Intrinsics.checkParameterIsNotNull(iterator, "$this$iterator");
        return new ByteIterator() { // from class: kotlin.io.ByteStreamsKt$iterator$1
            private boolean finished;
            private int nextByte = -1;
            private boolean nextPrepared;

            private final void prepareNext() {
                if (this.nextPrepared || this.finished) {
                    return;
                }
                int read = iterator.read();
                this.nextByte = read;
                this.nextPrepared = true;
                this.finished = read == -1;
            }

            public final boolean getFinished() {
                return this.finished;
            }

            public final int getNextByte() {
                return this.nextByte;
            }

            public final boolean getNextPrepared() {
                return this.nextPrepared;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                prepareNext();
                return !this.finished;
            }

            @Override // kotlin.collections.ByteIterator
            public byte nextByte() {
                prepareNext();
                if (this.finished) {
                    throw new NoSuchElementException("Input stream is over.");
                }
                byte b2 = (byte) this.nextByte;
                this.nextPrepared = false;
                return b2;
            }

            public final void setFinished(boolean z) {
                this.finished = z;
            }

            public final void setNextByte(int i2) {
                this.nextByte = i2;
            }

            public final void setNextPrepared(boolean z) {
                this.nextPrepared = z;
            }
        };
    }

    @d
    @Deprecated(message = "Use readBytes() overload without estimatedSize parameter", replaceWith = @ReplaceWith(expression = "readBytes()", imports = {}))
    public static final byte[] readBytes(@d InputStream readBytes, int i2) {
        Intrinsics.checkParameterIsNotNull(readBytes, "$this$readBytes");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(i2, readBytes.available()));
        copyTo$default(readBytes, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkExpressionValueIsNotNull(byteArray, "buffer.toByteArray()");
        return byteArray;
    }

    public static /* synthetic */ byte[] readBytes$default(InputStream inputStream, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 8192;
        }
        return readBytes(inputStream, i2);
    }

    @InlineOnly
    private static final InputStreamReader reader(@d InputStream inputStream, Charset charset) {
        return new InputStreamReader(inputStream, charset);
    }

    static /* synthetic */ InputStreamReader reader$default(InputStream inputStream, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return new InputStreamReader(inputStream, charset);
    }

    @InlineOnly
    private static final OutputStreamWriter writer(@d OutputStream outputStream, Charset charset) {
        return new OutputStreamWriter(outputStream, charset);
    }

    static /* synthetic */ OutputStreamWriter writer$default(OutputStream outputStream, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return new OutputStreamWriter(outputStream, charset);
    }

    @InlineOnly
    private static final BufferedOutputStream buffered(@d OutputStream outputStream, int i2) {
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, i2);
    }

    static /* synthetic */ BufferedOutputStream buffered$default(OutputStream outputStream, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 8192;
        }
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, i2);
    }

    @InlineOnly
    private static final ByteArrayInputStream inputStream(@d byte[] bArr, int i2, int i3) {
        return new ByteArrayInputStream(bArr, i2, i3);
    }

    @d
    @SinceKotlin(version = "1.3")
    public static final byte[] readBytes(@d InputStream readBytes) {
        Intrinsics.checkParameterIsNotNull(readBytes, "$this$readBytes");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, readBytes.available()));
        copyTo$default(readBytes, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkExpressionValueIsNotNull(byteArray, "buffer.toByteArray()");
        return byteArray;
    }
}
