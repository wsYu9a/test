package com.alimm.tanx.ui.image.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.alimm.tanx.ui.image.glide.load.Encoder;
import com.alimm.tanx.ui.image.glide.load.Key;
import com.alimm.tanx.ui.image.glide.load.ResourceDecoder;
import com.alimm.tanx.ui.image.glide.load.ResourceEncoder;
import com.alimm.tanx.ui.image.glide.load.Transformation;
import com.alimm.tanx.ui.image.glide.load.engine.DiskCacheStrategy;
import com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper;
import com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapTransformation;
import com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable;
import com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper;
import com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapperTransformation;
import com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder;
import com.alimm.tanx.ui.image.glide.manager.Lifecycle;
import com.alimm.tanx.ui.image.glide.manager.RequestTracker;
import com.alimm.tanx.ui.image.glide.provider.LoadProvider;
import com.alimm.tanx.ui.image.glide.request.RequestListener;
import com.alimm.tanx.ui.image.glide.request.animation.DrawableCrossFadeFactory;
import com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory;
import com.alimm.tanx.ui.image.glide.request.animation.ViewPropertyAnimation;
import com.alimm.tanx.ui.image.glide.request.target.Target;
import java.io.File;

/* loaded from: classes.dex */
public class DrawableRequestBuilder<ModelType> extends GenericRequestBuilder<ModelType, ImageVideoWrapper, GifBitmapWrapper, GlideDrawable> implements BitmapOptions, DrawableOptions {
    public DrawableRequestBuilder(Context context, Class<ModelType> cls, LoadProvider<ModelType, ImageVideoWrapper, GifBitmapWrapper, GlideDrawable> loadProvider, Glide glide, RequestTracker requestTracker, Lifecycle lifecycle) {
        super(context, cls, loadProvider, GlideDrawable.class, glide, requestTracker, lifecycle);
        crossFade();
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public void applyCenterCrop() {
        centerCrop();
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public void applyFitCenter() {
        fitCenter();
    }

    public DrawableRequestBuilder<ModelType> bitmapTransform(Transformation<Bitmap>... transformationArr) {
        GifBitmapWrapperTransformation[] gifBitmapWrapperTransformationArr = new GifBitmapWrapperTransformation[transformationArr.length];
        for (int i10 = 0; i10 < transformationArr.length; i10++) {
            gifBitmapWrapperTransformationArr[i10] = new GifBitmapWrapperTransformation(this.glide.getBitmapPool(), transformationArr[i10]);
        }
        return transform((Transformation<GifBitmapWrapper>[]) gifBitmapWrapperTransformationArr);
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public Target<GlideDrawable> into(ImageView imageView) {
        return super.into(imageView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public /* bridge */ /* synthetic */ GenericRequestBuilder load(Object obj) {
        return load((DrawableRequestBuilder<ModelType>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> cacheDecoder(ResourceDecoder<File, GifBitmapWrapper> resourceDecoder) {
        super.cacheDecoder((ResourceDecoder) resourceDecoder);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.BitmapOptions
    public DrawableRequestBuilder<ModelType> centerCrop() {
        return transform(this.glide.getDrawableCenterCrop());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> decoder(ResourceDecoder<ImageVideoWrapper, GifBitmapWrapper> resourceDecoder) {
        super.decoder((ResourceDecoder) resourceDecoder);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> diskCacheStrategy(DiskCacheStrategy diskCacheStrategy) {
        super.diskCacheStrategy(diskCacheStrategy);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> dontAnimate() {
        super.dontAnimate();
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> dontTransform() {
        super.dontTransform();
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> encoder(ResourceEncoder<GifBitmapWrapper> resourceEncoder) {
        super.encoder((ResourceEncoder) resourceEncoder);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.BitmapOptions
    public DrawableRequestBuilder<ModelType> fitCenter() {
        return transform(this.glide.getDrawableFitCenter());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> listener(RequestListener<? super ModelType, GlideDrawable> requestListener) {
        super.listener((RequestListener) requestListener);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> load(ModelType modeltype) {
        super.load((DrawableRequestBuilder<ModelType>) modeltype);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> override(int i10, int i11) {
        super.override(i10, i11);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> priority(Priority priority) {
        super.priority(priority);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> signature(Key key) {
        super.signature(key);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> sizeMultiplier(float f10) {
        super.sizeMultiplier(f10);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> skipMemoryCache(boolean z10) {
        super.skipMemoryCache(z10);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> sourceEncoder(Encoder<ImageVideoWrapper> encoder) {
        super.sourceEncoder((Encoder) encoder);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> transcoder(ResourceTranscoder<GifBitmapWrapper, GlideDrawable> resourceTranscoder) {
        super.transcoder((ResourceTranscoder) resourceTranscoder);
        return this;
    }

    public DrawableRequestBuilder<ModelType> transform(BitmapTransformation... bitmapTransformationArr) {
        return bitmapTransform(bitmapTransformationArr);
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    /* renamed from: clone */
    public DrawableRequestBuilder<ModelType> mo27clone() {
        return (DrawableRequestBuilder) super.mo27clone();
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> error(int i10) {
        super.error(i10);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> fallback(Drawable drawable) {
        super.fallback(drawable);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> placeholder(int i10) {
        super.placeholder(i10);
        return this;
    }

    public DrawableRequestBuilder<ModelType> thumbnail(DrawableRequestBuilder<?> drawableRequestBuilder) {
        super.thumbnail((GenericRequestBuilder) drawableRequestBuilder);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> transform(Transformation<GifBitmapWrapper>... transformationArr) {
        super.transform((Transformation[]) transformationArr);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> error(Drawable drawable) {
        super.error(drawable);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> fallback(int i10) {
        super.fallback(i10);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> placeholder(Drawable drawable) {
        super.placeholder(drawable);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> thumbnail(GenericRequestBuilder<?, ?, ?, GlideDrawable> genericRequestBuilder) {
        super.thumbnail((GenericRequestBuilder) genericRequestBuilder);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> animate(ViewPropertyAnimation.Animator animator) {
        super.animate(animator);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.DrawableOptions
    public final DrawableRequestBuilder<ModelType> crossFade() {
        super.animate((GlideAnimationFactory) new DrawableCrossFadeFactory());
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> thumbnail(float f10) {
        super.thumbnail(f10);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> animate(GlideAnimationFactory<GlideDrawable> glideAnimationFactory) {
        super.animate((GlideAnimationFactory) glideAnimationFactory);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.DrawableOptions
    public DrawableRequestBuilder<ModelType> crossFade(int i10) {
        super.animate((GlideAnimationFactory) new DrawableCrossFadeFactory(i10));
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public DrawableRequestBuilder<ModelType> animate(int i10) {
        super.animate(i10);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.DrawableOptions
    @Deprecated
    public DrawableRequestBuilder<ModelType> crossFade(Animation animation, int i10) {
        super.animate((GlideAnimationFactory) new DrawableCrossFadeFactory(animation, i10));
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    @Deprecated
    public DrawableRequestBuilder<ModelType> animate(Animation animation) {
        super.animate(animation);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.DrawableOptions
    public DrawableRequestBuilder<ModelType> crossFade(int i10, int i11) {
        super.animate((GlideAnimationFactory) new DrawableCrossFadeFactory(this.context, i10, i11));
        return this;
    }
}
