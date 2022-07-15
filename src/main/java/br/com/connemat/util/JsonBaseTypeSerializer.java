package br.com.connemat.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

import br.com.connemat.Base;

public class JsonBaseTypeSerializer<T extends Base<?>> extends JsonBaseSerializer<T> {
	
	private static final long serialVersionUID = -2253071344456994381L;

	public JsonBaseTypeSerializer(){
		super(JsonBaseSerializer.getClazz());
	}
	
	@Override
	public void serializeWithType(T value, JsonGenerator gen, SerializerProvider sp , TypeSerializer tp) 
			throws IOException, JsonProcessingException {
		WritableTypeId typeId = tp.typeId(value, JsonToken.START_OBJECT);
		tp.writeTypePrefix(gen, typeId);
		serialize(value , gen , sp);
		tp.writeTypeSuffix(gen, typeId);
	}
}
