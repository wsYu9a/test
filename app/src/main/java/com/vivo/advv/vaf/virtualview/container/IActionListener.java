package com.vivo.advv.vaf.virtualview.container;

import com.vivo.advv.vaf.virtualview.core.IContainer;
import com.vivo.advv.vaf.virtualview.event.EventData;

/* loaded from: classes4.dex */
public interface IActionListener {
    boolean onClickAction(String str, IContainer iContainer, EventData eventData, int i2, int i3, int i4, int i5);

    boolean onLongClickAction(String str, IContainer iContainer, EventData eventData, int i2, int i3, int i4, int i5);
}
