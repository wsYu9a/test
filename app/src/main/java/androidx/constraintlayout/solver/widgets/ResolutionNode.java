package androidx.constraintlayout.solver.widgets;

import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ResolutionNode {
    public static final int REMOVED = 2;
    public static final int RESOLVED = 1;
    public static final int UNRESOLVED = 0;

    /* renamed from: a */
    HashSet<ResolutionNode> f1286a = new HashSet<>(2);

    /* renamed from: b */
    int f1287b = 0;

    public void addDependent(ResolutionNode resolutionNode) {
        this.f1286a.add(resolutionNode);
    }

    public void didResolve() {
        this.f1287b = 1;
        Iterator<ResolutionNode> it = this.f1286a.iterator();
        while (it.hasNext()) {
            it.next().resolve();
        }
    }

    public void invalidate() {
        this.f1287b = 0;
        Iterator<ResolutionNode> it = this.f1286a.iterator();
        while (it.hasNext()) {
            it.next().invalidate();
        }
    }

    public void invalidateAnchors() {
        if (this instanceof ResolutionAnchor) {
            this.f1287b = 0;
        }
        Iterator<ResolutionNode> it = this.f1286a.iterator();
        while (it.hasNext()) {
            it.next().invalidateAnchors();
        }
    }

    public boolean isResolved() {
        return this.f1287b == 1;
    }

    public void remove(ResolutionDimension resolutionDimension) {
    }

    public void reset() {
        this.f1287b = 0;
        this.f1286a.clear();
    }

    public void resolve() {
    }
}
