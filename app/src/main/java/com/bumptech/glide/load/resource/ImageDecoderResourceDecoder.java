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

@RequiresApi(api = 28)
/* loaded from: classes.dex */
public abstract class ImageDecoderResourceDecoder<T> implements ResourceDecoder<ImageDecoder.Source, T> {
    private static final String TAG = "ImageDecoder";
    final HardwareConfigState hardwareConfigState = HardwareConfigState.getInstance();

    /* renamed from: com.bumptech.glide.load.resource.ImageDecoderResourceDecoder$1 */
    class AnonymousClass1 implements ImageDecoder.OnHeaderDecodedListener {
        final /* synthetic */ DecodeFormat val$decodeFormat;
        final /* synthetic */ boolean val$isHardwareConfigAllowed;
        final /* synthetic */ PreferredColorSpace val$preferredColorSpace;
        final /* synthetic */ int val$requestedHeight;
        final /* synthetic */ int val$requestedWidth;
        final /* synthetic */ DownsampleStrategy val$strategy;

        /* renamed from: com.bumptech.glide.load.resource.ImageDecoderResourceDecoder$1$1 */
        class C00661 implements ImageDecoder.OnPartialImageListener {
            C00661() {
            }

            @Override // android.graphics.ImageDecoder.OnPartialImageListener
            public boolean onPartialImage(@NonNull ImageDecoder.DecodeException decodeException) {
                return false;
            }
        }

        AnonymousClass1(int i2, int i3, boolean z, DecodeFormat decodeFormat, DownsampleStrategy downsampleStrategy, PreferredColorSpace preferredColorSpace) {
            i2 = i2;
            i3 = i3;
            z = z;
            decodeFormat = decodeFormat;
            downsampleStrategy = downsampleStrategy;
            preferredColorSpace = preferredColorSpace;
        }

        @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
        @SuppressLint({"Override"})
        public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
            boolean z = false;
            if (ImageDecoderResourceDecoder.this.hardwareConfigState.isHardwareConfigAllowed(i2, i3, z, false)) {
                imageDecoder.setAllocator(3);
            } else {
                imageDecoder.setAllocator(1);
            }
            if (decodeFormat == DecodeFormat.PREFER_RGB_565) {
                imageDecoder.setMemorySizePolicy(0);
            }
            imageDecoder.setOnPartialImageListener(new ImageDecoder.OnPartialImageListener() { // from class: com.bumptech.glide.load.resource.ImageDecoderResourceDecoder.1.1
                C00661() {
                }

                @Override // android.graphics.ImageDecoder.OnPartialImageListener
                public boolean onPartialImage(@NonNull ImageDecoder.DecodeException decodeException) {
                    return false;
                }
            });
            Size size = imageInfo.getSize();
            int i2 = i2;
            if (i2 == Integer.MIN_VALUE) {
                i2 = size.getWidth();
            }
            int i3 = i3;
            if (i3 == Integer.MIN_VALUE) {
                i3 = size.getHeight();
            }
            float scaleFactor = downsampleStrategy.getScaleFactor(size.getWidth(), size.getHeight(), i2, i3);
            int round = Math.round(size.getWidth() * scaleFactor);
            int round2 = Math.round(size.getHeight() * scaleFactor);
            if (Log.isLoggable(ImageDecoderResourceDecoder.TAG, 2)) {
                Log.v(ImageDecoderResourceDecoder.TAG, "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + round + "x" + round2 + "] scaleFactor: " + scaleFactor);
            }
            imageDecoder.setTargetSize(round, round2);
            int i4 = Build.VERSION.SDK_INT;
            if (i4 < 28) {
                if (i4 >= 26) {
                    imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
                }
            } else {
                if (preferredColorSpace == PreferredColorSpace.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) {
                    z = true;
                }
                imageDecoder.setTargetColorSpace(ColorSpace.get(z ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
            }
        }
    }

