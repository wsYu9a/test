package com.kwad.components.core.offline.init.kwai;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.kwad.components.offline.api.core.api.IImageLoader;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bi;
import java.io.InputStream;

/* loaded from: classes2.dex */
final class e implements IImageLoader {

    /* renamed from: com.kwad.components.core.offline.init.kwai.e$1 */
    final class AnonymousClass1 implements ImageLoadingListener {
        final /* synthetic */ IImageLoader.ImageLoadingListener Kf;

        AnonymousClass1(IImageLoader.ImageLoadingListener imageLoadingListener) {
            imageLoadingListener = imageLoadingListener;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            return imageLoadingListener.onDecode(str, inputStream, decodedResult == null ? null : decodedResult.mBitmap);
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingCancelled(String str, View view) {
            imageLoadingListener.onLoadingCancelled(str, view);
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
            imageLoadingListener.onLoadingComplete(str, view, decodedResult == null ? null : decodedResult.mBitmap);
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingFailed(String str, View view, FailReason failReason) {
            imageLoadingListener.onLoadingFailed(str, view, failReason.getType().toString(), failReason.getCause());
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingStarted(String str, View view) {
            imageLoadingListener.onLoadingStarted(str, view);
        }
    }

    /* renamed from: com.kwad.components.core.offline.init.kwai.e$2 */
    final class AnonymousClass2 implements ImageLoadingListener {
        final /* synthetic */ ImageView Ct;
        final /* synthetic */ IImageLoader.ImageLoadingListener Kf;
        final /* synthetic */ IImageLoader.DisplayImageOptionsCompat Kh;

        /* renamed from: com.kwad.components.core.offline.init.kwai.e$2$1 */
        final class AnonymousClass1 implements Runnable {
            final /* synthetic */ DecodedResult Ki;
            final /* synthetic */ String Kj;
            final /* synthetic */ View fe;

            /* renamed from: com.kwad.components.core.offline.init.kwai.e$2$1$1 */
            final class RunnableC01811 implements Runnable {
                final /* synthetic */ Bitmap Kl;

                RunnableC01811(Bitmap bitmap) {
                    stackBlur = bitmap;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Bitmap bitmap;
                    AnonymousClass2.this.Ct.setImageBitmap(stackBlur);
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    IImageLoader.ImageLoadingListener imageLoadingListener = AnonymousClass2.this.Kf;
                    String str = str;
                    View view = view;
                    DecodedResult decodedResult = decodedResult;
                    if (decodedResult == null) {
                        bitmap = null;
                    } else {
                        Bitmap bitmap2 = stackBlur;
                        bitmap = bitmap2 == null ? decodedResult.mBitmap : bitmap2;
                    }
                    imageLoadingListener.onLoadingComplete(str, view, bitmap);
                }
            }

            AnonymousClass1(DecodedResult decodedResult, String str, View view) {
                decodedResult = decodedResult;
                str = str;
                view = view;
            }

            @Override // java.lang.Runnable
            public final void run() {
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.offline.init.kwai.e.2.1.1
                    final /* synthetic */ Bitmap Kl;

                    RunnableC01811(Bitmap bitmap) {
                        stackBlur = bitmap;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Bitmap bitmap;
                        AnonymousClass2.this.Ct.setImageBitmap(stackBlur);
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        IImageLoader.ImageLoadingListener imageLoadingListener = AnonymousClass2.this.Kf;
                        String str = str;
                        View view = view;
                        DecodedResult decodedResult = decodedResult;
                        if (decodedResult == null) {
                            bitmap = null;
                        } else {
                            Bitmap bitmap2 = stackBlur;
                            bitmap = bitmap2 == null ? decodedResult.mBitmap : bitmap2;
                        }
                        imageLoadingListener.onLoadingComplete(str, view, bitmap);
                    }
                });
            }
        }

        AnonymousClass2(IImageLoader.ImageLoadingListener imageLoadingListener, IImageLoader.DisplayImageOptionsCompat displayImageOptionsCompat, ImageView imageView) {
            this.Kf = imageLoadingListener;
            this.Kh = displayImageOptionsCompat;
            this.Ct = imageView;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            return this.Kf.onDecode(str, inputStream, decodedResult == null ? null : decodedResult.mBitmap);
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingCancelled(String str, View view) {
            this.Kf.onLoadingCancelled(str, view);
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
            IImageLoader.DisplayImageOptionsCompat displayImageOptionsCompat = this.Kh;
            if (displayImageOptionsCompat == null || displayImageOptionsCompat.getBlurRadius() <= 0 || decodedResult == null || decodedResult.mBitmap == null) {
                this.Kf.onLoadingComplete(str, view, decodedResult == null ? null : decodedResult.mBitmap);
            } else {
                GlobalThreadPools.xM().submit(new Runnable() { // from class: com.kwad.components.core.offline.init.kwai.e.2.1
                    final /* synthetic */ DecodedResult Ki;
                    final /* synthetic */ String Kj;
                    final /* synthetic */ View fe;

                    /* renamed from: com.kwad.components.core.offline.init.kwai.e$2$1$1 */
                    final class RunnableC01811 implements Runnable {
                        final /* synthetic */ Bitmap Kl;

                        RunnableC01811(Bitmap bitmap) {
                            stackBlur = bitmap;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Bitmap bitmap;
                            AnonymousClass2.this.Ct.setImageBitmap(stackBlur);
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            IImageLoader.ImageLoadingListener imageLoadingListener = AnonymousClass2.this.Kf;
                            String str = str;
                            View view = view;
                            DecodedResult decodedResult = decodedResult;
                            if (decodedResult == null) {
                                bitmap = null;
                            } else {
                                Bitmap bitmap2 = stackBlur;
                                bitmap = bitmap2 == null ? decodedResult.mBitmap : bitmap2;
                            }
                            imageLoadingListener.onLoadingComplete(str, view, bitmap);
                        }
                    }

                    AnonymousClass1(DecodedResult decodedResult2, String str2, View view2) {
                        decodedResult = decodedResult2;
                        str = str2;
                        view = view2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.offline.init.kwai.e.2.1.1
                            final /* synthetic */ Bitmap Kl;

                            RunnableC01811(Bitmap bitmap) {
                                stackBlur = bitmap;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Bitmap bitmap;
                                AnonymousClass2.this.Ct.setImageBitmap(stackBlur);
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                IImageLoader.ImageLoadingListener imageLoadingListener = AnonymousClass2.this.Kf;
                                String str2 = str;
                                View view2 = view;
                                DecodedResult decodedResult2 = decodedResult;
                                if (decodedResult2 == null) {
                                    bitmap = null;
                                } else {
                                    Bitmap bitmap2 = stackBlur;
                                    bitmap = bitmap2 == null ? decodedResult2.mBitmap : bitmap2;
                                }
                                imageLoadingListener.onLoadingComplete(str2, view2, bitmap);
                            }
                        });
                    }
                });
            }
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingFailed(String str, View view, FailReason failReason) {
            this.Kf.onLoadingFailed(str, view, failReason.getType().toString(), failReason.getCause());
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingStarted(String str, View view) {
            this.Kf.onLoadingStarted(str, view);
        }
    }

    e() {
    }

    private static DisplayImageOptionsCompat a(IImageLoader.DisplayImageOptionsCompat displayImageOptionsCompat) {
        if (displayImageOptionsCompat == null) {
            return null;
        }
        return new DisplayImageOptionsCompat.Builder().showImageOnLoading(displayImageOptionsCompat.getImageOnLoading()).showImageForEmptyUri(displayImageOptionsCompat.getImageForEmptyUri()).showImageOnFail(displayImageOptionsCompat.getImageOnFail()).cacheInMemory(displayImageOptionsCompat.isCacheInMemory()).cacheOnDisk(displayImageOptionsCompat.isCacheOnDisk()).bitmapConfig(displayImageOptionsCompat.getDecodingOptions().inPreferredConfig).considerExifParams(displayImageOptionsCompat.isConsiderExifParams()).setBlurRadius(displayImageOptionsCompat.getBlurRadius()).setFrameSequence(displayImageOptionsCompat.isFrameSequence()).setCornerRound(displayImageOptionsCompat.getCornerRound()).setCircle(displayImageOptionsCompat.isCircle()).setStrokeColor(displayImageOptionsCompat.getStrokeColor()).setStrokeWidth(displayImageOptionsCompat.getStrokeWidth()).build();
    }

    private ImageLoadingListener a(IImageLoader.ImageLoadingListener imageLoadingListener) {
        if (imageLoadingListener == null) {
            return null;
        }
        return new ImageLoadingListener() { // from class: com.kwad.components.core.offline.init.kwai.e.1
            final /* synthetic */ IImageLoader.ImageLoadingListener Kf;

            AnonymousClass1(IImageLoader.ImageLoadingListener imageLoadingListener2) {
                imageLoadingListener = imageLoadingListener2;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                return imageLoadingListener.onDecode(str, inputStream, decodedResult == null ? null : decodedResult.mBitmap);
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingCancelled(String str, View view) {
                imageLoadingListener.onLoadingCancelled(str, view);
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                imageLoadingListener.onLoadingComplete(str, view, decodedResult == null ? null : decodedResult.mBitmap);
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view, FailReason failReason) {
                imageLoadingListener.onLoadingFailed(str, view, failReason.getType().toString(), failReason.getCause());
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingStarted(String str, View view) {
                imageLoadingListener.onLoadingStarted(str, view);
            }
        };
    }

    private ImageLoadingListener a(IImageLoader.ImageLoadingListener imageLoadingListener, IImageLoader.DisplayImageOptionsCompat displayImageOptionsCompat, ImageView imageView) {
        if (imageLoadingListener == null) {
            return null;
        }
        return new AnonymousClass2(imageLoadingListener, displayImageOptionsCompat, imageView);
    }

    @Override // com.kwad.components.offline.api.core.api.IImageLoader
    public final void loadImage(ImageView imageView, @Nullable String str) {
        KSImageLoader.loadImage(imageView, str);
    }

    @Override // com.kwad.components.offline.api.core.api.IImageLoader
    public final void loadImage(ImageView imageView, @Nullable String str, IImageLoader.DisplayImageOptionsCompat displayImageOptionsCompat) {
        KSImageLoader.loadImage(imageView, str, (AdTemplate) null, a(displayImageOptionsCompat));
    }

    @Override // com.kwad.components.offline.api.core.api.IImageLoader
    public final void loadImage(ImageView imageView, @Nullable String str, IImageLoader.DisplayImageOptionsCompat displayImageOptionsCompat, IImageLoader.ImageLoadingListener imageLoadingListener) {
        KSImageLoader.loadImage(imageView, str, null, a(displayImageOptionsCompat), a(imageLoadingListener, displayImageOptionsCompat, imageView));
    }

    @Override // com.kwad.components.offline.api.core.api.IImageLoader
    public final void loadImage(ImageView imageView, @Nullable String str, IImageLoader.ImageLoadingListener imageLoadingListener) {
        KSImageLoader.loadImage(imageView, str, (AdTemplate) null, a(imageLoadingListener, null, imageView));
    }

    @Override // com.kwad.components.offline.api.core.api.IImageLoader
    public final void loadImage(@Nullable String str, IImageLoader.DisplayImageOptionsCompat displayImageOptionsCompat, IImageLoader.ImageLoadingListener imageLoadingListener) {
        KSImageLoader.loadImage(str, (AdTemplate) null, a(displayImageOptionsCompat), a(imageLoadingListener));
    }
}
