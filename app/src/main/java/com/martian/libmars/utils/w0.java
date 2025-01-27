package com.martian.libmars.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.martian.libmars.R;
import com.martian.libmars.activity.j1;

/* loaded from: classes2.dex */
public class w0 {
    public static void a(Context context, String message) {
        if (context != null) {
            e.a.a.a.e.b(context.getApplicationContext(), message, 0).show();
        }
    }

    public static void b(j1 activity, String msg, String bonus, Integer resId) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        View inflate = activity.getLayoutInflater().inflate(R.layout.libmars_toast_message_bar, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.martian_mbMessage);
        TextView textView2 = (TextView) inflate.findViewById(R.id.martian_add_coins);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.martian_coins_type);
        textView.setText(msg);
        textView2.setText(bonus);
        if (resId != null) {
            imageView.setImageResource(resId.intValue());
        }
        Toast toast = new Toast(activity);
        toast.setGravity(17, 0, 0);
        toast.setDuration(0);
        toast.setView(inflate);
        toast.show();
    }
}
