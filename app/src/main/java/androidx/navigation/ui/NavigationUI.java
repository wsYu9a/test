package androidx.navigation.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.widget.Openable;
import androidx.navigation.ActivityNavigator;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavOptions;
import androidx.navigation.ui.AppBarConfiguration;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.navigation.NavigationView;
import java.lang.ref.WeakReference;
import java.util.Set;

/* loaded from: classes.dex */
public final class NavigationUI {

    /* renamed from: androidx.navigation.ui.NavigationUI$1 */
    public class AnonymousClass1 implements View.OnClickListener {
        final /* synthetic */ AppBarConfiguration val$configuration;

        public AnonymousClass1(AppBarConfiguration appBarConfiguration) {
            appBarConfiguration = appBarConfiguration;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NavigationUI.navigateUp(NavController.this, appBarConfiguration);
        }
    }

    /* renamed from: androidx.navigation.ui.NavigationUI$2 */
    public class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ AppBarConfiguration val$configuration;

        public AnonymousClass2(AppBarConfiguration appBarConfiguration) {
            appBarConfiguration = appBarConfiguration;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NavigationUI.navigateUp(NavController.this, appBarConfiguration);
        }
    }

    /* renamed from: androidx.navigation.ui.NavigationUI$3 */
    public class AnonymousClass3 implements NavigationView.OnNavigationItemSelectedListener {
        final /* synthetic */ NavigationView val$navigationView;

        public AnonymousClass3(NavigationView navigationView) {
            navigationView = navigationView;
        }

        @Override // com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            boolean onNavDestinationSelected = NavigationUI.onNavDestinationSelected(menuItem, NavController.this);
            if (onNavDestinationSelected) {
                ViewParent parent = navigationView.getParent();
                if (parent instanceof Openable) {
                    ((Openable) parent).close();
                } else {
                    BottomSheetBehavior findBottomSheetBehavior = NavigationUI.findBottomSheetBehavior(navigationView);
                    if (findBottomSheetBehavior != null) {
                        findBottomSheetBehavior.setState(5);
                    }
                }
            }
            return onNavDestinationSelected;
        }
    }

    /* renamed from: androidx.navigation.ui.NavigationUI$4 */
    public class AnonymousClass4 implements NavController.OnDestinationChangedListener {
        final /* synthetic */ NavController val$navController;
        final /* synthetic */ WeakReference val$weakReference;

        public AnonymousClass4(WeakReference weakReference, NavController navController) {
            weakReference = weakReference;
            navController = navController;
        }

        @Override // androidx.navigation.NavController.OnDestinationChangedListener
        public void onDestinationChanged(@NonNull NavController navController, @NonNull NavDestination navDestination, @Nullable Bundle bundle) {
            NavigationView navigationView = (NavigationView) weakReference.get();
            if (navigationView == null) {
                navController.removeOnDestinationChangedListener(this);
                return;
            }
            Menu menu = navigationView.getMenu();
            int size = menu.size();
            for (int i10 = 0; i10 < size; i10++) {
                MenuItem item = menu.getItem(i10);
                item.setChecked(NavigationUI.matchDestination(navDestination, item.getItemId()));
            }
        }
    }

    /* renamed from: androidx.navigation.ui.NavigationUI$5 */
    public class AnonymousClass5 implements BottomNavigationView.OnNavigationItemSelectedListener {
        public AnonymousClass5() {
        }

        @Override // com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            return NavigationUI.onNavDestinationSelected(menuItem, NavController.this);
        }
    }

    /* renamed from: androidx.navigation.ui.NavigationUI$6 */
    public class AnonymousClass6 implements NavController.OnDestinationChangedListener {
        final /* synthetic */ NavController val$navController;
        final /* synthetic */ WeakReference val$weakReference;

        public AnonymousClass6(WeakReference weakReference, NavController navController) {
            weakReference = weakReference;
            navController = navController;
        }

        @Override // androidx.navigation.NavController.OnDestinationChangedListener
        public void onDestinationChanged(@NonNull NavController navController, @NonNull NavDestination navDestination, @Nullable Bundle bundle) {
            BottomNavigationView bottomNavigationView = (BottomNavigationView) weakReference.get();
            if (bottomNavigationView == null) {
                navController.removeOnDestinationChangedListener(this);
                return;
            }
            Menu menu = bottomNavigationView.getMenu();
            int size = menu.size();
            for (int i10 = 0; i10 < size; i10++) {
                MenuItem item = menu.getItem(i10);
                if (NavigationUI.matchDestination(navDestination, item.getItemId())) {
                    item.setChecked(true);
                }
            }
        }
    }

    private NavigationUI() {
    }

    public static BottomSheetBehavior findBottomSheetBehavior(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
            if (behavior instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) behavior;
            }
            return null;
        }
        Object parent = view.getParent();
        if (parent instanceof View) {
            return findBottomSheetBehavior((View) parent);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [androidx.navigation.NavDestination] */
    public static NavDestination findStartDestination(@NonNull NavGraph navGraph) {
        NavGraph navGraph2 = navGraph;
        while (navGraph2 instanceof NavGraph) {
            NavGraph navGraph3 = navGraph2;
            navGraph2 = navGraph3.findNode(navGraph3.getStartDestination());
        }
        return navGraph2;
    }

    public static boolean matchDestination(@NonNull NavDestination navDestination, @IdRes int i10) {
        while (navDestination.getId() != i10 && navDestination.getParent() != null) {
            navDestination = navDestination.getParent();
        }
        return navDestination.getId() == i10;
    }

    public static boolean matchDestinations(@NonNull NavDestination navDestination, @NonNull Set<Integer> set) {
        while (!set.contains(Integer.valueOf(navDestination.getId()))) {
            navDestination = navDestination.getParent();
            if (navDestination == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean navigateUp(@NonNull NavController navController, @Nullable Openable openable) {
        return navigateUp(navController, new AppBarConfiguration.Builder(navController.getGraph()).setOpenableLayout(openable).build());
    }

    public static boolean onNavDestinationSelected(@NonNull MenuItem menuItem, @NonNull NavController navController) {
        NavOptions.Builder launchSingleTop = new NavOptions.Builder().setLaunchSingleTop(true);
        if (navController.getCurrentDestination().getParent().findNode(menuItem.getItemId()) instanceof ActivityNavigator.Destination) {
            launchSingleTop.setEnterAnim(R.anim.nav_default_enter_anim).setExitAnim(R.anim.nav_default_exit_anim).setPopEnterAnim(R.anim.nav_default_pop_enter_anim).setPopExitAnim(R.anim.nav_default_pop_exit_anim);
        } else {
            launchSingleTop.setEnterAnim(R.animator.nav_default_enter_anim).setExitAnim(R.animator.nav_default_exit_anim).setPopEnterAnim(R.animator.nav_default_pop_enter_anim).setPopExitAnim(R.animator.nav_default_pop_exit_anim);
        }
        if ((menuItem.getOrder() & 196608) == 0) {
            launchSingleTop.setPopUpTo(findStartDestination(navController.getGraph()).getId(), false);
        }
        try {
            navController.navigate(menuItem.getItemId(), (Bundle) null, launchSingleTop.build());
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public static void setupActionBarWithNavController(@NonNull AppCompatActivity appCompatActivity, @NonNull NavController navController) {
        setupActionBarWithNavController(appCompatActivity, navController, new AppBarConfiguration.Builder(navController.getGraph()).build());
    }

    public static void setupWithNavController(@NonNull Toolbar toolbar, @NonNull NavController navController) {
        setupWithNavController(toolbar, navController, new AppBarConfiguration.Builder(navController.getGraph()).build());
    }

    public static void setupWithNavController(@NonNull Toolbar toolbar, @NonNull NavController navController, @Nullable Openable openable) {
        setupWithNavController(toolbar, navController, new AppBarConfiguration.Builder(navController.getGraph()).setOpenableLayout(openable).build());
    }

    public static boolean navigateUp(@NonNull NavController navController, @NonNull AppBarConfiguration appBarConfiguration) {
        Openable openableLayout = appBarConfiguration.getOpenableLayout();
        NavDestination currentDestination = navController.getCurrentDestination();
        Set<Integer> topLevelDestinations = appBarConfiguration.getTopLevelDestinations();
        if (openableLayout != null && currentDestination != null && matchDestinations(currentDestination, topLevelDestinations)) {
            openableLayout.open();
            return true;
        }
        if (navController.navigateUp()) {
            return true;
        }
        if (appBarConfiguration.getFallbackOnNavigateUpListener() != null) {
            return appBarConfiguration.getFallbackOnNavigateUpListener().onNavigateUp();
        }
        return false;
    }

    public static void setupActionBarWithNavController(@NonNull AppCompatActivity appCompatActivity, @NonNull NavController navController, @Nullable Openable openable) {
        setupActionBarWithNavController(appCompatActivity, navController, new AppBarConfiguration.Builder(navController.getGraph()).setOpenableLayout(openable).build());
    }

    public static void setupWithNavController(@NonNull Toolbar toolbar, @NonNull NavController navController, @NonNull AppBarConfiguration appBarConfiguration) {
        navController.addOnDestinationChangedListener(new ToolbarOnDestinationChangedListener(toolbar, appBarConfiguration));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: androidx.navigation.ui.NavigationUI.1
            final /* synthetic */ AppBarConfiguration val$configuration;

            public AnonymousClass1(AppBarConfiguration appBarConfiguration2) {
                appBarConfiguration = appBarConfiguration2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NavigationUI.navigateUp(NavController.this, appBarConfiguration);
            }
        });
    }

    public static void setupActionBarWithNavController(@NonNull AppCompatActivity appCompatActivity, @NonNull NavController navController, @NonNull AppBarConfiguration appBarConfiguration) {
        navController.addOnDestinationChangedListener(new ActionBarOnDestinationChangedListener(appCompatActivity, appBarConfiguration));
    }

    public static void setupWithNavController(@NonNull CollapsingToolbarLayout collapsingToolbarLayout, @NonNull Toolbar toolbar, @NonNull NavController navController) {
        setupWithNavController(collapsingToolbarLayout, toolbar, navController, new AppBarConfiguration.Builder(navController.getGraph()).build());
    }

    public static void setupWithNavController(@NonNull CollapsingToolbarLayout collapsingToolbarLayout, @NonNull Toolbar toolbar, @NonNull NavController navController, @Nullable Openable openable) {
        setupWithNavController(collapsingToolbarLayout, toolbar, navController, new AppBarConfiguration.Builder(navController.getGraph()).setOpenableLayout(openable).build());
    }

    public static void setupWithNavController(@NonNull CollapsingToolbarLayout collapsingToolbarLayout, @NonNull Toolbar toolbar, @NonNull NavController navController, @NonNull AppBarConfiguration appBarConfiguration) {
        navController.addOnDestinationChangedListener(new CollapsingToolbarOnDestinationChangedListener(collapsingToolbarLayout, toolbar, appBarConfiguration));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: androidx.navigation.ui.NavigationUI.2
            final /* synthetic */ AppBarConfiguration val$configuration;

            public AnonymousClass2(AppBarConfiguration appBarConfiguration2) {
                appBarConfiguration = appBarConfiguration2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NavigationUI.navigateUp(NavController.this, appBarConfiguration);
            }
        });
    }

    public static void setupWithNavController(@NonNull NavigationView navigationView, @NonNull NavController navController) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() { // from class: androidx.navigation.ui.NavigationUI.3
            final /* synthetic */ NavigationView val$navigationView;

            public AnonymousClass3(NavigationView navigationView2) {
                navigationView = navigationView2;
            }

            @Override // com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                boolean onNavDestinationSelected = NavigationUI.onNavDestinationSelected(menuItem, NavController.this);
                if (onNavDestinationSelected) {
                    ViewParent parent = navigationView.getParent();
                    if (parent instanceof Openable) {
                        ((Openable) parent).close();
                    } else {
                        BottomSheetBehavior findBottomSheetBehavior = NavigationUI.findBottomSheetBehavior(navigationView);
                        if (findBottomSheetBehavior != null) {
                            findBottomSheetBehavior.setState(5);
                        }
                    }
                }
                return onNavDestinationSelected;
            }
        });
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() { // from class: androidx.navigation.ui.NavigationUI.4
            final /* synthetic */ NavController val$navController;
            final /* synthetic */ WeakReference val$weakReference;

            public AnonymousClass4(WeakReference weakReference, NavController navController2) {
                weakReference = weakReference;
                navController = navController2;
            }

            @Override // androidx.navigation.NavController.OnDestinationChangedListener
            public void onDestinationChanged(@NonNull NavController navController2, @NonNull NavDestination navDestination, @Nullable Bundle bundle) {
                NavigationView navigationView2 = (NavigationView) weakReference.get();
                if (navigationView2 == null) {
                    navController.removeOnDestinationChangedListener(this);
                    return;
                }
                Menu menu = navigationView2.getMenu();
                int size = menu.size();
                for (int i10 = 0; i10 < size; i10++) {
                    MenuItem item = menu.getItem(i10);
                    item.setChecked(NavigationUI.matchDestination(navDestination, item.getItemId()));
                }
            }
        });
    }

    public static void setupWithNavController(@NonNull BottomNavigationView bottomNavigationView, @NonNull NavController navController) {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() { // from class: androidx.navigation.ui.NavigationUI.5
            public AnonymousClass5() {
            }

            @Override // com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                return NavigationUI.onNavDestinationSelected(menuItem, NavController.this);
            }
        });
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() { // from class: androidx.navigation.ui.NavigationUI.6
            final /* synthetic */ NavController val$navController;
            final /* synthetic */ WeakReference val$weakReference;

            public AnonymousClass6(WeakReference weakReference, NavController navController2) {
                weakReference = weakReference;
                navController = navController2;
            }

            @Override // androidx.navigation.NavController.OnDestinationChangedListener
            public void onDestinationChanged(@NonNull NavController navController2, @NonNull NavDestination navDestination, @Nullable Bundle bundle) {
                BottomNavigationView bottomNavigationView2 = (BottomNavigationView) weakReference.get();
                if (bottomNavigationView2 == null) {
                    navController.removeOnDestinationChangedListener(this);
                    return;
                }
                Menu menu = bottomNavigationView2.getMenu();
                int size = menu.size();
                for (int i10 = 0; i10 < size; i10++) {
                    MenuItem item = menu.getItem(i10);
                    if (NavigationUI.matchDestination(navDestination, item.getItemId())) {
                        item.setChecked(true);
                    }
                }
            }
        });
    }
}
