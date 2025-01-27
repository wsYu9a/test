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
import com.kwad.sdk.j.k;

/* loaded from: classes2.dex */
public final class a extends Dialog {
    private final InterfaceC0185a Ns;
    private final String Nt;

    /* renamed from: com.kwad.components.core.page.widget.a$1 */
    final class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a.this.Ns.c(a.this);
        }
    }

    /* renamed from: com.kwad.components.core.page.widget.a$2 */
    final class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
        }
    }

    /* renamed from: com.kwad.components.core.page.widget.a$3 */
    final class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a.this.Ns.a(a.this);
        }
    }

    /* renamed from: com.kwad.components.core.page.widget.a$4 */
    final class AnonymousClass4 implements View.OnClickListener {
        AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a.this.Ns.b(a.this);
        }
    }

    /* renamed from: com.kwad.components.core.page.widget.a$a */
    public interface InterfaceC0185a {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    public a(@NonNull Context context, @NonNull InterfaceC0185a interfaceC0185a) {
        this(context, null, interfaceC0185a);
    }

    public a(@NonNull Context context, String str, @NonNull InterfaceC0185a interfaceC0185a) {
        super(context);
        if (context instanceof Activity) {
            setOwnerActivity((Activity) context);
        }
        this.Ns = interfaceC0185a;
        this.Nt = str;
    }

    private View oU() {
        View inflate = k.inflate(getContext(), R.layout.ksad_web_exit_intercept_content_layout, null);
        inflate.findViewById(R.id.ksad_exit_intercept_dialog_layout).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.widget.a.1
            AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a.this.Ns.c(a.this);
            }
        });
        inflate.findViewById(R.id.ksad_exit_intercept_content_layout).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.widget.a.2
            AnonymousClass2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
            }
        });
        inflate.findViewById(R.id.ksad_web_exit_intercept_positive_btn).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.widget.a.3
            AnonymousClass3() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a.this.Ns.a(a.this);
            }
        });
        inflate.findViewById(R.id.ksad_web_exit_intercept_negative_btn).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.widget.a.4
            AnonymousClass4() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a.this.Ns.b(a.this);
            }
        });
        TextView textView = (TextView) inflate.findViewById(R.id.ksad_exit_intercept_content);
        if (!TextUtils.isEmpty(this.Nt)) {
            textView.setText(this.Nt);
        }
        return inflate;
    }

    @Override // android.app.Dialog
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(oU());
        setCanceledOnTouchOutside(false);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setLayout(-1, -1);
        setCancelable(false);
    }
}
