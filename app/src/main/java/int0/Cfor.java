package int0;

import android.content.Context;
import android.util.Log;
import com.sntech.net.DomainProvider;
import java.io.IOException;
import kk.c;
import new0.Cif;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import rh.d;
import rh.f;
import sk.b;

/* renamed from: int0.for */
/* loaded from: classes4.dex */
public final class Cfor implements Runnable {

    /* renamed from: b */
    public Context f27051b;

    /* renamed from: int0.for$a */
    public class a implements Callback {

        /* renamed from: a */
        public int f27052a = 0;

        /* renamed from: b */
        public final /* synthetic */ OkHttpClient f27053b;

        public a(OkHttpClient okHttpClient) {
            this.f27053b = okHttpClient;
        }

        @Override // okhttp3.Callback
        public final void onFailure(Call call, IOException iOException) {
            if (d.d()) {
                iOException.printStackTrace();
                Log.d("SNC_LOG", Log.getStackTraceString(iOException));
            }
            int i10 = this.f27052a;
            this.f27052a = i10 + 1;
            if (i10 >= 3 || call == null || call.request() == null) {
                return;
            }
            try {
                Thread.sleep(this.f27052a * 5000);
            } catch (InterruptedException e10) {
                e10.printStackTrace();
            }
            this.f27053b.newCall(call.request().newBuilder().url(call.request().url()).build()).enqueue(this);
        }

        @Override // okhttp3.Callback
        public final void onResponse(Call call, Response response) {
            int code = response == null ? -1 : response.code();
            if (d.d()) {
                Log.d("SNC_LOG", "request: " + code);
            }
            if (response.isSuccessful()) {
                try {
                    "200".equals(new JSONObject(response.body().string()).optString("code"));
                } catch (JSONException e10) {
                    if (d.d()) {
                        e10.printStackTrace();
                    }
                }
            }
        }
    }

    public Cfor(Context context) {
        this.f27051b = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        JSONObject jSONObject;
        Cif cif;
        if (d.d()) {
            Log.d("SNC_LOG", "Attribution run");
        }
        JSONObject jSONObject2 = null;
        try {
            Context context = this.f27051b;
            synchronized (Cif.class) {
                try {
                    if (Cif.f28856e == null) {
                        Cif.f28856e = new Cif(context);
                    }
                    cif = Cif.f28856e;
                } finally {
                }
            }
            jSONObject = cif.b();
        } catch (JSONException e10) {
            if (d.d()) {
                Log.d("SNC_LOG", "", e10);
            }
            jSONObject = null;
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject != null) {
                jSONObject3.put("attData", jSONObject);
            }
            jSONObject2 = f.a(this.f27051b, jSONObject3);
        } catch (Exception e11) {
            if (d.d()) {
                Log.d("SNC_LOG", Log.getStackTraceString(e11));
            }
        }
        if (jSONObject2 != null) {
            RequestBody create = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jSONObject2.toString());
            Request.Builder builder = new Request.Builder();
            StringBuilder sb2 = new StringBuilder();
            ((c.a) b.f30679c).getClass();
            sb2.append(DomainProvider.baseDeviceUrl());
            sb2.append("att");
            Request build = builder.url(sb2.toString()).post(create).build();
            OkHttpClient build2 = new OkHttpClient.Builder().build();
            build2.newCall(build).enqueue(new a(build2));
        }
    }
}
