package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.alimm.tanx.ui.image.glide.load.DecodeFormat;
import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool;
import com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageHeaderParser;
import com.alimm.tanx.ui.image.glide.util.ByteArrayPool;
import com.alimm.tanx.ui.image.glide.util.ExceptionCatchingInputStream;
import com.alimm.tanx.ui.image.glide.util.MarkEnforcingInputStream;
import com.alimm.tanx.ui.image.glide.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.util.EnumSet;
import java.util.Queue;
import java.util.Set;
import ok.a;

/* loaded from: classes.dex */
public abstract class Downsampler implements BitmapDecoder<InputStream> {
    private static final int MARK_POSITION = 5242880;
    private static final String TAG = "Downsampler";
    private static final Set<ImageHeaderParser.ImageType> TYPES_THAT_USE_POOL = EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG);
    private static final Queue<BitmapFactory.Options> OPTIONS_QUEUE = Util.createQueue(0);
    public static final Downsampler AT_LEAST = new Downsampler() { // from class: com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler.1
        @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler, com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapDecoder
        public /* bridge */ /* synthetic */ Bitmap decode(InputStream inputStream, BitmapPool bitmapPool, int i10, int i11, DecodeFormat decodeFormat) throws Exception {
            return super.decode(inputStream, bitmapPool, i10, i11, decodeFormat);
        }

        @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapDecoder
        public String getId() {
            return "AT_LEAST.com.alimm.tanx.ui.image.glide.load.data.bitmap";
        }

        @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler
        public int getSampleSize(int i10, int i11, int i12, int i13) {
            return Math.min(i11 / i13, i10 / i12);
        }
    };
    public static final Downsampler AT_MOST = new Downsampler() { // from class: com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler.2
        @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler, com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapDecoder
        public /* bridge */ /* synthetic */ Bitmap decode(InputStream inputStream, BitmapPool bitmapPool, int i10, int i11, DecodeFormat decodeFormat) throws Exception {
            return super.decode(inputStream, bitmapPool, i10, i11, decodeFormat);
        }

        @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapDecoder
        public String getId() {
            return "AT_MOST.com.alimm.tanx.ui.image.glide.load.data.bitmap";
        }

        @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler
        public int getSampleSize(int i10, int i11, int i12, int i13) {
            int ceil = (int) Math.ceil(Math.max(i11 / i13, i10 / i12));
            int max = Math.max(1, Integer.highestOneBit(ceil));
            return max << (max >= ceil ? 0 : 1);
        }
    };
    public static final Downsampler NONE = new Downsampler() { // from class: com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler.3
        @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler, com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapDecoder
        public /* bridge */ /* synthetic */ Bitmap decode(InputStream inputStream, BitmapPool bitmapPool, int i10, int i11, DecodeFormat decodeFormat) throws Exception {
            return super.decode(inputStream, bitmapPool, i10, i11, decodeFormat);
        }

        @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapDecoder
        public String getId() {
            return "NONE.com.alimm.tanx.ui.image.glide.load.data.bitmap";
        }

        @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler
        public int getSampleSize(int i10, int i11, int i12, int i13) {
            return 0;
        }
    };

    /* renamed from: com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler$1 */
    public static class AnonymousClass1 extends Downsampler {
        @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler, com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapDecoder
        public /* bridge */ /* synthetic */ Bitmap decode(InputStream inputStream, BitmapPool bitmapPool, int i10, int i11, DecodeFormat decodeFormat) throws Exception {
            return super.decode(inputStream, bitmapPool, i10, i11, decodeFormat);
        }

        @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapDecoder
        public String getId() {
            return "AT_LEAST.com.alimm.tanx.ui.image.glide.load.data.bitmap";
        }

        @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler
        public int getSampleSize(int i10, int i11, int i12, int i13) {
            return Math.min(i11 / i13, i10 / i12);
        }
    }

    /* renamed from: com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler$2 */
    public static class AnonymousClass2 extends Downsampler {
        @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler, com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapDecoder
        public /* bridge */ /* synthetic */ Bitmap decode(InputStream inputStream, BitmapPool bitmapPool, int i10, int i11, DecodeFormat decodeFormat) throws Exception {
            return super.decode(inputStream, bitmapPool, i10, i11, decodeFormat);
        }

        @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapDecoder
        public String getId() {
            return "AT_MOST.com.alimm.tanx.ui.image.glide.load.data.bitmap";
        }

        @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler
        public int getSampleSize(int i10, int i11, int i12, int i13) {
            int ceil = (int) Math.ceil(Math.max(i11 / i13, i10 / i12));
            int max = Math.max(1, Integer.highestOneBit(ceil));
            return max << (max >= ceil ? 0 : 1);
        }
    }

    /* renamed from: com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler$3 */
    public static class AnonymousClass3 extends Downsampler {
        @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler, com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapDecoder
        public /* bridge */ /* synthetic */ Bitmap decode(InputStream inputStream, BitmapPool bitmapPool, int i10, int i11, DecodeFormat decodeFormat) throws Exception {
            return super.decode(inputStream, bitmapPool, i10, i11, decodeFormat);
        }

        @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapDecoder
        public String getId() {
            return "NONE.com.alimm.tanx.ui.image.glide.load.data.bitmap";
        }

        @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler
        public int getSampleSize(int i10, int i11, int i12, int i13) {
            return 0;
        }
    }

    private static Bitmap decodeStream(MarkEnforcingInputStream markEnforcingInputStream, RecyclableBufferedInputStream recyclableBufferedInputStream, BitmapFactory.Options options) {
        if (options.inJustDecodeBounds) {
            markEnforcingInputStream.mark(MARK_POSITION);
        } else {
            recyclableBufferedInputStream.fixMarkLimit();
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(markEnforcingInputStream, null, options);
        try {
            if (options.inJustDecodeBounds) {
                markEnforcingInputStream.reset();
            }
        } catch (IOException e10) {
            if (Log.isLoggable(TAG, 6)) {
                StringBuilder a10 = a.a("Exception loading inDecodeBounds=");
                a10.append(options.inJustDecodeBounds);
                a10.append(" sample=");
                a10.append(options.inSampleSize);
                Log.e(TAG, a10.toString(), e10);
            }
        }
        return decodeStream;
    }

    private Bitmap downsampleWithSize(MarkEnforcingInputStream markEnforcingInputStream, RecyclableBufferedInputStream recyclableBufferedInputStream, BitmapFactory.Options options, BitmapPool bitmapPool, int i10, int i11, int i12, DecodeFormat decodeFormat) {
        Bitmap.Config config = getConfig(markEnforcingInputStream, decodeFormat);
        options.inSampleSize = i12;
        options.inPreferredConfig = config;
        if (shouldUsePool(markEnforcingInputStream)) {
            double d10 = i12;
            setInBitmap(options, bitmapPool.getDirty((int) Math.ceil(i10 / d10), (int) Math.ceil(i11 / d10), config));
        }
        return decodeStream(markEnforcingInputStream, recyclableBufferedInputStream, options);
    }

    private static Bitmap.Config getConfig(InputStream inputStream, DecodeFormat decodeFormat) {
        boolean z10;
        if (decodeFormat == DecodeFormat.ALWAYS_ARGB_8888 || decodeFormat == DecodeFormat.PREFER_ARGB_8888) {
            return Bitmap.Config.ARGB_8888;
        }
        inputStream.mark(1024);
        try {
            try {
                z10 = new ImageHeaderParser(inputStream).hasAlpha();
            } catch (IOException e10) {
                if (Log.isLoggable(TAG, 5)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Cannot determine whether the image has alpha or not from header for format ");
                    sb2.append(decodeFormat);
                    Log.w(TAG, sb2.toString(), e10);
                }
                try {
                    inputStream.reset();
                } catch (IOException e11) {
                    if (Log.isLoggable(TAG, 5)) {
                        Log.w(TAG, "Cannot reset the input stream", e11);
                    }
                }
                z10 = false;
            }
            return z10 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        } finally {
            try {
                inputStream.reset();
            } catch (IOException e12) {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Cannot reset the input stream", e12);
                }
            }
        }
    }

    @TargetApi(11)
    private static synchronized BitmapFactory.Options getDefaultOptions() {
        BitmapFactory.Options poll;
        synchronized (Downsampler.class) {
            Queue<BitmapFactory.Options> queue = OPTIONS_QUEUE;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                resetOptions(poll);
            }
        }
        return poll;
    }

    private int getRoundedSampleSize(int i10, int i11, int i12, int i13, int i14) {
        if (i14 == Integer.MIN_VALUE) {
            i14 = i12;
        }
        if (i13 == Integer.MIN_VALUE) {
            i13 = i11;
        }
        int sampleSize = (i10 == 90 || i10 == 270) ? getSampleSize(i12, i11, i13, i14) : getSampleSize(i11, i12, i13, i14);
        return Math.max(1, sampleSize == 0 ? 0 : Integer.highestOneBit(sampleSize));
    }

    private static void releaseOptions(BitmapFactory.Options options) {
        resetOptions(options);
        Queue<BitmapFactory.Options> queue = OPTIONS_QUEUE;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    @TargetApi(11)
    private static void resetOptions(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    @TargetApi(11)
    private static void setInBitmap(BitmapFactory.Options options, Bitmap bitmap) {
        options.inBitmap = bitmap;
    }

    private static boolean shouldUsePool(InputStream inputStream) {
        return true;
    }

    public int[] getDimensions(MarkEnforcingInputStream markEnforcingInputStream, RecyclableBufferedInputStream recyclableBufferedInputStream, BitmapFactory.Options options) {
        options.inJustDecodeBounds = true;
        decodeStream(markEnforcingInputStream, recyclableBufferedInputStream, options);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    public abstract int getSampleSize(int i10, int i11, int i12, int i13);

    @Override // com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapDecoder
    public Bitmap decode(InputStream inputStream, BitmapPool bitmapPool, int i10, int i11, DecodeFormat decodeFormat) {
        int i12;
        Bitmap bitmap;
        ByteArrayPool byteArrayPool = ByteArrayPool.get();
        byte[] bytes = byteArrayPool.getBytes();
        byte[] bytes2 = byteArrayPool.getBytes();
        BitmapFactory.Options defaultOptions = getDefaultOptions();
        RecyclableBufferedInputStream recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, bytes2);
        ExceptionCatchingInputStream obtain = ExceptionCatchingInputStream.obtain(recyclableBufferedInputStream);
        MarkEnforcingInputStream markEnforcingInputStream = new MarkEnforcingInputStream(obtain);
        try {
            obtain.mark(MARK_POSITION);
            try {
                try {
                    int orientation = new ImageHeaderParser(obtain).getOrientation();
                    try {
                        obtain.reset();
                    } catch (IOException e10) {
                        if (Log.isLoggable(TAG, 5)) {
                            Log.w(TAG, "Cannot reset the input stream", e10);
                        }
                    }
                    i12 = orientation;
                } catch (IOException e11) {
                    if (Log.isLoggable(TAG, 5)) {
                        Log.w(TAG, "Cannot determine the image orientation from header", e11);
                    }
                    try {
                        obtain.reset();
                    } catch (IOException e12) {
                        if (Log.isLoggable(TAG, 5)) {
                            Log.w(TAG, "Cannot reset the input stream", e12);
                        }
                    }
                    i12 = 0;
                }
                defaultOptions.inTempStorage = bytes;
                int[] dimensions = getDimensions(markEnforcingInputStream, recyclableBufferedInputStream, defaultOptions);
                int i13 = dimensions[0];
                int i14 = dimensions[1];
                Bitmap downsampleWithSize = downsampleWithSize(markEnforcingInputStream, recyclableBufferedInputStream, defaultOptions, bitmapPool, i13, i14, getRoundedSampleSize(TransformationUtils.getExifOrientationDegrees(i12), i13, i14, i10, i11), decodeFormat);
                IOException exception = obtain.getException();
                if (exception != null) {
                    throw new RuntimeException(exception);
                }
                if (downsampleWithSize != null) {
                    bitmap = TransformationUtils.rotateImageExif(downsampleWithSize, bitmapPool, i12);
                    if (!downsampleWithSize.equals(bitmap) && !bitmapPool.put(downsampleWithSize)) {
                        downsampleWithSize.recycle();
                    }
                } else {
                    bitmap = null;
                }
                return bitmap;
            } finally {
            }
        } finally {
            byteArrayPool.releaseBytes(bytes);
            byteArrayPool.releaseBytes(bytes2);
            obtain.release();
            releaseOptions(defaultOptions);
        }
    }
}
