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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

import dev.megascus.suppressexceptionjdbc.internal.NullResultSet;

/**
 * @author megascus
 */
public class SEStatement implements Statement {

	protected SEConnection conn;

	protected Statement base;

	public SEStatement(SEConnection conn, Statement base) {
		this.base = base;
		this.conn = conn;
	}

	public Statement getRealStatement() {
		return base;
	}

	@Override
	public final SQLWarning getWarnings() {
		try {
			return base.getWarnings();
		} catch (final SQLException s) {
			return null;
		}
	}

	@Override
	public final int executeUpdate(String sql, String[] columnNames) {
		try {
			return base.executeUpdate(sql, columnNames);
		} catch (final SQLException s) {
			return 0;
		}
	}

	@Override
	public final boolean execute(String sql, String[] columnNames) {
		try {
			return base.execute(sql, columnNames);
		} catch (final SQLException s) {
			return false;
		}
	}

	@Override
	public final void setMaxRows(int max) {
		try {
			base.setMaxRows(max);
		} catch (final SQLException s) {
			return;
		}
	}

	@Override
	public final boolean getMoreResults() {
		try {
			return base.getMoreResults();
		} catch (final SQLException s) {
			return false;
		}
	}

	@Override
	public final void clearWarnings() {
		try {
			base.clearWarnings();
		} catch (final SQLException s) {
			return;
		}
	}

	@Override
	public final void addBatch(String sql) {
		try {
			base.addBatch(sql);
		} catch (final SQLException s) {
			return;
		}
	}

	@Override
	public final int getResultSetType() {
		try {
			return base.getResultSetType();
		} catch (final SQLException s) {
			return Statement.KEEP_CURRENT_RESULT;
		}
	}

	@Override
	public final void clearBatch() {
		try {
			base.clearBatch();
		} catch (final SQLException s) {
			return;
		}
	}

	@Override
	public final void setFetchDirection(int direction) {
		try {
			base.setFetchDirection(direction);
		} catch (final SQLException s) {
			return;
		}
	}

	@Override
	public final int[] executeBatch() {
		try {
			return base.executeBatch();
		} catch (final SQLException s) {
			return new int[0];
		}
	}

	@Override
	public final void setFetchSize(int rows) {
		try {
			base.setFetchSize(rows);
		} catch (final SQLException s) {
			return;
		}
	}

	@Override
	public final int getQueryTimeout() {
		try {
			return base.getQueryTimeout();
		} catch (final SQLException s) {
			return -1;
		}
	}

	@Override
	public final SEConnection getConnection() {
		return conn;
	}

	@Override
	public final <T> T unwrap(Class<T> iface) {
		try {
			return base.unwrap(iface);
		} catch (final SQLException e) {
			return null;
		}
	}

	@Override
	public final SEResultSet executeQuery(String sql) {
		try {
			return new SEResultSet(base.executeQuery(sql));
		} catch (final SQLException e) {
			return new SEResultSet(new NullResultSet(base));
		}
	}

	@Override
	public final boolean isWrapperFor(Class<?> iface) {
		try {
			return base.isWrapperFor(iface);
		} catch (final SQLException e) {
			return false;
		}
	}

	@Override
	public final int executeUpdate(String sql) {
		try {
			return base.executeUpdate(sql);
		} catch (final SQLException e) {
			return 0;
		}
	}

	@Override
	public final void close() {
		try {
			base.close();
		} catch (final SQLException e) {
			return;
		}
	}

	@Override
	public final int getMaxFieldSize() {
		try {
			return base.getMaxFieldSize();
		} catch (final SQLException e) {
			return 0;
		}
	}

	@Override
	public final void setMaxFieldSize(int max) {
		try {
			base.setMaxFieldSize(max);
		} catch (final SQLException e) {
			return;
		}
	}

	@Override
	public final int getMaxRows() {
		try {
			return base.getMaxRows();
		} catch (final SQLException e) {
			return 0;
		}
	}

	@Override
	public final void setEscapeProcessing(boolean enable) {
		try {
			base.setEscapeProcessing(enable);
		} catch (final SQLException e) {
			return;
		}
	}

	@Override
	public final void setQueryTimeout(int seconds) {
		try {
			base.setQueryTimeout(seconds);
		} catch (final SQLException e) {
			return;
		}
	}

	@Override
	public final void cancel() {
		try {
			base.cancel();
		} catch (final SQLException e) {
			return;
		}
	}

	@Override
	public final void setCursorName(String name) {
		try {
			base.setCursorName(name);
		} catch (final SQLException e) {
			return;
		}
	}

	@Override
	public final boolean execute(String sql) {
		try {
			return base.execute(sql);
		} catch (final SQLException e) {
			return false;
		}
	}

