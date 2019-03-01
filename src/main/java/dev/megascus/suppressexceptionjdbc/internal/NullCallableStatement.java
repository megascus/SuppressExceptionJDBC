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

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.RowId;
import java.sql.SQLType;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

/**
 * @author megascus
 */
public class NullCallableStatement extends NullPreparedStatement implements CallableStatement {

	public NullCallableStatement(Connection c) {
		super(c);
	}

	@Override
	public void registerOutParameter(int parameterIndex, int sqlType) {
	}

	@Override
	public void registerOutParameter(int parameterIndex, int sqlType, int scale) {
	}

	@Override
	public boolean wasNull() {
		return true;
	}

	@Override
	public String getString(int parameterIndex) {
		return null;
	}

	@Override
	public boolean getBoolean(int parameterIndex) {
		return false;
	}

	@Override
	public byte getByte(int parameterIndex) {
		return 0;
	}

	@Override
	public short getShort(int parameterIndex) {
		return 0;
	}

	@Override
	public int getInt(int parameterIndex) {
		return 0;
	}

	@Override
	public long getLong(int parameterIndex) {
		return 0;
	}

	@Override
	public float getFloat(int parameterIndex) {
		return 0;
	}

	@Override
	public double getDouble(int parameterIndex) {
		return 0;
	}

	@Deprecated
	@Override
	public BigDecimal getBigDecimal(int parameterIndex, int scale) {
		return null;
	}

	@Override
	public byte[] getBytes(int parameterIndex) {
		return null;
	}

	@Override
	public Date getDate(int parameterIndex) {
		return null;
	}

	@Override
	public Time getTime(int parameterIndex) {
		return null;
	}

	@Override
	public Timestamp getTimestamp(int parameterIndex) {
		return null;
	}

	@Override
	public Object getObject(int parameterIndex) {
		return null;
	}

	@Override
	public BigDecimal getBigDecimal(int parameterIndex) {
		return null;
	}

	@Override
	public Object getObject(int parameterIndex, Map<String, Class<?>> map) {
		return null;
	}

	@Override
	public Ref getRef(int parameterIndex) {
		return null;
	}

	@Override
	public Blob getBlob(int parameterIndex) {
		return null;
	}

	@Override
	public Clob getClob(int parameterIndex) {
		return null;
	}

	@Override
	public Array getArray(int parameterIndex) {
		return null;
	}

	@Override
	public Date getDate(int parameterIndex, Calendar cal) {
		return null;
	}

	@Override
	public Time getTime(int parameterIndex, Calendar cal) {
		return null;
	}

	@Override
	public Timestamp getTimestamp(int parameterIndex, Calendar cal) {
		return null;
	}

	@Override
	public void registerOutParameter(int parameterIndex, int sqlType, String typeName) {
	}

	@Override
	public void registerOutParameter(String parameterName, int sqlType) {
	}

	@Override
	public void registerOutParameter(String parameterName, int sqlType, int scale) {
	}

	@Override
	public void registerOutParameter(String parameterName, int sqlType, String typeName) {
	}

	@Override
	public URL getURL(int parameterIndex) {
		return null;
	}

	@Override
	public void setURL(String parameterName, URL val) {
	}

	@Override
	public void setNull(String parameterName, int sqlType) {
	}

	@Override
	public void setBoolean(String parameterName, boolean x) {
	}

	@Override
	public void setByte(String parameterName, byte x) {
	}

	@Override
	public void setShort(String parameterName, short x) {
	}

	@Override
	public void setInt(String parameterName, int x) {
	}

	@Override
	public void setLong(String parameterName, long x) {
	}

	@Override
	public void setFloat(String parameterName, float x) {
	}

	@Override
	public void setDouble(String parameterName, double x) {
	}

	@Override
	public void setBigDecimal(String parameterName, BigDecimal x) {
	}

	@Override
	public void setString(String parameterName, String x) {
	}

	@Override
	public void setBytes(String parameterName, byte[] x) {
	}

	@Override
	public void setDate(String parameterName, Date x) {
	}

	@Override
	public void setTime(String parameterName, Time x) {
	}

	@Override
	public void setTimestamp(String parameterName, Timestamp x) {
	}

	@Override
	public void setAsciiStream(String parameterName, InputStream x, int length) {
	}

	@Override
	public void setBinaryStream(String parameterName, InputStream x, int length) {
	}

	@Override
	public void setObject(String parameterName, Object x, int targetSqlType, int scale) {
	}

	@Override
	public void setObject(String parameterName, Object x, int targetSqlType) {
	}

	@Override
	public void setObject(String parameterName, Object x) {
	}

	@Override
	public void setCharacterStream(String parameterName, Reader reader, int length) {
	}

	@Override
	public void setDate(String parameterName, Date x, Calendar cal) {
	}

	@Override
	public void setTime(String parameterName, Time x, Calendar cal) {
	}

	@Override
	public void setTimestamp(String parameterName, Timestamp x, Calendar cal) {
	}

