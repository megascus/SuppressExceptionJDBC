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

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;

/**
 * @author megascus
 */
public class SEResultSetMetaData implements ResultSetMetaData {

	private final ResultSetMetaData metaData;

	public SEResultSetMetaData(ResultSetMetaData metaData) {
		this.metaData = metaData;
	}

	public ResultSetMetaData getRealResultSetMetaData() {
		return metaData;
	}

	@Override
	public int getColumnCount() {
		try {
			return metaData.getColumnCount();
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public boolean isAutoIncrement(int column) {
		try {
			return metaData.isAutoIncrement(column);
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean isCaseSensitive(int column) {
		try {
			return metaData.isCaseSensitive(column);
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean isSearchable(int column) {
		try {
			return metaData.isSearchable(column);
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean isCurrency(int column) {
		try {
			return metaData.isCurrency(column);
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public int isNullable(int column) {
		try {
			return metaData.isNullable(column);
		} catch (final SQLException ex) {
			return columnNullableUnknown;
		}
	}

	@Override
	public boolean isSigned(int column) {
		try {
			return metaData.isSigned(column);
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public int getColumnDisplaySize(int column) {
		try {
			return metaData.getColumnDisplaySize(column);
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public String getColumnLabel(int column) {
		try {
			return metaData.getColumnLabel(column);
		} catch (final SQLException ex) {
			return "";
		}
	}

	@Override
	public String getColumnName(int column) {
		try {
			return metaData.getColumnName(column);
		} catch (final SQLException ex) {
			return "";
		}
	}

	@Override
	public String getSchemaName(int column) {
		try {
			return metaData.getSchemaName(column);
		} catch (final SQLException ex) {
			return "";
		}
	}

	@Override
	public int getPrecision(int column) {
		try {
			return metaData.getPrecision(column);
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public int getScale(int column) {
		try {
			return metaData.getScale(column);
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public String getTableName(int column) {
		try {
			return metaData.getTableName(column);
		} catch (final SQLException ex) {
			return "";
		}
	}

	@Override
	public String getCatalogName(int column) {
		try {
			return metaData.getCatalogName(column);
		} catch (final SQLException ex) {
			return "";
		}
	}

	@Override
	public int getColumnType(int column) {
		try {
			return metaData.getColumnType(column);
		} catch (final SQLException ex) {
			return Types.NULL;
		}
	}

	@Override
	public String getColumnTypeName(int column) {
		try {
			return metaData.getColumnTypeName(column);
		} catch (final SQLException ex) {
			return "";
		}
	}

	@Override
	public boolean isReadOnly(int column) {
		try {
			return metaData.isReadOnly(column);
		} catch (final SQLException ex) {
			return true;
		}
	}

	@Override
	public boolean isWritable(int column) {
		try {
			return metaData.isWritable(column);
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean isDefinitelyWritable(int column) {
		try {
			return metaData.isDefinitelyWritable(column);
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public String getColumnClassName(int column) {
		try {
			return metaData.getColumnClassName(column);
		} catch (final SQLException ex) {
			return Object.class.getName();
		}
	}

	@Override
	public <T> T unwrap(Class<T> iface) {
		try {
			return metaData.unwrap(iface);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) {
		try {
			return metaData.isWrapperFor(iface);
		} catch (final SQLException ex) {
			return false;
		}
	}

}
