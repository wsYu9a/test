package com.bumptech.glide.load.resource;

import android.annotation.SuppressLint;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import java.io.IOException;
import z3.a;

@RequiresApi(api = 28)
/* loaded from: classes2.dex */
public abstract class ImageDecoderResourceDecoder<T> implements ResourceDecoder<ImageDecoder.Source, T> {
    private static final String TAG = "ImageDecoder";
    final HardwareConfigState hardwareConfigState = HardwareConfigState.getInstance();

    /* renamed from: com.bumptech.glide.load.resource.ImageDecoderResourceDecoder$1 */
    public class AnonymousClass1 implements ImageDecoder.OnHeaderDecodedListener {
        final /* synthetic */ DecodeFormat val$decodeFormat;
        final /* synthetic */ boolean val$isHardwareConfigAllowed;
        final /* synthetic */ PreferredColorSpace val$preferredColorSpace;
        final /* synthetic */ int val$requestedHeight;
        final /* synthetic */ int val$requestedWidth;
        final /* synthetic */ DownsampleStrategy val$strategy;

        /* renamed from: com.bumptech.glide.load.resource.ImageDecoderResourceDecoder$1$1 */
        public class C02221 implements ImageDecoder.OnPartialImageListener {
            public C02221() {
            }

            @Override // android.graphics.ImageDecoder.OnPartialImageListener
            public boolean onPartialImage(@NonNull ImageDecoder.DecodeException decodeException) {
                return false;
            }
        }

        public AnonymousClass1(int i10, int i11, boolean z10, DecodeFormat decodeFormat, DownsampleStrategy downsampleStrategy, PreferredColorSpace preferredColorSpace) {
            i10 = i10;
            i11 = i11;
            z10 = z10;
            decodeFormat = decodeFormat;
            downsampleStrategy = downsampleStrategy;
            preferredColorSpace = preferredColorSpace;
        }

