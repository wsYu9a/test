package com.martian.libmars.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.text.Html;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.gyf.barlibrary.ImmersionBar;
import com.martian.libmars.R;
import com.martian.libmars.activity.j1;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.utils.k0;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;

/* loaded from: classes.dex */
public class k0 {

    /* renamed from: a */
    private static final String f10157a = "MASK_VIEW";

    /* loaded from: classes2.dex */
    static class a extends ClickableSpan {

        /* renamed from: a */
        final /* synthetic */ m f10158a;

        /* renamed from: b */
        final /* synthetic */ j1 f10159b;

        a(final m val$activity, final j1 val$listener) {
            this.f10158a = val$activity;
            this.f10159b = val$listener;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            m mVar = this.f10158a;
            if (mVar != null) {
                mVar.b();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            ds.setUnderlineText(true);
            ds.setColor(this.f10159b.getResources().getColor(R.color.day_text_color_primary));
        }
    }

    /* loaded from: classes2.dex */
    static class b extends ClickableSpan {

        /* renamed from: a */
        final /* synthetic */ m f10160a;

        /* renamed from: b */
        final /* synthetic */ j1 f10161b;

        b(final m val$activity, final j1 val$listener) {
            this.f10160a = val$activity;
            this.f10161b = val$listener;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            m mVar = this.f10160a;
            if (mVar != null) {
                mVar.c();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            ds.setUnderlineText(true);
            ds.setColor(this.f10161b.getResources().getColor(R.color.day_text_color_primary));
        }
    }

    /* loaded from: classes2.dex */
    static class c extends ClickableSpan {

        /* renamed from: a */
        final /* synthetic */ m f10162a;

        /* renamed from: b */
        final /* synthetic */ Activity f10163b;

        c(final m val$activity, final Activity val$listener) {
            this.f10162a = val$activity;
            this.f10163b = val$listener;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            m mVar = this.f10162a;
            if (mVar != null) {
                mVar.e();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            ds.setUnderlineText(true);
            ds.setColor(this.f10163b.getResources().getColor(R.color.day_text_color_primary));
        }
    }

    /* loaded from: classes2.dex */
    static class d extends ClickableSpan {

        /* renamed from: a */
        final /* synthetic */ m f10164a;

        /* renamed from: b */
        final /* synthetic */ Activity f10165b;

        d(final m val$activity, final Activity val$listener) {
            this.f10164a = val$activity;
            this.f10165b = val$listener;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            m mVar = this.f10164a;
            if (mVar != null) {
                mVar.b();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            ds.setUnderlineText(true);
            ds.setColor(this.f10165b.getResources().getColor(R.color.day_text_color_primary));
        }
    }

    /* loaded from: classes2.dex */
    static class e extends ClickableSpan {

        /* renamed from: a */
        final /* synthetic */ m f10166a;

        /* renamed from: b */
        final /* synthetic */ Activity f10167b;

        e(final m val$activity, final Activity val$listener) {
            this.f10166a = val$activity;
            this.f10167b = val$listener;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            m mVar = this.f10166a;
            if (mVar != null) {
                mVar.c();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            ds.setUnderlineText(true);
            ds.setColor(this.f10167b.getResources().getColor(R.color.day_text_color_primary));
        }
    }

    /* loaded from: classes2.dex */
    public interface f {
        void a(boolean[] itemChecked);
    }

    /* loaded from: classes2.dex */
    public interface g {
        void a(boolean isChecked);
    }

    /* loaded from: classes2.dex */
    public interface h {
        void a(String text, AlertDialog alertDialog);
    }

    /* loaded from: classes2.dex */
    public interface i {
        void a(String text);
    }

    public interface j {
        void a();
    }

    /* loaded from: classes2.dex */
    public interface k {
        void a();

        void b();
    }

    public interface l {
        void a();
    }

    /* loaded from: classes2.dex */
    public interface m {
        void a();

        void b();

        void c();

        void d();

        void e();
    }

    /* loaded from: classes2.dex */
    public interface n {
        void a(int which);
    }

    /* loaded from: classes2.dex */
    public interface o {
        void a();

