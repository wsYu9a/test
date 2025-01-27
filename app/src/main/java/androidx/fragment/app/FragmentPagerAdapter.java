package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;

/* loaded from: classes.dex */
public abstract class FragmentPagerAdapter extends PagerAdapter {
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;

    @Deprecated
    public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;

    /* renamed from: a */
    private static final String f2406a = "FragmentPagerAdapter";

    /* renamed from: b */
    private static final boolean f2407b = false;

    /* renamed from: c */
    private final FragmentManager f2408c;

    /* renamed from: d */
    private final int f2409d;

    /* renamed from: e */
    private FragmentTransaction f2410e;

    /* renamed from: f */
    private Fragment f2411f;

    @Deprecated
    public FragmentPagerAdapter(@NonNull FragmentManager fragmentManager) {
        this(fragmentManager, 0);
    }

    private static String a(int i2, long j2) {
        return "android:switcher:" + i2 + ":" + j2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f2410e == null) {
            this.f2410e = this.f2408c.beginTransaction();
        }
        this.f2410e.detach(fragment);
        if (fragment == this.f2411f) {
            this.f2411f = null;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(@NonNull ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.f2410e;
        if (fragmentTransaction != null) {
            fragmentTransaction.commitNowAllowingStateLoss();
            this.f2410e = null;
        }
    }

    @NonNull
    public abstract Fragment getItem(int i2);

    public long getItemId(int i2) {
        return i2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i2) {
        if (this.f2410e == null) {
            this.f2410e = this.f2408c.beginTransaction();
        }
        long itemId = getItemId(i2);
        Fragment findFragmentByTag = this.f2408c.findFragmentByTag(a(viewGroup.getId(), itemId));
        if (findFragmentByTag != null) {
            this.f2410e.attach(findFragmentByTag);
        } else {
            findFragmentByTag = getItem(i2);
            this.f2410e.add(viewGroup.getId(), findFragmentByTag, a(viewGroup.getId(), itemId));
        }
        if (findFragmentByTag != this.f2411f) {
            findFragmentByTag.setMenuVisibility(false);
            if (this.f2409d == 1) {
                this.f2410e.setMaxLifecycle(findFragmentByTag, Lifecycle.State.STARTED);
            } else {
                findFragmentByTag.setUserVisibleHint(false);
            }
        }
        return findFragmentByTag;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(@Nullable Parcelable parcelable, @Nullable ClassLoader classLoader) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @Nullable
    public Parcelable saveState() {
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f2411f;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.f2409d == 1) {
                    if (this.f2410e == null) {
                        this.f2410e = this.f2408c.beginTransaction();
                    }
                    this.f2410e.setMaxLifecycle(this.f2411f, Lifecycle.State.STARTED);
                } else {
                    this.f2411f.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.f2409d == 1) {
                if (this.f2410e == null) {
                    this.f2410e = this.f2408c.beginTransaction();
                }
                this.f2410e.setMaxLifecycle(fragment, Lifecycle.State.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.f2411f = fragment;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(@NonNull ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    public FragmentPagerAdapter(@NonNull FragmentManager fragmentManager, int i2) {
        this.f2410e = null;
        this.f2411f = null;
        this.f2408c = fragmentManager;
        this.f2409d = i2;
    }
}
