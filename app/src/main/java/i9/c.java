package i9;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import java.io.File;
import java.net.URL;

/* loaded from: classes3.dex */
public class c<TranscodeType> extends RequestBuilder<TranscodeType> implements Cloneable {
    public c(@NonNull Class<TranscodeType> cls, @NonNull RequestBuilder<?> requestBuilder) {
        super(cls, requestBuilder);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: A, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c<TranscodeType> load2(@Nullable Uri uri) {
        return (c) super.load2(uri);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: B, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c<TranscodeType> load2(@Nullable File file) {
        return (c) super.load2(file);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: C, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c<TranscodeType> load2(@Nullable @DrawableRes @RawRes Integer num) {
        return (c) super.load2(num);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: D, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c<TranscodeType> load2(@Nullable Object obj) {
        return (c) super.load2(obj);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: E, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c<TranscodeType> load2(@Nullable String str) {
        return (c) super.load2(str);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @CheckResult
    @Deprecated
    /* renamed from: F, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c<TranscodeType> load2(@Nullable URL url) {
        return (c) super.load2(url);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: G, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c<TranscodeType> load2(@Nullable byte[] bArr) {
        return (c) super.load2(bArr);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: H */
    public c<TranscodeType> onlyRetrieveFromCache(boolean z10) {
        return (c) super.onlyRetrieveFromCache(z10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: I */
    public c<TranscodeType> optionalCenterCrop() {
        return (c) super.optionalCenterCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: J */
    public c<TranscodeType> optionalCenterInside() {
        return (c) super.optionalCenterInside();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: K */
    public c<TranscodeType> optionalCircleCrop() {
        return (c) super.optionalCircleCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: L */
    public c<TranscodeType> optionalFitCenter() {
        return (c) super.optionalFitCenter();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: M */
    public c<TranscodeType> optionalTransform(@NonNull Transformation<Bitmap> transformation) {
        return (c) super.optionalTransform(transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: N */
    public <Y> c<TranscodeType> optionalTransform(@NonNull Class<Y> cls, @NonNull Transformation<Y> transformation) {
        return (c) super.optionalTransform(cls, transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: O */
    public c<TranscodeType> override(int i10) {
        return (c) super.override(i10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: P */
    public c<TranscodeType> override(int i10, int i11) {
        return (c) super.override(i10, i11);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: Q */
    public c<TranscodeType> placeholder(@DrawableRes int i10) {
        return (c) super.placeholder(i10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: R */
    public c<TranscodeType> placeholder(@Nullable Drawable drawable) {
        return (c) super.placeholder(drawable);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: S */
    public c<TranscodeType> priority(@NonNull Priority priority) {
        return (c) super.priority(priority);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: T */
    public <Y> c<TranscodeType> set(@NonNull Option<Y> option, @NonNull Y y10) {
        return (c) super.set(option, y10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: U */
    public c<TranscodeType> signature(@NonNull Key key) {
        return (c) super.signature(key);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: V */
    public c<TranscodeType> sizeMultiplier(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        return (c) super.sizeMultiplier(f10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: W */
    public c<TranscodeType> skipMemoryCache(boolean z10) {
        return (c) super.skipMemoryCache(z10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: X */
    public c<TranscodeType> theme(@Nullable Resources.Theme theme) {
        return (c) super.theme(theme);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @CheckResult
    /* renamed from: Y */
    public c<TranscodeType> thumbnail(float f10) {
        return (c) super.thumbnail(f10);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @CheckResult
    /* renamed from: Z */
    public c<TranscodeType> thumbnail(@Nullable RequestBuilder<TranscodeType> requestBuilder) {
        return (c) super.thumbnail(requestBuilder);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @CheckResult
    /* renamed from: a */
    public c<TranscodeType> addListener(@Nullable RequestListener<TranscodeType> requestListener) {
        return (c) super.addListener(requestListener);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @SafeVarargs
    @CheckResult
    /* renamed from: a0 */
    public final c<TranscodeType> thumbnail(@Nullable RequestBuilder<TranscodeType>... requestBuilderArr) {
        return (c) super.thumbnail(requestBuilderArr);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: b */
    public c<TranscodeType> apply(@NonNull BaseRequestOptions<?> baseRequestOptions) {
        return (c) super.apply(baseRequestOptions);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: b0 */
    public c<TranscodeType> timeout(@IntRange(from = 0) int i10) {
        return (c) super.timeout(i10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: c */
    public c<TranscodeType> centerCrop() {
        return (c) super.centerCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: c0 */
    public c<TranscodeType> transform(@NonNull Transformation<Bitmap> transformation) {
        return (c) super.transform(transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: d */
    public c<TranscodeType> centerInside() {
        return (c) super.centerInside();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: d0 */
    public <Y> c<TranscodeType> transform(@NonNull Class<Y> cls, @NonNull Transformation<Y> transformation) {
        return (c) super.transform(cls, transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: e */
    public c<TranscodeType> circleCrop() {
        return (c) super.circleCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: e0 */
    public c<TranscodeType> transform(@NonNull Transformation<Bitmap>... transformationArr) {
        return (c) super.transform(transformationArr);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.request.BaseRequestOptions
    @CheckResult
    /* renamed from: f */
    public c<TranscodeType> mo29clone() {
        return (c) super.mo29clone();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    @Deprecated
    /* renamed from: f0 */
    public c<TranscodeType> transforms(@NonNull Transformation<Bitmap>... transformationArr) {
        return (c) super.transforms(transformationArr);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: g */
    public c<TranscodeType> decode(@NonNull Class<?> cls) {
        return (c) super.decode(cls);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @CheckResult
    /* renamed from: g0 */
    public c<TranscodeType> transition(@NonNull TransitionOptions<?, ? super TranscodeType> transitionOptions) {
        return (c) super.transition(transitionOptions);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: h */
    public c<TranscodeType> disallowHardwareConfig() {
        return (c) super.disallowHardwareConfig();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: h0 */
    public c<TranscodeType> useAnimationPool(boolean z10) {
        return (c) super.useAnimationPool(z10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: i */
    public c<TranscodeType> diskCacheStrategy(@NonNull DiskCacheStrategy diskCacheStrategy) {
        return (c) super.diskCacheStrategy(diskCacheStrategy);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: i0 */
    public c<TranscodeType> useUnlimitedSourceGeneratorsPool(boolean z10) {
        return (c) super.useUnlimitedSourceGeneratorsPool(z10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: j */
    public c<TranscodeType> dontAnimate() {
        return (c) super.dontAnimate();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: k */
    public c<TranscodeType> dontTransform() {
        return (c) super.dontTransform();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: l */
    public c<TranscodeType> downsample(@NonNull DownsampleStrategy downsampleStrategy) {
        return (c) super.downsample(downsampleStrategy);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: m */
    public c<TranscodeType> encodeFormat(@NonNull Bitmap.CompressFormat compressFormat) {
        return (c) super.encodeFormat(compressFormat);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: n */
    public c<TranscodeType> encodeQuality(@IntRange(from = 0, to = 100) int i10) {
        return (c) super.encodeQuality(i10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: o */
    public c<TranscodeType> error(@DrawableRes int i10) {
        return (c) super.error(i10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: p */
    public c<TranscodeType> error(@Nullable Drawable drawable) {
        return (c) super.error(drawable);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    /* renamed from: q */
    public c<TranscodeType> error(@Nullable RequestBuilder<TranscodeType> requestBuilder) {
        return (c) super.error(requestBuilder);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: r */
    public c<TranscodeType> fallback(@DrawableRes int i10) {
        return (c) super.fallback(i10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: s */
    public c<TranscodeType> fallback(@Nullable Drawable drawable) {
        return (c) super.fallback(drawable);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: t */
    public c<TranscodeType> fitCenter() {
        return (c) super.fitCenter();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: u */
    public c<TranscodeType> format(@NonNull DecodeFormat decodeFormat) {
        return (c) super.format(decodeFormat);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: v */
    public c<TranscodeType> frame(@IntRange(from = 0) long j10) {
        return (c) super.frame(j10);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @CheckResult
    /* renamed from: w */
    public c<File> getDownloadOnlyRequest() {
        return new c(File.class, this).apply(RequestBuilder.DOWNLOAD_ONLY_OPTIONS);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @NonNull
    @CheckResult
    /* renamed from: x */
    public c<TranscodeType> listener(@Nullable RequestListener<TranscodeType> requestListener) {
        return (c) super.listener(requestListener);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: y, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c<TranscodeType> load2(@Nullable Bitmap bitmap) {
        return (c) super.load2(bitmap);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @NonNull
    @CheckResult
    /* renamed from: z, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c<TranscodeType> load2(@Nullable Drawable drawable) {
        return (c) super.load2(drawable);
    }

    public c(@NonNull Glide glide, @NonNull RequestManager requestManager, @NonNull Class<TranscodeType> cls, @NonNull Context context) {
        super(glide, requestManager, cls, context);
    }
}
