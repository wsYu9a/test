package com.vivo.advv.vaf.virtualview;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.vivo.advv.TextUtils;
import com.vivo.advv.Utils;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.virtualview.Helper.VVFeatureConfig;
import com.vivo.advv.vaf.virtualview.container.Container;
import com.vivo.advv.vaf.virtualview.core.IContainer;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.core.ViewCache;
import com.vivo.advv.vaf.virtualview.layout.FlexLayout;
import com.vivo.advv.vaf.virtualview.layout.FrameLayout;
import com.vivo.advv.vaf.virtualview.layout.GridLayout;
import com.vivo.advv.vaf.virtualview.layout.RatioLayout;
import com.vivo.advv.vaf.virtualview.layout.VH2Layout;
import com.vivo.advv.vaf.virtualview.layout.VHLayout;
import com.vivo.advv.vaf.virtualview.loader.BinaryLoader;
import com.vivo.advv.vaf.virtualview.loader.CodeReader;
import com.vivo.advv.vaf.virtualview.loader.ExprCodeLoader;
import com.vivo.advv.vaf.virtualview.loader.UiCodeLoader;
import com.vivo.advv.vaf.virtualview.util.VVLog;
import com.vivo.advv.vaf.virtualview.view.VirtualContainer;
import com.vivo.advv.vaf.virtualview.view.VirtualGraph;
import com.vivo.advv.vaf.virtualview.view.VirtualTime;
import com.vivo.advv.vaf.virtualview.view.grid.Grid;
import com.vivo.advv.vaf.virtualview.view.image.NativeImage;
import com.vivo.advv.vaf.virtualview.view.image.VirtualImage;
import com.vivo.advv.vaf.virtualview.view.line.NativeLine;
import com.vivo.advv.vaf.virtualview.view.line.VirtualLine;
import com.vivo.advv.vaf.virtualview.view.nlayout.NFrameLayout;
import com.vivo.advv.vaf.virtualview.view.nlayout.NGridLayout;
import com.vivo.advv.vaf.virtualview.view.nlayout.NRatioLayout;
import com.vivo.advv.vaf.virtualview.view.nlayout.NVH2Layout;
import com.vivo.advv.vaf.virtualview.view.nlayout.NVHLayout;
import com.vivo.advv.vaf.virtualview.view.page.Page;
import com.vivo.advv.vaf.virtualview.view.progress.VirtualProgress;
import com.vivo.advv.vaf.virtualview.view.scroller.Scroller;
import com.vivo.advv.vaf.virtualview.view.slider.Slider;
import com.vivo.advv.vaf.virtualview.view.slider.SliderCompact;
import com.vivo.advv.vaf.virtualview.view.text.NativeText;
import com.vivo.advv.vaf.virtualview.view.text.VirtualText;
import com.vivo.advv.vaf.virtualview.view.vh.VH;
import java.lang.ref.WeakReference;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes4.dex */
public class ViewFactory {
    private static final int STATE_continue = 0;
    private static final int STATE_failed = 2;
    private static final int STATE_successful = 1;
    private static final String TAG = "ViewFac_TMTEST";
    private static TmplWorker mTmplWorker;
    private VafContext mAppContext;
    private SparseArray<ViewBase.IBuilder> mBuilders;
    private int mScreenWidth;
    private static UiCodeLoader mUiCodeLoader = new UiCodeLoader();
    private static ExprCodeLoader mExprCodeLoader = new ExprCodeLoader();
    private static BinaryLoader mLoader = new BinaryLoader();
    private static final Object LOCK = new Object();
    private Stack<ViewBase> mComArr = new Stack<>();
    private int mUedScreen = DownloadErrorCode.ERROR_TTNET_NOT_MODIFIED;

    private static class TmplTask {
        private final byte[] buffer;
        private final boolean override;
        private final String type;

        /* synthetic */ TmplTask(String str, byte[] bArr, boolean z, AnonymousClass1 anonymousClass1) {
            this(str, bArr, z);
        }

        private TmplTask(String str, byte[] bArr, boolean z) {
            this.type = str;
            this.buffer = bArr;
            this.override = z;
        }
    }

