package l9;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.martian.libmars.R;

/* loaded from: classes3.dex */
public class t0 {
    public static void a(Context context, String str) {
        if (context != null) {
            ki.e.b(context.getApplicationContext(), str, 1).show();
        }
    }

    public static void b(Context context, String str) {
        if (context != null) {
            ki.e.b(context.getApplicationContext(), str, 0).show();
        }
    }

    public static void c(Activity activity, String str, String str2, Integer num) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        View inflate = activity.getLayoutInflater().inflate(R.layout.libmars_toast_message_bar, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.martian_mbMessage);
        TextView textView2 = (TextView) inflate.findViewById(R.id.martian_add_coins);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.martian_coins_type);
        textView.setText(str);
        textView2.setText(str2);
        if (num != null) {
            imageView.setImageResource(num.intValue());
        }
        Toast toast = new Toast(activity);
        toast.setGravity(17, 0, 0);
        toast.setDuration(0);
        toast.setView(inflate);
        toast.show();
    }
}
