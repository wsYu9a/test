package androidx.emoji2.text;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import androidx.core.os.TraceCompat;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.EmojiCompatInitializer;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
public class EmojiCompatInitializer implements Initializer<Boolean> {
    private static final long STARTUP_THREAD_CREATION_DELAY_MS = 500;
    private static final String S_INITIALIZER_THREAD_NAME = "EmojiCompatInitializer";

    /* renamed from: androidx.emoji2.text.EmojiCompatInitializer$1 */
    public class AnonymousClass1 implements DefaultLifecycleObserver {
        final /* synthetic */ Lifecycle val$lifecycle;

        public AnonymousClass1(Lifecycle lifecycle) {
            lifecycle = lifecycle;
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
        public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
            k0.a.a(this, lifecycleOwner);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
        public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
            k0.a.b(this, lifecycleOwner);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
        public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
            k0.a.c(this, lifecycleOwner);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
        public void onResume(@NonNull LifecycleOwner lifecycleOwner) {
            EmojiCompatInitializer.this.loadEmojiCompatAfterDelay();
            lifecycle.removeObserver(this);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
        public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
            k0.a.e(this, lifecycleOwner);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
        public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
            k0.a.f(this, lifecycleOwner);
        }
    }

    @RequiresApi(19)
    public static class BackgroundDefaultConfig extends EmojiCompat.Config {
        public BackgroundDefaultConfig(Context context) {
            super(new BackgroundDefaultLoader(context));
            setMetadataLoadStrategy(1);
        }
    }

    @RequiresApi(19)
    public static class BackgroundDefaultLoader implements EmojiCompat.MetadataRepoLoader {
        private final Context mContext;

        /* renamed from: androidx.emoji2.text.EmojiCompatInitializer$BackgroundDefaultLoader$1 */
        public class AnonymousClass1 extends EmojiCompat.MetadataRepoLoaderCallback {
            final /* synthetic */ ThreadPoolExecutor val$executor;
            final /* synthetic */ EmojiCompat.MetadataRepoLoaderCallback val$loaderCallback;

            public AnonymousClass1(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback, ThreadPoolExecutor threadPoolExecutor) {
                metadataRepoLoaderCallback = metadataRepoLoaderCallback;
                threadPoolExecutor = threadPoolExecutor;
            }

            @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
            public void onFailed(@Nullable Throwable th2) {
                try {
                    metadataRepoLoaderCallback.onFailed(th2);
                } finally {
                    threadPoolExecutor.shutdown();
                }
            }

            @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
            public void onLoaded(@NonNull MetadataRepo metadataRepo) {
                try {
                    metadataRepoLoaderCallback.onLoaded(metadataRepo);
                } finally {
                    threadPoolExecutor.shutdown();
                }
            }
        }

        public BackgroundDefaultLoader(Context context) {
            this.mContext = context.getApplicationContext();
        }

        @WorkerThread
        /* renamed from: doLoad */
        public void lambda$load$0(@NonNull EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback, @NonNull ThreadPoolExecutor threadPoolExecutor) {
            try {
                FontRequestEmojiCompatConfig create = DefaultEmojiCompatConfig.create(this.mContext);
                if (create == null) {
                    throw new RuntimeException("EmojiCompat font provider not available on this device.");
                }
                create.setLoadingExecutor(threadPoolExecutor);
                create.getMetadataRepoLoader().load(new EmojiCompat.MetadataRepoLoaderCallback() { // from class: androidx.emoji2.text.EmojiCompatInitializer.BackgroundDefaultLoader.1
                    final /* synthetic */ ThreadPoolExecutor val$executor;
                    final /* synthetic */ EmojiCompat.MetadataRepoLoaderCallback val$loaderCallback;

                    public AnonymousClass1(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback2, ThreadPoolExecutor threadPoolExecutor2) {
                        metadataRepoLoaderCallback = metadataRepoLoaderCallback2;
                        threadPoolExecutor = threadPoolExecutor2;
                    }

                    @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
                    public void onFailed(@Nullable Throwable th2) {
                        try {
                            metadataRepoLoaderCallback.onFailed(th2);
                        } finally {
                            threadPoolExecutor.shutdown();
                        }
                    }

                    @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
                    public void onLoaded(@NonNull MetadataRepo metadataRepo) {
                        try {
                            metadataRepoLoaderCallback.onLoaded(metadataRepo);
                        } finally {
                            threadPoolExecutor.shutdown();
                        }
                    }
                });
            } catch (Throwable th2) {
                metadataRepoLoaderCallback2.onFailed(th2);
                threadPoolExecutor2.shutdown();
            }
        }

        @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
        public void load(@NonNull EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            ThreadPoolExecutor createBackgroundPriorityExecutor = ConcurrencyHelpers.createBackgroundPriorityExecutor(EmojiCompatInitializer.S_INITIALIZER_THREAD_NAME);
            createBackgroundPriorityExecutor.execute(new Runnable() { // from class: androidx.emoji2.text.b

                /* renamed from: c */
                public final /* synthetic */ EmojiCompat.MetadataRepoLoaderCallback f358c;

                /* renamed from: d */
                public final /* synthetic */ ThreadPoolExecutor f359d;

                public /* synthetic */ b(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback2, ThreadPoolExecutor createBackgroundPriorityExecutor2) {
                    metadataRepoLoaderCallback = metadataRepoLoaderCallback2;
                    createBackgroundPriorityExecutor = createBackgroundPriorityExecutor2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    EmojiCompatInitializer.BackgroundDefaultLoader.this.lambda$load$0(metadataRepoLoaderCallback, createBackgroundPriorityExecutor);
                }
            });
        }
    }

    public static class LoadEmojiCompatRunnable implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                TraceCompat.beginSection("EmojiCompat.EmojiCompatInitializer.run");
                if (EmojiCompat.isConfigured()) {
                    EmojiCompat.get().load();
                }
            } finally {
                TraceCompat.endSection();
            }
        }
    }

    @RequiresApi(19)
    public void delayUntilFirstResume(@NonNull Context context) {
        Lifecycle lifecycle = ((LifecycleOwner) AppInitializer.getInstance(context).initializeComponent(ProcessLifecycleInitializer.class)).getLifecycle();
        lifecycle.addObserver(new DefaultLifecycleObserver() { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            final /* synthetic */ Lifecycle val$lifecycle;

            public AnonymousClass1(Lifecycle lifecycle2) {
                lifecycle = lifecycle2;
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
            public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
                k0.a.a(this, lifecycleOwner);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
            public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
                k0.a.b(this, lifecycleOwner);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
            public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
                k0.a.c(this, lifecycleOwner);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
            public void onResume(@NonNull LifecycleOwner lifecycleOwner) {
                EmojiCompatInitializer.this.loadEmojiCompatAfterDelay();
                lifecycle.removeObserver(this);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
            public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
                k0.a.e(this, lifecycleOwner);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
            public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
                k0.a.f(this, lifecycleOwner);
            }
        });
    }

    @Override // androidx.startup.Initializer
    @NonNull
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @RequiresApi(19)
    public void loadEmojiCompatAfterDelay() {
        ConcurrencyHelpers.mainHandlerAsync().postDelayed(new LoadEmojiCompatRunnable(), 500L);
    }

    @Override // androidx.startup.Initializer
    @NonNull
    public Boolean create(@NonNull Context context) {
        EmojiCompat.init(new BackgroundDefaultConfig(context));
        delayUntilFirstResume(context);
        return Boolean.TRUE;
    }
}
