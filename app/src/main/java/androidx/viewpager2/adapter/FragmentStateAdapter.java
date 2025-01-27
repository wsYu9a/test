package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import androidx.collection.LongSparseArray;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class FragmentStateAdapter extends RecyclerView.Adapter<FragmentViewHolder> implements StatefulAdapter {

    /* renamed from: a */
    private static final String f4067a = "f#";

    /* renamed from: b */
    private static final String f4068b = "s#";

    /* renamed from: c */
    private static final long f4069c = 10000;

    /* renamed from: d */
    final Lifecycle f4070d;

    /* renamed from: e */
    final FragmentManager f4071e;

    /* renamed from: f */
    final LongSparseArray<Fragment> f4072f;

    /* renamed from: g */
    private final LongSparseArray<Fragment.SavedState> f4073g;

    /* renamed from: h */
    private final LongSparseArray<Integer> f4074h;

    /* renamed from: i */
    private FragmentMaxLifecycleEnforcer f4075i;

    /* renamed from: j */
    boolean f4076j;
    private boolean k;

    /* renamed from: androidx.viewpager2.adapter.FragmentStateAdapter$1 */
    class AnonymousClass1 implements View.OnLayoutChangeListener {

        /* renamed from: a */
        final /* synthetic */ FrameLayout f4077a;

        /* renamed from: b */
        final /* synthetic */ FragmentViewHolder f4078b;

        AnonymousClass1(FrameLayout frameLayout, FragmentViewHolder fragmentViewHolder) {
            B = frameLayout;
            fragmentViewHolder = fragmentViewHolder;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            if (B.getParent() != null) {
                B.removeOnLayoutChangeListener(this);
                FragmentStateAdapter.this.J(fragmentViewHolder);
            }
        }
    }

    /* renamed from: androidx.viewpager2.adapter.FragmentStateAdapter$2 */
    class AnonymousClass2 implements LifecycleEventObserver {

        /* renamed from: a */
        final /* synthetic */ FragmentViewHolder f4080a;

        AnonymousClass2(FragmentViewHolder fragmentViewHolder) {
            fragmentViewHolder = fragmentViewHolder;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
            if (FragmentStateAdapter.this.N()) {
                return;
            }
            lifecycleOwner.getLifecycle().removeObserver(this);
            if (ViewCompat.isAttachedToWindow(fragmentViewHolder.B())) {
                FragmentStateAdapter.this.J(fragmentViewHolder);
            }
        }
    }

    /* renamed from: androidx.viewpager2.adapter.FragmentStateAdapter$3 */
    class AnonymousClass3 extends FragmentManager.FragmentLifecycleCallbacks {

        /* renamed from: a */
        final /* synthetic */ Fragment f4082a;

        /* renamed from: b */
        final /* synthetic */ FrameLayout f4083b;

        AnonymousClass3(Fragment fragment, FrameLayout frameLayout) {
            fragment = fragment;
            frameLayout = frameLayout;
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentViewCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull View view, @Nullable Bundle bundle) {
            if (fragment == fragment) {
                fragmentManager.unregisterFragmentLifecycleCallbacks(this);
                FragmentStateAdapter.this.b(view, frameLayout);
            }
        }
    }

    /* renamed from: androidx.viewpager2.adapter.FragmentStateAdapter$4 */
    class AnonymousClass4 implements Runnable {
        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentStateAdapter fragmentStateAdapter = FragmentStateAdapter.this;
            fragmentStateAdapter.f4076j = false;
            fragmentStateAdapter.E();
        }
    }

    /* renamed from: androidx.viewpager2.adapter.FragmentStateAdapter$5 */
    class AnonymousClass5 implements LifecycleEventObserver {

        /* renamed from: a */
        final /* synthetic */ Handler f4086a;

        /* renamed from: b */
        final /* synthetic */ Runnable f4087b;

        AnonymousClass5(Handler handler, Runnable runnable) {
            handler = handler;
            runnable = runnable;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_DESTROY) {
                handler.removeCallbacks(runnable);
                lifecycleOwner.getLifecycle().removeObserver(this);
            }
        }
    }

    private static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
        private DataSetChangeObserver() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public abstract void onChanged();

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i2, int i3) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int i2, int i3) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int i2, int i3, int i4) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int i2, int i3) {
            onChanged();
        }

        /* synthetic */ DataSetChangeObserver(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i2, int i3, @Nullable Object obj) {
            onChanged();
        }
    }

    class FragmentMaxLifecycleEnforcer {

        /* renamed from: a */
        private ViewPager2.OnPageChangeCallback f4089a;

        /* renamed from: b */
        private RecyclerView.AdapterDataObserver f4090b;

        /* renamed from: c */
        private LifecycleEventObserver f4091c;

        /* renamed from: d */
        private ViewPager2 f4092d;

        /* renamed from: e */
        private long f4093e = -1;

        /* renamed from: androidx.viewpager2.adapter.FragmentStateAdapter$FragmentMaxLifecycleEnforcer$1 */
        class AnonymousClass1 extends ViewPager2.OnPageChangeCallback {
            AnonymousClass1() {
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i2) {
                FragmentMaxLifecycleEnforcer.this.d(false);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i2) {
                FragmentMaxLifecycleEnforcer.this.d(false);
            }
        }

        /* renamed from: androidx.viewpager2.adapter.FragmentStateAdapter$FragmentMaxLifecycleEnforcer$2 */
        class AnonymousClass2 extends DataSetChangeObserver {
            AnonymousClass2() {
            }

            @Override // androidx.viewpager2.adapter.FragmentStateAdapter.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                FragmentMaxLifecycleEnforcer.this.d(true);
            }
        }

        /* renamed from: androidx.viewpager2.adapter.FragmentStateAdapter$FragmentMaxLifecycleEnforcer$3 */
        class AnonymousClass3 implements LifecycleEventObserver {
            AnonymousClass3() {
            }

            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                FragmentMaxLifecycleEnforcer.this.d(false);
            }
        }

        FragmentMaxLifecycleEnforcer() {
        }

        @NonNull
        private ViewPager2 a(@NonNull RecyclerView recyclerView) {
            ViewParent parent = recyclerView.getParent();
            if (parent instanceof ViewPager2) {
                return (ViewPager2) parent;
            }
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
        }

        void b(@NonNull RecyclerView recyclerView) {
            this.f4092d = a(recyclerView);
            AnonymousClass1 anonymousClass1 = new ViewPager2.OnPageChangeCallback() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.1
                AnonymousClass1() {
                }

                @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                public void onPageScrollStateChanged(int i2) {
                    FragmentMaxLifecycleEnforcer.this.d(false);
                }

                @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                public void onPageSelected(int i2) {
                    FragmentMaxLifecycleEnforcer.this.d(false);
                }
            };
            this.f4089a = anonymousClass1;
            this.f4092d.registerOnPageChangeCallback(anonymousClass1);
            AnonymousClass2 anonymousClass2 = new DataSetChangeObserver() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.2
                AnonymousClass2() {
                }

                @Override // androidx.viewpager2.adapter.FragmentStateAdapter.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
                public void onChanged() {
                    FragmentMaxLifecycleEnforcer.this.d(true);
                }
            };
            this.f4090b = anonymousClass2;
            FragmentStateAdapter.this.registerAdapterDataObserver(anonymousClass2);
            AnonymousClass3 anonymousClass3 = new LifecycleEventObserver() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.3
                AnonymousClass3() {
                }

                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                    FragmentMaxLifecycleEnforcer.this.d(false);
                }
            };
            this.f4091c = anonymousClass3;
            FragmentStateAdapter.this.f4070d.addObserver(anonymousClass3);
        }

        void c(@NonNull RecyclerView recyclerView) {
            a(recyclerView).unregisterOnPageChangeCallback(this.f4089a);
            FragmentStateAdapter.this.unregisterAdapterDataObserver(this.f4090b);
            FragmentStateAdapter.this.f4070d.removeObserver(this.f4091c);
            this.f4092d = null;
        }

        void d(boolean z) {
            int currentItem;
            Fragment fragment;
            if (FragmentStateAdapter.this.N() || this.f4092d.getScrollState() != 0 || FragmentStateAdapter.this.f4072f.isEmpty() || FragmentStateAdapter.this.getItemCount() == 0 || (currentItem = this.f4092d.getCurrentItem()) >= FragmentStateAdapter.this.getItemCount()) {
                return;
            }
            long itemId = FragmentStateAdapter.this.getItemId(currentItem);
            if ((itemId != this.f4093e || z) && (fragment = FragmentStateAdapter.this.f4072f.get(itemId)) != null && fragment.isAdded()) {
                this.f4093e = itemId;
                FragmentTransaction beginTransaction = FragmentStateAdapter.this.f4071e.beginTransaction();
                Fragment fragment2 = null;
                for (int i2 = 0; i2 < FragmentStateAdapter.this.f4072f.size(); i2++) {
                    long keyAt = FragmentStateAdapter.this.f4072f.keyAt(i2);
                    Fragment valueAt = FragmentStateAdapter.this.f4072f.valueAt(i2);
                    if (valueAt.isAdded()) {
                        if (keyAt != this.f4093e) {
                            beginTransaction.setMaxLifecycle(valueAt, Lifecycle.State.STARTED);
                        } else {
                            fragment2 = valueAt;
                        }
                        valueAt.setMenuVisibility(keyAt == this.f4093e);
                    }
                }
                if (fragment2 != null) {
                    beginTransaction.setMaxLifecycle(fragment2, Lifecycle.State.RESUMED);
                }
                if (beginTransaction.isEmpty()) {
                    return;
                }
                beginTransaction.commitNow();
            }
        }
    }

    public FragmentStateAdapter(@NonNull FragmentActivity fragmentActivity) {
        this(fragmentActivity.getSupportFragmentManager(), fragmentActivity.getLifecycle());
    }

    private boolean F(long j2) {
        View view;
        if (this.f4074h.containsKey(j2)) {
            return true;
        }
        Fragment fragment = this.f4072f.get(j2);
        return (fragment == null || (view = fragment.getView()) == null || view.getParent() == null) ? false : true;
    }

    private static boolean G(@NonNull String str, @NonNull String str2) {
        return str.startsWith(str2) && str.length() > str2.length();
    }

    private Long H(int i2) {
        Long l = null;
        for (int i3 = 0; i3 < this.f4074h.size(); i3++) {
            if (this.f4074h.valueAt(i3).intValue() == i2) {
                if (l != null) {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
                l = Long.valueOf(this.f4074h.keyAt(i3));
            }
        }
        return l;
    }

    private static long I(@NonNull String str, @NonNull String str2) {
        return Long.parseLong(str.substring(str2.length()));
    }

    private void K(long j2) {
        ViewParent parent;
        Fragment fragment = this.f4072f.get(j2);
        if (fragment == null) {
            return;
        }
        if (fragment.getView() != null && (parent = fragment.getView().getParent()) != null) {
            ((FrameLayout) parent).removeAllViews();
        }
        if (!containsItem(j2)) {
            this.f4073g.remove(j2);
        }
        if (!fragment.isAdded()) {
            this.f4072f.remove(j2);
            return;
        }
        if (N()) {
            this.k = true;
            return;
        }
        if (fragment.isAdded() && containsItem(j2)) {
            this.f4073g.put(j2, this.f4071e.saveFragmentInstanceState(fragment));
        }
        this.f4071e.beginTransaction().remove(fragment).commitNow();
        this.f4072f.remove(j2);
    }

    private void L() {
        Handler handler = new Handler(Looper.getMainLooper());
        AnonymousClass4 anonymousClass4 = new Runnable() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.4
            AnonymousClass4() {
            }

            @Override // java.lang.Runnable
            public void run() {
                FragmentStateAdapter fragmentStateAdapter = FragmentStateAdapter.this;
                fragmentStateAdapter.f4076j = false;
                fragmentStateAdapter.E();
            }
        };
        this.f4070d.addObserver(new LifecycleEventObserver() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.5

            /* renamed from: a */
            final /* synthetic */ Handler f4086a;

            /* renamed from: b */
            final /* synthetic */ Runnable f4087b;

            AnonymousClass5(Handler handler2, Runnable anonymousClass42) {
                handler = handler2;
                runnable = anonymousClass42;
            }

            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    handler.removeCallbacks(runnable);
                    lifecycleOwner.getLifecycle().removeObserver(this);
                }
            }
        });
        handler2.postDelayed(anonymousClass42, f4069c);
    }

    private void M(Fragment fragment, @NonNull FrameLayout frameLayout) {
        this.f4071e.registerFragmentLifecycleCallbacks(new FragmentManager.FragmentLifecycleCallbacks() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.3

            /* renamed from: a */
            final /* synthetic */ Fragment f4082a;

            /* renamed from: b */
            final /* synthetic */ FrameLayout f4083b;

            AnonymousClass3(Fragment fragment2, FrameLayout frameLayout2) {
                fragment = fragment2;
                frameLayout = frameLayout2;
            }

            @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
            public void onFragmentViewCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment2, @NonNull View view, @Nullable Bundle bundle) {
                if (fragment2 == fragment) {
                    fragmentManager.unregisterFragmentLifecycleCallbacks(this);
                    FragmentStateAdapter.this.b(view, frameLayout);
                }
            }
        }, false);
    }

    @NonNull
    private static String c(@NonNull String str, long j2) {
        return str + j2;
    }

    private void n(int i2) {
        long itemId = getItemId(i2);
        if (this.f4072f.containsKey(itemId)) {
            return;
        }
        Fragment createFragment = createFragment(i2);
        createFragment.setInitialSavedState(this.f4073g.get(itemId));
        this.f4072f.put(itemId, createFragment);
    }

    void E() {
        if (!this.k || N()) {
            return;
        }
        ArraySet arraySet = new ArraySet();
        for (int i2 = 0; i2 < this.f4072f.size(); i2++) {
            long keyAt = this.f4072f.keyAt(i2);
            if (!containsItem(keyAt)) {
                arraySet.add(Long.valueOf(keyAt));
                this.f4074h.remove(keyAt);
            }
        }
        if (!this.f4076j) {
            this.k = false;
            for (int i3 = 0; i3 < this.f4072f.size(); i3++) {
                long keyAt2 = this.f4072f.keyAt(i3);
                if (!F(keyAt2)) {
                    arraySet.add(Long.valueOf(keyAt2));
                }
            }
        }
        Iterator<E> it = arraySet.iterator();
        while (it.hasNext()) {
            K(((Long) it.next()).longValue());
        }
    }

    void J(@NonNull FragmentViewHolder fragmentViewHolder) {
        Fragment fragment = this.f4072f.get(fragmentViewHolder.getItemId());
        if (fragment == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        FrameLayout B = fragmentViewHolder.B();
        View view = fragment.getView();
        if (!fragment.isAdded() && view != null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (fragment.isAdded() && view == null) {
            M(fragment, B);
            return;
        }
        if (fragment.isAdded() && view.getParent() != null) {
            if (view.getParent() != B) {
                b(view, B);
                return;
            }
            return;
        }
        if (fragment.isAdded()) {
            b(view, B);
            return;
        }
        if (N()) {
            if (this.f4071e.isDestroyed()) {
                return;
            }
            this.f4070d.addObserver(new LifecycleEventObserver() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.2

                /* renamed from: a */
                final /* synthetic */ FragmentViewHolder f4080a;

                AnonymousClass2(FragmentViewHolder fragmentViewHolder2) {
                    fragmentViewHolder = fragmentViewHolder2;
                }

                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                    if (FragmentStateAdapter.this.N()) {
                        return;
                    }
                    lifecycleOwner.getLifecycle().removeObserver(this);
                    if (ViewCompat.isAttachedToWindow(fragmentViewHolder.B())) {
                        FragmentStateAdapter.this.J(fragmentViewHolder);
                    }
                }
            });
            return;
        }
        M(fragment, B);
        this.f4071e.beginTransaction().add(fragment, "f" + fragmentViewHolder2.getItemId()).setMaxLifecycle(fragment, Lifecycle.State.STARTED).commitNow();
        this.f4075i.d(false);
    }

    boolean N() {
        return this.f4071e.isStateSaved();
    }

    void b(@NonNull View view, @NonNull FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (view.getParent() == frameLayout) {
            return;
        }
        if (frameLayout.getChildCount() > 0) {
            frameLayout.removeAllViews();
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        frameLayout.addView(view);
    }

    public boolean containsItem(long j2) {
        return j2 >= 0 && j2 < ((long) getItemCount());
    }

    @NonNull
    public abstract Fragment createFragment(int i2);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @CallSuper
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        Preconditions.checkArgument(this.f4075i == null);
        FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer = new FragmentMaxLifecycleEnforcer();
        this.f4075i = fragmentMaxLifecycleEnforcer;
        fragmentMaxLifecycleEnforcer.b(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @CallSuper
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        this.f4075i.c(recyclerView);
        this.f4075i = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final boolean onFailedToRecycleView(@NonNull FragmentViewHolder fragmentViewHolder) {
        return true;
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    public final void restoreState(@NonNull Parcelable parcelable) {
        if (!this.f4073g.isEmpty() || !this.f4072f.isEmpty()) {
            throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
        }
        Bundle bundle = (Bundle) parcelable;
        if (bundle.getClassLoader() == null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        for (String str : bundle.keySet()) {
            if (G(str, f4067a)) {
                this.f4072f.put(I(str, f4067a), this.f4071e.getFragment(bundle, str));
            } else {
                if (!G(str, f4068b)) {
                    throw new IllegalArgumentException("Unexpected key in savedState: " + str);
                }
                long I = I(str, f4068b);
                Fragment.SavedState savedState = (Fragment.SavedState) bundle.getParcelable(str);
                if (containsItem(I)) {
                    this.f4073g.put(I, savedState);
                }
            }
        }
        if (this.f4072f.isEmpty()) {
            return;
        }
        this.k = true;
        this.f4076j = true;
        E();
        L();
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    @NonNull
    public final Parcelable saveState() {
        Bundle bundle = new Bundle(this.f4072f.size() + this.f4073g.size());
        for (int i2 = 0; i2 < this.f4072f.size(); i2++) {
            long keyAt = this.f4072f.keyAt(i2);
            Fragment fragment = this.f4072f.get(keyAt);
            if (fragment != null && fragment.isAdded()) {
                this.f4071e.putFragment(bundle, c(f4067a, keyAt), fragment);
            }
        }
        for (int i3 = 0; i3 < this.f4073g.size(); i3++) {
            long keyAt2 = this.f4073g.keyAt(i3);
            if (containsItem(keyAt2)) {
                bundle.putParcelable(c(f4068b, keyAt2), this.f4073g.get(keyAt2));
            }
        }
        return bundle;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void setHasStableIds(boolean z) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    public FragmentStateAdapter(@NonNull Fragment fragment) {
        this(fragment.getChildFragmentManager(), fragment.getLifecycle());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(@NonNull FragmentViewHolder fragmentViewHolder, int i2) {
        long itemId = fragmentViewHolder.getItemId();
        int id = fragmentViewHolder.B().getId();
        Long H = H(id);
        if (H != null && H.longValue() != itemId) {
            K(H.longValue());
            this.f4074h.remove(H.longValue());
        }
        this.f4074h.put(itemId, Integer.valueOf(id));
        n(i2);
        FrameLayout B = fragmentViewHolder.B();
        if (ViewCompat.isAttachedToWindow(B)) {
            if (B.getParent() != null) {
                throw new IllegalStateException("Design assumption violated.");
            }
            B.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.1

                /* renamed from: a */
                final /* synthetic */ FrameLayout f4077a;

                /* renamed from: b */
                final /* synthetic */ FragmentViewHolder f4078b;

                AnonymousClass1(FrameLayout B2, FragmentViewHolder fragmentViewHolder2) {
                    B = B2;
                    fragmentViewHolder = fragmentViewHolder2;
                }

                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i22, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                    if (B.getParent() != null) {
                        B.removeOnLayoutChangeListener(this);
                        FragmentStateAdapter.this.J(fragmentViewHolder);
                    }
                }
            });
        }
        E();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public final FragmentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return FragmentViewHolder.a(viewGroup);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(@NonNull FragmentViewHolder fragmentViewHolder) {
        J(fragmentViewHolder);
        E();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(@NonNull FragmentViewHolder fragmentViewHolder) {
        Long H = H(fragmentViewHolder.B().getId());
        if (H != null) {
            K(H.longValue());
            this.f4074h.remove(H.longValue());
        }
    }

    public FragmentStateAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        this.f4072f = new LongSparseArray<>();
        this.f4073g = new LongSparseArray<>();
        this.f4074h = new LongSparseArray<>();
        this.f4076j = false;
        this.k = false;
        this.f4071e = fragmentManager;
        this.f4070d = lifecycle;
        super.setHasStableIds(true);
    }
}
