package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.annotation.CallSuper;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SparseArrayCompat;
import androidx.navigation.NavDeepLink;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class NavDestination {

    /* renamed from: a */
    private static final HashMap<String, Class<?>> f3003a = new HashMap<>();

    /* renamed from: b */
    private final String f3004b;

    /* renamed from: c */
    private NavGraph f3005c;

    /* renamed from: d */
    private int f3006d;

    /* renamed from: e */
    private String f3007e;

    /* renamed from: f */
    private CharSequence f3008f;

    /* renamed from: g */
    private ArrayList<NavDeepLink> f3009g;

    /* renamed from: h */
    private SparseArrayCompat<NavAction> f3010h;

    /* renamed from: i */
    private HashMap<String, NavArgument> f3011i;

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.CLASS)
    public @interface ClassType {
        Class<?> value();
    }

    static class DeepLinkMatch implements Comparable<DeepLinkMatch> {

        /* renamed from: a */
        @NonNull
        private final NavDestination f3012a;

        /* renamed from: b */
        @Nullable
        private final Bundle f3013b;

        /* renamed from: c */
        private final boolean f3014c;

        /* renamed from: d */
        private final boolean f3015d;

        /* renamed from: e */
        private final int f3016e;

        DeepLinkMatch(@NonNull NavDestination navDestination, @Nullable Bundle bundle, boolean z, boolean z2, int i2) {
            this.f3012a = navDestination;
            this.f3013b = bundle;
            this.f3014c = z;
            this.f3015d = z2;
            this.f3016e = i2;
        }

        @NonNull
        NavDestination a() {
            return this.f3012a;
        }

        @Nullable
        Bundle b() {
            return this.f3013b;
        }

        @Override // java.lang.Comparable
        public int compareTo(@NonNull DeepLinkMatch deepLinkMatch) {
            boolean z = this.f3014c;
            if (z && !deepLinkMatch.f3014c) {
                return 1;
            }
            if (!z && deepLinkMatch.f3014c) {
                return -1;
            }
            Bundle bundle = this.f3013b;
            if (bundle != null && deepLinkMatch.f3013b == null) {
                return 1;
            }
            if (bundle == null && deepLinkMatch.f3013b != null) {
                return -1;
            }
            if (bundle != null) {
                int size = bundle.size() - deepLinkMatch.f3013b.size();
                if (size > 0) {
                    return 1;
                }
                if (size < 0) {
                    return -1;
                }
            }
            boolean z2 = this.f3015d;
            if (z2 && !deepLinkMatch.f3015d) {
                return 1;
            }
            if (z2 || !deepLinkMatch.f3015d) {
                return this.f3016e - deepLinkMatch.f3016e;
            }
            return -1;
        }
    }

    public NavDestination(@NonNull Navigator<? extends NavDestination> navigator) {
        this(NavigatorProvider.a(navigator.getClass()));
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    static String c(@NonNull Context context, int i2) {
        if (i2 <= 16777215) {
            return Integer.toString(i2);
        }
        try {
            return context.getResources().getResourceName(i2);
        } catch (Resources.NotFoundException unused) {
            return Integer.toString(i2);
        }
    }

    @NonNull
    protected static <C> Class<? extends C> e(@NonNull Context context, @NonNull String str, @NonNull Class<? extends C> cls) {
        if (str.charAt(0) == '.') {
            str = context.getPackageName() + str;
        }
        HashMap<String, Class<?>> hashMap = f3003a;
        Class<? extends C> cls2 = (Class<? extends C>) hashMap.get(str);
        if (cls2 == null) {
            try {
                cls2 = (Class<? extends C>) Class.forName(str, true, context.getClassLoader());
                hashMap.put(str, cls2);
            } catch (ClassNotFoundException e2) {
                throw new IllegalArgumentException(e2);
            }
        }
        if (cls.isAssignableFrom(cls2)) {
            return cls2;
        }
        throw new IllegalArgumentException(str + " must be a subclass of " + cls);
    }

    @Nullable
    Bundle a(@Nullable Bundle bundle) {
        HashMap<String, NavArgument> hashMap;
        if (bundle == null && ((hashMap = this.f3011i) == null || hashMap.isEmpty())) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        HashMap<String, NavArgument> hashMap2 = this.f3011i;
        if (hashMap2 != null) {
            for (Map.Entry<String, NavArgument> entry : hashMap2.entrySet()) {
                entry.getValue().a(entry.getKey(), bundle2);
            }
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
            HashMap<String, NavArgument> hashMap3 = this.f3011i;
            if (hashMap3 != null) {
                for (Map.Entry<String, NavArgument> entry2 : hashMap3.entrySet()) {
                    if (!entry2.getValue().b(entry2.getKey(), bundle)) {
                        throw new IllegalArgumentException("Wrong argument type for '" + entry2.getKey() + "' in argument bundle. " + entry2.getValue().getType().getName() + " expected.");
                    }
                }
            }
        }
        return bundle2;
    }

    public final void addArgument(@NonNull String str, @NonNull NavArgument navArgument) {
        if (this.f3011i == null) {
            this.f3011i = new HashMap<>();
        }
        this.f3011i.put(str, navArgument);
    }

    public final void addDeepLink(@NonNull String str) {
        addDeepLink(new NavDeepLink.Builder().setUriPattern(str).build());
    }

    @NonNull
    int[] b() {
        ArrayDeque arrayDeque = new ArrayDeque();
        NavDestination navDestination = this;
        while (true) {
            NavGraph parent = navDestination.getParent();
            if (parent == null || parent.getStartDestination() != navDestination.getId()) {
                arrayDeque.addFirst(navDestination);
            }
            if (parent == null) {
                break;
            }
            navDestination = parent;
        }
        int[] iArr = new int[arrayDeque.size()];
        int i2 = 0;
        Iterator it = arrayDeque.iterator();
        while (it.hasNext()) {
            iArr[i2] = ((NavDestination) it.next()).getId();
            i2++;
        }
        return iArr;
    }

    @Nullable
    DeepLinkMatch d(@NonNull NavDeepLinkRequest navDeepLinkRequest) {
        ArrayList<NavDeepLink> arrayList = this.f3009g;
        if (arrayList == null) {
            return null;
        }
        Iterator<NavDeepLink> it = arrayList.iterator();
        DeepLinkMatch deepLinkMatch = null;
        while (it.hasNext()) {
            NavDeepLink next = it.next();
            Uri uri = navDeepLinkRequest.getUri();
            Bundle b2 = uri != null ? next.b(uri, getArguments()) : null;
            String action = navDeepLinkRequest.getAction();
            boolean z = action != null && action.equals(next.getAction());
            String mimeType = navDeepLinkRequest.getMimeType();
            int c2 = mimeType != null ? next.c(mimeType) : -1;
            if (b2 != null || z || c2 > -1) {
                DeepLinkMatch deepLinkMatch2 = new DeepLinkMatch(this, b2, next.d(), z, c2);
                if (deepLinkMatch == null || deepLinkMatch2.compareTo(deepLinkMatch) > 0) {
                    deepLinkMatch = deepLinkMatch2;
                }
            }
        }
        return deepLinkMatch;
    }

    final void f(NavGraph navGraph) {
        this.f3005c = navGraph;
    }

    boolean g() {
        return true;
    }

    @Nullable
    public final NavAction getAction(@IdRes int i2) {
        SparseArrayCompat<NavAction> sparseArrayCompat = this.f3010h;
        NavAction navAction = sparseArrayCompat == null ? null : sparseArrayCompat.get(i2);
        if (navAction != null) {
            return navAction;
        }
        if (getParent() != null) {
            return getParent().getAction(i2);
        }
        return null;
    }

    @NonNull
    public final Map<String, NavArgument> getArguments() {
        HashMap<String, NavArgument> hashMap = this.f3011i;
        return hashMap == null ? Collections.emptyMap() : Collections.unmodifiableMap(hashMap);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getDisplayName() {
        if (this.f3007e == null) {
            this.f3007e = Integer.toString(this.f3006d);
        }
        return this.f3007e;
    }

    @IdRes
    public final int getId() {
        return this.f3006d;
    }

    @Nullable
    public final CharSequence getLabel() {
        return this.f3008f;
    }

    @NonNull
    public final String getNavigatorName() {
        return this.f3004b;
    }

    @Nullable
    public final NavGraph getParent() {
        return this.f3005c;
    }

    public boolean hasDeepLink(@NonNull Uri uri) {
        return hasDeepLink(new NavDeepLinkRequest(uri, null, null));
    }

    @CallSuper
    public void onInflate(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, androidx.navigation.common.R.styleable.Navigator);
        setId(obtainAttributes.getResourceId(androidx.navigation.common.R.styleable.Navigator_android_id, 0));
        this.f3007e = c(context, this.f3006d);
        setLabel(obtainAttributes.getText(androidx.navigation.common.R.styleable.Navigator_android_label));
        obtainAttributes.recycle();
    }

    public final void putAction(@IdRes int i2, @IdRes int i3) {
        putAction(i2, new NavAction(i3));
    }

    public final void removeAction(@IdRes int i2) {
        SparseArrayCompat<NavAction> sparseArrayCompat = this.f3010h;
        if (sparseArrayCompat == null) {
            return;
        }
        sparseArrayCompat.remove(i2);
    }

    public final void removeArgument(@NonNull String str) {
        HashMap<String, NavArgument> hashMap = this.f3011i;
        if (hashMap == null) {
            return;
        }
        hashMap.remove(str);
    }

    public final void setId(@IdRes int i2) {
        this.f3006d = i2;
        this.f3007e = null;
    }

    public final void setLabel(@Nullable CharSequence charSequence) {
        this.f3008f = charSequence;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        String str = this.f3007e;
        if (str == null) {
            sb.append("0x");
            sb.append(Integer.toHexString(this.f3006d));
        } else {
            sb.append(str);
        }
        sb.append(")");
        if (this.f3008f != null) {
            sb.append(" label=");
            sb.append(this.f3008f);
        }
        return sb.toString();
    }

    public NavDestination(@NonNull String str) {
        this.f3004b = str;
    }

    public final void addDeepLink(@NonNull NavDeepLink navDeepLink) {
        if (this.f3009g == null) {
            this.f3009g = new ArrayList<>();
        }
        this.f3009g.add(navDeepLink);
    }

    public boolean hasDeepLink(@NonNull NavDeepLinkRequest navDeepLinkRequest) {
        return d(navDeepLinkRequest) != null;
    }

    public final void putAction(@IdRes int i2, @NonNull NavAction navAction) {
        if (g()) {
            if (i2 == 0) {
                throw new IllegalArgumentException("Cannot have an action with actionId 0");
            }
            if (this.f3010h == null) {
                this.f3010h = new SparseArrayCompat<>();
            }
            this.f3010h.put(i2, navAction);
            return;
        }
        throw new UnsupportedOperationException("Cannot add action " + i2 + " to " + this + " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
    }
}
