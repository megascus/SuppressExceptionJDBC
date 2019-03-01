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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Savepoint;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import dev.megascus.suppressexceptionjdbc.internal.NullArray;
import dev.megascus.suppressexceptionjdbc.internal.NullBlob;
import dev.megascus.suppressexceptionjdbc.internal.NullCallableStatement;
import dev.megascus.suppressexceptionjdbc.internal.NullClob;
import dev.megascus.suppressexceptionjdbc.internal.NullDatabaseMetaData;
import dev.megascus.suppressexceptionjdbc.internal.NullNClob;
import dev.megascus.suppressexceptionjdbc.internal.NullPreparedStatement;
import dev.megascus.suppressexceptionjdbc.internal.NullSQLEXML;
import dev.megascus.suppressexceptionjdbc.internal.NullSavepoint;
import dev.megascus.suppressexceptionjdbc.internal.NullStatement;
import dev.megascus.suppressexceptionjdbc.internal.NullStruct;

/**
 * @author megascus
 */
public class SEConnection implements Connection {

	private final Connection base;
	private final SEDriver driver; //maybe null.
	private final String url; //maybe null.

	public SEConnection(Connection base) {
		this.driver = null;
		this.base = base;
		this.url = null;
	}

	SEConnection(SEDriver driver, Connection base, String url) {
		this.driver = driver;
		this.base = base;
		this.url = url;
	}

	public Connection getRealConnection() {
		return base;
	}