	@Override
	public final ResultSet getResultSet() {
		try {
			return new SEResultSet(this, base.getResultSet());
		} catch (final SQLException e) {
			return new SEResultSet(new NullResultSet(this));
		}
	}

	@Override
	public final int getUpdateCount() {
		try {
			return base.getUpdateCount();
		} catch (final SQLException e) {
			return 0;
		}
	}

	@Override
	public final int getFetchDirection() {
		try {
			return base.getFetchDirection();
		} catch (final SQLException e) {
			return ResultSet.FETCH_FORWARD;
		}
	}

	@Override
	public final int getFetchSize() {
		try {
			return base.getFetchSize();
		} catch (final SQLException e) {
			return 1;
		}
	}

	@Override
	public final int getResultSetConcurrency() {
		try {
			return base.getResultSetConcurrency();
		} catch (final SQLException e) {
			return ResultSet.CONCUR_READ_ONLY;
		}
	}

	@Override
	public final boolean getMoreResults(int current) {
		try {
			return base.getMoreResults(current);
		} catch (final SQLException e) {
			return false;
		}
	}

	@Override
	public final SEResultSet getGeneratedKeys() {
		try {
			return new SEResultSet(this, base.getGeneratedKeys());
		} catch (final SQLException e) {
			return new SEResultSet(new NullResultSet(this));
		}
	}

	@Override
	public final int executeUpdate(String sql, int autoGeneratedKeys) {
		try {
			return base.executeUpdate(sql, autoGeneratedKeys);
		} catch (final SQLException e) {
			return 0;
		}
	}

	@Override
	public final int executeUpdate(String sql, int[] columnIndexes) {
		try {
			return base.executeUpdate(sql, columnIndexes);
		} catch (final SQLException e) {
			return 0;
		}
	}

	@Override
	public final boolean execute(String sql, int autoGeneratedKeys) {
		try {
			return base.execute(sql, autoGeneratedKeys);
		} catch (final SQLException e) {
			return false;
		}
	}

	@Override
	public final boolean execute(String sql, int[] columnIndexes) {
		try {
			return base.execute(sql, columnIndexes);
		} catch (final SQLException e) {
			return false;
		}
	}

	@Override
	public final int getResultSetHoldability() {
		try {
			return base.getResultSetHoldability();
		} catch (final SQLException e) {
			return ResultSet.CLOSE_CURSORS_AT_COMMIT;
		}
	}

	@Override
	public final boolean isClosed() {
		try {
			return base.isClosed();
		} catch (final SQLException e) {
			return true;
		}
	}

	@Override
	public final void setPoolable(boolean poolable) {
		try {
			base.setPoolable(poolable);
		} catch (final SQLException e) {
			return;
		}
	}

	@Override
	public final boolean isPoolable() {
		try {
			return base.isPoolable();
		} catch (final SQLException e) {
			return false;
		}
	}

	@Override
	public final void closeOnCompletion() {
		try {
			base.closeOnCompletion();
		} catch (final SQLException e) {
			return;
		}
	}

	@Override
	public final boolean isCloseOnCompletion() {
		try {
			return base.isCloseOnCompletion();
		} catch (final SQLException e) {
			return false;
		}
	}

	@Override
	public final long getLargeUpdateCount() {
		try {
			return base.getLargeUpdateCount();
		} catch (final SQLException e) {
			return 0L;
		}
	}

	@Override
	public final void setLargeMaxRows(long max) {
		try {
			base.setLargeMaxRows(max);
		} catch (final SQLException e) {
			return;
		}
	}

	@Override
	public final long getLargeMaxRows() {
		try {
			return base.getLargeMaxRows();
		} catch (final SQLException e) {
			return 0L;
		}
	}

	@Override
	public final long[] executeLargeBatch() {
		try {
			return base.executeLargeBatch();
		} catch (final SQLException e) {
			return new long[0];
		}
	}

	@Override
	public final long executeLargeUpdate(String sql) {
		try {
			return base.executeLargeUpdate(sql);
		} catch (final SQLException e) {
			return 0L;
		}
	}

	@Override
	public final long executeLargeUpdate(String sql, int autoGeneratedKeys) {
		try {
			return base.executeLargeUpdate(sql, autoGeneratedKeys);
		} catch (final SQLException e) {
			return 0L;
		}
	}

	@Override
	public final long executeLargeUpdate(String sql, int[] columnIndexes) {
		try {
			return base.executeLargeUpdate(sql, columnIndexes);
		} catch (final SQLException e) {
			return 0L;
		}
	}

	@Override
	public final long executeLargeUpdate(String sql, String[] columnNames) {
		try {
			return base.executeLargeUpdate(sql, columnNames);
		} catch (final SQLException e) {
			return 0L;
		}
	}

}