        void b();

        void c();
    }

    static /* synthetic */ void A(final o listener, final PopupWindow window, View v) {
        if (listener != null) {
            listener.c();
        }
        window.dismiss();
    }

    static /* synthetic */ void B(final o listener, final PopupWindow window, View v) {
        if (listener != null) {
            listener.b();
        }
        window.dismiss();
    }

    static /* synthetic */ void D(final j1 activity, final o listener) {
        L(activity, false);
        if (listener != null) {
            listener.a();
        }
    }

    static /* synthetic */ void E(final View view, final k listener, View v) {
        view.setVisibility(8);
        if (listener != null) {
            listener.a();
        }
    }

    static /* synthetic */ void F(final View view, final k listener, View v) {
        view.setVisibility(8);
        if (listener != null) {
            listener.b();
        }
    }

    static /* synthetic */ void G(final m listener, final Activity activity, View v) {
        if (listener != null) {
            listener.a();
        }
        Intent intent = new Intent();
        intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        activity.startActivity(intent);
    }

    static /* synthetic */ void H(final View view, final m listener, View v) {
        view.setVisibility(8);
        if (listener != null) {
            listener.d();
        }
    }

    static /* synthetic */ void I(final View view, final j1 activity, final String appName, final boolean lightMode, final m listener, View v) {
        view.setVisibility(8);
        Z(activity, appName, lightMode, listener);
    }

    static /* synthetic */ void J(final View view, final m listener, View v) {
        view.setVisibility(8);
        if (listener != null) {
            listener.d();
        }
    }

    public static void L(Activity activity, boolean showMask) {
        if (n0.B(activity)) {
            ViewGroup viewGroup = (ViewGroup) activity.findViewById(android.R.id.content);
            View findViewWithTag = viewGroup.findViewWithTag(f10157a);
            if (findViewWithTag == null) {
                findViewWithTag = new View(activity);
                findViewWithTag.setTag(f10157a);
                findViewWithTag.setBackgroundColor(-16777216);
                findViewWithTag.setAlpha(0.5f);
                viewGroup.addView(findViewWithTag);
            }
            if (showMask) {
                findViewWithTag.setVisibility(0);
            } else {
                findViewWithTag.setVisibility(8);
            }
        }
    }

    public static ImageView M(Activity context, String title, String url, final h codeDialogClickListener) {
        if (!n0.B(context)) {
            return null;
        }
        View inflate = View.inflate(context, R.layout.dialog_verification_code, null);
        ((RelativeLayout.LayoutParams) ((LinearLayout) inflate.findViewById(R.id.dialog_view)).getLayoutParams()).width = com.martian.libsupport.l.h(context) - com.martian.libmars.d.h.b(80.0f);
        TextView textView = (TextView) inflate.findViewById(R.id.dialog_code_title);
        final EditText editText = (EditText) inflate.findViewById(R.id.dialog_edit);
        View findViewById = inflate.findViewById(R.id.code_edit_view);
        findViewById.setVisibility(0);
        if (!com.martian.libsupport.k.p(title)) {
            textView.setText(title);
        }
        if (com.martian.libmars.d.h.F().I0()) {
            findViewById.setBackgroundResource(R.drawable.border_search_line_night);
        } else {
            findViewById.setBackgroundResource(R.drawable.border_search_line_day);
        }
        ImageView imageView = (ImageView) inflate.findViewById(R.id.code_bg);
        n0.l(context, url, imageView, R.drawable.image_loading_default_horizontal);
        ThemeTextView themeTextView = (ThemeTextView) inflate.findViewById(R.id.get_captcha);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(inflate);
        final AlertDialog show = builder.show();
        show.getWindow().setBackgroundDrawable(null);
        themeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.martian.libmars.utils.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k0.m(k0.h.this, editText, show, view);
            }
        });
        return imageView;
    }

    public static void N(Activity context, String title, Spanned desc, final l postiveClickListener) {
        O(context, title, desc, "", "", false, postiveClickListener, null);
    }

