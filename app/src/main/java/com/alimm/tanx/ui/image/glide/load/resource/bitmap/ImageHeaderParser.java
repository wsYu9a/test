package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

import android.util.Log;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.MotionEventCompat;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class ImageHeaderParser {
    private static final int[] BYTES_PER_FORMAT = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    private static final int EXIF_MAGIC_NUMBER = 65496;
    private static final int EXIF_SEGMENT_TYPE = 225;
    private static final int GIF_HEADER = 4671814;
    private static final int INTEL_TIFF_MAGIC_NUMBER = 18761;
    private static final String JPEG_EXIF_SEGMENT_PREAMBLE = "Exif\u0000\u0000";
    private static final byte[] JPEG_EXIF_SEGMENT_PREAMBLE_BYTES;
    private static final int MARKER_EOI = 217;
    private static final int MOTOROLA_TIFF_MAGIC_NUMBER = 19789;
    private static final int ORIENTATION_TAG_TYPE = 274;
    private static final int PNG_HEADER = -1991225785;
    private static final int SEGMENT_SOS = 218;
    private static final int SEGMENT_START_ID = 255;
    private static final String TAG = "ImageHeaderParser";
    private final StreamReader streamReader;

    public enum ImageType {
        GIF(true),
        JPEG(false),
        PNG_A(true),
        PNG(false),
        UNKNOWN(false);

        private final boolean hasAlpha;

        ImageType(boolean z10) {
            this.hasAlpha = z10;
        }

        public boolean hasAlpha() {
            return this.hasAlpha;
        }
    }

    public static class RandomAccessReader {
        private final ByteBuffer data;

        public RandomAccessReader(byte[] bArr) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.data = wrap;
            wrap.order(ByteOrder.BIG_ENDIAN);
        }

        public short getInt16(int i10) {
            return this.data.getShort(i10);
        }

        public int getInt32(int i10) {
            return this.data.getInt(i10);
        }

        public int length() {
            return this.data.array().length;
        }

        public void order(ByteOrder byteOrder) {
            this.data.order(byteOrder);
        }
    }

    public static class StreamReader {
        private final InputStream is;

        public StreamReader(InputStream inputStream) {
            this.is = inputStream;
        }

        public int getByte() throws IOException {
            return this.is.read();
        }

        public int getUInt16() throws IOException {
            return ((this.is.read() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (this.is.read() & 255);
        }

        public short getUInt8() throws IOException {
            return (short) (this.is.read() & 255);
        }

        public int read(byte[] bArr) throws IOException {
            int length = bArr.length;
            while (length > 0) {
                int read = this.is.read(bArr, bArr.length - length, length);
                if (read == -1) {
                    break;
                }
                length -= read;
            }
            return bArr.length - length;
        }

        public long skip(long j10) throws IOException {
            if (j10 < 0) {
                return 0L;
            }
            long j11 = j10;
            while (j11 > 0) {
                long skip = this.is.skip(j11);
                if (skip <= 0) {
                    if (this.is.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j11 -= skip;
            }
            return j10 - j11;
        }
    }

    static {
        byte[] bArr = new byte[0];
        try {
            bArr = JPEG_EXIF_SEGMENT_PREAMBLE.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
        }
        JPEG_EXIF_SEGMENT_PREAMBLE_BYTES = bArr;
    }

    public ImageHeaderParser(InputStream inputStream) {
        this.streamReader = new StreamReader(inputStream);
    }

    private static int calcTagOffset(int i10, int i11) {
        return (i11 * 12) + i10 + 2;
    }

    private byte[] getExifSegment() throws IOException {
        short uInt8;
        int uInt16;
        long j10;
        long skip;
        do {
            short uInt82 = this.streamReader.getUInt8();
            if (uInt82 != 255) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Unknown segmentId=" + ((int) uInt82));
                }
                return null;
            }
            uInt8 = this.streamReader.getUInt8();
            if (uInt8 == SEGMENT_SOS) {
                return null;
            }
            if (uInt8 == MARKER_EOI) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Found MARKER_EOI in exif segment");
                }
                return null;
            }
            uInt16 = this.streamReader.getUInt16() - 2;
            if (uInt8 == EXIF_SEGMENT_TYPE) {
                byte[] bArr = new byte[uInt16];
                int read = this.streamReader.read(bArr);
                if (read == uInt16) {
                    return bArr;
                }
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Unable to read segment data, type: " + ((int) uInt8) + ", length: " + uInt16 + ", actually read: " + read);
                }
                return null;
            }
            j10 = uInt16;
            skip = this.streamReader.skip(j10);
        } while (skip == j10);
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "Unable to skip enough data, type: " + ((int) uInt8) + ", wanted to skip: " + uInt16 + ", but actually skipped: " + skip);
        }
        return null;
    }

    private static boolean handles(int i10) {
        return (i10 & EXIF_MAGIC_NUMBER) == EXIF_MAGIC_NUMBER || i10 == MOTOROLA_TIFF_MAGIC_NUMBER || i10 == INTEL_TIFF_MAGIC_NUMBER;
    }

    private static int parseExifSegment(RandomAccessReader randomAccessReader) {
        ByteOrder byteOrder;
        short int16 = randomAccessReader.getInt16(6);
        if (int16 == MOTOROLA_TIFF_MAGIC_NUMBER) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else if (int16 == INTEL_TIFF_MAGIC_NUMBER) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Unknown endianness = " + ((int) int16));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        randomAccessReader.order(byteOrder);
        int int32 = randomAccessReader.getInt32(10) + 6;
        short int162 = randomAccessReader.getInt16(int32);
        for (int i10 = 0; i10 < int162; i10++) {
            int calcTagOffset = calcTagOffset(int32, i10);
            short int163 = randomAccessReader.getInt16(calcTagOffset);
            if (int163 == ORIENTATION_TAG_TYPE) {
                short int164 = randomAccessReader.getInt16(calcTagOffset + 2);
                if (int164 >= 1 && int164 <= 12) {
                    int int322 = randomAccessReader.getInt32(calcTagOffset + 4);
                    if (int322 >= 0) {
                        if (Log.isLoggable(TAG, 3)) {
                            Log.d(TAG, "Got tagIndex=" + i10 + " tagType=" + ((int) int163) + " formatCode=" + ((int) int164) + " componentCount=" + int322);
                        }
                        int i11 = int322 + BYTES_PER_FORMAT[int164];
                        if (i11 <= 4) {
                            int i12 = calcTagOffset + 8;
                            if (i12 >= 0 && i12 <= randomAccessReader.length()) {
                                if (i11 >= 0 && i11 + i12 <= randomAccessReader.length()) {
                                    return randomAccessReader.getInt16(i12);
                                }
                                if (Log.isLoggable(TAG, 3)) {
                                    Log.d(TAG, "Illegal number of bytes for TI tag data tagType=" + ((int) int163));
                                }
                            } else if (Log.isLoggable(TAG, 3)) {
                                Log.d(TAG, "Illegal tagValueOffset=" + i12 + " tagType=" + ((int) int163));
                            }
                        } else if (Log.isLoggable(TAG, 3)) {
                            Log.d(TAG, "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) int164));
                        }
                    } else if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "Negative tiff component count");
                    }
                } else if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Got invalid format code=" + ((int) int164));
                }
            }
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getOrientation() throws java.io.IOException {
        /*
            r7 = this;
            com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageHeaderParser$StreamReader r0 = r7.streamReader
            int r0 = r0.getUInt16()
            boolean r0 = handles(r0)
            r1 = -1
            if (r0 != 0) goto Le
            return r1
        Le:
            byte[] r0 = r7.getExifSegment()
            r2 = 0
            if (r0 == 0) goto L1d
            int r3 = r0.length
            byte[] r4 = com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageHeaderParser.JPEG_EXIF_SEGMENT_PREAMBLE_BYTES
            int r4 = r4.length
            if (r3 <= r4) goto L1d
            r3 = 1
            goto L1e
        L1d:
            r3 = 0
        L1e:
            if (r3 == 0) goto L30
            r4 = 0
        L21:
            byte[] r5 = com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageHeaderParser.JPEG_EXIF_SEGMENT_PREAMBLE_BYTES
            int r6 = r5.length
            if (r4 >= r6) goto L30
            r6 = r0[r4]
            r5 = r5[r4]
            if (r6 == r5) goto L2d
            goto L31
        L2d:
            int r4 = r4 + 1
            goto L21
        L30:
            r2 = r3
        L31:
            if (r2 == 0) goto L3d
            com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageHeaderParser$RandomAccessReader r1 = new com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageHeaderParser$RandomAccessReader
            r1.<init>(r0)
            int r0 = parseExifSegment(r1)
            return r0
        L3d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageHeaderParser.getOrientation():int");
    }

    public ImageType getType() throws IOException {
        int uInt16 = this.streamReader.getUInt16();
        if (uInt16 == EXIF_MAGIC_NUMBER) {
            return ImageType.JPEG;
        }
        int uInt162 = ((uInt16 << 16) & SupportMenu.CATEGORY_MASK) | (this.streamReader.getUInt16() & 65535);
        if (uInt162 != PNG_HEADER) {
            return (uInt162 >> 8) == GIF_HEADER ? ImageType.GIF : ImageType.UNKNOWN;
        }
        this.streamReader.skip(21L);
        return this.streamReader.getByte() >= 3 ? ImageType.PNG_A : ImageType.PNG;
    }

    public boolean hasAlpha() throws IOException {
        return getType().hasAlpha();
    }
}
