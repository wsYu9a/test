package com.vivo.advv.vaf.virtualview.view.grid;

import android.text.TextUtils;
import android.view.View;
import com.vivo.advv.Utils;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.framework.cm.ContainerService;
import com.vivo.advv.vaf.virtualview.core.IContainer;
import com.vivo.advv.vaf.virtualview.core.NativeViewBase;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.core.ViewCache;
import com.vivo.advv.vaf.virtualview.event.EventData;
import com.vivo.advv.vaf.virtualview.util.VVLog;
import com.vivo.advv.virtualview.common.StringBase;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class Grid extends NativeViewBase {
    private static final String TAG = "Grid_TMTEST";
    private GridImp mNative;

    public static class Builder implements ViewBase.IBuilder {
        @Override // com.vivo.advv.vaf.virtualview.core.ViewBase.IBuilder
        public ViewBase build(VafContext vafContext, ViewCache viewCache) {
            return new Grid(vafContext, viewCache);
        }
    }

    public Grid(VafContext vafContext, ViewCache viewCache) {
        super(vafContext, viewCache);
        GridImp gridImp = new GridImp(vafContext.forViewConstruction());
        this.mNative = gridImp;
        gridImp.setVirtualView(this, null);
        this.__mNative = this.mNative;
    }

    private void recycleViews() {
        ContainerService containerService = this.mContext.getContainerService();
        int childCount = this.mNative.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            containerService.recycle((IContainer) this.mNative.getChildAt(i2));
        }
        this.mNative.removeAllViews();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public boolean isContainer() {
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.NativeViewBase, com.vivo.advv.vaf.virtualview.core.ViewBase
    public void onParseValueFinished(float f2) {
        super.onParseValueFinished(f2);
        this.mNative.setAutoDimDirection(this.mAutoDimDirection);
        this.mNative.setAutoDimX(this.mAutoDimX);
        this.mNative.setAutoDimY(this.mAutoDimY);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.NativeViewBase, com.vivo.advv.vaf.virtualview.core.ViewBase
    public void reset() {
        super.reset();
        recycleViews();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, float f2) {
        boolean attribute = super.setAttribute(i2, f2);
        if (attribute) {
            return attribute;
        }
        if (i2 == 196203191) {
            this.mNative.setItemVerticalMargin(Utils.dp2px(f2));
            return true;
        }
        if (i2 == 1671241242) {
            this.mNative.setItemHeight(Utils.dp2px(f2));
            return true;
        }
        if (i2 != 2129234981) {
            return false;
        }
        this.mNative.setItemHorizontalMargin(Utils.dp2px(f2));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public void setData(Object obj) {
        super.setData(obj);
        if (obj instanceof JSONObject) {
            obj = ((JSONObject) obj).optJSONArray(getDataTag());
        }
        recycleViews();
        if (!(obj instanceof JSONArray)) {
            VVLog.e(TAG, "setData not array");
            return;
        }
        JSONArray jSONArray = (JSONArray) obj;
        ContainerService containerService = this.mContext.getContainerService();
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                String optString = jSONObject.optString("type");
                if (TextUtils.isEmpty(optString)) {
                    VVLog.e(TAG, "get type failed");
                } else {
                    View container = containerService.getContainer(optString);
                    if (container != 0) {
                        ViewBase virtualView = ((IContainer) container).getVirtualView();
                        virtualView.setVData(jSONObject);
                        this.mNative.addView(container);
                        if (virtualView.supportExposure()) {
                            this.mContext.getEventManager().emitEvent(1, EventData.obtainData(this.mContext, virtualView));
                        }
                        virtualView.ready();
                    } else {
                        VVLog.e(TAG, "create view failed");
                    }
                }
            } catch (JSONException e2) {
                VVLog.e(TAG, "get json object failed:" + e2);
            }
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setRPAttribute(int i2, float f2) {
        if (i2 == 196203191) {
            this.mNative.setItemVerticalMargin(rp2px(f2));
        } else if (i2 == 1671241242) {
            this.mNative.setItemHeight(rp2px(f2));
        } else {
            if (i2 != 2129234981) {
                return super.setRPAttribute(i2, f2);
            }
            this.mNative.setItemHorizontalMargin(rp2px(f2));
        }
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, int i3) {
        if (i2 == -669528209) {
            this.mNative.setColumnCount(i3);
        } else if (i2 == 196203191) {
            this.mNative.setItemVerticalMargin(Utils.dp2px(i3));
        } else if (i2 == 1671241242) {
            this.mNative.setItemHeight(Utils.dp2px(i3));
        } else {
            if (i2 != 2129234981) {
                return super.setAttribute(i2, i3);
            }
            this.mNative.setItemHorizontalMargin(Utils.dp2px(i3));
        }
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setRPAttribute(int i2, int i3) {
        if (i2 == 196203191) {
            this.mNative.setItemVerticalMargin(rp2px(i3));
        } else if (i2 == 1671241242) {
            this.mNative.setItemHeight(rp2px(i3));
        } else {
            if (i2 != 2129234981) {
                return super.setRPAttribute(i2, i3);
            }
            this.mNative.setItemHorizontalMargin(rp2px(i3));
        }
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, String str) {
        if (i2 == 196203191) {
            this.mViewCache.put(this, StringBase.STR_ID_itemVerticalMargin, str, 1);
            return true;
        }
        if (i2 != 2129234981) {
            return super.setAttribute(i2, str);
        }
        this.mViewCache.put(this, StringBase.STR_ID_itemHorizontalMargin, str, 1);
        return true;
    }
}
