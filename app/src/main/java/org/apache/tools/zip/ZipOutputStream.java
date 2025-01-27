package org.apache.tools.zip;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Hashtable;
import java.util.Vector;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.util.zip.ZipException;

/* loaded from: classes5.dex */
public class ZipOutputStream extends FilterOutputStream {
    public static final int DEFAULT_COMPRESSION = -1;
    public static final int DEFLATED = 8;
    public static final int STORED = 0;
    protected byte[] buf;
    private long cdLength;
    private long cdOffset;
    private String comment;
    private CRC32 crc;
    private long dataStart;
    protected Deflater def;
    private String encoding;
    private Vector entries;
    private ZipEntry entry;
    private boolean hasCompressionLevelChanged;
    private int level;
    private long localDataStart;
    private int method;
    private Hashtable offsets;
    private RandomAccessFile raf;
    private long written;
    private static final byte[] ZERO = {0, 0};
    private static final byte[] LZERO = {0, 0, 0, 0};
    protected static final byte[] LFH_SIG = ZipLong.getBytes(67324752);
    protected static final byte[] DD_SIG = ZipLong.getBytes(134695760);
    protected static final byte[] CFH_SIG = ZipLong.getBytes(33639248);
    protected static final byte[] EOCD_SIG = ZipLong.getBytes(101010256);
    private static final byte[] DOS_TIME_MIN = ZipLong.getBytes(8448);

    public ZipOutputStream(OutputStream outputStream) {
        super(outputStream);
        this.comment = "";
        this.level = -1;
        this.hasCompressionLevelChanged = false;
        this.method = 8;
        this.entries = new Vector();
        this.crc = new CRC32();
        this.written = 0L;
        this.dataStart = 0L;
        this.localDataStart = 0L;
        this.cdOffset = 0L;
        this.cdLength = 0L;
        this.offsets = new Hashtable();
        this.encoding = null;
        this.def = new Deflater(this.level, true);
        this.buf = new byte[512];
        this.raf = null;
    }

    protected static long adjustToLong(int i2) {
        return i2 < 0 ? i2 + 4294967296L : i2;
    }

    protected static ZipLong toDosTime(Date date) {
        return new ZipLong(toDosTime(date.getTime()));
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        finish();
        RandomAccessFile randomAccessFile = this.raf;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
        OutputStream outputStream = ((FilterOutputStream) this).out;
        if (outputStream != null) {
            outputStream.close();
        }
    }

