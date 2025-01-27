package l9;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.Html;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.databinding.DialogInputViewBinding;
import com.martian.libmars.databinding.PopupwindowOptionsBinding;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeTextView;
import l9.i0;

/* loaded from: classes3.dex */
public class i0 {

    /* renamed from: a */
    public static final String f27990a = "MASK_VIEW";

    public class a extends ClickableSpan {

        /* renamed from: a */
        public final /* synthetic */ m f27991a;

        /* renamed from: b */
        public final /* synthetic */ Activity f27992b;

        public a(m mVar, Activity activity) {
            this.f27991a = mVar;
            this.f27992b = activity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            m mVar = this.f27991a;
            if (mVar != null) {
                mVar.a();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(true);
            textPaint.setColor(this.f27992b.getResources().getColor(R.color.day_text_color_primary));
        }
    }

    public class b extends ClickableSpan {

        /* renamed from: a */
        public final /* synthetic */ m f27993a;

        /* renamed from: b */
        public final /* synthetic */ Activity f27994b;

        public b(m mVar, Activity activity) {
            this.f27993a = mVar;
            this.f27994b = activity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            m mVar = this.f27993a;
            if (mVar != null) {
                mVar.b();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(true);
            textPaint.setColor(this.f27994b.getResources().getColor(R.color.day_text_color_primary));
        }
    }

    public class c extends ClickableSpan {

        /* renamed from: a */
        public final /* synthetic */ m f27995a;

        /* renamed from: b */
        public final /* synthetic */ Activity f27996b;

        public c(m mVar, Activity activity) {
            this.f27995a = mVar;
            this.f27996b = activity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            m mVar = this.f27995a;
            if (mVar != null) {
                mVar.a();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(true);
            textPaint.setColor(this.f27996b.getResources().getColor(R.color.day_text_color_primary));
        }
    }

    public class d extends ClickableSpan {

        /* renamed from: a */
        public final /* synthetic */ m f27997a;

        /* renamed from: b */
        public final /* synthetic */ Activity f27998b;

        public d(m mVar, Activity activity) {
            this.f27997a = mVar;
            this.f27998b = activity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            m mVar = this.f27997a;
            if (mVar != null) {
                mVar.b();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(true);
            textPaint.setColor(this.f27998b.getResources().getColor(R.color.day_text_color_primary));
        }
    }

    public class e extends ClickableSpan {

        /* renamed from: a */
        public final /* synthetic */ m f27999a;

        /* renamed from: b */
        public final /* synthetic */ Activity f28000b;

        public e(m mVar, Activity activity) {
            this.f27999a = mVar;
            this.f28000b = activity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            m mVar = this.f27999a;
            if (mVar != null) {
                mVar.b();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(true);
            textPaint.setColor(this.f28000b.getResources().getColor(R.color.day_text_color_primary));
        }
    }

    public class f extends ClickableSpan {

        /* renamed from: a */
        public final /* synthetic */ m f28001a;

        /* renamed from: b */
        public final /* synthetic */ Activity f28002b;

        public f(m mVar, Activity activity) {
            this.f28001a = mVar;
            this.f28002b = activity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            m mVar = this.f28001a;
            if (mVar != null) {
                mVar.a();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(true);
            textPaint.setColor(this.f28002b.getResources().getColor(R.color.day_text_color_primary));
        }
    }

    public interface h {
        void a(boolean[] zArr);
    }

    public interface i {
        void a(boolean z10);
    }

    public interface j {
        void a(String str);
    }

    public interface k {
        void a();
    }

    public interface l {
        void a();
    }

    public interface m {
        void a();

        void b();

        void c();

        void d();

        void e();
    }

    public interface n {
        void a(int i10);
    }

    public interface o {
        void a();

        void b();

        void c();
    }

    public interface p {
        void a(AlertDialog alertDialog, EditText editText, TextView textView);

        void b(EditText editText, TextView textView);
    }

    public static void A0(Activity activity, String str, String str2, String str3, boolean z10, i iVar) {
        if (m0.B(activity)) {
            View inflate = View.inflate(activity, R.layout.dialog_confirm_view, null);
            ThemeTextView themeTextView = (ThemeTextView) inflate.findViewById(R.id.dialog_title);
            ThemeTextView themeTextView2 = (ThemeTextView) inflate.findViewById(R.id.dialog_desc);
            ThemeTextView themeTextView3 = (ThemeTextView) inflate.findViewById(R.id.dialog_close);
            ThemeTextView themeTextView4 = (ThemeTextView) inflate.findViewById(R.id.dialog_notarize);
            CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.dialog_check);
            checkBox.setVisibility(0);
            View findViewById = inflate.findViewById(R.id.dialog_shade_view);
            if (!ba.l.q(str)) {
                themeTextView.setText(str);
            }
            if (!ba.l.q(str2)) {
                themeTextView2.setText(str2);
            }
            if (!ba.l.q(str3)) {
                checkBox.setText(str3);
            }
            checkBox.setTextColor(ConfigSingleton.D().j0());
            checkBox.setChecked(z10);
            AlertDialog G = G(activity, inflate, true);
            if (G == null) {
                return;
            }
            if (ConfigSingleton.D().A0()) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            themeTextView3.setOnClickListener(new View.OnClickListener() { // from class: l9.u

                /* renamed from: b */
                public final /* synthetic */ AlertDialog f28042b;

                public /* synthetic */ u(AlertDialog G2) {
                    G = G2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    G.dismiss();
                }
            });
            themeTextView4.setOnClickListener(new View.OnClickListener() { // from class: l9.v

                /* renamed from: b */
                public final /* synthetic */ AlertDialog f28043b;

                /* renamed from: c */
                public final /* synthetic */ i0.i f28044c;

                /* renamed from: d */
                public final /* synthetic */ CheckBox f28045d;

                public /* synthetic */ v(AlertDialog G2, i0.i iVar2, CheckBox checkBox2) {
                    G = G2;
                    iVar = iVar2;
                    checkBox = checkBox2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i0.V(G, iVar, checkBox, view);
                }
            });
        }
    }

