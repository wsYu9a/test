package ki;

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

/* loaded from: classes4.dex */
public final class d extends ContextWrapper {

    /* renamed from: a */
    @NonNull
    public Toast f27839a;

    /* renamed from: b */
    @Nullable
    public ki.a f27840b;

    public final class b extends ContextWrapper {
        public /* synthetic */ b(d dVar, Context context, a aVar) {
            this(context);
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(@NonNull String str) {
            return "window".equals(str) ? new c((WindowManager) getBaseContext().getSystemService(str)) : super.getSystemService(str);
        }

        public b(@NonNull Context context) {
            super(context);
        }
    }

    public final class c implements WindowManager {

        /* renamed from: d */
        public static final String f27842d = "WindowManagerWrapper";

        /* renamed from: b */
        @NonNull
        public final WindowManager f27843b;

        public /* synthetic */ c(d dVar, WindowManager windowManager, a aVar) {
            this(windowManager);
        }

        @Override // android.view.ViewManager
        public void addView(View view, ViewGroup.LayoutParams layoutParams) {
            try {
                Log.d(f27842d, "WindowManager's addView(view, params) has been hooked.");
                this.f27843b.addView(view, layoutParams);
            } catch (WindowManager.BadTokenException e10) {
                Log.i(f27842d, e10.getMessage());
                if (d.this.f27840b != null) {
                    d.this.f27840b.a(d.this.f27839a);
                }
            } catch (Throwable th2) {
                Log.e(f27842d, "[addView]", th2);
            }
        }

        @Override // android.view.WindowManager
        public Display getDefaultDisplay() {
            return this.f27843b.getDefaultDisplay();
        }

        @Override // android.view.ViewManager
        public void removeView(View view) {
            this.f27843b.removeView(view);
        }

        @Override // android.view.WindowManager
        public void removeViewImmediate(View view) {
            this.f27843b.removeViewImmediate(view);
        }

        @Override // android.view.ViewManager
        public void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams) {
            this.f27843b.updateViewLayout(view, layoutParams);
        }

        public c(@NonNull WindowManager windowManager) {
            this.f27843b = windowManager;
        }
    }

    public d(@NonNull Context context, @NonNull Toast toast) {
        super(context);
        this.f27839a = toast;
    }

    public void c(@NonNull ki.a aVar) {
        this.f27840b = aVar;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return new b(getBaseContext().getApplicationContext());
    }
}
