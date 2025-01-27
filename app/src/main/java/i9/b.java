package i9;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;

/* loaded from: classes3.dex */
public final class b extends RequestOptions implements Cloneable {

    /* renamed from: b */
    public static b f26935b;

    /* renamed from: c */
    public static b f26936c;

    /* renamed from: d */
    public static b f26937d;

    /* renamed from: e */
    public static b f26938e;

    /* renamed from: f */
    public static b f26939f;

    /* renamed from: g */
    public static b f26940g;

    @NonNull
    @CheckResult
    public static b A(@Nullable Drawable drawable) {
        return new b().error(drawable);
    }

    @NonNull
    @CheckResult
    public static b E() {
        if (f26935b == null) {
            f26935b = new b().fitCenter().autoClone();
        }
        return f26935b;
    }

    @NonNull
    @CheckResult
    public static b G(@NonNull DecodeFormat decodeFormat) {
        return new b().format(decodeFormat);
    }

    @NonNull
    @CheckResult
    public static b I(@IntRange(from = 0) long j10) {
        return new b().frame(j10);
    }

    @NonNull
    @CheckResult
    public static b K() {
        if (f26940g == null) {
            f26940g = new b().dontAnimate().autoClone();
        }
        return f26940g;
    }

    @NonNull
    @CheckResult
    public static b L() {
        if (f26939f == null) {
            f26939f = new b().dontTransform().autoClone();
        }
        return f26939f;
    }

    @NonNull
    @CheckResult
    public static <T> b N(@NonNull Option<T> option, @NonNull T t10) {
        return new b().set(option, t10);
    }

    @NonNull
    @CheckResult
    public static b W(int i10) {
        return new b().override(i10);
    }

    @NonNull
    @CheckResult
    public static b X(int i10, int i11) {
        return new b().override(i10, i11);
    }

    @NonNull
    @CheckResult
    public static b a0(@DrawableRes int i10) {
        return new b().placeholder(i10);
    }

    @NonNull
    @CheckResult
    public static b b0(@Nullable Drawable drawable) {
        return new b().placeholder(drawable);
    }

    @NonNull
    @CheckResult
    public static b c(@NonNull Transformation<Bitmap> transformation) {
        return new b().transform(transformation);
    }

    @NonNull
    @CheckResult
    public static b d0(@NonNull Priority priority) {
        return new b().priority(priority);
    }

    @NonNull
    @CheckResult
    public static b e() {
        if (f26937d == null) {
            f26937d = new b().centerCrop().autoClone();
        }
        return f26937d;
    }

    @NonNull
    @CheckResult
    public static b g() {
        if (f26936c == null) {
            f26936c = new b().centerInside().autoClone();
        }
        return f26936c;
    }

    @NonNull
    @CheckResult
    public static b g0(@NonNull Key key) {
        return new b().signature(key);
    }

    @NonNull
    @CheckResult
    public static b i() {
        if (f26938e == null) {
            f26938e = new b().circleCrop().autoClone();
        }
        return f26938e;
    }

    @NonNull
    @CheckResult
    public static b i0(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        return new b().sizeMultiplier(f10);
    }

    @NonNull
    @CheckResult
    public static b k0(boolean z10) {
        return new b().skipMemoryCache(z10);
    }

    @NonNull
    @CheckResult
    public static b l(@NonNull Class<?> cls) {
        return new b().decode(cls);
    }

    @NonNull
    @CheckResult
    public static b n0(@IntRange(from = 0) int i10) {
        return new b().timeout(i10);
    }

    @NonNull
    @CheckResult
    public static b o(@NonNull DiskCacheStrategy diskCacheStrategy) {
        return new b().diskCacheStrategy(diskCacheStrategy);
    }

    @NonNull
    @CheckResult
    public static b s(@NonNull DownsampleStrategy downsampleStrategy) {
        return new b().downsample(downsampleStrategy);
    }

    @NonNull
    @CheckResult
    public static b u(@NonNull Bitmap.CompressFormat compressFormat) {
        return new b().encodeFormat(compressFormat);
    }

    @NonNull
    @CheckResult
    public static b w(@IntRange(from = 0, to = 100) int i10) {
        return new b().encodeQuality(i10);
    }

