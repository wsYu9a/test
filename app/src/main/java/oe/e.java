package oe;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.martian.rpauth.R;
import oe.e;

/* loaded from: classes3.dex */
public class e {

    public interface a {
        void a();

        void b();
    }

    public static /* synthetic */ void e(a aVar, PopupWindow popupWindow, View view) {
        if (aVar != null) {
            aVar.a();
        }
        popupWindow.dismiss();
    }

    public static void g(Activity activity, View view, String str, String str2, String str3, a aVar) {
        if (activity == null || view == null || activity.isFinishing()) {
            return;
        }
        View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.martian_success_operation_dialog, (ViewGroup) null);
        PopupWindow popupWindow = new PopupWindow(inflate, -1, -1);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(1610612736));
        popupWindow.showAtLocation(view, 17, 0, 0);
        TextView textView = (TextView) inflate.findViewById(R.id.fr_success_known);
        TextView textView2 = (TextView) inflate.findViewById(R.id.fr_success_hint1);
        TextView textView3 = (TextView) inflate.findViewById(R.id.fr_success_hint2);
        textView2.setText(str);
        textView3.setText(str2);
        textView.setText(str3);
        inflate.findViewById(R.id.fr_close).setOnClickListener(new View.OnClickListener() { // from class: oe.b

            /* renamed from: b */
            public final /* synthetic */ PopupWindow f29167b;

            public /* synthetic */ b(PopupWindow popupWindow2) {
                popupWindow = popupWindow2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                popupWindow.dismiss();
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: oe.c

            /* renamed from: c */
            public final /* synthetic */ PopupWindow f29169c;

            public /* synthetic */ c(PopupWindow popupWindow2) {
                popupWindow = popupWindow2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                e.e(e.a.this, popupWindow, view2);
            }
        });
        popupWindow2.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: oe.d
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                e.f();
            }
        });
    }

    public static /* synthetic */ void f() {
    }
}
