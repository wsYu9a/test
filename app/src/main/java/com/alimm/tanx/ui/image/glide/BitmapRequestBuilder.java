package com.alimm.tanx.ui.image.glide;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.ParcelFileDescriptor;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.alimm.tanx.ui.image.glide.load.DecodeFormat;
import com.alimm.tanx.ui.image.glide.load.Encoder;
import com.alimm.tanx.ui.image.glide.load.Key;
import com.alimm.tanx.ui.image.glide.load.ResourceDecoder;
import com.alimm.tanx.ui.image.glide.load.ResourceEncoder;
import com.alimm.tanx.ui.image.glide.load.Transformation;
import com.alimm.tanx.ui.image.glide.load.engine.DiskCacheStrategy;
import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool;
import com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper;
import com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapTransformation;
import com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler;
import com.alimm.tanx.ui.image.glide.load.resource.bitmap.FileDescriptorBitmapDecoder;
import com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageVideoBitmapDecoder;
import com.alimm.tanx.ui.image.glide.load.resource.bitmap.StreamBitmapDecoder;
import com.alimm.tanx.ui.image.glide.load.resource.bitmap.VideoBitmapDecoder;
import com.alimm.tanx.ui.image.glide.load.resource.file.FileToStreamDecoder;
import com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder;
import com.alimm.tanx.ui.image.glide.provider.LoadProvider;
import com.alimm.tanx.ui.image.glide.request.RequestListener;
import com.alimm.tanx.ui.image.glide.request.animation.BitmapCrossFadeFactory;
import com.alimm.tanx.ui.image.glide.request.animation.DrawableCrossFadeFactory;
import com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory;
import com.alimm.tanx.ui.image.glide.request.animation.ViewPropertyAnimation;
import com.alimm.tanx.ui.image.glide.request.target.Target;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes.dex */
public class BitmapRequestBuilder<ModelType, TranscodeType> extends GenericRequestBuilder<ModelType, ImageVideoWrapper, Bitmap, TranscodeType> implements BitmapOptions, DrawableOptions {
    private final BitmapPool bitmapPool;
    private DecodeFormat decodeFormat;
    private Downsampler downsampler;
    private ResourceDecoder<InputStream, Bitmap> imageDecoder;
    private ResourceDecoder<ParcelFileDescriptor, Bitmap> videoDecoder;

    public BitmapRequestBuilder(LoadProvider<ModelType, ImageVideoWrapper, Bitmap, TranscodeType> loadProvider, Class<TranscodeType> cls, GenericRequestBuilder<ModelType, ?, ?, ?> genericRequestBuilder) {
        super(loadProvider, cls, genericRequestBuilder);
        this.downsampler = Downsampler.AT_LEAST;
        BitmapPool bitmapPool = genericRequestBuilder.glide.getBitmapPool();
        this.bitmapPool = bitmapPool;
        DecodeFormat decodeFormat = genericRequestBuilder.glide.getDecodeFormat();
        this.decodeFormat = decodeFormat;
        this.imageDecoder = new StreamBitmapDecoder(bitmapPool, decodeFormat);
        this.videoDecoder = new FileDescriptorBitmapDecoder(bitmapPool, this.decodeFormat);
    }

    private RuntimeException crossFadeNotSupported() {
        String canonicalName = this.transcodeClass.getCanonicalName();
        if (canonicalName == null) {
            canonicalName = this.transcodeClass.toString();
        }
        return new UnsupportedOperationException(".crossFade() is not supported for " + canonicalName + ", use .animate() to provide a compatible animation.");
    }

