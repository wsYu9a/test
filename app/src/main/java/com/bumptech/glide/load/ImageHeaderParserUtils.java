package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class ImageHeaderParserUtils {
    private static final int MARK_READ_LIMIT = 5242880;

    /* renamed from: com.bumptech.glide.load.ImageHeaderParserUtils$1 */
    class AnonymousClass1 implements TypeReader {
        final /* synthetic */ InputStream val$finalIs;

        AnonymousClass1(InputStream inputStream) {
            inputStream = inputStream;
        }

        @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
        public ImageHeaderParser.ImageType getType(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.getType(inputStream);
            } finally {
                inputStream.reset();
            }
        }
    }

    /* renamed from: com.bumptech.glide.load.ImageHeaderParserUtils$2 */
    class AnonymousClass2 implements TypeReader {
        final /* synthetic */ ByteBuffer val$buffer;

        AnonymousClass2(ByteBuffer byteBuffer) {
            byteBuffer = byteBuffer;
        }

        @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
        public ImageHeaderParser.ImageType getType(ImageHeaderParser imageHeaderParser) throws IOException {
            return imageHeaderParser.getType(byteBuffer);
        }
    }

    /* renamed from: com.bumptech.glide.load.ImageHeaderParserUtils$3 */
    class AnonymousClass3 implements TypeReader {
        final /* synthetic */ ArrayPool val$byteArrayPool;

        AnonymousClass3(ArrayPool arrayPool) {
            arrayPool = arrayPool;
        }

        @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
        public ImageHeaderParser.ImageType getType(ImageHeaderParser imageHeaderParser) throws IOException {
            RecyclableBufferedInputStream recyclableBufferedInputStream;
            RecyclableBufferedInputStream recyclableBufferedInputStream2 = null;
            try {
                recyclableBufferedInputStream = new RecyclableBufferedInputStream(new FileInputStream(ParcelFileDescriptorRewinder.this.rewindAndGet().getFileDescriptor()), arrayPool);
            } catch (Throwable th) {
                th = th;
            }
            try {
                ImageHeaderParser.ImageType type = imageHeaderParser.getType(recyclableBufferedInputStream);
                try {
                    recyclableBufferedInputStream.close();
                } catch (IOException unused) {
                }
                ParcelFileDescriptorRewinder.this.rewindAndGet();
                return type;
            } catch (Throwable th2) {
                th = th2;
                recyclableBufferedInputStream2 = recyclableBufferedInputStream;
                if (recyclableBufferedInputStream2 != null) {
                    try {
                        recyclableBufferedInputStream2.close();
                    } catch (IOException unused2) {
                    }
                }
                ParcelFileDescriptorRewinder.this.rewindAndGet();
                throw th;
            }
        }
    }

    /* renamed from: com.bumptech.glide.load.ImageHeaderParserUtils$4 */
    class AnonymousClass4 implements OrientationReader {
        final /* synthetic */ ArrayPool val$byteArrayPool;
        final /* synthetic */ InputStream val$finalIs;

        AnonymousClass4(InputStream inputStream, ArrayPool arrayPool) {
            inputStream = inputStream;
            arrayPool = arrayPool;
        }

        @Override // com.bumptech.glide.load.ImageHeaderParserUtils.OrientationReader
        public int getOrientation(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.getOrientation(inputStream, arrayPool);
            } finally {
                inputStream.reset();
            }
        }
    }

    /* renamed from: com.bumptech.glide.load.ImageHeaderParserUtils$5 */
    class AnonymousClass5 implements OrientationReader {
        final /* synthetic */ ArrayPool val$byteArrayPool;

        AnonymousClass5(ArrayPool arrayPool) {
            arrayPool = arrayPool;
        }

        @Override // com.bumptech.glide.load.ImageHeaderParserUtils.OrientationReader
        public int getOrientation(ImageHeaderParser imageHeaderParser) throws IOException {
            RecyclableBufferedInputStream recyclableBufferedInputStream;
            RecyclableBufferedInputStream recyclableBufferedInputStream2 = null;
            try {
                recyclableBufferedInputStream = new RecyclableBufferedInputStream(new FileInputStream(ParcelFileDescriptorRewinder.this.rewindAndGet().getFileDescriptor()), arrayPool);
            } catch (Throwable th) {
                th = th;
            }
            try {
                int orientation = imageHeaderParser.getOrientation(recyclableBufferedInputStream, arrayPool);
                try {
                    recyclableBufferedInputStream.close();
                } catch (IOException unused) {
                }
                ParcelFileDescriptorRewinder.this.rewindAndGet();
                return orientation;
            } catch (Throwable th2) {
                th = th2;
                recyclableBufferedInputStream2 = recyclableBufferedInputStream;
                if (recyclableBufferedInputStream2 != null) {
                    try {
                        recyclableBufferedInputStream2.close();
                    } catch (IOException unused2) {
                    }
                }
                ParcelFileDescriptorRewinder.this.rewindAndGet();
                throw th;
            }
        }
    }

    private interface OrientationReader {
        int getOrientation(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    private interface TypeReader {
        ImageHeaderParser.ImageType getType(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    private ImageHeaderParserUtils() {
    }

    public static int getOrientation(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull ArrayPool arrayPool) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(MARK_READ_LIMIT);
        return getOrientationInternal(list, new OrientationReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.4
            final /* synthetic */ ArrayPool val$byteArrayPool;
            final /* synthetic */ InputStream val$finalIs;

            AnonymousClass4(InputStream inputStream2, ArrayPool arrayPool2) {
                inputStream = inputStream2;
                arrayPool = arrayPool2;
            }

            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.OrientationReader
            public int getOrientation(ImageHeaderParser imageHeaderParser) throws IOException {
                try {
                    return imageHeaderParser.getOrientation(inputStream, arrayPool);
                } finally {
                    inputStream.reset();
                }
            }
        });
    }

    private static int getOrientationInternal(@NonNull List<ImageHeaderParser> list, OrientationReader orientationReader) throws IOException {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            int orientation = orientationReader.getOrientation(list.get(i2));
            if (orientation != -1) {
                return orientation;
            }
        }
        return -1;
    }

    @NonNull
    public static ImageHeaderParser.ImageType getType(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull ArrayPool arrayPool) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        }
        inputStream.mark(MARK_READ_LIMIT);
        return getTypeInternal(list, new TypeReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.1
            final /* synthetic */ InputStream val$finalIs;

            AnonymousClass1(InputStream inputStream2) {
                inputStream = inputStream2;
            }

            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
            public ImageHeaderParser.ImageType getType(ImageHeaderParser imageHeaderParser) throws IOException {
                try {
                    return imageHeaderParser.getType(inputStream);
                } finally {
                    inputStream.reset();
                }
            }
        });
    }

    @NonNull
    private static ImageHeaderParser.ImageType getTypeInternal(@NonNull List<ImageHeaderParser> list, TypeReader typeReader) throws IOException {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ImageHeaderParser.ImageType type = typeReader.getType(list.get(i2));
            if (type != ImageHeaderParser.ImageType.UNKNOWN) {
                return type;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @RequiresApi(21)
    public static int getOrientation(@NonNull List<ImageHeaderParser> list, @NonNull ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, @NonNull ArrayPool arrayPool) throws IOException {
        return getOrientationInternal(list, new OrientationReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.5
            final /* synthetic */ ArrayPool val$byteArrayPool;

            AnonymousClass5(ArrayPool arrayPool2) {
                arrayPool = arrayPool2;
            }

            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.OrientationReader
            public int getOrientation(ImageHeaderParser imageHeaderParser) throws IOException {
                RecyclableBufferedInputStream recyclableBufferedInputStream;
                RecyclableBufferedInputStream recyclableBufferedInputStream2 = null;
                try {
                    recyclableBufferedInputStream = new RecyclableBufferedInputStream(new FileInputStream(ParcelFileDescriptorRewinder.this.rewindAndGet().getFileDescriptor()), arrayPool);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    int orientation = imageHeaderParser.getOrientation(recyclableBufferedInputStream, arrayPool);
                    try {
                        recyclableBufferedInputStream.close();
                    } catch (IOException unused) {
                    }
                    ParcelFileDescriptorRewinder.this.rewindAndGet();
                    return orientation;
                } catch (Throwable th2) {
                    th = th2;
                    recyclableBufferedInputStream2 = recyclableBufferedInputStream;
                    if (recyclableBufferedInputStream2 != null) {
                        try {
                            recyclableBufferedInputStream2.close();
                        } catch (IOException unused2) {
                        }
                    }
                    ParcelFileDescriptorRewinder.this.rewindAndGet();
                    throw th;
                }
            }
        });
    }

    @NonNull
    public static ImageHeaderParser.ImageType getType(@NonNull List<ImageHeaderParser> list, @Nullable ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        return getTypeInternal(list, new TypeReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.2
            final /* synthetic */ ByteBuffer val$buffer;

            AnonymousClass2(ByteBuffer byteBuffer2) {
                byteBuffer = byteBuffer2;
            }

            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
            public ImageHeaderParser.ImageType getType(ImageHeaderParser imageHeaderParser) throws IOException {
                return imageHeaderParser.getType(byteBuffer);
            }
        });
    }

    @NonNull
    @RequiresApi(21)
    public static ImageHeaderParser.ImageType getType(@NonNull List<ImageHeaderParser> list, @NonNull ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, @NonNull ArrayPool arrayPool) throws IOException {
        return getTypeInternal(list, new TypeReader() { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.3
            final /* synthetic */ ArrayPool val$byteArrayPool;

            AnonymousClass3(ArrayPool arrayPool2) {
                arrayPool = arrayPool2;
            }

            @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
            public ImageHeaderParser.ImageType getType(ImageHeaderParser imageHeaderParser) throws IOException {
                RecyclableBufferedInputStream recyclableBufferedInputStream;
                RecyclableBufferedInputStream recyclableBufferedInputStream2 = null;
                try {
                    recyclableBufferedInputStream = new RecyclableBufferedInputStream(new FileInputStream(ParcelFileDescriptorRewinder.this.rewindAndGet().getFileDescriptor()), arrayPool);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    ImageHeaderParser.ImageType type = imageHeaderParser.getType(recyclableBufferedInputStream);
                    try {
                        recyclableBufferedInputStream.close();
                    } catch (IOException unused) {
                    }
                    ParcelFileDescriptorRewinder.this.rewindAndGet();
                    return type;
                } catch (Throwable th2) {
                    th = th2;
                    recyclableBufferedInputStream2 = recyclableBufferedInputStream;
                    if (recyclableBufferedInputStream2 != null) {
                        try {
                            recyclableBufferedInputStream2.close();
                        } catch (IOException unused2) {
                        }
                    }
                    ParcelFileDescriptorRewinder.this.rewindAndGet();
                    throw th;
                }
            }
        });
    }
}
