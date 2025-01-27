package com.ss.android.downloadlib.i;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.download.api.model.zx;
import com.ss.android.downloadlib.addownload.pa;
import com.ss.android.socialbase.appdownloader.i.nt;
import com.ss.android.socialbase.appdownloader.i.t;

/* loaded from: classes4.dex */
public class lg extends com.ss.android.socialbase.appdownloader.i.j {

    /* renamed from: j */
    private static String f24274j = "lg";

    /* renamed from: com.ss.android.downloadlib.i.lg$1 */
    class AnonymousClass1 implements nt {

        /* renamed from: g */
        private DialogInterface.OnClickListener f24275g;
        private DialogInterface.OnCancelListener gv;

        /* renamed from: i */
        private zx.j f24276i;

        /* renamed from: j */
        final /* synthetic */ Context f24277j;
        private DialogInterface.OnClickListener q;

        /* renamed from: com.ss.android.downloadlib.i.lg$1$1 */
        class C04961 implements zx.InterfaceC0493zx {
            C04961() {
            }

            @Override // com.ss.android.download.api.model.zx.InterfaceC0493zx
            public void i(DialogInterface dialogInterface) {
                if (AnonymousClass1.this.gv == null || dialogInterface == null) {
                    return;
                }
                AnonymousClass1.this.gv.onCancel(dialogInterface);
            }

            @Override // com.ss.android.download.api.model.zx.InterfaceC0493zx
            public void j(DialogInterface dialogInterface) {
                if (AnonymousClass1.this.f24275g != null) {
                    AnonymousClass1.this.f24275g.onClick(dialogInterface, -1);
                }
            }

            @Override // com.ss.android.download.api.model.zx.InterfaceC0493zx
            public void zx(DialogInterface dialogInterface) {
                if (AnonymousClass1.this.q != null) {
                    AnonymousClass1.this.q.onClick(dialogInterface, -2);
                }
            }
        }

        AnonymousClass1(Context context) {
            this.f24277j = context;
            this.f24276i = new zx.j(context);
        }

        @Override // com.ss.android.socialbase.appdownloader.i.nt
        public nt j(int i2) {
            this.f24276i.j(this.f24277j.getResources().getString(i2));
            return this;
        }

        @Override // com.ss.android.socialbase.appdownloader.i.nt
        public nt zx(int i2, DialogInterface.OnClickListener onClickListener) {
            this.f24276i.g(this.f24277j.getResources().getString(i2));
            this.q = onClickListener;
            return this;
        }

        @Override // com.ss.android.socialbase.appdownloader.i.nt
        public nt j(String str) {
            this.f24276i.zx(str);
            return this;
        }

        @Override // com.ss.android.socialbase.appdownloader.i.nt
        public nt j(int i2, DialogInterface.OnClickListener onClickListener) {
            this.f24276i.i(this.f24277j.getResources().getString(i2));
            this.f24275g = onClickListener;
            return this;
        }

        @Override // com.ss.android.socialbase.appdownloader.i.nt
        public nt j(DialogInterface.OnCancelListener onCancelListener) {
            this.gv = onCancelListener;
            return this;
        }

        @Override // com.ss.android.socialbase.appdownloader.i.nt
        public nt j(boolean z) {
            this.f24276i.j(z);
            return this;
        }

        @Override // com.ss.android.socialbase.appdownloader.i.nt
        public t j() {
            this.f24276i.j(new zx.InterfaceC0493zx() { // from class: com.ss.android.downloadlib.i.lg.1.1
                C04961() {
                }

                @Override // com.ss.android.download.api.model.zx.InterfaceC0493zx
                public void i(DialogInterface dialogInterface) {
                    if (AnonymousClass1.this.gv == null || dialogInterface == null) {
                        return;
                    }
                    AnonymousClass1.this.gv.onCancel(dialogInterface);
                }

                @Override // com.ss.android.download.api.model.zx.InterfaceC0493zx
                public void j(DialogInterface dialogInterface) {
                    if (AnonymousClass1.this.f24275g != null) {
                        AnonymousClass1.this.f24275g.onClick(dialogInterface, -1);
                    }
                }

                @Override // com.ss.android.download.api.model.zx.InterfaceC0493zx
                public void zx(DialogInterface dialogInterface) {
                    if (AnonymousClass1.this.q != null) {
                        AnonymousClass1.this.q.onClick(dialogInterface, -2);
                    }
                }
            });
            com.ss.android.downloadlib.lg.t.j(lg.f24274j, "getThemedAlertDlgBuilder", null);
            this.f24276i.j(3);
            return new j(pa.i().zx(this.f24276i.j()));
        }
    }

