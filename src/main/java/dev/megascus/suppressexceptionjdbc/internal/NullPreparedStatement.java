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
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLType;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * @author megascus
 */
public class NullPreparedStatement extends NullStatement implements PreparedStatement {

	public NullPreparedStatement(Connection c) {
		super(c);
	}

	@Override
	public ResultSet executeQuery() {
		return new NullResultSet(this);
	}

	@Override
	public int executeUpdate() {
		return 0;
	}

	@Override
	public void setNull(int parameterIndex, int sqlType) {

	}

	@Override
	public void setBoolean(int parameterIndex, boolean x) {

	}

	@Override
	public void setByte(int parameterIndex, byte x) {

	}

	@Override
	public void setShort(int parameterIndex, short x) {

	}

	@Override
	public void setInt(int parameterIndex, int x) {

	}

	@Override
	public void setLong(int parameterIndex, long x) {

	}

	@Override
	public void setFloat(int parameterIndex, float x) {

	}

	@Override
	public void setDouble(int parameterIndex, double x) {

	}

	@Override
	public void setBigDecimal(int parameterIndex, BigDecimal x) {

	}

	@Override
	public void setString(int parameterIndex, String x) {

	}

	@Override
	public void setBytes(int parameterIndex, byte[] x) {

	}

	@Override
	public void setDate(int parameterIndex, Date x) {

	}

	@Override
	public void setTime(int parameterIndex, Time x) {

	}

	@Override
	public void setTimestamp(int parameterIndex, Timestamp x) {

	}

	@Override
	public void setAsciiStream(int parameterIndex, InputStream x, int length) {

	}

	@Deprecated
	@Override
	public void setUnicodeStream(int parameterIndex, InputStream x, int length) {

	}

	@Override
	public void setBinaryStream(int parameterIndex, InputStream x, int length) {

	}

	@Override
	public void clearParameters() {

	}

	@Override
	public void setObject(int parameterIndex, Object x, int targetSqlType) {

	}

	@Override
	public void setObject(int parameterIndex, Object x) {

	}

	@Override
	public boolean execute() {
		return false;
	}

	@Override
	public void addBatch() {

	}

	@Override
	public void setCharacterStream(int parameterIndex, Reader reader, int length) {

	}

	@Override
	public void setRef(int parameterIndex, Ref x) {

	}

	@Override
	public void setBlob(int parameterIndex, Blob x) {

	}

	@Override
	public void setClob(int parameterIndex, Clob x) {

	}

	@Override
	public void setArray(int parameterIndex, Array x) {

	}

	@Override
	public ResultSetMetaData getMetaData() {
		return NullResultSetMetaData.INSTANCE;
	}

	@Override
	public void setDate(int parameterIndex, Date x, Calendar cal) {

	}

	@Override
	public void setTime(int parameterIndex, Time x, Calendar cal) {

	}

	@Override
	public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal) {

	}

	@Override
	public void setNull(int parameterIndex, int sqlType, String typeName) {

	}

	@Override
	public void setURL(int parameterIndex, URL x) {

	}

	@Override
	public ParameterMetaData getParameterMetaData() {
		return NullParameterMetaData.INSTANCE;
	}

	@Override
	public void setRowId(int parameterIndex, RowId x) {

	}

	@Override
	public void setNString(int parameterIndex, String value) {

	}

	@Override
	public void setNCharacterStream(int parameterIndex, Reader value, long length) {

	}

	@Override
	public void setNClob(int parameterIndex, NClob value) {

	}

	@Override
	public void setClob(int parameterIndex, Reader reader, long length) {

	}

	@Override
	public void setBlob(int parameterIndex, InputStream inputStream, long length) {

	}

	@Override
	public void setNClob(int parameterIndex, Reader reader, long length) {

	}

	@Override
	public void setSQLXML(int parameterIndex, SQLXML xmlObject) {

	}

	@Override
	public void setObject(int parameterIndex, Object x, int targetSqlType, int scaleOrLength) {

	}

	@Override
	public void setAsciiStream(int parameterIndex, InputStream x, long length) {

	}

	@Override
	public void setBinaryStream(int parameterIndex, InputStream x, long length) {

	}

	@Override
	public void setCharacterStream(int parameterIndex, Reader reader, long length) {

	}

	@Override
	public void setAsciiStream(int parameterIndex, InputStream x) {

	}

	@Override
	public void setBinaryStream(int parameterIndex, InputStream x) {

	}

	@Override
	public void setCharacterStream(int parameterIndex, Reader reader) {

	}

	@Override
	public void setNCharacterStream(int parameterIndex, Reader value) {

	}

	@Override
	public void setClob(int parameterIndex, Reader reader) {

	}

	@Override
	public void setBlob(int parameterIndex, InputStream inputStream) {

	}

	@Override
	public void setNClob(int parameterIndex, Reader reader) {

	}

	@Override
	public void setObject(int parameterIndex, Object x, SQLType targetSqlType, int scaleOrLength) {
	}

	@Override
	public void setObject(int parameterIndex, Object x, SQLType targetSqlType) {
	}

	@Override
	public long executeLargeUpdate() {
		return 0;
	}

}
