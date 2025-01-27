package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class FragmentStatePagerAdapter extends PagerAdapter {
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;

    @Deprecated
    public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;

    /* renamed from: a */
    private static final String f2422a = "FragmentStatePagerAdapt";

    /* renamed from: b */
    private static final boolean f2423b = false;

    /* renamed from: c */
    private final FragmentManager f2424c;

    /* renamed from: d */
    private final int f2425d;

    /* renamed from: e */
    private FragmentTransaction f2426e;

    /* renamed from: f */
    private ArrayList<Fragment.SavedState> f2427f;

    /* renamed from: g */
    private ArrayList<Fragment> f2428g;

    /* renamed from: h */
    private Fragment f2429h;

    @Deprecated
    public FragmentStatePagerAdapter(@NonNull FragmentManager fragmentManager) {
        this(fragmentManager, 0);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f2426e == null) {
            this.f2426e = this.f2424c.beginTransaction();
        }
        while (this.f2427f.size() <= i2) {
            this.f2427f.add(null);
        }
        this.f2427f.set(i2, fragment.isAdded() ? this.f2424c.saveFragmentInstanceState(fragment) : null);
        this.f2428g.set(i2, null);
        this.f2426e.remove(fragment);
        if (fragment == this.f2429h) {
            this.f2429h = null;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(@NonNull ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.f2426e;
        if (fragmentTransaction != null) {
            fragmentTransaction.commitNowAllowingStateLoss();
            this.f2426e = null;
        }
    }

    @NonNull
    public abstract Fragment getItem(int i2);

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i2) {
        Fragment.SavedState savedState;
        Fragment fragment;
        if (this.f2428g.size() > i2 && (fragment = this.f2428g.get(i2)) != null) {
            return fragment;
        }
        if (this.f2426e == null) {
            this.f2426e = this.f2424c.beginTransaction();
        }
        Fragment item = getItem(i2);
        if (this.f2427f.size() > i2 && (savedState = this.f2427f.get(i2)) != null) {
            item.setInitialSavedState(savedState);
        }
        while (this.f2428g.size() <= i2) {
            this.f2428g.add(null);
        }
        item.setMenuVisibility(false);
        if (this.f2425d == 0) {
            item.setUserVisibleHint(false);
        }
        this.f2428g.set(i2, item);
        this.f2426e.add(viewGroup.getId(), item);
        if (this.f2425d == 1) {
            this.f2426e.setMaxLifecycle(item, Lifecycle.State.STARTED);
        }
        return item;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(@Nullable Parcelable parcelable, @Nullable ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f2427f.clear();
            this.f2428g.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f2427f.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment fragment = this.f2424c.getFragment(bundle, str);
                    if (fragment != null) {
                        while (this.f2428g.size() <= parseInt) {
                            this.f2428g.add(null);
                        }
                        fragment.setMenuVisibility(false);
                        this.f2428g.set(parseInt, fragment);
                    } else {
                        Log.w(f2422a, "Bad fragment at key " + str);
                    }
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @Nullable
    public Parcelable saveState() {
        Bundle bundle;
        if (this.f2427f.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.f2427f.size()];
            this.f2427f.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        } else {
            bundle = null;
        }
        for (int i2 = 0; i2 < this.f2428g.size(); i2++) {
            Fragment fragment = this.f2428g.get(i2);
            if (fragment != null && fragment.isAdded()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.f2424c.putFragment(bundle, "f" + i2, fragment);
            }
        }
        return bundle;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f2429h;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.f2425d == 1) {
                    if (this.f2426e == null) {
                        this.f2426e = this.f2424c.beginTransaction();
                    }
                    this.f2426e.setMaxLifecycle(this.f2429h, Lifecycle.State.STARTED);
                } else {
                    this.f2429h.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.f2425d == 1) {
                if (this.f2426e == null) {
                    this.f2426e = this.f2424c.beginTransaction();
                }
                this.f2426e.setMaxLifecycle(fragment, Lifecycle.State.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.f2429h = fragment;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(@NonNull ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    public FragmentStatePagerAdapter(@NonNull FragmentManager fragmentManager, int i2) {
        this.f2426e = null;
        this.f2427f = new ArrayList<>();
        this.f2428g = new ArrayList<>();
        this.f2429h = null;
        this.f2424c = fragmentManager;
        this.f2425d = i2;
    }
}
