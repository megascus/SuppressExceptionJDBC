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
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

/**
 * @author megascus
 */
public class SECallableStatement extends SEPreparedStatement implements CallableStatement {

	private final CallableStatement base;

	public SECallableStatement(SEConnection conn, CallableStatement base) {
		super(conn, base);
		this.base = base;
	}

	public CallableStatement getRealCallableStatement() {
		return base;
	}

	@Override
	public final void registerOutParameter(int parameterIndex, int sqlType) {
		try {
			base.registerOutParameter(parameterIndex, sqlType);
		} catch (final SQLException e) {
		}
	}

	@Override
	public final void registerOutParameter(int parameterIndex, int sqlType, int scale) {
		try {
			base.registerOutParameter(parameterIndex, sqlType, scale);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final boolean wasNull() {
		try {
			return base.wasNull();
		} catch (final SQLException e) {
			return true;
		}
	}

	@Override
	public final String getString(int parameterIndex) {
		try {
			return base.getString(parameterIndex);
		} catch (final SQLException e) {
			return null;
		}
	}

	@Override
	public final boolean getBoolean(int parameterIndex) {
		try {
			return base.getBoolean(parameterIndex);
		} catch (final SQLException e) {
			return false;
		}
	}

	@Override
	public final byte getByte(int parameterIndex) {
		try {
			return base.getByte(parameterIndex);
		} catch (final SQLException e) {
			return 0;
		}
	}

	@Override
	public final short getShort(int parameterIndex) {
		try {
			return base.getShort(parameterIndex);
		} catch (final SQLException e) {
			return 0;
		}
	}

	@Override
	public final int getInt(int parameterIndex) {
		try {
			return base.getInt(parameterIndex);
		} catch (final SQLException e) {
			return 0;
		}
	}

	@Override
	public final long getLong(int parameterIndex) {
		try {
			return base.getLong(parameterIndex);
		} catch (final SQLException e) {
			return 0;
		}
	}

	@Override
	public final float getFloat(int parameterIndex) {
		try {
			return base.getFloat(parameterIndex);
		} catch (final SQLException e) {
			return 0;
		}
	}

	@Override
	public final double getDouble(int parameterIndex) {
		try {
			return base.getDouble(parameterIndex);
		} catch (final SQLException e) {
			return 0;
		}
	}

	@Override
	@Deprecated
	public final BigDecimal getBigDecimal(int parameterIndex, int scale) {
		try {
			return base.getBigDecimal(parameterIndex, scale);
		} catch (final SQLException e) {
			return null;
		}
	}

	@Override
	public final byte[] getBytes(int parameterIndex) {
		try {
			return base.getBytes(parameterIndex);
		} catch (final SQLException e) {
			return null;
		}
	}

	@Override
	public final Date getDate(int parameterIndex) {
		try {
			return base.getDate(parameterIndex);
		} catch (final SQLException e) {
			return null;
		}
	}

	@Override
	public final Time getTime(int parameterIndex) {
		try {
			return base.getTime(parameterIndex);
		} catch (final SQLException e) {
			return null;
		}
	}

	@Override
	public final Timestamp getTimestamp(int parameterIndex) {
		try {
			return base.getTimestamp(parameterIndex);
		} catch (final SQLException e) {
			return null;
		}
	}

	@Override
	public final Object getObject(int parameterIndex) {
		try {
			return base.getObject(parameterIndex);
		} catch (final SQLException e) {
			return null;
		}
	}

	@Override
	public final BigDecimal getBigDecimal(int parameterIndex) {
		try {
			return base.getBigDecimal(parameterIndex);
		} catch (final SQLException e) {
			return null;
		}
	}

	@Override
	public final Object getObject(int parameterIndex, Map<String, Class<?>> map) {
		try {
			return base.getObject(parameterIndex, map);
		} catch (final SQLException e) {
			return null;
		}
	}

	@Override
	public final Ref getRef(int parameterIndex) {
		try {
			return base.getRef(parameterIndex);
		} catch (final SQLException e) {
			return null;
		}
	}

	@Override
	public final SEBlob getBlob(int parameterIndex) {
		try {
			Blob b = base.getBlob(parameterIndex);
			if (b != null) {
				return new SEBlob(b);
			}
		} catch (final SQLException e) {
		}
		return null;
	}

	@Override
	public final SEClob getClob(int parameterIndex) {
		try {
			Clob c = base.getClob(parameterIndex);
			if (c != null) {
				return new SEClob(c);
			}
		} catch (final SQLException e) {
		}
		return null;
	}

	@Override
	public final SEArray getArray(int parameterIndex) {
		try {
			Array a = base.getArray(parameterIndex);
			if (a != null) {
				return new SEArray(a);
			}
		} catch (final SQLException e) {
		}
		return null;
	}

	@Override
	public final Date getDate(int parameterIndex, Calendar cal) {
		try {
			return base.getDate(parameterIndex, cal);
		} catch (final SQLException e) {
			return null;
		}
	}

	@Override
	public final Time getTime(int parameterIndex, Calendar cal) {
		try {
			return base.getTime(parameterIndex, cal);
		} catch (final SQLException e) {
			return null;
		}
	}

	@Override
	public final Timestamp getTimestamp(int parameterIndex, Calendar cal) {
		try {
			return base.getTimestamp(parameterIndex, cal);
		} catch (final SQLException e) {
			return null;
		}
	}

	@Override
	public final void registerOutParameter(int parameterIndex, int sqlType, String typeName) {
		try {
			base.registerOutParameter(parameterIndex, sqlType, typeName);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void registerOutParameter(String parameterName, int sqlType) {
		try {
			base.registerOutParameter(parameterName, sqlType);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void registerOutParameter(String parameterName, int sqlType, int scale) {
		try {
			base.registerOutParameter(parameterName, sqlType, scale);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void registerOutParameter(String parameterName, int sqlType, String typeName) {
		try {
			base.registerOutParameter(parameterName, sqlType, typeName);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final URL getURL(int parameterIndex) {
		try {
			return base.getURL(parameterIndex);
		} catch (final SQLException e) {
			return null;
		}
	}

	@Override
	public final void setURL(String parameterName, URL val) {
		try {
			base.setURL(parameterName, val);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setNull(String parameterName, int sqlType) {
		try {
			base.setNull(parameterName, sqlType);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setBoolean(String parameterName, boolean x) {
		try {
			base.setBoolean(parameterName, x);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setByte(String parameterName, byte x) {
		try {
			base.setByte(parameterName, x);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setShort(String parameterName, short x) {
		try {
			base.setShort(parameterName, x);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setInt(String parameterName, int x) {
		try {
			base.setInt(parameterName, x);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setLong(String parameterName, long x) {
		try {
			base.setLong(parameterName, x);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setFloat(String parameterName, float x) {
		try {
			base.setFloat(parameterName, x);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setDouble(String parameterName, double x) {
		try {
			base.setDouble(parameterName, x);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setBigDecimal(String parameterName, BigDecimal x) {
		try {
			base.setBigDecimal(parameterName, x);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setString(String parameterName, String x) {
		try {
			base.setString(parameterName, x);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setBytes(String parameterName, byte[] x) {
		try {
			base.setBytes(parameterName, x);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setDate(String parameterName, Date x) {
		try {
			base.setDate(parameterName, x);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setTime(String parameterName, Time x) {
		try {
			base.setTime(parameterName, x);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setTimestamp(String parameterName, Timestamp x) {
		try {
			base.setTimestamp(parameterName, x);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setAsciiStream(String parameterName, InputStream x, int length) {
		try {
			base.setAsciiStream(parameterName, x, length);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setBinaryStream(String parameterName, InputStream x, int length) {
		try {
			base.setBinaryStream(parameterName, x, length);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setObject(String parameterName, Object x, int targetSqlType, int scale) {
		try {
			base.setObject(parameterName, x, targetSqlType, scale);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setObject(String parameterName, Object x, int targetSqlType) {
		try {
			base.setObject(parameterName, x, targetSqlType);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setObject(String parameterName, Object x) {
		try {
			base.setObject(parameterName, x);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setCharacterStream(String parameterName, Reader reader, int length) {
		try {
			base.setCharacterStream(parameterName, reader, length);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setDate(String parameterName, Date x, Calendar cal) {
		try {
			base.setDate(parameterName, x, cal);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setTime(String parameterName, Time x, Calendar cal) {
		try {
			base.setTime(parameterName, x, cal);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setTimestamp(String parameterName, Timestamp x, Calendar cal) {
		try {
			base.setTimestamp(parameterName, x, cal);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setNull(String parameterName, int sqlType, String typeName) {
		try {
			base.setNull(parameterName, sqlType, typeName);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final String getString(String parameterName) {
		try {
			return base.getString(parameterName);
		} catch (final SQLException e) {
			return null;
		}
	}

	@Override
	public final boolean getBoolean(String parameterName) {
		try {
			return base.getBoolean(parameterName);
		} catch (final SQLException e) {
			return false;
		}
	}

	@Override
	public final void setObject(int parameterIndex, Object x, SQLType targetSqlType, int scaleOrLength) {
		try {
			base.setObject(parameterIndex, x, targetSqlType, scaleOrLength);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final byte getByte(String parameterName) {
		try {
			return base.getByte(parameterName);
		} catch (final SQLException e) {
			return 0;
		}
	}

	@Override
	public final short getShort(String parameterName) {
		try {
			return base.getShort(parameterName);
		} catch (final SQLException e) {
			return 0;
		}
	}

	@Override
	public final int getInt(String parameterName) {
		try {
			return base.getInt(parameterName);
		} catch (final SQLException e) {
			return 0;
		}
	}

	@Override
	public final long getLong(String parameterName) {
		try {
			return base.getLong(parameterName);
		} catch (final SQLException e) {
			return 0;
		}
	}

	@Override
	public final void setObject(int parameterIndex, Object x, SQLType targetSqlType) {
		try {
			base.setObject(parameterIndex, x, targetSqlType);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final float getFloat(String parameterName) {
		try {
			return base.getFloat(parameterName);
		} catch (final SQLException e) {
			return 0;
		}
	}

	@Override
	public final long executeLargeUpdate() {
		try {
			return base.executeLargeUpdate();
		} catch (final SQLException e) {
			return 0;
		}
	}

	@Override
	public final double getDouble(String parameterName) {
		try {
			return base.getDouble(parameterName);
		} catch (final SQLException e) {
			return 0;
		}
	}

	@Override
	public final byte[] getBytes(String parameterName) {
		try {
			return base.getBytes(parameterName);
		} catch (final SQLException e) {
			return null;
		}
	}

	@Override
	public final Date getDate(String parameterName) {
		try {
			return base.getDate(parameterName);
		} catch (final SQLException e) {
			return null;
		}
	}

	@Override
	public final Time getTime(String parameterName) {
		try {
			return base.getTime(parameterName);
		} catch (final SQLException e) {
			return null;
		}
	}

	@Override
	public final Timestamp getTimestamp(String parameterName) {
		try {
			return base.getTimestamp(parameterName);
		} catch (final SQLException e) {
			return null;
		}
	}

	@Override
	public final Object getObject(String parameterName) {
		try {
			return base.getObject(parameterName);
		} catch (final SQLException e) {
			return null;
		}
	}

	@Override
	public final BigDecimal getBigDecimal(String parameterName) {
		try {
			return base.getBigDecimal(parameterName);
		} catch (final SQLException e) {
			return null;
		}
	}

	@Override
	public final Object getObject(String parameterName, Map<String, Class<?>> map) {
		try {
			return base.getObject(parameterName, map);
		} catch (final SQLException e) {
			return null;
		}
	}

	@Override
	public final SERef getRef(String parameterName) {
		try {
			Ref ref = base.getRef(parameterName);
			if (ref != null) {
				return new SERef(ref);
			}
		} catch (final SQLException e) {
		}
		return null;
	}

	@Override
	public final SEBlob getBlob(String parameterName) {
		try {
			Blob b = base.getBlob(parameterName);
			if (b != null) {
				return new SEBlob(b);
			}
		} catch (final SQLException e) {
		}
		return null;
	}

	@Override
	public final SEClob getClob(String parameterName) {
		try {
			Clob c = base.getClob(parameterName);
			if (c != null) {
				return new SEClob(c);
			}
		} catch (final SQLException e) {
		}
		return null;
	}

	@Override
	public final SEArray getArray(String parameterName) {
		try {
			Array a = base.getArray(parameterName);
			if (a != null) {
				return new SEArray(a);
			}
		} catch (final SQLException e) {
		}
		return null;
	}

	@Override
	public final Date getDate(String parameterName, Calendar cal) {
		try {
			return base.getDate(parameterName, cal);
		} catch (final SQLException e) {
			return null;
		}
	}

	@Override
	public final Time getTime(String parameterName, Calendar cal) {
		try {
			return base.getTime(parameterName, cal);
		} catch (final SQLException e) {
			return null;
		}
	}

	@Override
	public final Timestamp getTimestamp(String parameterName, Calendar cal) {
		try {
			return base.getTimestamp(parameterName, cal);
		} catch (final SQLException e) {
			return null;
		}
	}

	@Override
	public final URL getURL(String parameterName) {
		try {
			return base.getURL(parameterName);
		} catch (final SQLException e) {
			return null;
		}
	}

	@Override
	public final RowId getRowId(int parameterIndex) {
		try {
			return base.getRowId(parameterIndex);
		} catch (final SQLException e) {
			return null;
		}
	}

	@Override
	public final RowId getRowId(String parameterName) {
		try {
			return base.getRowId(parameterName);
		} catch (final SQLException e) {
			return null;
		}
	}

	@Override
	public final void setRowId(String parameterName, RowId x) {
		try {
			base.setRowId(parameterName, x);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setNString(String parameterName, String value) {
		try {
			base.setNString(parameterName, value);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setNCharacterStream(String parameterName, Reader value, long length) {
		try {
			base.setNCharacterStream(parameterName, value, length);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setNClob(String parameterName, NClob value) {
		try {
			base.setNClob(parameterName, value);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setClob(String parameterName, Reader reader, long length) {
		try {
			base.setClob(parameterName, reader, length);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setBlob(String parameterName, InputStream inputStream, long length) {
		try {
			base.setBlob(parameterName, inputStream, length);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setNClob(String parameterName, Reader reader, long length) {
		try {
			base.setNClob(parameterName, reader, length);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final SENClob getNClob(int parameterIndex) {
		try {
			NClob c = base.getNClob(parameterIndex);
			if (c != null) {
				return new SENClob(c);
			}
		} catch (final SQLException e) {
		}
		return null;
	}

	@Override
	public final NClob getNClob(String parameterName) {
		try {
			NClob c = base.getNClob(parameterName);
			if (c != null) {
				return new SENClob(c);
			}
		} catch (final SQLException e) {
		}
		return null;
	}

	@Override
	public final void setSQLXML(String parameterName, SQLXML xmlObject) {
		try {
			base.setSQLXML(parameterName, xmlObject);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final SESQLXML getSQLXML(int parameterIndex) {
		try {
			SQLXML sqlxml = base.getSQLXML(parameterIndex);
			if (sqlxml != null) {
				return new SESQLXML(sqlxml);
			}
		} catch (final SQLException e) {
		}
		return null;
	}

	@Override
	public final SESQLXML getSQLXML(String parameterName) {
		try {
			SQLXML sqlxml = base.getSQLXML(parameterName);
			if (sqlxml != null) {
				return new SESQLXML(sqlxml);
			}
		} catch (final SQLException e) {
		}
		return null;
	}

	@Override
	public final String getNString(int parameterIndex) {
		try {
			return base.getNString(parameterIndex);
		} catch (final SQLException e) {
			return null;
		}
	}

	@Override
	public final String getNString(String parameterName) {
		try {
			return base.getNString(parameterName);
		} catch (final SQLException e) {
			return null;
		}
	}

	@Override
	public final SEReader getNCharacterStream(int parameterIndex) {
		try {
			Reader reader = base.getNCharacterStream(parameterIndex);
			if (reader != null) {
				return new SEReader(reader);
			}
		} catch (final SQLException e) {
		}
		return null;
	}

	@Override
	public final SEReader getNCharacterStream(String parameterName) {
		try {
			Reader reader = base.getNCharacterStream(parameterName);
			if (reader != null) {
				return new SEReader(reader);
			}
		} catch (final SQLException e) {
		}
		return null;
	}

	@Override
	public final SEReader getCharacterStream(int parameterIndex) {
		try {
			Reader reader = base.getCharacterStream(parameterIndex);
			if (reader != null) {
				return new SEReader(reader);
			}
		} catch (final SQLException e) {
		}
		return null;
	}

	@Override
	public final SEReader getCharacterStream(String parameterName) {
		try {
			Reader reader = base.getCharacterStream(parameterName);
			if (reader != null) {
				return new SEReader(reader);
			}
		} catch (final SQLException e) {
		}
		return null;
	}

	@Override
	public final void setBlob(String parameterName, Blob x) {
		try {
			base.setBlob(parameterName, x);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setClob(String parameterName, Clob x) {
		try {
			base.setClob(parameterName, x);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setAsciiStream(String parameterName, InputStream x, long length) {
		try {
			base.setAsciiStream(parameterName, x, length);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setBinaryStream(String parameterName, InputStream x, long length) {
		try {
			base.setBinaryStream(parameterName, x, length);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setCharacterStream(String parameterName, Reader reader, long length) {
		try {
			base.setCharacterStream(parameterName, reader, length);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setAsciiStream(String parameterName, InputStream x) {
		try {
			base.setAsciiStream(parameterName, x);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setBinaryStream(String parameterName, InputStream x) {
		try {
			base.setBinaryStream(parameterName, x);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setCharacterStream(String parameterName, Reader reader) {
		try {
			base.setCharacterStream(parameterName, reader);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setNCharacterStream(String parameterName, Reader value) {
		try {
			base.setNCharacterStream(parameterName, value);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setClob(String parameterName, Reader reader) {
		try {
			base.setClob(parameterName, reader);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setBlob(String parameterName, InputStream inputStream) {
		try {
			base.setBlob(parameterName, inputStream);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setNClob(String parameterName, Reader reader) {
		try {
			base.setNClob(parameterName, reader);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final <T> T getObject(int parameterIndex, Class<T> type) {
		try {
			return base.getObject(parameterIndex, type);
		} catch (final SQLException e) {
			return null;
		}
	}

	@Override
	public final <T> T getObject(String parameterName, Class<T> type) {
		try {
			return base.getObject(parameterName, type);
		} catch (final SQLException e) {
			return null;
		}
	}

	@Override
	public final void setObject(String parameterName, Object x, SQLType targetSqlType, int scaleOrLength) {
		try {
			base.setObject(parameterName, x, targetSqlType, scaleOrLength);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void setObject(String parameterName, Object x, SQLType targetSqlType) {
		try {
			base.setObject(parameterName, x, targetSqlType);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void registerOutParameter(int parameterIndex, SQLType sqlType) {
		try {
			base.registerOutParameter(parameterIndex, sqlType);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void registerOutParameter(int parameterIndex, SQLType sqlType, int scale) {
		try {
			base.registerOutParameter(parameterIndex, sqlType, scale);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void registerOutParameter(int parameterIndex, SQLType sqlType, String typeName) {
		try {
			base.registerOutParameter(parameterIndex, sqlType, typeName);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void registerOutParameter(String parameterName, SQLType sqlType) {
		try {
			base.registerOutParameter(parameterName, sqlType);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void registerOutParameter(String parameterName, SQLType sqlType, int scale) {
		try {
			base.registerOutParameter(parameterName, sqlType, scale);
		} catch (final SQLException e) {

		}
	}

	@Override
	public final void registerOutParameter(String parameterName, SQLType sqlType, String typeName) {
		try {
			base.registerOutParameter(parameterName, sqlType, typeName);
		} catch (final SQLException e) {

		}
	}

}
