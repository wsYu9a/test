package com.vivo.advv.vaf.framework.cm;

import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.virtualview.core.IContainer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class ContainerMrg {
    protected List<IContainer> mContainers = new LinkedList();

    public void destroy() {
        Iterator<IContainer> it = this.mContainers.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
        this.mContainers.clear();
    }

    public abstract IContainer getContainer(VafContext vafContext);

    public void recycle(IContainer iContainer) {
        this.mContainers.add(iContainer);
    }
}
