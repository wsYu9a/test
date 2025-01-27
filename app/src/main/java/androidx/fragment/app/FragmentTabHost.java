package androidx.fragment.app;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

@Deprecated
/* loaded from: classes.dex */
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {

    /* renamed from: a */
    private final ArrayList<TabInfo> f2430a;

    /* renamed from: b */
    private FrameLayout f2431b;

    /* renamed from: c */
    private Context f2432c;

    /* renamed from: d */
    private FragmentManager f2433d;

    /* renamed from: e */
    private int f2434e;

    /* renamed from: f */
    private TabHost.OnTabChangeListener f2435f;

    /* renamed from: g */
    private TabInfo f2436g;

    /* renamed from: h */
    private boolean f2437h;

    static class DummyTabFactory implements TabHost.TabContentFactory {

        /* renamed from: a */
        private final Context f2438a;

        public DummyTabFactory(Context context) {
            this.f2438a = context;
        }

        @Override // android.widget.TabHost.TabContentFactory
        public View createTabContent(String str) {
            View view = new View(this.f2438a);
            view.setMinimumWidth(0);
            view.setMinimumHeight(0);
            return view;
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.fragment.app.FragmentTabHost.SavedState.1
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };

        /* renamed from: a */
        String f2439a;

        /* renamed from: androidx.fragment.app.FragmentTabHost$SavedState$1 */
        static class AnonymousClass1 implements Parcelable.Creator<SavedState> {
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f2439a + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.f2439a);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f2439a = parcel.readString();
        }
    }

    static final class TabInfo {

        /* renamed from: a */
        @NonNull
        final String f2440a;

        /* renamed from: b */
        @NonNull
        final Class<?> f2441b;

        /* renamed from: c */
        @Nullable
        final Bundle f2442c;

        /* renamed from: d */
        Fragment f2443d;

        TabInfo(@NonNull String str, @NonNull Class<?> cls, @Nullable Bundle bundle) {
            this.f2440a = str;
            this.f2441b = cls;
            this.f2442c = bundle;
        }
    }

    @Deprecated
    public FragmentTabHost(@NonNull Context context) {
        super(context, null);
        this.f2430a = new ArrayList<>();
        e(context, null);
    }

    @Nullable
    private FragmentTransaction a(@Nullable String str, @Nullable FragmentTransaction fragmentTransaction) {
        Fragment fragment;
        TabInfo d2 = d(str);
        if (this.f2436g != d2) {
            if (fragmentTransaction == null) {
                fragmentTransaction = this.f2433d.beginTransaction();
            }
            TabInfo tabInfo = this.f2436g;
            if (tabInfo != null && (fragment = tabInfo.f2443d) != null) {
                fragmentTransaction.detach(fragment);
            }
            if (d2 != null) {
                Fragment fragment2 = d2.f2443d;
                if (fragment2 == null) {
                    Fragment instantiate = this.f2433d.getFragmentFactory().instantiate(this.f2432c.getClassLoader(), d2.f2441b.getName());
                    d2.f2443d = instantiate;
                    instantiate.setArguments(d2.f2442c);
                    fragmentTransaction.add(this.f2434e, d2.f2443d, d2.f2440a);
                } else {
                    fragmentTransaction.attach(fragment2);
                }
            }
            this.f2436g = d2;
        }
        return fragmentTransaction;
    }

    private void b() {
        if (this.f2431b == null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(this.f2434e);
            this.f2431b = frameLayout;
            if (frameLayout != null) {
                return;
            }
            throw new IllegalStateException("No tab content FrameLayout found for id " + this.f2434e);
        }
    }

    private void c(Context context) {
        if (findViewById(R.id.tabs) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
            TabWidget tabWidget = new TabWidget(context);
            tabWidget.setId(R.id.tabs);
            tabWidget.setOrientation(0);
            linearLayout.addView(tabWidget, new LinearLayout.LayoutParams(-1, -2, 0.0f));
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setId(R.id.tabcontent);
            linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(0, 0, 0.0f));
            FrameLayout frameLayout2 = new FrameLayout(context);
            this.f2431b = frameLayout2;
            frameLayout2.setId(this.f2434e);
            linearLayout.addView(frameLayout2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
    }

    @Nullable
    private TabInfo d(String str) {
        int size = this.f2430a.size();
        for (int i2 = 0; i2 < size; i2++) {
            TabInfo tabInfo = this.f2430a.get(i2);
            if (tabInfo.f2440a.equals(str)) {
                return tabInfo;
            }
        }
        return null;
    }

    private void e(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.inflatedId}, 0, 0);
        this.f2434e = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Deprecated
    public void addTab(@NonNull TabHost.TabSpec tabSpec, @NonNull Class<?> cls, @Nullable Bundle bundle) {
        tabSpec.setContent(new DummyTabFactory(this.f2432c));
        String tag = tabSpec.getTag();
        TabInfo tabInfo = new TabInfo(tag, cls, bundle);
        if (this.f2437h) {
            Fragment findFragmentByTag = this.f2433d.findFragmentByTag(tag);
            tabInfo.f2443d = findFragmentByTag;
            if (findFragmentByTag != null && !findFragmentByTag.isDetached()) {
                FragmentTransaction beginTransaction = this.f2433d.beginTransaction();
                beginTransaction.detach(tabInfo.f2443d);
                beginTransaction.commit();
            }
        }
        this.f2430a.add(tabInfo);
        addTab(tabSpec);
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        int size = this.f2430a.size();
        FragmentTransaction fragmentTransaction = null;
        for (int i2 = 0; i2 < size; i2++) {
            TabInfo tabInfo = this.f2430a.get(i2);
            Fragment findFragmentByTag = this.f2433d.findFragmentByTag(tabInfo.f2440a);
            tabInfo.f2443d = findFragmentByTag;
            if (findFragmentByTag != null && !findFragmentByTag.isDetached()) {
                if (tabInfo.f2440a.equals(currentTabTag)) {
                    this.f2436g = tabInfo;
                } else {
                    if (fragmentTransaction == null) {
                        fragmentTransaction = this.f2433d.beginTransaction();
                    }
                    fragmentTransaction.detach(tabInfo.f2443d);
                }
            }
        }
        this.f2437h = true;
        FragmentTransaction a2 = a(currentTabTag, fragmentTransaction);
        if (a2 != null) {
            a2.commit();
            this.f2433d.executePendingTransactions();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2437h = false;
    }

    @Override // android.view.View
    @Deprecated
    protected void onRestoreInstanceState(@SuppressLint({"UnknownNullness"}) Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f2439a);
    }

    @Override // android.view.View
    @NonNull
    @Deprecated
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2439a = getCurrentTabTag();
        return savedState;
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    @Deprecated
    public void onTabChanged(@Nullable String str) {
        FragmentTransaction a2;
        if (this.f2437h && (a2 = a(str, null)) != null) {
            a2.commit();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.f2435f;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setOnTabChangedListener(@Nullable TabHost.OnTabChangeListener onTabChangeListener) {
        this.f2435f = onTabChangeListener;
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Deprecated
    public void setup(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        c(context);
        super.setup();
        this.f2432c = context;
        this.f2433d = fragmentManager;
        b();
    }

    @Deprecated
    public FragmentTabHost(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2430a = new ArrayList<>();
        e(context, attributeSet);
    }

    @Deprecated
    public void setup(@NonNull Context context, @NonNull FragmentManager fragmentManager, int i2) {
        c(context);
        super.setup();
        this.f2432c = context;
        this.f2433d = fragmentManager;
        this.f2434e = i2;
        b();
        this.f2431b.setId(i2);
        if (getId() == -1) {
            setId(R.id.tabhost);
        }
    }
}
