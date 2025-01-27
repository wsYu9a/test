package com.vivo.advv.vaf.framework;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.vivo.advv.vaf.virtualview.ViewFactory;
import com.vivo.advv.vaf.virtualview.core.Layout;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.core.ViewCache;
import com.vivo.advv.vaf.virtualview.util.VVLog;
import com.vivo.advv.vaf.virtualview.view.image.VirtualImage;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class ViewManager {
    private static final String TAG = "ViewManager_TMTEST";
    private VafContext mAppContext;
    private ViewFactory mViewFactory = new ViewFactory();
    private ConcurrentHashMap<String, List<ViewBase>> mViewCache = new ConcurrentHashMap<>();
    private SparseArray<ViewBase> mUuidContainers = new SparseArray<>();

    public void destroy() {
        Iterator<Map.Entry<String, List<ViewBase>>> it = this.mViewCache.entrySet().iterator();
        while (it.hasNext()) {
            List<ViewBase> value = it.next().getValue();
            if (value != null) {
                for (int i2 = 0; i2 < value.size(); i2++) {
                    ViewBase viewBase = value.get(i2);
                    viewBase.destroy();
                    ViewCache viewCache = viewBase.getViewCache();
                    if (viewCache != null) {
                        viewCache.destroy();
                    }
                }
                value.clear();
            }
        }
        this.mViewCache.clear();
        this.mViewCache = null;
        this.mViewFactory.destroy();
        this.mUuidContainers.clear();
        this.mUuidContainers = null;
    }

    public ViewBase getDefaultImage() {
        VirtualImage virtualImage = new VirtualImage(this.mAppContext, new ViewCache());
        virtualImage.setComLayoutParams(new Layout.Params(getViewFactory()));
        return virtualImage;
    }

    public ViewBase getView(String str, float f2) {
        List<ViewBase> list = this.mViewCache.get(str);
        if (list != null && list.size() != 0) {
            return list.remove(0);
        }
        ViewBase newView = this.mViewFactory.newView(str, this.mUuidContainers, f2);
        if (newView != null) {
            if (newView.supportDynamic()) {
                this.mAppContext.getNativeObjectManager().addView(newView);
            }
            newView.setViewType(str);
        } else {
            VVLog.e(TAG, "new view failed type:" + str);
        }
        return newView;
    }

    public ViewFactory getViewFactory() {
        return this.mViewFactory;
    }

    public ViewBase getViewFromUuid(int i2) {
        return this.mUuidContainers.get(i2);
    }

    public int getViewVersion(String str) {
        return this.mViewFactory.getViewVersion(str);
    }

    public boolean init(Context context) {
        return this.mViewFactory.init(context);
    }

    public void loadBinBufferAsync(String str, byte[] bArr) {
        this.mViewFactory.loadBinBufferAsync(str, bArr);
    }

    public int loadBinBufferSync(byte[] bArr) {
        return this.mViewFactory.loadBinBuffer(bArr);
    }

    public int loadBinFileSync(String str) {
        return this.mViewFactory.loadBinFile(str);
    }

    public void recycle(ViewBase viewBase) {
        if (viewBase != null) {
            String viewType = viewBase.getViewType();
            if (!TextUtils.isEmpty(viewType)) {
                viewBase.reset();
                List<ViewBase> list = this.mViewCache.get(viewType);
                if (list == null) {
                    list = new LinkedList<>();
                    this.mViewCache.put(viewType, list);
                }
                list.add(viewBase);
                return;
            }
            VVLog.e(TAG, "recycle type invalidate:" + viewType);
            RuntimeException runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            VVLog.w(TAG, "Called: " + this, runtimeException);
        }
    }

    public int rp2px(double d2) {
        return this.mViewFactory.rp2px(d2);
    }

    public void setPageContext(VafContext vafContext) {
        this.mAppContext = vafContext;
        this.mViewFactory.setPageContext(vafContext);
    }

    public void setUedScreen(int i2) {
        this.mViewFactory.setUedScreen(i2);
    }

    public boolean init(Context context, int i2) {
        return this.mViewFactory.init(context, i2);
    }

    public void loadBinBufferAsync(String str, byte[] bArr, boolean z) {
        this.mViewFactory.loadBinBufferAsync(str, bArr, z);
    }

    public int loadBinBufferSync(byte[] bArr, boolean z) {
        return this.mViewFactory.loadBinBuffer(bArr, z);
    }
}
