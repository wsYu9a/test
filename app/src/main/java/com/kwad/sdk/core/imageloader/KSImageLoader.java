package com.kwad.sdk.core.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.ad;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class KSImageLoader {
    public static DisplayImageOptionsCompat IMGOPTION_NORMAL = new DisplayImageOptionsCompat.Builder().bitmapConfig(Bitmap.Config.ARGB_8888).cacheOnDisk(true).cacheInMemory(true).build();
    private static OnRenderResultListener<AdTemplate> mDefaultListener;

    /* renamed from: com.kwad.sdk.core.imageloader.KSImageLoader$1 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType;

        static {
            int[] iArr = new int[FailReason.FailType.values().length];
            $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType = iArr;
            try {
                iArr[FailReason.FailType.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.IO_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.OUT_OF_MEMORY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.NETWORK_DENIED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.DECODING_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static class InnerImageLoadingListener implements ImageLoadingListener {
        public static final int MAX_DURATION = 30000;

        @Nullable
        AdTemplate adTemplate;

        @Nullable
        ImageLoadingListener loadingListener;
        private long startTime;

        public InnerImageLoadingListener(@Nullable AdTemplate adTemplate, @Nullable ImageLoadingListener imageLoadingListener) {
            this.adTemplate = adTemplate;
            this.loadingListener = imageLoadingListener;
        }

        private long getDuration(long j10) {
            if (j10 == 0) {
                return -1L;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - j10;
            if (elapsedRealtime >= 30000) {
                return -1L;
            }
            return elapsedRealtime;
        }

        private void recordDuration(long j10) {
            try {
                long duration = getDuration(j10);
                if (duration >= 0) {
                    ad.aP(duration);
                }
            } catch (Exception unused) {
            }
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            ImageLoadingListener imageLoadingListener = this.loadingListener;
            if (imageLoadingListener != null) {
                return imageLoadingListener.onDecode(str, inputStream, decodedResult);
            }
            return false;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public void onLoadingCancelled(String str, View view) {
            ImageLoadingListener imageLoadingListener = this.loadingListener;
            if (imageLoadingListener != null) {
                imageLoadingListener.onLoadingCancelled(str, view);
            }
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
            ImageLoadingListener imageLoadingListener = this.loadingListener;
            if (imageLoadingListener != null) {
                imageLoadingListener.onLoadingComplete(str, view, decodedResult);
            }
            recordDuration(this.startTime);
            ad.NE();
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            String str2;
            ImageLoadingListener imageLoadingListener = this.loadingListener;
            if (imageLoadingListener != null) {
                imageLoadingListener.onLoadingFailed(str, view, failReason);
            }
            if (this.adTemplate != null) {
                StringBuilder sb2 = new StringBuilder("ImageLoader:");
                if (failReason != null) {
                    Throwable cause = failReason.getCause();
                    if (cause == null || cause.getStackTrace().length <= 0) {
                        str2 = "";
                    } else {
                        str2 = cause.getMessage() + " @ " + cause.getStackTrace()[0].getFileName() + cause.getStackTrace()[0].getClassName() + cause.getStackTrace()[0].getLineNumber();
                    }
                    int i10 = AnonymousClass1.$SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[failReason.getType().ordinal()];
                    if (i10 == 1) {
                        sb2.append("UNKNOWN");
                    } else if (i10 == 2) {
                        sb2.append("IO_ERROR");
                        sb2.append(str2);
                    } else if (i10 == 3) {
                        sb2.append("OUT_OF_MEMORY");
                    } else if (i10 == 4) {
                        sb2.append("NETWORK_DENIED");
                    } else if (i10 == 5) {
                        sb2.append("DECODING_ERROR");
                    }
                }
                if (KSImageLoader.getGlobalImageListener() != null) {
                    KSImageLoader.getGlobalImageListener().onRenderResult(false, this.adTemplate, str, sb2.toString());
                }
            }
            ad.NF();
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
            ImageLoadingListener imageLoadingListener = this.loadingListener;
            if (imageLoadingListener != null) {
                imageLoadingListener.onLoadingStarted(str, view);
            }
            this.startTime = SystemClock.elapsedRealtime();
            ad.ND();
        }
    }

    @RequiresApi(api = 17)
    public static Bitmap blur(Context context, Bitmap bitmap, @IntRange(from = 1, to = 25) int i10) {
        try {
            Bitmap.Config config = bitmap.getConfig();
            Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
            Bitmap copy = config == config2 ? bitmap : bitmap.copy(config2, true);
            if (copy == null) {
                copy = bitmap.copy(bitmap.getConfig(), true);
            }
            Bitmap createBitmap = Bitmap.createBitmap(copy.getWidth(), copy.getHeight(), copy.getConfig());
            RenderScript create = RenderScript.create(context);
            Allocation createFromBitmap = Allocation.createFromBitmap(create, createBitmap);
            ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, createFromBitmap.getElement());
            create2.setInput(createFromBitmap);
            create2.setRadius(i10);
            create2.forEach(createFromBitmap);
            createFromBitmap.copyTo(createBitmap);
            create.destroy();
            return createBitmap;
        } catch (Exception unused) {
            return bitmap;
        }
    }

    public static void clearMemory() {
        ImageLoaderProxy.INSTANCE.clearMemory(((f) ServiceProvider.get(f.class)).getContext());
    }

    public static OnRenderResultListener<AdTemplate> getGlobalImageListener() {
        if (mDefaultListener == null) {
            mDefaultListener = new GlobalImageListener();
        }
        return mDefaultListener;
    }

    private static Context getSDKContext() {
        f fVar = (f) ServiceProvider.get(f.class);
        if (fVar != null) {
            return fVar.getContext();
        }
        return null;
    }

    public static boolean isImageExist(String str) {
        File isImageExistOnDisk;
        return !TextUtils.isEmpty(str) && (isImageExistOnDisk = ImageLoaderProxy.INSTANCE.isImageExistOnDisk(str)) != null && isImageExistOnDisk.exists() && isImageExistOnDisk.length() > 0;
    }

    public static void loadAppIcon(ImageView imageView, @Nullable String str, AdTemplate adTemplate, int i10) {
        if (imageView == null || TextUtils.isEmpty(str) || getSDKContext() == null) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, new DisplayImageOptionsCompat.Builder().showImageOnLoading(imageView.getContext().getResources().getDrawable(R.drawable.ksad_default_app_icon)).showImageForEmptyUri(imageView.getContext().getResources().getDrawable(R.drawable.ksad_default_app_icon)).showImageOnFail(imageView.getContext().getResources().getDrawable(R.drawable.ksad_default_app_icon)).considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565).setCornerRound(i10).build(), new InnerImageLoadingListener(adTemplate, null));
    }

    public static void loadCircleIcon(ImageView imageView, String str, Drawable drawable, @ColorInt int i10) {
        if (imageView == null || getSDKContext() == null) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, new DisplayImageOptionsCompat.Builder().showImageOnLoading(drawable).showImageForEmptyUri(drawable).showImageOnFail(drawable).cacheInMemory(true).cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565).setStrokeColor(i10).setStrokeWidth(1.0f).build(), (ImageLoadingListener) null);
    }

    public static void loadCircleIconWithBorder(ImageView imageView, String str, Drawable drawable, Integer num, float f10) {
        if (imageView == null || getSDKContext() == null) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, new DisplayImageOptionsCompat.Builder().showImageOnLoading(drawable).showImageForEmptyUri(drawable).showImageOnFail(drawable).cacheInMemory(true).cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565).setStrokeColor(num.intValue()).setStrokeWidth(f10).build(), (ImageLoadingListener) null);
    }

    public static void loadCircleIconWithoutStroke(ImageView imageView, String str, Drawable drawable) {
        if (imageView == null || getSDKContext() == null) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, new DisplayImageOptionsCompat.Builder().showImageOnLoading(drawable).showImageForEmptyUri(drawable).showImageOnFail(drawable).cacheInMemory(true).cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565).setCircle(true).build(), (ImageLoadingListener) null);
    }

    public static void loadFeeImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate) {
        loadFeeImage(imageView, str, adTemplate, null);
    }

    public static void loadImage(String str, AdTemplate adTemplate, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener) {
        if (TextUtils.isEmpty(str) || getSDKContext() == null) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, displayImageOptionsCompat, new InnerImageLoadingListener(adTemplate, imageLoadingListener));
    }

    public static Bitmap loadImageSync(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return ImageLoaderProxy.INSTANCE.loadImageSync(str);
    }

    public static void loadWithRadius(ImageView imageView, @Nullable String str, AdTemplate adTemplate, int i10) {
        if (imageView == null || TextUtils.isEmpty(str) || getSDKContext() == null) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, new DisplayImageOptionsCompat.Builder().showImageOnLoading(imageView.getContext().getResources().getDrawable(R.drawable.ksad_default_app_icon)).showImageForEmptyUri(imageView.getContext().getResources().getDrawable(R.drawable.ksad_default_app_icon)).showImageOnFail(imageView.getContext().getResources().getDrawable(R.drawable.ksad_default_app_icon)).considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565).setCornerRound(i10).build(), new InnerImageLoadingListener(adTemplate, null));
    }

    public static void pause() {
        ImageLoaderProxy.INSTANCE.pause();
    }

    public static void preloadImage(String str, AdTemplate adTemplate) {
        loadImage(str, adTemplate, IMGOPTION_NORMAL, (ImageLoadingListener) null);
    }

    public static void resume() {
        ImageLoaderProxy.INSTANCE.resume();
    }

    public static void loadFeeImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate, ImageLoadingListener imageLoadingListener) {
        if (imageView == null || TextUtils.isEmpty(str) || getSDKContext() == null) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, new DisplayImageOptionsCompat.Builder().bitmapConfig(Bitmap.Config.RGB_565).cacheInMemory(true).cacheOnDisk(true).setCornerRound(1).build(), new InnerImageLoadingListener(adTemplate, imageLoadingListener));
    }

    public static void loadImage(ImageView imageView, @Nullable String str, ImageLoadingListener imageLoadingListener) {
        if (imageView == null) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(((f) ServiceProvider.get(f.class)).getContext(), str, imageView, IMGOPTION_NORMAL, imageLoadingListener);
    }

    public static void loadImage(ImageView imageView, @Nullable String str, DisplayImageOptionsCompat displayImageOptionsCompat) {
        if (imageView == null) {
            return;
        }
        if (displayImageOptionsCompat == null) {
            displayImageOptionsCompat = IMGOPTION_NORMAL;
        }
        ImageLoaderProxy.INSTANCE.load(((f) ServiceProvider.get(f.class)).getContext(), str, imageView, displayImageOptionsCompat, (ImageLoadingListener) null);
    }

    public static void loadImage(ImageView imageView, @Nullable String str) {
        loadImage(imageView, str, (AdTemplate) null, IMGOPTION_NORMAL);
    }

    public static void loadImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate) {
        loadImage(imageView, str, adTemplate, IMGOPTION_NORMAL);
    }

    public static void loadImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate, DisplayImageOptionsCompat displayImageOptionsCompat) {
        if (imageView == null || getSDKContext() == null) {
            return;
        }
        if (displayImageOptionsCompat == null) {
            displayImageOptionsCompat = IMGOPTION_NORMAL;
        }
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, displayImageOptionsCompat, new InnerImageLoadingListener(adTemplate, null));
    }

    public static void loadImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener) {
        if (imageView == null || TextUtils.isEmpty(str) || getSDKContext() == null) {
            return;
        }
        if (displayImageOptionsCompat == null) {
            displayImageOptionsCompat = IMGOPTION_NORMAL;
        }
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, displayImageOptionsCompat, new InnerImageLoadingListener(adTemplate, imageLoadingListener));
    }

    public static void loadCircleIcon(ImageView imageView, String str, Drawable drawable) {
        if (imageView == null || getSDKContext() == null) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, new DisplayImageOptionsCompat.Builder().showImageOnLoading(drawable).showImageForEmptyUri(drawable).showImageOnFail(drawable).cacheInMemory(true).cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565).setStrokeColor(Color.argb(255, 255, 255, 255)).setStrokeWidth(1.0f).build(), (ImageLoadingListener) null);
    }

    public static void loadImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate, ImageLoadingListener imageLoadingListener) {
        if (imageView == null || TextUtils.isEmpty(str) || getSDKContext() == null) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, IMGOPTION_NORMAL, new InnerImageLoadingListener(adTemplate, imageLoadingListener));
    }
}
