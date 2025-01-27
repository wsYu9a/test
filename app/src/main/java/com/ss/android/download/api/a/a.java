package com.ss.android.download.api.a;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.l;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.b;

/* loaded from: classes4.dex */
public class a implements l {

    /* renamed from: com.ss.android.download.api.a.a$1 */
    public static class AnonymousClass1 implements DialogInterface.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            b.InterfaceC0631b interfaceC0631b = com.ss.android.download.api.model.b.this.f20996h;
            if (interfaceC0631b != null) {
                interfaceC0631b.b(dialogInterface);
            }
        }
    }

    /* renamed from: com.ss.android.download.api.a.a$2 */
    public static class AnonymousClass2 implements DialogInterface.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            b.InterfaceC0631b interfaceC0631b = com.ss.android.download.api.model.b.this.f20996h;
            if (interfaceC0631b != null) {
                interfaceC0631b.a(dialogInterface);
            }
        }
    }

    /* renamed from: com.ss.android.download.api.a.a$3 */
    public static class AnonymousClass3 implements DialogInterface.OnCancelListener {
        public AnonymousClass3() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            b.InterfaceC0631b interfaceC0631b = com.ss.android.download.api.model.b.this.f20996h;
            if (interfaceC0631b != null) {
                interfaceC0631b.c(dialogInterface);
            }
        }
    }

    @Override // com.ss.android.download.api.config.l
    public void a(int i10, @Nullable Context context, DownloadModel downloadModel, String str, Drawable drawable, int i11) {
        Toast.makeText(context, str, 0).show();
    }

    @Override // com.ss.android.download.api.config.l
    public Dialog b(@NonNull com.ss.android.download.api.model.b bVar) {
        return a(bVar);
    }

    private static Dialog a(com.ss.android.download.api.model.b bVar) {
        if (bVar == null) {
            return null;
        }
        AlertDialog show = new AlertDialog.Builder(bVar.f20989a).setTitle(bVar.f20990b).setMessage(bVar.f20991c).setPositiveButton(bVar.f20992d, new DialogInterface.OnClickListener() { // from class: com.ss.android.download.api.a.a.2
            public AnonymousClass2() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                b.InterfaceC0631b interfaceC0631b = com.ss.android.download.api.model.b.this.f20996h;
                if (interfaceC0631b != null) {
                    interfaceC0631b.a(dialogInterface);
                }
            }
        }).setNegativeButton(bVar.f20993e, new DialogInterface.OnClickListener() { // from class: com.ss.android.download.api.a.a.1
            public AnonymousClass1() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                b.InterfaceC0631b interfaceC0631b = com.ss.android.download.api.model.b.this.f20996h;
                if (interfaceC0631b != null) {
                    interfaceC0631b.b(dialogInterface);
                }
            }
        }).show();
        show.setCanceledOnTouchOutside(bVar.f20994f);
        show.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ss.android.download.api.a.a.3
            public AnonymousClass3() {
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                b.InterfaceC0631b interfaceC0631b = com.ss.android.download.api.model.b.this.f20996h;
                if (interfaceC0631b != null) {
                    interfaceC0631b.c(dialogInterface);
                }
            }
        });
        Drawable drawable = bVar.f20995g;
        if (drawable != null) {
            show.setIcon(drawable);
        }
        return show;
    }
}