    @NonNull
    @CheckResult
    public static b z(@DrawableRes int i10) {
        return new b().error(i10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: B */
    public b fallback(@DrawableRes int i10) {
        return (b) super.fallback(i10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: C */
    public b fallback(@Nullable Drawable drawable) {
        return (b) super.fallback(drawable);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: D */
    public b fitCenter() {
        return (b) super.fitCenter();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: F */
    public b format(@NonNull DecodeFormat decodeFormat) {
        return (b) super.format(decodeFormat);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: H */
    public b frame(@IntRange(from = 0) long j10) {
        return (b) super.frame(j10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    /* renamed from: J */
    public b lock() {
        return (b) super.lock();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: M */
    public b onlyRetrieveFromCache(boolean z10) {
        return (b) super.onlyRetrieveFromCache(z10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: O */
    public b optionalCenterCrop() {
        return (b) super.optionalCenterCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: P */
    public b optionalCenterInside() {
        return (b) super.optionalCenterInside();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: Q */
    public b optionalCircleCrop() {
        return (b) super.optionalCircleCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: R */
    public b optionalFitCenter() {
        return (b) super.optionalFitCenter();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: S */
    public b optionalTransform(@NonNull Transformation<Bitmap> transformation) {
        return (b) super.optionalTransform(transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: T */
    public <Y> b optionalTransform(@NonNull Class<Y> cls, @NonNull Transformation<Y> transformation) {
        return (b) super.optionalTransform(cls, transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: U */
    public b override(int i10) {
        return (b) super.override(i10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: V */
    public b override(int i10, int i11) {
        return (b) super.override(i10, i11);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: Y */
    public b placeholder(@DrawableRes int i10) {
        return (b) super.placeholder(i10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: Z */
    public b placeholder(@Nullable Drawable drawable) {
        return (b) super.placeholder(drawable);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: a */
    public b apply(@NonNull BaseRequestOptions<?> baseRequestOptions) {
        return (b) super.apply(baseRequestOptions);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    /* renamed from: b */
    public b autoClone() {
        return (b) super.autoClone();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: c0 */
    public b priority(@NonNull Priority priority) {
        return (b) super.priority(priority);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: d */
    public b centerCrop() {
        return (b) super.centerCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: e0 */
    public <Y> b set(@NonNull Option<Y> option, @NonNull Y y10) {
        return (b) super.set(option, y10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: f */
    public b centerInside() {
        return (b) super.centerInside();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: f0 */
    public b signature(@NonNull Key key) {
        return (b) super.signature(key);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: h */
    public b circleCrop() {
        return (b) super.circleCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: h0 */
    public b sizeMultiplier(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        return (b) super.sizeMultiplier(f10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @CheckResult
    /* renamed from: j */
    public b mo29clone() {
        return (b) super.mo29clone();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: j0 */
    public b skipMemoryCache(boolean z10) {
        return (b) super.skipMemoryCache(z10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: k */
    public b decode(@NonNull Class<?> cls) {
        return (b) super.decode(cls);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: l0 */
    public b theme(@Nullable Resources.Theme theme) {
        return (b) super.theme(theme);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: m */
    public b disallowHardwareConfig() {
        return (b) super.disallowHardwareConfig();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: m0 */
    public b timeout(@IntRange(from = 0) int i10) {
        return (b) super.timeout(i10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: n */
    public b diskCacheStrategy(@NonNull DiskCacheStrategy diskCacheStrategy) {
        return (b) super.diskCacheStrategy(diskCacheStrategy);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: o0 */
    public b transform(@NonNull Transformation<Bitmap> transformation) {
        return (b) super.transform(transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: p */
    public b dontAnimate() {
        return (b) super.dontAnimate();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: p0 */
    public <Y> b transform(@NonNull Class<Y> cls, @NonNull Transformation<Y> transformation) {
        return (b) super.transform(cls, transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: q */
    public b dontTransform() {
        return (b) super.dontTransform();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @SafeVarargs
    @CheckResult
    /* renamed from: q0 */
    public final b transform(@NonNull Transformation<Bitmap>... transformationArr) {
        return (b) super.transform(transformationArr);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: r */
    public b downsample(@NonNull DownsampleStrategy downsampleStrategy) {
        return (b) super.downsample(downsampleStrategy);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @Deprecated
    @SafeVarargs
    @CheckResult
    /* renamed from: r0 */
    public final b transforms(@NonNull Transformation<Bitmap>... transformationArr) {
        return (b) super.transforms(transformationArr);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: s0 */
    public b useAnimationPool(boolean z10) {
        return (b) super.useAnimationPool(z10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: t */
    public b encodeFormat(@NonNull Bitmap.CompressFormat compressFormat) {
        return (b) super.encodeFormat(compressFormat);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: t0 */
    public b useUnlimitedSourceGeneratorsPool(boolean z10) {
        return (b) super.useUnlimitedSourceGeneratorsPool(z10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: v */
    public b encodeQuality(@IntRange(from = 0, to = 100) int i10) {
        return (b) super.encodeQuality(i10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: x */
    public b error(@DrawableRes int i10) {
        return (b) super.error(i10);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @NonNull
    @CheckResult
    /* renamed from: y */
    public b error(@Nullable Drawable drawable) {
        return (b) super.error(drawable);
    }
}