    private static class TmplWorker extends Thread {
        private int count;
        private volatile boolean isRunning;
        private final LinkedBlockingQueue<TmplTask> mLoadingPool;
        private WeakReference<ViewFactory> mViewFactory;

        /* synthetic */ TmplWorker(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
        
            r2 = r5.mViewFactory.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
        
            if (r2 == null) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
        
            com.vivo.advv.vaf.virtualview.util.VVLog.d(com.vivo.advv.vaf.virtualview.ViewFactory.TAG, "load " + r6 + " force -  size " + r5.mLoadingPool.size());
            r2.loadBinBuffer(r1.buffer, r1.override);
            r0.remove();
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public synchronized void executeTask(java.lang.String r6) {
            /*
                r5 = this;
                monitor-enter(r5)
                boolean r0 = com.vivo.advv.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L63
                if (r0 == 0) goto L9
                monitor-exit(r5)
                return
            L9:
                java.util.concurrent.LinkedBlockingQueue<com.vivo.advv.vaf.virtualview.ViewFactory$TmplTask> r0 = r5.mLoadingPool     // Catch: java.lang.Throwable -> L63
                java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L63
            Lf:
                boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L63
                if (r1 == 0) goto L61
                java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L63
                com.vivo.advv.vaf.virtualview.ViewFactory$TmplTask r1 = (com.vivo.advv.vaf.virtualview.ViewFactory.TmplTask) r1     // Catch: java.lang.Throwable -> L63
                java.lang.String r2 = com.vivo.advv.vaf.virtualview.ViewFactory.TmplTask.access$200(r1)     // Catch: java.lang.Throwable -> L63
                boolean r2 = r6.equals(r2)     // Catch: java.lang.Throwable -> L63
                if (r2 == 0) goto Lf
                java.lang.ref.WeakReference<com.vivo.advv.vaf.virtualview.ViewFactory> r2 = r5.mViewFactory     // Catch: java.lang.Throwable -> L63
                java.lang.Object r2 = r2.get()     // Catch: java.lang.Throwable -> L63
                com.vivo.advv.vaf.virtualview.ViewFactory r2 = (com.vivo.advv.vaf.virtualview.ViewFactory) r2     // Catch: java.lang.Throwable -> L63
                if (r2 == 0) goto L61
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L63
                r3.<init>()     // Catch: java.lang.Throwable -> L63
                java.lang.String r4 = "load "
                r3.append(r4)     // Catch: java.lang.Throwable -> L63
                r3.append(r6)     // Catch: java.lang.Throwable -> L63
                java.lang.String r6 = " force -  size "
                r3.append(r6)     // Catch: java.lang.Throwable -> L63
                java.util.concurrent.LinkedBlockingQueue<com.vivo.advv.vaf.virtualview.ViewFactory$TmplTask> r6 = r5.mLoadingPool     // Catch: java.lang.Throwable -> L63
                int r6 = r6.size()     // Catch: java.lang.Throwable -> L63
                r3.append(r6)     // Catch: java.lang.Throwable -> L63
                java.lang.String r6 = r3.toString()     // Catch: java.lang.Throwable -> L63
                java.lang.String r3 = "ViewFac_TMTEST"
                com.vivo.advv.vaf.virtualview.util.VVLog.d(r3, r6)     // Catch: java.lang.Throwable -> L63
                byte[] r6 = com.vivo.advv.vaf.virtualview.ViewFactory.TmplTask.access$300(r1)     // Catch: java.lang.Throwable -> L63
                boolean r1 = com.vivo.advv.vaf.virtualview.ViewFactory.TmplTask.access$400(r1)     // Catch: java.lang.Throwable -> L63
                r2.loadBinBuffer(r6, r1)     // Catch: java.lang.Throwable -> L63
                r0.remove()     // Catch: java.lang.Throwable -> L63
            L61:
                monitor-exit(r5)
                return
            L63:
                r6 = move-exception
                monitor-exit(r5)
                goto L67
            L66:
                throw r6
            L67:
                goto L66
            */
            throw new UnsupportedOperationException("Method not decompiled: com.vivo.advv.vaf.virtualview.ViewFactory.TmplWorker.executeTask(java.lang.String):void");
        }

        public synchronized boolean isRunning() {
            return this.isRunning;
        }

        public synchronized void offerTask(TmplTask tmplTask) {
            try {
                this.mLoadingPool.put(tmplTask);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            ViewFactory viewFactory;
            while (this.isRunning) {
                try {
                    TmplTask take = this.mLoadingPool.take();
                    VVLog.d(ViewFactory.TAG, "take " + take.type);
                    if (take != null && (viewFactory = this.mViewFactory.get()) != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("load ");
                        sb.append(take.type);
                        sb.append(" doing ");
                        int i2 = this.count + 1;
                        this.count = i2;
                        sb.append(i2);
                        VVLog.d(ViewFactory.TAG, sb.toString());
                        viewFactory.loadBinBuffer(take.buffer, take.override);
                    }
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            this.mLoadingPool.clear();
            this.isRunning = false;
        }

        public synchronized void setViewFactory(ViewFactory viewFactory) {
            this.mViewFactory = new WeakReference<>(viewFactory);
        }

        @Override // java.lang.Thread
        public synchronized void start() {
            super.start();
            this.isRunning = true;
        }

        public synchronized void stopSelf() {
            this.isRunning = false;
            interrupt();
        }

        private TmplWorker() {
            super("VirtualView-TmplWorker");
            this.mLoadingPool = new LinkedBlockingQueue<>();
            this.count = 0;
            this.isRunning = false;
        }
    }

    static {
        TmplWorker tmplWorker = new TmplWorker();
        mTmplWorker = tmplWorker;
        tmplWorker.start();
        mLoader.setUiCodeManager(mUiCodeLoader);
        mLoader.setExprCodeManager(mExprCodeLoader);
    }

    public ViewFactory() {
        SparseArray<ViewBase.IBuilder> sparseArray = new SparseArray<>();
        this.mBuilders = sparseArray;
        sparseArray.put(1, new FrameLayout.Builder());
        this.mBuilders.put(4, new GridLayout.Builder());
        this.mBuilders.put(2, new VHLayout.Builder());
        this.mBuilders.put(5, new FlexLayout.Builder());
        this.mBuilders.put(6, new RatioLayout.Builder());
        this.mBuilders.put(3, new VH2Layout.Builder());
        this.mBuilders.put(7, new NativeText.Builder());
        this.mBuilders.put(8, new VirtualText.Builder());
        this.mBuilders.put(9, new NativeImage.Builder());
        this.mBuilders.put(10, new VirtualImage.Builder());
        this.mBuilders.put(14, new VirtualLine.Builder());
        this.mBuilders.put(15, new Scroller.Builder());
        this.mBuilders.put(16, new Page.Builder());
        this.mBuilders.put(17, new Grid.Builder());
        this.mBuilders.put(13, new NativeLine.Builder());
        this.mBuilders.put(21, new VirtualGraph.Builder());
        this.mBuilders.put(18, new VH.Builder());
        this.mBuilders.put(20, new VirtualTime.Builder());
        if (VVFeatureConfig.isSliderCompat()) {
            this.mBuilders.put(19, new SliderCompact.Builder());
        } else {
            this.mBuilders.put(19, new Slider.Builder());
        }
        this.mBuilders.put(22, new VirtualProgress.Builder());
        this.mBuilders.put(23, new VirtualContainer.Builder());
        this.mBuilders.put(25, new NFrameLayout.Builder());
        this.mBuilders.put(26, new NGridLayout.Builder());
        this.mBuilders.put(27, new NRatioLayout.Builder());
        this.mBuilders.put(28, new NVH2Layout.Builder());
        this.mBuilders.put(29, new NVHLayout.Builder());
        synchronized (LOCK) {
            mTmplWorker.setViewFactory(this);
        }
    }

    private ViewBase createView(VafContext vafContext, int i2, ViewCache viewCache) {
        ViewBase.IBuilder iBuilder = this.mBuilders.get(i2);
        if (iBuilder != null) {
            return iBuilder.build(vafContext, viewCache);
        }
        return null;
    }

    public void destroy() {
        this.mAppContext = null;
        this.mComArr.clear();
        this.mBuilders.clear();
    }

    public int getViewVersion(String str) {
        CodeReader code;
        synchronized (LOCK) {
            code = mUiCodeLoader.getCode(str);
            if (code == null) {
                mTmplWorker.executeTask(str);
                code = mUiCodeLoader.getCode(str);
            }
        }
        if (code != null) {
            return code.getPatchVersion();
        }
        return 0;
    }

    public boolean init(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i2 = displayMetrics.widthPixels;
        this.mScreenWidth = i2;
        Utils.init(displayMetrics.density, i2);
        return true;
    }

    public int loadBinBuffer(byte[] bArr) {
        int loadFromBuffer;
        synchronized (LOCK) {
            loadFromBuffer = mLoader.loadFromBuffer(bArr);
        }
        return loadFromBuffer;
    }

    public void loadBinBufferAsync(String str, byte[] bArr) {
        loadBinBufferAsync(str, bArr, false);
    }

    public int loadBinFile(String str) {
        int loadFromFile;
        synchronized (LOCK) {
            loadFromFile = mLoader.loadFromFile(str);
        }
        return loadFromFile;
    }

    public ViewBase newView(String str) {
        return newView(str, null, 1.0f);
    }

    public IContainer newViewWithContainer(String str) {
        ViewBase newView = newView(str);
        if (newView != null) {
            Container container = new Container(this.mAppContext.forViewConstruction());
            container.setVirtualView(newView, null);
            container.attachViews();
            return container;
        }
        VVLog.e(TAG, "new view failed type:" + str);
        return null;
    }

    public boolean overrideBuilder(int i2, ViewBase.IBuilder iBuilder) {
        if (iBuilder != null) {
            this.mBuilders.put(i2, iBuilder);
            return true;
        }
        VVLog.e(TAG, "register builder failed, builder is null");
        return false;
    }

    public boolean registerBuilder(int i2, ViewBase.IBuilder iBuilder) {
        if (iBuilder == null) {
            VVLog.e(TAG, "register builder failed, builder is null");
        } else {
            if (this.mBuilders.get(i2) == null) {
                this.mBuilders.put(i2, iBuilder);
                return true;
            }
            VVLog.e(TAG, "register builder failed, already exist id:" + i2);
        }
        return false;
    }

    public int rp2px(double d2) {
        if (this.mUedScreen == 0) {
            this.mUedScreen = DownloadErrorCode.ERROR_TTNET_NOT_MODIFIED;
        }
        double d3 = this.mScreenWidth;
        Double.isNaN(d3);
        double d4 = d2 * d3;
        double d5 = this.mUedScreen;
        Double.isNaN(d5);
        return (int) ((d4 / d5) + 0.5d);
    }

    public void setPageContext(VafContext vafContext) {
        this.mAppContext = vafContext;
        mLoader.setPageContext(vafContext);
    }

    public void setUedScreen(int i2) {
        this.mUedScreen = i2;
    }

    public void loadBinBufferAsync(String str, byte[] bArr, boolean z) {
        if (TextUtils.isEmpty(str) || bArr == null || !mTmplWorker.isRunning()) {
            return;
        }
        mTmplWorker.offerTask(new TmplTask(str, bArr, z));
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x01b5 A[LOOP:0: B:13:0x0049->B:19:0x01b5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x01a5 A[EDGE_INSN: B:20:0x01a5->B:21:0x01a5 BREAK  A[LOOP:0: B:13:0x0049->B:19:0x01b5], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.vivo.advv.vaf.virtualview.core.ViewBase newView(java.lang.String r10, android.util.SparseArray<com.vivo.advv.vaf.virtualview.core.ViewBase> r11, float r12) {
        /*
            Method dump skipped, instructions count: 477
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.advv.vaf.virtualview.ViewFactory.newView(java.lang.String, android.util.SparseArray, float):com.vivo.advv.vaf.virtualview.core.ViewBase");
    }

    public int loadBinBuffer(byte[] bArr, boolean z) {
        int loadFromBuffer;
        synchronized (LOCK) {
            try {
                try {
                    loadFromBuffer = mLoader.loadFromBuffer(bArr, z);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    VVLog.d(TAG, "load exception ");
                    return -1;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return loadFromBuffer;
    }

    public boolean init(Context context, int i2) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.mScreenWidth = i2;
        Utils.init(displayMetrics.density, i2);
        return true;
    }
}
