package com.kwad.components.core.page.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.n.m;

/* loaded from: classes3.dex */
public final class a extends Dialog {
    private final InterfaceC0442a SD;
    private final String SE;

    /* renamed from: com.kwad.components.core.page.widget.a$1 */
    public class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a.this.SD.c(a.this);
        }
    }

    /* renamed from: com.kwad.components.core.page.widget.a$2 */
    public class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
        }
    }

    /* renamed from: com.kwad.components.core.page.widget.a$3 */
    public class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a.this.SD.a(a.this);
        }
    }

    /* renamed from: com.kwad.components.core.page.widget.a$4 */
    public class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a.this.SD.b(a.this);
        }
    }

    /* renamed from: com.kwad.components.core.page.widget.a$a */
    public interface InterfaceC0442a {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    public a(@NonNull Context context, @NonNull InterfaceC0442a interfaceC0442a) {
        this(context, null, interfaceC0442a);
    }

    private View qS() {
        View inflate = m.inflate(getContext(), R.layout.ksad_web_exit_intercept_content_layout, null);
        inflate.findViewById(R.id.ksad_exit_intercept_dialog_layout).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.widget.a.1
            public AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a.this.SD.c(a.this);
            }
        });
        inflate.findViewById(R.id.ksad_exit_intercept_content_layout).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.widget.a.2
            public AnonymousClass2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
            }
        });
        inflate.findViewById(R.id.ksad_web_exit_intercept_positive_btn).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.widget.a.3
            public AnonymousClass3() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a.this.SD.a(a.this);
            }
        });
        inflate.findViewById(R.id.ksad_web_exit_intercept_negative_btn).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.widget.a.4
            public AnonymousClass4() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a.this.SD.b(a.this);
            }
        });
        TextView textView = (TextView) inflate.findViewById(R.id.ksad_exit_intercept_content);
        if (!TextUtils.isEmpty(this.SE)) {
            textView.setText(this.SE);
        }
        return inflate;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
        } catch (Exception unused) {
        }
        setContentView(qS());
        setCanceledOnTouchOutside(false);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setLayout(-1, -1);
        setCancelable(false);
    }

    public a(@NonNull Context context, String str, @NonNull InterfaceC0442a interfaceC0442a) {
        super(context);
        if (context instanceof Activity) {
            setOwnerActivity((Activity) context);
        }
        this.SD = interfaceC0442a;
        this.SE = str;
    }
}
