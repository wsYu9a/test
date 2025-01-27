package com.google.android.material.tabs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    @NonNull
    private final TabLayout f7862a;

    /* renamed from: b */
    @NonNull
    private final ViewPager2 f7863b;

    /* renamed from: c */
    private final boolean f7864c;

    /* renamed from: d */
    private final boolean f7865d;

    /* renamed from: e */
    private final b f7866e;

    /* renamed from: f */
    @Nullable
    private RecyclerView.Adapter<?> f7867f;

    /* renamed from: g */
    private boolean f7868g;

    /* renamed from: h */
    @Nullable
    private c f7869h;

    /* renamed from: i */
    @Nullable
    private TabLayout.f f7870i;

    /* renamed from: j */
    @Nullable
    private RecyclerView.AdapterDataObserver f7871j;

    /* renamed from: com.google.android.material.tabs.a$a */
    private class C0100a extends RecyclerView.AdapterDataObserver {
        C0100a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            a.this.c();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i2, int i3) {
            a.this.c();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i2, int i3) {
            a.this.c();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i2, int i3, int i4) {
            a.this.c();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i2, int i3) {
            a.this.c();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i2, int i3, @Nullable Object obj) {
            a.this.c();
        }
    }

    public interface b {
        void a(@NonNull TabLayout.i iVar, int i2);
    }

    private static class c extends ViewPager2.OnPageChangeCallback {

        /* renamed from: a */
        @NonNull
        private final WeakReference<TabLayout> f7873a;

        /* renamed from: b */
        private int f7874b;

        /* renamed from: c */
        private int f7875c;

        c(TabLayout tabLayout) {
            this.f7873a = new WeakReference<>(tabLayout);
            a();
        }

        void a() {
            this.f7875c = 0;
            this.f7874b = 0;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i2) {
            this.f7874b = this.f7875c;
            this.f7875c = i2;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i2, float f2, int i3) {
            TabLayout tabLayout = this.f7873a.get();
            if (tabLayout != null) {
                int i4 = this.f7875c;
                tabLayout.P(i2, f2, i4 != 2 || this.f7874b == 1, (i4 == 2 && this.f7874b == 0) ? false : true);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i2) {
            TabLayout tabLayout = this.f7873a.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i2 || i2 >= tabLayout.getTabCount()) {
                return;
            }
            int i3 = this.f7875c;
            tabLayout.M(tabLayout.y(i2), i3 == 0 || (i3 == 2 && this.f7874b == 0));
        }
    }

    private static class d implements TabLayout.f {

        /* renamed from: a */
        private final ViewPager2 f7876a;

        /* renamed from: b */
        private final boolean f7877b;

        d(ViewPager2 viewPager2, boolean z) {
            this.f7876a = viewPager2;
            this.f7877b = z;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(@NonNull TabLayout.i iVar) {
            this.f7876a.setCurrentItem(iVar.i(), this.f7877b);
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(TabLayout.i iVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(TabLayout.i iVar) {
        }
    }

    public a(@NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2, @NonNull b bVar) {
        this(tabLayout, viewPager2, true, bVar);
    }

    public void a() {
        if (this.f7868g) {
            throw new IllegalStateException("TabLayoutMediator is already attached");
        }
        RecyclerView.Adapter<?> adapter = this.f7863b.getAdapter();
        this.f7867f = adapter;
        if (adapter == null) {
            throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
        }
        this.f7868g = true;
        c cVar = new c(this.f7862a);
        this.f7869h = cVar;
        this.f7863b.registerOnPageChangeCallback(cVar);
        d dVar = new d(this.f7863b, this.f7865d);
        this.f7870i = dVar;
        this.f7862a.c(dVar);
        if (this.f7864c) {
            C0100a c0100a = new C0100a();
            this.f7871j = c0100a;
            this.f7867f.registerAdapterDataObserver(c0100a);
        }
        c();
        this.f7862a.O(this.f7863b.getCurrentItem(), 0.0f, true);
    }

    public void b() {
        RecyclerView.Adapter<?> adapter;
        if (this.f7864c && (adapter = this.f7867f) != null) {
            adapter.unregisterAdapterDataObserver(this.f7871j);
            this.f7871j = null;
        }
        this.f7862a.H(this.f7870i);
        this.f7863b.unregisterOnPageChangeCallback(this.f7869h);
        this.f7870i = null;
        this.f7869h = null;
        this.f7867f = null;
        this.f7868g = false;
    }

    void c() {
        this.f7862a.F();
        RecyclerView.Adapter<?> adapter = this.f7867f;
        if (adapter != null) {
            int itemCount = adapter.getItemCount();
            for (int i2 = 0; i2 < itemCount; i2++) {
                TabLayout.i C = this.f7862a.C();
                this.f7866e.a(C, i2);
                this.f7862a.g(C, false);
            }
            if (itemCount > 0) {
                int min = Math.min(this.f7863b.getCurrentItem(), this.f7862a.getTabCount() - 1);
                if (min != this.f7862a.getSelectedTabPosition()) {
                    TabLayout tabLayout = this.f7862a;
                    tabLayout.L(tabLayout.y(min));
                }
            }
        }
    }

    public a(@NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2, boolean z, @NonNull b bVar) {
        this(tabLayout, viewPager2, z, true, bVar);
    }

    public a(@NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2, boolean z, boolean z2, @NonNull b bVar) {
        this.f7862a = tabLayout;
        this.f7863b = viewPager2;
        this.f7864c = z;
        this.f7865d = z2;
        this.f7866e = bVar;
    }
}
