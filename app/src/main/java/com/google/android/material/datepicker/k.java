package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.R;
import com.google.android.material.datepicker.a;
import com.google.android.material.internal.CheckableImageButton;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public final class k<S> extends DialogFragment {

    /* renamed from: a */
    private static final String f7045a = "OVERRIDE_THEME_RES_ID";

    /* renamed from: b */
    private static final String f7046b = "DATE_SELECTOR_KEY";

    /* renamed from: c */
    private static final String f7047c = "CALENDAR_CONSTRAINTS_KEY";

    /* renamed from: d */
    private static final String f7048d = "TITLE_TEXT_RES_ID_KEY";

    /* renamed from: e */
    private static final String f7049e = "TITLE_TEXT_KEY";

    /* renamed from: f */
    private static final String f7050f = "INPUT_MODE_KEY";

    /* renamed from: g */
    static final Object f7051g = "CONFIRM_BUTTON_TAG";

    /* renamed from: h */
    static final Object f7052h = "CANCEL_BUTTON_TAG";

    /* renamed from: i */
    static final Object f7053i = "TOGGLE_BUTTON_TAG";

    /* renamed from: j */
    public static final int f7054j = 0;
    public static final int k = 1;

    @Nullable
    private com.google.android.material.j.j A;
    private Button B;
    private final LinkedHashSet<l<? super S>> l = new LinkedHashSet<>();
    private final LinkedHashSet<View.OnClickListener> m = new LinkedHashSet<>();
    private final LinkedHashSet<DialogInterface.OnCancelListener> n = new LinkedHashSet<>();
    private final LinkedHashSet<DialogInterface.OnDismissListener> o = new LinkedHashSet<>();

    @StyleRes
    private int p;

    @Nullable
    private com.google.android.material.datepicker.f<S> q;
    private r<S> r;

    @Nullable
    private com.google.android.material.datepicker.a s;
    private MaterialCalendar<S> t;

    @StringRes
    private int u;
    private CharSequence v;
    private boolean w;
    private int x;
    private TextView y;
    private CheckableImageButton z;

    class a implements View.OnClickListener {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = k.this.l.iterator();
            while (it.hasNext()) {
                ((l) it.next()).a(k.this.u());
            }
            k.this.dismiss();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = k.this.m.iterator();
            while (it.hasNext()) {
                ((View.OnClickListener) it.next()).onClick(view);
            }
            k.this.dismiss();
        }
    }

    class c extends q<S> {
        c() {
        }

        @Override // com.google.android.material.datepicker.q
        void a() {
            k.this.B.setEnabled(false);
        }

        @Override // com.google.android.material.datepicker.q
        public void b(S s) {
            k.this.G();
            k.this.B.setEnabled(k.this.q.g0());
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            k.this.B.setEnabled(k.this.q.g0());
            k.this.z.toggle();
            k kVar = k.this;
            kVar.H(kVar.z);
            k.this.D();
        }
    }

    public static final class e<S> {

        /* renamed from: a */
        final com.google.android.material.datepicker.f<S> f7059a;

        /* renamed from: c */
        com.google.android.material.datepicker.a f7061c;

        /* renamed from: b */
        int f7060b = 0;

        /* renamed from: d */
        int f7062d = 0;

        /* renamed from: e */
        CharSequence f7063e = null;

        /* renamed from: f */
        @Nullable
        S f7064f = null;

        /* renamed from: g */
        int f7065g = 0;

        private e(com.google.android.material.datepicker.f<S> fVar) {
            this.f7059a = fVar;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static <S> e<S> b(@NonNull com.google.android.material.datepicker.f<S> fVar) {
            return new e<>(fVar);
        }

        @NonNull
        public static e<Long> c() {
            return new e<>(new t());
        }

        @NonNull
        public static e<Pair<Long, Long>> d() {
            return new e<>(new s());
        }

        @NonNull
        public k<S> a() {
            if (this.f7061c == null) {
                this.f7061c = new a.b().a();
            }
            if (this.f7062d == 0) {
                this.f7062d = this.f7059a.a0();
            }
            S s = this.f7064f;
            if (s != null) {
                this.f7059a.e0(s);
            }
            return k.y(this);
        }

        @NonNull
        public e<S> e(com.google.android.material.datepicker.a aVar) {
            this.f7061c = aVar;
            return this;
        }

        @NonNull
        public e<S> f(int i2) {
            this.f7065g = i2;
            return this;
        }

        @NonNull
        public e<S> g(S s) {
            this.f7064f = s;
            return this;
        }

        @NonNull
        public e<S> h(@StyleRes int i2) {
            this.f7060b = i2;
            return this;
        }

        @NonNull
        public e<S> i(@StringRes int i2) {
            this.f7062d = i2;
            this.f7063e = null;
            return this;
        }

        @NonNull
        public e<S> j(@Nullable CharSequence charSequence) {
            this.f7063e = charSequence;
            this.f7062d = 0;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface f {
    }

    public void D() {
        this.t = MaterialCalendar.s(this.q, v(requireContext()), this.s);
        this.r = this.z.isChecked() ? m.e(this.q, this.s) : this.t;
        G();
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.mtrl_calendar_frame, this.r);
        beginTransaction.commitNow();
        this.r.a(new c());
    }

    public static long E() {
        return n.e().f7077g;
    }

    public static long F() {
        return w.t().getTimeInMillis();
    }

    public void G() {
        String s = s();
        this.y.setContentDescription(String.format(getString(R.string.mtrl_picker_announce_current_selection), s));
        this.y.setText(s);
    }

    public void H(@NonNull CheckableImageButton checkableImageButton) {
        this.z.setContentDescription(this.z.isChecked() ? checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_calendar_input_mode) : checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_text_input_mode));
    }

    @NonNull
    private static Drawable q(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_checked}, AppCompatResources.getDrawable(context, R.drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], AppCompatResources.getDrawable(context, R.drawable.material_ic_edit_black_24dp));
        return stateListDrawable;
    }

    private static int r(@NonNull Context context) {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_navigation_height) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_bottom_padding);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_days_of_week_height);
        int i2 = o.f7078a;
        return dimensionPixelSize + dimensionPixelSize2 + (resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * i2) + ((i2 - 1) * resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_vertical_padding)) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_bottom_padding);
    }

    private static int t(@NonNull Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_content_padding);
        int i2 = n.e().f7075e;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_width) * i2) + ((i2 - 1) * resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_horizontal_padding));
    }

    private int v(Context context) {
        int i2 = this.p;
        return i2 != 0 ? i2 : this.q.b0(context);
    }

    private void w(Context context) {
        this.z.setTag(f7053i);
        this.z.setImageDrawable(q(context));
        this.z.setChecked(this.x != 0);
        ViewCompat.setAccessibilityDelegate(this.z, null);
        H(this.z);
        this.z.setOnClickListener(new d());
    }

    static boolean x(@NonNull Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(com.google.android.material.g.b.f(context, R.attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), new int[]{android.R.attr.windowFullscreen});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    @NonNull
    static <S> k<S> y(@NonNull e<S> eVar) {
        k<S> kVar = new k<>();
        Bundle bundle = new Bundle();
        bundle.putInt(f7045a, eVar.f7060b);
        bundle.putParcelable(f7046b, eVar.f7059a);
        bundle.putParcelable(f7047c, eVar.f7061c);
        bundle.putInt(f7048d, eVar.f7062d);
        bundle.putCharSequence(f7049e, eVar.f7063e);
        bundle.putInt(f7050f, eVar.f7065g);
        kVar.setArguments(bundle);
        return kVar;
    }

    public boolean A(DialogInterface.OnDismissListener onDismissListener) {
        return this.o.remove(onDismissListener);
    }

    public boolean B(View.OnClickListener onClickListener) {
        return this.m.remove(onClickListener);
    }

    public boolean C(l<? super S> lVar) {
        return this.l.remove(lVar);
    }

    public boolean i(DialogInterface.OnCancelListener onCancelListener) {
        return this.n.add(onCancelListener);
    }

    public boolean j(DialogInterface.OnDismissListener onDismissListener) {
        return this.o.add(onDismissListener);
    }

    public boolean k(View.OnClickListener onClickListener) {
        return this.m.add(onClickListener);
    }

    public boolean l(l<? super S> lVar) {
        return this.l.add(lVar);
    }

    public void m() {
        this.n.clear();
    }

    public void n() {
        this.o.clear();
    }

    public void o() {
        this.m.clear();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.p = bundle.getInt(f7045a);
        this.q = (com.google.android.material.datepicker.f) bundle.getParcelable(f7046b);
        this.s = (com.google.android.material.datepicker.a) bundle.getParcelable(f7047c);
        this.u = bundle.getInt(f7048d);
        this.v = bundle.getCharSequence(f7049e);
        this.x = bundle.getInt(f7050f);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public final Dialog onCreateDialog(@Nullable Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), v(requireContext()));
        Context context = dialog.getContext();
        this.w = x(context);
        int f2 = com.google.android.material.g.b.f(context, R.attr.colorSurface, k.class.getCanonicalName());
        com.google.android.material.j.j jVar = new com.google.android.material.j.j(context, null, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
        this.A = jVar;
        jVar.Y(context);
        this.A.n0(ColorStateList.valueOf(f2));
        this.A.m0(ViewCompat.getElevation(dialog.getWindow().getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(this.w ? R.layout.mtrl_picker_fullscreen : R.layout.mtrl_picker_dialog, viewGroup);
        Context context = inflate.getContext();
        if (this.w) {
            inflate.findViewById(R.id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(t(context), -2));
        } else {
            View findViewById = inflate.findViewById(R.id.mtrl_calendar_main_pane);
            View findViewById2 = inflate.findViewById(R.id.mtrl_calendar_frame);
            findViewById.setLayoutParams(new LinearLayout.LayoutParams(t(context), -1));
            findViewById2.setMinimumHeight(r(requireContext()));
        }
        TextView textView = (TextView) inflate.findViewById(R.id.mtrl_picker_header_selection_text);
        this.y = textView;
        ViewCompat.setAccessibilityLiveRegion(textView, 1);
        this.z = (CheckableImageButton) inflate.findViewById(R.id.mtrl_picker_header_toggle);
        TextView textView2 = (TextView) inflate.findViewById(R.id.mtrl_picker_title_text);
        CharSequence charSequence = this.v;
        if (charSequence != null) {
            textView2.setText(charSequence);
        } else {
            textView2.setText(this.u);
        }
        w(context);
        this.B = (Button) inflate.findViewById(R.id.confirm_button);
        if (this.q.g0()) {
            this.B.setEnabled(true);
        } else {
            this.B.setEnabled(false);
        }
        this.B.setTag(f7051g);
        this.B.setOnClickListener(new a());
        Button button = (Button) inflate.findViewById(R.id.cancel_button);
        button.setTag(f7052h);
        button.setOnClickListener(new b());
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.o.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(f7045a, this.p);
        bundle.putParcelable(f7046b, this.q);
        a.b bVar = new a.b(this.s);
        if (this.t.p() != null) {
            bVar.c(this.t.p().f7077g);
        }
        bundle.putParcelable(f7047c, bVar.a());
        bundle.putInt(f7048d, this.u);
        bundle.putCharSequence(f7049e, this.v);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.w) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.A);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.A, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new com.google.android.material.dialog.a(requireDialog(), rect));
        }
        D();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        this.r.b();
        super.onStop();
    }

    public void p() {
        this.l.clear();
    }

    public String s() {
        return this.q.c0(getContext());
    }

    @Nullable
    public final S u() {
        return this.q.i0();
    }

    public boolean z(DialogInterface.OnCancelListener onCancelListener) {
        return this.n.remove(onCancelListener);
    }
}
