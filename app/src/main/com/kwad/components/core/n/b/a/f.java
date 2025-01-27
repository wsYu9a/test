package com.kwad.components.core.n.b.a;

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
import com.kwad.sdk.utils.bt;
import java.io.InputStream;

/* loaded from: classes3.dex */
final class f implements IImageLoader {

    /* renamed from: com.kwad.components.core.n.b.a.f$1 */
    public class AnonymousClass1 implements ImageLoadingListener {
        final /* synthetic */ IImageLoader.ImageLoadingListener OD;

        public AnonymousClass1(IImageLoader.ImageLoadingListener imageLoadingListener) {
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

    /* renamed from: com.kwad.components.core.n.b.a.f$2 */
    public class AnonymousClass2 implements ImageLoadingListener {
        final /* synthetic */ ImageView EX;
        final /* synthetic */ IImageLoader.ImageLoadingListener OD;
        final /* synthetic */ IImageLoader.DisplayImageOptionsCompat OF;

        /* renamed from: com.kwad.components.core.n.b.a.f$2$1 */
        public class AnonymousClass1 implements Runnable {
            final /* synthetic */ DecodedResult OG;
            final /* synthetic */ String OH;
            final /* synthetic */ View gv;

            /* renamed from: com.kwad.components.core.n.b.a.f$2$1$1 */
            public class RunnableC04341 implements Runnable {
                final /* synthetic */ Bitmap OJ;

                public RunnableC04341(Bitmap bitmap) {
                    stackBlur = bitmap;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Bitmap bitmap;
                    AnonymousClass2.this.EX.setImageBitmap(stackBlur);
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    IImageLoader.ImageLoadingListener imageLoadingListener = AnonymousClass2.this.OD;
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

            public AnonymousClass1(DecodedResult decodedResult, String str, View view) {
                decodedResult = decodedResult;
                str = str;
                view = view;
            }

            @Override // java.lang.Runnable
            public final void run() {
                bt.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.n.b.a.f.2.1.1
                    final /* synthetic */ Bitmap OJ;

                    public RunnableC04341(Bitmap bitmap) {
                        stackBlur = bitmap;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Bitmap bitmap;
                        AnonymousClass2.this.EX.setImageBitmap(stackBlur);
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        IImageLoader.ImageLoadingListener imageLoadingListener = AnonymousClass2.this.OD;
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

        public AnonymousClass2(IImageLoader.ImageLoadingListener imageLoadingListener, IImageLoader.DisplayImageOptionsCompat displayImageOptionsCompat, ImageView imageView) {
            this.OD = imageLoadingListener;
            this.OF = displayImageOptionsCompat;
            this.EX = imageView;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            return this.OD.onDecode(str, inputStream, decodedResult == null ? null : decodedResult.mBitmap);
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingCancelled(String str, View view) {
            this.OD.onLoadingCancelled(str, view);
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
            IImageLoader.DisplayImageOptionsCompat displayImageOptionsCompat = this.OF;
            if (displayImageOptionsCompat == null || displayImageOptionsCompat.getBlurRadius() <= 0 || decodedResult == null || decodedResult.mBitmap == null) {
                this.OD.onLoadingComplete(str, view, decodedResult == null ? null : decodedResult.mBitmap);
            } else {
                GlobalThreadPools.Hk().submit(new Runnable() { // from class: com.kwad.components.core.n.b.a.f.2.1
                    final /* synthetic */ DecodedResult OG;
                    final /* synthetic */ String OH;
                    final /* synthetic */ View gv;

                    /* renamed from: com.kwad.components.core.n.b.a.f$2$1$1 */
                    public class RunnableC04341 implements Runnable {
                        final /* synthetic */ Bitmap OJ;

                        public RunnableC04341(Bitmap bitmap) {
                            stackBlur = bitmap;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Bitmap bitmap;
                            AnonymousClass2.this.EX.setImageBitmap(stackBlur);
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            IImageLoader.ImageLoadingListener imageLoadingListener = AnonymousClass2.this.OD;
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

                    public AnonymousClass1(DecodedResult decodedResult2, String str2, View view2) {
                        decodedResult = decodedResult2;
                        str = str2;
                        view = view2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        bt.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.n.b.a.f.2.1.1
                            final /* synthetic */ Bitmap OJ;

                            public RunnableC04341(Bitmap bitmap) {
                                stackBlur = bitmap;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Bitmap bitmap;
                                AnonymousClass2.this.EX.setImageBitmap(stackBlur);
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                IImageLoader.ImageLoadingListener imageLoadingListener = AnonymousClass2.this.OD;
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
            this.OD.onLoadingFailed(str, view, failReason.getType().toString(), failReason.getCause());
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingStarted(String str, View view) {
            this.OD.onLoadingStarted(str, view);
        }
    }

    private static DisplayImageOptionsCompat a(IImageLoader.DisplayImageOptionsCompat displayImageOptionsCompat) {
        if (displayImageOptionsCompat == null) {
            return null;
        }
        return new DisplayImageOptionsCompat.Builder().showImageOnLoading(displayImageOptionsCompat.getImageOnLoading()).showImageForEmptyUri(displayImageOptionsCompat.getImageForEmptyUri()).showImageOnFail(displayImageOptionsCompat.getImageOnFail()).cacheInMemory(displayImageOptionsCompat.isCacheInMemory()).cacheOnDisk(displayImageOptionsCompat.isCacheOnDisk()).bitmapConfig(displayImageOptionsCompat.getDecodingOptions().inPreferredConfig).considerExifParams(displayImageOptionsCompat.isConsiderExifParams()).setBlurRadius(displayImageOptionsCompat.getBlurRadius()).setFrameSequence(displayImageOptionsCompat.isFrameSequence()).setCornerRound(displayImageOptionsCompat.getCornerRound()).setCircle(displayImageOptionsCompat.isCircle()).setStrokeColor(displayImageOptionsCompat.getStrokeColor()).setStrokeWidth(displayImageOptionsCompat.getStrokeWidth()).build();
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
    public final void loadImage(ImageView imageView, @Nullable String str, IImageLoader.ImageLoadingListener imageLoadingListener) {
        KSImageLoader.loadImage(imageView, str, (AdTemplate) null, a(imageLoadingListener, null, imageView));
    }

    @Override // com.kwad.components.offline.api.core.api.IImageLoader
    public final void loadImage(ImageView imageView, @Nullable String str, IImageLoader.DisplayImageOptionsCompat displayImageOptionsCompat, IImageLoader.ImageLoadingListener imageLoadingListener) {
        KSImageLoader.loadImage(imageView, str, null, a(displayImageOptionsCompat), a(imageLoadingListener, displayImageOptionsCompat, imageView));
    }

    @Override // com.kwad.components.offline.api.core.api.IImageLoader
    public final void loadImage(@Nullable String str, IImageLoader.DisplayImageOptionsCompat displayImageOptionsCompat, IImageLoader.ImageLoadingListener imageLoadingListener) {
        KSImageLoader.loadImage(str, (AdTemplate) null, a(displayImageOptionsCompat), a(imageLoadingListener));
    }

    private ImageLoadingListener a(IImageLoader.ImageLoadingListener imageLoadingListener) {
        if (imageLoadingListener == null) {
            return null;
        }
        return new ImageLoadingListener() { // from class: com.kwad.components.core.n.b.a.f.1
            final /* synthetic */ IImageLoader.ImageLoadingListener OD;

            public AnonymousClass1(IImageLoader.ImageLoadingListener imageLoadingListener2) {
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
}
