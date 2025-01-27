package androidx.navigation.ui;

import android.annotation.SuppressLint;
import android.view.Menu;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.customview.widget.Openable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavGraph;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class AppBarConfiguration {

    /* renamed from: a */
    @NonNull
    private final Set<Integer> f3060a;

    /* renamed from: b */
    @Nullable
    private final Openable f3061b;

    /* renamed from: c */
    @Nullable
    private final OnNavigateUpListener f3062c;

    public interface OnNavigateUpListener {
        boolean onNavigateUp();
    }

    /* synthetic */ AppBarConfiguration(Set set, Openable openable, OnNavigateUpListener onNavigateUpListener, AnonymousClass1 anonymousClass1) {
        this(set, openable, onNavigateUpListener);
    }

    @Nullable
    @Deprecated
    public DrawerLayout getDrawerLayout() {
        Openable openable = this.f3061b;
        if (openable instanceof DrawerLayout) {
            return (DrawerLayout) openable;
        }
        return null;
    }

    @Nullable
    public OnNavigateUpListener getFallbackOnNavigateUpListener() {
        return this.f3062c;
    }

    @Nullable
    public Openable getOpenableLayout() {
        return this.f3061b;
    }

    @NonNull
    public Set<Integer> getTopLevelDestinations() {
        return this.f3060a;
    }

    private AppBarConfiguration(@NonNull Set<Integer> set, @Nullable Openable openable, @Nullable OnNavigateUpListener onNavigateUpListener) {
        this.f3060a = set;
        this.f3061b = openable;
        this.f3062c = onNavigateUpListener;
    }

    public static final class Builder {

        /* renamed from: a */
        @NonNull
        private final Set<Integer> f3063a;

        /* renamed from: b */
        @Nullable
        private Openable f3064b;

        /* renamed from: c */
        @Nullable
        private OnNavigateUpListener f3065c;

        public Builder(@NonNull NavGraph navGraph) {
            HashSet hashSet = new HashSet();
            this.f3063a = hashSet;
            hashSet.add(Integer.valueOf(NavigationUI.b(navGraph).getId()));
        }

        @NonNull
        @SuppressLint({"SyntheticAccessor"})
        public AppBarConfiguration build() {
            return new AppBarConfiguration(this.f3063a, this.f3064b, this.f3065c);
        }

        @NonNull
        @Deprecated
        public Builder setDrawerLayout(@Nullable DrawerLayout drawerLayout) {
            this.f3064b = drawerLayout;
            return this;
        }

        @NonNull
        public Builder setFallbackOnNavigateUpListener(@Nullable OnNavigateUpListener onNavigateUpListener) {
            this.f3065c = onNavigateUpListener;
            return this;
        }

        @NonNull
        public Builder setOpenableLayout(@Nullable Openable openable) {
            this.f3064b = openable;
            return this;
        }

        public Builder(@NonNull Menu menu) {
            this.f3063a = new HashSet();
            int size = menu.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f3063a.add(Integer.valueOf(menu.getItem(i2).getItemId()));
            }
        }

        public Builder(@NonNull int... iArr) {
            this.f3063a = new HashSet();
            for (int i2 : iArr) {
                this.f3063a.add(Integer.valueOf(i2));
            }
        }

        public Builder(@NonNull Set<Integer> set) {
            HashSet hashSet = new HashSet();
            this.f3063a = hashSet;
            hashSet.addAll(set);
        }
    }
}
