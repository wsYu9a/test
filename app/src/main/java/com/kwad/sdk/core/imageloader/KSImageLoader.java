package com.kwad.sdk.core.imageloader;

import android.content.Context;
import android.content.res.Resources;
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
import com.kwad.sdk.service.kwai.e;
import com.kwad.sdk.utils.y;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class KSImageLoader {
    public static DisplayImageOptionsCompat IMGOPTION_NORMAL = new DisplayImageOptionsCompat.Builder().bitmapConfig(Bitmap.Config.ARGB_8888).cacheOnDisk(true).cacheInMemory(true).build();
    private static OnRenderResultListener<AdTemplate> mDefaultListener;

    /* renamed from: com.kwad.sdk.core.imageloader.KSImageLoader$1 */
    static /* synthetic */ class AnonymousClass1 {
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

        private long getDuration(long j2) {
            if (j2 == 0) {
                return -1L;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - j2;
            if (elapsedRealtime >= 30000) {
                return -1L;
            }
            return elapsedRealtime;
        }

        private void recordDuration(long j2) {
            try {
                long duration = getDuration(j2);
                if (duration >= 0) {
                    y.ah(duration);
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
            y.DB();
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            String str2;
            String str3;
            ImageLoadingListener imageLoadingListener = this.loadingListener;
            if (imageLoadingListener != null) {
                imageLoadingListener.onLoadingFailed(str, view, failReason);
            }
            if (this.adTemplate != null) {
                StringBuilder sb = new StringBuilder("ImageLoader:");
                if (failReason != null) {
                    Throwable cause = failReason.getCause();
                    if (cause == null || cause.getStackTrace().length <= 0) {
                        str2 = "";
                    } else {
                        str2 = cause.getMessage() + " @ " + cause.getStackTrace()[0].getFileName() + cause.getStackTrace()[0].getClassName() + cause.getStackTrace()[0].getLineNumber();
                    }
                    int i2 = AnonymousClass1.$SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[failReason.getType().ordinal()];
                    if (i2 == 1) {
                        str3 = "UNKNOWN";
                    } else if (i2 == 2) {
                        sb.append("IO_ERROR");
                        sb.append(str2);
                    } else if (i2 == 3) {
                        str3 = "OUT_OF_MEMORY";
                    } else if (i2 == 4) {
                        str3 = "NETWORK_DENIED";
                    } else if (i2 == 5) {
                        str3 = "DECODING_ERROR";
                    }
                    sb.append(str3);
                }
                if (KSImageLoader.getGlobalImageListener() != null) {
                    KSImageLoader.getGlobalImageListener().onRenderResult(false, this.adTemplate, str, sb.toString());
                }
            }
            y.DC();
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
            ImageLoadingListener imageLoadingListener = this.loadingListener;
            if (imageLoadingListener != null) {
                imageLoadingListener.onLoadingStarted(str, view);
            }
            this.startTime = SystemClock.elapsedRealtime();
            y.DA();
        }
    }

    @RequiresApi(api = 17)
    public static Bitmap blur(Context context, Bitmap bitmap, @IntRange(from = 1, to = 25) int i2) {
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
            create2.setRadius(i2);
            create2.forEach(createFromBitmap);
            createFromBitmap.copyTo(createBitmap);
            create.destroy();
            return createBitmap;
        } catch (Exception unused) {
            return bitmap;
        }
    }

    public static void clearMemory() {
        ImageLoaderProxy.INSTANCE.clearMemory(((e) ServiceProvider.get(e.class)).getContext());
    }

    public static OnRenderResultListener<AdTemplate> getGlobalImageListener() {
        if (mDefaultListener == null) {
            mDefaultListener = new GlobalImageListener();
        }
        return mDefaultListener;
    }

    private static Context getSDKContext() {
        e eVar = (e) ServiceProvider.get(e.class);
        if (eVar != null) {
            return eVar.getContext();
        }
        return null;
    }

    public static void loadAppIcon(ImageView imageView, @Nullable String str, AdTemplate adTemplate, int i2) {
        if (imageView == null || TextUtils.isEmpty(str) || getSDKContext() == null) {
            return;
        }
        DisplayImageOptionsCompat.Builder builder = new DisplayImageOptionsCompat.Builder();
        Resources resources = imageView.getContext().getResources();
        int i3 = R.drawable.ksad_default_app_icon;
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, builder.showImageOnLoading(resources.getDrawable(i3)).showImageForEmptyUri(imageView.getContext().getResources().getDrawable(i3)).showImageOnFail(imageView.getContext().getResources().getDrawable(i3)).considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565).setCornerRound(i2).build(), new InnerImageLoadingListener(adTemplate, null));
    }

    public static void loadCircleIcon(ImageView imageView, String str, Drawable drawable) {
        if (imageView == null || getSDKContext() == null) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, new DisplayImageOptionsCompat.Builder().showImageOnLoading(drawable).showImageForEmptyUri(drawable).showImageOnFail(drawable).cacheInMemory(true).cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565).setStrokeColor(Color.argb(255, 255, 255, 255)).setStrokeWidth(1.0f).build(), (ImageLoadingListener) null);
    }

    public static void loadCircleIcon(ImageView imageView, String str, Drawable drawable, @ColorInt int i2) {
        if (imageView == null || getSDKContext() == null) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, new DisplayImageOptionsCompat.Builder().showImageOnLoading(drawable).showImageForEmptyUri(drawable).showImageOnFail(drawable).cacheInMemory(true).cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565).setStrokeColor(i2).setStrokeWidth(1.0f).build(), (ImageLoadingListener) null);
    }

    public static void loadCircleIconWithBorder(ImageView imageView, String str, Drawable drawable, Integer num, float f2) {
        if (imageView == null || getSDKContext() == null) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, new DisplayImageOptionsCompat.Builder().showImageOnLoading(drawable).showImageForEmptyUri(drawable).showImageOnFail(drawable).cacheInMemory(true).cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565).setStrokeColor(num.intValue()).setStrokeWidth(f2).build(), (ImageLoadingListener) null);
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

    public static void loadFeeImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate, ImageLoadingListener imageLoadingListener) {
        if (imageView == null || TextUtils.isEmpty(str) || getSDKContext() == null) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, new DisplayImageOptionsCompat.Builder().bitmapConfig(Bitmap.Config.RGB_565).cacheInMemory(true).cacheOnDisk(true).setCornerRound(1).build(), new InnerImageLoadingListener(adTemplate, imageLoadingListener));
    }

    public static void loadImage(ImageView imageView, @Nullable String str) {
        loadImage(imageView, str, (AdTemplate) null, IMGOPTION_NORMAL);
    }

    public static void loadImage(ImageView imageView, @Nullable String str, DisplayImageOptionsCompat displayImageOptionsCompat) {
        if (imageView == null) {
            return;
        }
        if (displayImageOptionsCompat == null) {
            displayImageOptionsCompat = IMGOPTION_NORMAL;
        }
        ImageLoaderProxy.INSTANCE.load(((e) ServiceProvider.get(e.class)).getContext(), str, imageView, displayImageOptionsCompat, (ImageLoadingListener) null);
    }

    public static void loadImage(ImageView imageView, @Nullable String str, ImageLoadingListener imageLoadingListener) {
        if (imageView == null) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(((e) ServiceProvider.get(e.class)).getContext(), str, imageView, IMGOPTION_NORMAL, imageLoadingListener);
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

    public static void loadImage(ImageView imageView, @Nullable String str, AdTemplate adTemplate, ImageLoadingListener imageLoadingListener) {
        if (imageView == null || TextUtils.isEmpty(str) || getSDKContext() == null) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, IMGOPTION_NORMAL, new InnerImageLoadingListener(adTemplate, imageLoadingListener));
    }

    public static void loadImage(String str, AdTemplate adTemplate, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener) {
        if (TextUtils.isEmpty(str) || getSDKContext() == null) {
            return;
        }
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, displayImageOptionsCompat, new InnerImageLoadingListener(adTemplate, imageLoadingListener));
    }

    public static void loadWithRadius(ImageView imageView, @Nullable String str, AdTemplate adTemplate, int i2) {
        if (imageView == null || TextUtils.isEmpty(str) || getSDKContext() == null) {
            return;
        }
        DisplayImageOptionsCompat.Builder builder = new DisplayImageOptionsCompat.Builder();
        Resources resources = imageView.getContext().getResources();
        int i3 = R.drawable.ksad_default_app_icon;
        ImageLoaderProxy.INSTANCE.load(getSDKContext(), str, imageView, builder.showImageOnLoading(resources.getDrawable(i3)).showImageForEmptyUri(imageView.getContext().getResources().getDrawable(i3)).showImageOnFail(imageView.getContext().getResources().getDrawable(i3)).considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565).setCornerRound(i2).build(), new InnerImageLoadingListener(adTemplate, null));
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
}
