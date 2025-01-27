package com.opos.mobad.cmn.a;

import android.content.Context;
import android.view.View;
import com.opos.mobad.ad.privacy.ComplianceInfo;
import com.opos.mobad.ad.privacy.b;
import com.opos.mobad.model.data.AdItemData;
import java.util.List;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: com.opos.mobad.cmn.a.e$1 */
    static final class AnonymousClass1 implements View.OnClickListener {

        /* renamed from: b */
        final /* synthetic */ com.opos.mobad.ad.privacy.b f20286b;

        /* renamed from: c */
        final /* synthetic */ Context f20287c;

        /* renamed from: d */
        final /* synthetic */ ComplianceInfo f20288d;

        /* renamed from: com.opos.mobad.cmn.a.e$1$1 */
        class C04331 implements b.a {
            C04331() {
            }

            @Override // com.opos.mobad.ad.privacy.b.a
            public void a() {
                a aVar = a.this;
                if (aVar != null) {
                    aVar.a();
                }
            }
        }

        AnonymousClass1(com.opos.mobad.ad.privacy.b bVar, Context context, ComplianceInfo complianceInfo) {
            bVar = bVar;
            context = context;
            complianceInfo = complianceInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            if (aVar != null) {
                aVar.a(view);
            }
            bVar.a(context, 0, complianceInfo, new b.a() { // from class: com.opos.mobad.cmn.a.e.1.1
                C04331() {
                }

                @Override // com.opos.mobad.ad.privacy.b.a
                public void a() {
                    a aVar2 = a.this;
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                }
            });
        }
    }

    /* renamed from: com.opos.mobad.cmn.a.e$2 */
    static final class AnonymousClass2 implements View.OnClickListener {

        /* renamed from: b */
        final /* synthetic */ com.opos.mobad.ad.privacy.b f20291b;

        /* renamed from: c */
        final /* synthetic */ Context f20292c;

        /* renamed from: d */
        final /* synthetic */ ComplianceInfo f20293d;

        /* renamed from: com.opos.mobad.cmn.a.e$2$1 */
        class AnonymousClass1 implements b.a {
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.ad.privacy.b.a
            public void a() {
                a aVar = a.this;
                if (aVar != null) {
                    aVar.a();
                }
            }
        }

        AnonymousClass2(com.opos.mobad.ad.privacy.b bVar, Context context, ComplianceInfo complianceInfo) {
            bVar = bVar;
            context = context;
            complianceInfo = complianceInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            if (aVar != null) {
                aVar.a(view);
            }
            bVar.a(context, 1, complianceInfo, new b.a() { // from class: com.opos.mobad.cmn.a.e.2.1
                AnonymousClass1() {
                }

                @Override // com.opos.mobad.ad.privacy.b.a
                public void a() {
                    a aVar2 = a.this;
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                }
            });
        }
    }

    public interface a {
        void a();

        void a(View view);
    }

    public static ComplianceInfo a(AdItemData adItemData) {
        if (adItemData == null || adItemData.O() == null) {
            return null;
        }
        return new ComplianceInfo(adItemData.O().f21706b, adItemData.O().f21705a);
    }

    public static void a(Context context, List<View> list, a aVar, List<View> list2, a aVar2, com.opos.mobad.ad.privacy.b bVar, ComplianceInfo complianceInfo) {
        if (complianceInfo == null || bVar == null) {
            com.opos.cmn.an.f.a.b("PrivacyTool", "bind but return " + complianceInfo + "," + bVar);
            return;
        }
        AnonymousClass1 anonymousClass1 = new View.OnClickListener() { // from class: com.opos.mobad.cmn.a.e.1

            /* renamed from: b */
            final /* synthetic */ com.opos.mobad.ad.privacy.b f20286b;

            /* renamed from: c */
            final /* synthetic */ Context f20287c;

            /* renamed from: d */
            final /* synthetic */ ComplianceInfo f20288d;

            /* renamed from: com.opos.mobad.cmn.a.e$1$1 */
            class C04331 implements b.a {
                C04331() {
                }

                @Override // com.opos.mobad.ad.privacy.b.a
                public void a() {
                    a aVar2 = a.this;
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                }
            }

            AnonymousClass1(com.opos.mobad.ad.privacy.b bVar2, Context context2, ComplianceInfo complianceInfo2) {
                bVar = bVar2;
                context = context2;
                complianceInfo = complianceInfo2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a aVar3 = a.this;
                if (aVar3 != null) {
                    aVar3.a(view);
                }
                bVar.a(context, 0, complianceInfo, new b.a() { // from class: com.opos.mobad.cmn.a.e.1.1
                    C04331() {
                    }

                    @Override // com.opos.mobad.ad.privacy.b.a
                    public void a() {
                        a aVar22 = a.this;
                        if (aVar22 != null) {
                            aVar22.a();
                        }
                    }
                });
            }
        };
        for (View view : list) {
            com.opos.cmn.an.f.a.b("PrivacyTool", "set privacy listener " + view);
            if (view != null) {
                view.setOnClickListener(anonymousClass1);
            }
        }
        AnonymousClass2 anonymousClass2 = new View.OnClickListener() { // from class: com.opos.mobad.cmn.a.e.2

            /* renamed from: b */
            final /* synthetic */ com.opos.mobad.ad.privacy.b f20291b;

            /* renamed from: c */
            final /* synthetic */ Context f20292c;

            /* renamed from: d */
            final /* synthetic */ ComplianceInfo f20293d;

            /* renamed from: com.opos.mobad.cmn.a.e$2$1 */
            class AnonymousClass1 implements b.a {
                AnonymousClass1() {
                }

                @Override // com.opos.mobad.ad.privacy.b.a
                public void a() {
                    a aVar2 = a.this;
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                }
            }

            AnonymousClass2(com.opos.mobad.ad.privacy.b bVar2, Context context2, ComplianceInfo complianceInfo2) {
                bVar = bVar2;
                context = context2;
                complianceInfo = complianceInfo2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a aVar3 = a.this;
                if (aVar3 != null) {
                    aVar3.a(view2);
                }
                bVar.a(context, 1, complianceInfo, new b.a() { // from class: com.opos.mobad.cmn.a.e.2.1
                    AnonymousClass1() {
                    }

                    @Override // com.opos.mobad.ad.privacy.b.a
                    public void a() {
                        a aVar22 = a.this;
                        if (aVar22 != null) {
                            aVar22.a();
                        }
                    }
                });
            }
        };
        for (View view2 : list2) {
            com.opos.cmn.an.f.a.b("PrivacyTool", "set permission listener " + view2);
            if (view2 != null) {
                view2.setOnClickListener(anonymousClass2);
            }
        }
    }
}
