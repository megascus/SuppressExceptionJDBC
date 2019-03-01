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

import java.sql.Array;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;

import dev.megascus.suppressexceptionjdbc.internal.NullResultSet;

/**
 * @author megascus
 */
public class SEArray implements Array {

	private final Array array;

	public SEArray(Array array) {
		this.array = array;
	}

	public Array getRealArray() {
		return this.array;
	}

	@Override
	public String getBaseTypeName() {
		try {
			return array.getBaseTypeName();
		} catch (final SQLException ex) {
			return "";
		}
	}

	@Override
	public int getBaseType() {
		try {
			return array.getBaseType();
		} catch (final SQLException ex) {
			return Types.NULL;
		}
	}

	@Override
	public Object getArray() {
		try {
			return array.getArray();
		} catch (final SQLException ex) {
			return new Object[0];
		}
	}

	@Override
	public Object getArray(Map<String, Class<?>> map) {
		try {
			return array.getArray(map);
		} catch (final SQLException ex) {
			return new Object[0];
		}
	}

	@Override
	public Object getArray(long index, int count) {
		try {
			return array.getArray(index, count);
		} catch (final SQLException ex) {
			return new Object[0];
		}
	}

	@Override
	public Object getArray(long index, int count, Map<String, Class<?>> map) {
		try {
			return array.getArray(index, count, map);
		} catch (final SQLException ex) {
			return new Object[0];
		}
	}

	@Override
	public SEResultSet getResultSet() {
		try {
			return new SEResultSet(array.getResultSet());
		} catch (final SQLException ex) {
			return new SEResultSet(NullResultSet.INSTANCE);
		}
	}

	@Override
	public SEResultSet getResultSet(Map<String, Class<?>> map) {
		try {
			return new SEResultSet(array.getResultSet(map));
		} catch (final SQLException ex) {
			return new SEResultSet(NullResultSet.INSTANCE);
		}
	}

	@Override
	public SEResultSet getResultSet(long index, int count) {
		try {
			return new SEResultSet(array.getResultSet(index, count));
		} catch (final SQLException ex) {
			return new SEResultSet(NullResultSet.INSTANCE);
		}
	}

	@Override
	public SEResultSet getResultSet(long index, int count, Map<String, Class<?>> map) {
		try {
			return new SEResultSet(array.getResultSet(index, count, map));
		} catch (final SQLException ex) {
			return new SEResultSet(NullResultSet.INSTANCE);
		}
	}

	@Override
	public void free() {
		try {
			array.free();
		} catch (final SQLException ex) {
		}
	}

}