    public static void O(Activity context, String title, Spanned desc, String neutral, String postive, boolean cancelable, final l postiveClickListener, final j negativeClickListener) {
        if (n0.B(context)) {
            View inflate = View.inflate(context, R.layout.dialog_confirm_view, null);
            ThemeTextView themeTextView = (ThemeTextView) inflate.findViewById(R.id.dialog_title);
            ThemeTextView themeTextView2 = (ThemeTextView) inflate.findViewById(R.id.dialog_desc);
            ThemeTextView themeTextView3 = (ThemeTextView) inflate.findViewById(R.id.dialog_close);
            ThemeTextView themeTextView4 = (ThemeTextView) inflate.findViewById(R.id.dialog_notarize);
            View findViewById = inflate.findViewById(R.id.dialog_shade_view);
            if (!com.martian.libsupport.k.p(title)) {
                themeTextView.setText(title);
            }
            if (!com.martian.libsupport.k.p(desc.toString())) {
                themeTextView2.setText(desc);
            }
            if (!com.martian.libsupport.k.p(postive)) {
                themeTextView4.setText(postive);
            }
            if (!com.martian.libsupport.k.p(neutral)) {
                themeTextView3.setText(neutral);
            }
            final AlertDialog b2 = b(context, inflate, cancelable);
            if (b2 == null) {
                return;
            }
            if (com.martian.libmars.d.h.F().I0()) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            themeTextView3.setOnClickListener(new View.OnClickListener() { // from class: com.martian.libmars.utils.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    k0.n(b2, negativeClickListener, view);
                }
            });
            themeTextView4.setOnClickListener(new View.OnClickListener() { // from class: com.martian.libmars.utils.a0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    k0.o(b2, postiveClickListener, view);
                }
            });
        }
    }

    public static void P(Activity context, String title, String desc, final l l2) {
        N(context, title, Html.fromHtml(desc), l2);
    }

    public static void Q(Activity context, String title, String desc, String neutral, String postive, boolean cancelable, final l postiveClickListener, final j negativeClickListener) {
        O(context, title, Html.fromHtml(desc), neutral, postive, cancelable, postiveClickListener, negativeClickListener);
    }

