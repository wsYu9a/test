package cn.vlion.ad.inland.oaid;

import android.content.Context;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.oaid.VlionOaidManager;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;

/* loaded from: classes.dex */
public final class a implements IIdentifierListener {

    /* renamed from: a */
    public InterfaceC0045a f4015a;

    /* renamed from: cn.vlion.ad.inland.oaid.a$a */
    public interface InterfaceC0045a {
    }

    public a(VlionOaidManager.a aVar) {
        this.f4015a = aVar;
    }

    public final void OnSupport(boolean z10, IdSupplier idSupplier) {
        if (idSupplier == null) {
            return;
        }
        String oaid = idSupplier.getOAID();
        LogVlion.e("VlionOaidHelper OnSupport oaid=" + oaid);
        InterfaceC0045a interfaceC0045a = this.f4015a;
        if (interfaceC0045a != null) {
            ((VlionOaidManager.a) interfaceC0045a).a(oaid);
        }
    }

    public final void a(Context context) {
        try {
            MdidSdkHelper.InitSdk(context, true, this);
        } catch (Exception e10) {
            e10.printStackTrace();
            LogVlion.e("VlionOaidHelper callFromReflect Exception=" + e10.getMessage());
        }
    }
}
