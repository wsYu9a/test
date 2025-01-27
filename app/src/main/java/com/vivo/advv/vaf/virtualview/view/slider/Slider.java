package com.vivo.advv.vaf.virtualview.view.slider;

import androidx.recyclerview.widget.LinearSnapHelper;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.core.ViewCache;
import com.vivo.advv.vaf.virtualview.view.scroller.Scroller;

/* loaded from: classes4.dex */
public class Slider extends Scroller {

    public static class Builder implements ViewBase.IBuilder {
        @Override // com.vivo.advv.vaf.virtualview.core.ViewBase.IBuilder
        public ViewBase build(VafContext vafContext, ViewCache viewCache) {
            return new Slider(vafContext, viewCache);
        }
    }

    public Slider(VafContext vafContext, ViewCache viewCache) {
        super(vafContext, viewCache);
        new LinearSnapHelper().attachToRecyclerView(this.mNative);
    }
}