    public static void B0(Activity activity, String str, String str2, String str3, String str4, k kVar, l lVar) {
        if (m0.B(activity)) {
            View inflate = View.inflate(activity, R.layout.dialog_confirm_hint, null);
            ThemeTextView themeTextView = (ThemeTextView) inflate.findViewById(R.id.dialog_title);
            ThemeTextView themeTextView2 = (ThemeTextView) inflate.findViewById(R.id.dialog_desc);
            ThemeTextView themeTextView3 = (ThemeTextView) inflate.findViewById(R.id.dialog_close);
            ThemeTextView themeTextView4 = (ThemeTextView) inflate.findViewById(R.id.dialog_notarize);
            ThemeImageView themeImageView = (ThemeImageView) inflate.findViewById(R.id.dialog_close_image);
            View findViewById = inflate.findViewById(R.id.dialog_shade_view);
            if (!ba.l.q(str)) {
                themeTextView.setText(str);
            }
            if (!ba.l.q(str2)) {
                themeTextView2.setText(str2);
            }
            if (!ba.l.q(str3)) {
                themeTextView3.setText(str3);
            }
            if (!ba.l.q(str4)) {
                themeTextView4.setText(str4);
            }
            AlertDialog G = G(activity, inflate, true);
            if (G == null) {
                return;
            }
            if (ConfigSingleton.D().A0()) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            themeImageView.setOnClickListener(new View.OnClickListener() { // from class: l9.d

                /* renamed from: b */
                public final /* synthetic */ AlertDialog f27970b;

                public /* synthetic */ d(AlertDialog G2) {
                    G = G2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    G.dismiss();
                }
            });
            themeTextView3.setOnClickListener(new View.OnClickListener() { // from class: l9.o

                /* renamed from: b */
                public final /* synthetic */ AlertDialog f28027b;

                /* renamed from: c */
                public final /* synthetic */ i0.k f28028c;

                public /* synthetic */ o(AlertDialog G2, i0.k kVar2) {
                    G = G2;
                    kVar = kVar2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i0.X(G, kVar, view);
                }
            });
            themeTextView4.setOnClickListener(new View.OnClickListener() { // from class: l9.z

                /* renamed from: b */
                public final /* synthetic */ AlertDialog f28052b;

                /* renamed from: c */
                public final /* synthetic */ i0.l f28053c;

                public /* synthetic */ z(AlertDialog G2, i0.l lVar2) {
                    G = G2;
                    lVar = lVar2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i0.Y(G, lVar, view);
                }
            });
        }
    }

