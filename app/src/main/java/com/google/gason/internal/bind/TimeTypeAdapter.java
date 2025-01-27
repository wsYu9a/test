package com.google.gason.internal.bind;

import android.support.v4.view.C0008;
import com.google.gason.JsonSyntaxException;
import com.google.gason.internal.bind.TypeAdapter;
import com.google.gason.reflect.C0105;
import com.google.gason.reflect.TypeToken;
import com.google.gason.stream.JsonReader;
import com.google.gason.stream.JsonToken;
import com.google.gason.stream.JsonWriter;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes7.dex */
public final class TimeTypeAdapter extends TypeAdapter<Time> {
    public static final TypeAdapter.Factory FACTORY;

    /* renamed from: short */
    private static final short[] f83short;
    private final DateFormat format = new SimpleDateFormat(C0105.m44(f83short, 56509 ^ C0008.m27((Object) "ۦۣ"), 1748783 ^ C0008.m27((Object) "ۡۤۨ"), C0008.m27((Object) "ۣۢۧ") ^ 1751808));

    /* renamed from: com.google.gason.internal.bind.TimeTypeAdapter$1 */
    static class AnonymousClass1 implements TypeAdapter.Factory {
        AnonymousClass1() {
        }

        @Override // com.google.gason.internal.bind.TypeAdapter.Factory
        public <T> TypeAdapter<T> create(MiniGson miniGson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Time.class) {
                return new TimeTypeAdapter();
            }
            return null;
        }
    }

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(1609656)}[0]).intValue() ^ 1609650];
        sArr[0] = 2134;
        sArr[1] = 2134;
        sArr[2] = 2052;
        sArr[3] = 2131;
        sArr[4] = 2131;
        sArr[5] = 2052;
        sArr[6] = 2125;
        sArr[7] = 2125;
        sArr[8] = 2078;
        sArr[9] = 2143;
        f83short = sArr;
        FACTORY = new TypeAdapter.Factory() { // from class: com.google.gason.internal.bind.TimeTypeAdapter.1
            AnonymousClass1() {
            }

            @Override // com.google.gason.internal.bind.TypeAdapter.Factory
            public <T> TypeAdapter<T> create(MiniGson miniGson, TypeToken<T> typeToken) {
                if (typeToken.getRawType() == Time.class) {
                    return new TimeTypeAdapter();
                }
                return null;
            }
        };
    }

    @Override // com.google.gason.internal.bind.TypeAdapter
    public Time read(JsonReader jsonReader) throws IOException {
        synchronized (this) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return new Time(this.format.parse(jsonReader.nextString()).getTime());
            } catch (ParseException e2) {
                throw new JsonSyntaxException(e2);
            }
        }
    }

    @Override // com.google.gason.internal.bind.TypeAdapter
    public void write(JsonWriter jsonWriter, Time time) throws IOException {
        synchronized (this) {
            jsonWriter.value(time == null ? null : this.format.format((Date) time));
        }
    }
}
