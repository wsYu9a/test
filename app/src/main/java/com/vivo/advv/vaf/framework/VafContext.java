package com.vivo.advv.vaf.framework;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import com.vivo.advv.vaf.expr.engine.ExprEngine;
import com.vivo.advv.vaf.expr.engine.NativeObjectManager;
import com.vivo.advv.vaf.framework.cm.ComContainerTypeMap;
import com.vivo.advv.vaf.framework.cm.ContainerService;
import com.vivo.advv.vaf.virtualview.Helper.BeanManager;
import com.vivo.advv.vaf.virtualview.Helper.DataOpt;
import com.vivo.advv.vaf.virtualview.Helper.ImageLoader;
import com.vivo.advv.vaf.virtualview.Helper.NativeViewManager;
import com.vivo.advv.vaf.virtualview.Helper.ServiceManager;
import com.vivo.advv.vaf.virtualview.core.IContainer;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.event.ClickProcessorManager;
import com.vivo.advv.vaf.virtualview.event.EventData;
import com.vivo.advv.vaf.virtualview.event.EventManager;
import com.vivo.advv.vaf.virtualview.loader.StringLoader;

/* loaded from: classes4.dex */
public class VafContext {
    public static int SLOP = 0;
    private static final String TAG = "PageContext_TMTEST";
    protected static StringLoader mStringLoader = new StringLoader();
    protected BeanManager mBeanManager;
    protected ClickProcessorManager mClickProcessorManager;
    protected ComContainerTypeMap mComContainerTypeMap;
    protected NativeViewManager mCompactNativeManager;
    protected ContainerService mContainerService;
    protected Context mContext;
    protected Activity mCurActivity;
    protected EventManager mEventManager;
    protected ExprEngine mExprEngine;
    protected ImageLoader mImageLoader;
    protected NativeObjectManager mNativeObjManager;
    protected UserData mUserData;
    protected ViewManager mViewManager;
    protected ServiceManager serviceManager;

    public VafContext(Context context) {
        this(context, false);
    }

    public View createContainer(String str) {
        return this.mContainerService.getContainer(str);
    }

    public ViewBase createView(String str) {
        return this.mViewManager.getView(str, 1.0f);
    }

    public final Context forViewConstruction() {
        Activity activity = this.mCurActivity;
        return activity != null ? activity : this.mContext;
    }

    public final Context getActivityContext() {
        return this.mCurActivity;
    }

    public final Context getApplicationContext() {
        return this.mContext.getApplicationContext();
    }

    public final BeanManager getBeanManager() {
        return this.mBeanManager;
    }

    public ClickProcessorManager getClickProcessorManager() {
        return this.mClickProcessorManager;
    }

    public ComContainerTypeMap getComContainerTypeMap() {
        return this.mComContainerTypeMap;
    }

    public final NativeViewManager getCompactNativeManager() {
        return this.mCompactNativeManager;
    }

    public final ContainerService getContainerService() {
        return this.mContainerService;
    }

    @Deprecated
    public final Context getContext() {
        return this.mContext;
    }

    public final Activity getCurActivity() {
        return this.mCurActivity;
    }

    public final EventManager getEventManager() {
        return this.mEventManager;
    }

    public final ExprEngine getExprEngine() {
        return this.mExprEngine;
    }

    public final ImageLoader getImageLoader() {
        return this.mImageLoader;
    }

    public final NativeObjectManager getNativeObjectManager() {
        return this.mNativeObjManager;
    }

    public <S> S getService(@NonNull Class<S> cls) {
        return (S) this.serviceManager.getService(cls);
    }

    public final StringLoader getStringLoader() {
        return mStringLoader;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public final ViewManager getViewManager() {
        return this.mViewManager;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void onDestroy(int i2) {
        if (i2 > -1) {
            mStringLoader.remove(i2);
        }
    }

    public void onResume(int i2) {
        if (i2 > -1) {
            mStringLoader.setCurPage(i2);
        }
    }

    public void recycleContainer(IContainer iContainer) {
        this.mContainerService.recycle(iContainer, false);
    }

    public void recycleView(ViewBase viewBase) {
        this.mViewManager.recycle(viewBase);
    }

    public <S> void registerService(@NonNull Class<S> cls, @NonNull S s) {
        this.serviceManager.register(cls, s);
    }

    public void setCurActivity(Activity activity) {
        this.mCurActivity = activity;
    }

    public final void setImageLoaderAdapter(ImageLoader.IImageLoaderAdapter iImageLoaderAdapter) {
        this.mImageLoader.setImageLoaderAdapter(iImageLoaderAdapter);
    }

    public void uninit() {
        this.mContext = null;
        this.mCurActivity = null;
        EventData.clear();
    }

    public VafContext(Activity activity) {
        this(activity.getApplicationContext(), false);
        this.mCurActivity = activity;
    }

    public void onDestroy() {
        this.mContext = null;
        this.mCurActivity = null;
        EventData.clear();
        ExprEngine exprEngine = this.mExprEngine;
        if (exprEngine != null) {
            exprEngine.destroy();
            this.mExprEngine = null;
        }
        NativeObjectManager nativeObjectManager = this.mNativeObjManager;
        if (nativeObjectManager != null) {
            nativeObjectManager.destroy();
            this.mNativeObjManager = null;
        }
        ViewManager viewManager = this.mViewManager;
        if (viewManager != null) {
            viewManager.destroy();
            this.mViewManager = null;
        }
        ContainerService containerService = this.mContainerService;
        if (containerService != null) {
            containerService.destroy();
            this.mContainerService = null;
        }
    }

    public VafContext(Context context, boolean z) {
        this.mExprEngine = new ExprEngine();
        this.mViewManager = new ViewManager();
        this.mBeanManager = new BeanManager();
        this.mCompactNativeManager = new NativeViewManager();
        this.mNativeObjManager = new NativeObjectManager();
        this.mEventManager = new EventManager();
        this.mUserData = new UserData();
        this.mComContainerTypeMap = new ComContainerTypeMap();
        this.serviceManager = new ServiceManager();
        this.mClickProcessorManager = new ClickProcessorManager();
        this.mContext = context;
        DataOpt.setStringLoader(mStringLoader);
        this.mViewManager.setPageContext(this);
        this.mNativeObjManager.setStringManager(mStringLoader);
        this.mExprEngine.setNativeObjectManager(this.mNativeObjManager);
        this.mExprEngine.setStringSupport(mStringLoader);
        this.mExprEngine.initFinished();
        if (!z) {
            ContainerService containerService = new ContainerService();
            this.mContainerService = containerService;
            containerService.setPageContext(this);
        }
        this.mImageLoader = ImageLoader.build(context);
        try {
            SLOP = ViewConfiguration.get(context).getScaledTouchSlop();
        } catch (Exception e2) {
            e2.printStackTrace();
            SLOP = 8;
        }
    }
}
