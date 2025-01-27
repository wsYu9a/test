package com.ss.android.download.api.j;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.nt;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.zx;

/* loaded from: classes4.dex */
public class j implements nt {

    /* renamed from: com.ss.android.download.api.j.j$1 */
    static class AnonymousClass1 implements DialogInterface.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            zx.InterfaceC0493zx interfaceC0493zx = com.ss.android.download.api.model.zx.this.y;
            if (interfaceC0493zx != null) {
                interfaceC0493zx.zx(dialogInterface);
            }
        }
    }

    /* renamed from: com.ss.android.download.api.j.j$2 */
    static class AnonymousClass2 implements DialogInterface.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            zx.InterfaceC0493zx interfaceC0493zx = com.ss.android.download.api.model.zx.this.y;
            if (interfaceC0493zx != null) {
                interfaceC0493zx.j(dialogInterface);
            }
        }
    }

    /* renamed from: com.ss.android.download.api.j.j$3 */
    static class AnonymousClass3 implements DialogInterface.OnCancelListener {
        AnonymousClass3() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            zx.InterfaceC0493zx interfaceC0493zx = com.ss.android.download.api.model.zx.this.y;
            if (interfaceC0493zx != null) {
                interfaceC0493zx.i(dialogInterface);
            }
        }
    }

    @Override // com.ss.android.download.api.config.nt
    public void j(int i2, @Nullable Context context, DownloadModel downloadModel, String str, Drawable drawable, int i3) {
        Toast.makeText(context, str, 0).show();
    }

    @Override // com.ss.android.download.api.config.nt
    public Dialog zx(@NonNull com.ss.android.download.api.model.zx zxVar) {
        return j(zxVar);
    }

    private static Dialog j(com.ss.android.download.api.model.zx zxVar) {
        if (zxVar == null) {
            return null;
        }
        AlertDialog show = new AlertDialog.Builder(zxVar.f24084j).setTitle(zxVar.zx).setMessage(zxVar.f24083i).setPositiveButton(zxVar.f24082g, new DialogInterface.OnClickListener() { // from class: com.ss.android.download.api.j.j.2
            AnonymousClass2() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                zx.InterfaceC0493zx interfaceC0493zx = com.ss.android.download.api.model.zx.this.y;
                if (interfaceC0493zx != null) {
                    interfaceC0493zx.j(dialogInterface);
                }
            }
        }).setNegativeButton(zxVar.q, new DialogInterface.OnClickListener() { // from class: com.ss.android.download.api.j.j.1
            AnonymousClass1() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                zx.InterfaceC0493zx interfaceC0493zx = com.ss.android.download.api.model.zx.this.y;
                if (interfaceC0493zx != null) {
                    interfaceC0493zx.zx(dialogInterface);
                }
            }
        }).show();
        show.setCanceledOnTouchOutside(zxVar.gv);
        show.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ss.android.download.api.j.j.3
            AnonymousClass3() {
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                zx.InterfaceC0493zx interfaceC0493zx = com.ss.android.download.api.model.zx.this.y;
                if (interfaceC0493zx != null) {
                    interfaceC0493zx.i(dialogInterface);
                }
            }
        });
        Drawable drawable = zxVar.lg;
        if (drawable != null) {
            show.setIcon(drawable);
        }
        return show;
    }
}
