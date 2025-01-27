package c.a.a.a.a;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import c.a.a.a.a.o;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class o extends DialogFragment {

    public static class a {

        /* renamed from: a */
        private static final int[] f5145a = {R.attr.state_pressed};

        /* renamed from: b */
        private static final int[] f5146b = {R.attr.state_focused};

        /* renamed from: c */
        private static final int[] f5147c = {R.attr.state_enabled};
        private int A;
        private ColorStateList B;
        private int C;
        private int D;
        private int E;
        private int F;
        private int G;
        private int H;
        private int I;
        private int J;

        /* renamed from: d */
        private o f5148d;

        /* renamed from: e */
        private Context f5149e;

        /* renamed from: f */
        private ViewGroup f5150f;

        /* renamed from: g */
        private LayoutInflater f5151g;

        /* renamed from: i */
        private CharSequence f5153i;

        /* renamed from: j */
        private DialogInterface.OnClickListener f5154j;
        private CharSequence k;
        private DialogInterface.OnClickListener l;
        private CharSequence m;
        private DialogInterface.OnClickListener n;
        private CharSequence o;
        private View p;
        private boolean q;
        private int r;
        private int s;
        private int t;
        private int u;
        private ListAdapter v;
        private int w;
        private AdapterView.OnItemClickListener x;
        private Drawable y;
        private int z;

        /* renamed from: h */
        private CharSequence f5152h = null;
        public boolean K = false;
        public boolean L = false;

        public a(o dialogFragment, Context context, LayoutInflater inflater, ViewGroup container) {
            this.f5148d = dialogFragment;
            this.f5149e = context;
            this.f5150f = container;
            this.f5151g = inflater;
        }

        /* renamed from: B */
        public /* synthetic */ void C(final DialogInterface.OnClickListener listener, final boolean autoDismiss, AdapterView parent, View view, int position, long id) {
            if (listener != null) {
                listener.onClick(i(), position);
            }
            this.w = position;
            if (autoDismiss) {
                j().dismiss();
            }
        }

        /* renamed from: D */
        public /* synthetic */ void E(final DialogInterface.OnClickListener listener, final boolean autoDismiss, AdapterView parent, View view, int position, long id) {
            if (listener != null) {
                listener.onClick(i(), position);
            }
            this.w = position;
            if (autoDismiss) {
                j().dismiss();
            }
        }

        /* renamed from: F */
        public /* synthetic */ void G(final DialogInterface.OnClickListener listener, final boolean autoDismiss, AdapterView parent, View view, int position, long id) {
            if (listener != null) {
                listener.onClick(i(), position);
            }
            this.w = position;
            if (autoDismiss) {
                j().dismiss();
            }
        }

        /* renamed from: H */
        public /* synthetic */ void I(final DialogInterface.OnClickListener listener, final boolean autoDismiss, AdapterView parent, View view, int position, long id) {
            if (listener != null) {
                listener.onClick(i(), position);
            }
            this.w = position;
            if (autoDismiss) {
                j().dismiss();
            }
        }

        private void a(LinearLayout llListDialog) {
            if (this.k == null && this.m == null && this.f5153i == null) {
                return;
            }
            View inflate = this.f5151g.inflate(com.martian.dialog.R.layout.dialog_part_button_panel, (ViewGroup) llListDialog, false);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(com.martian.dialog.R.id.dialog_button_panel);
            inflate.findViewById(com.martian.dialog.R.id.dialog_horizontal_separator).setBackgroundDrawable(new ColorDrawable(this.C));
            e(linearLayout, d(linearLayout, c(linearLayout, false)));
            llListDialog.addView(inflate);
        }

        private void b(ViewGroup parent) {
            View inflate = this.f5151g.inflate(com.martian.dialog.R.layout.dialog_part_button_separator, parent, false);
            inflate.findViewById(com.martian.dialog.R.id.dialog_button_separator).setBackgroundDrawable(new ColorDrawable(this.C));
            parent.addView(inflate);
        }

        private boolean c(ViewGroup parent, boolean addDivider) {
            if (this.k == null) {
                return addDivider;
            }
            if (addDivider) {
                b(parent);
            }
            Button button = (Button) this.f5151g.inflate(com.martian.dialog.R.layout.dialog_part_button, parent, false);
            button.setId(com.martian.dialog.R.id.sdl__negative_button);
            button.setText(this.k);
            button.setTextColor(this.B);
            button.setBackgroundDrawable(g());
            button.setOnClickListener(new View.OnClickListener() { // from class: c.a.a.a.a.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o.a.this.q(view);
                }
            });
            parent.addView(button);
            return true;
        }

        private boolean d(ViewGroup parent, boolean addDivider) {
            if (this.m == null) {
                return addDivider;
            }
            if (addDivider) {
                b(parent);
            }
            Button button = (Button) this.f5151g.inflate(com.martian.dialog.R.layout.dialog_part_button, parent, false);
            button.setId(com.martian.dialog.R.id.sdl__neutral_button);
            button.setText(this.m);
            button.setTextColor(this.B);
            button.setBackgroundDrawable(g());
            button.setOnClickListener(new View.OnClickListener() { // from class: c.a.a.a.a.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o.a.this.s(view);
                }
            });
            parent.addView(button);
            return true;
        }

        private boolean e(ViewGroup parent, boolean addDivider) {
            if (this.f5153i == null) {
                return addDivider;
            }
            if (addDivider) {
                b(parent);
            }
            Button button = (Button) this.f5151g.inflate(com.martian.dialog.R.layout.dialog_part_button, parent, false);
            button.setId(com.martian.dialog.R.id.sdl__positive_button);
            button.setText(this.f5153i);
            button.setTextColor(this.B);
            button.setBackgroundDrawable(g());
            button.setOnClickListener(new View.OnClickListener() { // from class: c.a.a.a.a.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o.a.this.u(view);
                }
            });
            parent.addView(button);
            return true;
        }

        private StateListDrawable g() {
            ColorDrawable colorDrawable = new ColorDrawable(this.D);
            ColorDrawable colorDrawable2 = new ColorDrawable(this.E);
            ColorDrawable colorDrawable3 = new ColorDrawable(this.F);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(f5145a, colorDrawable2);
            stateListDrawable.addState(f5146b, colorDrawable3);
            stateListDrawable.addState(f5147c, colorDrawable);
            return stateListDrawable;
        }

        private ColorDrawable h() {
            return new ColorDrawable(this.G);
        }

        private View k() {
            View inflate = this.f5151g.inflate(com.martian.dialog.R.layout.dialog_part_title, this.f5150f, false);
            TextView textView = (TextView) inflate.findViewById(com.martian.dialog.R.id.sdl__title);
            View findViewById = inflate.findViewById(com.martian.dialog.R.id.sdl__titleDivider);
            CharSequence charSequence = this.f5152h;
            if (charSequence != null) {
                textView.setText(charSequence);
                textView.setTextColor(this.z);
                Drawable drawable = this.y;
                if (drawable != null) {
                    textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                    textView.setCompoundDrawablePadding(this.f5149e.getResources().getDimensionPixelSize(com.martian.dialog.R.dimen.grid_2));
                }
                findViewById.setBackgroundDrawable(new ColorDrawable(this.A));
            } else {
                textView.setVisibility(8);
                findViewById.setVisibility(8);
            }
            return inflate;
        }

        private StateListDrawable n() {
            ColorDrawable colorDrawable = new ColorDrawable(this.H);
            ColorDrawable colorDrawable2 = new ColorDrawable(this.I);
            ColorDrawable colorDrawable3 = new ColorDrawable(this.J);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(f5145a, colorDrawable2);
            stateListDrawable.addState(f5146b, colorDrawable3);
            stateListDrawable.addState(f5147c, colorDrawable);
            return stateListDrawable;
        }

        /* renamed from: p */
        public /* synthetic */ void q(View v) {
            DialogInterface.OnClickListener onClickListener = this.l;
            if (onClickListener != null) {
                onClickListener.onClick(this.f5148d.getDialog(), -2);
            }
            this.f5148d.dismiss();
        }

        /* renamed from: r */
        public /* synthetic */ void s(View v) {
            this.n.onClick(this.f5148d.getDialog(), -3);
            this.f5148d.dismiss();
        }

        /* renamed from: t */
        public /* synthetic */ void u(View v) {
            this.f5154j.onClick(this.f5148d.getDialog(), -1);
            this.f5148d.dismiss();
        }

        /* renamed from: v */
        public /* synthetic */ void w(final DialogInterface.OnClickListener l, AdapterView parent, View view, int position, long id) {
            if (l != null) {
                l.onClick(i(), position);
            }
            j().dismiss();
        }

        /* renamed from: x */
        public /* synthetic */ void y(final DialogInterface.OnClickListener l, AdapterView parent, View view, int position, long id) {
            if (l != null) {
                l.onClick(i(), position);
            }
            j().dismiss();
        }

        /* renamed from: z */
        public /* synthetic */ void A(final DialogInterface.OnClickListener l, AdapterView parent, View view, int position, long id) {
            if (l != null) {
                l.onClick(i(), position);
            }
            j().dismiss();
        }

        public a J(int resourceId) {
            this.y = this.f5149e.getResources().getDrawable(resourceId);
            return this;
        }

        public a K(Drawable drawable) {
            this.y = drawable;
            return this;
        }

        public a L(ListAdapter listAdapter, int checkedItemIdx, final DialogInterface.OnClickListener l) {
            return M(listAdapter, checkedItemIdx, new AdapterView.OnItemClickListener() { // from class: c.a.a.a.a.a
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
                    o.a.this.w(l, adapterView, view, i2, j2);
                }
            });
        }

        public a M(ListAdapter listAdapter, int checkedItemIdx, final AdapterView.OnItemClickListener listener) {
            this.v = listAdapter;
            this.x = listener;
            this.w = checkedItemIdx;
            return this;
        }

        public a N(List objects, final DialogInterface.OnClickListener l) {
            return M(new ArrayAdapter(this.f5149e, com.martian.dialog.R.layout.dialog_list_item, R.id.text1, objects), 0, new AdapterView.OnItemClickListener() { // from class: c.a.a.a.a.d
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
                    o.a.this.A(l, adapterView, view, i2, j2);
                }
            });
        }

        public a O(String[] items, final DialogInterface.OnClickListener l) {
            return M(new ArrayAdapter(this.f5149e, com.martian.dialog.R.layout.dialog_list_item, R.id.text1, items), 0, new AdapterView.OnItemClickListener() { // from class: c.a.a.a.a.j
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
                    o.a.this.y(l, adapterView, view, i2, j2);
                }
            });
        }

        public a P(int messageId) {
            this.o = this.f5149e.getText(messageId);
            return this;
        }

        public a Q(CharSequence message) {
            this.o = message;
            return this;
        }

        public a R(int textId, final DialogInterface.OnClickListener listener) {
            this.k = this.f5149e.getText(textId);
            this.l = listener;
            return this;
        }

        public a S(CharSequence text, final DialogInterface.OnClickListener listener) {
            this.k = text;
            this.l = listener;
            return this;
        }

        public a T(int textId, final DialogInterface.OnClickListener listener) {
            this.m = this.f5149e.getText(textId);
            this.n = listener;
            return this;
        }

        public a U(CharSequence text, final DialogInterface.OnClickListener listener) {
            this.m = text;
            this.n = listener;
            return this;
        }

        public a V(int textId, final DialogInterface.OnClickListener listener) {
            this.f5153i = this.f5149e.getText(textId);
            this.f5154j = listener;
            return this;
        }

        public a W(CharSequence text, final DialogInterface.OnClickListener listener) {
            this.f5153i = text;
            this.f5154j = listener;
            return this;
        }

        public a X(ListAdapter adapter, int checkedItemIdx, final boolean autoDismiss, final DialogInterface.OnClickListener listener) {
            this.L = true;
            return M(adapter, checkedItemIdx, new AdapterView.OnItemClickListener() { // from class: c.a.a.a.a.c
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
                    o.a.this.I(listener, autoDismiss, adapterView, view, i2, j2);
                }
            });
        }

        public a Y(List objects, int checkedItemIdx, final boolean autoDismiss, final DialogInterface.OnClickListener listener) {
            this.L = true;
            return M(new ArrayAdapter(this.f5149e, com.martian.dialog.R.layout.dialog_single_choice_item, R.id.text1, objects), checkedItemIdx, new AdapterView.OnItemClickListener() { // from class: c.a.a.a.a.b
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
                    o.a.this.C(listener, autoDismiss, adapterView, view, i2, j2);
                }
            });
        }

        public <T> a Z(T[] items, int checkedItemIdx, final boolean autoDismiss, final DialogInterface.OnClickListener listener) {
            this.L = true;
            return M(new ArrayAdapter(this.f5149e, com.martian.dialog.R.layout.dialog_single_choice_item, R.id.text1, items), checkedItemIdx, new AdapterView.OnItemClickListener() { // from class: c.a.a.a.a.f
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
                    o.a.this.E(listener, autoDismiss, adapterView, view, i2, j2);
                }
            });
        }

        public a a0(String[] items, int checkedItemIdx, final boolean autoDismiss, final DialogInterface.OnClickListener listener) {
            this.L = true;
            return M(new ArrayAdapter(this.f5149e, com.martian.dialog.R.layout.dialog_single_choice_item, R.id.text1, items), checkedItemIdx, new AdapterView.OnItemClickListener() { // from class: c.a.a.a.a.g
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
                    o.a.this.G(listener, autoDismiss, adapterView, view, i2, j2);
                }
            });
        }

        public a b0(int titleId) {
            this.f5152h = this.f5149e.getText(titleId);
            return this;
        }

        public a c0(CharSequence title) {
            this.f5152h = title;
            return this;
        }

        public a d0(View view) {
            this.p = view;
            this.q = false;
            return this;
        }

        public a e0(View view, int viewSpacingLeft, int viewSpacingTop, int viewSpacingRight, int viewSpacingBottom) {
            this.p = view;
            this.q = true;
            this.r = viewSpacingLeft;
            this.s = viewSpacingTop;
            this.t = viewSpacingRight;
            this.u = viewSpacingBottom;
            return this;
        }

        public View f() {
            Resources resources = this.f5149e.getResources();
            int color = resources.getColor(com.martian.dialog.R.color.sdl_title_text_dark);
            int color2 = resources.getColor(com.martian.dialog.R.color.sdl_title_separator_dark);
            int color3 = resources.getColor(com.martian.dialog.R.color.sdl_message_text_dark);
            ColorStateList colorStateList = resources.getColorStateList(com.martian.dialog.R.color.sdl_button_text_dark);
            int color4 = resources.getColor(com.martian.dialog.R.color.sdl_button_separator_dark);
            int i2 = com.martian.dialog.R.color.sdl_button_normal_dark;
            int color5 = resources.getColor(i2);
            int i3 = com.martian.dialog.R.color.sdl_button_pressed_dark;
            int color6 = resources.getColor(i3);
            int i4 = com.martian.dialog.R.color.sdl_button_focused_dark;
            int color7 = resources.getColor(i4);
            TypedArray obtainStyledAttributes = this.f5149e.getTheme().obtainStyledAttributes(null, com.martian.dialog.R.styleable.DialogStyle, com.martian.dialog.R.attr.sdlDialogStyle, 0);
            this.z = obtainStyledAttributes.getColor(com.martian.dialog.R.styleable.DialogStyle_titleTextColor2, color);
            this.A = obtainStyledAttributes.getColor(com.martian.dialog.R.styleable.DialogStyle_titleSeparatorColor, color2);
            int color8 = obtainStyledAttributes.getColor(com.martian.dialog.R.styleable.DialogStyle_messageTextColor, color3);
            ColorStateList colorStateList2 = obtainStyledAttributes.getColorStateList(com.martian.dialog.R.styleable.DialogStyle_buttonTextColor);
            this.B = colorStateList2;
            if (colorStateList2 == null) {
                this.B = colorStateList;
            }
            this.C = obtainStyledAttributes.getColor(com.martian.dialog.R.styleable.DialogStyle_buttonSeparatorColor, color4);
            this.D = obtainStyledAttributes.getColor(com.martian.dialog.R.styleable.DialogStyle_buttonBackgroundColorNormal, color5);
            this.E = obtainStyledAttributes.getColor(com.martian.dialog.R.styleable.DialogStyle_buttonBackgroundColorPressed, color6);
            this.F = obtainStyledAttributes.getColor(com.martian.dialog.R.styleable.DialogStyle_buttonBackgroundColorFocused, color7);
            if (this.v != null) {
                int color9 = resources.getColor(com.martian.dialog.R.color.sdl_list_item_separator_dark);
                int color10 = resources.getColor(i2);
                int color11 = resources.getColor(i4);
                int color12 = resources.getColor(i3);
                this.G = obtainStyledAttributes.getColor(com.martian.dialog.R.styleable.DialogStyle_listItemSeparatorColor, color9);
                this.H = obtainStyledAttributes.getColor(com.martian.dialog.R.styleable.DialogStyle_listItemColorNormal, color10);
                this.J = obtainStyledAttributes.getColor(com.martian.dialog.R.styleable.DialogStyle_listItemColorFocused, color11);
                this.I = obtainStyledAttributes.getColor(com.martian.dialog.R.styleable.DialogStyle_listItemColorPressed, color12);
            }
            obtainStyledAttributes.recycle();
            View k = k();
            LinearLayout linearLayout = (LinearLayout) k.findViewById(com.martian.dialog.R.id.sdl__content);
            if (this.o != null) {
                View inflate = this.f5151g.inflate(com.martian.dialog.R.layout.dialog_part_message, (ViewGroup) linearLayout, false);
                TextView textView = (TextView) inflate.findViewById(com.martian.dialog.R.id.sdl__message);
                textView.setTextColor(color8);
                textView.setText(this.o);
                linearLayout.addView(inflate);
            }
            if (this.p != null) {
                FrameLayout frameLayout = (FrameLayout) this.f5151g.inflate(com.martian.dialog.R.layout.dialog_part_custom, (ViewGroup) linearLayout, false);
                FrameLayout frameLayout2 = (FrameLayout) frameLayout.findViewById(com.martian.dialog.R.id.sdl__custom);
                frameLayout2.addView(this.p, new FrameLayout.LayoutParams(-1, -1));
                if (this.q) {
                    frameLayout2.setPadding(this.r, this.s, this.t, this.u);
                }
                linearLayout.addView(frameLayout);
            }
            if (this.v != null) {
                ListView listView = (ListView) this.f5151g.inflate(com.martian.dialog.R.layout.dialog_part_list, (ViewGroup) linearLayout, false);
                listView.setAdapter(this.v);
                if (this.v.getCount() > 40) {
                    listView.setFastScrollEnabled(true);
                }
                if (this.L) {
                    listView.setChoiceMode(1);
                }
                listView.setDivider(h());
                listView.setDividerHeight(1);
                listView.setSelector(n());
                listView.setOnItemClickListener(this.x);
                int i5 = this.w;
                if (i5 != -1) {
                    listView.setItemChecked(i5, true);
                    listView.setSelection(this.w);
                }
                linearLayout.addView(listView);
            }
            a(linearLayout);
            return k;
        }

        public Dialog i() {
            return this.f5148d.getDialog();
        }

        public DialogFragment j() {
            return this.f5148d;
        }

        public LayoutInflater l() {
            return this.f5151g;
        }

        public int m() {
            return this.w;
        }

        public a o(o dialogFragment, Context context, LayoutInflater inflater, ViewGroup container) {
            this.f5148d = dialogFragment;
            this.f5149e = context;
            this.f5150f = container;
            this.f5151g = inflater;
            return this;
        }
    }

    protected abstract a a(a initialBuilder);

    protected Button b() {
        if (getView() != null) {
            return (Button) getView().findViewById(com.martian.dialog.R.id.sdl__negative_button);
        }
        return null;
    }

    protected Button c() {
        if (getView() != null) {
            return (Button) getView().findViewById(com.martian.dialog.R.id.sdl__neutral_button);
        }
        return null;
    }

    protected Button d() {
        if (getView() != null) {
            return (Button) getView().findViewById(com.martian.dialog.R.id.sdl__positive_button);
        }
        return null;
    }

    public void e(FragmentManager manager, String tag) {
        FragmentTransaction beginTransaction = manager.beginTransaction();
        beginTransaction.add(this, tag);
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new Dialog(getActivity(), com.martian.dialog.R.style.SDL_Dialog);
        FragmentActivity activity = getActivity();
        activity.getClass();
        TypedArray obtainStyledAttributes = activity.getTheme().obtainStyledAttributes(null, com.martian.dialog.R.styleable.DialogStyle, com.martian.dialog.R.attr.sdlDialogStyle, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(com.martian.dialog.R.styleable.DialogStyle_dialogBackground);
        obtainStyledAttributes.recycle();
        dialog.getWindow().setBackgroundDrawable(drawable);
        Bundle arguments = getArguments();
        if (arguments != null) {
            dialog.setCanceledOnTouchOutside(arguments.getBoolean(n.f5136b));
            if (arguments.getBoolean(n.f5137c)) {
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            }
        }
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return a(new a(this, getActivity(), inflater, container)).f();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
    }
}
