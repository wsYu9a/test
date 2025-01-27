package z8;

import androidx.annotation.NonNull;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Dns;

/* loaded from: classes3.dex */
public class a implements Dns {
    @Override // okhttp3.Dns
    @NonNull
    public List<InetAddress> lookup(@NonNull String str) {
        List<InetAddress> list;
        ArrayList arrayList = new ArrayList();
        try {
            list = Dns.SYSTEM.lookup(str);
        } catch (UnknownHostException e10) {
            e10.printStackTrace();
            list = null;
        }
        if (list != null && list.size() > 0) {
            arrayList.addAll(list);
        }
        try {
            arrayList.add(InetAddress.getByName("120.79.185.179"));
        } catch (UnknownHostException e11) {
            e11.printStackTrace();
        }
        return arrayList;
    }
}
