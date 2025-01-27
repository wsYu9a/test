package com.ss.android.downloadlib.c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.download.api.model.b;
import com.ss.android.socialbase.appdownloader.c.k;
import com.ss.android.socialbase.appdownloader.c.l;

/* loaded from: classes4.dex */
public class g extends com.ss.android.socialbase.appdownloader.c.a {

    /* renamed from: a */
    private static String f21568a = "g";

    /* renamed from: com.ss.android.downloadlib.c.g$1 */
    public class AnonymousClass1 implements l {

        /* renamed from: a */
        final /* synthetic */ Context f21569a;

        /* renamed from: c */
        private b.a f21571c;

        /* renamed from: d */
        private DialogInterface.OnClickListener f21572d;

        /* renamed from: e */
        private DialogInterface.OnClickListener f21573e;

        /* renamed from: f */
        private DialogInterface.OnCancelListener f21574f;

        /* renamed from: com.ss.android.downloadlib.c.g$1$1 */
        public class C06401 implements b.InterfaceC0631b {
            public C06401() {
            }

            @Override // com.ss.android.download.api.model.b.InterfaceC0631b
            public void a(DialogInterface dialogInterface) {
                if (AnonymousClass1.this.f21572d != null) {
                    AnonymousClass1.this.f21572d.onClick(dialogInterface, -1);
                }
            }

            @Override // com.ss.android.download.api.model.b.InterfaceC0631b
            public void b(DialogInterface dialogInterface) {
                if (AnonymousClass1.this.f21573e != null) {
                    AnonymousClass1.this.f21573e.onClick(dialogInterface, -2);
                }
            }

            @Override // com.ss.android.download.api.model.b.InterfaceC0631b
            public void c(DialogInterface dialogInterface) {
                if (AnonymousClass1.this.f21574f == null || dialogInterface == null) {
                    return;
                }
                AnonymousClass1.this.f21574f.onCancel(dialogInterface);
            }
        }

        public AnonymousClass1(Context context) {
            this.f21569a = context;
            this.f21571c = new b.a(context);
        }

        @Override // com.ss.android.socialbase.appdownloader.c.l
        public l a(int i10) {
            this.f21571c.a(this.f21569a.getResources().getString(i10));
            return this;
        }

        @Override // com.ss.android.socialbase.appdownloader.c.l
        public l b(int i10, DialogInterface.OnClickListener onClickListener) {
            this.f21571c.d(this.f21569a.getResources().getString(i10));
            this.f21573e = onClickListener;
            return this;
        }

        @Override // com.ss.android.socialbase.appdownloader.c.l
        public l a(String str) {
            this.f21571c.b(str);
            return this;
        }

        @Override // com.ss.android.socialbase.appdownloader.c.l
        public l a(int i10, DialogInterface.OnClickListener onClickListener) {
            this.f21571c.c(this.f21569a.getResources().getString(i10));
            this.f21572d = onClickListener;
            return this;
        }

        @Override // com.ss.android.socialbase.appdownloader.c.l
        public l a(DialogInterface.OnCancelListener onCancelListener) {
            this.f21574f = onCancelListener;
            return this;
        }

        @Override // com.ss.android.socialbase.appdownloader.c.l
        public l a(boolean z10) {
            this.f21571c.a(z10);
            return this;
        }

        @Override // com.ss.android.socialbase.appdownloader.c.l
        public k a() {
            this.f21571c.a(new b.InterfaceC0631b() { // from class: com.ss.android.downloadlib.c.g.1.1
                public C06401() {
                }

                @Override // com.ss.android.download.api.model.b.InterfaceC0631b
                public void a(DialogInterface dialogInterface) {
                    if (AnonymousClass1.this.f21572d != null) {
                        AnonymousClass1.this.f21572d.onClick(dialogInterface, -1);
                    }
                }

                @Override // com.ss.android.download.api.model.b.InterfaceC0631b
                public void b(DialogInterface dialogInterface) {
                    if (AnonymousClass1.this.f21573e != null) {
                        AnonymousClass1.this.f21573e.onClick(dialogInterface, -2);
                    }
                }

                @Override // com.ss.android.download.api.model.b.InterfaceC0631b
                public void c(DialogInterface dialogInterface) {
                    if (AnonymousClass1.this.f21574f == null || dialogInterface == null) {
                        return;
                    }
                    AnonymousClass1.this.f21574f.onCancel(dialogInterface);
                }
            });
            com.ss.android.downloadlib.g.k.a(g.f21568a, "getThemedAlertDlgBuilder", null);
            this.f21571c.a(3);
            return new a(com.ss.android.downloadlib.addownload.k.d().b(this.f21571c.a()));
        }
    }

