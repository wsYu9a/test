package com.czhj.wire.okio;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public interface BufferedSource extends Source {
    Buffer buffer();

    boolean exhausted() throws IOException;

    long indexOf(byte b10) throws IOException;

    long indexOf(byte b10, long j10) throws IOException;

    long indexOf(ByteString byteString) throws IOException;

    long indexOf(ByteString byteString, long j10) throws IOException;

    long indexOfElement(ByteString byteString) throws IOException;

    long indexOfElement(ByteString byteString, long j10) throws IOException;

    InputStream inputStream();

    int read(byte[] bArr) throws IOException;

    int read(byte[] bArr, int i10, int i11) throws IOException;

    long readAll(Sink sink) throws IOException;

    byte readByte() throws IOException;

    byte[] readByteArray() throws IOException;

    byte[] readByteArray(long j10) throws IOException;

    ByteString readByteString() throws IOException;

    ByteString readByteString(long j10) throws IOException;

    long readDecimalLong() throws IOException;

    void readFully(Buffer buffer, long j10) throws IOException;

    void readFully(byte[] bArr) throws IOException;

    long readHexadecimalUnsignedLong() throws IOException;

    int readInt() throws IOException;

    int readIntLe() throws IOException;

    long readLong() throws IOException;

    long readLongLe() throws IOException;

    short readShort() throws IOException;

    short readShortLe() throws IOException;

    String readString(long j10, Charset charset) throws IOException;

    String readString(Charset charset) throws IOException;

    String readUtf8() throws IOException;

    String readUtf8(long j10) throws IOException;

    int readUtf8CodePoint() throws IOException;

    String readUtf8Line() throws IOException;

    String readUtf8LineStrict() throws IOException;

    boolean request(long j10) throws IOException;

    void require(long j10) throws IOException;

    int select(Options options) throws IOException;

    void skip(long j10) throws IOException;
}
