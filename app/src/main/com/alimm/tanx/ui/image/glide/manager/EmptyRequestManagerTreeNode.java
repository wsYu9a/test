package com.alimm.tanx.ui.image.glide.manager;

import com.alimm.tanx.ui.image.glide.RequestManager;
import java.util.Collections;
import java.util.Set;

/* loaded from: classes.dex */
final class EmptyRequestManagerTreeNode implements RequestManagerTreeNode {
    @Override // com.alimm.tanx.ui.image.glide.manager.RequestManagerTreeNode
    public Set<RequestManager> getDescendants() {
        return Collections.emptySet();
    }
}
