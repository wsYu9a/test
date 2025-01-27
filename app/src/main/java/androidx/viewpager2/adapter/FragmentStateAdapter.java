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
    private static final long GRACE_WINDOW_TIME_MS = 10000;
    private static final String KEY_PREFIX_FRAGMENT = "f#";
    private static final String KEY_PREFIX_STATE = "s#";
    final FragmentManager mFragmentManager;
    private FragmentMaxLifecycleEnforcer mFragmentMaxLifecycleEnforcer;
    final LongSparseArray<Fragment> mFragments;
    private boolean mHasStaleFragments;
    boolean mIsInGracePeriod;
    private final LongSparseArray<Integer> mItemIdToViewHolder;
    final Lifecycle mLifecycle;
    private final LongSparseArray<Fragment.SavedState> mSavedStates;

    /* renamed from: androidx.viewpager2.adapter.FragmentStateAdapter$1 */
    public class AnonymousClass1 implements View.OnLayoutChangeListener {
        final /* synthetic */ FrameLayout val$container;
        final /* synthetic */ FragmentViewHolder val$holder;

        public AnonymousClass1(FrameLayout frameLayout, FragmentViewHolder fragmentViewHolder) {
            container = frameLayout;
            fragmentViewHolder = fragmentViewHolder;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            if (container.getParent() != null) {
                container.removeOnLayoutChangeListener(this);
                FragmentStateAdapter.this.placeFragmentInViewHolder(fragmentViewHolder);
            }
        }
    }

    /* renamed from: androidx.viewpager2.adapter.FragmentStateAdapter$2 */
    public class AnonymousClass2 implements LifecycleEventObserver {
        final /* synthetic */ FragmentViewHolder val$holder;

        public AnonymousClass2(FragmentViewHolder fragmentViewHolder) {
            fragmentViewHolder = fragmentViewHolder;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
            if (FragmentStateAdapter.this.shouldDelayFragmentTransactions()) {
                return;
            }
            lifecycleOwner.getLifecycle().removeObserver(this);
            if (ViewCompat.isAttachedToWindow(fragmentViewHolder.getContainer())) {
                FragmentStateAdapter.this.placeFragmentInViewHolder(fragmentViewHolder);
            }
        }
    }

    /* renamed from: androidx.viewpager2.adapter.FragmentStateAdapter$3 */
    public class AnonymousClass3 extends FragmentManager.FragmentLifecycleCallbacks {
        final /* synthetic */ FrameLayout val$container;
        final /* synthetic */ Fragment val$fragment;

        public AnonymousClass3(Fragment fragment, FrameLayout frameLayout) {
            fragment = fragment;
            frameLayout = frameLayout;
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentViewCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull View view, @Nullable Bundle bundle) {
            if (fragment == fragment) {
                fragmentManager.unregisterFragmentLifecycleCallbacks(this);
                FragmentStateAdapter.this.addViewToContainer(view, frameLayout);
            }
        }
    }

    /* renamed from: androidx.viewpager2.adapter.FragmentStateAdapter$4 */
    public class AnonymousClass4 implements Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentStateAdapter fragmentStateAdapter = FragmentStateAdapter.this;
            fragmentStateAdapter.mIsInGracePeriod = false;
            fragmentStateAdapter.gcFragments();
        }
    }

    /* renamed from: androidx.viewpager2.adapter.FragmentStateAdapter$5 */
    public class AnonymousClass5 implements LifecycleEventObserver {
        final /* synthetic */ Handler val$handler;
        final /* synthetic */ Runnable val$runnable;

        public AnonymousClass5(Handler handler, Runnable runnable) {
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

    public static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
        private DataSetChangeObserver() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public abstract void onChanged();

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i10, int i11) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int i10, int i11) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int i10, int i11, int i12) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int i10, int i11) {
            onChanged();
        }

        public /* synthetic */ DataSetChangeObserver(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i10, int i11, @Nullable Object obj) {
            onChanged();
        }
    }

    public class FragmentMaxLifecycleEnforcer {
        private RecyclerView.AdapterDataObserver mDataObserver;
        private LifecycleEventObserver mLifecycleObserver;
        private ViewPager2.OnPageChangeCallback mPageChangeCallback;
        private long mPrimaryItemId = -1;
        private ViewPager2 mViewPager;

        /* renamed from: androidx.viewpager2.adapter.FragmentStateAdapter$FragmentMaxLifecycleEnforcer$1 */
        public class AnonymousClass1 extends ViewPager2.OnPageChangeCallback {
            public AnonymousClass1() {
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i10) {
                FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(false);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i10) {
                FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(false);
            }
        }

        /* renamed from: androidx.viewpager2.adapter.FragmentStateAdapter$FragmentMaxLifecycleEnforcer$2 */
        public class AnonymousClass2 extends DataSetChangeObserver {
            public AnonymousClass2() {
            }

            @Override // androidx.viewpager2.adapter.FragmentStateAdapter.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(true);
            }
        }

        /* renamed from: androidx.viewpager2.adapter.FragmentStateAdapter$FragmentMaxLifecycleEnforcer$3 */
        public class AnonymousClass3 implements LifecycleEventObserver {
            public AnonymousClass3() {
            }

            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(false);
            }
        }

        public FragmentMaxLifecycleEnforcer() {
        }

        @NonNull
        private ViewPager2 inferViewPager(@NonNull RecyclerView recyclerView) {
            ViewParent parent = recyclerView.getParent();
            if (parent instanceof ViewPager2) {
                return (ViewPager2) parent;
            }
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
        }

        public void register(@NonNull RecyclerView recyclerView) {
            this.mViewPager = inferViewPager(recyclerView);
            AnonymousClass1 anonymousClass1 = new ViewPager2.OnPageChangeCallback() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.1
                public AnonymousClass1() {
                }

                @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                public void onPageScrollStateChanged(int i10) {
                    FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(false);
                }

                @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                public void onPageSelected(int i10) {
                    FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(false);
                }
            };
            this.mPageChangeCallback = anonymousClass1;
            this.mViewPager.registerOnPageChangeCallback(anonymousClass1);
            AnonymousClass2 anonymousClass2 = new DataSetChangeObserver() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.2
                public AnonymousClass2() {
                }

                @Override // androidx.viewpager2.adapter.FragmentStateAdapter.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
                public void onChanged() {
                    FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(true);
                }
            };
            this.mDataObserver = anonymousClass2;
            FragmentStateAdapter.this.registerAdapterDataObserver(anonymousClass2);
            AnonymousClass3 anonymousClass3 = new LifecycleEventObserver() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.FragmentMaxLifecycleEnforcer.3
                public AnonymousClass3() {
                }

                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                    FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(false);
                }
            };
            this.mLifecycleObserver = anonymousClass3;
            FragmentStateAdapter.this.mLifecycle.addObserver(anonymousClass3);
        }

        public void unregister(@NonNull RecyclerView recyclerView) {
            inferViewPager(recyclerView).unregisterOnPageChangeCallback(this.mPageChangeCallback);
            FragmentStateAdapter.this.unregisterAdapterDataObserver(this.mDataObserver);
            FragmentStateAdapter.this.mLifecycle.removeObserver(this.mLifecycleObserver);
            this.mViewPager = null;
        }

        public void updateFragmentMaxLifecycle(boolean z10) {
            int currentItem;
            Fragment fragment;
            if (FragmentStateAdapter.this.shouldDelayFragmentTransactions() || this.mViewPager.getScrollState() != 0 || FragmentStateAdapter.this.mFragments.isEmpty() || FragmentStateAdapter.this.getPageSize() == 0 || (currentItem = this.mViewPager.getCurrentItem()) >= FragmentStateAdapter.this.getPageSize()) {
                return;
            }
            long itemId = FragmentStateAdapter.this.getItemId(currentItem);
            if ((itemId != this.mPrimaryItemId || z10) && (fragment = FragmentStateAdapter.this.mFragments.get(itemId)) != null && fragment.isAdded()) {
                this.mPrimaryItemId = itemId;
                FragmentTransaction beginTransaction = FragmentStateAdapter.this.mFragmentManager.beginTransaction();
                Fragment fragment2 = null;
                for (int i10 = 0; i10 < FragmentStateAdapter.this.mFragments.size(); i10++) {
                    long keyAt = FragmentStateAdapter.this.mFragments.keyAt(i10);
                    Fragment valueAt = FragmentStateAdapter.this.mFragments.valueAt(i10);
                    if (valueAt.isAdded()) {
                        if (keyAt != this.mPrimaryItemId) {
                            beginTransaction.setMaxLifecycle(valueAt, Lifecycle.State.STARTED);
                        } else {
                            fragment2 = valueAt;
                        }
                        valueAt.setMenuVisibility(keyAt == this.mPrimaryItemId);
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

    @NonNull
    private static String createKey(@NonNull String str, long j10) {
        return str + j10;
    }

    private void ensureFragment(int i10) {
        long itemId = getItemId(i10);
        if (this.mFragments.containsKey(itemId)) {
            return;
        }
        Fragment createFragment = createFragment(i10);
        createFragment.setInitialSavedState(this.mSavedStates.get(itemId));
        this.mFragments.put(itemId, createFragment);
    }

    private boolean isFragmentViewBound(long j10) {
        View view;
        if (this.mItemIdToViewHolder.containsKey(j10)) {
            return true;
        }
        Fragment fragment = this.mFragments.get(j10);
        return (fragment == null || (view = fragment.getView()) == null || view.getParent() == null) ? false : true;
    }

    private static boolean isValidKey(@NonNull String str, @NonNull String str2) {
        return str.startsWith(str2) && str.length() > str2.length();
    }

    private Long itemForViewHolder(int i10) {
        Long l10 = null;
        for (int i11 = 0; i11 < this.mItemIdToViewHolder.size(); i11++) {
            if (this.mItemIdToViewHolder.valueAt(i11).intValue() == i10) {
                if (l10 != null) {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
                l10 = Long.valueOf(this.mItemIdToViewHolder.keyAt(i11));
            }
        }
        return l10;
    }

    private static long parseIdFromKey(@NonNull String str, @NonNull String str2) {
        return Long.parseLong(str.substring(str2.length()));
    }

    private void removeFragment(long j10) {
        ViewParent parent;
        Fragment fragment = this.mFragments.get(j10);
        if (fragment == null) {
            return;
        }
        if (fragment.getView() != null && (parent = fragment.getView().getParent()) != null) {
            ((FrameLayout) parent).removeAllViews();
        }
        if (!containsItem(j10)) {
            this.mSavedStates.remove(j10);
        }
        if (!fragment.isAdded()) {
            this.mFragments.remove(j10);
            return;
        }
        if (shouldDelayFragmentTransactions()) {
            this.mHasStaleFragments = true;
            return;
        }
        if (fragment.isAdded() && containsItem(j10)) {
            this.mSavedStates.put(j10, this.mFragmentManager.saveFragmentInstanceState(fragment));
        }
        this.mFragmentManager.beginTransaction().remove(fragment).commitNow();
        this.mFragments.remove(j10);
    }

    private void scheduleGracePeriodEnd() {
        Handler handler = new Handler(Looper.getMainLooper());
        AnonymousClass4 anonymousClass4 = new Runnable() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.4
            public AnonymousClass4() {
            }

            @Override // java.lang.Runnable
            public void run() {
                FragmentStateAdapter fragmentStateAdapter = FragmentStateAdapter.this;
                fragmentStateAdapter.mIsInGracePeriod = false;
                fragmentStateAdapter.gcFragments();
            }
        };
        this.mLifecycle.addObserver(new LifecycleEventObserver() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.5
            final /* synthetic */ Handler val$handler;
            final /* synthetic */ Runnable val$runnable;

            public AnonymousClass5(Handler handler2, Runnable anonymousClass42) {
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
        handler2.postDelayed(anonymousClass42, 10000L);
    }

    private void scheduleViewAttach(Fragment fragment, @NonNull FrameLayout frameLayout) {
        this.mFragmentManager.registerFragmentLifecycleCallbacks(new FragmentManager.FragmentLifecycleCallbacks() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.3
            final /* synthetic */ FrameLayout val$container;
            final /* synthetic */ Fragment val$fragment;

            public AnonymousClass3(Fragment fragment2, FrameLayout frameLayout2) {
                fragment = fragment2;
                frameLayout = frameLayout2;
            }

            @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
            public void onFragmentViewCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment2, @NonNull View view, @Nullable Bundle bundle) {
                if (fragment2 == fragment) {
                    fragmentManager.unregisterFragmentLifecycleCallbacks(this);
                    FragmentStateAdapter.this.addViewToContainer(view, frameLayout);
                }
            }
        }, false);
    }

    public void addViewToContainer(@NonNull View view, @NonNull FrameLayout frameLayout) {
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

    public boolean containsItem(long j10) {
        return j10 >= 0 && j10 < ((long) getPageSize());
    }

    @NonNull
    public abstract Fragment createFragment(int i10);

    public void gcFragments() {
        if (!this.mHasStaleFragments || shouldDelayFragmentTransactions()) {
            return;
        }
        ArraySet arraySet = new ArraySet();
        for (int i10 = 0; i10 < this.mFragments.size(); i10++) {
            long keyAt = this.mFragments.keyAt(i10);
            if (!containsItem(keyAt)) {
                arraySet.add(Long.valueOf(keyAt));
                this.mItemIdToViewHolder.remove(keyAt);
            }
        }
        if (!this.mIsInGracePeriod) {
            this.mHasStaleFragments = false;
            for (int i11 = 0; i11 < this.mFragments.size(); i11++) {
                long keyAt2 = this.mFragments.keyAt(i11);
                if (!isFragmentViewBound(keyAt2)) {
                    arraySet.add(Long.valueOf(keyAt2));
                }
            }
        }
        Iterator<E> it = arraySet.iterator();
        while (it.hasNext()) {
            removeFragment(((Long) it.next()).longValue());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @CallSuper
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        Preconditions.checkArgument(this.mFragmentMaxLifecycleEnforcer == null);
        FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer = new FragmentMaxLifecycleEnforcer();
        this.mFragmentMaxLifecycleEnforcer = fragmentMaxLifecycleEnforcer;
        fragmentMaxLifecycleEnforcer.register(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @CallSuper
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        this.mFragmentMaxLifecycleEnforcer.unregister(recyclerView);
        this.mFragmentMaxLifecycleEnforcer = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final boolean onFailedToRecycleView(@NonNull FragmentViewHolder fragmentViewHolder) {
        return true;
    }

    public void placeFragmentInViewHolder(@NonNull FragmentViewHolder fragmentViewHolder) {
        Fragment fragment = this.mFragments.get(fragmentViewHolder.getItemId());
        if (fragment == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        FrameLayout container = fragmentViewHolder.getContainer();
        View view = fragment.getView();
        if (!fragment.isAdded() && view != null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (fragment.isAdded() && view == null) {
            scheduleViewAttach(fragment, container);
            return;
        }
        if (fragment.isAdded() && view.getParent() != null) {
            if (view.getParent() != container) {
                addViewToContainer(view, container);
                return;
            }
            return;
        }
        if (fragment.isAdded()) {
            addViewToContainer(view, container);
            return;
        }
        if (shouldDelayFragmentTransactions()) {
            if (this.mFragmentManager.isDestroyed()) {
                return;
            }
            this.mLifecycle.addObserver(new LifecycleEventObserver() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.2
                final /* synthetic */ FragmentViewHolder val$holder;

                public AnonymousClass2(FragmentViewHolder fragmentViewHolder2) {
                    fragmentViewHolder = fragmentViewHolder2;
                }

                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                    if (FragmentStateAdapter.this.shouldDelayFragmentTransactions()) {
                        return;
                    }
                    lifecycleOwner.getLifecycle().removeObserver(this);
                    if (ViewCompat.isAttachedToWindow(fragmentViewHolder.getContainer())) {
                        FragmentStateAdapter.this.placeFragmentInViewHolder(fragmentViewHolder);
                    }
                }
            });
            return;
        }
        scheduleViewAttach(fragment, container);
        this.mFragmentManager.beginTransaction().add(fragment, "f" + fragmentViewHolder2.getItemId()).setMaxLifecycle(fragment, Lifecycle.State.STARTED).commitNow();
        this.mFragmentMaxLifecycleEnforcer.updateFragmentMaxLifecycle(false);
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    public final void restoreState(@NonNull Parcelable parcelable) {
        if (!this.mSavedStates.isEmpty() || !this.mFragments.isEmpty()) {
            throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
        }
        Bundle bundle = (Bundle) parcelable;
        if (bundle.getClassLoader() == null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        for (String str : bundle.keySet()) {
            if (isValidKey(str, KEY_PREFIX_FRAGMENT)) {
                this.mFragments.put(parseIdFromKey(str, KEY_PREFIX_FRAGMENT), this.mFragmentManager.getFragment(bundle, str));
            } else {
                if (!isValidKey(str, KEY_PREFIX_STATE)) {
                    throw new IllegalArgumentException("Unexpected key in savedState: " + str);
                }
                long parseIdFromKey = parseIdFromKey(str, KEY_PREFIX_STATE);
                Fragment.SavedState savedState = (Fragment.SavedState) bundle.getParcelable(str);
                if (containsItem(parseIdFromKey)) {
                    this.mSavedStates.put(parseIdFromKey, savedState);
                }
            }
        }
        if (this.mFragments.isEmpty()) {
            return;
        }
        this.mHasStaleFragments = true;
        this.mIsInGracePeriod = true;
        gcFragments();
        scheduleGracePeriodEnd();
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    @NonNull
    public final Parcelable saveState() {
        Bundle bundle = new Bundle(this.mFragments.size() + this.mSavedStates.size());
        for (int i10 = 0; i10 < this.mFragments.size(); i10++) {
            long keyAt = this.mFragments.keyAt(i10);
            Fragment fragment = this.mFragments.get(keyAt);
            if (fragment != null && fragment.isAdded()) {
                this.mFragmentManager.putFragment(bundle, createKey(KEY_PREFIX_FRAGMENT, keyAt), fragment);
            }
        }
        for (int i11 = 0; i11 < this.mSavedStates.size(); i11++) {
            long keyAt2 = this.mSavedStates.keyAt(i11);
            if (containsItem(keyAt2)) {
                bundle.putParcelable(createKey(KEY_PREFIX_STATE, keyAt2), this.mSavedStates.get(keyAt2));
            }
        }
        return bundle;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void setHasStableIds(boolean z10) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    public boolean shouldDelayFragmentTransactions() {
        return this.mFragmentManager.isStateSaved();
    }

    public FragmentStateAdapter(@NonNull Fragment fragment) {
        this(fragment.getChildFragmentManager(), fragment.getLifecycle());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(@NonNull FragmentViewHolder fragmentViewHolder, int i10) {
        long itemId = fragmentViewHolder.getItemId();
        int id2 = fragmentViewHolder.getContainer().getId();
        Long itemForViewHolder = itemForViewHolder(id2);
        if (itemForViewHolder != null && itemForViewHolder.longValue() != itemId) {
            removeFragment(itemForViewHolder.longValue());
            this.mItemIdToViewHolder.remove(itemForViewHolder.longValue());
        }
        this.mItemIdToViewHolder.put(itemId, Integer.valueOf(id2));
        ensureFragment(i10);
        FrameLayout container = fragmentViewHolder.getContainer();
        if (ViewCompat.isAttachedToWindow(container)) {
            if (container.getParent() != null) {
                throw new IllegalStateException("Design assumption violated.");
            }
            container.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter.1
                final /* synthetic */ FrameLayout val$container;
                final /* synthetic */ FragmentViewHolder val$holder;

                public AnonymousClass1(FrameLayout container2, FragmentViewHolder fragmentViewHolder2) {
                    container = container2;
                    fragmentViewHolder = fragmentViewHolder2;
                }

                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i102, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                    if (container.getParent() != null) {
                        container.removeOnLayoutChangeListener(this);
                        FragmentStateAdapter.this.placeFragmentInViewHolder(fragmentViewHolder);
                    }
                }
            });
        }
        gcFragments();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public final FragmentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i10) {
        return FragmentViewHolder.create(viewGroup);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(@NonNull FragmentViewHolder fragmentViewHolder) {
        placeFragmentInViewHolder(fragmentViewHolder);
        gcFragments();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(@NonNull FragmentViewHolder fragmentViewHolder) {
        Long itemForViewHolder = itemForViewHolder(fragmentViewHolder.getContainer().getId());
        if (itemForViewHolder != null) {
            removeFragment(itemForViewHolder.longValue());
            this.mItemIdToViewHolder.remove(itemForViewHolder.longValue());
        }
    }

    public FragmentStateAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        this.mFragments = new LongSparseArray<>();
        this.mSavedStates = new LongSparseArray<>();
        this.mItemIdToViewHolder = new LongSparseArray<>();
        this.mIsInGracePeriod = false;
        this.mHasStaleFragments = false;
        this.mFragmentManager = fragmentManager;
        this.mLifecycle = lifecycle;
        super.setHasStableIds(true);
    }
}
