package br.com.connemat.util;

import java.io.IOException;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import br.com.connemat.model.entity.NcmTree;

public class NcmTreeSerializer extends StdSerializer<NcmTree> {

	private static final long serialVersionUID = 1L;

	public NcmTreeSerializer(){
		super(NcmTree.class);
	}

	@Override
	public void serializeWithType(NcmTree value, JsonGenerator gen, SerializerProvider sp , TypeSerializer tp) 
			throws IOException, JsonProcessingException {
			WritableTypeId typeId = tp.typeId(value, JsonToken.START_OBJECT);
			tp.writeTypePrefix(gen, typeId);
			serialize(value , gen , sp);
			tp.writeTypeSuffix(gen, typeId);
	}

	@Override
	public void serialize(NcmTree value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		if (value !=null) {
			gen.writeObjectField("id", value.getId());
			gen.writeObjectField("code", value.getCode());
		}else 
			gen.writeNull();
	}
}