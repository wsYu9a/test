package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.martian.mibook.application.MiConfigSingleton;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class cv implements Runnable {

    /* renamed from: a */
    private Context f9245a;

    /* renamed from: com.kuaishou.weapon.p0.cv$1 */
    class AnonymousClass1 implements j {
        AnonymousClass1() {
        }

        @Override // com.kuaishou.weapon.p0.j
        public void a(String str) {
            try {
                cv.this.a(str);
            } catch (Exception unused) {
            }
        }

        @Override // com.kuaishou.weapon.p0.j
        public void b(String str) {
        }
    }

    public cv(Context context) {
        this.f9245a = context;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(44:7|(2:8|9)|(45:11|12|13|14|15|16|18|19|(1:21)|23|24|(1:26)|28|29|30|31|32|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|53|54|(3:56|(1:58)|59)|61|62|(1:64)|66|67|(1:69)|71)|94|95|18|19|(0)|23|24|(0)|28|29|30|31|32|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|53|54|(0)|61|62|(0)|66|67|(0)|71) */
    /* JADX WARN: Can't wrap try/catch for region: R(45:7|8|9|(45:11|12|13|14|15|16|18|19|(1:21)|23|24|(1:26)|28|29|30|31|32|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|53|54|(3:56|(1:58)|59)|61|62|(1:64)|66|67|(1:69)|71)|94|95|18|19|(0)|23|24|(0)|28|29|30|31|32|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|53|54|(0)|61|62|(0)|66|67|(0)|71) */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0335, code lost:
    
        r13 = "p";
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0338, code lost:
    
        r13 = "p";
        r10 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x033f, code lost:
    
        r13 = "p";
        r10 = r18;
        r8 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x028c, code lost:
    
        r17 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x033d, code lost:
    
        r17 = r15;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0101 A[Catch: Exception -> 0x0128, TRY_LEAVE, TryCatch #13 {Exception -> 0x0128, blocks: (B:19:0x00f2, B:21:0x0101), top: B:18:0x00f2 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x013c A[Catch: Exception -> 0x01ff, TRY_LEAVE, TryCatch #8 {Exception -> 0x01ff, blocks: (B:24:0x0128, B:26:0x013c), top: B:23:0x0128 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x03e1 A[Catch: Exception -> 0x0446, TryCatch #14 {Exception -> 0x0446, blocks: (B:54:0x03d2, B:56:0x03e1, B:58:0x040d, B:59:0x0443), top: B:53:0x03d2 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0457 A[Catch: Exception -> 0x0488, TRY_LEAVE, TryCatch #12 {Exception -> 0x0488, blocks: (B:62:0x0446, B:64:0x0457), top: B:61:0x0446 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0499 A[Catch: Exception -> 0x04dc, TRY_LEAVE, TryCatch #11 {Exception -> 0x04dc, blocks: (B:67:0x0488, B:69:0x0499), top: B:66:0x0488 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.kuaishou.weapon.p0.y b(java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 1247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.cv.b(java.lang.String):com.kuaishou.weapon.p0.y");
    }

    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("result", 0) == 1) {
                String a2 = new bm(this.f9245a).a(jSONObject.getString("antispamPluginRsp"));
                if (TextUtils.isEmpty(a2)) {
                    return;
                }
                y b2 = b(a2);
                if (b2 != null) {
                    de.a(this.f9245a).a(str, b2);
                } else {
                    de.a(this.f9245a).b(System.currentTimeMillis());
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            String str = ct.f9230a + ct.f9233d;
            String a2 = cu.a(this.f9245a);
            if (!TextUtils.isEmpty(a2)) {
                str = str + "?" + a2;
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject b2 = cu.b(this.f9245a);
            if (b2 != null) {
                jSONObject.put(MiConfigSingleton.t0, new bm(this.f9245a).c(b2.toString()));
            }
            l a3 = l.a(this.f9245a);
            m mVar = new m(str, jSONObject);
            mVar.a(WeaponHI.cookieData);
            mVar.b(WeaponHI.encryENV);
            a3.b(mVar, new j() { // from class: com.kuaishou.weapon.p0.cv.1
                AnonymousClass1() {
                }

                @Override // com.kuaishou.weapon.p0.j
                public void a(String str2) {
                    try {
                        cv.this.a(str2);
                    } catch (Exception unused) {
                    }
                }

                @Override // com.kuaishou.weapon.p0.j
                public void b(String str2) {
                }
            });
        } catch (Exception unused) {
        }
    }
}
