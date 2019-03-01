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

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

import dev.megascus.suppressexceptionjdbc.internal.NullConnection;

/**
 * @author megascus
 */
public class SEDriver implements Driver {

	public SEDriver() {
	}

	public static final String SEJDBC_URL_PREFIX = "jdbc:sej:";
	private static final int SEJDBC_URL_PREFIX_LENGTH = SEJDBC_URL_PREFIX.length();

	static {
		try {
			DriverManager.registerDriver(new SEDriver());
		} catch (final SQLException e) {
		}
	}

	private static String getDelegateUrl(String url) {
		return "jdbc:" + url.substring(SEJDBC_URL_PREFIX_LENGTH);
	}

	private Driver lastUsedJDBCDriver;

	@Override
	public boolean acceptsURL(String url) {
		return url.startsWith(SEJDBC_URL_PREFIX);
	}

	@Override
	public SEConnection connect(String url, Properties info) {

		if (!url.startsWith(SEJDBC_URL_PREFIX)) {
			return new SEConnection(this, new NullConnection(this, url), url);
		}

		final String delegeteUrl = SEDriver.getDelegateUrl(url);

		try {
			final Driver delegateDriver = DriverManager.getDriver(delegeteUrl);
			if (delegateDriver == null) {
				return new SEConnection(this, new NullConnection(this, url), url);
			}
			lastUsedJDBCDriver = delegateDriver;

			return new SEConnection(this, delegateDriver.connect(delegeteUrl, info), url);
		} catch (SQLException | RuntimeException e) {
			return new SEConnection(this, new NullConnection(this, url), url);
		}
	}

	@Override
	public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) {
		if (lastUsedJDBCDriver == null) {
			return new DriverPropertyInfo[0];
		}
		try {
			return lastUsedJDBCDriver.getPropertyInfo(url, info);
		} catch (final SQLException ex) {
			return new DriverPropertyInfo[0];
		}
	}

	@Override
	public int getMajorVersion() {
		return 0;
	}

	@Override
	public int getMinorVersion() {
		return 1;
	}

	@Override
	public boolean jdbcCompliant() {
		return true;
	}

	@Override
	public Logger getParentLogger() {
		if (lastUsedJDBCDriver == null) {
			return Logger.getLogger(SEDriver.class.getName());
		}
		try {
			return lastUsedJDBCDriver.getParentLogger();
		} catch (final SQLFeatureNotSupportedException ex) {
			return Logger.getLogger(SEDriver.class.getName());
		}
	}
}