    public static class a implements k {

        /* renamed from: a */
        private Dialog f21576a;

        public a(Dialog dialog) {
            if (dialog != null) {
                this.f21576a = dialog;
                a();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.k
        public void a() {
            Dialog dialog = this.f21576a;
            if (dialog != null) {
                dialog.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.c.k
        public boolean b() {
            Dialog dialog = this.f21576a;
            if (dialog != null) {
                return dialog.isShowing();
            }
            return false;
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.c.a, com.ss.android.socialbase.appdownloader.c.c
    public l a(Context context) {
        return new l(context) { // from class: com.ss.android.downloadlib.c.g.1

            /* renamed from: a */
            final /* synthetic */ Context f21569a;

            /* renamed from: c */
            private b.a f21571c;

            /* renamed from: d */
            private DialogInterface.OnClickListener f21572d;

            /* renamed from: e */
            private DialogInterface.OnClickListener f21573e;

            /* renamed from: f */
            private DialogInterface.OnCancelListener f21574f;

            /* renamed from: com.ss.android.downloadlib.c.g$1$1 */
            public class C06401 implements b.InterfaceC0631b {
                public C06401() {
                }

                @Override // com.ss.android.download.api.model.b.InterfaceC0631b
                public void a(DialogInterface dialogInterface) {
                    if (AnonymousClass1.this.f21572d != null) {
                        AnonymousClass1.this.f21572d.onClick(dialogInterface, -1);
                    }
                }

                @Override // com.ss.android.download.api.model.b.InterfaceC0631b
                public void b(DialogInterface dialogInterface) {
                    if (AnonymousClass1.this.f21573e != null) {
                        AnonymousClass1.this.f21573e.onClick(dialogInterface, -2);
                    }
                }

                @Override // com.ss.android.download.api.model.b.InterfaceC0631b
                public void c(DialogInterface dialogInterface) {
                    if (AnonymousClass1.this.f21574f == null || dialogInterface == null) {
                        return;
                    }
                    AnonymousClass1.this.f21574f.onCancel(dialogInterface);
                }
            }

            public AnonymousClass1(Context context2) {
                this.f21569a = context2;
                this.f21571c = new b.a(context2);
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(int i10) {
                this.f21571c.a(this.f21569a.getResources().getString(i10));
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l b(int i10, DialogInterface.OnClickListener onClickListener) {
                this.f21571c.d(this.f21569a.getResources().getString(i10));
                this.f21573e = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(String str) {
                this.f21571c.b(str);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(int i10, DialogInterface.OnClickListener onClickListener) {
                this.f21571c.c(this.f21569a.getResources().getString(i10));
                this.f21572d = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(DialogInterface.OnCancelListener onCancelListener) {
                this.f21574f = onCancelListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public l a(boolean z10) {
                this.f21571c.a(z10);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.l
            public k a() {
                this.f21571c.a(new b.InterfaceC0631b() { // from class: com.ss.android.downloadlib.c.g.1.1
                    public C06401() {
                    }

                    @Override // com.ss.android.download.api.model.b.InterfaceC0631b
                    public void a(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.f21572d != null) {
                            AnonymousClass1.this.f21572d.onClick(dialogInterface, -1);
                        }
                    }

                    @Override // com.ss.android.download.api.model.b.InterfaceC0631b
                    public void b(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.f21573e != null) {
                            AnonymousClass1.this.f21573e.onClick(dialogInterface, -2);
                        }
                    }

                    @Override // com.ss.android.download.api.model.b.InterfaceC0631b
                    public void c(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.f21574f == null || dialogInterface == null) {
                            return;
                        }
                        AnonymousClass1.this.f21574f.onCancel(dialogInterface);
                    }
                });
                com.ss.android.downloadlib.g.k.a(g.f21568a, "getThemedAlertDlgBuilder", null);
                this.f21571c.a(3);
                return new a(com.ss.android.downloadlib.addownload.k.d().b(this.f21571c.a()));
            }
        };
    }
}