	public String getURL() {
		return url;
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

	@Override
	public SEStatement createStatement() {
		try {
			return new SEStatement(this, base.createStatement());
		} catch (final SQLException ex) {
			return new SEStatement(this, new NullStatement(this));
		}
	}

	@Override
	public SEPreparedStatement prepareStatement(String sql) {
		try {
			return new SEPreparedStatement(this, base.prepareStatement(sql));
		} catch (final SQLException ex) {
			return new SEPreparedStatement(this, new NullPreparedStatement(this));
		}
	}

	@Override
	public SECallableStatement prepareCall(String sql) {
		try {
			return new SECallableStatement(this, base.prepareCall(sql));
		} catch (final SQLException ex) {
			return new SECallableStatement(this, new NullCallableStatement(this));
		}
	}

	@Override
	public String nativeSQL(String sql) {
		try {
			return base.nativeSQL(sql);
		} catch (final SQLException ex) {
			return sql;
		}
	}

	@Override
	public void setAutoCommit(boolean autoCommit) {
		try {
			base.setAutoCommit(autoCommit);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public boolean getAutoCommit() {
		try {
			return base.getAutoCommit();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public void commit() {
		try {
			base.commit();
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void rollback() {
		try {
			base.rollback();
		} catch (final SQLException ex) {
			return;
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
	public boolean isClosed() {
		try {
			return base.isClosed();
		} catch (final SQLException ex) {
			return true;
		}
	}

	@Override
	public SEDatabaseMetaData getMetaData() {
		try {
			return new SEDatabaseMetaData(driver, this, base.getMetaData());
		} catch (final SQLException ex) {
			return new SEDatabaseMetaData(driver, this, new NullDatabaseMetaData(driver, this, url));
		}
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		try {
			base.setReadOnly(readOnly);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public boolean isReadOnly() {
		try {
			return base.isReadOnly();
		} catch (final SQLException ex) {
			return true;
		}
	}

	@Override
	public void setCatalog(String catalog) {
		try {
			base.setCatalog(catalog);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public String getCatalog() {
		try {
			return base.getCatalog();
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public void setTransactionIsolation(int level) {
		try {
			base.setTransactionIsolation(level);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public int getTransactionIsolation() {
		try {
			return base.getTransactionIsolation();
		} catch (final SQLException ex) {
			return Connection.TRANSACTION_NONE;
		}
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
	public SEStatement createStatement(int resultSetType, int resultSetConcurrency) {
		try {
			return new SEStatement(this, base.createStatement(resultSetType, resultSetConcurrency));
		} catch (final SQLException ex) {
			return new SEStatement(this, new NullStatement(this));
		}
	}

	@Override
	public SEPreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) {
		try {
			return new SEPreparedStatement(this, base.prepareStatement(sql, resultSetType, resultSetConcurrency));
		} catch (final SQLException ex) {
			return new SEPreparedStatement(this, new NullPreparedStatement(this));
		}
	}

	@Override
	public SECallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) {
		try {
			return new SECallableStatement(this, base.prepareCall(sql, resultSetType, resultSetConcurrency));
		} catch (final SQLException ex) {
			return new SECallableStatement(this, new NullCallableStatement(this));
		}
	}

	@Override
	public Map<String, Class<?>> getTypeMap() {
		try {
			return base.getTypeMap();
		} catch (final SQLException ex) {
			return Collections.emptyMap();
		}
	}

	@Override
	public void setTypeMap(Map<String, Class<?>> map) {
		try {
			base.setTypeMap(map);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void setHoldability(int holdability) {
		try {
			base.setHoldability(holdability);
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
	public SESavepoint setSavepoint() {
		try {
			return new SESavepoint(base.setSavepoint());
		} catch (final SQLException ex) {
			return new SESavepoint(NullSavepoint.INSTANCE);
		}
	}

	@Override
	public SESavepoint setSavepoint(String name) {
		try {
			return new SESavepoint(base.setSavepoint(name));
		} catch (final SQLException ex) {
			return new SESavepoint(NullSavepoint.INSTANCE);
		}
	}

	@Override
	public void rollback(Savepoint savepoint) {
		try {
			base.rollback(savepoint);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void releaseSavepoint(Savepoint savepoint) {
		try {
			base.releaseSavepoint(savepoint);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public SEStatement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) {
		try {
			return new SEStatement(this,
					base.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability));
		} catch (final SQLException ex) {
			return new SEStatement(this, new NullStatement(this));
		}
	}

	@Override
	public SEPreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency,
			int resultSetHoldability) {
		try {
			return new SEPreparedStatement(this,
					base.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability));
		} catch (final SQLException ex) {
			return new SEPreparedStatement(this, new NullPreparedStatement(this));
		}
	}

	@Override
	public SECallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency,
			int resultSetHoldability) {
		try {
			return new SECallableStatement(this,
					base.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability));
		} catch (final SQLException ex) {
			return new SECallableStatement(this, new NullCallableStatement(this));
		}
	}

	@Override
	public SEPreparedStatement prepareStatement(String sql, int autoGeneratedKeys) {
		try {
			return new SEPreparedStatement(this, base.prepareStatement(sql, autoGeneratedKeys));
		} catch (final SQLException ex) {
			return new SEPreparedStatement(this, new NullPreparedStatement(this));
		}
	}

	@Override
	public SEPreparedStatement prepareStatement(String sql, int[] columnIndexes) {
		try {
			return new SEPreparedStatement(this, base.prepareStatement(sql, columnIndexes));
		} catch (final SQLException ex) {
			return new SEPreparedStatement(this, new NullPreparedStatement(this));
		}
	}

	@Override
	public SEPreparedStatement prepareStatement(String sql, String[] columnNames) {
		try {
			return new SEPreparedStatement(this, base.prepareStatement(sql, columnNames));
		} catch (final SQLException ex) {
			return new SEPreparedStatement(this, new NullPreparedStatement(this));
		}
	}

	@Override
	public SEClob createClob() {
		try {
			return new SEClob(base.createClob());
		} catch (final SQLException ex) {
			return new SEClob(NullClob.INSTANCE);
		}
	}

	@Override
	public SEBlob createBlob() {
		try {
			return new SEBlob(base.createBlob());
		} catch (final SQLException ex) {
			return new SEBlob(NullBlob.INSTANCE);
		}
	}

	@Override
	public SENClob createNClob() {
		try {
			return new SENClob(base.createNClob());
		} catch (final SQLException ex) {
			return new SENClob(NullNClob.INSTANCE);
		}
	}

	@Override
	public SESQLXML createSQLXML() {
		try {
			return new SESQLXML(base.createSQLXML());
		} catch (final SQLException ex) {
			return new SESQLXML(NullSQLEXML.INSTANCE);
		}
	}

	@Override
	public boolean isValid(int timeout) {
		try {
			return base.isValid(timeout);
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public void setClientInfo(String name, String value) {
		try {
			base.setClientInfo(name, value);
		} catch (final SQLClientInfoException ex) {
			return;
		}
	}

	@Override
	public void setClientInfo(Properties properties) {
		try {
			base.setClientInfo(properties);
		} catch (final SQLClientInfoException ex) {
			return;
		}
	}

	@Override
	public String getClientInfo(String name) {
		try {
			return base.getClientInfo(name);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public Properties getClientInfo() {
		try {
			return base.getClientInfo();
		} catch (final SQLException ex) {
			return new Properties();
		}
	}

	@Override
	public SEArray createArrayOf(String typeName, Object[] elements) {
		try {
			return new SEArray(base.createArrayOf(typeName, elements));
		} catch (final SQLException ex) {
			return new SEArray(NullArray.INSTANCE);
		}
	}

	@Override
	public SEStruct createStruct(String typeName, Object[] attributes) {
		try {
			return new SEStruct(base.createStruct(typeName, attributes), typeName, attributes);
		} catch (final SQLException ex) {
			return new SEStruct(new NullStruct(typeName, attributes), typeName, attributes);
		}

	}

	@Override
	public void setSchema(String schema) {
		try {
			base.setSchema(schema);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public String getSchema() {
		try {
			return base.getSchema();
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public void abort(Executor executor) {
		try {
			base.abort(executor);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public void setNetworkTimeout(Executor executor, int milliseconds) {
		try {
			base.setNetworkTimeout(executor, milliseconds);
		} catch (final SQLException ex) {
			return;
		}
	}

	@Override
	public int getNetworkTimeout() {
		try {
			return base.getNetworkTimeout();
		} catch (final SQLException ex) {
			return -1;
		}
	}

}
