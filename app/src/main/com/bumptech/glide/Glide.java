package com.bumptech.glide;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.prefill.BitmapPreFiller;
import com.bumptech.glide.load.engine.prefill.PreFillType;
import com.bumptech.glide.load.model.AssetUriLoader;
import com.bumptech.glide.load.model.ByteArrayLoader;
import com.bumptech.glide.load.model.ByteBufferEncoder;
import com.bumptech.glide.load.model.ByteBufferFileLoader;
import com.bumptech.glide.load.model.DataUrlLoader;
import com.bumptech.glide.load.model.FileLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.MediaStoreFileLoader;
import com.bumptech.glide.load.model.ResourceLoader;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.model.StringLoader;
import com.bumptech.glide.load.model.UnitModelLoader;
import com.bumptech.glide.load.model.UriLoader;
import com.bumptech.glide.load.model.UrlUriLoader;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.model.stream.HttpUriLoader;
import com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader;
import com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader;
import com.bumptech.glide.load.model.stream.QMediaStoreUriLoader;
import com.bumptech.glide.load.model.stream.UrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableEncoder;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.ExifInterfaceImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.InputStreamBitmapImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.ParcelFileDescriptorBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.ResourceBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.bytes.ByteBufferRewinder;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.bumptech.glide.load.resource.drawable.UnitDrawableDecoder;
import com.bumptech.glide.load.resource.file.FileDecoder;
import com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableEncoder;
import com.bumptech.glide.load.resource.gif.GifFrameResourceDecoder;
import com.bumptech.glide.load.resource.gif.StreamGifDecoder;
import com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.BitmapDrawableTranscoder;
import com.bumptech.glide.load.resource.transcode.DrawableBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.GifDrawableBytesTranscoder;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.module.ManifestParser;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class Glide implements ComponentCallbacks2 {
    private static final String DEFAULT_DISK_CACHE_DIR = "image_manager_disk_cache";
    private static final String TAG = "Glide";
    private static volatile Glide glide;
    private static volatile boolean isInitializing;
    private final ArrayPool arrayPool;
    private final BitmapPool bitmapPool;

    @Nullable
    @GuardedBy("this")
    private BitmapPreFiller bitmapPreFiller;
    private final ConnectivityMonitorFactory connectivityMonitorFactory;
    private final RequestOptionsFactory defaultRequestOptionsFactory;
    private final Engine engine;
    private final GlideContext glideContext;
    private final MemoryCache memoryCache;
    private final Registry registry;
    private final RequestManagerRetriever requestManagerRetriever;
    private final List<RequestManager> managers = new ArrayList();
    private MemoryCategory memoryCategory = MemoryCategory.NORMAL;

    public interface RequestOptionsFactory {
        @NonNull
        RequestOptions build();
    }

    public Glide(@NonNull Context context, @NonNull Engine engine, @NonNull MemoryCache memoryCache, @NonNull BitmapPool bitmapPool, @NonNull ArrayPool arrayPool, @NonNull RequestManagerRetriever requestManagerRetriever, @NonNull ConnectivityMonitorFactory connectivityMonitorFactory, int i10, @NonNull RequestOptionsFactory requestOptionsFactory, @NonNull Map<Class<?>, TransitionOptions<?, ?>> map, @NonNull List<RequestListener<Object>> list, boolean z10, boolean z11) {
        ResourceDecoder byteBufferBitmapDecoder;
        ResourceDecoder streamBitmapDecoder;
        Registry registry;
        this.engine = engine;
        this.bitmapPool = bitmapPool;
        this.arrayPool = arrayPool;
        this.memoryCache = memoryCache;
        this.requestManagerRetriever = requestManagerRetriever;
        this.connectivityMonitorFactory = connectivityMonitorFactory;
        this.defaultRequestOptionsFactory = requestOptionsFactory;
        Resources resources = context.getResources();
        Registry registry2 = new Registry();
        this.registry = registry2;
        registry2.register(new DefaultImageHeaderParser());
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 27) {
            registry2.register(new ExifInterfaceImageHeaderParser());
        }
        List<ImageHeaderParser> imageHeaderParsers = registry2.getImageHeaderParsers();
        ByteBufferGifDecoder byteBufferGifDecoder = new ByteBufferGifDecoder(context, imageHeaderParsers, bitmapPool, arrayPool);
        ResourceDecoder<ParcelFileDescriptor, Bitmap> parcel = VideoDecoder.parcel(bitmapPool);
        Downsampler downsampler = new Downsampler(registry2.getImageHeaderParsers(), resources.getDisplayMetrics(), bitmapPool, arrayPool);
        if (!z11 || i11 < 28) {
            byteBufferBitmapDecoder = new ByteBufferBitmapDecoder(downsampler);
            streamBitmapDecoder = new StreamBitmapDecoder(downsampler, arrayPool);
        } else {
            streamBitmapDecoder = new InputStreamBitmapImageDecoderResourceDecoder();
            byteBufferBitmapDecoder = new ByteBufferBitmapImageDecoderResourceDecoder();
        }
        ResourceDrawableDecoder resourceDrawableDecoder = new ResourceDrawableDecoder(context);
        ResourceLoader.StreamFactory streamFactory = new ResourceLoader.StreamFactory(resources);
        ResourceLoader.UriFactory uriFactory = new ResourceLoader.UriFactory(resources);
        ResourceLoader.FileDescriptorFactory fileDescriptorFactory = new ResourceLoader.FileDescriptorFactory(resources);
        ResourceLoader.AssetFileDescriptorFactory assetFileDescriptorFactory = new ResourceLoader.AssetFileDescriptorFactory(resources);
        BitmapEncoder bitmapEncoder = new BitmapEncoder(arrayPool);
        BitmapBytesTranscoder bitmapBytesTranscoder = new BitmapBytesTranscoder();
        GifDrawableBytesTranscoder gifDrawableBytesTranscoder = new GifDrawableBytesTranscoder();
        ContentResolver contentResolver = context.getContentResolver();
        registry2.append(ByteBuffer.class, new ByteBufferEncoder()).append(InputStream.class, new StreamEncoder(arrayPool)).append(Registry.BUCKET_BITMAP, ByteBuffer.class, Bitmap.class, byteBufferBitmapDecoder).append(Registry.BUCKET_BITMAP, InputStream.class, Bitmap.class, streamBitmapDecoder);
        if (ParcelFileDescriptorRewinder.isSupported()) {
            registry2.append(Registry.BUCKET_BITMAP, ParcelFileDescriptor.class, Bitmap.class, new ParcelFileDescriptorBitmapDecoder(downsampler));
        }
        registry2.append(Registry.BUCKET_BITMAP, ParcelFileDescriptor.class, Bitmap.class, parcel).append(Registry.BUCKET_BITMAP, AssetFileDescriptor.class, Bitmap.class, VideoDecoder.asset(bitmapPool)).append(Bitmap.class, Bitmap.class, UnitModelLoader.Factory.getInstance()).append(Registry.BUCKET_BITMAP, Bitmap.class, Bitmap.class, new UnitBitmapDecoder()).append(Bitmap.class, (ResourceEncoder) bitmapEncoder).append(Registry.BUCKET_BITMAP_DRAWABLE, ByteBuffer.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, byteBufferBitmapDecoder)).append(Registry.BUCKET_BITMAP_DRAWABLE, InputStream.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, streamBitmapDecoder)).append(Registry.BUCKET_BITMAP_DRAWABLE, ParcelFileDescriptor.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, parcel)).append(BitmapDrawable.class, (ResourceEncoder) new BitmapDrawableEncoder(bitmapPool, bitmapEncoder)).append(Registry.BUCKET_GIF, InputStream.class, GifDrawable.class, new StreamGifDecoder(imageHeaderParsers, byteBufferGifDecoder, arrayPool)).append(Registry.BUCKET_GIF, ByteBuffer.class, GifDrawable.class, byteBufferGifDecoder).append(GifDrawable.class, (ResourceEncoder) new GifDrawableEncoder()).append(GifDecoder.class, GifDecoder.class, UnitModelLoader.Factory.getInstance()).append(Registry.BUCKET_BITMAP, GifDecoder.class, Bitmap.class, new GifFrameResourceDecoder(bitmapPool)).append(Uri.class, Drawable.class, resourceDrawableDecoder).append(Uri.class, Bitmap.class, new ResourceBitmapDecoder(resourceDrawableDecoder, bitmapPool)).register(new ByteBufferRewinder.Factory()).append(File.class, ByteBuffer.class, new ByteBufferFileLoader.Factory()).append(File.class, InputStream.class, new FileLoader.StreamFactory()).append(File.class, File.class, new FileDecoder()).append(File.class, ParcelFileDescriptor.class, new FileLoader.FileDescriptorFactory()).append(File.class, File.class, UnitModelLoader.Factory.getInstance()).register(new InputStreamRewinder.Factory(arrayPool));
        if (ParcelFileDescriptorRewinder.isSupported()) {
            registry = registry2;
            registry.register(new ParcelFileDescriptorRewinder.Factory());
        } else {
            registry = registry2;
        }
        Class cls = Integer.TYPE;
        registry.append(cls, InputStream.class, streamFactory).append(cls, ParcelFileDescriptor.class, fileDescriptorFactory).append(Integer.class, InputStream.class, streamFactory).append(Integer.class, ParcelFileDescriptor.class, fileDescriptorFactory).append(Integer.class, Uri.class, uriFactory).append(cls, AssetFileDescriptor.class, assetFileDescriptorFactory).append(Integer.class, AssetFileDescriptor.class, assetFileDescriptorFactory).append(cls, Uri.class, uriFactory).append(String.class, InputStream.class, new DataUrlLoader.StreamFactory()).append(Uri.class, InputStream.class, new DataUrlLoader.StreamFactory()).append(String.class, InputStream.class, new StringLoader.StreamFactory()).append(String.class, ParcelFileDescriptor.class, new StringLoader.FileDescriptorFactory()).append(String.class, AssetFileDescriptor.class, new StringLoader.AssetFileDescriptorFactory()).append(Uri.class, InputStream.class, new HttpUriLoader.Factory()).append(Uri.class, InputStream.class, new AssetUriLoader.StreamFactory(context.getAssets())).append(Uri.class, ParcelFileDescriptor.class, new AssetUriLoader.FileDescriptorFactory(context.getAssets())).append(Uri.class, InputStream.class, new MediaStoreImageThumbLoader.Factory(context)).append(Uri.class, InputStream.class, new MediaStoreVideoThumbLoader.Factory(context));
        if (i11 >= 29) {
            registry.append(Uri.class, InputStream.class, new QMediaStoreUriLoader.InputStreamFactory(context));
            registry.append(Uri.class, ParcelFileDescriptor.class, new QMediaStoreUriLoader.FileDescriptorFactory(context));
        }
        registry.append(Uri.class, InputStream.class, new UriLoader.StreamFactory(contentResolver)).append(Uri.class, ParcelFileDescriptor.class, new UriLoader.FileDescriptorFactory(contentResolver)).append(Uri.class, AssetFileDescriptor.class, new UriLoader.AssetFileDescriptorFactory(contentResolver)).append(Uri.class, InputStream.class, new UrlUriLoader.StreamFactory()).append(URL.class, InputStream.class, new UrlLoader.StreamFactory()).append(Uri.class, File.class, new MediaStoreFileLoader.Factory(context)).append(GlideUrl.class, InputStream.class, new HttpGlideUrlLoader.Factory()).append(byte[].class, ByteBuffer.class, new ByteArrayLoader.ByteBufferFactory()).append(byte[].class, InputStream.class, new ByteArrayLoader.StreamFactory()).append(Uri.class, Uri.class, UnitModelLoader.Factory.getInstance()).append(Drawable.class, Drawable.class, UnitModelLoader.Factory.getInstance()).append(Drawable.class, Drawable.class, new UnitDrawableDecoder()).register(Bitmap.class, BitmapDrawable.class, new BitmapDrawableTranscoder(resources)).register(Bitmap.class, byte[].class, bitmapBytesTranscoder).register(Drawable.class, byte[].class, new DrawableBytesTranscoder(bitmapPool, bitmapBytesTranscoder, gifDrawableBytesTranscoder)).register(GifDrawable.class, byte[].class, gifDrawableBytesTranscoder);
        if (i11 >= 23) {
            ResourceDecoder<ByteBuffer, Bitmap> byteBuffer = VideoDecoder.byteBuffer(bitmapPool);
            registry.append(ByteBuffer.class, Bitmap.class, byteBuffer);
            registry.append(ByteBuffer.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, byteBuffer));
        }
        this.glideContext = new GlideContext(context, arrayPool, registry, new ImageViewTargetFactory(), requestOptionsFactory, map, list, engine, z10, i10);
    }

    @GuardedBy("Glide.class")
    private static void checkAndInitializeGlide(@NonNull Context context, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        if (isInitializing) {
            throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
        }
        isInitializing = true;
        initializeGlide(context, generatedAppGlideModule);
        isInitializing = false;
    }

    @NonNull
    public static Glide get(@NonNull Context context) {
        if (glide == null) {
            GeneratedAppGlideModule annotationGeneratedGlideModules = getAnnotationGeneratedGlideModules(context.getApplicationContext());
            synchronized (Glide.class) {
                try {
                    if (glide == null) {
                        checkAndInitializeGlide(context, annotationGeneratedGlideModules);
                    }
                } finally {
                }
            }
        }
        return glide;
    }

    @Nullable
    private static GeneratedAppGlideModule getAnnotationGeneratedGlideModules(Context context) {
        try {
            return (GeneratedAppGlideModule) GeneratedAppGlideModuleImpl.class.getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext());
        } catch (ClassNotFoundException unused) {
            if (Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
            return null;
        } catch (IllegalAccessException e10) {
            throwIncorrectGlideModule(e10);
            return null;
        } catch (InstantiationException e11) {
            throwIncorrectGlideModule(e11);
            return null;
        } catch (NoSuchMethodException e12) {
            throwIncorrectGlideModule(e12);
            return null;
        } catch (InvocationTargetException e13) {
            throwIncorrectGlideModule(e13);
            return null;
        }
    }

    @Nullable
    public static File getPhotoCacheDir(@NonNull Context context) {
        return getPhotoCacheDir(context, "image_manager_disk_cache");
    }

    @NonNull
    private static RequestManagerRetriever getRetriever(@Nullable Context context) {
        Preconditions.checkNotNull(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return get(context).getRequestManagerRetriever();
    }

    @VisibleForTesting
    @Deprecated
    public static synchronized void init(Glide glide2) {
        synchronized (Glide.class) {
            try {
                if (glide != null) {
                    tearDown();
                }
                glide = glide2;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @GuardedBy("Glide.class")
    private static void initializeGlide(@NonNull Context context, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        initializeGlide(context, new GlideBuilder(), generatedAppGlideModule);
    }

    @VisibleForTesting
    public static synchronized void tearDown() {
        synchronized (Glide.class) {
            try {
                if (glide != null) {
                    glide.getContext().getApplicationContext().unregisterComponentCallbacks(glide);
                    glide.engine.shutdown();
                }
                glide = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static void throwIncorrectGlideModule(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    @NonNull
    public static RequestManager with(@NonNull Context context) {
        return getRetriever(context).get(context);
    }

    public void clearDiskCache() {
        Util.assertBackgroundThread();
        this.engine.clearDiskCache();
    }

    public void clearMemory() {
        Util.assertMainThread();
        this.memoryCache.clearMemory();
        this.bitmapPool.clearMemory();
        this.arrayPool.clearMemory();
    }

    @NonNull
    public ArrayPool getArrayPool() {
        return this.arrayPool;
    }

    @NonNull
    public BitmapPool getBitmapPool() {
        return this.bitmapPool;
    }

    public ConnectivityMonitorFactory getConnectivityMonitorFactory() {
        return this.connectivityMonitorFactory;
    }

    @NonNull
    public Context getContext() {
        return this.glideContext.getBaseContext();
    }

    @NonNull
    public GlideContext getGlideContext() {
        return this.glideContext;
    }

    @NonNull
    public Registry getRegistry() {
        return this.registry;
    }

    @NonNull
    public RequestManagerRetriever getRequestManagerRetriever() {
        return this.requestManagerRetriever;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        clearMemory();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        trimMemory(i10);
    }

    public synchronized void preFillBitmapPool(@NonNull PreFillType.Builder... builderArr) {
        try {
            if (this.bitmapPreFiller == null) {
                this.bitmapPreFiller = new BitmapPreFiller(this.memoryCache, this.bitmapPool, (DecodeFormat) this.defaultRequestOptionsFactory.build().getOptions().get(Downsampler.DECODE_FORMAT));
            }
            this.bitmapPreFiller.preFill(builderArr);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void registerRequestManager(RequestManager requestManager) {
        synchronized (this.managers) {
            try {
                if (this.managers.contains(requestManager)) {
                    throw new IllegalStateException("Cannot register already registered manager");
                }
                this.managers.add(requestManager);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean removeFromManagers(@NonNull Target<?> target) {
        synchronized (this.managers) {
            try {
                Iterator<RequestManager> it = this.managers.iterator();
                while (it.hasNext()) {
                    if (it.next().untrack(target)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @NonNull
    public MemoryCategory setMemoryCategory(@NonNull MemoryCategory memoryCategory) {
        Util.assertMainThread();
        this.memoryCache.setSizeMultiplier(memoryCategory.getMultiplier());
        this.bitmapPool.setSizeMultiplier(memoryCategory.getMultiplier());
        MemoryCategory memoryCategory2 = this.memoryCategory;
        this.memoryCategory = memoryCategory;
        return memoryCategory2;
    }

    public void trimMemory(int i10) {
        Util.assertMainThread();
        Iterator<RequestManager> it = this.managers.iterator();
        while (it.hasNext()) {
            it.next().onTrimMemory(i10);
        }
        this.memoryCache.trimMemory(i10);
        this.bitmapPool.trimMemory(i10);
        this.arrayPool.trimMemory(i10);
    }

    public void unregisterRequestManager(RequestManager requestManager) {
        synchronized (this.managers) {
            try {
                if (!this.managers.contains(requestManager)) {
                    throw new IllegalStateException("Cannot unregister not yet registered manager");
                }
                this.managers.remove(requestManager);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Nullable
    public static File getPhotoCacheDir(@NonNull Context context, @NonNull String str) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            if (Log.isLoggable(TAG, 6)) {
                Log.e(TAG, "default disk cache dir is null");
            }
            return null;
        }
        File file = new File(cacheDir, str);
        if (file.mkdirs() || (file.exists() && file.isDirectory())) {
            return file;
        }
        return null;
    }

    @GuardedBy("Glide.class")
    private static void initializeGlide(@NonNull Context context, @NonNull GlideBuilder glideBuilder, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        Context applicationContext = context.getApplicationContext();
        List<GlideModule> emptyList = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.isManifestParsingEnabled()) {
            emptyList = new ManifestParser(applicationContext).parse();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.getExcludedModuleClasses().isEmpty()) {
            Set<Class<?>> excludedModuleClasses = generatedAppGlideModule.getExcludedModuleClasses();
            Iterator<GlideModule> it = emptyList.iterator();
            while (it.hasNext()) {
                GlideModule next = it.next();
                if (excludedModuleClasses.contains(next.getClass())) {
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "AppGlideModule excludes manifest GlideModule: " + next);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable(TAG, 3)) {
            Iterator<GlideModule> it2 = emptyList.iterator();
            while (it2.hasNext()) {
                Log.d(TAG, "Discovered GlideModule from manifest: " + it2.next().getClass());
            }
        }
        glideBuilder.setRequestManagerFactory(generatedAppGlideModule != null ? generatedAppGlideModule.getRequestManagerFactory() : null);
        Iterator<GlideModule> it3 = emptyList.iterator();
        while (it3.hasNext()) {
            it3.next().applyOptions(applicationContext, glideBuilder);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.applyOptions(applicationContext, glideBuilder);
        }
        Glide build = glideBuilder.build(applicationContext);
        for (GlideModule glideModule : emptyList) {
            try {
                glideModule.registerComponents(applicationContext, build, build.registry);
            } catch (AbstractMethodError e10) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + glideModule.getClass().getName(), e10);
            }
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.registerComponents(applicationContext, build, build.registry);
        }
        applicationContext.registerComponentCallbacks(build);
        glide = build;
    }

    @NonNull
    public static RequestManager with(@NonNull Activity activity) {
        return getRetriever(activity).get(activity);
    }

    @NonNull
    public static RequestManager with(@NonNull FragmentActivity fragmentActivity) {
        return getRetriever(fragmentActivity).get(fragmentActivity);
    }

    @NonNull
    public static RequestManager with(@NonNull Fragment fragment) {
        return getRetriever(fragment.getContext()).get(fragment);
    }

    @VisibleForTesting
    public static void init(@NonNull Context context, @NonNull GlideBuilder glideBuilder) {
        GeneratedAppGlideModule annotationGeneratedGlideModules = getAnnotationGeneratedGlideModules(context);
        synchronized (Glide.class) {
            try {
                if (glide != null) {
                    tearDown();
                }
                initializeGlide(context, glideBuilder, annotationGeneratedGlideModules);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @NonNull
    @Deprecated
    public static RequestManager with(@NonNull android.app.Fragment fragment) {
        return getRetriever(fragment.getActivity()).get(fragment);
    }

    @NonNull
    public static RequestManager with(@NonNull View view) {
        return getRetriever(view.getContext()).get(view);
    }
}
