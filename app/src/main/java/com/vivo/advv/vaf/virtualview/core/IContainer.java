package com.vivo.advv.vaf.virtualview.core;

import android.view.View;
import com.vivo.advv.vaf.virtualview.container.IActionListener;

/* loaded from: classes4.dex */
public interface IContainer {
    void attachViews();

    void destroy();

    View getHolderView();

    int getType();

    ViewBase getVirtualView();

    void setVirtualView(ViewBase viewBase, IActionListener iActionListener);
}
