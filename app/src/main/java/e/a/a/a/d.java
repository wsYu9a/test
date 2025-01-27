package e.a.a.a;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes5.dex */
final class d extends ContextWrapper {

    /* renamed from: a */
    @NonNull
    private Toast f35236a;

    /* renamed from: b */
    @Nullable
    private e.a.a.a.a f35237b;

    private final class b extends ContextWrapper {
        /* synthetic */ b(d dVar, Context context, a aVar) {
            this(context);
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(@NonNull String str) {
            return "window".equals(str) ? new c((WindowManager) getBaseContext().getSystemService(str)) : super.getSystemService(str);
        }

        private b(@NonNull Context context) {
            super(context);
        }
    }

    private final class c implements WindowManager {

        /* renamed from: a */
        private static final String f35239a = "WindowManagerWrapper";

        /* renamed from: b */
        @NonNull
        private final WindowManager f35240b;

        /* synthetic */ c(d dVar, WindowManager windowManager, a aVar) {
            this(windowManager);
        }

        @Override // android.view.ViewManager
        public void addView(View view, ViewGroup.LayoutParams layoutParams) {
            try {
                Log.d(f35239a, "WindowManager's addView(view, params) has been hooked.");
                this.f35240b.addView(view, layoutParams);
            } catch (WindowManager.BadTokenException e2) {
                Log.i(f35239a, e2.getMessage());
                if (d.this.f35237b != null) {
                    d.this.f35237b.a(d.this.f35236a);
                }
            } catch (Throwable th) {
                Log.e(f35239a, "[addView]", th);
            }
        }

        @Override // android.view.WindowManager
        public Display getDefaultDisplay() {
            return this.f35240b.getDefaultDisplay();
        }

        @Override // android.view.ViewManager
        public void removeView(View view) {
            this.f35240b.removeView(view);
        }

        @Override // android.view.WindowManager
        public void removeViewImmediate(View view) {
            this.f35240b.removeViewImmediate(view);
        }

        @Override // android.view.ViewManager
        public void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams) {
            this.f35240b.updateViewLayout(view, layoutParams);
        }

        private c(@NonNull WindowManager windowManager) {
            this.f35240b = windowManager;
        }
    }

    d(@NonNull Context context, @NonNull Toast toast) {
        super(context);
        this.f35236a = toast;
    }

    public void c(@NonNull e.a.a.a.a aVar) {
        this.f35237b = aVar;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return new b(getBaseContext().getApplicationContext());
    }
}
