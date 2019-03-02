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

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import dev.megascus.suppressexceptionjdbc.internal.NullConnection;
import dev.megascus.suppressexceptionjdbc.internal.NullOutputStream;

/**
 * @author megascus
 */
public class SEDataSource implements DataSource {

	private DataSource ds;

	public SEDataSource(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public PrintWriter getLogWriter() {
		try {
			return ds.getLogWriter();
		} catch (SQLException e) {
			return new PrintWriter(new NullOutputStream());
		}
	}

	@Override
	public void setLogWriter(PrintWriter out) {
		try {
			ds.setLogWriter(out);
		} catch (SQLException e) {
		}
	}

	@Override
	public void setLoginTimeout(int seconds) {
		try {
			ds.setLoginTimeout(seconds);
		} catch (SQLException e) {
		}
	}

	@Override
	public int getLoginTimeout() {
		try {
			return ds.getLoginTimeout();
		} catch (SQLException e) {
			return 0;
		}
	}

	@Override
	public Logger getParentLogger() {
		try {
			return ds.getParentLogger();
		} catch (SQLFeatureNotSupportedException e) {
			return Logger.getLogger(this.getClass().getName());
		}
	}

	@Override
	public <T> T unwrap(Class<T> iface) {
		try {
			return ds.unwrap(iface);
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) {
		try {
			return ds.isWrapperFor(iface);
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public Connection getConnection() {
		Connection con;
		try {
			con = ds.getConnection();
		} catch (SQLException e) {
			con = new NullConnection(new SEDriver(), "");
		}
		return new SEConnection(con);
	}

	@Override
	public Connection getConnection(String username, String password) {
		Connection con;
		try {
			con = ds.getConnection(username, password);
		} catch (SQLException e) {
			con = new NullConnection(new SEDriver(), "");
		}
		return new SEConnection(con);
	}

}
