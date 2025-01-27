package e.a.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import java.lang.reflect.Field;

/* loaded from: classes5.dex */
public final class e extends Toast {

    /* renamed from: a */
    @NonNull
    private final Toast f35242a;

    private e(Context context, @NonNull Toast toast) {
        super(context);
        this.f35242a = toast;
    }

    public static e b(Context context, CharSequence charSequence, int i2) {
        Toast makeText = Toast.makeText(context, charSequence, i2);
        d(makeText.getView(), new d(context, makeText));
        return new e(context, makeText);
    }

    private static void d(@NonNull View view, @NonNull Context context) {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                Field declaredField = View.class.getDeclaredField("mContext");
                declaredField.setAccessible(true);
                declaredField.set(view, context);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static Toast makeText(Context context, @StringRes int i2, int i3) throws Resources.NotFoundException {
        return b(context, context.getResources().getText(i2), i3);
    }

    @NonNull
    public Toast a() {
        return this.f35242a;
    }

    @NonNull
    public e c(@NonNull a aVar) {
        Context context = getView().getContext();
        if (context instanceof d) {
            ((d) context).c(aVar);
        }
        return this;
    }

    @Override // android.widget.Toast
    public int getDuration() {
        return this.f35242a.getDuration();
    }

    @Override // android.widget.Toast
    public int getGravity() {
        return this.f35242a.getGravity();
    }

    @Override // android.widget.Toast
    public float getHorizontalMargin() {
        return this.f35242a.getHorizontalMargin();
    }

    @Override // android.widget.Toast
    public float getVerticalMargin() {
        return this.f35242a.getVerticalMargin();
    }

    @Override // android.widget.Toast
    public View getView() {
        return this.f35242a.getView();
    }

    @Override // android.widget.Toast
    public int getXOffset() {
        return this.f35242a.getXOffset();
    }

    @Override // android.widget.Toast
    public int getYOffset() {
        return this.f35242a.getYOffset();
    }

    @Override // android.widget.Toast
    public void setDuration(int i2) {
        this.f35242a.setDuration(i2);
    }

    @Override // android.widget.Toast
    public void setGravity(int i2, int i3, int i4) {
        this.f35242a.setGravity(i2, i3, i4);
    }

    @Override // android.widget.Toast
    public void setMargin(float f2, float f3) {
        this.f35242a.setMargin(f2, f3);
    }

    @Override // android.widget.Toast
    public void setText(int i2) {
        this.f35242a.setText(i2);
    }

    @Override // android.widget.Toast
    public void setView(View view) {
        this.f35242a.setView(view);
        d(view, new d(view.getContext(), this));
    }

    @Override // android.widget.Toast
    public void show() {
        this.f35242a.show();
    }

    @Override // android.widget.Toast
    public void setText(CharSequence charSequence) {
        this.f35242a.setText(charSequence);
    }
}
