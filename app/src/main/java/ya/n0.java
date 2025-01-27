package ya;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.mvvm.tts.TTSReadManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;

@SourceDebugExtension({"SMAP\nLifecycleManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LifecycleManager.kt\ncom/martian/mibook/application/LifecycleManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,157:1\n1855#2,2:158\n1855#2,2:160\n1855#2,2:162\n1864#2,3:164\n1855#2,2:167\n1855#2,2:169\n*S KotlinDebug\n*F\n+ 1 LifecycleManager.kt\ncom/martian/mibook/application/LifecycleManager\n*L\n28#1:158,2\n39#1:160,2\n52#1:162,2\n68#1:164,3\n79#1:167,2\n101#1:169,2\n*E\n"})
/* loaded from: classes3.dex */
public final class n0 implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    @xi.k
    public static final n0 f33313a = new n0();

    /* renamed from: b */
    @xi.k
    public static final List<WeakReference<Activity>> f33314b = new ArrayList();

    /* renamed from: c */
    @xi.l
    public static WeakReference<Activity> f33315c;

    public final int a() {
        return f33314b.size();
    }

    public final void b(@xi.k Class<?>... activityClasses) {
        Intrinsics.checkNotNullParameter(activityClasses, "activityClasses");
        ArrayList arrayList = new ArrayList();
        for (WeakReference<Activity> weakReference : f33314b) {
            int length = activityClasses.length;
            int i10 = 0;
            while (true) {
                if (i10 < length) {
                    Class<?> cls = activityClasses[i10];
                    Activity activity = weakReference.get();
                    if (Intrinsics.areEqual(activity != null ? activity.getClass() : null, cls)) {
                        arrayList.add(weakReference);
                        break;
                    }
                    i10++;
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Activity activity2 = (Activity) ((WeakReference) it.next()).get();
            if (activity2 != null) {
                activity2.finish();
            }
        }
    }

    @xi.l
    public final Activity c() {
        WeakReference<Activity> weakReference = f33315c;
        if (weakReference == null || weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @xi.l
    public final List<WeakReference<Activity>> d(@xi.l Class<?> cls) {
        ArrayList arrayList = null;
        for (WeakReference<Activity> weakReference : f33314b) {
            Activity activity = weakReference.get();
            if (Intrinsics.areEqual(activity != null ? activity.getClass() : null, cls)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(weakReference);
            }
        }
        return arrayList;
    }

    @xi.l
    public final WeakReference<Activity> e(@xi.l Activity activity) {
        int i10;
        if (activity == null) {
            return null;
        }
        int i11 = 0;
        for (Object obj : f33314b) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(((WeakReference) obj).get(), activity) && i11 - 1 >= 0) {
                return f33314b.get(i10);
            }
            i11 = i12;
        }
        return null;
    }

    public final WeakReference<Activity> f(Activity activity) {
        for (WeakReference<Activity> weakReference : f33314b) {
            if (Intrinsics.areEqual(weakReference.get(), activity)) {
                return weakReference;
            }
        }
        return null;
    }

    public final void g(Activity activity) {
        WeakReference<Activity> weakReference;
        f33315c = new WeakReference<>(activity);
        List<WeakReference<Activity>> list = f33314b;
        WeakReference weakReference2 = (WeakReference) CollectionsKt.lastOrNull((List) list);
        if (h(activity)) {
            if (Intrinsics.areEqual(weakReference2 != null ? (Activity) weakReference2.get() : null, activity) || (weakReference = f33315c) == null) {
                return;
            }
            TypeIntrinsics.asMutableCollection(list).remove(f33313a.f(activity));
            list.add(weakReference);
        }
    }

    public final boolean h(Activity activity) {
        Iterator<T> it = f33314b.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(((WeakReference) it.next()).get(), activity)) {
                return true;
            }
        }
        return false;
    }

    public final boolean i(@xi.l Class<?> cls) {
        Iterator<T> it = f33314b.iterator();
        while (it.hasNext()) {
            Activity activity = (Activity) ((WeakReference) it.next()).get();
            if (Intrinsics.areEqual(activity != null ? activity.getClass() : null, cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@xi.k Activity activity, @xi.l Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        f33314b.add(new WeakReference<>(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@xi.k Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        for (WeakReference<Activity> weakReference : f33314b) {
            if (weakReference.get() != null && weakReference.get() == activity) {
                f33314b.remove(weakReference);
                return;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@xi.k Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@xi.k Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        g(activity);
        if (MiConfigSingleton.b2().H1().i0() && b8.h.D(activity)) {
            MiConfigSingleton.b2().H1().P0(false);
        }
        ab.a.a().c(activity.getLocalClassName());
        if (TTSReadManager.q() && (activity instanceof FragmentActivity)) {
            id.i.g((FragmentActivity) activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@xi.k Activity activity, @xi.k Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@xi.k Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@xi.k Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }
}
