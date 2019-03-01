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
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

import dev.megascus.suppressexceptionjdbc.internal.NullResultSet;
import dev.megascus.suppressexceptionjdbc.internal.NullResultSetMetaData;

/**
 * @author megascus
 */
public class SEResultSet implements ResultSet {

	private ResultSet base;

	private SEStatement parent;

	public SEResultSet(SEStatement parent, ResultSet base) {
		if (base == null) {
			this.base = NullResultSet.INSTANCE;
		} else {
			this.base = base;
		}
		this.parent = parent;
	}

	public SEResultSet(ResultSet base) {
		this.base = base;
	}

	public ResultSet getReaulResultSet() {
		return base;
	}

	@Override
	public boolean next() {
		try {
			return base.next();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public void close() {
		try {
			base.close();
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public boolean wasNull() {
		try {
			return base.wasNull();
		} catch (final SQLException ex) {
			return true;
		}
	}

	@Override
	public String getString(int columnIndex) {
		try {
			return base.getString(columnIndex);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public boolean getBoolean(int columnIndex) {
		try {
			return base.getBoolean(columnIndex);
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public byte getByte(int columnIndex) {
		try {
			return base.getByte(columnIndex);
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public short getShort(int columnIndex) {
		try {
			return base.getShort(columnIndex);
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public int getInt(int columnIndex) {
		try {
			return base.getInt(columnIndex);
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public long getLong(int columnIndex) {
		try {
			return base.getLong(columnIndex);
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public float getFloat(int columnIndex) {
		try {
			return base.getFloat(columnIndex);
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public double getDouble(int columnIndex) {
		try {
			return base.getDouble(columnIndex);
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	@Deprecated
	public BigDecimal getBigDecimal(int columnIndex, int scale) {
		try {
			return base.getBigDecimal(columnIndex, scale);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public byte[] getBytes(int columnIndex) {
		try {
			return base.getBytes(columnIndex);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public Date getDate(int columnIndex) {
		try {
			return base.getDate(columnIndex);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public Time getTime(int columnIndex) {
		try {
			return base.getTime(columnIndex);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public Timestamp getTimestamp(int columnIndex) {
		try {
			return base.getTimestamp(columnIndex);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public SEInputStream getAsciiStream(int columnIndex) {
		try {
			InputStream in = base.getAsciiStream(columnIndex);
			if (in != null) {
				return new SEInputStream(in);
			}
		} catch (final SQLException ex) {
		}
		return null;
	}

	@Deprecated
	@Override
	public InputStream getUnicodeStream(int columnIndex) {
		try {
			InputStream in = base.getUnicodeStream(columnIndex);
			if (in != null) {
				return new SEInputStream(in);
			}
		} catch (final SQLException ex) {

		}
		return null;
	}

	@Override
	public SEInputStream getBinaryStream(int columnIndex) {
		try {
			InputStream in = base.getBinaryStream(columnIndex);
			if (in != null) {
				return new SEInputStream(in);
			}
		} catch (final SQLException ex) {
		}
		return null;
	}

	@Override
	public String getString(String columnLabel) {
		try {
			return base.getString(columnLabel);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public boolean getBoolean(String columnLabel) {
		try {
			return base.getBoolean(columnLabel);
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public byte getByte(String columnLabel) {
		try {
			return base.getByte(columnLabel);
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public short getShort(String columnLabel) {
		try {
			return base.getShort(columnLabel);
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public int getInt(String columnLabel) {
		try {
			return base.getInt(columnLabel);
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public long getLong(String columnLabel) {
		try {
			return base.getLong(columnLabel);
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public float getFloat(String columnLabel) {
		try {
			return base.getFloat(columnLabel);
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public double getDouble(String columnLabel) {
		try {
			return base.getDouble(columnLabel);
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Deprecated
	@Override
	public BigDecimal getBigDecimal(String columnLabel, int scale) {
		try {
			return base.getBigDecimal(columnLabel, scale);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public byte[] getBytes(String columnLabel) {
		try {
			return base.getBytes(columnLabel);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public Date getDate(String columnLabel) {
		try {
			return base.getDate(columnLabel);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public Time getTime(String columnLabel) {
		try {
			return base.getTime(columnLabel);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public Timestamp getTimestamp(String columnLabel) {
		try {
			return base.getTimestamp(columnLabel);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public SEInputStream getAsciiStream(String columnLabel) {
		try {
			InputStream in = base.getAsciiStream(columnLabel);
			if (in != null) {
				return new SEInputStream(in);
			}
		} catch (final SQLException ex) {
		}
		return null;
	}

	@Deprecated
	@Override
	public SEInputStream getUnicodeStream(String columnLabel) {
		try {
			InputStream in = base.getUnicodeStream(columnLabel);
			if (in != null) {
				return new SEInputStream(in);
			}
		} catch (final SQLException ex) {
		}
		return null;
	}

	@Override
	public SEInputStream getBinaryStream(String columnLabel) {
		try {
			InputStream in = base.getBinaryStream(columnLabel);
			if (in != null) {
				return new SEInputStream(in);
			}
		} catch (final SQLException ex) {
		}
		return null;
	}

	@Override
	public SQLWarning getWarnings() {
		try {
			return base.getWarnings();
		} catch (final SQLException ex) {
			return new SQLWarning(ex);
		}
	}

	@Override
	public void clearWarnings() {
		try {
			base.clearWarnings();
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public String getCursorName() {
		try {
			return base.getCursorName();
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public SEResultSetMetaData getMetaData() {
		try {
			return new SEResultSetMetaData(base.getMetaData());
		} catch (final SQLException ex) {
			return new SEResultSetMetaData(NullResultSetMetaData.INSTANCE);
		}
	}

	@Override
	public Object getObject(int columnIndex) {
		try {
			return base.getObject(columnIndex);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public Object getObject(String columnLabel) {
		try {
			return base.getObject(columnLabel);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public int findColumn(String columnLabel) {
		try {
			return base.findColumn(columnLabel);
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public SEReader getCharacterStream(int columnIndex) {
		try {
			Reader reader = base.getCharacterStream(columnIndex);
			if (reader != null) {
				return new SEReader(reader);
			}
		} catch (final SQLException ex) {
		}
		return null;
	}

	@Override
	public SEReader getCharacterStream(String columnLabel) {
		try {
			Reader reader = base.getCharacterStream(columnLabel);
			if (reader != null) {
				return new SEReader(reader);
			}
		} catch (final SQLException ex) {
		}
		return null;
	}

	@Override
	public BigDecimal getBigDecimal(int columnIndex) {
		try {
			return base.getBigDecimal(columnIndex);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public BigDecimal getBigDecimal(String columnLabel) {
		try {
			return base.getBigDecimal(columnLabel);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public boolean isBeforeFirst() {
		try {
			return base.isBeforeFirst();
		} catch (final SQLException ex) {
			return true;
		}
	}

	@Override
	public boolean isAfterLast() {
		try {
			return base.isAfterLast();
		} catch (final SQLException ex) {
			return true;
		}
	}

	@Override
	public boolean isFirst() {
		try {
			return base.isFirst();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean isLast() {
		try {
			return base.isLast();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public void beforeFirst() {
		try {
			base.beforeFirst();
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void afterLast() {
		try {
			base.afterLast();
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public boolean first() {
		try {
			return base.first();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean last() {
		try {
			return base.last();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public int getRow() {
		try {
			return base.getRow();
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public boolean absolute(int row) {
		try {
			return base.absolute(row);
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean relative(int rows) {
		try {
			return base.relative(rows);
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean previous() {
		try {
			return base.previous();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public void setFetchDirection(int direction) {
		try {
			base.setFetchDirection(direction);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public int getFetchDirection() {
		try {
			return base.getFetchDirection();
		} catch (final SQLException ex) {
			return ResultSet.FETCH_FORWARD;
		}
	}

	@Override
	public void setFetchSize(int rows) {
		try {
			base.setFetchSize(rows);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public int getFetchSize() {
		try {
			return base.getFetchSize();
		} catch (final SQLException ex) {
			return 1;
		}
	}

	@Override
	public int getType() {
		try {
			return base.getType();
		} catch (final SQLException ex) {
			return ResultSet.TYPE_FORWARD_ONLY;
		}
	}

	@Override
	public int getConcurrency() {
		try {
			return base.getConcurrency();
		} catch (final SQLException ex) {
			return ResultSet.CONCUR_READ_ONLY;
		}
	}

	@Override
	public boolean rowUpdated() {
		try {
			return base.rowUpdated();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean rowInserted() {
		try {
			return base.rowInserted();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean rowDeleted() {
		try {
			return base.rowDeleted();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public void updateNull(int columnIndex) {
		try {
			base.updateNull(columnIndex);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateBoolean(int columnIndex, boolean x) {
		try {
			base.updateBoolean(columnIndex, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateByte(int columnIndex, byte x) {
		try {
			base.updateByte(columnIndex, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateShort(int columnIndex, short x) {
		try {
			base.updateShort(columnIndex, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateInt(int columnIndex, int x) {
		try {
			base.updateInt(columnIndex, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateLong(int columnIndex, long x) {
		try {
			base.updateLong(columnIndex, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateFloat(int columnIndex, float x) {
		try {
			base.updateFloat(columnIndex, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateDouble(int columnIndex, double x) {
		try {
			base.updateDouble(columnIndex, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateBigDecimal(int columnIndex, BigDecimal x) {
		try {
			base.updateBigDecimal(columnIndex, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateString(int columnIndex, String x) {
		try {
			base.updateString(columnIndex, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateBytes(int columnIndex, byte[] x) {
		try {
			base.updateBytes(columnIndex, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateDate(int columnIndex, Date x) {
		try {
			base.updateDate(columnIndex, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateTime(int columnIndex, Time x) {
		try {
			base.updateTime(columnIndex, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateTimestamp(int columnIndex, Timestamp x) {
		try {
			base.updateTimestamp(columnIndex, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateAsciiStream(int columnIndex, InputStream x, int length) {
		try {
			base.updateAsciiStream(columnIndex, x, length);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateBinaryStream(int columnIndex, InputStream x, int length) {
		try {
			base.updateBinaryStream(columnIndex, x, length);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateCharacterStream(int columnIndex, Reader x, int length) {
		try {
			base.updateCharacterStream(columnIndex, x, length);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateObject(int columnIndex, Object x, int scaleOrLength) {
		try {
			base.updateObject(columnIndex, x, scaleOrLength);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateObject(int columnIndex, Object x) {
		try {
			base.updateObject(columnIndex, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateNull(String columnLabel) {
		try {
			base.updateNull(columnLabel);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateBoolean(String columnLabel, boolean x) {
		try {
			base.updateBoolean(columnLabel, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateByte(String columnLabel, byte x) {
		try {
			base.updateByte(columnLabel, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateShort(String columnLabel, short x) {
		try {
			base.updateShort(columnLabel, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateInt(String columnLabel, int x) {
		try {
			base.updateInt(columnLabel, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateLong(String columnLabel, long x) {
		try {
			base.updateLong(columnLabel, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateFloat(String columnLabel, float x) {
		try {
			base.updateFloat(columnLabel, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateDouble(String columnLabel, double x) {
		try {
			base.updateDouble(columnLabel, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateBigDecimal(String columnLabel, BigDecimal x) {
		try {
			base.updateBigDecimal(columnLabel, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateString(String columnLabel, String x) {
		try {
			base.updateString(columnLabel, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateBytes(String columnLabel, byte[] x) {
		try {
			base.updateBytes(columnLabel, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateDate(String columnLabel, Date x) {
		try {
			base.updateDate(columnLabel, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateTime(String columnLabel, Time x) {
		try {
			base.updateTime(columnLabel, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateTimestamp(String columnLabel, Timestamp x) {
		try {
			base.updateTimestamp(columnLabel, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateAsciiStream(String columnLabel, InputStream x, int length) {
		try {
			base.updateAsciiStream(columnLabel, x, length);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateBinaryStream(String columnLabel, InputStream x, int length) {
		try {
			base.updateBinaryStream(columnLabel, x, length);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateCharacterStream(String columnLabel, Reader reader, int length) {
		try {
			base.updateCharacterStream(columnLabel, reader, length);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateObject(String columnLabel, Object x, int scaleOrLength) {
		try {
			base.updateObject(columnLabel, x, scaleOrLength);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateObject(String columnLabel, Object x) {
		try {
			base.updateObject(columnLabel, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void insertRow() {
		try {
			base.insertRow();
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateRow() {
		try {
			base.updateRow();
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void deleteRow() {
		try {
			base.deleteRow();
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void refreshRow() {
		try {
			base.refreshRow();
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void cancelRowUpdates() {
		try {
			base.cancelRowUpdates();
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void moveToInsertRow() {
		try {
			base.moveToInsertRow();
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void moveToCurrentRow() {
		try {
			base.moveToCurrentRow();
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public SEStatement getStatement() {
		return parent;
	}

	@Override
	public Object getObject(int columnIndex, Map<String, Class<?>> map) {
		try {
			return base.getObject(columnIndex, map);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public Ref getRef(int columnIndex) {
		try {
			return base.getRef(columnIndex);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public Blob getBlob(int columnIndex) {
		try {
			return base.getBlob(columnIndex);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public Clob getClob(int columnIndex) {
		try {
			return base.getClob(columnIndex);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public Array getArray(int columnIndex) {
		try {
			return base.getArray(columnIndex);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public Object getObject(String columnLabel, Map<String, Class<?>> map) {
		try {
			return base.getObject(columnLabel, map);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public Ref getRef(String columnLabel) {
		try {
			return base.getRef(columnLabel);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public Blob getBlob(String columnLabel) {
		try {
			return base.getBlob(columnLabel);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public Clob getClob(String columnLabel) {
		try {
			return base.getClob(columnLabel);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public Array getArray(String columnLabel) {
		try {
			return base.getArray(columnLabel);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public Date getDate(int columnIndex, Calendar cal) {
		try {
			return base.getDate(columnIndex, cal);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public Date getDate(String columnLabel, Calendar cal) {
		try {
			return base.getDate(columnLabel, cal);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public Time getTime(int columnIndex, Calendar cal) {
		try {
			return base.getTime(columnIndex, cal);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public Time getTime(String columnLabel, Calendar cal) {
		try {
			return base.getTime(columnLabel, cal);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public Timestamp getTimestamp(int columnIndex, Calendar cal) {
		try {
			return base.getTimestamp(columnIndex, cal);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public Timestamp getTimestamp(String columnLabel, Calendar cal) {
		try {
			return base.getTimestamp(columnLabel, cal);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public URL getURL(int columnIndex) {
		try {
			return base.getURL(columnIndex);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public URL getURL(String columnLabel) {
		try {
			return base.getURL(columnLabel);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public void updateRef(int columnIndex, Ref x) {
		try {
			base.updateRef(columnIndex, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateRef(String columnLabel, Ref x) {
		try {
			base.updateRef(columnLabel, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateBlob(int columnIndex, Blob x) {
		try {
			base.updateBlob(columnIndex, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateBlob(String columnLabel, Blob x) {
		try {
			base.updateBlob(columnLabel, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateClob(int columnIndex, Clob x) {
		try {
			base.updateClob(columnIndex, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateClob(String columnLabel, Clob x) {
		try {
			base.updateClob(columnLabel, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateArray(int columnIndex, Array x) {
		try {
			base.updateArray(columnIndex, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateArray(String columnLabel, Array x) {
		try {
			base.updateArray(columnLabel, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public RowId getRowId(int columnIndex) {
		try {
			return base.getRowId(columnIndex);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public RowId getRowId(String columnLabel) {
		try {
			return base.getRowId(columnLabel);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public void updateRowId(int columnIndex, RowId x) {
		try {
			base.updateRowId(columnIndex, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateRowId(String columnLabel, RowId x) {
		try {
			base.updateRowId(columnLabel, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public int getHoldability() {
		try {
			return base.getHoldability();
		} catch (final SQLException ex) {
			return ResultSet.CLOSE_CURSORS_AT_COMMIT;
		}
	}

	@Override
	public boolean isClosed() {
		try {
			return base.isClosed();
		} catch (final SQLException ex) {
			return true;
		}
	}

	@Override
	public void updateNString(int columnIndex, String nString) {
		try {
			base.updateNString(columnIndex, nString);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateNString(String columnLabel, String nString) {
		try {
			base.updateNString(columnLabel, nString);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateNClob(int columnIndex, NClob nClob) {
		try {
			base.updateNClob(columnIndex, nClob);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateNClob(String columnLabel, NClob nClob) {
		try {
			base.updateNClob(columnLabel, nClob);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public SENClob getNClob(int columnIndex) {
		try {
			NClob nclob = base.getNClob(columnIndex);
			if (nclob != null) {
				return new SENClob(nclob);
			}
		} catch (final SQLException ex) {
		}
		return null;
	}

	@Override
	public SENClob getNClob(String columnLabel) {
		try {
			NClob nclob = base.getNClob(columnLabel);
			if (nclob != null) {
				return new SENClob(nclob);
			}
		} catch (final SQLException ex) {
		}
		return null;
	}

	@Override
	public SESQLXML getSQLXML(int columnIndex) {
		try {
			SQLXML sqlxml = base.getSQLXML(columnIndex);
			if (sqlxml != null) {
				return new SESQLXML(sqlxml);
			}
		} catch (final SQLException ex) {
		}
		return null;
	}

	@Override
	public SESQLXML getSQLXML(String columnLabel) {
		try {
			SQLXML sqlxml = base.getSQLXML(columnLabel);
			if (sqlxml != null) {
				return new SESQLXML(sqlxml);
			}
		} catch (final SQLException ex) {
		}
		return null;
	}

	@Override
	public void updateSQLXML(int columnIndex, SQLXML xmlObject) {
		try {
			base.updateSQLXML(columnIndex, xmlObject);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateSQLXML(String columnLabel, SQLXML xmlObject) {
		try {
			base.updateSQLXML(columnLabel, xmlObject);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public String getNString(int columnIndex) {
		try {
			return base.getNString(columnIndex);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public String getNString(String columnLabel) {
		try {
			return base.getNString(columnLabel);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public SEReader getNCharacterStream(int columnIndex) {
		try {
			Reader re = base.getNCharacterStream(columnIndex);
			if (re != null) {
				return new SEReader(re);
			}
		} catch (final SQLException ex) {
		}
		return null;
	}

	@Override
	public SEReader getNCharacterStream(String columnLabel) {
		try {
			Reader re = base.getNCharacterStream(columnLabel);
			if (re != null) {
				return new SEReader(re);
			}
		} catch (final SQLException ex) {
		}
		return null;
	}

	@Override
	public void updateNCharacterStream(int columnIndex, Reader x, long length) {
		try {
			base.updateNCharacterStream(columnIndex, x, length);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateNCharacterStream(String columnLabel, Reader reader, long length) {
		try {
			base.updateNCharacterStream(columnLabel, reader, length);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateAsciiStream(int columnIndex, InputStream x, long length) {
		try {
			base.updateAsciiStream(columnIndex, x, length);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateBinaryStream(int columnIndex, InputStream x, long length) {
		try {
			base.updateBinaryStream(columnIndex, x, length);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateCharacterStream(int columnIndex, Reader x, long length) {
		try {
			base.updateCharacterStream(columnIndex, x, length);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateAsciiStream(String columnLabel, InputStream x, long length) {
		try {
			base.updateAsciiStream(columnLabel, x, length);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateBinaryStream(String columnLabel, InputStream x, long length) {
		try {
			base.updateBinaryStream(columnLabel, x, length);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateCharacterStream(String columnLabel, Reader reader, long length) {
		try {
			base.updateCharacterStream(columnLabel, reader, length);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateBlob(int columnIndex, InputStream inputStream, long length) {
		try {
			base.updateBlob(columnIndex, inputStream, length);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateBlob(String columnLabel, InputStream inputStream, long length) {
		try {
			base.updateBlob(columnLabel, inputStream, length);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateClob(int columnIndex, Reader reader, long length) {
		try {
			base.updateClob(columnIndex, reader, length);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateClob(String columnLabel, Reader reader, long length) {
		try {
			base.updateClob(columnLabel, reader, length);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateNClob(int columnIndex, Reader reader, long length) {
		try {
			base.updateNClob(columnIndex, reader, length);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateNClob(String columnLabel, Reader reader, long length) {
		try {
			base.updateNClob(columnLabel, reader, length);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateNCharacterStream(int columnIndex, Reader x) {
		try {
			base.updateNCharacterStream(columnIndex, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateNCharacterStream(String columnLabel, Reader reader) {
		try {
			base.updateNCharacterStream(columnLabel, reader);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateAsciiStream(int columnIndex, InputStream x) {
		try {
			base.updateAsciiStream(columnIndex, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateBinaryStream(int columnIndex, InputStream x) {
		try {
			base.updateBinaryStream(columnIndex, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateCharacterStream(int columnIndex, Reader x) {
		try {
			base.updateCharacterStream(columnIndex, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateAsciiStream(String columnLabel, InputStream x) {
		try {
			base.updateAsciiStream(columnLabel, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateBinaryStream(String columnLabel, InputStream x) {
		try {
			base.updateBinaryStream(columnLabel, x);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateCharacterStream(String columnLabel, Reader reader) {
		try {
			base.updateCharacterStream(columnLabel, reader);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateBlob(int columnIndex, InputStream inputStream) {
		try {
			base.updateBlob(columnIndex, inputStream);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateBlob(String columnLabel, InputStream inputStream) {
		try {
			base.updateBlob(columnLabel, inputStream);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateClob(int columnIndex, Reader reader) {
		try {
			base.updateClob(columnIndex, reader);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateClob(String columnLabel, Reader reader) {
		try {
			base.updateClob(columnLabel, reader);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateNClob(int columnIndex, Reader reader) {
		try {
			base.updateNClob(columnIndex, reader);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateNClob(String columnLabel, Reader reader) {
		try {
			base.updateNClob(columnLabel, reader);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public <T> T getObject(int columnIndex, Class<T> type) {
		try {
			return base.getObject(columnIndex, type);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public <T> T getObject(String columnLabel, Class<T> type) {
		try {
			return base.getObject(columnLabel, type);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public void updateObject(int columnIndex, Object x, SQLType targetSqlType, int scaleOrLength) {
		try {
			base.updateObject(columnIndex, x, targetSqlType, scaleOrLength);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateObject(String columnLabel, Object x, SQLType targetSqlType, int scaleOrLength) {
		try {
			base.updateObject(columnLabel, x, targetSqlType, scaleOrLength);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateObject(int columnIndex, Object x, SQLType targetSqlType) {
		try {
			base.updateObject(columnIndex, x, targetSqlType);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void updateObject(String columnLabel, Object x, SQLType targetSqlType) {
		try {
			base.updateObject(columnLabel, x, targetSqlType);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public <T> T unwrap(Class<T> iface) {
		try {
			return base.unwrap(iface);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) {
		try {
			return base.isWrapperFor(iface);
		} catch (final SQLException ex) {
			return false;
		}
	}

}