    public static void R(Activity context, String title, String desc, String checkDesc, boolean checked, final g checkedClickListener) {
        if (n0.B(context)) {
            View inflate = View.inflate(context, R.layout.dialog_confirm_view, null);
            ThemeTextView themeTextView = (ThemeTextView) inflate.findViewById(R.id.dialog_title);
            ThemeTextView themeTextView2 = (ThemeTextView) inflate.findViewById(R.id.dialog_desc);
            ThemeTextView themeTextView3 = (ThemeTextView) inflate.findViewById(R.id.dialog_close);
            ThemeTextView themeTextView4 = (ThemeTextView) inflate.findViewById(R.id.dialog_notarize);
            final CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.dialog_check);
            checkBox.setVisibility(0);
            View findViewById = inflate.findViewById(R.id.dialog_shade_view);
            if (!com.martian.libsupport.k.p(title)) {
                themeTextView.setText(title);
            }
            if (!com.martian.libsupport.k.p(desc)) {
                themeTextView2.setText(desc);
            }
            if (!com.martian.libsupport.k.p(checkDesc)) {
                checkBox.setText(checkDesc);
            }
            checkBox.setTextColor(com.martian.libmars.d.h.F().r0());
            checkBox.setChecked(checked);
            final AlertDialog b2 = b(context, inflate, true);
            if (b2 == null) {
                return;
            }
            if (com.martian.libmars.d.h.F().I0()) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            themeTextView3.setOnClickListener(new View.OnClickListener() { // from class: com.martian.libmars.utils.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    b2.dismiss();
                }
            });
            themeTextView4.setOnClickListener(new View.OnClickListener() { // from class: com.martian.libmars.utils.x
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    k0.q(b2, checkedClickListener, checkBox, view);
                }
            });
        }
    }

    public static void S(Activity context, String title, String desc, String neutral, String postive, final j negativeClickListener, final l postiveClickListener) {
        if (n0.B(context)) {
            View inflate = View.inflate(context, R.layout.dialog_confirm_hint, null);
            ThemeTextView themeTextView = (ThemeTextView) inflate.findViewById(R.id.dialog_title);
            ThemeTextView themeTextView2 = (ThemeTextView) inflate.findViewById(R.id.dialog_desc);
            ThemeTextView themeTextView3 = (ThemeTextView) inflate.findViewById(R.id.dialog_close);
            ThemeTextView themeTextView4 = (ThemeTextView) inflate.findViewById(R.id.dialog_notarize);
            ThemeImageView themeImageView = (ThemeImageView) inflate.findViewById(R.id.dialog_close_image);
            View findViewById = inflate.findViewById(R.id.dialog_shade_view);
            if (!com.martian.libsupport.k.p(title)) {
                themeTextView.setText(title);
            }
            if (!com.martian.libsupport.k.p(desc)) {
                themeTextView2.setText(desc);
            }
            if (!com.martian.libsupport.k.p(neutral)) {
                themeTextView3.setText(neutral);
            }
            if (!com.martian.libsupport.k.p(postive)) {
                themeTextView4.setText(postive);
            }
            final AlertDialog b2 = b(context, inflate, true);
            if (b2 == null) {
                return;
            }
            if (com.martian.libmars.d.h.F().I0()) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            themeImageView.setOnClickListener(new View.OnClickListener() { // from class: com.martian.libmars.utils.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    b2.dismiss();
                }
            });
            themeTextView3.setOnClickListener(new View.OnClickListener() { // from class: com.martian.libmars.utils.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    k0.s(b2, negativeClickListener, view);
                }
            });
            themeTextView4.setOnClickListener(new View.OnClickListener() { // from class: com.martian.libmars.utils.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    k0.t(b2, postiveClickListener, view);
                }
            });
        }
    }

    public static void T(final Activity activity, String title, String content, String hint, boolean isPwd, boolean isNewPwd, final i editTextEnterListener) {
        if (n0.B(activity)) {
            View inflate = activity.getLayoutInflater().inflate(R.layout.dialog_input_view, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.dialog_create_title);
            final EditText editText = (EditText) inflate.findViewById(R.id.dialog_edit);
            TextView textView2 = (TextView) inflate.findViewById(R.id.dialog_close);
            TextView textView3 = (TextView) inflate.findViewById(R.id.dialog_notarize);
            View findViewById = inflate.findViewById(R.id.dialog_shade_view);
            if (!com.martian.libsupport.k.p(title)) {
                textView.setText(title);
            }
            final AlertDialog b2 = b(activity, inflate, true);
            if (b2 == null) {
                return;
            }
            if (b2.getWindow() != null) {
                b2.getWindow().clearFlags(131072);
            }
            new Handler().post(new Runnable() { // from class: com.martian.libmars.utils.f
                @Override // java.lang.Runnable
                public final void run() {
                    k0.c0(activity, editText);
                }
            });
            editText.setTextColor(com.martian.libmars.d.h.F().p0());
            editText.setHintTextColor(com.martian.libmars.d.h.F().r0());
            if (!com.martian.libsupport.k.p(content)) {
                editText.setText(content);
                editText.setSelection(content.length());
            }
            if (!com.martian.libsupport.k.p(hint)) {
                editText.setHint(hint);
            }
            if (isPwd) {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            if (isNewPwd) {
                editText.setInputType(2);
                editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
            }
            if (com.martian.libmars.d.h.F().I0()) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.martian.libmars.utils.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    k0.v(activity, editText, b2, view);
                }
            });
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.martian.libmars.utils.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    k0.w(editText, activity, editTextEnterListener, b2, view);
                }
            });
        }
    }

    public static void U(final Activity activity, String title, String hint, boolean isPwd, final i editTextEnterListener) {
        V(activity, title, hint, isPwd, false, editTextEnterListener);
    }

    public static void V(final Activity activity, String title, String hint, boolean isPwd, boolean isNewPwd, final i editTextEnterListener) {
        T(activity, title, "", hint, isPwd, isNewPwd, editTextEnterListener);
    }

    public static void W(Activity context, String title, String desc, String postive, final j negativeClickListener, final l postiveClickListener) {
        if (n0.B(context)) {
            View inflate = View.inflate(context, R.layout.dialog_single_button, null);
            ThemeTextView themeTextView = (ThemeTextView) inflate.findViewById(R.id.dialog_title);
            ThemeTextView themeTextView2 = (ThemeTextView) inflate.findViewById(R.id.dialog_desc);
            ThemeImageView themeImageView = (ThemeImageView) inflate.findViewById(R.id.dialog_close);
            ThemeTextView themeTextView3 = (ThemeTextView) inflate.findViewById(R.id.dialog_notarize);
            if (!com.martian.libsupport.k.p(title)) {
                themeTextView.setText(title);
            }
            if (!com.martian.libsupport.k.p(desc)) {
                themeTextView2.setText(desc);
            }
            if (!com.martian.libsupport.k.p(postive)) {
                themeTextView3.setText(postive);
            }
            final AlertDialog b2 = b(context, inflate, true);
            if (b2 == null) {
                return;
            }
            themeImageView.setOnClickListener(new View.OnClickListener() { // from class: com.martian.libmars.utils.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    k0.x(b2, negativeClickListener, view);
                }
            });
            themeTextView3.setOnClickListener(new View.OnClickListener() { // from class: com.martian.libmars.utils.y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    k0.y(b2, postiveClickListener, view);
                }
            });
        }
    }

    public static void X(final j1 activity, String title, String firstDesc, String secondDesc, boolean lightMode, final o listener) {
        if (n0.B(activity)) {
            View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.popupwindow_options, (ViewGroup) null);
            final com.martian.libmars.e.k0 a2 = com.martian.libmars.e.k0.a(inflate);
            final PopupWindow popupWindow = new PopupWindow(inflate, -1, -1);
            popupWindow.setFocusable(true);
            popupWindow.setOutsideTouchable(true);
            popupWindow.setClippingEnabled(false);
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
            L(activity, true);
            popupWindow.setAnimationStyle(R.style.updownpopwindow_anim_style);
            popupWindow.showAtLocation(activity.getWindow().getDecorView(), 80, 0, 0);
            inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.martian.libmars.utils.s
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return k0.z(com.martian.libmars.e.k0.this, popupWindow, view, motionEvent);
                }
            });
            a2.f10017c.setText(title);
            a2.f10019e.setText(firstDesc);
            a2.f10019e.setOnClickListener(new View.OnClickListener() { // from class: com.martian.libmars.utils.b0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    k0.A(k0.o.this, popupWindow, view);
                }
            });
            if (com.martian.libsupport.k.p(secondDesc)) {
                a2.f10020f.setVisibility(8);
            } else {
                a2.f10020f.setVisibility(0);
                a2.f10020f.setText(secondDesc);
            }
            a2.f10020f.setOnClickListener(new View.OnClickListener() { // from class: com.martian.libmars.utils.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    k0.B(k0.o.this, popupWindow, view);
                }
            });
            a2.f10016b.setOnClickListener(new View.OnClickListener() { // from class: com.martian.libmars.utils.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    popupWindow.dismiss();
                }
            });
            if (lightMode) {
                a2.f10019e.setTextColor(ContextCompat.getColor(activity, R.color.day_text_color_primary));
            }
            if (ImmersionBar.hasNavigationBar(activity)) {
                a2.f10018d.setPadding(0, 0, 0, com.martian.libmars.d.h.b(48.0f));
            }
            popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.martian.libmars.utils.a
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    k0.D(j1.this, listener);
                }
            });
        }
    }

    public static void Y(final j1 activity, final k listener) {
        final View inflate = LayoutInflater.from(activity).inflate(R.layout.libmars_popupwindow_permission, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.privacy_known);
        TextView textView2 = (TextView) inflate.findViewById(R.id.privacy_agree);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.martian.libmars.utils.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k0.E(inflate, listener, view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.martian.libmars.utils.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k0.F(inflate, listener, view);
            }
        });
        activity.getWindow().addContentView(inflate, new ViewGroup.LayoutParams(-1, -1));
    }

    public static void Z(final Activity activity, String appName, boolean lightMode, final m listener) {
        final View inflate = LayoutInflater.from(activity).inflate(R.layout.libmars_popupwindow_privacy, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.privacy_deac);
        textView.setText(com.martian.libmars.d.h.F().n(activity.getString(R.string.privacy_guide_desc_1) + appName + "。\n\n" + activity.getString(R.string.privacy_guide_desc_2) + appName + activity.getString(R.string.privacy_guide_desc_3)));
        SpannableString spannableString = new SpannableString(activity.getString(R.string.base_function_mode));
        spannableString.setSpan(new c(listener, activity), 0, 6, 17);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.append(spannableString);
        textView.append("。\n\n您可以通过阅读完整的");
        SpannableString spannableString2 = new SpannableString(activity.getString(R.string.privacy_policy));
        spannableString2.setSpan(new d(listener, activity), 0, 6, 17);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.append(spannableString2);
        textView.append("和");
        SpannableString spannableString3 = new SpannableString(activity.getString(R.string.service_policy));
        spannableString3.setSpan(new e(listener, activity), 0, 6, 17);
        textView.append(spannableString3);
        textView.append(activity.getString(R.string.to_know_infomation));
        TextView textView2 = (TextView) inflate.findViewById(R.id.privacy_known);
        TextView textView3 = (TextView) inflate.findViewById(R.id.privacy_agree);
        if (lightMode) {
            textView3.setTextColor(ContextCompat.getColor(activity, R.color.day_text_color_primary));
        }
        textView2.setText(activity.getString(R.string.unagree_exit));
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.martian.libmars.utils.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k0.G(k0.m.this, activity, view);
            }
        });
        textView3.setText(activity.getString(R.string.agree_to_use));
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.martian.libmars.utils.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k0.H(inflate, listener, view);
            }
        });
        activity.getWindow().addContentView(inflate, new ViewGroup.LayoutParams(-1, -1));
    }

    private static View a(Context activity, final int position, boolean isChecked, String name, final AlertDialog alertDialog, final n selectedListener) {
        View inflate = View.inflate(activity, R.layout.dialog_list_item, null);
        RadioButton radioButton = (RadioButton) inflate.findViewById(R.id.dialog_item_radio);
        radioButton.setVisibility(0);
        radioButton.setChecked(isChecked);
        if (!com.martian.libsupport.k.p(name)) {
            radioButton.setText(name);
        }
        radioButton.measure(0, 0);
        radioButton.setCompoundDrawablePadding(((com.martian.libsupport.l.h(activity) - com.martian.libmars.d.h.b(90.0f)) - com.martian.libmars.d.h.b(48.0f)) - radioButton.getMeasuredWidth());
        radioButton.setTextColor(com.martian.libmars.d.h.F().p0());
        radioButton.setOnClickListener(new View.OnClickListener() { // from class: com.martian.libmars.utils.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k0.i(alertDialog, selectedListener, position, view);
            }
        });
        return inflate;
    }

    public static void a0(final j1 activity, final String appName, final boolean lightMode, final m listener) {
        if (n0.C(activity)) {
            final View inflate = LayoutInflater.from(activity).inflate(R.layout.libmars_popupwindow_privacy, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.privacy_deac);
            textView.setText(com.martian.libmars.d.h.F().n("欢迎使用" + appName + "！我们将通过"));
            SpannableString spannableString = new SpannableString(activity.getString(R.string.privacy_policy));
            spannableString.setSpan(new a(listener, activity), 0, 6, 17);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.append(spannableString);
            textView.append("和");
            SpannableString spannableString2 = new SpannableString(activity.getString(R.string.service_policy));
            spannableString2.setSpan(new b(listener, activity), 0, 6, 17);
            textView.append(spannableString2);
            textView.append(activity.getString(R.string.service_policy_guide));
            TextView textView2 = (TextView) inflate.findViewById(R.id.privacy_known);
            TextView textView3 = (TextView) inflate.findViewById(R.id.privacy_agree);
            if (lightMode) {
                textView3.setTextColor(ContextCompat.getColor(activity, R.color.day_text_color_primary));
            }
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.martian.libmars.utils.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    k0.I(inflate, activity, appName, lightMode, listener, view);
                }
            });
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.martian.libmars.utils.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    k0.J(inflate, listener, view);
                }
            });
            activity.getWindow().addContentView(inflate, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public static AlertDialog b(Activity context, View view, boolean cancelable) {
        if (!n0.B(context)) {
            return null;
        }
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setCancelable(cancelable);
            AlertDialog show = builder.show();
            if (show.getWindow() != null) {
                show.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                show.getWindow().setSoftInputMode(4);
            }
            show.setContentView(view);
            WindowManager.LayoutParams attributes = show.getWindow().getAttributes();
            if (context.getResources().getConfiguration().orientation == 1) {
                attributes.width = com.martian.libsupport.l.h(context);
            } else {
                attributes.width = com.martian.libsupport.l.g(context);
            }
            attributes.height = -2;
            show.getWindow().setAttributes(attributes);
            return show;
        } catch (WindowManager.BadTokenException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void b0(final Activity context, String title, String[] msg, int index, final n selectedListener) {
        if (n0.B(context)) {
            View inflate = View.inflate(context, R.layout.dialog_single_choice, null);
            View findViewById = inflate.findViewById(R.id.dialog_shade_view);
            ThemeTextView themeTextView = (ThemeTextView) inflate.findViewById(R.id.dialog_title);
            RadioGroup radioGroup = (RadioGroup) inflate.findViewById(R.id.dialog_radio_group);
            if (com.martian.libmars.d.h.F().I0()) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            if (!com.martian.libsupport.k.p(title)) {
                themeTextView.setText(title);
            }
            radioGroup.removeAllViews();
            AlertDialog b2 = b(context, inflate, true);
            if (b2 != null && msg.length > 0) {
                for (int i2 = 0; i2 < msg.length; i2++) {
                    if (i2 == index) {
                        radioGroup.addView(a(context, i2, true, msg[i2], b2, selectedListener));
                    } else {
                        radioGroup.addView(a(context, i2, false, msg[i2], b2, selectedListener));
                    }
                }
            }
        }
    }

    public static PopupWindow c(final Activity activity, View parentView, View view, boolean cancelable, int gravity, boolean fullscreen, final boolean showMask) {
        if (!n0.B(activity)) {
            return null;
        }
        PopupWindow popupWindow = new PopupWindow(view, -1, -2);
        if (cancelable) {
            popupWindow.setFocusable(true);
            popupWindow.setOutsideTouchable(true);
        }
        if (fullscreen) {
            popupWindow.setClippingEnabled(false);
        }
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        if (showMask) {
            L(activity, true);
        }
        if (gravity == 80) {
            popupWindow.setAnimationStyle(R.style.updownpopwindow_anim_style);
        }
        if (parentView == null) {
            parentView = activity.getWindow().getDecorView();
        }
        popupWindow.showAtLocation(parentView, gravity, 0, 0);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.martian.libmars.utils.e
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                k0.j(showMask, activity);
            }
        });
        return popupWindow;
    }

    public static void c0(Activity activity, EditText view) {
        InputMethodManager inputMethodManager;
        if (!view.requestFocus() || (inputMethodManager = (InputMethodManager) activity.getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.toggleSoftInput(1, 2);
    }

    public static PopupWindow d(final Activity activity, View view, boolean cancelable) {
        return e(activity, view, cancelable, 17);
    }

    public static void d0(final Activity activity) {
        if (n0.C(activity)) {
            activity.runOnUiThread(new Runnable() { // from class: com.martian.libmars.utils.u
                @Override // java.lang.Runnable
                public final void run() {
                    k0.W(activity, "剩余空间不足", "内部存储空间不足，App可能无法正常使用，请尽快清理。", "知道了", new k0.j() { // from class: com.martian.libmars.utils.c0
                        @Override // com.martian.libmars.utils.k0.j
                        public final void a() {
                            k0.k();
                        }
                    }, new k0.l() { // from class: com.martian.libmars.utils.d
                        @Override // com.martian.libmars.utils.k0.l
                        public final void a() {
                            k0.l();
                        }
                    });
                }
            });
        }
    }

    public static PopupWindow e(final Activity activity, View view, boolean cancelable, int gravity) {
        return g(activity, view, cancelable, gravity, false, true);
    }

    public static PopupWindow f(final Activity activity, View view, boolean cancelable, int gravity, boolean fullscreen) {
        return g(activity, view, cancelable, gravity, fullscreen, true);
    }

    public static PopupWindow g(final Activity activity, View view, boolean cancelable, int gravity, boolean fullscreen, final boolean showMask) {
        return c(activity, null, view, cancelable, gravity, fullscreen, showMask);
    }

    public static void h(Activity activity, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        if (view != null) {
            view.clearFocus();
        }
    }

    static /* synthetic */ void i(final AlertDialog alertDialog, final n selectedListener, final int position, View v) {
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (selectedListener != null) {
            selectedListener.a(position);
        }
    }

    static /* synthetic */ void j(final boolean showMask, final Activity activity) {
        if (showMask) {
            L(activity, false);
        }
    }

    static /* synthetic */ void k() {
    }

    static /* synthetic */ void l() {
    }

    static /* synthetic */ void m(final h codeDialogClickListener, final EditText dialog_edit, final AlertDialog alertDialog, View view) {
        if (codeDialogClickListener != null) {
            codeDialogClickListener.a(dialog_edit.getText().toString(), alertDialog);
        }
    }

    static /* synthetic */ void n(final AlertDialog alertDialog, final j negativeClickListener, View v) {
        alertDialog.dismiss();
        if (negativeClickListener != null) {
            negativeClickListener.a();
        }
    }

    static /* synthetic */ void o(final AlertDialog alertDialog, final l postiveClickListener, View v) {
        alertDialog.dismiss();
        if (postiveClickListener != null) {
            postiveClickListener.a();
        }
    }

    static /* synthetic */ void q(final AlertDialog alertDialog, final g checkedClickListener, final CheckBox dialog_check, View v) {
        alertDialog.dismiss();
        if (checkedClickListener != null) {
            checkedClickListener.a(dialog_check.isChecked());
        }
    }

    static /* synthetic */ void s(final AlertDialog alertDialog, final j negativeClickListener, View v) {
        alertDialog.dismiss();
        if (negativeClickListener != null) {
            negativeClickListener.a();
        }
    }

    static /* synthetic */ void t(final AlertDialog alertDialog, final l postiveClickListener, View v) {
        alertDialog.dismiss();
        if (postiveClickListener != null) {
            postiveClickListener.a();
        }
    }

    static /* synthetic */ void v(final Activity activity, final EditText editText, final AlertDialog alertDialog, View v) {
        h(activity, editText);
        alertDialog.dismiss();
    }

    static /* synthetic */ void w(final EditText editText, final Activity activity, final i editTextEnterListener, final AlertDialog alertDialog, View v) {
        if (com.martian.libsupport.k.p(editText.getText().toString())) {
            w0.a(activity, "输入不能为空");
            return;
        }
        h(activity, editText);
        if (editTextEnterListener != null) {
            editTextEnterListener.a(editText.getText().toString());
        }
        alertDialog.dismiss();
    }

    static /* synthetic */ void x(final AlertDialog alertDialog, final j negativeClickListener, View v) {
        alertDialog.dismiss();
        if (negativeClickListener != null) {
            negativeClickListener.a();
        }
    }

    static /* synthetic */ void y(final AlertDialog alertDialog, final l postiveClickListener, View v) {
        alertDialog.dismiss();
        if (postiveClickListener != null) {
            postiveClickListener.a();
        }
    }

    static /* synthetic */ boolean z(final com.martian.libmars.e.k0 popupwindowOptionsBinding, final PopupWindow window, View v, MotionEvent event) {
        int top = popupwindowOptionsBinding.f10018d.getTop();
        int y = (int) event.getY();
        if (event.getAction() == 1 && y < top) {
            window.dismiss();
        }
        return true;
    }
}
