package com.vivo.advv.vaf.framework.cm;

import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.virtualview.container.Container;
import com.vivo.advv.vaf.virtualview.core.IContainer;

/* loaded from: classes4.dex */
public class NormalManager extends ContainerMrg {
    @Override // com.vivo.advv.vaf.framework.cm.ContainerMrg
    public IContainer getContainer(VafContext vafContext) {
        return this.mContainers.size() > 0 ? this.mContainers.remove(0) : new Container(vafContext.forViewConstruction());
    }
}