        @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
        @SuppressLint({"Override"})
        public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
            Size size;
            ColorSpace.Named named;
            ColorSpace colorSpace;
            ColorSpace.Named named2;
            ColorSpace colorSpace2;
            ColorSpace colorSpace3;
            ColorSpace colorSpace4;
            boolean isWideGamut;
            if (ImageDecoderResourceDecoder.this.hardwareConfigState.isHardwareConfigAllowed(i10, i11, z10, false)) {
                imageDecoder.setAllocator(3);
            } else {
                imageDecoder.setAllocator(1);
            }
            if (decodeFormat == DecodeFormat.PREFER_RGB_565) {
                imageDecoder.setMemorySizePolicy(0);
            }
            imageDecoder.setOnPartialImageListener(new ImageDecoder.OnPartialImageListener() { // from class: com.bumptech.glide.load.resource.ImageDecoderResourceDecoder.1.1
                public C02221() {
                }

                @Override // android.graphics.ImageDecoder.OnPartialImageListener
                public boolean onPartialImage(@NonNull ImageDecoder.DecodeException decodeException) {
                    return false;
                }
            });
            size = imageInfo.getSize();
            int i10 = i10;
            if (i10 == Integer.MIN_VALUE) {
                i10 = size.getWidth();
            }
            int i11 = i11;
            if (i11 == Integer.MIN_VALUE) {
                i11 = size.getHeight();
            }
            float scaleFactor = downsampleStrategy.getScaleFactor(size.getWidth(), size.getHeight(), i10, i11);
            int round = Math.round(size.getWidth() * scaleFactor);
            int round2 = Math.round(size.getHeight() * scaleFactor);
            if (Log.isLoggable(ImageDecoderResourceDecoder.TAG, 2)) {
                Log.v(ImageDecoderResourceDecoder.TAG, "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + round + "x" + round2 + "] scaleFactor: " + scaleFactor);
            }
            imageDecoder.setTargetSize(round, round2);
            int i12 = Build.VERSION.SDK_INT;
            if (i12 < 28) {
                if (i12 >= 26) {
                    named = ColorSpace.Named.SRGB;
                    colorSpace = ColorSpace.get(named);
                    imageDecoder.setTargetColorSpace(colorSpace);
                    return;
                }
                return;
            }
            if (preferredColorSpace == PreferredColorSpace.DISPLAY_P3) {
                colorSpace3 = imageInfo.getColorSpace();
                if (colorSpace3 != null) {
                    colorSpace4 = imageInfo.getColorSpace();
                    isWideGamut = colorSpace4.isWideGamut();
                    if (isWideGamut) {
                        named2 = ColorSpace.Named.DISPLAY_P3;
                        colorSpace2 = ColorSpace.get(named2);
                        imageDecoder.setTargetColorSpace(colorSpace2);
                    }
                }
            }
            named2 = ColorSpace.Named.SRGB;
            colorSpace2 = ColorSpace.get(named2);
            imageDecoder.setTargetColorSpace(colorSpace2);
        }
    }

    public abstract Resource<T> decode(ImageDecoder.Source source, int i10, int i11, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException;

    @Override // com.bumptech.glide.load.ResourceDecoder
    @Nullable
    public /* bridge */ /* synthetic */ Resource decode(@NonNull ImageDecoder.Source source, int i10, int i11, @NonNull Options options) throws IOException {
        return decode2(a.a(source), i10, i11, options);
    }

    /* renamed from: handles */
    public final boolean handles2(@NonNull ImageDecoder.Source source, @NonNull Options options) {
        return true;
    }

    @Nullable
    /* renamed from: decode */
    public final Resource<T> decode2(@NonNull ImageDecoder.Source source, int i10, int i11, @NonNull Options options) throws IOException {
        DecodeFormat decodeFormat = (DecodeFormat) options.get(Downsampler.DECODE_FORMAT);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.get(DownsampleStrategy.OPTION);
        Option<Boolean> option = Downsampler.ALLOW_HARDWARE_CONFIG;
        return decode(source, i10, i11, new ImageDecoder.OnHeaderDecodedListener() { // from class: com.bumptech.glide.load.resource.ImageDecoderResourceDecoder.1
            final /* synthetic */ DecodeFormat val$decodeFormat;
            final /* synthetic */ boolean val$isHardwareConfigAllowed;
            final /* synthetic */ PreferredColorSpace val$preferredColorSpace;
            final /* synthetic */ int val$requestedHeight;
            final /* synthetic */ int val$requestedWidth;
            final /* synthetic */ DownsampleStrategy val$strategy;

            /* renamed from: com.bumptech.glide.load.resource.ImageDecoderResourceDecoder$1$1 */
            public class C02221 implements ImageDecoder.OnPartialImageListener {
                public C02221() {
                }

                @Override // android.graphics.ImageDecoder.OnPartialImageListener
                public boolean onPartialImage(@NonNull ImageDecoder.DecodeException decodeException) {
                    return false;
                }
            }

            public AnonymousClass1(int i102, int i112, boolean z10, DecodeFormat decodeFormat2, DownsampleStrategy downsampleStrategy2, PreferredColorSpace preferredColorSpace) {
                i10 = i102;
                i11 = i112;
                z10 = z10;
                decodeFormat = decodeFormat2;
                downsampleStrategy = downsampleStrategy2;
                preferredColorSpace = preferredColorSpace;
            }

            @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
            @SuppressLint({"Override"})
            public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source2) {
                Size size;
                ColorSpace.Named named;
                ColorSpace colorSpace;
                ColorSpace.Named named2;
                ColorSpace colorSpace2;
                ColorSpace colorSpace3;
                ColorSpace colorSpace4;
                boolean isWideGamut;
                if (ImageDecoderResourceDecoder.this.hardwareConfigState.isHardwareConfigAllowed(i10, i11, z10, false)) {
                    imageDecoder.setAllocator(3);
                } else {
                    imageDecoder.setAllocator(1);
                }
                if (decodeFormat == DecodeFormat.PREFER_RGB_565) {
                    imageDecoder.setMemorySizePolicy(0);
                }
                imageDecoder.setOnPartialImageListener(new ImageDecoder.OnPartialImageListener() { // from class: com.bumptech.glide.load.resource.ImageDecoderResourceDecoder.1.1
                    public C02221() {
                    }

                    @Override // android.graphics.ImageDecoder.OnPartialImageListener
                    public boolean onPartialImage(@NonNull ImageDecoder.DecodeException decodeException) {
                        return false;
                    }
                });
                size = imageInfo.getSize();
                int i102 = i10;
                if (i102 == Integer.MIN_VALUE) {
                    i102 = size.getWidth();
                }
                int i112 = i11;
                if (i112 == Integer.MIN_VALUE) {
                    i112 = size.getHeight();
                }
                float scaleFactor = downsampleStrategy.getScaleFactor(size.getWidth(), size.getHeight(), i102, i112);
                int round = Math.round(size.getWidth() * scaleFactor);
                int round2 = Math.round(size.getHeight() * scaleFactor);
                if (Log.isLoggable(ImageDecoderResourceDecoder.TAG, 2)) {
                    Log.v(ImageDecoderResourceDecoder.TAG, "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + round + "x" + round2 + "] scaleFactor: " + scaleFactor);
                }
                imageDecoder.setTargetSize(round, round2);
                int i12 = Build.VERSION.SDK_INT;
                if (i12 < 28) {
                    if (i12 >= 26) {
                        named = ColorSpace.Named.SRGB;
                        colorSpace = ColorSpace.get(named);
                        imageDecoder.setTargetColorSpace(colorSpace);
                        return;
                    }
                    return;
                }
                if (preferredColorSpace == PreferredColorSpace.DISPLAY_P3) {
                    colorSpace3 = imageInfo.getColorSpace();
                    if (colorSpace3 != null) {
                        colorSpace4 = imageInfo.getColorSpace();
                        isWideGamut = colorSpace4.isWideGamut();
                        if (isWideGamut) {
                            named2 = ColorSpace.Named.DISPLAY_P3;
                            colorSpace2 = ColorSpace.get(named2);
                            imageDecoder.setTargetColorSpace(colorSpace2);
                        }
                    }
                }
                named2 = ColorSpace.Named.SRGB;
                colorSpace2 = ColorSpace.get(named2);
                imageDecoder.setTargetColorSpace(colorSpace2);
            }
        });
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ boolean handles(@NonNull ImageDecoder.Source source, @NonNull Options options) throws IOException {
        return handles2(a.a(source), options);
    }
}
