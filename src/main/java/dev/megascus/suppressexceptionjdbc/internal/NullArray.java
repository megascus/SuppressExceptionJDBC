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
package dev.megascus.suppressexceptionjdbc.internal;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Map;

/**
 * @author megascus
 */
public class NullArray implements Array {

	public static final NullArray INSTANCE = new NullArray();

	NullArray() {
	}

	@Override
	public String getBaseTypeName() {
		return "";
	}

	@Override
	public int getBaseType() {
		return Types.NULL;
	}

	@Override
	public Object getArray() {
		return Types.NULL;
	}

	@Override
	public Object getArray(Map<String, Class<?>> map) {
		return new Object[0];
	}

	@Override
	public Object getArray(long index, int count) {
		return new Object[0];
	}

	@Override
	public Object getArray(long index, int count, Map<String, Class<?>> map) {
		return new Object[0];
	}

	@Override
	public ResultSet getResultSet() {
		return NullResultSet.INSTANCE;
	}

	@Override
	public ResultSet getResultSet(Map<String, Class<?>> map) {
		return NullResultSet.INSTANCE;
	}

	@Override
	public ResultSet getResultSet(long index, int count) {
		return NullResultSet.INSTANCE;
	}

	@Override
	public ResultSet getResultSet(long index, int count, Map<String, Class<?>> map) {
		return NullResultSet.INSTANCE;
	}

	@Override
	public void free() {
	}

}
