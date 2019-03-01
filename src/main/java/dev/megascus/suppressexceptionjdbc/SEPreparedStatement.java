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

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;

import dev.megascus.suppressexceptionjdbc.internal.NullParameterMetaData;
import dev.megascus.suppressexceptionjdbc.internal.NullResultSet;
import dev.megascus.suppressexceptionjdbc.internal.NullResultSetMetaData;

/**
 * @author megascus
 */
public class SEPreparedStatement extends SEStatement implements PreparedStatement {

	protected PreparedStatement base;

	public PreparedStatement getRealPreparedStatement() {
		return base;
	}

	public SEPreparedStatement(SEConnection conn,
			PreparedStatement base) {
		super(conn, base);
		this.base = base;
	}

	@Override
	public final SEResultSet executeQuery() {
		try {
			return new SEResultSet(base.executeQuery());
		} catch (final SQLException e) {
			return new SEResultSet(NullResultSet.INSTANCE);
		}
	}

	@Override
	public final int executeUpdate() {
		try {
			return base.executeUpdate();
		} catch (final SQLException e) {
			return 0;
		}
	}

	@Override
	public final void setNull(int parameterIndex, int sqlType) {
		try {
			base.setNull(parameterIndex, sqlType);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setBoolean(int parameterIndex, boolean x) {
		try {
			base.setBoolean(parameterIndex, x);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setByte(int parameterIndex, byte x) {
		try {
			base.setByte(parameterIndex, x);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setShort(int parameterIndex, short x) {
		try {
			base.setShort(parameterIndex, x);
		} catch (final SQLException e) {
		}
	}

	@Override
	public final void setInt(int parameterIndex, int x) {
		try {
			base.setInt(parameterIndex, x);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setLong(int parameterIndex, long x) {
		try {
			base.setLong(parameterIndex, x);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setFloat(int parameterIndex, float x) {
		try {
			base.setFloat(parameterIndex, x);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setDouble(int parameterIndex, double x) {
		try {
			base.setDouble(parameterIndex, x);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setBigDecimal(int parameterIndex, BigDecimal x) {
		try {
			base.setBigDecimal(parameterIndex, x);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setString(int parameterIndex, String x) {
		try {
			base.setString(parameterIndex, x);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setBytes(int parameterIndex, byte[] x) {
		try {
			base.setBytes(parameterIndex, x);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setDate(int parameterIndex, Date x) {
		try {
			base.setDate(parameterIndex, x);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setTime(int parameterIndex, Time x) {
		try {
			base.setTime(parameterIndex, x);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setTimestamp(int parameterIndex, Timestamp x) {
		try {
			base.setTimestamp(parameterIndex, x);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setAsciiStream(int parameterIndex, InputStream x, int length) {
		try {
			base.setAsciiStream(parameterIndex, x, length);
		} catch (final SQLException e) {
		}

	}

	@Deprecated
	@Override
	public final void setUnicodeStream(int parameterIndex, InputStream x, int length) {
		try {
			base.setUnicodeStream(parameterIndex, x, length);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setBinaryStream(int parameterIndex, InputStream x, int length) {
		try {
			base.setBinaryStream(parameterIndex, x, length);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void clearParameters() {
		try {
			base.clearParameters();
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setObject(int parameterIndex, Object x, int targetSqlType) {
		try {
			base.setObject(parameterIndex, x, targetSqlType);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setObject(int parameterIndex, Object x) {
		try {
			base.setObject(parameterIndex, x);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final boolean execute() {
		try {
			return base.execute();
		} catch (final SQLException e) {
			return false;
		}
	}

	@Override
	public final void addBatch() {
		try {
			base.addBatch();
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setCharacterStream(int parameterIndex, Reader reader, int length) {
		try {
			base.setCharacterStream(parameterIndex, reader, length);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setRef(int parameterIndex, Ref x) {
		try {
			base.setRef(parameterIndex, x);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setBlob(int parameterIndex, Blob x) {
		try {
			base.setBlob(parameterIndex, x);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setClob(int parameterIndex, Clob x) {
		try {
			base.setClob(parameterIndex, x);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setArray(int parameterIndex, Array x) {
		try {
			base.setArray(parameterIndex, x);
		} catch (final SQLException e) {
		}
	}

	@Override
	public final SEResultSetMetaData getMetaData() {
		try {
			return new SEResultSetMetaData(base.getMetaData());
		} catch (final SQLException e) {
			return new SEResultSetMetaData(NullResultSetMetaData.INSTANCE);
		}

	}

	@Override
	public final void setDate(int parameterIndex, Date x, Calendar cal) {
		try {
			base.setDate(parameterIndex, x, cal);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setTime(int parameterIndex, Time x, Calendar cal) {
		try {
			base.setTime(parameterIndex, x, cal);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setTimestamp(int parameterIndex, Timestamp x, Calendar cal) {
		try {
			base.setTimestamp(parameterIndex, x, cal);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setNull(int parameterIndex, int sqlType, String typeName) {
		try {
			base.setNull(parameterIndex, sqlType, typeName);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setURL(int parameterIndex, URL x) {
		try {
			base.setURL(parameterIndex, x);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final SEParameterMetaData getParameterMetaData() {
		try {
			return new SEParameterMetaData(base.getParameterMetaData());
		} catch (final SQLException e) {
			return new SEParameterMetaData(NullParameterMetaData.INSTANCE);
		}
	}

	@Override
	public final void setRowId(int parameterIndex, RowId x) {
		try {
			base.setRowId(parameterIndex, x);
		} catch (final SQLException e) {
		}
	}

	@Override
	public final void setNString(int parameterIndex, String value) {
		try {
			base.setNString(parameterIndex, value);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setNCharacterStream(int parameterIndex, Reader value, long length) {
		try {
			base.setNCharacterStream(parameterIndex, value, length);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setNClob(int parameterIndex, NClob value) {
		try {
			base.setNClob(parameterIndex, value);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setClob(int parameterIndex, Reader reader, long length) {
		try {
			base.setClob(parameterIndex, reader, length);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setBlob(int parameterIndex, InputStream inputStream, long length) {
		try {
			base.setBlob(parameterIndex, inputStream, length);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setNClob(int parameterIndex, Reader reader, long length) {
		try {
			base.setNClob(parameterIndex, reader, length);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setSQLXML(int parameterIndex, SQLXML xmlObject) {
		try {
			base.setSQLXML(parameterIndex, xmlObject);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setObject(int parameterIndex, Object x, int targetSqlType, int scaleOrLength) {
		try {
			base.setObject(parameterIndex, x, targetSqlType, scaleOrLength);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setAsciiStream(int parameterIndex, InputStream x, long length) {
		try {
			base.setAsciiStream(parameterIndex, x, length);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setBinaryStream(int parameterIndex, InputStream x, long length) {
		try {
			base.setBinaryStream(parameterIndex, x, length);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setCharacterStream(int parameterIndex, Reader reader, long length) {
		try {
			base.setCharacterStream(parameterIndex, reader, length);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setAsciiStream(int parameterIndex, InputStream x) {
		try {
			base.setAsciiStream(parameterIndex, x);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setBinaryStream(int parameterIndex, InputStream x) {
		try {
			base.setBinaryStream(parameterIndex, x);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setCharacterStream(int parameterIndex, Reader reader) {
		try {
			base.setCharacterStream(parameterIndex, reader);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setNCharacterStream(int parameterIndex, Reader value) {
		try {
			base.setNCharacterStream(parameterIndex, value);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setClob(int parameterIndex, Reader reader) {
		try {
			base.setClob(parameterIndex, reader);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setBlob(int parameterIndex, InputStream inputStream) {
		try {
			base.setBlob(parameterIndex, inputStream);
		} catch (final SQLException e) {
		}

	}

	@Override
	public final void setNClob(int parameterIndex, Reader reader) {
		try {
			base.setNClob(parameterIndex, reader);
		} catch (final SQLException e) {
		}

	}

}