    private BitmapRequestBuilder<ModelType, TranscodeType> downsample(Downsampler downsampler) {
        this.downsampler = downsampler;
        StreamBitmapDecoder streamBitmapDecoder = new StreamBitmapDecoder(downsampler, this.bitmapPool, this.decodeFormat);
        this.imageDecoder = streamBitmapDecoder;
        super.decoder((ResourceDecoder) new ImageVideoBitmapDecoder(streamBitmapDecoder, this.videoDecoder));
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public void applyCenterCrop() {
        centerCrop();
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public void applyFitCenter() {
        fitCenter();
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> approximate() {
        return downsample(Downsampler.AT_LEAST);
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> asIs() {
        return downsample(Downsampler.NONE);
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> atMost() {
        return downsample(Downsampler.AT_MOST);
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> format(DecodeFormat decodeFormat) {
        this.decodeFormat = decodeFormat;
        this.imageDecoder = new StreamBitmapDecoder(this.downsampler, this.bitmapPool, decodeFormat);
        this.videoDecoder = new FileDescriptorBitmapDecoder(new VideoBitmapDecoder(), this.bitmapPool, decodeFormat);
        super.cacheDecoder((ResourceDecoder) new FileToStreamDecoder(new StreamBitmapDecoder(this.downsampler, this.bitmapPool, decodeFormat)));
        super.decoder((ResourceDecoder) new ImageVideoBitmapDecoder(this.imageDecoder, this.videoDecoder));
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> imageDecoder(ResourceDecoder<InputStream, Bitmap> resourceDecoder) {
        this.imageDecoder = resourceDecoder;
        super.decoder((ResourceDecoder) new ImageVideoBitmapDecoder(resourceDecoder, this.videoDecoder));
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public Target<TranscodeType> into(ImageView imageView) {
        return super.into(imageView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public /* bridge */ /* synthetic */ GenericRequestBuilder load(Object obj) {
        return load((BitmapRequestBuilder<ModelType, TranscodeType>) obj);
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> videoDecoder(ResourceDecoder<ParcelFileDescriptor, Bitmap> resourceDecoder) {
        this.videoDecoder = resourceDecoder;
        super.decoder((ResourceDecoder) new ImageVideoBitmapDecoder(this.imageDecoder, resourceDecoder));
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> cacheDecoder(ResourceDecoder<File, Bitmap> resourceDecoder) {
        super.cacheDecoder((ResourceDecoder) resourceDecoder);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.BitmapOptions
    public BitmapRequestBuilder<ModelType, TranscodeType> centerCrop() {
        return transform(this.glide.getBitmapCenterCrop());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> decoder(ResourceDecoder<ImageVideoWrapper, Bitmap> resourceDecoder) {
        super.decoder((ResourceDecoder) resourceDecoder);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> diskCacheStrategy(DiskCacheStrategy diskCacheStrategy) {
        super.diskCacheStrategy(diskCacheStrategy);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> dontAnimate() {
        super.dontAnimate();
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> dontTransform() {
        super.dontTransform();
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> encoder(ResourceEncoder<Bitmap> resourceEncoder) {
        super.encoder((ResourceEncoder) resourceEncoder);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.BitmapOptions
    public BitmapRequestBuilder<ModelType, TranscodeType> fitCenter() {
        return transform(this.glide.getBitmapFitCenter());
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> listener(RequestListener<? super ModelType, TranscodeType> requestListener) {
        super.listener((RequestListener) requestListener);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> load(ModelType modeltype) {
        super.load((BitmapRequestBuilder<ModelType, TranscodeType>) modeltype);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> override(int i10, int i11) {
        super.override(i10, i11);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> priority(Priority priority) {
        super.priority(priority);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> signature(Key key) {
        super.signature(key);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> sizeMultiplier(float f10) {
        super.sizeMultiplier(f10);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> skipMemoryCache(boolean z10) {
        super.skipMemoryCache(z10);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> sourceEncoder(Encoder<ImageVideoWrapper> encoder) {
        super.sourceEncoder((Encoder) encoder);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> transcoder(ResourceTranscoder<Bitmap, TranscodeType> resourceTranscoder) {
        super.transcoder((ResourceTranscoder) resourceTranscoder);
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> transform(BitmapTransformation... bitmapTransformationArr) {
        super.transform((Transformation[]) bitmapTransformationArr);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    /* renamed from: clone */
    public BitmapRequestBuilder<ModelType, TranscodeType> mo27clone() {
        return (BitmapRequestBuilder) super.mo27clone();
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> error(int i10) {
        super.error(i10);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> fallback(Drawable drawable) {
        super.fallback(drawable);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> placeholder(int i10) {
        super.placeholder(i10);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> thumbnail(float f10) {
        super.thumbnail(f10);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> transform(Transformation<Bitmap>... transformationArr) {
        super.transform((Transformation[]) transformationArr);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> error(Drawable drawable) {
        super.error(drawable);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> fallback(int i10) {
        super.fallback(i10);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> placeholder(Drawable drawable) {
        super.placeholder(drawable);
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> thumbnail(BitmapRequestBuilder<?, TranscodeType> bitmapRequestBuilder) {
        super.thumbnail((GenericRequestBuilder) bitmapRequestBuilder);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> animate(int i10) {
        super.animate(i10);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.DrawableOptions
    public final BitmapRequestBuilder<ModelType, TranscodeType> crossFade() {
        if (Bitmap.class.isAssignableFrom(this.transcodeClass)) {
            return animate((GlideAnimationFactory) new BitmapCrossFadeFactory());
        }
        if (Drawable.class.isAssignableFrom(this.transcodeClass)) {
            return animate((GlideAnimationFactory) new DrawableCrossFadeFactory());
        }
        throw crossFadeNotSupported();
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> thumbnail(GenericRequestBuilder<?, ?, ?, TranscodeType> genericRequestBuilder) {
        super.thumbnail((GenericRequestBuilder) genericRequestBuilder);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    @Deprecated
    public BitmapRequestBuilder<ModelType, TranscodeType> animate(Animation animation) {
        super.animate(animation);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> animate(ViewPropertyAnimation.Animator animator) {
        super.animate(animator);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public BitmapRequestBuilder<ModelType, TranscodeType> animate(GlideAnimationFactory<TranscodeType> glideAnimationFactory) {
        super.animate((GlideAnimationFactory) glideAnimationFactory);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.DrawableOptions
    public BitmapRequestBuilder<ModelType, TranscodeType> crossFade(int i10) {
        if (Bitmap.class.isAssignableFrom(this.transcodeClass)) {
            return animate((GlideAnimationFactory) new BitmapCrossFadeFactory(i10));
        }
        if (Drawable.class.isAssignableFrom(this.transcodeClass)) {
            return animate((GlideAnimationFactory) new DrawableCrossFadeFactory(i10));
        }
        throw crossFadeNotSupported();
    }

    @Override // com.alimm.tanx.ui.image.glide.DrawableOptions
    @Deprecated
    public BitmapRequestBuilder<ModelType, TranscodeType> crossFade(Animation animation, int i10) {
        if (Bitmap.class.isAssignableFrom(this.transcodeClass)) {
            return animate((GlideAnimationFactory) new BitmapCrossFadeFactory(animation, i10));
        }
        if (Drawable.class.isAssignableFrom(this.transcodeClass)) {
            return animate((GlideAnimationFactory) new DrawableCrossFadeFactory(animation, i10));
        }
        throw crossFadeNotSupported();
    }

    @Override // com.alimm.tanx.ui.image.glide.DrawableOptions
    public BitmapRequestBuilder<ModelType, TranscodeType> crossFade(int i10, int i11) {
        if (Bitmap.class.isAssignableFrom(this.transcodeClass)) {
            return animate((GlideAnimationFactory) new BitmapCrossFadeFactory(this.context, i10, i11));
        }
        if (Drawable.class.isAssignableFrom(this.transcodeClass)) {
            return animate((GlideAnimationFactory) new DrawableCrossFadeFactory(this.context, i10, i11));
        }
        throw crossFadeNotSupported();
    }
}
