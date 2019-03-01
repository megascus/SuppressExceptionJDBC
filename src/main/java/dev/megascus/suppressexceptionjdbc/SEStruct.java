/*
 * Copyright 2019 megascus
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.megascus.suppressexceptionjdbc;

import java.sql.SQLException;
import java.sql.Struct;
import java.util.Map;

/**
 * @author megascus
 */
public class SEStruct implements Struct {

	private final Struct struct;
	private final String typeName;
	private final Object[] attributes;

	public SEStruct(Struct struct, String typeName, Object[] attributes) {
		this.struct = struct;
		this.typeName = typeName;
		this.attributes = attributes;
	}

	public Struct getRealStruct() {
		return struct;
	}

	@Override
	public String getSQLTypeName() {
		try {
			return struct.getSQLTypeName();
		} catch (final SQLException ex) {
			return typeName;
		}
	}

	@Override
	public Object[] getAttributes() {
		try {
			return struct.getAttributes();
		} catch (final SQLException ex) {
			return attributes;
		}
	}

	@Override
	public Object[] getAttributes(Map<String, Class<?>> map) {
		try {
			return struct.getAttributes(map);
		} catch (final SQLException ex) {
			return attributes;
		}
	}
}