    public static void C0(Activity activity, String str, String str2, String str3, String str4, boolean z10, boolean z11, j jVar) {
        if (m0.B(activity)) {
            View inflate = activity.getLayoutInflater().inflate(R.layout.dialog_input_view, (ViewGroup) null);
            DialogInputViewBinding a10 = DialogInputViewBinding.a(inflate);
            if (!ba.l.q(str)) {
                a10.f12156d.setText(str);
            }
            if (TextUtils.isEmpty(str2)) {
                a10.f12155c.setVisibility(8);
            } else {
                a10.f12155c.setVisibility(0);
                a10.f12155c.setText(str2);
            }
            AlertDialog G = G(activity, inflate, true);
            if (G == null) {
                return;
            }
            if (G.getWindow() != null) {
                G.getWindow().clearFlags(131072);
            }
            a10.f12157e.post(new Runnable() { // from class: l9.g

                /* renamed from: b */
                public final /* synthetic */ Activity f27978b;

                /* renamed from: c */
                public final /* synthetic */ DialogInputViewBinding f27979c;

                public /* synthetic */ g(Activity activity2, DialogInputViewBinding a102) {
                    activity = activity2;
                    a10 = a102;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    i0.Z(activity, a10);
                }
            });
            a102.f12157e.setTextColor(ConfigSingleton.D().h0());
            a102.f12157e.setHintTextColor(ConfigSingleton.D().j0());
            if (!ba.l.q(str3)) {
                a102.f12157e.setText(str3);
                a102.f12157e.setSelection(str3.length());
            }
            if (!ba.l.q(str4)) {
                a102.f12157e.setHint(str4);
            }
            if (z10) {
                a102.f12157e.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            if (z11) {
                a102.f12157e.setInputType(2);
                a102.f12157e.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
            }
            a102.f12160h.setVisibility(ConfigSingleton.D().A0() ? 0 : 8);
            a102.f12154b.setOnClickListener(new View.OnClickListener() { // from class: l9.h

                /* renamed from: b */
                public final /* synthetic */ Activity f27981b;

                /* renamed from: c */
                public final /* synthetic */ DialogInputViewBinding f27982c;

                /* renamed from: d */
                public final /* synthetic */ AlertDialog f27983d;

                public /* synthetic */ h(Activity activity2, DialogInputViewBinding a102, AlertDialog G2) {
                    activity = activity2;
                    a10 = a102;
                    G = G2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i0.a0(activity, a10, G, view);
                }
            });
            a102.f12158f.setOnClickListener(new View.OnClickListener() { // from class: l9.i

                /* renamed from: c */
                public final /* synthetic */ Activity f27987c;

                /* renamed from: d */
                public final /* synthetic */ i0.j f27988d;

                /* renamed from: e */
                public final /* synthetic */ AlertDialog f27989e;

                public /* synthetic */ i(Activity activity2, i0.j jVar2, AlertDialog G2) {
                    activity = activity2;
                    jVar = jVar2;
                    G = G2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i0.b0(DialogInputViewBinding.this, activity, jVar, G, view);
                }
            });
        }
    }

    public static void D0(Activity activity, String str, String str2, boolean z10, boolean z11, j jVar) {
        C0(activity, str, "", "", str2, z10, z11, jVar);
    }

    public static void E0(Activity activity, String str, m mVar) {
        if (m0.B(activity)) {
            View inflate = LayoutInflater.from(activity).inflate(R.layout.libmars_popupwindow_privacy, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.privacy_desc);
            textView.setLineSpacing(0.0f, 1.2f);
            textView.setText(ConfigSingleton.D().s(activity.getString(R.string.please_read) + str));
            SpannableString spannableString = new SpannableString(activity.getString(R.string.service_policy));
            spannableString.setSpan(new e(mVar, activity), 0, 6, 17);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.append(spannableString);
            textView.append("和");
            SpannableString spannableString2 = new SpannableString(activity.getString(R.string.privacy_policy));
            spannableString2.setSpan(new f(mVar, activity), 0, 6, 17);
            textView.append(spannableString2);
            TextView textView2 = (TextView) inflate.findViewById(R.id.privacy_known);
            TextView textView3 = (TextView) inflate.findViewById(R.id.privacy_agree);
            textView2.setText(activity.getString(R.string.giveup_login));
            textView2.setOnClickListener(new View.OnClickListener() { // from class: l9.y

                /* renamed from: b */
                public final /* synthetic */ View f28050b;

                /* renamed from: c */
                public final /* synthetic */ i0.m f28051c;

                public /* synthetic */ y(View inflate2, i0.m mVar2) {
                    inflate = inflate2;
                    mVar = mVar2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i0.c0(inflate, mVar, view);
                }
            });
            textView3.setText(activity.getString(R.string.agree_login));
            textView3.setOnClickListener(new View.OnClickListener() { // from class: l9.a0

                /* renamed from: b */
                public final /* synthetic */ View f27961b;

                /* renamed from: c */
                public final /* synthetic */ i0.m f27962c;

                public /* synthetic */ a0(View inflate2, i0.m mVar2) {
                    inflate = inflate2;
                    mVar = mVar2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i0.d0(inflate, mVar, view);
                }
            });
            activity.getWindow().addContentView(inflate2, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public static View F(Context context, int i10, boolean z10, String str, AlertDialog alertDialog, n nVar) {
        View inflate = View.inflate(context, R.layout.dialog_list_item, null);
        RadioButton radioButton = (RadioButton) inflate.findViewById(R.id.dialog_item_radio);
        radioButton.setVisibility(0);
        radioButton.setChecked(z10);
        if (!ba.l.q(str)) {
            radioButton.setText(str);
        }
        radioButton.measure(0, 0);
        radioButton.setCompoundDrawablePadding(((ba.m.i(context) - ConfigSingleton.i(90.0f)) - ConfigSingleton.i(48.0f)) - radioButton.getMeasuredWidth());
        radioButton.setTextColor(ConfigSingleton.D().h0());
        radioButton.setOnClickListener(new View.OnClickListener() { // from class: l9.j

            /* renamed from: b */
            public final /* synthetic */ AlertDialog f28005b;

            /* renamed from: c */
            public final /* synthetic */ i0.n f28006c;

            /* renamed from: d */
            public final /* synthetic */ int f28007d;

            public /* synthetic */ j(AlertDialog alertDialog2, i0.n nVar2, int i102) {
                alertDialog = alertDialog2;
                nVar = nVar2;
                i10 = i102;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i0.N(alertDialog, nVar, i10, view);
            }
        });
        return inflate;
    }

    public static void F0(Activity activity, String str, String str2, String str3, k kVar, l lVar) {
        G0(activity, str, str2, str3, true, kVar, lVar);
    }

    public static AlertDialog G(Context context, View view, boolean z10) {
        if (!m0.B(context)) {
            return null;
        }
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setCancelable(z10);
            AlertDialog show = builder.show();
            if (show.getWindow() != null) {
                show.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                show.getWindow().setSoftInputMode(4);
            }
            show.setContentView(view);
            WindowManager.LayoutParams attributes = show.getWindow().getAttributes();
            if (context.getResources().getConfiguration().orientation == 1) {
                attributes.width = ba.m.i(context);
            } else {
                attributes.width = ba.m.h(context);
            }
            attributes.height = -2;
            show.getWindow().setAttributes(attributes);
            return show;
        } catch (WindowManager.BadTokenException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static void G0(Activity activity, String str, String str2, String str3, boolean z10, k kVar, l lVar) {
        if (m0.B(activity)) {
            View inflate = View.inflate(activity, R.layout.dialog_single_button, null);
            ThemeTextView themeTextView = (ThemeTextView) inflate.findViewById(R.id.dialog_title);
            ThemeTextView themeTextView2 = (ThemeTextView) inflate.findViewById(R.id.dialog_desc);
            ThemeImageView themeImageView = (ThemeImageView) inflate.findViewById(R.id.dialog_close);
            ThemeTextView themeTextView3 = (ThemeTextView) inflate.findViewById(R.id.dialog_notarize);
            if (!ba.l.q(str)) {
                themeTextView.setText(str);
            }
            if (!ba.l.q(str2)) {
                themeTextView2.setText(str2);
            }
            if (!ba.l.q(str3)) {
                themeTextView3.setText(str3);
            }
            themeImageView.setVisibility(z10 ? 0 : 8);
            AlertDialog G = G(activity, inflate, z10);
            if (G == null) {
                return;
            }
            themeImageView.setOnClickListener(new View.OnClickListener() { // from class: l9.e

                /* renamed from: b */
                public final /* synthetic */ AlertDialog f27974b;

                /* renamed from: c */
                public final /* synthetic */ i0.k f27975c;

                public /* synthetic */ e(AlertDialog G2, i0.k kVar2) {
                    G = G2;
                    kVar = kVar2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i0.e0(G, kVar, view);
                }
            });
            themeTextView3.setOnClickListener(new View.OnClickListener() { // from class: l9.f

                /* renamed from: b */
                public final /* synthetic */ AlertDialog f27976b;

                /* renamed from: c */
                public final /* synthetic */ i0.l f27977c;

                public /* synthetic */ f(AlertDialog G2, i0.l lVar2) {
                    G = G2;
                    lVar = lVar2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i0.f0(G, lVar, view);
                }
            });
        }
    }

    public static PopupWindow H(Activity activity, View view, View view2, boolean z10, int i10, boolean z11, boolean z12) {
        if (!m0.B(activity)) {
            return null;
        }
        if (view2 != null && view2.getParent() != null) {
            return null;
        }
        PopupWindow popupWindow = new PopupWindow(view2, -1, -2);
        if (z10) {
            popupWindow.setFocusable(true);
            popupWindow.setOutsideTouchable(true);
        }
        if (z11) {
            popupWindow.setClippingEnabled(false);
        }
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        if (z12) {
            s0(activity, true);
        }
        if (i10 == 80) {
            popupWindow.setAnimationStyle(R.style.updownpopwindow_anim_style);
        }
        if (view == null) {
            view = activity.getWindow().getDecorView();
        }
        popupWindow.showAtLocation(view, i10, 0, 0);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: l9.t

            /* renamed from: b */
            public final /* synthetic */ boolean f28040b;

            /* renamed from: c */
            public final /* synthetic */ Activity f28041c;

            public /* synthetic */ t(boolean z122, Activity activity2) {
                z12 = z122;
                activity = activity2;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                i0.O(z12, activity);
            }
        });
        return popupWindow;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public static void H0(Activity activity, String str, String str2, String str3, boolean z10, o oVar) {
        if (m0.B(activity)) {
            View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.popupwindow_options, (ViewGroup) null);
            PopupwindowOptionsBinding a10 = PopupwindowOptionsBinding.a(inflate);
            PopupWindow popupWindow = new PopupWindow(inflate, -1, -1);
            popupWindow.setFocusable(true);
            popupWindow.setOutsideTouchable(true);
            popupWindow.setClippingEnabled(false);
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
            s0(activity, true);
            popupWindow.setAnimationStyle(R.style.updownpopwindow_anim_style);
            popupWindow.showAtLocation(activity.getWindow().getDecorView(), 80, 0, 0);
            inflate.setOnTouchListener(new View.OnTouchListener() { // from class: l9.m

                /* renamed from: c */
                public final /* synthetic */ PopupWindow f28020c;

                public /* synthetic */ m(PopupWindow popupWindow2) {
                    popupWindow = popupWindow2;
                }

                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean g02;
                    g02 = i0.g0(PopupwindowOptionsBinding.this, popupWindow, view, motionEvent);
                    return g02;
                }
            });
            a10.f12336c.setText(str);
            a10.f12338e.setText(str2);
            a10.f12338e.setOnClickListener(new View.OnClickListener() { // from class: l9.n

                /* renamed from: c */
                public final /* synthetic */ PopupWindow f28024c;

                public /* synthetic */ n(PopupWindow popupWindow2) {
                    popupWindow = popupWindow2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i0.h0(i0.o.this, popupWindow, view);
                }
            });
            if (ba.l.q(str3)) {
                a10.f12339f.setVisibility(8);
            } else {
                a10.f12339f.setVisibility(0);
                a10.f12339f.setText(str3);
            }
            a10.f12339f.setOnClickListener(new View.OnClickListener() { // from class: l9.p

                /* renamed from: c */
                public final /* synthetic */ PopupWindow f28031c;

                public /* synthetic */ p(PopupWindow popupWindow2) {
                    popupWindow = popupWindow2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i0.i0(i0.o.this, popupWindow, view);
                }
            });
            a10.f12335b.setOnClickListener(new View.OnClickListener() { // from class: l9.q

                /* renamed from: b */
                public final /* synthetic */ PopupWindow f28032b;

                public /* synthetic */ q(PopupWindow popupWindow2) {
                    popupWindow = popupWindow2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    popupWindow.dismiss();
                }
            });
            if (z10) {
                a10.f12338e.setTextColor(ContextCompat.getColor(activity, R.color.day_text_color_primary));
            }
            if (com.gyf.immersionbar.d.O0(activity)) {
                a10.f12337d.setPadding(0, 0, 0, ConfigSingleton.i(48.0f));
            }
            popupWindow2.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: l9.r

                /* renamed from: b */
                public final /* synthetic */ Activity f28037b;

                /* renamed from: c */
                public final /* synthetic */ i0.o f28038c;

                public /* synthetic */ r(Activity activity2, i0.o oVar2) {
                    activity = activity2;
                    oVar = oVar2;
                }

                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    i0.k0(activity, oVar);
                }
            });
        }
    }

