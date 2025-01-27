package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.collection.ArrayMap;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: classes.dex */
public class AppCompatViewInflater {

    /* renamed from: d */
    private static final String f275d = "AppCompatViewInflater";

    /* renamed from: f */
    private final Object[] f277f = new Object[2];

    /* renamed from: a */
    private static final Class<?>[] f272a = {Context.class, AttributeSet.class};

    /* renamed from: b */
    private static final int[] f273b = {R.attr.onClick};

    /* renamed from: c */
    private static final String[] f274c = {"android.widget.", "android.view.", "android.webkit."};

    /* renamed from: e */
    private static final Map<String, Constructor<? extends View>> f276e = new ArrayMap();

    private static class DeclaredOnClickListener implements View.OnClickListener {

        /* renamed from: a */
        private final View f278a;

        /* renamed from: b */
        private final String f279b;

        /* renamed from: c */
        private Method f280c;

        /* renamed from: d */
        private Context f281d;

        public DeclaredOnClickListener(@NonNull View view, @NonNull String str) {
            this.f278a = view;
            this.f279b = str;
        }

        @NonNull
        private void a(@Nullable Context context, @NonNull String str) {
            String str2;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.f279b, View.class)) != null) {
                        this.f280c = method;
                        this.f281d = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            int id = this.f278a.getId();
            if (id == -1) {
                str2 = "";
            } else {
                str2 = " with id '" + this.f278a.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.f279b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f278a.getClass() + str2);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@NonNull View view) {
            if (this.f280c == null) {
                a(this.f278a.getContext(), this.f279b);
            }
            try {
                this.f280c.invoke(this.f281d, view);
            } catch (IllegalAccessException e2) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e2);
            } catch (InvocationTargetException e3) {
                throw new IllegalStateException("Could not execute method for android:onClick", e3);
            }
        }
    }

    private void a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (context instanceof ContextWrapper) {
            if (Build.VERSION.SDK_INT < 15 || ViewCompat.hasOnClickListeners(view)) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f273b);
                String string = obtainStyledAttributes.getString(0);
                if (string != null) {
                    view.setOnClickListener(new DeclaredOnClickListener(view, string));
                }
                obtainStyledAttributes.recycle();
            }
        }
    }

    private View r(Context context, String str, String str2) throws ClassNotFoundException, InflateException {
        String str3;
        Map<String, Constructor<? extends View>> map = f276e;
        Constructor<? extends View> constructor = map.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            constructor = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f272a);
            map.put(str, constructor);
        }
        constructor.setAccessible(true);
        return constructor.newInstance(this.f277f);
    }

    private View s(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            Object[] objArr = this.f277f;
            objArr[0] = context;
            objArr[1] = attributeSet;
            if (-1 != str.indexOf(46)) {
                return r(context, str, null);
            }
            int i2 = 0;
            while (true) {
                String[] strArr = f274c;
                if (i2 >= strArr.length) {
                    return null;
                }
                View r = r(context, str, strArr[i2]);
                if (r != null) {
                    return r;
                }
                i2++;
            }
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr2 = this.f277f;
            objArr2[0] = null;
            objArr2[1] = null;
        }
    }

    private static Context t(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.appcompat.R.styleable.View, 0, 0);
        int resourceId = z ? obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.View_android_theme, 0) : 0;
        if (z2 && resourceId == 0 && (resourceId = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.View_theme, 0)) != 0) {
            Log.i(f275d, "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        obtainStyledAttributes.recycle();
        return resourceId != 0 ? ((context instanceof ContextThemeWrapper) && ((ContextThemeWrapper) context).getThemeResId() == resourceId) ? context : new ContextThemeWrapper(context, resourceId) : context;
    }

    private void u(View view, String str) {
        if (view != null) {
            return;
        }
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
    }

    @NonNull
    protected AppCompatAutoCompleteTextView b(Context context, AttributeSet attributeSet) {
        return new AppCompatAutoCompleteTextView(context, attributeSet);
    }

    @NonNull
    protected AppCompatButton c(Context context, AttributeSet attributeSet) {
        return new AppCompatButton(context, attributeSet);
    }

    @NonNull
    protected AppCompatCheckBox d(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckBox(context, attributeSet);
    }

    @NonNull
    protected AppCompatCheckedTextView e(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckedTextView(context, attributeSet);
    }

    @NonNull
    protected AppCompatEditText f(Context context, AttributeSet attributeSet) {
        return new AppCompatEditText(context, attributeSet);
    }

    @NonNull
    protected AppCompatImageButton g(Context context, AttributeSet attributeSet) {
        return new AppCompatImageButton(context, attributeSet);
    }

    @NonNull
    protected AppCompatImageView h(Context context, AttributeSet attributeSet) {
        return new AppCompatImageView(context, attributeSet);
    }

    @NonNull
    protected AppCompatMultiAutoCompleteTextView i(Context context, AttributeSet attributeSet) {
        return new AppCompatMultiAutoCompleteTextView(context, attributeSet);
    }

    @NonNull
    protected AppCompatRadioButton j(Context context, AttributeSet attributeSet) {
        return new AppCompatRadioButton(context, attributeSet);
    }

    @NonNull
    protected AppCompatRatingBar k(Context context, AttributeSet attributeSet) {
        return new AppCompatRatingBar(context, attributeSet);
    }

    @NonNull
    protected AppCompatSeekBar l(Context context, AttributeSet attributeSet) {
        return new AppCompatSeekBar(context, attributeSet);
    }

    @NonNull
    protected AppCompatSpinner m(Context context, AttributeSet attributeSet) {
        return new AppCompatSpinner(context, attributeSet);
    }

    @NonNull
    protected AppCompatTextView n(Context context, AttributeSet attributeSet) {
        return new AppCompatTextView(context, attributeSet);
    }

    @NonNull
    protected AppCompatToggleButton o(Context context, AttributeSet attributeSet) {
        return new AppCompatToggleButton(context, attributeSet);
    }

    @Nullable
    protected View p(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    final View q(View view, String str, @NonNull Context context, @NonNull AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        Context context2;
        View k;
        context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            context2 = t(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = TintContextWrapper.wrap(context2);
        }
        str.hashCode();
        switch (str) {
            case "RatingBar":
                k = k(context2, attributeSet);
                u(k, str);
                break;
            case "CheckedTextView":
                k = e(context2, attributeSet);
                u(k, str);
                break;
            case "MultiAutoCompleteTextView":
                k = i(context2, attributeSet);
                u(k, str);
                break;
            case "TextView":
                k = n(context2, attributeSet);
                u(k, str);
                break;
            case "ImageButton":
                k = g(context2, attributeSet);
                u(k, str);
                break;
            case "SeekBar":
                k = l(context2, attributeSet);
                u(k, str);
                break;
            case "Spinner":
                k = m(context2, attributeSet);
                u(k, str);
                break;
            case "RadioButton":
                k = j(context2, attributeSet);
                u(k, str);
                break;
            case "ToggleButton":
                k = o(context2, attributeSet);
                u(k, str);
                break;
            case "ImageView":
                k = h(context2, attributeSet);
                u(k, str);
                break;
            case "AutoCompleteTextView":
                k = b(context2, attributeSet);
                u(k, str);
                break;
            case "CheckBox":
                k = d(context2, attributeSet);
                u(k, str);
                break;
            case "EditText":
                k = f(context2, attributeSet);
                u(k, str);
                break;
            case "Button":
                k = c(context2, attributeSet);
                u(k, str);
                break;
            default:
                k = p(context2, str, attributeSet);
                break;
        }
        if (k == null && context != context2) {
            k = s(context2, str, attributeSet);
        }
        if (k != null) {
            a(k, attributeSet);
        }
        return k;
    }
}