	@Override
	public void setNull(String parameterName, int sqlType, String typeName) {
	}

	@Override
	public String getString(String parameterName) {
		return null;
	}

	@Override
	public boolean getBoolean(String parameterName) {
		return false;
	}

	@Override
	public byte getByte(String parameterName) {
		return 0;
	}

	@Override
	public short getShort(String parameterName) {
		return 0;
	}

	@Override
	public int getInt(String parameterName) {
		return 0;
	}

	@Override
	public long getLong(String parameterName) {
		return 0;
	}

	@Override
	public float getFloat(String parameterName) {
		return 0;
	}

	@Override
	public double getDouble(String parameterName) {
		return 0;
	}

	@Override
	public byte[] getBytes(String parameterName) {
		return null;
	}

	@Override
	public Date getDate(String parameterName) {
		return null;
	}

	@Override
	public Time getTime(String parameterName) {
		return null;
	}

	@Override
	public Timestamp getTimestamp(String parameterName) {
		return null;
	}

	@Override
	public Object getObject(String parameterName) {
		return null;
	}

	@Override
	public BigDecimal getBigDecimal(String parameterName) {
		return null;
	}

	@Override
	public Object getObject(String parameterName, Map<String, Class<?>> map) {
		return null;
	}

	@Override
	public Ref getRef(String parameterName) {
		return null;
	}

	@Override
	public Blob getBlob(String parameterName) {
		return null;
	}

	@Override
	public Clob getClob(String parameterName) {
		return null;
	}

	@Override
	public Array getArray(String parameterName) {
		return null;
	}

	@Override
	public Date getDate(String parameterName, Calendar cal) {
		return null;
	}

	@Override
	public Time getTime(String parameterName, Calendar cal) {
		return null;
	}

	@Override
	public Timestamp getTimestamp(String parameterName, Calendar cal) {
		return null;
	}

	@Override
	public URL getURL(String parameterName) {
		return null;
	}

	@Override
	public RowId getRowId(int parameterIndex) {
		return null;
	}

	@Override
	public RowId getRowId(String parameterName) {
		return null;
	}

	@Override
	public void setRowId(String parameterName, RowId x) {
	}

	@Override
	public void setNString(String parameterName, String value) {
	}

	@Override
	public void setNCharacterStream(String parameterName, Reader value, long length) {
	}

	@Override
	public void setNClob(String parameterName, NClob value) {
	}

	@Override
	public void setClob(String parameterName, Reader reader, long length) {
	}

	@Override
	public void setBlob(String parameterName, InputStream inputStream, long length) {
	}

	@Override
	public void setNClob(String parameterName, Reader reader, long length) {
	}

	@Override
	public NClob getNClob(int parameterIndex) {
		return null;
	}

	@Override
	public NClob getNClob(String parameterName) {
		return null;
	}

	@Override
	public void setSQLXML(String parameterName, SQLXML xmlObject) {
	}

	@Override
	public SQLXML getSQLXML(int parameterIndex) {
		return null;
	}

	@Override
	public SQLXML getSQLXML(String parameterName) {
		return null;
	}

	@Override
	public String getNString(int parameterIndex) {
		return null;
	}

	@Override
	public String getNString(String parameterName) {
		return null;
	}

	@Override
	public Reader getNCharacterStream(int parameterIndex) {
		return null;
	}

	@Override
	public Reader getNCharacterStream(String parameterName) {
		return null;
	}

	@Override
	public Reader getCharacterStream(int parameterIndex) {
		return null;
	}

	@Override
	public Reader getCharacterStream(String parameterName) {
		return null;
	}

	@Override
	public void setBlob(String parameterName, Blob x) {
	}

	@Override
	public void setClob(String parameterName, Clob x) {
	}

	@Override
	public void setAsciiStream(String parameterName, InputStream x, long length) {
	}

	@Override
	public void setBinaryStream(String parameterName, InputStream x, long length) {
	}

	@Override
	public void setCharacterStream(String parameterName, Reader reader, long length) {
	}

	@Override
	public void setAsciiStream(String parameterName, InputStream x) {
	}

	@Override
	public void setBinaryStream(String parameterName, InputStream x) {
	}

	@Override
	public void setCharacterStream(String parameterName, Reader reader) {
	}

	@Override
	public void setNCharacterStream(String parameterName, Reader value) {
	}

	@Override
	public void setClob(String parameterName, Reader reader) {
	}

	@Override
	public void setBlob(String parameterName, InputStream inputStream) {
	}

	@Override
	public void setNClob(String parameterName, Reader reader) {
	}

	@Override
	public <T> T getObject(int parameterIndex, Class<T> type) {
		return null;
	}

	@Override
	public <T> T getObject(String parameterName, Class<T> type) {
		return null;
	}

	@Override
	public void setObject(String parameterName, Object x, SQLType targetSqlType, int scaleOrLength) {
	}

	@Override
	public void setObject(String parameterName, Object x, SQLType targetSqlType) {
	}

}