    public static PopupWindow I(Activity activity, View view, boolean z10) {
        return J(activity, view, z10, 17);
    }

    public static void I0(Activity activity, String str, boolean z10, m mVar) {
        if (m0.B(activity)) {
            View inflate = LayoutInflater.from(activity).inflate(R.layout.libmars_popupwindow_privacy, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.privacy_desc);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(ConfigSingleton.D().s(activity.getString(R.string.privacy_guide_desc_1) + str + "。\n\n" + activity.getString(R.string.privacy_guide_desc_2) + str + activity.getString(R.string.privacy_guide_desc_3)));
            sb2.append(activity.getString(R.string.base_function_mode));
            textView.setText(sb2.toString());
            textView.append("。\n\n您可以通过阅读完整的");
            SpannableString spannableString = new SpannableString(activity.getString(R.string.privacy_policy));
            spannableString.setSpan(new c(mVar, activity), 0, 6, 17);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.append(spannableString);
            textView.append("和");
            SpannableString spannableString2 = new SpannableString(activity.getString(R.string.service_policy));
            spannableString2.setSpan(new d(mVar, activity), 0, 6, 17);
            textView.append(spannableString2);
            textView.append(activity.getString(R.string.to_know_infomation));
            TextView textView2 = (TextView) inflate.findViewById(R.id.privacy_known);
            TextView textView3 = (TextView) inflate.findViewById(R.id.privacy_agree);
            if (z10) {
                textView3.setTextColor(ContextCompat.getColor(activity, R.color.day_text_color_primary));
            }
            textView2.setText(activity.getString(R.string.unagree_exit));
            textView2.setOnClickListener(new View.OnClickListener() { // from class: l9.g0
                public /* synthetic */ g0() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i0.l0(i0.m.this, view);
                }
            });
            textView3.setText(activity.getString(R.string.agree_to_use));
            textView3.setOnClickListener(new View.OnClickListener() { // from class: l9.h0

                /* renamed from: b */
                public final /* synthetic */ View f27984b;

                /* renamed from: c */
                public final /* synthetic */ i0.m f27985c;

                public /* synthetic */ h0(View inflate2, i0.m mVar2) {
                    inflate = inflate2;
                    mVar = mVar2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i0.m0(inflate, mVar, view);
                }
            });
            activity.getWindow().addContentView(inflate2, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public static PopupWindow J(Activity activity, View view, boolean z10, int i10) {
        return L(activity, view, z10, i10, false, true);
    }

    public static void J0(Activity activity, String str, boolean z10, m mVar) {
        if (m0.C(activity)) {
            View inflate = LayoutInflater.from(activity).inflate(R.layout.libmars_popupwindow_privacy, (ViewGroup) null);
            int h10 = ba.m.h(activity);
            if (h10 > 0) {
                ((ScrollView) inflate.findViewById(R.id.privacy_scroll_view)).getLayoutParams().height = Math.min(h10 / 3, ConfigSingleton.i(200.0f));
            }
            ((TextView) inflate.findViewById(R.id.privacy_title)).setText(ConfigSingleton.D().s("欢迎使用" + str));
            TextView textView = (TextView) inflate.findViewById(R.id.privacy_desc);
            textView.setText(ConfigSingleton.D().s("以下是个人信息保护指引：\n\n1、您可以查看完整版"));
            SpannableString spannableString = new SpannableString(activity.getString(R.string.privacy_policy));
            spannableString.setSpan(new a(mVar, activity), 0, 6, 17);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.append(spannableString);
            textView.append("和");
            SpannableString spannableString2 = new SpannableString(activity.getString(R.string.service_policy));
            spannableString2.setSpan(new b(mVar, activity), 0, 6, 17);
            textView.append(spannableString2);
            textView.append(activity.getString(R.string.service_policy_guide));
            textView.append(ConfigSingleton.D().s("\n\n2、在浏览使用时，我们会收集、使用设备标识信息（设备IP、Mac地址等）用于生成游客账号，保障账户安全\n\n3、我们可能会申请相册（存储）权限，以实现小说内容下载、txt导入、字体导入、应用升级等功能\n\n4、我们可能会申请电话权限，以保障软件服务的安全运营和效率，完成广告和信息的推送和统计。\n\n5、我们可能会收集软件安装列表，以便了解合作软件的安装情况\n\n如果您同意请点击下面的按钮以接受我们的服务"));
            TextView textView2 = (TextView) inflate.findViewById(R.id.privacy_known);
            TextView textView3 = (TextView) inflate.findViewById(R.id.privacy_agree);
            if (z10) {
                textView3.setTextColor(ContextCompat.getColor(activity, R.color.day_text_color_primary));
            }
            textView2.setOnClickListener(new View.OnClickListener() { // from class: l9.k

                /* renamed from: b */
                public final /* synthetic */ View f28012b;

                /* renamed from: c */
                public final /* synthetic */ Activity f28013c;

                /* renamed from: d */
                public final /* synthetic */ String f28014d;

                /* renamed from: e */
                public final /* synthetic */ boolean f28015e;

                /* renamed from: f */
                public final /* synthetic */ i0.m f28016f;

                public /* synthetic */ k(View inflate2, Activity activity2, String str2, boolean z102, i0.m mVar2) {
                    inflate = inflate2;
                    activity = activity2;
                    str = str2;
                    z10 = z102;
                    mVar = mVar2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i0.n0(inflate, activity, str, z10, mVar, view);
                }
            });
            textView3.setOnClickListener(new View.OnClickListener() { // from class: l9.l

                /* renamed from: b */
                public final /* synthetic */ View f28017b;

                /* renamed from: c */
                public final /* synthetic */ i0.m f28018c;

                public /* synthetic */ l(View inflate2, i0.m mVar2) {
                    inflate = inflate2;
                    mVar = mVar2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i0.o0(inflate, mVar, view);
                }
            });
            activity2.getWindow().addContentView(inflate2, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public static PopupWindow K(Activity activity, View view, boolean z10, int i10, boolean z11) {
        return L(activity, view, z10, i10, z11, true);
    }

    public static void K0(Activity activity, String str, String[] strArr, int i10, n nVar) {
        if (m0.B(activity)) {
            View inflate = View.inflate(activity, R.layout.dialog_single_choice, null);
            View findViewById = inflate.findViewById(R.id.dialog_shade_view);
            ThemeTextView themeTextView = (ThemeTextView) inflate.findViewById(R.id.dialog_title);
            RadioGroup radioGroup = (RadioGroup) inflate.findViewById(R.id.dialog_radio_group);
            if (ConfigSingleton.D().A0()) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            if (!ba.l.q(str)) {
                themeTextView.setText(str);
            }
            radioGroup.removeAllViews();
            AlertDialog G = G(activity, inflate, true);
            if (G == null || strArr.length == 0) {
                return;
            }
            for (int i11 = 0; i11 < strArr.length; i11++) {
                if (i11 == i10) {
                    radioGroup.addView(F(activity, i11, true, strArr[i11], G, nVar));
                } else {
                    radioGroup.addView(F(activity, i11, false, strArr[i11], G, nVar));
                }
            }
        }
    }

    public static PopupWindow L(Activity activity, View view, boolean z10, int i10, boolean z11, boolean z12) {
        return H(activity, null, view, z10, i10, z11, z12);
    }

    public static void L0(Activity activity, EditText editText) {
        InputMethodManager inputMethodManager;
        if (activity == null || activity.isFinishing() || !editText.requestFocus() || (inputMethodManager = (InputMethodManager) activity.getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.showSoftInput(editText, 1);
    }

    public static void M(Activity activity, View view) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        if (view != null) {
            view.clearFocus();
        }
    }

    public static void M0(Activity activity) {
        if (activity == null || activity.isFinishing() || !m0.C(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: l9.s

            /* renamed from: b */
            public final /* synthetic */ Activity f28039b;

            public /* synthetic */ s(Activity activity2) {
                activity = activity2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                i0.r0(activity);
            }
        });
    }

    public static /* synthetic */ void N(AlertDialog alertDialog, n nVar, int i10, View view) {
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (nVar != null) {
            nVar.a(i10);
        }
    }

    public static /* synthetic */ void O(boolean z10, Activity activity) {
        if (z10) {
            s0(activity, false);
        }
    }

    public static /* synthetic */ void Q(p pVar, AlertDialog alertDialog, EditText editText, TextView textView, View view) {
        if (pVar != null) {
            pVar.a(alertDialog, editText, textView);
        }
    }

    public static /* synthetic */ void R(p pVar, EditText editText, TextView textView, View view) {
        if (pVar != null) {
            pVar.b(editText, textView);
        }
    }

    public static /* synthetic */ void S(AlertDialog alertDialog, k kVar, View view) {
        alertDialog.dismiss();
        if (kVar != null) {
            kVar.a();
        }
    }

    public static /* synthetic */ void T(AlertDialog alertDialog, l lVar, View view) {
        alertDialog.dismiss();
        if (lVar != null) {
            lVar.a();
        }
    }

    public static /* synthetic */ void V(AlertDialog alertDialog, i iVar, CheckBox checkBox, View view) {
        alertDialog.dismiss();
        if (iVar != null) {
            iVar.a(checkBox.isChecked());
        }
    }

    public static /* synthetic */ void X(AlertDialog alertDialog, k kVar, View view) {
        alertDialog.dismiss();
        if (kVar != null) {
            kVar.a();
        }
    }

    public static /* synthetic */ void Y(AlertDialog alertDialog, l lVar, View view) {
        alertDialog.dismiss();
        if (lVar != null) {
            lVar.a();
        }
    }

    public static /* synthetic */ void Z(Activity activity, DialogInputViewBinding dialogInputViewBinding) {
        L0(activity, dialogInputViewBinding.f12157e);
    }

    public static /* synthetic */ void a0(Activity activity, DialogInputViewBinding dialogInputViewBinding, AlertDialog alertDialog, View view) {
        M(activity, dialogInputViewBinding.f12157e);
        alertDialog.dismiss();
    }

    public static /* synthetic */ void b0(DialogInputViewBinding dialogInputViewBinding, Activity activity, j jVar, AlertDialog alertDialog, View view) {
        if (ba.l.q(dialogInputViewBinding.f12157e.getText().toString())) {
            t0.b(activity, "输入不能为空");
            return;
        }
        M(activity, dialogInputViewBinding.f12157e);
        if (jVar != null) {
            jVar.a(dialogInputViewBinding.f12157e.getText().toString());
        }
        alertDialog.dismiss();
    }

    public static /* synthetic */ void c0(View view, m mVar, View view2) {
        view.setVisibility(8);
        if (mVar != null) {
            mVar.c();
        }
    }

    public static /* synthetic */ void d0(View view, m mVar, View view2) {
        view.setVisibility(8);
        if (mVar != null) {
            mVar.d();
        }
    }

    public static /* synthetic */ void e0(AlertDialog alertDialog, k kVar, View view) {
        alertDialog.dismiss();
        if (kVar != null) {
            kVar.a();
        }
    }

    public static /* synthetic */ void f0(AlertDialog alertDialog, l lVar, View view) {
        alertDialog.dismiss();
        if (lVar != null) {
            lVar.a();
        }
    }

    public static /* synthetic */ boolean g0(PopupwindowOptionsBinding popupwindowOptionsBinding, PopupWindow popupWindow, View view, MotionEvent motionEvent) {
        int top = popupwindowOptionsBinding.f12337d.getTop();
        int y10 = (int) motionEvent.getY();
        if (motionEvent.getAction() == 1 && y10 < top) {
            popupWindow.dismiss();
        }
        return true;
    }

    public static /* synthetic */ void h0(o oVar, PopupWindow popupWindow, View view) {
        if (oVar != null) {
            oVar.c();
        }
        popupWindow.dismiss();
    }

    public static /* synthetic */ void i0(o oVar, PopupWindow popupWindow, View view) {
        if (oVar != null) {
            oVar.b();
        }
        popupWindow.dismiss();
    }

    public static /* synthetic */ void k0(Activity activity, o oVar) {
        s0(activity, false);
        if (oVar != null) {
            oVar.a();
        }
    }

    public static /* synthetic */ void l0(m mVar, View view) {
        if (mVar != null) {
            mVar.e();
        }
    }

    public static /* synthetic */ void m0(View view, m mVar, View view2) {
        view.setVisibility(8);
        if (mVar != null) {
            mVar.d();
        }
    }

    public static /* synthetic */ void n0(View view, Activity activity, String str, boolean z10, m mVar, View view2) {
        view.setVisibility(8);
        I0(activity, str, z10, mVar);
    }

    public static /* synthetic */ void o0(View view, m mVar, View view2) {
        view.setVisibility(8);
        if (mVar != null) {
            mVar.d();
        }
    }

    public static /* synthetic */ void r0(Activity activity) {
        F0(activity, "剩余空间不足", "内部存储空间不足，App可能无法正常使用，请尽快清理。", "知道了", new k() { // from class: l9.e0
            @Override // l9.i0.k
            public final void a() {
                i0.p0();
            }
        }, new l() { // from class: l9.f0
            @Override // l9.i0.l
            public final void a() {
                i0.q0();
            }
        });
    }

    public static void s0(Activity activity, boolean z10) {
        if (m0.B(activity)) {
            ViewGroup viewGroup = (ViewGroup) activity.findViewById(android.R.id.content);
            View findViewWithTag = viewGroup.findViewWithTag(f27990a);
            if (findViewWithTag == null) {
                findViewWithTag = new View(activity);
                findViewWithTag.setTag(f27990a);
                findViewWithTag.setBackgroundColor(-16777216);
                findViewWithTag.setAlpha(0.5f);
                viewGroup.addView(findViewWithTag);
            }
            if (z10) {
                findViewWithTag.setVisibility(0);
            } else {
                findViewWithTag.setVisibility(8);
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: l9.c0.<init>(l9.i0$p, android.app.AlertDialog, android.widget.EditText, android.widget.TextView):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    public static android.widget.ImageView t0(android.app.Activity r8, java.lang.String r9, java.lang.String r10, l9.i0.p r11) {
        /*
            boolean r0 = l9.m0.B(r8)
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            int r0 = com.martian.libmars.R.layout.dialog_verification_code
            android.view.View r0 = android.view.View.inflate(r8, r0, r1)
            int r2 = com.martian.libmars.R.id.dialog_view
            android.view.View r2 = r0.findViewById(r2)
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r2 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r2
            int r3 = ba.m.i(r8)
            r4 = 1117782016(0x42a00000, float:80.0)
            int r4 = com.martian.libmars.common.ConfigSingleton.i(r4)
            int r3 = r3 - r4
            r2.width = r3
            int r2 = com.martian.libmars.R.id.iv_close
            android.view.View r2 = r0.findViewById(r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            int r3 = com.martian.libmars.R.id.dialog_code_title
            android.view.View r3 = r0.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            int r4 = com.martian.libmars.R.id.dialog_edit
            android.view.View r4 = r0.findViewById(r4)
            android.widget.EditText r4 = (android.widget.EditText) r4
            int r5 = com.martian.libmars.R.id.iv_refresh
            android.view.View r5 = r0.findViewById(r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            int r6 = com.martian.libmars.R.id.tv_error_tips
            android.view.View r6 = r0.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            boolean r7 = android.text.TextUtils.isEmpty(r9)
            if (r7 != 0) goto L5a
            r3.setText(r9)
        L5a:
            int r9 = com.martian.libmars.R.id.code_bg
            android.view.View r9 = r0.findViewById(r9)
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            l9.m0.k(r8, r10, r9)
            int r10 = com.martian.libmars.R.id.tv_confirm
            android.view.View r10 = r0.findViewById(r10)
            com.martian.libmars.ui.theme.ThemeTextView r10 = (com.martian.libmars.ui.theme.ThemeTextView) r10
            r3 = 1053609165(0x3ecccccd, float:0.4)
            r10.setAlpha(r3)
            r3 = 0
            r10.setEnabled(r3)
            android.app.AlertDialog$Builder r7 = new android.app.AlertDialog$Builder
            r7.<init>(r8)
            r7.setView(r0)
            android.app.AlertDialog r8 = r7.show()
            if (r8 == 0) goto Lb4
            r8.setCancelable(r3)
            r8.setCanceledOnTouchOutside(r3)
            android.view.Window r0 = r8.getWindow()
            if (r0 == 0) goto L94
            r0.setBackgroundDrawable(r1)
        L94:
            l9.b0 r0 = new l9.b0
            r0.<init>()
            r2.setOnClickListener(r0)
            l9.c0 r0 = new l9.c0
            r0.<init>()
            r10.setOnClickListener(r0)
            l9.d0 r8 = new l9.d0
            r8.<init>()
            r5.setOnClickListener(r8)
            l9.i0$g r8 = new l9.i0$g
            r8.<init>(r10, r6)
            r4.addTextChangedListener(r8)
        Lb4:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: l9.i0.t0(android.app.Activity, java.lang.String, java.lang.String, l9.i0$p):android.widget.ImageView");
    }

    public static AlertDialog u0(Context context, String str, Spanned spanned, String str2, String str3, boolean z10, l lVar, k kVar) {
        return v0(context, str, spanned, str2, str3, z10, lVar, kVar, null);
    }

    public static AlertDialog v0(Context context, String str, Spanned spanned, String str2, String str3, boolean z10, l lVar, k kVar, DialogInterface.OnDismissListener onDismissListener) {
        if (!m0.B(context)) {
            return null;
        }
        View inflate = View.inflate(context, R.layout.dialog_confirm_view, null);
        ThemeTextView themeTextView = (ThemeTextView) inflate.findViewById(R.id.dialog_title);
        ThemeTextView themeTextView2 = (ThemeTextView) inflate.findViewById(R.id.dialog_desc);
        ThemeTextView themeTextView3 = (ThemeTextView) inflate.findViewById(R.id.dialog_close);
        ThemeTextView themeTextView4 = (ThemeTextView) inflate.findViewById(R.id.dialog_notarize);
        View findViewById = inflate.findViewById(R.id.dialog_shade_view);
        if (!ba.l.q(str)) {
            themeTextView.setText(str);
        }
        if (!ba.l.q(spanned.toString())) {
            themeTextView2.setText(spanned);
        }
        if (!ba.l.q(str3)) {
            themeTextView4.setText(str3);
        }
        if (!ba.l.q(str2)) {
            themeTextView3.setText(str2);
        }
        AlertDialog G = G(context, inflate, z10);
        if (G == null) {
            return null;
        }
        if (ConfigSingleton.D().A0()) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        themeTextView3.setOnClickListener(new View.OnClickListener() { // from class: l9.w

            /* renamed from: b */
            public final /* synthetic */ AlertDialog f28046b;

            /* renamed from: c */
            public final /* synthetic */ i0.k f28047c;

            public /* synthetic */ w(AlertDialog G2, i0.k kVar2) {
                G = G2;
                kVar = kVar2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i0.S(G, kVar, view);
            }
        });
        themeTextView4.setOnClickListener(new View.OnClickListener() { // from class: l9.x

            /* renamed from: b */
            public final /* synthetic */ AlertDialog f28048b;

            /* renamed from: c */
            public final /* synthetic */ i0.l f28049c;

            public /* synthetic */ x(AlertDialog G2, i0.l lVar2) {
                G = G2;
                lVar = lVar2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i0.T(G, lVar, view);
            }
        });
        if (onDismissListener != null) {
            G2.setOnDismissListener(onDismissListener);
        }
        return G2;
    }

    public static AlertDialog w0(Context context, String str, Spanned spanned, l lVar) {
        return u0(context, str, spanned, "", "", false, lVar, null);
    }

    public static AlertDialog x0(Context context, String str, String str2, String str3, String str4, boolean z10, l lVar, k kVar) {
        return u0(context, str, Html.fromHtml(str2), str3, str4, z10, lVar, kVar);
    }

    public static AlertDialog y0(Context context, String str, String str2, String str3, String str4, boolean z10, l lVar, k kVar, DialogInterface.OnDismissListener onDismissListener) {
        return v0(context, str, Html.fromHtml(str2), str3, str4, z10, lVar, kVar, onDismissListener);
    }

    public static AlertDialog z0(Context context, String str, String str2, l lVar) {
        return w0(context, str, Html.fromHtml(str2), lVar);
    }

    public static /* synthetic */ void p0() {
    }

    public static /* synthetic */ void q0() {
    }

    public class g implements TextWatcher {

        /* renamed from: b */
        public final /* synthetic */ ThemeTextView f28003b;

        /* renamed from: c */
        public final /* synthetic */ TextView f28004c;

        public g(ThemeTextView themeTextView, TextView textView) {
            this.f28003b = themeTextView;
            this.f28004c = textView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable.toString().trim())) {
                this.f28003b.setAlpha(0.4f);
                this.f28003b.setEnabled(false);
            } else {
                this.f28003b.setAlpha(1.0f);
                this.f28003b.setEnabled(true);
                this.f28004c.setVisibility(4);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }
}
