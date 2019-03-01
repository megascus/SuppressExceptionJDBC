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

import java.sql.ResultSetMetaData;

/**
 * @author megascus
 */
public class NullResultSetMetaData implements ResultSetMetaData {

	public static final NullResultSetMetaData INSTANCE = new NullResultSetMetaData();

	@Override
	public <T> T unwrap(Class<T> iface) {
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) {
		return false;
	}

	@Override
	public int getColumnCount() {
		return 0;
	}

	@Override
	public boolean isAutoIncrement(int column) {
		return false;
	}

	@Override
	public boolean isCaseSensitive(int column) {
		return false;
	}

	@Override
	public boolean isSearchable(int column) {
		return false;
	}

	@Override
	public boolean isCurrency(int column) {
		return false;
	}

	@Override
	public int isNullable(int column) {
		return ResultSetMetaData.columnNullableUnknown;
	}

	@Override
	public boolean isSigned(int column) {
		return false;
	}

	@Override
	public int getColumnDisplaySize(int column) {
		return 0;
	}

	@Override
	public String getColumnLabel(int column) {
		return null;
	}

	@Override
	public String getColumnName(int column) {
		return null;
	}

	@Override
	public String getSchemaName(int column) {
		return null;
	}

	@Override
	public int getPrecision(int column) {
		return 0;
	}

	@Override
	public int getScale(int column) {
		return 0;
	}

	@Override
	public String getTableName(int column) {
		return null;
	}

	@Override
	public String getCatalogName(int column) {
		return null;
	}

	@Override
	public int getColumnType(int column) {
		return 0;
	}

	@Override
	public String getColumnTypeName(int column) {
		return null;
	}

	@Override
	public boolean isReadOnly(int column) {
		return true;
	}

	@Override
	public boolean isWritable(int column) {
		return false;
	}

	@Override
	public boolean isDefinitelyWritable(int column) {
		return false;
	}

	@Override
	public String getColumnClassName(int column) {
		return null;
	}
}
