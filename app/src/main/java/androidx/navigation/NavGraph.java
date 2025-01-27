package androidx.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SparseArrayCompat;
import androidx.navigation.NavDestination;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public class NavGraph extends NavDestination implements Iterable<NavDestination> {

    /* renamed from: j */
    final SparseArrayCompat<NavDestination> f3017j;
    private int k;
    private String l;

    /* renamed from: androidx.navigation.NavGraph$1 */
    class AnonymousClass1 implements Iterator<NavDestination> {

        /* renamed from: a */
        private int f3018a = -1;

        /* renamed from: b */
        private boolean f3019b = false;

        AnonymousClass1() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f3018a + 1 < NavGraph.this.f3017j.size();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f3019b) {
                throw new IllegalStateException("You must call next() before you can remove an element");
            }
            NavGraph.this.f3017j.valueAt(this.f3018a).f(null);
            NavGraph.this.f3017j.removeAt(this.f3018a);
            this.f3018a--;
            this.f3019b = false;
        }

        @Override // java.util.Iterator
        public NavDestination next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f3019b = true;
            SparseArrayCompat<NavDestination> sparseArrayCompat = NavGraph.this.f3017j;
            int i2 = this.f3018a + 1;
            this.f3018a = i2;
            return sparseArrayCompat.valueAt(i2);
        }
    }

    public NavGraph(@NonNull Navigator<? extends NavGraph> navigator) {
        super(navigator);
        this.f3017j = new SparseArrayCompat<>();
    }

    public final void addAll(@NonNull NavGraph navGraph) {
        Iterator<NavDestination> it = navGraph.iterator();
        while (it.hasNext()) {
            NavDestination next = it.next();
            it.remove();
            addDestination(next);
        }
    }

    public final void addDestination(@NonNull NavDestination navDestination) {
        int id = navDestination.getId();
        if (id == 0) {
            throw new IllegalArgumentException("Destinations must have an id. Call setId() or include an android:id in your navigation XML.");
        }
        if (id == getId()) {
            throw new IllegalArgumentException("Destination " + navDestination + " cannot have the same id as graph " + this);
        }
        NavDestination navDestination2 = this.f3017j.get(id);
        if (navDestination2 == navDestination) {
            return;
        }
        if (navDestination.getParent() != null) {
            throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.");
        }
        if (navDestination2 != null) {
            navDestination2.f(null);
        }
        navDestination.f(this);
        this.f3017j.put(navDestination.getId(), navDestination);
    }

    public final void addDestinations(@NonNull Collection<NavDestination> collection) {
        for (NavDestination navDestination : collection) {
            if (navDestination != null) {
                addDestination(navDestination);
            }
        }
    }

    public final void clear() {
        Iterator<NavDestination> it = iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    @Override // androidx.navigation.NavDestination
    @Nullable
    NavDestination.DeepLinkMatch d(@NonNull NavDeepLinkRequest navDeepLinkRequest) {
        NavDestination.DeepLinkMatch d2 = super.d(navDeepLinkRequest);
        Iterator<NavDestination> it = iterator();
        while (it.hasNext()) {
            NavDestination.DeepLinkMatch d3 = it.next().d(navDeepLinkRequest);
            if (d3 != null && (d2 == null || d3.compareTo(d2) > 0)) {
                d2 = d3;
            }
        }
        return d2;
    }

    @Nullable
    public final NavDestination findNode(@IdRes int i2) {
        return h(i2, true);
    }

    @Override // androidx.navigation.NavDestination
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getDisplayName() {
        return getId() != 0 ? super.getDisplayName() : "the root navigation";
    }

    @IdRes
    public final int getStartDestination() {
        return this.k;
    }

    @Nullable
    final NavDestination h(@IdRes int i2, boolean z) {
        NavDestination navDestination = this.f3017j.get(i2);
        if (navDestination != null) {
            return navDestination;
        }
        if (!z || getParent() == null) {
            return null;
        }
        return getParent().findNode(i2);
    }

    @NonNull
    String i() {
        if (this.l == null) {
            this.l = Integer.toString(this.k);
        }
        return this.l;
    }

    @Override // java.lang.Iterable
    @NonNull
    public final Iterator<NavDestination> iterator() {
        return new Iterator<NavDestination>() { // from class: androidx.navigation.NavGraph.1

            /* renamed from: a */
            private int f3018a = -1;

            /* renamed from: b */
            private boolean f3019b = false;

            AnonymousClass1() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f3018a + 1 < NavGraph.this.f3017j.size();
            }

            @Override // java.util.Iterator
            public void remove() {
                if (!this.f3019b) {
                    throw new IllegalStateException("You must call next() before you can remove an element");
                }
                NavGraph.this.f3017j.valueAt(this.f3018a).f(null);
                NavGraph.this.f3017j.removeAt(this.f3018a);
                this.f3018a--;
                this.f3019b = false;
            }

            @Override // java.util.Iterator
            public NavDestination next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.f3019b = true;
                SparseArrayCompat<NavDestination> sparseArrayCompat = NavGraph.this.f3017j;
                int i2 = this.f3018a + 1;
                this.f3018a = i2;
                return sparseArrayCompat.valueAt(i2);
            }
        };
    }

    @Override // androidx.navigation.NavDestination
    public void onInflate(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super.onInflate(context, attributeSet);
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, androidx.navigation.common.R.styleable.NavGraphNavigator);
        setStartDestination(obtainAttributes.getResourceId(androidx.navigation.common.R.styleable.NavGraphNavigator_startDestination, 0));
        this.l = NavDestination.c(context, this.k);
        obtainAttributes.recycle();
    }

    public final void remove(@NonNull NavDestination navDestination) {
        int indexOfKey = this.f3017j.indexOfKey(navDestination.getId());
        if (indexOfKey >= 0) {
            this.f3017j.valueAt(indexOfKey).f(null);
            this.f3017j.removeAt(indexOfKey);
        }
    }

    public final void setStartDestination(@IdRes int i2) {
        if (i2 != getId()) {
            this.k = i2;
            this.l = null;
            return;
        }
        throw new IllegalArgumentException("Start destination " + i2 + " cannot use the same id as the graph " + this);
    }

    @Override // androidx.navigation.NavDestination
    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" startDestination=");
        NavDestination findNode = findNode(getStartDestination());
        if (findNode == null) {
            String str = this.l;
            if (str == null) {
                sb.append("0x");
                sb.append(Integer.toHexString(this.k));
            } else {
                sb.append(str);
            }
        } else {
            sb.append("{");
            sb.append(findNode.toString());
            sb.append("}");
        }
        return sb.toString();
    }

    public final void addDestinations(@NonNull NavDestination... navDestinationArr) {
        for (NavDestination navDestination : navDestinationArr) {
            if (navDestination != null) {
                addDestination(navDestination);
            }
        }
    }
}
