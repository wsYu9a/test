package lc;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.ViewModelProvider;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a */
    @xi.k
    public static final b f28081a = new b();

    /* renamed from: b */
    @xi.l
    public static AppViewModel f28082b;

    @JvmStatic
    @xi.l
    public static final AppViewModel a(@xi.l Context context) {
        if (f28082b == null) {
            synchronized (f28081a) {
                try {
                    if (f28082b == null) {
                        Context applicationContext = context != null ? context.getApplicationContext() : null;
                        Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
                        if (application != null) {
                            f28082b = (AppViewModel) ViewModelProvider.AndroidViewModelFactory.INSTANCE.getInstance(application).create(AppViewModel.class);
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f28082b;
    }
}
