package com.vivo.advv.vaf.virtualview.view.vh;

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
public class VH extends NativeViewBase {
    private static final String TAG = "VH_TMTEST";
    private VHImp mNative;

    public static class Builder implements ViewBase.IBuilder {
        @Override // com.vivo.advv.vaf.virtualview.core.ViewBase.IBuilder
        public ViewBase build(VafContext vafContext, ViewCache viewCache) {
            return new VH(vafContext, viewCache);
        }
    }

    public VH(VafContext vafContext, ViewCache viewCache) {
        super(vafContext, viewCache);
        VHImp vHImp = new VHImp(vafContext.forViewConstruction());
        this.mNative = vHImp;
        this.__mNative = vHImp;
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
    public ViewBase getChild(int i2) {
        return ((IContainer) this.mNative.getChildAt(i2)).getVirtualView();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public boolean isContainer() {
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, float f2) {
        boolean attribute = super.setAttribute(i2, f2);
        if (attribute) {
            return attribute;
        }
        if (i2 == 1671241242) {
            this.mNative.setItemHeight(Utils.dp2px(f2));
            return true;
        }
        if (i2 == 1810961057) {
            this.mNative.setItemMargin(Utils.dp2px(f2));
            return true;
        }
        if (i2 != 2146088563) {
            return false;
        }
        this.mNative.setItemWidth(Utils.dp2px(f2));
        return true;
    }

    public void setData(int i2, String str) {
        recycleViews();
        ContainerService containerService = this.mContext.getContainerService();
        while (i2 > 0) {
            this.mNative.addView(containerService.getContainer(str));
            i2--;
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setRPAttribute(int i2, float f2) {
        boolean rPAttribute = super.setRPAttribute(i2, f2);
        if (rPAttribute) {
            return rPAttribute;
        }
        if (i2 == 1671241242) {
            this.mNative.setItemHeight(rp2px(f2));
            return true;
        }
        if (i2 == 1810961057) {
            this.mNative.setItemMargin(rp2px(f2));
            return true;
        }
        if (i2 != 2146088563) {
            return false;
        }
        this.mNative.setItemWidth(rp2px(f2));
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, int i3) {
        boolean attribute = super.setAttribute(i2, i3);
        if (attribute) {
            return attribute;
        }
        if (i2 == -1439500848) {
            this.mNative.setOrientation(i3);
            return true;
        }
        if (i2 == 1671241242) {
            this.mNative.setItemHeight(Utils.dp2px(i3));
            return true;
        }
        if (i2 == 1810961057) {
            this.mNative.setItemMargin(Utils.dp2px(i3));
            return true;
        }
        if (i2 != 2146088563) {
            return false;
        }
        this.mNative.setItemWidth(Utils.dp2px(i3));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public void setData(Object obj) {
        super.setData(obj);
        if (obj instanceof JSONObject) {
            obj = ((JSONObject) obj).optJSONArray(getDataTag());
        }
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            recycleViews();
            ContainerService containerService = this.mContext.getContainerService();
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    String optString = jSONObject.optString("type");
                    if (!TextUtils.isEmpty(optString)) {
                        View container = containerService.getContainer(optString);
                        if (container != 0) {
                            ViewBase virtualView = ((IContainer) container).getVirtualView();
                            virtualView.setVData(jSONObject);
                            this.mNative.addView(container);
                            virtualView.ready();
                            if (virtualView.supportExposure()) {
                                this.mContext.getEventManager().emitEvent(1, EventData.obtainData(this.mContext, virtualView));
                            }
                        } else {
                            VVLog.e(TAG, "create view failed");
                        }
                    } else {
                        VVLog.e(TAG, "get type failed");
                    }
                } catch (JSONException e2) {
                    VVLog.e(TAG, "get json object failed:" + e2);
                }
            }
            return;
        }
        VVLog.e(TAG, "setData not array:" + obj);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setRPAttribute(int i2, int i3) {
        boolean rPAttribute = super.setRPAttribute(i2, i3);
        if (rPAttribute) {
            return rPAttribute;
        }
        if (i2 == 1671241242) {
            this.mNative.setItemHeight(rp2px(i3));
            return true;
        }
        if (i2 == 1810961057) {
            this.mNative.setItemMargin(rp2px(i3));
            return true;
        }
        if (i2 != 2146088563) {
            return false;
        }
        this.mNative.setItemWidth(rp2px(i3));
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, String str) {
        if (i2 == 1671241242) {
            this.mViewCache.put(this, StringBase.STR_ID_itemHeight, str, 1);
            return true;
        }
        if (i2 == 1810961057) {
            this.mViewCache.put(this, StringBase.STR_ID_itemMargin, str, 1);
            return true;
        }
        if (i2 != 2146088563) {
            return super.setAttribute(i2, str);
        }
        this.mViewCache.put(this, StringBase.STR_ID_itemWidth, str, 1);
        return true;
    }
}
