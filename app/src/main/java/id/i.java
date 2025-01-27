package id;

import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import com.martian.libmars.activity.PermissionActivity;
import com.martian.mibook.activity.EnterActivity;
import com.martian.mibook.activity.EnterRestartActivity;
import com.martian.mibook.lib.account.activity.PhoneLoginActivity;
import com.martian.mibook.lib.account.activity.PopupLoginActivity;
import com.martian.mibook.mvvm.read.activity.ReadingNewActivity;
import com.martian.mibook.mvvm.tts.TTSFloatWidget;
import com.martian.mibook.mvvm.tts.activity.AudiobookActivity;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import xi.k;
import xi.l;

@SourceDebugExtension({"SMAP\nTTSFloatWidgetManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TTSFloatWidgetManager.kt\ncom/martian/mibook/mvvm/tts/TTSFloatWidgetManager\n+ 2 ArrayMap.kt\nandroidx/collection/ArrayMapKt\n*L\n1#1,96:1\n22#2:97\n22#2:98\n22#2:99\n*S KotlinDebug\n*F\n+ 1 TTSFloatWidgetManager.kt\ncom/martian/mibook/mvvm/tts/TTSFloatWidgetManager\n*L\n46#1:97\n64#1:98\n79#1:99\n*E\n"})
/* loaded from: classes3.dex */
public final class i {

    /* renamed from: a */
    @k
    public static final i f26978a = new i();

    /* renamed from: b */
    @l
    public static Map<FragmentActivity, TTSFloatWidget> f26979b;

    @JvmStatic
    public static final synchronized void a(@k FragmentActivity fragmentActivity, @l ViewGroup viewGroup) {
        synchronized (i.class) {
            try {
                Intrinsics.checkNotNullParameter(fragmentActivity, "fragmentActivity");
                if (f26979b == null) {
                    f26979b = new ArrayMap();
                }
                Map<FragmentActivity, TTSFloatWidget> map = f26979b;
                TTSFloatWidget tTSFloatWidget = map != null ? map.get(fragmentActivity) : null;
                if (tTSFloatWidget != null) {
                    tTSFloatWidget.g();
                } else {
                    TTSFloatWidget tTSFloatWidget2 = new TTSFloatWidget(fragmentActivity, viewGroup);
                    tTSFloatWidget2.g();
                    Map<FragmentActivity, TTSFloatWidget> map2 = f26979b;
                    if (map2 != null) {
                        map2.put(fragmentActivity, tTSFloatWidget2);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @JvmStatic
    public static final synchronized boolean e(@k FragmentActivity fragmentActivity) {
        boolean z10;
        synchronized (i.class) {
            try {
                Intrinsics.checkNotNullParameter(fragmentActivity, "fragmentActivity");
                if (f26979b == null) {
                    f26979b = new ArrayMap();
                }
                Map<FragmentActivity, TTSFloatWidget> map = f26979b;
                z10 = (map != null ? map.get(fragmentActivity) : null) != null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return z10;
    }

    @JvmStatic
    public static final void f(@k FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "fragmentActivity");
        Map<FragmentActivity, TTSFloatWidget> map = f26979b;
        TTSFloatWidget tTSFloatWidget = map != null ? map.get(fragmentActivity) : null;
        if (tTSFloatWidget != null) {
            tTSFloatWidget.u();
        }
        Map<FragmentActivity, TTSFloatWidget> map2 = f26979b;
        if (map2 != null) {
            map2.remove(fragmentActivity);
        }
    }

    @JvmStatic
    public static final void g(@k FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "fragmentActivity");
        i iVar = f26978a;
        if (iVar.d(fragmentActivity.getClass())) {
            iVar.b(fragmentActivity);
        }
    }

    public final synchronized void b(FragmentActivity fragmentActivity) {
        try {
            if (f26979b == null) {
                f26979b = new ArrayMap();
            }
            Map<FragmentActivity, TTSFloatWidget> map = f26979b;
            TTSFloatWidget tTSFloatWidget = map != null ? map.get(fragmentActivity) : null;
            if (tTSFloatWidget != null) {
                tTSFloatWidget.g();
            } else {
                TTSFloatWidget tTSFloatWidget2 = new TTSFloatWidget(fragmentActivity, null, 2, null);
                tTSFloatWidget2.g();
                Map<FragmentActivity, TTSFloatWidget> map2 = f26979b;
                if (map2 != null) {
                    map2.put(fragmentActivity, tTSFloatWidget2);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void c() {
        try {
            Map<FragmentActivity, TTSFloatWidget> map = f26979b;
            if (map != null) {
                map.clear();
            }
            f26979b = null;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final boolean d(Class<?> cls) {
        return (Intrinsics.areEqual(cls, ReadingNewActivity.class) || Intrinsics.areEqual(cls, AudiobookActivity.class) || Intrinsics.areEqual(cls, EnterActivity.class) || Intrinsics.areEqual(cls, PopupLoginActivity.class) || Intrinsics.areEqual(cls, PhoneLoginActivity.class) || Intrinsics.areEqual(cls, PermissionActivity.class) || Intrinsics.areEqual(cls, EnterRestartActivity.class)) ? false : true;
    }
}