    private static class j implements t {

        /* renamed from: j */
        private Dialog f24279j;

        public j(Dialog dialog) {
            if (dialog != null) {
                this.f24279j = dialog;
                j();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.i.t
        public void j() {
            Dialog dialog = this.f24279j;
            if (dialog != null) {
                dialog.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.i.t
        public boolean zx() {
            Dialog dialog = this.f24279j;
            if (dialog != null) {
                return dialog.isShowing();
            }
            return false;
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.i.j, com.ss.android.socialbase.appdownloader.i.i
    public nt j(Context context) {
        return new nt(context) { // from class: com.ss.android.downloadlib.i.lg.1

            /* renamed from: g */
            private DialogInterface.OnClickListener f24275g;
            private DialogInterface.OnCancelListener gv;

            /* renamed from: i */
            private zx.j f24276i;

            /* renamed from: j */
            final /* synthetic */ Context f24277j;
            private DialogInterface.OnClickListener q;

            /* renamed from: com.ss.android.downloadlib.i.lg$1$1 */
            class C04961 implements zx.InterfaceC0493zx {
                C04961() {
                }

                @Override // com.ss.android.download.api.model.zx.InterfaceC0493zx
                public void i(DialogInterface dialogInterface) {
                    if (AnonymousClass1.this.gv == null || dialogInterface == null) {
                        return;
                    }
                    AnonymousClass1.this.gv.onCancel(dialogInterface);
                }

                @Override // com.ss.android.download.api.model.zx.InterfaceC0493zx
                public void j(DialogInterface dialogInterface) {
                    if (AnonymousClass1.this.f24275g != null) {
                        AnonymousClass1.this.f24275g.onClick(dialogInterface, -1);
                    }
                }

                @Override // com.ss.android.download.api.model.zx.InterfaceC0493zx
                public void zx(DialogInterface dialogInterface) {
                    if (AnonymousClass1.this.q != null) {
                        AnonymousClass1.this.q.onClick(dialogInterface, -2);
                    }
                }
            }

            AnonymousClass1(Context context2) {
                this.f24277j = context2;
                this.f24276i = new zx.j(context2);
            }

            @Override // com.ss.android.socialbase.appdownloader.i.nt
            public nt j(int i2) {
                this.f24276i.j(this.f24277j.getResources().getString(i2));
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.i.nt
            public nt zx(int i2, DialogInterface.OnClickListener onClickListener) {
                this.f24276i.g(this.f24277j.getResources().getString(i2));
                this.q = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.i.nt
            public nt j(String str) {
                this.f24276i.zx(str);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.i.nt
            public nt j(int i2, DialogInterface.OnClickListener onClickListener) {
                this.f24276i.i(this.f24277j.getResources().getString(i2));
                this.f24275g = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.i.nt
            public nt j(DialogInterface.OnCancelListener onCancelListener) {
                this.gv = onCancelListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.i.nt
            public nt j(boolean z) {
                this.f24276i.j(z);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.i.nt
            public t j() {
                this.f24276i.j(new zx.InterfaceC0493zx() { // from class: com.ss.android.downloadlib.i.lg.1.1
                    C04961() {
                    }

                    @Override // com.ss.android.download.api.model.zx.InterfaceC0493zx
                    public void i(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.gv == null || dialogInterface == null) {
                            return;
                        }
                        AnonymousClass1.this.gv.onCancel(dialogInterface);
                    }

                    @Override // com.ss.android.download.api.model.zx.InterfaceC0493zx
                    public void j(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.f24275g != null) {
                            AnonymousClass1.this.f24275g.onClick(dialogInterface, -1);
                        }
                    }

                    @Override // com.ss.android.download.api.model.zx.InterfaceC0493zx
                    public void zx(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.q != null) {
                            AnonymousClass1.this.q.onClick(dialogInterface, -2);
                        }
                    }
                });
                com.ss.android.downloadlib.lg.t.j(lg.f24274j, "getThemedAlertDlgBuilder", null);
                this.f24276i.j(3);
                return new j(pa.i().zx(this.f24276i.j()));
            }
        };
    }

    @Override // com.ss.android.socialbase.appdownloader.i.j, com.ss.android.socialbase.appdownloader.i.i
    public boolean j() {
        return true;
    }
}
