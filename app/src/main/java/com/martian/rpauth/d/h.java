package com.martian.rpauth.d;

import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.martian.libmars.activity.j1;
import com.martian.rpauth.R;
import com.martian.rpauth.d.h;

/* loaded from: classes4.dex */
public class h {

    public interface a {
        void a();
    }

    public interface b {
        void a();
    }

    public interface c {
        void a();

        void b();
    }

    public interface d {
        void a();

        void b();
    }

    static /* synthetic */ void b(final c successDialogListener, final PopupWindow shareWindow, View v) {
        if (successDialogListener != null) {
            successDialogListener.a();
        }
        shareWindow.dismiss();
    }

    static /* synthetic */ void c() {
    }

    static /* synthetic */ void d(final d optionDialogListener, final PopupWindow shareWindow, View v) {
        optionDialogListener.a();
        shareWindow.dismiss();
    }

    static /* synthetic */ void e(final d optionDialogListener, final PopupWindow shareWindow, View v) {
        optionDialogListener.b();
        shareWindow.dismiss();
    }

    static /* synthetic */ void f() {
    }

    public static void g(final j1 activity, View parentview, String hint1, String hint2, String op1, final c successDialogListener) {
        if (activity == null || parentview == null || activity.isFinishing()) {
            return;
        }
        View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.martian_success_operation_dialog, (ViewGroup) null);
        final PopupWindow popupWindow = new PopupWindow(inflate, -1, -1);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(1610612736));
        popupWindow.showAtLocation(parentview, 17, 0, 0);
        TextView textView = (TextView) inflate.findViewById(R.id.fr_success_known);
        TextView textView2 = (TextView) inflate.findViewById(R.id.fr_success_hint1);
        TextView textView3 = (TextView) inflate.findViewById(R.id.fr_success_hint2);
        textView2.setText(hint1);
        textView3.setText(hint2);
        textView.setText(op1);
        inflate.findViewById(R.id.fr_close).setOnClickListener(new View.OnClickListener() { // from class: com.martian.rpauth.d.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                popupWindow.dismiss();
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.martian.rpauth.d.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.b(h.c.this, popupWindow, view);
            }
        });
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.martian.rpauth.d.c
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                h.c();
            }
        });
    }

    public static void h(final j1 activity, View parentview, String hintTitle, String hint1, String op1, String op2, final d optionDialogListener) {
        if (activity == null || parentview == null || activity.isFinishing()) {
            return;
        }
        View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.martian_two_options_simple_dialog, (ViewGroup) null);
        final PopupWindow popupWindow = new PopupWindow(inflate, -1, -1);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(1610612736));
        popupWindow.showAtLocation(parentview, 17, 0, 0);
        TextView textView = (TextView) inflate.findViewById(R.id.fr_title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.fr_option_hint1);
        TextView textView3 = (TextView) inflate.findViewById(R.id.fr_option_button1);
        TextView textView4 = (TextView) inflate.findViewById(R.id.fr_option_button2);
        if (!TextUtils.isEmpty(hintTitle)) {
            textView.setText(hintTitle);
        }
        if (!TextUtils.isEmpty(hint1)) {
            textView2.setText(hint1);
        }
        textView3.setText(op1);
        textView4.setText(op2);
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.martian.rpauth.d.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.d(h.d.this, popupWindow, view);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.martian.rpauth.d.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.e(h.d.this, popupWindow, view);
            }
        });
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.martian.rpauth.d.d
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                h.f();
            }
        });
    }
}
