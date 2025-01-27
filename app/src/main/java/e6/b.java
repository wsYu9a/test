package e6;

import androidx.core.view.InputDeviceCompat;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;

/* loaded from: classes2.dex */
public final class b implements g {
    public static char c(char c10, int i10) {
        int i11 = c10 + ((i10 * TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_CODE) % 255) + 1;
        return i11 <= 255 ? (char) i11 : (char) (i11 + InputDeviceCompat.SOURCE_ANY);
    }

    @Override // e6.g
    public void a(h hVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append((char) 0);
        while (true) {
            if (!hVar.j()) {
                break;
            }
            sb2.append(hVar.d());
            hVar.f25718f++;
            int o10 = j.o(hVar.e(), hVar.f25718f, b());
            if (o10 != b()) {
                hVar.p(o10);
                break;
            }
        }
        int length = sb2.length() - 1;
        int a10 = hVar.a() + length + 1;
        hVar.r(a10);
        boolean z10 = hVar.h().b() - a10 > 0;
        if (hVar.j() || z10) {
            if (length <= 249) {
                sb2.setCharAt(0, (char) length);
            } else {
                if (length > 1555) {
                    throw new IllegalStateException("Message length not in valid ranges: " + length);
                }
                sb2.setCharAt(0, (char) ((length / 250) + 249));
                sb2.insert(1, (char) (length % 250));
            }
        }
        int length2 = sb2.length();
        for (int i10 = 0; i10 < length2; i10++) {
            hVar.s(c(sb2.charAt(i10), hVar.a() + 1));
        }
    }

    @Override // e6.g
    public int b() {
        return 5;
    }
}
