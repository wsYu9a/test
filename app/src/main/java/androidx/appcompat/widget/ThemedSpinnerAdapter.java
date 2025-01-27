package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.widget.SpinnerAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.ContextThemeWrapper;

/* loaded from: classes.dex */
public interface ThemedSpinnerAdapter extends SpinnerAdapter {

    public static final class Helper {

        /* renamed from: a */
        private final Context f971a;

        /* renamed from: b */
        private final LayoutInflater f972b;

        /* renamed from: c */
        private LayoutInflater f973c;

        public Helper(@NonNull Context context) {
            this.f971a = context;
            this.f972b = LayoutInflater.from(context);
        }

        @NonNull
        public LayoutInflater getDropDownViewInflater() {
            LayoutInflater layoutInflater = this.f973c;
            return layoutInflater != null ? layoutInflater : this.f972b;
        }

        @Nullable
        public Resources.Theme getDropDownViewTheme() {
            LayoutInflater layoutInflater = this.f973c;
            if (layoutInflater == null) {
                return null;
            }
            return layoutInflater.getContext().getTheme();
        }

        public void setDropDownViewTheme(@Nullable Resources.Theme theme) {
            if (theme == null) {
                this.f973c = null;
            } else if (theme == this.f971a.getTheme()) {
                this.f973c = this.f972b;
            } else {
                this.f973c = LayoutInflater.from(new ContextThemeWrapper(this.f971a, theme));
            }
        }
    }

    @Nullable
    Resources.Theme getDropDownViewTheme();

    void setDropDownViewTheme(@Nullable Resources.Theme theme);
}
