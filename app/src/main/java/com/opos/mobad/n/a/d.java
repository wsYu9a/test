package com.opos.mobad.n.a;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.opos.mobad.n.d;
import java.util.Locale;

/* loaded from: classes4.dex */
public class d extends TextView implements com.opos.mobad.n.d {

    /* renamed from: com.opos.mobad.n.a.d$1 */
    class AnonymousClass1 extends com.opos.mobad.n.c.g {

        /* renamed from: a */
        final /* synthetic */ d.a f21771a;

        AnonymousClass1(d.a aVar) {
            aVar = aVar;
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            aVar.a(view, iArr);
        }
    }

    public d(@NonNull Context context) {
        this(context, null);
    }

    public d(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public d(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setGravity(17);
        setTextColor(-1);
        setTextSize(1, 14.0f);
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        int i3 = a2 * 2;
        setPadding(i3, a2, i3, a2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(60.0f);
        gradientDrawable.setColor(1711276032);
        com.opos.mobad.c.b.d.a(this, gradientDrawable);
    }

    @Override // com.opos.mobad.n.d
    public View a() {
        return this;
    }

    @Override // com.opos.mobad.n.d
    public void a(int i2) {
        setText(String.format(Locale.getDefault(), "跳过 %1$d", Integer.valueOf(i2)));
    }

    @Override // com.opos.mobad.n.d
    public void a(d.a aVar) {
        AnonymousClass1 anonymousClass1 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.a.d.1

            /* renamed from: a */
            final /* synthetic */ d.a f21771a;

            AnonymousClass1(d.a aVar2) {
                aVar = aVar2;
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                aVar.a(view, iArr);
            }
        };
        setOnClickListener(anonymousClass1);
        setOnTouchListener(anonymousClass1);
    }
}
