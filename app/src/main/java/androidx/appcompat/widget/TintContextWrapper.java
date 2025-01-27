package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class TintContextWrapper extends ContextWrapper {

    /* renamed from: a */
    private static final Object f974a = new Object();

    /* renamed from: b */
    private static ArrayList<WeakReference<TintContextWrapper>> f975b;

    /* renamed from: c */
    private final Resources f976c;

    /* renamed from: d */
    private final Resources.Theme f977d;

    private TintContextWrapper(@NonNull Context context) {
        super(context);
        if (!VectorEnabledTintResources.shouldBeUsed()) {
            this.f976c = new TintResources(this, context.getResources());
            this.f977d = null;
            return;
        }
        VectorEnabledTintResources vectorEnabledTintResources = new VectorEnabledTintResources(this, context.getResources());
        this.f976c = vectorEnabledTintResources;
        Resources.Theme newTheme = vectorEnabledTintResources.newTheme();
        this.f977d = newTheme;
        newTheme.setTo(context.getTheme());
    }

    private static boolean a(@NonNull Context context) {
        if ((context instanceof TintContextWrapper) || (context.getResources() instanceof TintResources) || (context.getResources() instanceof VectorEnabledTintResources)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || VectorEnabledTintResources.shouldBeUsed();
    }

    public static Context wrap(@NonNull Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (f974a) {
            ArrayList<WeakReference<TintContextWrapper>> arrayList = f975b;
            if (arrayList == null) {
                f975b = new ArrayList<>();
            } else {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    WeakReference<TintContextWrapper> weakReference = f975b.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f975b.remove(size);
                    }
                }
                for (int size2 = f975b.size() - 1; size2 >= 0; size2--) {
                    WeakReference<TintContextWrapper> weakReference2 = f975b.get(size2);
                    TintContextWrapper tintContextWrapper = weakReference2 != null ? weakReference2.get() : null;
                    if (tintContextWrapper != null && tintContextWrapper.getBaseContext() == context) {
                        return tintContextWrapper;
                    }
                }
            }
            TintContextWrapper tintContextWrapper2 = new TintContextWrapper(context);
            f975b.add(new WeakReference<>(tintContextWrapper2));
            return tintContextWrapper2;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f976c.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f976c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f977d;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        Resources.Theme theme = this.f977d;
        if (theme == null) {
            super.setTheme(i2);
        } else {
            theme.applyStyle(i2, true);
        }
    }
}
