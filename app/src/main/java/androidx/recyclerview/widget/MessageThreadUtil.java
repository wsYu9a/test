package androidx.recyclerview.widget;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
class MessageThreadUtil<T> implements ThreadUtil<T> {

    /* renamed from: androidx.recyclerview.widget.MessageThreadUtil$1 */
    class AnonymousClass1 implements ThreadUtil.MainThreadCallback<T> {

        /* renamed from: a */
        static final int f3365a = 1;

        /* renamed from: b */
        static final int f3366b = 2;

        /* renamed from: c */
        static final int f3367c = 3;

        /* renamed from: d */
        final MessageQueue f3368d = new MessageQueue();

        /* renamed from: e */
        private final Handler f3369e = new Handler(Looper.getMainLooper());

        /* renamed from: f */
        private Runnable f3370f = new Runnable() { // from class: androidx.recyclerview.widget.MessageThreadUtil.1.1
            RunnableC00121() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SyncQueueItem a2 = AnonymousClass1.this.f3368d.a();
                while (a2 != null) {
                    int i2 = a2.what;
                    if (i2 == 1) {
                        AnonymousClass1.this.f3371g.updateItemCount(a2.arg1, a2.arg2);
                    } else if (i2 == 2) {
                        AnonymousClass1.this.f3371g.addTile(a2.arg1, (TileList.Tile) a2.data);
                    } else if (i2 != 3) {
                        Log.e("ThreadUtil", "Unsupported message, what=" + a2.what);
                    } else {
                        AnonymousClass1.this.f3371g.removeTile(a2.arg1, a2.arg2);
                    }
                    a2 = AnonymousClass1.this.f3368d.a();
                }
            }
        };

        /* renamed from: g */
        final /* synthetic */ ThreadUtil.MainThreadCallback f3371g;

