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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLWarning;
import java.sql.Statement;

/**
 * @author megascus
 */
public class NullStatement implements Statement {

	private final Connection c;

	public NullStatement(Connection c) {
		this.c = c;
	}

	@Override
	public ResultSet executeQuery(String sql) {
		return new NullResultSet(this);
	}

	@Override
	public int executeUpdate(String sql) {
		return 0;
	}

	@Override
	public void close() {
	}

	@Override
	public int getMaxFieldSize() {
		return 0;
	}

	@Override
	public void setMaxFieldSize(int max) {
	}

	@Override
	public int getMaxRows() {
		return 0;
	}

	@Override
	public void setMaxRows(int max) {
	}

	@Override
	public void setEscapeProcessing(boolean enable) {
	}

	@Override
	public int getQueryTimeout() {
		return -1;
	}

	@Override
	public void setQueryTimeout(int seconds) {
	}

	@Override
	public void cancel() {
	}

	@Override
	public SQLWarning getWarnings() {
		return null;
	}

	@Override
	public void clearWarnings() {
	}

	@Override
	public void setCursorName(String name) {
	}

	@Override
	public boolean execute(String sql) {
		return false;
	}

	@Override
	public ResultSet getResultSet() {
		return new NullResultSet(this);
	}

	@Override
	public int getUpdateCount() {
		return 0;
	}

	@Override
	public boolean getMoreResults() {
		return false;
	}

	@Override
	public void setFetchDirection(int direction) {
	}

	@Override
	public int getFetchDirection() {
		return ResultSet.FETCH_FORWARD;
	}

	@Override
	public void setFetchSize(int rows) {
	}

	@Override
	public int getFetchSize() {
		return 1;
	}

	@Override
	public int getResultSetConcurrency() {
		return ResultSet.CONCUR_READ_ONLY;
	}

	@Override
	public int getResultSetType() {
		return Statement.KEEP_CURRENT_RESULT;
	}

	@Override
	public void addBatch(String sql) {
	}

	@Override
	public void clearBatch() {
	}

	@Override
	public int[] executeBatch() {
		return new int[0];
	}

	@Override
	public Connection getConnection() {
		return c;
	}

	@Override
	public boolean getMoreResults(int current) {
		return false;
	}

	@Override
	public ResultSet getGeneratedKeys() {
		return new NullResultSet(this);
	}

	@Override
	public int executeUpdate(String sql, int autoGeneratedKeys) {
		return 0;
	}

	@Override
	public int executeUpdate(String sql, int[] columnIndexes) {
		return 0;
	}

	@Override
	public int executeUpdate(String sql, String[] columnNames) {
		return 0;
	}

	@Override
	public boolean execute(String sql, int autoGeneratedKeys) {
		return false;
	}

	@Override
	public boolean execute(String sql, int[] columnIndexes) {
		return false;
	}

	@Override
	public boolean execute(String sql, String[] columnNames) {
		return false;
	}

	@Override
	public int getResultSetHoldability() {
		return ResultSet.CLOSE_CURSORS_AT_COMMIT;
	}

	@Override
	public boolean isClosed() {
		return true;
	}

	@Override
	public void setPoolable(boolean poolable) {

	}

	@Override
	public boolean isPoolable() {
		return false;
	}

	@Override
	public void closeOnCompletion() {

	}

	@Override
	public boolean isCloseOnCompletion() {
		return false;
	}

	@Override
	public long getLargeUpdateCount() {
		return 0;
	}

	@Override
	public void setLargeMaxRows(long max) {
	}

	@Override
	public long getLargeMaxRows() {
		return 0;
	}

	@Override
	public long[] executeLargeBatch() {
		return new long[0];
	}

	@Override
	public long executeLargeUpdate(String sql) {
		return 0L;
	}

	@Override
	public long executeLargeUpdate(String sql, int autoGeneratedKeys) {
		return 0L;
	}

	@Override
	public long executeLargeUpdate(String sql, int[] columnIndexes) {
		return 0L;
	}

	@Override
	public long executeLargeUpdate(String sql, String[] columnNames) {
		return 0L;
	}

	@Override
	public <T> T unwrap(Class<T> iface) {
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) {
		return false;
	}
}