package com.martian.libmars.common;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.czhj.sdk.common.Constants;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import l9.p0;
import xi.k;
import xi.l;

/* loaded from: classes3.dex */
public final class ActivityHooker {

    /* renamed from: a */
    @k
    public static final ActivityHooker f12078a = new ActivityHooker();

    /* renamed from: b */
    @k
    public static final String f12079b = "ActivityHooker";

    /* renamed from: c */
    @k
    public static final String f12080c = "execStartActivity";

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003JL\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/martian/libmars/common/ActivityHooker$InstrumentationProxy;", "Landroid/app/Instrumentation;", "original", "(Landroid/app/Instrumentation;)V", "execStartActivityMethod", "Ljava/lang/reflect/Method;", "getExecStartActivityMethod", "()Ljava/lang/reflect/Method;", "execStartActivityMethod$delegate", "Lkotlin/Lazy;", ActivityHooker.f12080c, "Landroid/app/Instrumentation$ActivityResult;", "who", "Landroid/content/Context;", "contextThread", "Landroid/os/IBinder;", Constants.TOKEN, "target", "Landroid/app/Activity;", "intent", "Landroid/content/Intent;", "requestCode", "", "options", "Landroid/os/Bundle;", "shouldBlockIntent", "", "libmars_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class InstrumentationProxy extends Instrumentation {

        /* renamed from: execStartActivityMethod$delegate, reason: from kotlin metadata */
        @k
        private final Lazy execStartActivityMethod;

        @k
        private final Instrumentation original;

        public InstrumentationProxy(@k Instrumentation original) {
            Intrinsics.checkNotNullParameter(original, "original");
            this.original = original;
            this.execStartActivityMethod = LazyKt.lazy(ActivityHooker$InstrumentationProxy$execStartActivityMethod$2.INSTANCE);
        }

        private final Method getExecStartActivityMethod() {
            return (Method) this.execStartActivityMethod.getValue();
        }

        private final boolean shouldBlockIntent(Intent intent) {
            String dataString;
            if (intent == null || (dataString = intent.getDataString()) == null) {
                return false;
            }
            boolean areEqual = Intrinsics.areEqual(intent.getScheme(), "hap");
            if (areEqual) {
                p0.c(ActivityHooker.f12079b, "Blocking Activity Launch: Uri = [" + dataString + "]");
            }
            return areEqual;
        }

        @l
        public final Instrumentation.ActivityResult execStartActivity(@l Context context, @l IBinder iBinder, @l IBinder iBinder2, @l Activity activity, @l Intent intent, int i10, @l Bundle bundle) {
            if (shouldBlockIntent(intent)) {
                p0.c(ActivityHooker.f12079b, "Blocked Intent: " + intent);
                return null;
            }
            Method execStartActivityMethod = getExecStartActivityMethod();
            if (execStartActivityMethod == null) {
                throw new IllegalStateException("execStartActivityMethod is null. Hooking may have failed.");
            }
            try {
                Object invoke = execStartActivityMethod.invoke(this.original, context, iBinder, iBinder2, activity, intent, Integer.valueOf(i10), bundle);
                if (invoke instanceof Instrumentation.ActivityResult) {
                    return (Instrumentation.ActivityResult) invoke;
                }
                return null;
            } catch (Exception e10) {
                p0.c(ActivityHooker.f12079b, "Failed to invoke execStartActivity: " + e10.getMessage());
                throw e10;
            }
        }
    }

    @JvmStatic
    @SuppressLint({"PrivateApi", "DiscouragedPrivateApi"})
    public static final void a() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", null);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, null);
            Field declaredField = cls.getDeclaredField("mInstrumentation");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(invoke);
            Instrumentation instrumentation = obj instanceof Instrumentation ? (Instrumentation) obj : null;
            if (instrumentation != null) {
                declaredField.set(invoke, new InstrumentationProxy(instrumentation));
            }
        } catch (Exception e10) {
            p0.c(f12079b, "Failed to hook Instrumentation: " + e10.getMessage());
        }
    }
}
