package com.google.gason.internal.bind;

import com.google.gason.JsonSyntaxException;
import com.google.gason.stream.JsonReader;
import com.google.gason.stream.JsonToken;
import com.google.gason.stream.JsonWriter;
import java.io.IOException;
import java.math.BigInteger;

/* loaded from: classes7.dex */
public final class BigIntegerTypeAdapter extends TypeAdapter<BigInteger> {
    @Override // com.google.gason.internal.bind.TypeAdapter
    public BigInteger read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        try {
            return new BigInteger(jsonReader.nextString());
        } catch (NumberFormatException e2) {
            throw new JsonSyntaxException(e2);
        }
    }

    @Override // com.google.gason.internal.bind.TypeAdapter
    public void write(JsonWriter jsonWriter, BigInteger bigInteger) throws IOException {
        jsonWriter.value(bigInteger);
    }
}