    protected abstract Resource<T> decode(ImageDecoder.Source source, int i2, int i3, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException;

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final boolean handles(@NonNull ImageDecoder.Source source, @NonNull Options options) {
        return true;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    @Nullable
    public final Resource<T> decode(@NonNull ImageDecoder.Source source, int i2, int i3, @NonNull Options options) throws IOException {
        DecodeFormat decodeFormat = (DecodeFormat) options.get(Downsampler.DECODE_FORMAT);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.get(DownsampleStrategy.OPTION);
        Option<Boolean> option = Downsampler.ALLOW_HARDWARE_CONFIG;
        return decode(source, i2, i3, new ImageDecoder.OnHeaderDecodedListener() { // from class: com.bumptech.glide.load.resource.ImageDecoderResourceDecoder.1
            final /* synthetic */ DecodeFormat val$decodeFormat;
            final /* synthetic */ boolean val$isHardwareConfigAllowed;
            final /* synthetic */ PreferredColorSpace val$preferredColorSpace;
            final /* synthetic */ int val$requestedHeight;
            final /* synthetic */ int val$requestedWidth;
            final /* synthetic */ DownsampleStrategy val$strategy;

            /* renamed from: com.bumptech.glide.load.resource.ImageDecoderResourceDecoder$1$1 */
            class C00661 implements ImageDecoder.OnPartialImageListener {
                C00661() {
                }

                @Override // android.graphics.ImageDecoder.OnPartialImageListener
                public boolean onPartialImage(@NonNull ImageDecoder.DecodeException decodeException) {
                    return false;
                }
            }

            AnonymousClass1(int i22, int i32, boolean z, DecodeFormat decodeFormat2, DownsampleStrategy downsampleStrategy2, PreferredColorSpace preferredColorSpace) {
                i2 = i22;
                i3 = i32;
                z = z;
                decodeFormat = decodeFormat2;
                downsampleStrategy = downsampleStrategy2;
                preferredColorSpace = preferredColorSpace;
            }

            @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
            @SuppressLint({"Override"})
            public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source2) {
                boolean z = false;
                if (ImageDecoderResourceDecoder.this.hardwareConfigState.isHardwareConfigAllowed(i2, i3, z, false)) {
                    imageDecoder.setAllocator(3);
                } else {
                    imageDecoder.setAllocator(1);
                }
                if (decodeFormat == DecodeFormat.PREFER_RGB_565) {
                    imageDecoder.setMemorySizePolicy(0);
                }
                imageDecoder.setOnPartialImageListener(new ImageDecoder.OnPartialImageListener() { // from class: com.bumptech.glide.load.resource.ImageDecoderResourceDecoder.1.1
                    C00661() {
                    }

                    @Override // android.graphics.ImageDecoder.OnPartialImageListener
                    public boolean onPartialImage(@NonNull ImageDecoder.DecodeException decodeException) {
                        return false;
                    }
                });
                Size size = imageInfo.getSize();
                int i22 = i2;
                if (i22 == Integer.MIN_VALUE) {
                    i22 = size.getWidth();
                }
                int i32 = i3;
                if (i32 == Integer.MIN_VALUE) {
                    i32 = size.getHeight();
                }
                float scaleFactor = downsampleStrategy.getScaleFactor(size.getWidth(), size.getHeight(), i22, i32);
                int round = Math.round(size.getWidth() * scaleFactor);
                int round2 = Math.round(size.getHeight() * scaleFactor);
                if (Log.isLoggable(ImageDecoderResourceDecoder.TAG, 2)) {
                    Log.v(ImageDecoderResourceDecoder.TAG, "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + round + "x" + round2 + "] scaleFactor: " + scaleFactor);
                }
                imageDecoder.setTargetSize(round, round2);
                int i4 = Build.VERSION.SDK_INT;
                if (i4 < 28) {
                    if (i4 >= 26) {
                        imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
                    }
                } else {
                    if (preferredColorSpace == PreferredColorSpace.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) {
                        z = true;
                    }
                    imageDecoder.setTargetColorSpace(ColorSpace.get(z ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
                }
            }
        });
    }
}
