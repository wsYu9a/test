package com.alimm.tanx.ui.image.glide.gifdecoder;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;

/* loaded from: classes.dex */
public class GifDecoder {
    private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
    private static final int DISPOSAL_BACKGROUND = 2;
    private static final int DISPOSAL_NONE = 1;
    private static final int DISPOSAL_PREVIOUS = 3;
    private static final int DISPOSAL_UNSPECIFIED = 0;
    private static final int INITIAL_FRAME_POINTER = -1;
    private static final int MAX_STACK_SIZE = 4096;
    private static final int NULL_CODE = -1;
    public static final int STATUS_FORMAT_ERROR = 1;
    public static final int STATUS_OK = 0;
    public static final int STATUS_OPEN_ERROR = 2;
    public static final int STATUS_PARTIAL_DECODE = 3;
    private static final String TAG = "GifDecoder";
    public static final int TOTAL_ITERATION_COUNT_FOREVER = 0;
    private int[] act;
    private BitmapProvider bitmapProvider;
    private byte[] data;
    private int framePointer;
    private byte[] mainPixels;
    private int[] mainScratch;
    private GifHeaderParser parser;
    private byte[] pixelStack;
    private short[] prefix;
    private Bitmap previousImage;
    private ByteBuffer rawData;
    private boolean savePrevious;
    private int status;
    private byte[] suffix;
    private final int[] pct = new int[256];
    private final byte[] block = new byte[256];
    private GifHeader header = new GifHeader();

    public interface BitmapProvider {
        Bitmap obtain(int i10, int i11, Bitmap.Config config);

        void release(Bitmap bitmap);
    }