        /* renamed from: androidx.recyclerview.widget.MessageThreadUtil$1$1 */
        class RunnableC00121 implements Runnable {
            RunnableC00121() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SyncQueueItem a2 = AnonymousClass1.this.f3368d.a();
                while (a2 != null) {
                    int i2 = a2.what;
                    if (i2 == 1) {
                        AnonymousClass1.this.f3371g.updateItemCount(a2.arg1, a2.arg2);
                    } else if (i2 == 2) {
                        AnonymousClass1.this.f3371g.addTile(a2.arg1, (TileList.Tile) a2.data);
                    } else if (i2 != 3) {
                        Log.e("ThreadUtil", "Unsupported message, what=" + a2.what);
                    } else {
                        AnonymousClass1.this.f3371g.removeTile(a2.arg1, a2.arg2);
                    }
                    a2 = AnonymousClass1.this.f3368d.a();
                }
            }
        }

        AnonymousClass1(ThreadUtil.MainThreadCallback mainThreadCallback) {
            this.f3371g = mainThreadCallback;
        }

        private void a(SyncQueueItem syncQueueItem) {
            this.f3368d.c(syncQueueItem);
            this.f3369e.post(this.f3370f);
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void addTile(int i2, TileList.Tile<T> tile) {
            a(SyncQueueItem.c(2, i2, tile));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void removeTile(int i2, int i3) {
            a(SyncQueueItem.a(3, i2, i3));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void updateItemCount(int i2, int i3) {
            a(SyncQueueItem.a(1, i2, i3));
        }
    }

    /* renamed from: androidx.recyclerview.widget.MessageThreadUtil$2 */
    class AnonymousClass2 implements ThreadUtil.BackgroundCallback<T> {

        /* renamed from: a */
        static final int f3374a = 1;

        /* renamed from: b */
        static final int f3375b = 2;

        /* renamed from: c */
        static final int f3376c = 3;

        /* renamed from: d */
        static final int f3377d = 4;

        /* renamed from: e */
        final MessageQueue f3378e = new MessageQueue();

        /* renamed from: f */
        private final Executor f3379f = AsyncTask.THREAD_POOL_EXECUTOR;

        /* renamed from: g */
        AtomicBoolean f3380g = new AtomicBoolean(false);

        /* renamed from: h */
        private Runnable f3381h = new Runnable() { // from class: androidx.recyclerview.widget.MessageThreadUtil.2.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    SyncQueueItem a2 = AnonymousClass2.this.f3378e.a();
                    if (a2 == null) {
                        AnonymousClass2.this.f3380g.set(false);
                        return;
                    }
                    int i2 = a2.what;
                    if (i2 == 1) {
                        AnonymousClass2.this.f3378e.b(1);
                        AnonymousClass2.this.f3382i.refresh(a2.arg1);
                    } else if (i2 == 2) {
                        AnonymousClass2.this.f3378e.b(2);
                        AnonymousClass2.this.f3378e.b(3);
                        AnonymousClass2.this.f3382i.updateRange(a2.arg1, a2.arg2, a2.arg3, a2.arg4, a2.arg5);
                    } else if (i2 == 3) {
                        AnonymousClass2.this.f3382i.loadTile(a2.arg1, a2.arg2);
                    } else if (i2 != 4) {
                        Log.e("ThreadUtil", "Unsupported message, what=" + a2.what);
                    } else {
                        AnonymousClass2.this.f3382i.recycleTile((TileList.Tile) a2.data);
                    }
                }
            }
        };

        /* renamed from: i */
        final /* synthetic */ ThreadUtil.BackgroundCallback f3382i;

        /* renamed from: androidx.recyclerview.widget.MessageThreadUtil$2$1 */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    SyncQueueItem a2 = AnonymousClass2.this.f3378e.a();
                    if (a2 == null) {
                        AnonymousClass2.this.f3380g.set(false);
                        return;
                    }
                    int i2 = a2.what;
                    if (i2 == 1) {
                        AnonymousClass2.this.f3378e.b(1);
                        AnonymousClass2.this.f3382i.refresh(a2.arg1);
                    } else if (i2 == 2) {
                        AnonymousClass2.this.f3378e.b(2);
                        AnonymousClass2.this.f3378e.b(3);
                        AnonymousClass2.this.f3382i.updateRange(a2.arg1, a2.arg2, a2.arg3, a2.arg4, a2.arg5);
                    } else if (i2 == 3) {
                        AnonymousClass2.this.f3382i.loadTile(a2.arg1, a2.arg2);
                    } else if (i2 != 4) {
                        Log.e("ThreadUtil", "Unsupported message, what=" + a2.what);
                    } else {
                        AnonymousClass2.this.f3382i.recycleTile((TileList.Tile) a2.data);
                    }
                }
            }
        }

        AnonymousClass2(ThreadUtil.BackgroundCallback backgroundCallback) {
            this.f3382i = backgroundCallback;
        }

        private void a() {
            if (this.f3380g.compareAndSet(false, true)) {
                this.f3379f.execute(this.f3381h);
            }
        }

        private void b(SyncQueueItem syncQueueItem) {
            this.f3378e.c(syncQueueItem);
            a();
        }

        private void c(SyncQueueItem syncQueueItem) {
            this.f3378e.d(syncQueueItem);
            a();
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void loadTile(int i2, int i3) {
            b(SyncQueueItem.a(3, i2, i3));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void recycleTile(TileList.Tile<T> tile) {
            b(SyncQueueItem.c(4, 0, tile));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void refresh(int i2) {
            c(SyncQueueItem.c(1, i2, null));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void updateRange(int i2, int i3, int i4, int i5, int i6) {
            c(SyncQueueItem.b(2, i2, i3, i4, i5, i6, null));
        }
    }

    static class MessageQueue {

        /* renamed from: a */
        private SyncQueueItem f3385a;

        MessageQueue() {
        }

        synchronized SyncQueueItem a() {
            SyncQueueItem syncQueueItem = this.f3385a;
            if (syncQueueItem == null) {
                return null;
            }
            this.f3385a = syncQueueItem.f3388c;
            return syncQueueItem;
        }

        synchronized void b(int i2) {
            SyncQueueItem syncQueueItem;
            while (true) {
                syncQueueItem = this.f3385a;
                if (syncQueueItem == null || syncQueueItem.what != i2) {
                    break;
                }
                this.f3385a = syncQueueItem.f3388c;
                syncQueueItem.d();
            }
            if (syncQueueItem != null) {
                SyncQueueItem syncQueueItem2 = syncQueueItem.f3388c;
                while (syncQueueItem2 != null) {
                    SyncQueueItem syncQueueItem3 = syncQueueItem2.f3388c;
                    if (syncQueueItem2.what == i2) {
                        syncQueueItem.f3388c = syncQueueItem3;
                        syncQueueItem2.d();
                    } else {
                        syncQueueItem = syncQueueItem2;
                    }
                    syncQueueItem2 = syncQueueItem3;
                }
            }
        }

        synchronized void c(SyncQueueItem syncQueueItem) {
            SyncQueueItem syncQueueItem2 = this.f3385a;
            if (syncQueueItem2 == null) {
                this.f3385a = syncQueueItem;
                return;
            }
            while (true) {
                SyncQueueItem syncQueueItem3 = syncQueueItem2.f3388c;
                if (syncQueueItem3 == null) {
                    syncQueueItem2.f3388c = syncQueueItem;
                    return;
                }
                syncQueueItem2 = syncQueueItem3;
            }
        }

        synchronized void d(SyncQueueItem syncQueueItem) {
            syncQueueItem.f3388c = this.f3385a;
            this.f3385a = syncQueueItem;
        }
    }

    static class SyncQueueItem {

        /* renamed from: a */
        private static SyncQueueItem f3386a;

        /* renamed from: b */
        private static final Object f3387b = new Object();
        public int arg1;
        public int arg2;
        public int arg3;
        public int arg4;
        public int arg5;

        /* renamed from: c */
        SyncQueueItem f3388c;
        public Object data;
        public int what;

        SyncQueueItem() {
        }

        static SyncQueueItem a(int i2, int i3, int i4) {
            return b(i2, i3, i4, 0, 0, 0, null);
        }

        static SyncQueueItem b(int i2, int i3, int i4, int i5, int i6, int i7, Object obj) {
            SyncQueueItem syncQueueItem;
            synchronized (f3387b) {
                syncQueueItem = f3386a;
                if (syncQueueItem == null) {
                    syncQueueItem = new SyncQueueItem();
                } else {
                    f3386a = syncQueueItem.f3388c;
                    syncQueueItem.f3388c = null;
                }
                syncQueueItem.what = i2;
                syncQueueItem.arg1 = i3;
                syncQueueItem.arg2 = i4;
                syncQueueItem.arg3 = i5;
                syncQueueItem.arg4 = i6;
                syncQueueItem.arg5 = i7;
                syncQueueItem.data = obj;
            }
            return syncQueueItem;
        }

        static SyncQueueItem c(int i2, int i3, Object obj) {
            return b(i2, i3, 0, 0, 0, 0, obj);
        }

        void d() {
            this.f3388c = null;
            this.arg5 = 0;
            this.arg4 = 0;
            this.arg3 = 0;
            this.arg2 = 0;
            this.arg1 = 0;
            this.what = 0;
            this.data = null;
            synchronized (f3387b) {
                SyncQueueItem syncQueueItem = f3386a;
                if (syncQueueItem != null) {
                    this.f3388c = syncQueueItem;
                }
                f3386a = this;
            }
        }
    }

    MessageThreadUtil() {
    }

    @Override // androidx.recyclerview.widget.ThreadUtil
    public ThreadUtil.BackgroundCallback<T> getBackgroundProxy(ThreadUtil.BackgroundCallback<T> backgroundCallback) {
        return new AnonymousClass2(backgroundCallback);
    }

    @Override // androidx.recyclerview.widget.ThreadUtil
    public ThreadUtil.MainThreadCallback<T> getMainThreadProxy(ThreadUtil.MainThreadCallback<T> mainThreadCallback) {
        return new AnonymousClass1(mainThreadCallback);
    }
}
