package androidx.navigation;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.IdRes;
import androidx.annotation.NavigationRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.TaskStackBuilder;
import androidx.navigation.Navigator;
import java.util.ArrayDeque;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class NavDeepLinkBuilder {

    /* renamed from: a */
    private final Context f2990a;

    /* renamed from: b */
    private final Intent f2991b;

    /* renamed from: c */
    private NavGraph f2992c;

    /* renamed from: d */
    private int f2993d;

    /* renamed from: e */
    private Bundle f2994e;

    private static class PermissiveNavigatorProvider extends NavigatorProvider {

        /* renamed from: c */
        private final Navigator<NavDestination> f2995c = new Navigator<NavDestination>() { // from class: androidx.navigation.NavDeepLinkBuilder.PermissiveNavigatorProvider.1
            AnonymousClass1() {
            }

            @Override // androidx.navigation.Navigator
            @NonNull
            public NavDestination createDestination() {
                return new NavDestination("permissive");
            }

            @Override // androidx.navigation.Navigator
            @Nullable
            public NavDestination navigate(@NonNull NavDestination navDestination, @Nullable Bundle bundle, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
                throw new IllegalStateException("navigate is not supported");
            }

            @Override // androidx.navigation.Navigator
            public boolean popBackStack() {
                throw new IllegalStateException("popBackStack is not supported");
            }
        };

        /* renamed from: androidx.navigation.NavDeepLinkBuilder$PermissiveNavigatorProvider$1 */
        class AnonymousClass1 extends Navigator<NavDestination> {
            AnonymousClass1() {
            }

            @Override // androidx.navigation.Navigator
            @NonNull
            public NavDestination createDestination() {
                return new NavDestination("permissive");
            }

            @Override // androidx.navigation.Navigator
            @Nullable
            public NavDestination navigate(@NonNull NavDestination navDestination, @Nullable Bundle bundle, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
                throw new IllegalStateException("navigate is not supported");
            }

            @Override // androidx.navigation.Navigator
            public boolean popBackStack() {
                throw new IllegalStateException("popBackStack is not supported");
            }
        }

        PermissiveNavigatorProvider() {
            addNavigator(new NavGraphNavigator(this));
        }

        @Override // androidx.navigation.NavigatorProvider
        @NonNull
        public Navigator<? extends NavDestination> getNavigator(@NonNull String str) {
            try {
                return super.getNavigator(str);
            } catch (IllegalStateException unused) {
                return this.f2995c;
            }
        }
    }

    public NavDeepLinkBuilder(@NonNull Context context) {
        this.f2990a = context;
        if (context instanceof Activity) {
            this.f2991b = new Intent(context, context.getClass());
        } else {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            this.f2991b = launchIntentForPackage == null ? new Intent() : launchIntentForPackage;
        }
        this.f2991b.addFlags(268468224);
    }

    private void a() {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(this.f2992c);
        NavDestination navDestination = null;
        while (!arrayDeque.isEmpty() && navDestination == null) {
            NavDestination navDestination2 = (NavDestination) arrayDeque.poll();
            if (navDestination2.getId() == this.f2993d) {
                navDestination = navDestination2;
            } else if (navDestination2 instanceof NavGraph) {
                Iterator<NavDestination> it = ((NavGraph) navDestination2).iterator();
                while (it.hasNext()) {
                    arrayDeque.add(it.next());
                }
            }
        }
        if (navDestination != null) {
            this.f2991b.putExtra("android-support-nav:controller:deepLinkIds", navDestination.b());
            return;
        }
        throw new IllegalArgumentException("Navigation destination " + NavDestination.c(this.f2990a, this.f2993d) + " cannot be found in the navigation graph " + this.f2992c);
    }

    @NonNull
    public PendingIntent createPendingIntent() {
        Bundle bundle = this.f2994e;
        int i2 = 0;
        if (bundle != null) {
            Iterator<String> it = bundle.keySet().iterator();
            int i3 = 0;
            while (it.hasNext()) {
                Object obj = this.f2994e.get(it.next());
                i3 = (i3 * 31) + (obj != null ? obj.hashCode() : 0);
            }
            i2 = i3;
        }
        return createTaskStackBuilder().getPendingIntent((i2 * 31) + this.f2993d, 134217728);
    }

    @NonNull
    public TaskStackBuilder createTaskStackBuilder() {
        if (this.f2991b.getIntArrayExtra("android-support-nav:controller:deepLinkIds") == null) {
            if (this.f2992c == null) {
                throw new IllegalStateException("You must call setGraph() before constructing the deep link");
            }
            throw new IllegalStateException("You must call setDestination() before constructing the deep link");
        }
        TaskStackBuilder addNextIntentWithParentStack = TaskStackBuilder.create(this.f2990a).addNextIntentWithParentStack(new Intent(this.f2991b));
        for (int i2 = 0; i2 < addNextIntentWithParentStack.getIntentCount(); i2++) {
            addNextIntentWithParentStack.editIntentAt(i2).putExtra(NavController.KEY_DEEP_LINK_INTENT, this.f2991b);
        }
        return addNextIntentWithParentStack;
    }

    @NonNull
    public NavDeepLinkBuilder setArguments(@Nullable Bundle bundle) {
        this.f2994e = bundle;
        this.f2991b.putExtra("android-support-nav:controller:deepLinkExtras", bundle);
        return this;
    }

    @NonNull
    public NavDeepLinkBuilder setComponentName(@NonNull Class<? extends Activity> cls) {
        return setComponentName(new ComponentName(this.f2990a, cls));
    }

    @NonNull
    public NavDeepLinkBuilder setDestination(@IdRes int i2) {
        this.f2993d = i2;
        if (this.f2992c != null) {
            a();
        }
        return this;
    }

    @NonNull
    public NavDeepLinkBuilder setGraph(@NavigationRes int i2) {
        return setGraph(new NavInflater(this.f2990a, new PermissiveNavigatorProvider()).inflate(i2));
    }

    @NonNull
    public NavDeepLinkBuilder setComponentName(@NonNull ComponentName componentName) {
        this.f2991b.setComponent(componentName);
        return this;
    }

    @NonNull
    public NavDeepLinkBuilder setGraph(@NonNull NavGraph navGraph) {
        this.f2992c = navGraph;
        if (this.f2993d != 0) {
            a();
        }
        return this;
    }

    NavDeepLinkBuilder(@NonNull NavController navController) {
        this(navController.getContext());
        this.f2992c = navController.getGraph();
    }
}
