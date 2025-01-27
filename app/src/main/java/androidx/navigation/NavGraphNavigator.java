package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.navigation.Navigator;

@Navigator.Name(NotificationCompat.CATEGORY_NAVIGATION)
/* loaded from: classes.dex */
public class NavGraphNavigator extends Navigator<NavGraph> {

    /* renamed from: a */
    private final NavigatorProvider f3021a;

    public NavGraphNavigator(@NonNull NavigatorProvider navigatorProvider) {
        this.f3021a = navigatorProvider;
    }

    @Override // androidx.navigation.Navigator
    public boolean popBackStack() {
        return true;
    }

    @Override // androidx.navigation.Navigator
    @NonNull
    public NavGraph createDestination() {
        return new NavGraph(this);
    }

    @Override // androidx.navigation.Navigator
    @Nullable
    public NavDestination navigate(@NonNull NavGraph navGraph, @Nullable Bundle bundle, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        int startDestination = navGraph.getStartDestination();
        if (startDestination == 0) {
            throw new IllegalStateException("no start destination defined via app:startDestination for " + navGraph.getDisplayName());
        }
        NavDestination h2 = navGraph.h(startDestination, false);
        if (h2 != null) {
            return this.f3021a.getNavigator(h2.getNavigatorName()).navigate(h2, h2.a(bundle), navOptions, extras);
        }
        throw new IllegalArgumentException("navigation destination " + navGraph.i() + " is not a direct child of this NavGraph");
    }
}