    public GifDecoder(BitmapProvider bitmapProvider) {
        this.bitmapProvider = bitmapProvider;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v16, types: [short] */
    /* JADX WARN: Type inference failed for: r3v18 */
    private void decodeBitmapData(GifFrame gifFrame) {
        int i10;
        int i11;
        int i12;
        short s10;
        if (gifFrame != null) {
            this.rawData.position(gifFrame.bufferFrameStart);
        }
        if (gifFrame == null) {
            GifHeader gifHeader = this.header;
            i10 = gifHeader.width;
            i11 = gifHeader.height;
        } else {
            i10 = gifFrame.iw;
            i11 = gifFrame.f6324ih;
        }
        int i13 = i10 * i11;
        byte[] bArr = this.mainPixels;
        if (bArr == null || bArr.length < i13) {
            this.mainPixels = new byte[i13];
        }
        if (this.prefix == null) {
            this.prefix = new short[4096];
        }
        if (this.suffix == null) {
            this.suffix = new byte[4096];
        }
        if (this.pixelStack == null) {
            this.pixelStack = new byte[4097];
        }
        int read = read();
        int i14 = 1;
        int i15 = 1 << read;
        int i16 = i15 + 1;
        int i17 = i15 + 2;
        int i18 = read + 1;
        int i19 = (1 << i18) - 1;
        for (int i20 = 0; i20 < i15; i20++) {
            this.prefix[i20] = 0;
            this.suffix[i20] = (byte) i20;
        }
        int i21 = -1;
        int i22 = i18;
        int i23 = i17;
        int i24 = i19;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        int i30 = 0;
        int i31 = 0;
        int i32 = 0;
        int i33 = -1;
        while (true) {
            if (i25 >= i13) {
                break;
            }
            if (i26 == 0) {
                i26 = readBlock();
                if (i26 <= 0) {
                    this.status = 3;
                    break;
                }
                i28 = 0;
            }
            i27 += (this.block[i28] & 255) << i29;
            i29 += 8;
            i28 += i14;
            i26 += i21;
            int i34 = i31;
            int i35 = i23;
            int i36 = i22;
            int i37 = i33;
            while (i29 >= i36) {
                int i38 = i27 & i24;
                i27 >>= i36;
                i29 -= i36;
                if (i38 != i15) {
                    if (i38 > i35) {
                        i12 = i18;
                        this.status = 3;
                    } else {
                        i12 = i18;
                        if (i38 != i16) {
                            int i39 = i16;
                            int i40 = i37;
                            if (i40 == -1) {
                                this.pixelStack[i32] = this.suffix[i38];
                                i32++;
                                i34 = i38;
                                i37 = i34;
                                i16 = i39;
                                i18 = i12;
                            } else {
                                if (i38 >= i35) {
                                    this.pixelStack[i32] = (byte) i34;
                                    s10 = i40;
                                    i32++;
                                } else {
                                    s10 = i38;
                                }
                                while (s10 >= i15) {
                                    this.pixelStack[i32] = this.suffix[s10];
                                    s10 = this.prefix[s10];
                                    i32++;
                                    i15 = i15;
                                }
                                int i41 = i15;
                                byte[] bArr2 = this.suffix;
                                i34 = bArr2[s10] & 255;
                                int i42 = i32 + 1;
                                int i43 = i17;
                                byte b10 = (byte) i34;
                                this.pixelStack[i32] = b10;
                                if (i35 < 4096) {
                                    this.prefix[i35] = (short) i40;
                                    bArr2[i35] = b10;
                                    i35++;
                                    if ((i35 & i24) == 0 && i35 < 4096) {
                                        i36++;
                                        i24 += i35;
                                    }
                                }
                                i32 = i42;
                                while (i32 > 0) {
                                    i32--;
                                    this.mainPixels[i30] = this.pixelStack[i32];
                                    i25++;
                                    i30++;
                                }
                                i37 = i38;
                                i16 = i39;
                                i18 = i12;
                                i15 = i41;
                                i17 = i43;
                            }
                        }
                    }
                    i31 = i34;
                    i23 = i35;
                    i22 = i36;
                    i18 = i12;
                    i33 = i37;
                    i14 = 1;
                    i21 = -1;
                    break;
                }
                i36 = i18;
                i35 = i17;
                i24 = i19;
                i37 = -1;
            }
            i31 = i34;
            i23 = i35;
            i22 = i36;
            i14 = 1;
            i21 = -1;
            i33 = i37;
            i18 = i18;
        }
        for (int i44 = i30; i44 < i13; i44++) {
            this.mainPixels[i44] = 0;
        }
    }

    private GifHeaderParser getHeaderParser() {
        if (this.parser == null) {
            this.parser = new GifHeaderParser();
        }
        return this.parser;
    }

    private Bitmap getNextBitmap() {
        BitmapProvider bitmapProvider = this.bitmapProvider;
        GifHeader gifHeader = this.header;
        int i10 = gifHeader.width;
        int i11 = gifHeader.height;
        Bitmap.Config config = BITMAP_CONFIG;
        Bitmap obtain = bitmapProvider.obtain(i10, i11, config);
        if (obtain == null) {
            GifHeader gifHeader2 = this.header;
            obtain = Bitmap.createBitmap(gifHeader2.width, gifHeader2.height, config);
        }
        setAlpha(obtain);
        return obtain;
    }

    private int readBlock() {
        int read = read();
        int i10 = 0;
        if (read > 0) {
            while (i10 < read) {
                int i11 = read - i10;
                try {
                    this.rawData.get(this.block, i10, i11);
                    i10 += i11;
                } catch (Exception e10) {
                    Log.w(TAG, "Error Reading Block", e10);
                    this.status = 1;
                }
            }
        }
        return i10;
    }

    @TargetApi(12)
    private static void setAlpha(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
    
        if (r4.bgIndex == r17.transIndex) goto L164;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bc A[EDGE_INSN: B:59:0x00bc->B:60:0x00bc BREAK  A[LOOP:2: B:29:0x0067->B:56:0x00b7], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.graphics.Bitmap setPixels(com.alimm.tanx.ui.image.glide.gifdecoder.GifFrame r17, com.alimm.tanx.ui.image.glide.gifdecoder.GifFrame r18) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder.setPixels(com.alimm.tanx.ui.image.glide.gifdecoder.GifFrame, com.alimm.tanx.ui.image.glide.gifdecoder.GifFrame):android.graphics.Bitmap");
    }

    public void advance() {
        this.framePointer = (this.framePointer + 1) % this.header.frameCount;
    }

    public void clear() {
        this.header = null;
        this.data = null;
        this.mainPixels = null;
        this.mainScratch = null;
        Bitmap bitmap = this.previousImage;
        if (bitmap != null) {
            this.bitmapProvider.release(bitmap);
        }
        this.previousImage = null;
        this.rawData = null;
    }

    public int getCurrentFrameIndex() {
        return this.framePointer;
    }

    public byte[] getData() {
        return this.data;
    }

    public int getDelay(int i10) {
        if (i10 >= 0) {
            GifHeader gifHeader = this.header;
            if (i10 < gifHeader.frameCount) {
                return gifHeader.frames.get(i10).delay;
            }
        }
        return -1;
    }

    public int getFrameCount() {
        return this.header.frameCount;
    }

    public int getHeight() {
        return this.header.height;
    }

    @Deprecated
    public int getLoopCount() {
        int i10 = this.header.loopCount;
        if (i10 == -1) {
            return 1;
        }
        return i10;
    }

    public int getNetscapeLoopCount() {
        return this.header.loopCount;
    }

    public int getNextDelay() {
        int i10;
        if (this.header.frameCount <= 0 || (i10 = this.framePointer) < 0) {
            return -1;
        }
        return getDelay(i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0056 A[Catch: all -> 0x000e, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x0039, B:13:0x0042, B:15:0x0056, B:16:0x0062, B:19:0x006b, B:21:0x006f, B:23:0x0077, B:24:0x007c, B:28:0x0080, B:30:0x0084, B:31:0x0092, B:34:0x0067, B:36:0x0098, B:38:0x00a0, B:41:0x0011, B:43:0x0019, B:44:0x0037), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006f A[Catch: all -> 0x000e, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x0039, B:13:0x0042, B:15:0x0056, B:16:0x0062, B:19:0x006b, B:21:0x006f, B:23:0x0077, B:24:0x007c, B:28:0x0080, B:30:0x0084, B:31:0x0092, B:34:0x0067, B:36:0x0098, B:38:0x00a0, B:41:0x0011, B:43:0x0019, B:44:0x0037), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0080 A[Catch: all -> 0x000e, TRY_ENTER, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x0039, B:13:0x0042, B:15:0x0056, B:16:0x0062, B:19:0x006b, B:21:0x006f, B:23:0x0077, B:24:0x007c, B:28:0x0080, B:30:0x0084, B:31:0x0092, B:34:0x0067, B:36:0x0098, B:38:0x00a0, B:41:0x0011, B:43:0x0019, B:44:0x0037), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0067 A[Catch: all -> 0x000e, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x0039, B:13:0x0042, B:15:0x0056, B:16:0x0062, B:19:0x006b, B:21:0x006f, B:23:0x0077, B:24:0x007c, B:28:0x0080, B:30:0x0084, B:31:0x0092, B:34:0x0067, B:36:0x0098, B:38:0x00a0, B:41:0x0011, B:43:0x0019, B:44:0x0037), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a0 A[Catch: all -> 0x000e, TRY_LEAVE, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x0039, B:13:0x0042, B:15:0x0056, B:16:0x0062, B:19:0x006b, B:21:0x006f, B:23:0x0077, B:24:0x007c, B:28:0x0080, B:30:0x0084, B:31:0x0092, B:34:0x0067, B:36:0x0098, B:38:0x00a0, B:41:0x0011, B:43:0x0019, B:44:0x0037), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized android.graphics.Bitmap getNextFrame() {
        /*
            r7 = this;
            monitor-enter(r7)
            com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader r0 = r7.header     // Catch: java.lang.Throwable -> Le
            int r0 = r0.frameCount     // Catch: java.lang.Throwable -> Le
            r1 = 3
            r2 = 1
            if (r0 <= 0) goto L11
            int r0 = r7.framePointer     // Catch: java.lang.Throwable -> Le
            if (r0 >= 0) goto L39
            goto L11
        Le:
            r0 = move-exception
            goto Lb4
        L11:
            java.lang.String r0 = com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder.TAG     // Catch: java.lang.Throwable -> Le
            boolean r3 = android.util.Log.isLoggable(r0, r1)     // Catch: java.lang.Throwable -> Le
            if (r3 == 0) goto L37
            java.lang.String r3 = "unable to decode frame, frameCount="
            java.lang.StringBuilder r3 = ok.a.a(r3)     // Catch: java.lang.Throwable -> Le
            com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader r4 = r7.header     // Catch: java.lang.Throwable -> Le
            int r4 = r4.frameCount     // Catch: java.lang.Throwable -> Le
            r3.append(r4)     // Catch: java.lang.Throwable -> Le
            java.lang.String r4 = " framePointer="
            r3.append(r4)     // Catch: java.lang.Throwable -> Le
            int r4 = r7.framePointer     // Catch: java.lang.Throwable -> Le
            r3.append(r4)     // Catch: java.lang.Throwable -> Le
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> Le
            android.util.Log.d(r0, r3)     // Catch: java.lang.Throwable -> Le
        L37:
            r7.status = r2     // Catch: java.lang.Throwable -> Le
        L39:
            int r0 = r7.status     // Catch: java.lang.Throwable -> Le
            r3 = 0
            if (r0 == r2) goto L98
            r4 = 2
            if (r0 != r4) goto L42
            goto L98
        L42:
            r0 = 0
            r7.status = r0     // Catch: java.lang.Throwable -> Le
            com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader r4 = r7.header     // Catch: java.lang.Throwable -> Le
            java.util.List<com.alimm.tanx.ui.image.glide.gifdecoder.GifFrame> r4 = r4.frames     // Catch: java.lang.Throwable -> Le
            int r5 = r7.framePointer     // Catch: java.lang.Throwable -> Le
            java.lang.Object r4 = r4.get(r5)     // Catch: java.lang.Throwable -> Le
            com.alimm.tanx.ui.image.glide.gifdecoder.GifFrame r4 = (com.alimm.tanx.ui.image.glide.gifdecoder.GifFrame) r4     // Catch: java.lang.Throwable -> Le
            int r5 = r7.framePointer     // Catch: java.lang.Throwable -> Le
            int r5 = r5 - r2
            if (r5 < 0) goto L61
            com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader r6 = r7.header     // Catch: java.lang.Throwable -> Le
            java.util.List<com.alimm.tanx.ui.image.glide.gifdecoder.GifFrame> r6 = r6.frames     // Catch: java.lang.Throwable -> Le
            java.lang.Object r5 = r6.get(r5)     // Catch: java.lang.Throwable -> Le
            com.alimm.tanx.ui.image.glide.gifdecoder.GifFrame r5 = (com.alimm.tanx.ui.image.glide.gifdecoder.GifFrame) r5     // Catch: java.lang.Throwable -> Le
            goto L62
        L61:
            r5 = r3
        L62:
            int[] r6 = r4.lct     // Catch: java.lang.Throwable -> Le
            if (r6 == 0) goto L67
            goto L6b
        L67:
            com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader r6 = r7.header     // Catch: java.lang.Throwable -> Le
            int[] r6 = r6.gct     // Catch: java.lang.Throwable -> Le
        L6b:
            r7.act = r6     // Catch: java.lang.Throwable -> Le
            if (r6 != 0) goto L80
            java.lang.String r0 = com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder.TAG     // Catch: java.lang.Throwable -> Le
            boolean r1 = android.util.Log.isLoggable(r0, r1)     // Catch: java.lang.Throwable -> Le
            if (r1 == 0) goto L7c
            java.lang.String r1 = "No Valid Color Table"
            android.util.Log.d(r0, r1)     // Catch: java.lang.Throwable -> Le
        L7c:
            r7.status = r2     // Catch: java.lang.Throwable -> Le
            monitor-exit(r7)
            return r3
        L80:
            boolean r1 = r4.transparency     // Catch: java.lang.Throwable -> Le
            if (r1 == 0) goto L92
            int[] r1 = r7.pct     // Catch: java.lang.Throwable -> Le
            int r2 = r6.length     // Catch: java.lang.Throwable -> Le
            java.lang.System.arraycopy(r6, r0, r1, r0, r2)     // Catch: java.lang.Throwable -> Le
            int[] r1 = r7.pct     // Catch: java.lang.Throwable -> Le
            r7.act = r1     // Catch: java.lang.Throwable -> Le
            int r2 = r4.transIndex     // Catch: java.lang.Throwable -> Le
            r1[r2] = r0     // Catch: java.lang.Throwable -> Le
        L92:
            android.graphics.Bitmap r0 = r7.setPixels(r4, r5)     // Catch: java.lang.Throwable -> Le
            monitor-exit(r7)
            return r0
        L98:
            java.lang.String r0 = com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder.TAG     // Catch: java.lang.Throwable -> Le
            boolean r1 = android.util.Log.isLoggable(r0, r1)     // Catch: java.lang.Throwable -> Le
            if (r1 == 0) goto Lb2
            java.lang.String r1 = "Unable to decode frame, status="
            java.lang.StringBuilder r1 = ok.a.a(r1)     // Catch: java.lang.Throwable -> Le
            int r2 = r7.status     // Catch: java.lang.Throwable -> Le
            r1.append(r2)     // Catch: java.lang.Throwable -> Le
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Le
            android.util.Log.d(r0, r1)     // Catch: java.lang.Throwable -> Le
        Lb2:
            monitor-exit(r7)
            return r3
        Lb4:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> Le
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder.getNextFrame():android.graphics.Bitmap");
    }

    public int getStatus() {
        return this.status;
    }

    public int getTotalIterationCount() {
        int i10 = this.header.loopCount;
        if (i10 == -1) {
            return 1;
        }
        if (i10 == 0) {
            return 0;
        }
        return i10 + 1;
    }

    public int getWidth() {
        return this.header.width;
    }

    public int read(InputStream inputStream, int i10) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i10 > 0 ? i10 + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr, 0, 16384);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                read(byteArrayOutputStream.toByteArray());
            } catch (IOException e10) {
                Log.w(TAG, "Error reading data from stream", e10);
            }
        } else {
            this.status = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e11) {
                Log.w(TAG, "Error closing stream", e11);
            }
        }
        return this.status;
    }

    public void resetFrameIndex() {
        this.framePointer = -1;
    }

    public void setData(GifHeader gifHeader, byte[] bArr) {
        this.header = gifHeader;
        this.data = bArr;
        this.status = 0;
        this.framePointer = -1;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.rawData = wrap;
        wrap.rewind();
        this.rawData.order(ByteOrder.LITTLE_ENDIAN);
        this.savePrevious = false;
        Iterator<GifFrame> it = gifHeader.frames.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().dispose == 3) {
                this.savePrevious = true;
                break;
            }
        }
        int i10 = gifHeader.width * gifHeader.height;
        this.mainPixels = new byte[i10];
        this.mainScratch = new int[i10];
    }

    public int read(byte[] bArr) {
        this.data = bArr;
        this.header = getHeaderParser().setData(bArr).parseHeader();
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.rawData = wrap;
            wrap.rewind();
            this.rawData.order(ByteOrder.LITTLE_ENDIAN);
            GifHeader gifHeader = this.header;
            int i10 = gifHeader.width * gifHeader.height;
            this.mainPixels = new byte[i10];
            this.mainScratch = new int[i10];
            this.savePrevious = false;
            Iterator<GifFrame> it = gifHeader.frames.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (it.next().dispose == 3) {
                    this.savePrevious = true;
                    break;
                }
            }
        }
        return this.status;
    }

    private int read() {
        try {
            return this.rawData.get() & 255;
        } catch (Exception unused) {
            this.status = 1;
            return 0;
        }
    }
}
