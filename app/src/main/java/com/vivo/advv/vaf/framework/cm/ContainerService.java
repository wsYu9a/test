package com.vivo.advv.vaf.framework.cm;

import android.view.View;
import android.view.ViewGroup;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.framework.ViewManager;
import com.vivo.advv.vaf.virtualview.container.IActionListener;
import com.vivo.advv.vaf.virtualview.core.IContainer;
import com.vivo.advv.vaf.virtualview.core.Layout;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.util.VVLog;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class ContainerService {
    public static final int CONTAINER_TYPE_NORMAL = 0;

    @Deprecated
    public static final int CONTAINER_TYPE_SURFACE = 1;
    public static final int MAX_CONTAINER_MRG_COUNT = 20;
    private static final String TAG = "ContainerService_TMTEST";
    private VafContext mAppContext;
    protected ComContainerTypeMap mComContainerTypeMap;
    private List<ContainerMrg> mContainerMrg = new ArrayList(20);
    private ViewManager mVM;

    public ContainerService() {
        registerContainerMrg(new NormalManager(), 0);
        registerContainerMrg(new NormalManager(), 1);
    }

    public void destroy() {
        for (ContainerMrg containerMrg : this.mContainerMrg) {
            if (containerMrg != null) {
                containerMrg.destroy();
            }
        }
        this.mVM = null;
        this.mAppContext = null;
    }

    public ComContainerTypeMap getComContainerTypeMap() {
        return this.mComContainerTypeMap;
    }

    public View getContainer(String str) {
        return getContainer(str, true);
    }

    public void recycle(IContainer iContainer) {
        recycle(iContainer, true);
    }

    public void registerContainerMrg(ContainerMrg containerMrg, int i2) {
        if (containerMrg != null && i2 >= 0 && i2 < 20) {
            this.mContainerMrg.add(i2, containerMrg);
            return;
        }
        VVLog.e(TAG, "param invalidate containerID:" + i2);
    }

    public void setPageContext(VafContext vafContext) {
        this.mAppContext = vafContext;
        this.mVM = vafContext.getViewManager();
        this.mComContainerTypeMap = this.mAppContext.getComContainerTypeMap();
    }

    public View getContainer(String str, int i2) {
        return getContainer(str, i2, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void recycle(IContainer iContainer, boolean z) {
        if (iContainer != 0) {
            if (z) {
                ViewBase virtualView = iContainer.getVirtualView();
                if (virtualView != null) {
                    this.mVM.recycle(virtualView);
                    if (iContainer instanceof ViewGroup) {
                        ((ViewGroup) iContainer).removeAllViews();
                    }
                } else {
                    VVLog.e(TAG, "recycle viewbase is null");
                }
            }
            int type = iContainer.getType();
            if (type > -1) {
                ContainerMrg containerMrg = this.mContainerMrg.get(type);
                if (containerMrg != null) {
                    containerMrg.recycle(iContainer);
                    return;
                }
                VVLog.e(TAG, "recycle container type is invalidate:" + iContainer.getType());
            }
        }
    }

    public View getContainer(String str, boolean z) {
        int containerMap = this.mComContainerTypeMap.getContainerMap(str);
        if (containerMap <= -1) {
            containerMap = 0;
        }
        return getContainer(str, containerMap, z);
    }

    public View getContainer(String str, boolean z, float f2, IActionListener iActionListener) {
        int containerMap = this.mComContainerTypeMap.getContainerMap(str);
        return getContainer(str, containerMap <= -1 ? 0 : containerMap, z, f2, iActionListener);
    }

    public View getContainer(String str, int i2, boolean z) {
        return getContainer(str, i2, z, 1.0f, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.vivo.advv.vaf.virtualview.core.IContainer] */
    public View getContainer(String str, int i2, boolean z, float f2, IActionListener iActionListener) {
        View view;
        ViewBase view2 = this.mVM.getView(str, f2);
        if (view2 == null) {
            view2 = this.mVM.getDefaultImage();
            view2.setViewType(str);
        }
        if (view2.isContainer()) {
            view = (IContainer) view2.getNativeView();
        } else {
            ContainerMrg containerMrg = this.mContainerMrg.get(i2);
            if (containerMrg != null) {
                view = containerMrg.getContainer(this.mAppContext);
            } else {
                VVLog.e(TAG, "getContainer type invalidate:" + i2);
                view = 0;
            }
        }
        if (view != 0) {
            view.setVirtualView(view2, iActionListener);
            if (z) {
                Layout.Params comLayoutParams = view2.getComLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(comLayoutParams.mLayoutWidth, comLayoutParams.mLayoutHeight);
                marginLayoutParams.leftMargin = comLayoutParams.mLayoutMarginLeft;
                marginLayoutParams.topMargin = comLayoutParams.mLayoutMarginTop;
                marginLayoutParams.rightMargin = comLayoutParams.mLayoutMarginRight;
                marginLayoutParams.bottomMargin = comLayoutParams.mLayoutMarginBottom;
                view.setLayoutParams(marginLayoutParams);
            }
            view.attachViews();
        }
        return view;
    }
}
