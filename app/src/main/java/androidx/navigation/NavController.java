package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.CallSuper;
import androidx.annotation.IdRes;
import androidx.annotation.NavigationRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.app.TaskStackBuilder;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class NavController {

    @NonNull
    public static final String KEY_DEEP_LINK_INTENT = "android-support-nav:controller:deepLinkIntent";

    /* renamed from: a */
    private static final String f2959a = "NavController";

    /* renamed from: b */
    private static final String f2960b = "android-support-nav:controller:navigatorState";

    /* renamed from: c */
    private static final String f2961c = "android-support-nav:controller:navigatorState:names";

    /* renamed from: d */
    private static final String f2962d = "android-support-nav:controller:backStack";

    /* renamed from: e */
    static final String f2963e = "android-support-nav:controller:deepLinkIds";

    /* renamed from: f */
    static final String f2964f = "android-support-nav:controller:deepLinkExtras";

    /* renamed from: g */
    static final String f2965g = "android-support-nav:controller:deepLinkHandled";

    /* renamed from: h */
    private final Context f2966h;

    /* renamed from: i */
    private Activity f2967i;

    /* renamed from: j */
    private NavInflater f2968j;
    NavGraph k;
    private Bundle l;
    private Parcelable[] m;
    private boolean n;
    private LifecycleOwner p;
    private NavControllerViewModel q;
    final Deque<NavBackStackEntry> o = new ArrayDeque();
    private NavigatorProvider r = new NavigatorProvider();
    private final CopyOnWriteArrayList<OnDestinationChangedListener> s = new CopyOnWriteArrayList<>();
    private final LifecycleObserver t = new LifecycleEventObserver() { // from class: androidx.navigation.NavController.1
        AnonymousClass1() {
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
            NavController navController = NavController.this;
            if (navController.k != null) {
                Iterator<NavBackStackEntry> it = navController.o.iterator();
                while (it.hasNext()) {
                    it.next().c(event);
                }
            }
        }
    };
    private final OnBackPressedCallback u = new OnBackPressedCallback(false) { // from class: androidx.navigation.NavController.2
        AnonymousClass2(boolean z) {
            super(z);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            NavController.this.popBackStack();
        }
    };
    private boolean v = true;

    /* renamed from: androidx.navigation.NavController$1 */
    class AnonymousClass1 implements LifecycleEventObserver {
        AnonymousClass1() {
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
            NavController navController = NavController.this;
            if (navController.k != null) {
                Iterator<NavBackStackEntry> it = navController.o.iterator();
                while (it.hasNext()) {
                    it.next().c(event);
                }
            }
        }
    }

    /* renamed from: androidx.navigation.NavController$2 */
    class AnonymousClass2 extends OnBackPressedCallback {
        AnonymousClass2(boolean z) {
            super(z);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            NavController.this.popBackStack();
        }
    }

    public interface OnDestinationChangedListener {
        void onDestinationChanged(@NonNull NavController navController, @NonNull NavDestination navDestination, @Nullable Bundle bundle);
    }

    public NavController(@NonNull Context context) {
        this.f2966h = context;
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                break;
            }
            if (context instanceof Activity) {
                this.f2967i = (Activity) context;
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        NavigatorProvider navigatorProvider = this.r;
        navigatorProvider.addNavigator(new NavGraphNavigator(navigatorProvider));
        this.r.addNavigator(new ActivityNavigator(this.f2966h));
    }

    private boolean a() {
        while (!this.o.isEmpty() && (this.o.peekLast().getDestination() instanceof NavGraph) && g(this.o.peekLast().getDestination().getId(), true)) {
        }
        if (this.o.isEmpty()) {
            return false;
        }
        NavDestination destination = this.o.peekLast().getDestination();
        NavDestination navDestination = null;
        if (destination instanceof FloatingWindow) {
            Iterator<NavBackStackEntry> descendingIterator = this.o.descendingIterator();
            while (true) {
                if (!descendingIterator.hasNext()) {
                    break;
                }
                NavDestination destination2 = descendingIterator.next().getDestination();
                if (!(destination2 instanceof NavGraph) && !(destination2 instanceof FloatingWindow)) {
                    navDestination = destination2;
                    break;
                }
            }
        }
        HashMap hashMap = new HashMap();
        Iterator<NavBackStackEntry> descendingIterator2 = this.o.descendingIterator();
        while (descendingIterator2.hasNext()) {
            NavBackStackEntry next = descendingIterator2.next();
            Lifecycle.State a2 = next.a();
            NavDestination destination3 = next.getDestination();
            if (destination != null && destination3.getId() == destination.getId()) {
                Lifecycle.State state = Lifecycle.State.RESUMED;
                if (a2 != state) {
                    hashMap.put(next, state);
                }
                destination = destination.getParent();
            } else if (navDestination == null || destination3.getId() != navDestination.getId()) {
                next.f(Lifecycle.State.CREATED);
            } else {
                if (a2 == Lifecycle.State.RESUMED) {
                    next.f(Lifecycle.State.STARTED);
                } else {
                    Lifecycle.State state2 = Lifecycle.State.STARTED;
                    if (a2 != state2) {
                        hashMap.put(next, state2);
                    }
                }
                navDestination = navDestination.getParent();
            }
        }
        for (NavBackStackEntry navBackStackEntry : this.o) {
            Lifecycle.State state3 = (Lifecycle.State) hashMap.get(navBackStackEntry);
            if (state3 != null) {
                navBackStackEntry.f(state3);
            } else {
                navBackStackEntry.g();
            }
        }
        NavBackStackEntry peekLast = this.o.peekLast();
        Iterator<OnDestinationChangedListener> it = this.s.iterator();
        while (it.hasNext()) {
            it.next().onDestinationChanged(this, peekLast.getDestination(), peekLast.getArguments());
        }
        return true;
    }

    @Nullable
    private String c(@NonNull int[] iArr) {
        NavGraph navGraph;
        NavGraph navGraph2 = this.k;
        int i2 = 0;
        while (true) {
            NavDestination navDestination = null;
            if (i2 >= iArr.length) {
                return null;
            }
            int i3 = iArr[i2];
            if (i2 != 0) {
                navDestination = navGraph2.findNode(i3);
            } else if (this.k.getId() == i3) {
                navDestination = this.k;
            }
            if (navDestination == null) {
                return NavDestination.c(this.f2966h, i3);
            }
            if (i2 != iArr.length - 1) {
                while (true) {
                    navGraph = (NavGraph) navDestination;
                    if (!(navGraph.findNode(navGraph.getStartDestination()) instanceof NavGraph)) {
                        break;
                    }
                    navDestination = navGraph.findNode(navGraph.getStartDestination());
                }
                navGraph2 = navGraph;
            }
            i2++;
        }
    }

    private int d() {
        Iterator<NavBackStackEntry> it = this.o.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (!(it.next().getDestination() instanceof NavGraph)) {
                i2++;
            }
        }
        return i2;
    }

    private void e(@NonNull NavDestination navDestination, @Nullable Bundle bundle, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        boolean z = false;
        boolean g2 = (navOptions == null || navOptions.getPopUpTo() == -1) ? false : g(navOptions.getPopUpTo(), navOptions.isPopUpToInclusive());
        Navigator navigator = this.r.getNavigator(navDestination.getNavigatorName());
        Bundle a2 = navDestination.a(bundle);
        NavDestination navigate = navigator.navigate(navDestination, a2, navOptions, extras);
        if (navigate != null) {
            if (!(navigate instanceof FloatingWindow)) {
                while (!this.o.isEmpty() && (this.o.peekLast().getDestination() instanceof FloatingWindow) && g(this.o.peekLast().getDestination().getId(), true)) {
                }
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            if (navDestination instanceof NavGraph) {
                NavDestination navDestination2 = navigate;
                while (true) {
                    NavGraph parent = navDestination2.getParent();
                    if (parent != null) {
                        arrayDeque.addFirst(new NavBackStackEntry(this.f2966h, parent, a2, this.p, this.q));
                        if (!this.o.isEmpty() && this.o.getLast().getDestination() == parent) {
                            g(parent.getId(), true);
                        }
                    }
                    if (parent == null || parent == navDestination) {
                        break;
                    } else {
                        navDestination2 = parent;
                    }
                }
            }
            NavDestination destination = arrayDeque.isEmpty() ? navigate : ((NavBackStackEntry) arrayDeque.getFirst()).getDestination();
            while (destination != null && b(destination.getId()) == null) {
                destination = destination.getParent();
                if (destination != null) {
                    arrayDeque.addFirst(new NavBackStackEntry(this.f2966h, destination, a2, this.p, this.q));
                }
            }
            NavDestination destination2 = arrayDeque.isEmpty() ? navigate : ((NavBackStackEntry) arrayDeque.getLast()).getDestination();
            while (!this.o.isEmpty() && (this.o.getLast().getDestination() instanceof NavGraph) && ((NavGraph) this.o.getLast().getDestination()).h(destination2.getId(), false) == null && g(this.o.getLast().getDestination().getId(), true)) {
            }
            this.o.addAll(arrayDeque);
            if (this.o.isEmpty() || this.o.getFirst().getDestination() != this.k) {
                this.o.addFirst(new NavBackStackEntry(this.f2966h, this.k, a2, this.p, this.q));
            }
            this.o.add(new NavBackStackEntry(this.f2966h, navigate, navigate.a(a2), this.p, this.q));
        } else if (navOptions != null && navOptions.shouldLaunchSingleTop()) {
            NavBackStackEntry peekLast = this.o.peekLast();
            if (peekLast != null) {
                peekLast.d(a2);
            }
            z = true;
        }
        h();
        if (g2 || navigate != null || z) {
            a();
        }
    }

    private void f(@Nullable Bundle bundle) {
        Activity activity;
        ArrayList<String> stringArrayList;
        Bundle bundle2 = this.l;
        if (bundle2 != null && (stringArrayList = bundle2.getStringArrayList(f2961c)) != null) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                Navigator navigator = this.r.getNavigator(next);
                Bundle bundle3 = this.l.getBundle(next);
                if (bundle3 != null) {
                    navigator.onRestoreState(bundle3);
                }
            }
        }
        Parcelable[] parcelableArr = this.m;
        boolean z = false;
        if (parcelableArr != null) {
            for (Parcelable parcelable : parcelableArr) {
                NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) parcelable;
                NavDestination b2 = b(navBackStackEntryState.b());
                if (b2 == null) {
                    throw new IllegalStateException("Restoring the Navigation back stack failed: destination " + NavDestination.c(this.f2966h, navBackStackEntryState.b()) + " cannot be found from the current destination " + getCurrentDestination());
                }
                Bundle a2 = navBackStackEntryState.a();
                if (a2 != null) {
                    a2.setClassLoader(this.f2966h.getClassLoader());
                }
                this.o.add(new NavBackStackEntry(this.f2966h, b2, a2, this.p, this.q, navBackStackEntryState.e(), navBackStackEntryState.d()));
            }
            h();
            this.m = null;
        }
        if (this.k == null || !this.o.isEmpty()) {
            a();
            return;
        }
        if (!this.n && (activity = this.f2967i) != null && handleDeepLink(activity.getIntent())) {
            z = true;
        }
        if (z) {
            return;
        }
        e(this.k, bundle, null, null);
    }

    private void h() {
        this.u.setEnabled(this.v && d() > 1);
    }

    public void addOnDestinationChangedListener(@NonNull OnDestinationChangedListener onDestinationChangedListener) {
        if (!this.o.isEmpty()) {
            NavBackStackEntry peekLast = this.o.peekLast();
            onDestinationChangedListener.onDestinationChanged(this, peekLast.getDestination(), peekLast.getArguments());
        }
        this.s.add(onDestinationChangedListener);
    }

    NavDestination b(@IdRes int i2) {
        NavGraph navGraph = this.k;
        if (navGraph == null) {
            return null;
        }
        if (navGraph.getId() == i2) {
            return this.k;
        }
        NavGraph destination = this.o.isEmpty() ? this.k : this.o.getLast().getDestination();
        return (destination instanceof NavGraph ? destination : destination.getParent()).findNode(i2);
    }

    @NonNull
    public NavDeepLinkBuilder createDeepLink() {
        return new NavDeepLinkBuilder(this);
    }

    void enableOnBackPressed(boolean z) {
        this.v = z;
        h();
    }

    boolean g(@IdRes int i2, boolean z) {
        boolean z2;
        boolean z3 = false;
        if (this.o.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<NavBackStackEntry> descendingIterator = this.o.descendingIterator();
        while (true) {
            if (!descendingIterator.hasNext()) {
                z2 = false;
                break;
            }
            NavDestination destination = descendingIterator.next().getDestination();
            Navigator navigator = this.r.getNavigator(destination.getNavigatorName());
            if (z || destination.getId() != i2) {
                arrayList.add(navigator);
            }
            if (destination.getId() == i2) {
                z2 = true;
                break;
            }
        }
        if (!z2) {
            Log.i(f2959a, "Ignoring popBackStack to destination " + NavDestination.c(this.f2966h, i2) + " as it was not found on the current back stack");
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext() && ((Navigator) it.next()).popBackStack()) {
            NavBackStackEntry removeLast = this.o.removeLast();
            removeLast.f(Lifecycle.State.DESTROYED);
            NavControllerViewModel navControllerViewModel = this.q;
            if (navControllerViewModel != null) {
                navControllerViewModel.f(removeLast.f2948f);
            }
            z3 = true;
        }
        h();
        return z3;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Deque<NavBackStackEntry> getBackStack() {
        return this.o;
    }

    @NonNull
    public NavBackStackEntry getBackStackEntry(@IdRes int i2) {
        NavBackStackEntry navBackStackEntry;
        Iterator<NavBackStackEntry> descendingIterator = this.o.descendingIterator();
        while (true) {
            if (!descendingIterator.hasNext()) {
                navBackStackEntry = null;
                break;
            }
            navBackStackEntry = descendingIterator.next();
            if (navBackStackEntry.getDestination().getId() == i2) {
                break;
            }
        }
        if (navBackStackEntry != null) {
            return navBackStackEntry;
        }
        throw new IllegalArgumentException("No destination with ID " + i2 + " is on the NavController's back stack. The current destination is " + getCurrentDestination());
    }

    @NonNull
    Context getContext() {
        return this.f2966h;
    }

    @Nullable
    public NavBackStackEntry getCurrentBackStackEntry() {
        if (this.o.isEmpty()) {
            return null;
        }
        return this.o.getLast();
    }

    @Nullable
    public NavDestination getCurrentDestination() {
        NavBackStackEntry currentBackStackEntry = getCurrentBackStackEntry();
        if (currentBackStackEntry != null) {
            return currentBackStackEntry.getDestination();
        }
        return null;
    }

    @NonNull
    public NavGraph getGraph() {
        NavGraph navGraph = this.k;
        if (navGraph != null) {
            return navGraph;
        }
        throw new IllegalStateException("You must call setGraph() before calling getGraph()");
    }

    @NonNull
    public NavInflater getNavInflater() {
        if (this.f2968j == null) {
            this.f2968j = new NavInflater(this.f2966h, this.r);
        }
        return this.f2968j;
    }

    @NonNull
    public NavigatorProvider getNavigatorProvider() {
        return this.r;
    }

    @Nullable
    public NavBackStackEntry getPreviousBackStackEntry() {
        Iterator<NavBackStackEntry> descendingIterator = this.o.descendingIterator();
        if (descendingIterator.hasNext()) {
            descendingIterator.next();
        }
        while (descendingIterator.hasNext()) {
            NavBackStackEntry next = descendingIterator.next();
            if (!(next.getDestination() instanceof NavGraph)) {
                return next;
            }
        }
        return null;
    }

    @NonNull
    public ViewModelStoreOwner getViewModelStoreOwner(@IdRes int i2) {
        if (this.q == null) {
            throw new IllegalStateException("You must call setViewModelStore() before calling getViewModelStoreOwner().");
        }
        NavBackStackEntry backStackEntry = getBackStackEntry(i2);
        if (backStackEntry.getDestination() instanceof NavGraph) {
            return backStackEntry;
        }
        throw new IllegalArgumentException("No NavGraph with ID " + i2 + " is on the NavController's back stack");
    }

    public boolean handleDeepLink(@Nullable Intent intent) {
        NavDestination.DeepLinkMatch d2;
        NavGraph navGraph;
        if (intent == null) {
            return false;
        }
        Bundle extras = intent.getExtras();
        int[] intArray = extras != null ? extras.getIntArray(f2963e) : null;
        Bundle bundle = new Bundle();
        Bundle bundle2 = extras != null ? extras.getBundle(f2964f) : null;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if ((intArray == null || intArray.length == 0) && intent.getData() != null && (d2 = this.k.d(new NavDeepLinkRequest(intent))) != null) {
            NavDestination a2 = d2.a();
            int[] b2 = a2.b();
            bundle.putAll(a2.a(d2.b()));
            intArray = b2;
        }
        if (intArray == null || intArray.length == 0) {
            return false;
        }
        String c2 = c(intArray);
        if (c2 != null) {
            Log.i(f2959a, "Could not find destination " + c2 + " in the navigation graph, ignoring the deep link from " + intent);
            return false;
        }
        bundle.putParcelable(KEY_DEEP_LINK_INTENT, intent);
        int flags = intent.getFlags();
        int i2 = 268435456 & flags;
        if (i2 != 0 && (flags & 32768) == 0) {
            intent.addFlags(32768);
            TaskStackBuilder.create(this.f2966h).addNextIntentWithParentStack(intent).startActivities();
            Activity activity = this.f2967i;
            if (activity != null) {
                activity.finish();
                this.f2967i.overridePendingTransition(0, 0);
            }
            return true;
        }
        if (i2 != 0) {
            if (!this.o.isEmpty()) {
                g(this.k.getId(), true);
            }
            int i3 = 0;
            while (i3 < intArray.length) {
                int i4 = i3 + 1;
                int i5 = intArray[i3];
                NavDestination b3 = b(i5);
                if (b3 == null) {
                    throw new IllegalStateException("Deep Linking failed: destination " + NavDestination.c(this.f2966h, i5) + " cannot be found from the current destination " + getCurrentDestination());
                }
                e(b3, bundle, new NavOptions.Builder().setEnterAnim(0).setExitAnim(0).build(), null);
                i3 = i4;
            }
            return true;
        }
        NavGraph navGraph2 = this.k;
        int i6 = 0;
        while (i6 < intArray.length) {
            int i7 = intArray[i6];
            NavDestination findNode = i6 == 0 ? this.k : navGraph2.findNode(i7);
            if (findNode == null) {
                throw new IllegalStateException("Deep Linking failed: destination " + NavDestination.c(this.f2966h, i7) + " cannot be found in graph " + navGraph2);
            }
            if (i6 != intArray.length - 1) {
                while (true) {
                    navGraph = (NavGraph) findNode;
                    if (!(navGraph.findNode(navGraph.getStartDestination()) instanceof NavGraph)) {
                        break;
                    }
                    findNode = navGraph.findNode(navGraph.getStartDestination());
                }
                navGraph2 = navGraph;
            } else {
                e(findNode, findNode.a(bundle), new NavOptions.Builder().setPopUpTo(this.k.getId(), true).setEnterAnim(0).setExitAnim(0).build(), null);
            }
            i6++;
        }
        this.n = true;
        return true;
    }

    public void navigate(@IdRes int i2) {
        navigate(i2, (Bundle) null);
    }

    public boolean navigateUp() {
        if (d() != 1) {
            return popBackStack();
        }
        NavDestination currentDestination = getCurrentDestination();
        int id = currentDestination.getId();
        for (NavGraph parent = currentDestination.getParent(); parent != null; parent = parent.getParent()) {
            if (parent.getStartDestination() != id) {
                Bundle bundle = new Bundle();
                Activity activity = this.f2967i;
                if (activity != null && activity.getIntent() != null && this.f2967i.getIntent().getData() != null) {
                    bundle.putParcelable(KEY_DEEP_LINK_INTENT, this.f2967i.getIntent());
                    NavDestination.DeepLinkMatch d2 = this.k.d(new NavDeepLinkRequest(this.f2967i.getIntent()));
                    if (d2 != null) {
                        bundle.putAll(d2.a().a(d2.b()));
                    }
                }
                new NavDeepLinkBuilder(this).setDestination(parent.getId()).setArguments(bundle).createTaskStackBuilder().startActivities();
                Activity activity2 = this.f2967i;
                if (activity2 != null) {
                    activity2.finish();
                }
                return true;
            }
            id = parent.getId();
        }
        return false;
    }

    public boolean popBackStack() {
        if (this.o.isEmpty()) {
            return false;
        }
        return popBackStack(getCurrentDestination().getId(), true);
    }

    public void removeOnDestinationChangedListener(@NonNull OnDestinationChangedListener onDestinationChangedListener) {
        this.s.remove(onDestinationChangedListener);
    }

    @CallSuper
    public void restoreState(@Nullable Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(this.f2966h.getClassLoader());
        this.l = bundle.getBundle(f2960b);
        this.m = bundle.getParcelableArray(f2962d);
        this.n = bundle.getBoolean(f2965g);
    }

    @Nullable
    @CallSuper
    public Bundle saveState() {
        Bundle bundle;
        ArrayList<String> arrayList = new ArrayList<>();
        Bundle bundle2 = new Bundle();
        for (Map.Entry<String, Navigator<? extends NavDestination>> entry : this.r.b().entrySet()) {
            String key = entry.getKey();
            Bundle onSaveState = entry.getValue().onSaveState();
            if (onSaveState != null) {
                arrayList.add(key);
                bundle2.putBundle(key, onSaveState);
            }
        }
        if (arrayList.isEmpty()) {
            bundle = null;
        } else {
            bundle = new Bundle();
            bundle2.putStringArrayList(f2961c, arrayList);
            bundle.putBundle(f2960b, bundle2);
        }
        if (!this.o.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Parcelable[] parcelableArr = new Parcelable[this.o.size()];
            int i2 = 0;
            Iterator<NavBackStackEntry> it = this.o.iterator();
            while (it.hasNext()) {
                parcelableArr[i2] = new NavBackStackEntryState(it.next());
                i2++;
            }
            bundle.putParcelableArray(f2962d, parcelableArr);
        }
        if (this.n) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean(f2965g, this.n);
        }
        return bundle;
    }

    @CallSuper
    public void setGraph(@NavigationRes int i2) {
        setGraph(i2, (Bundle) null);
    }

    void setLifecycleOwner(@NonNull LifecycleOwner lifecycleOwner) {
        this.p = lifecycleOwner;
        lifecycleOwner.getLifecycle().addObserver(this.t);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setNavigatorProvider(@NonNull NavigatorProvider navigatorProvider) {
        if (!this.o.isEmpty()) {
            throw new IllegalStateException("NavigatorProvider must be set before setGraph call");
        }
        this.r = navigatorProvider;
    }

    void setOnBackPressedDispatcher(@NonNull OnBackPressedDispatcher onBackPressedDispatcher) {
        if (this.p == null) {
            throw new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()");
        }
        this.u.remove();
        onBackPressedDispatcher.addCallback(this.p, this.u);
    }

    void setViewModelStore(@NonNull ViewModelStore viewModelStore) {
        if (!this.o.isEmpty()) {
            throw new IllegalStateException("ViewModelStore should be set before setGraph call");
        }
        this.q = NavControllerViewModel.g(viewModelStore);
    }

    public void navigate(@IdRes int i2, @Nullable Bundle bundle) {
        navigate(i2, bundle, (NavOptions) null);
    }

    @CallSuper
    public void setGraph(@NavigationRes int i2, @Nullable Bundle bundle) {
        setGraph(getNavInflater().inflate(i2), bundle);
    }

    public void navigate(@IdRes int i2, @Nullable Bundle bundle, @Nullable NavOptions navOptions) {
        navigate(i2, bundle, navOptions, null);
    }

    public boolean popBackStack(@IdRes int i2, boolean z) {
        return g(i2, z) && a();
    }

    @CallSuper
    public void setGraph(@NonNull NavGraph navGraph) {
        setGraph(navGraph, (Bundle) null);
    }

    public void navigate(@IdRes int i2, @Nullable Bundle bundle, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        NavDestination destination;
        int i3;
        if (this.o.isEmpty()) {
            destination = this.k;
        } else {
            destination = this.o.getLast().getDestination();
        }
        if (destination != null) {
            NavAction action = destination.getAction(i2);
            Bundle bundle2 = null;
            if (action != null) {
                if (navOptions == null) {
                    navOptions = action.getNavOptions();
                }
                i3 = action.getDestinationId();
                Bundle defaultArguments = action.getDefaultArguments();
                if (defaultArguments != null) {
                    bundle2 = new Bundle();
                    bundle2.putAll(defaultArguments);
                }
            } else {
                i3 = i2;
            }
            if (bundle != null) {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                bundle2.putAll(bundle);
            }
            if (i3 == 0 && navOptions != null && navOptions.getPopUpTo() != -1) {
                popBackStack(navOptions.getPopUpTo(), navOptions.isPopUpToInclusive());
                return;
            }
            if (i3 != 0) {
                NavDestination b2 = b(i3);
                if (b2 == null) {
                    String c2 = NavDestination.c(this.f2966h, i3);
                    if (action != null) {
                        throw new IllegalArgumentException("Navigation destination " + c2 + " referenced from action " + NavDestination.c(this.f2966h, i2) + " cannot be found from the current destination " + destination);
                    }
                    throw new IllegalArgumentException("Navigation action/destination " + c2 + " cannot be found from the current destination " + destination);
                }
                e(b2, bundle2, navOptions, extras);
                return;
            }
            throw new IllegalArgumentException("Destination id == 0 can only be used in conjunction with a valid navOptions.popUpTo");
        }
        throw new IllegalStateException("no current navigation node");
    }

    @CallSuper
    public void setGraph(@NonNull NavGraph navGraph, @Nullable Bundle bundle) {
        NavGraph navGraph2 = this.k;
        if (navGraph2 != null) {
            g(navGraph2.getId(), true);
        }
        this.k = navGraph;
        f(bundle);
    }

    public void navigate(@NonNull Uri uri) {
        navigate(new NavDeepLinkRequest(uri, null, null));
    }

    public void navigate(@NonNull Uri uri, @Nullable NavOptions navOptions) {
        navigate(new NavDeepLinkRequest(uri, null, null), navOptions);
    }

    public void navigate(@NonNull Uri uri, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        navigate(new NavDeepLinkRequest(uri, null, null), navOptions, extras);
    }

    public void navigate(@NonNull NavDeepLinkRequest navDeepLinkRequest) {
        navigate(navDeepLinkRequest, (NavOptions) null);
    }

    public void navigate(@NonNull NavDeepLinkRequest navDeepLinkRequest, @Nullable NavOptions navOptions) {
        navigate(navDeepLinkRequest, navOptions, (Navigator.Extras) null);
    }

    public void navigate(@NonNull NavDeepLinkRequest navDeepLinkRequest, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        NavDestination.DeepLinkMatch d2 = this.k.d(navDeepLinkRequest);
        if (d2 != null) {
            e(d2.a(), d2.a().a(d2.b()), navOptions, extras);
            return;
        }
        throw new IllegalArgumentException("Navigation destination that matches request " + navDeepLinkRequest + " cannot be found in the navigation graph " + this.k);
    }

    public void navigate(@NonNull NavDirections navDirections) {
        navigate(navDirections.getActionId(), navDirections.getArguments());
    }

    public void navigate(@NonNull NavDirections navDirections, @Nullable NavOptions navOptions) {
        navigate(navDirections.getActionId(), navDirections.getArguments(), navOptions);
    }

    public void navigate(@NonNull NavDirections navDirections, @NonNull Navigator.Extras extras) {
        navigate(navDirections.getActionId(), navDirections.getArguments(), null, extras);
    }
}
