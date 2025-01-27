package ki;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import java.lang.reflect.Field;

/* loaded from: classes4.dex */
public final class e extends Toast {

    /* renamed from: a */
    @NonNull
    public final Toast f27845a;

    public e(Context context, @NonNull Toast toast) {
        super(context);
        this.f27845a = toast;
    }

    public static e b(Context context, CharSequence charSequence, int i10) {
        Toast makeText = Toast.makeText(context, charSequence, i10);
        d(makeText.getView(), new d(context, makeText));
        return new e(context, makeText);
    }

    public static void d(@NonNull View view, @NonNull Context context) {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                Field declaredField = View.class.getDeclaredField("mContext");
                declaredField.setAccessible(true);
                declaredField.set(view, context);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public static Toast makeText(Context context, @StringRes int i10, int i11) throws Resources.NotFoundException {
        return b(context, context.getResources().getText(i10), i11);
    }

    @NonNull
    public Toast a() {
        return this.f27845a;
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
        return this.f27845a.getDuration();
    }

    @Override // android.widget.Toast
    public int getGravity() {
        return this.f27845a.getGravity();
    }

    @Override // android.widget.Toast
    public float getHorizontalMargin() {
        return this.f27845a.getHorizontalMargin();
    }

    @Override // android.widget.Toast
    public float getVerticalMargin() {
        return this.f27845a.getVerticalMargin();
    }

    @Override // android.widget.Toast
    public View getView() {
        return this.f27845a.getView();
    }

    @Override // android.widget.Toast
    public int getXOffset() {
        return this.f27845a.getXOffset();
    }

    @Override // android.widget.Toast
    public int getYOffset() {
        return this.f27845a.getYOffset();
    }

    @Override // android.widget.Toast
    public void setDuration(int i10) {
        this.f27845a.setDuration(i10);
    }

    @Override // android.widget.Toast
    public void setGravity(int i10, int i11, int i12) {
        this.f27845a.setGravity(i10, i11, i12);
    }

    @Override // android.widget.Toast
    public void setMargin(float f10, float f11) {
        this.f27845a.setMargin(f10, f11);
    }

    @Override // android.widget.Toast
    public void setText(int i10) {
        this.f27845a.setText(i10);
    }

    @Override // android.widget.Toast
    public void setView(View view) {
        this.f27845a.setView(view);
        d(view, new d(view.getContext(), this));
    }

    @Override // android.widget.Toast
    public void show() {
        this.f27845a.show();
    }

    @Override // android.widget.Toast
    public void setText(CharSequence charSequence) {
        this.f27845a.setText(charSequence);
    }
}