    public void closeEntry() throws IOException {
        if (this.entry == null) {
            return;
        }
        long value = this.crc.getValue();
        this.crc.reset();
        if (this.entry.getMethod() == 8) {
            this.def.finish();
            while (!this.def.finished()) {
                deflate();
            }
            this.entry.setSize(adjustToLong(this.def.getTotalIn()));
            this.entry.setCompressedSize(adjustToLong(this.def.getTotalOut()));
            this.entry.setCrc(value);
            this.def.reset();
            this.written += this.entry.getCompressedSize();
        } else if (this.raf != null) {
            long j2 = this.written - this.dataStart;
            this.entry.setSize(j2);
            this.entry.setCompressedSize(j2);
            this.entry.setCrc(value);
        } else {
            if (this.entry.getCrc() != value) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("bad CRC checksum for entry ");
                stringBuffer.append(this.entry.getName());
                stringBuffer.append(": ");
                stringBuffer.append(Long.toHexString(this.entry.getCrc()));
                stringBuffer.append(" instead of ");
                stringBuffer.append(Long.toHexString(value));
                throw new ZipException(stringBuffer.toString());
            }
            if (this.entry.getSize() != this.written - this.dataStart) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("bad size for entry ");
                stringBuffer2.append(this.entry.getName());
                stringBuffer2.append(": ");
                stringBuffer2.append(this.entry.getSize());
                stringBuffer2.append(" instead of ");
                stringBuffer2.append(this.written - this.dataStart);
                throw new ZipException(stringBuffer2.toString());
            }
        }
        RandomAccessFile randomAccessFile = this.raf;
        if (randomAccessFile != null) {
            long filePointer = randomAccessFile.getFilePointer();
            this.raf.seek(this.localDataStart);
            writeOut(ZipLong.getBytes(this.entry.getCrc()));
            writeOut(ZipLong.getBytes(this.entry.getCompressedSize()));
            writeOut(ZipLong.getBytes(this.entry.getSize()));
            this.raf.seek(filePointer);
        }
        writeDataDescriptor(this.entry);
        this.entry = null;
    }

    protected final void deflate() throws IOException {
        Deflater deflater = this.def;
        byte[] bArr = this.buf;
        int deflate = deflater.deflate(bArr, 0, bArr.length);
        if (deflate > 0) {
            writeOut(this.buf, 0, deflate);
        }
    }

    public void finish() throws IOException {
        closeEntry();
        this.cdOffset = this.written;
        int size = this.entries.size();
        for (int i2 = 0; i2 < size; i2++) {
            writeCentralFileHeader((ZipEntry) this.entries.elementAt(i2));
        }
        this.cdLength = this.written - this.cdOffset;
        writeCentralDirectoryEnd();
        this.offsets.clear();
        this.entries.removeAllElements();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        OutputStream outputStream = ((FilterOutputStream) this).out;
        if (outputStream != null) {
            outputStream.flush();
        }
    }

    protected byte[] getBytes(String str) throws ZipException {
        String str2 = this.encoding;
        if (str2 == null) {
            return str.getBytes();
        }
        try {
            return str.getBytes(str2);
        } catch (UnsupportedEncodingException e2) {
            throw new ZipException(e2.getMessage());
        }
    }

    public String getEncoding() {
        return this.encoding;
    }

    public boolean isSeekable() {
        return this.raf != null;
    }

    public void putNextEntry(ZipEntry zipEntry) throws IOException {
        closeEntry();
        this.entry = zipEntry;
        this.entries.addElement(zipEntry);
        if (this.entry.getMethod() == -1) {
            this.entry.setMethod(this.method);
        }
        if (this.entry.getTime() == -1) {
            this.entry.setTime(System.currentTimeMillis());
        }
        if (this.entry.getMethod() == 0 && this.raf == null) {
            if (this.entry.getSize() == -1) {
                throw new ZipException("uncompressed size is required for STORED method when not writing to a file");
            }
            if (this.entry.getCrc() == -1) {
                throw new ZipException("crc checksum is required for STORED method when not writing to a file");
            }
            ZipEntry zipEntry2 = this.entry;
            zipEntry2.setCompressedSize(zipEntry2.getSize());
        }
        if (this.entry.getMethod() == 8 && this.hasCompressionLevelChanged) {
            this.def.setLevel(this.level);
            this.hasCompressionLevelChanged = false;
        }
        writeLocalFileHeader(this.entry);
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public void setEncoding(String str) {
        this.encoding = str;
    }

    public void setLevel(int i2) {
        if (i2 >= -1 && i2 <= 9) {
            this.hasCompressionLevelChanged = this.level != i2;
            this.level = i2;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Invalid compression level: ");
            stringBuffer.append(i2);
            throw new IllegalArgumentException(stringBuffer.toString());
        }
    }

    public void setMethod(int i2) {
        this.method = i2;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        if (this.entry.getMethod() != 8) {
            writeOut(bArr, i2, i3);
            this.written += i3;
        } else if (i3 > 0 && !this.def.finished()) {
            this.def.setInput(bArr, i2, i3);
            while (!this.def.needsInput()) {
                deflate();
            }
        }
        this.crc.update(bArr, i2, i3);
    }

    protected void writeCentralDirectoryEnd() throws IOException {
        writeOut(EOCD_SIG);
        byte[] bArr = ZERO;
        writeOut(bArr);
        writeOut(bArr);
        byte[] bytes = ZipShort.getBytes(this.entries.size());
        writeOut(bytes);
        writeOut(bytes);
        writeOut(ZipLong.getBytes(this.cdLength));
        writeOut(ZipLong.getBytes(this.cdOffset));
        byte[] bytes2 = getBytes(this.comment);
        writeOut(ZipShort.getBytes(bytes2.length));
        writeOut(bytes2);
    }

    protected void writeCentralFileHeader(ZipEntry zipEntry) throws IOException {
        writeOut(CFH_SIG);
        this.written += 4;
        writeOut(ZipShort.getBytes((zipEntry.getPlatform() << 8) | 20));
        this.written += 2;
        if (zipEntry.getMethod() == 8 && this.raf == null) {
            writeOut(ZipShort.getBytes(20));
            writeOut(ZipShort.getBytes(8));
        } else {
            writeOut(ZipShort.getBytes(10));
            writeOut(ZERO);
        }
        this.written += 4;
        writeOut(ZipShort.getBytes(zipEntry.getMethod()));
        this.written += 2;
        writeOut(toDosTime(zipEntry.getTime()));
        this.written += 4;
        writeOut(ZipLong.getBytes(zipEntry.getCrc()));
        writeOut(ZipLong.getBytes(zipEntry.getCompressedSize()));
        writeOut(ZipLong.getBytes(zipEntry.getSize()));
        this.written += 12;
        byte[] bytes = getBytes(zipEntry.getName());
        writeOut(ZipShort.getBytes(bytes.length));
        this.written += 2;
        byte[] centralDirectoryExtra = zipEntry.getCentralDirectoryExtra();
        writeOut(ZipShort.getBytes(centralDirectoryExtra.length));
        this.written += 2;
        String comment = zipEntry.getComment();
        if (comment == null) {
            comment = "";
        }
        byte[] bytes2 = getBytes(comment);
        writeOut(ZipShort.getBytes(bytes2.length));
        this.written += 2;
        writeOut(ZERO);
        this.written += 2;
        writeOut(ZipShort.getBytes(zipEntry.getInternalAttributes()));
        this.written += 2;
        writeOut(ZipLong.getBytes(zipEntry.getExternalAttributes()));
        this.written += 4;
        writeOut((byte[]) this.offsets.get(zipEntry));
        this.written += 4;
        writeOut(bytes);
        this.written += bytes.length;
        writeOut(centralDirectoryExtra);
        this.written += centralDirectoryExtra.length;
        writeOut(bytes2);
        this.written += bytes2.length;
    }

    protected void writeDataDescriptor(ZipEntry zipEntry) throws IOException {
        if (zipEntry.getMethod() == 8 && this.raf == null) {
            writeOut(DD_SIG);
            writeOut(ZipLong.getBytes(this.entry.getCrc()));
            writeOut(ZipLong.getBytes(this.entry.getCompressedSize()));
            writeOut(ZipLong.getBytes(this.entry.getSize()));
            this.written += 16;
        }
    }

    protected void writeLocalFileHeader(ZipEntry zipEntry) throws IOException {
        this.offsets.put(zipEntry, ZipLong.getBytes(this.written));
        writeOut(LFH_SIG);
        this.written += 4;
        int method = zipEntry.getMethod();
        if (method == 8 && this.raf == null) {
            writeOut(ZipShort.getBytes(20));
            writeOut(ZipShort.getBytes(8));
        } else {
            writeOut(ZipShort.getBytes(10));
            writeOut(ZERO);
        }
        this.written += 4;
        writeOut(ZipShort.getBytes(method));
        this.written += 2;
        writeOut(toDosTime(zipEntry.getTime()));
        long j2 = this.written + 4;
        this.written = j2;
        this.localDataStart = j2;
        if (method == 8 || this.raf != null) {
            byte[] bArr = LZERO;
            writeOut(bArr);
            writeOut(bArr);
            writeOut(bArr);
        } else {
            writeOut(ZipLong.getBytes(zipEntry.getCrc()));
            writeOut(ZipLong.getBytes(zipEntry.getSize()));
            writeOut(ZipLong.getBytes(zipEntry.getSize()));
        }
        this.written += 12;
        byte[] bytes = getBytes(zipEntry.getName());
        writeOut(ZipShort.getBytes(bytes.length));
        this.written += 2;
        byte[] localFileDataExtra = zipEntry.getLocalFileDataExtra();
        writeOut(ZipShort.getBytes(localFileDataExtra.length));
        this.written += 2;
        writeOut(bytes);
        this.written += bytes.length;
        writeOut(localFileDataExtra);
        long length = this.written + localFileDataExtra.length;
        this.written = length;
        this.dataStart = length;
    }

    protected final void writeOut(byte[] bArr) throws IOException {
        writeOut(bArr, 0, bArr.length);
    }

    protected static byte[] toDosTime(long j2) {
        return new Date(j2).getYear() + 1900 < 1980 ? DOS_TIME_MIN : ZipLong.getBytes(((r2 - 1980) << 25) | ((r0.getMonth() + 1) << 21) | (r0.getDate() << 16) | (r0.getHours() << 11) | (r0.getMinutes() << 5) | (r0.getSeconds() >> 1));
    }

    protected final void writeOut(byte[] bArr, int i2, int i3) throws IOException {
        RandomAccessFile randomAccessFile = this.raf;
        if (randomAccessFile != null) {
            randomAccessFile.write(bArr, i2, i3);
        } else {
            ((FilterOutputStream) this).out.write(bArr, i2, i3);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i2) throws IOException {
        write(new byte[]{(byte) (i2 & 255)}, 0, 1);
    }

    public ZipOutputStream(File file) throws IOException {
        super(null);
        this.comment = "";
        this.level = -1;
        this.hasCompressionLevelChanged = false;
        this.method = 8;
        this.entries = new Vector();
        this.crc = new CRC32();
        this.written = 0L;
        this.dataStart = 0L;
        this.localDataStart = 0L;
        this.cdOffset = 0L;
        this.cdLength = 0L;
        this.offsets = new Hashtable();
        this.encoding = null;
        this.def = new Deflater(this.level, true);
        this.buf = new byte[512];
        this.raf = null;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.raf = randomAccessFile;
            randomAccessFile.setLength(0L);
        } catch (IOException unused) {
            RandomAccessFile randomAccessFile2 = this.raf;
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (IOException unused2) {
                }
                this.raf = null;
            }
            ((FilterOutputStream) this).out = new FileOutputStream(file);
        }
    }
}
