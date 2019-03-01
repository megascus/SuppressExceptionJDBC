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

import java.sql.Clob;
import java.sql.SQLException;

import dev.megascus.suppressexceptionjdbc.internal.NullInputStream;
import dev.megascus.suppressexceptionjdbc.internal.NullOutputStream;
import dev.megascus.suppressexceptionjdbc.internal.NullReader;
import dev.megascus.suppressexceptionjdbc.internal.NullWriter;

/**
 * @author megascus
 */
public class SEClob implements Clob {

	private Clob clob;

	public SEClob(Clob clob) {
		this.clob = clob;
	}

	public Clob getRealClob() {
		return clob;
	}

	public long length() {
		try {
			return clob.length();
		} catch (SQLException e) {
			return 0;
		}
	}

	public String getSubString(long pos, int length) {
		try {
			return clob.getSubString(pos, length);
		} catch (SQLException e) {
			return "";
		}
	}

	public SEReader getCharacterStream() {
		try {
			return new SEReader(clob.getCharacterStream());
		} catch (SQLException e) {
			return new SEReader(NullReader.INSTANCE);
		}
	}

	public SEInputStream getAsciiStream() {
		try {
			return new SEInputStream(clob.getAsciiStream());
		} catch (SQLException e) {
			return new SEInputStream(NullInputStream.INSTANCE);
		}
	}

	public long position(String searchstr, long start) {
		try {
			return clob.position(searchstr, start);
		} catch (SQLException e) {
			return -1;
		}
	}

	public long position(Clob searchstr, long start) {
		try {
			return clob.position(searchstr, start);
		} catch (SQLException e) {
			return -1;
		}
	}

	public int setString(long pos, String str) {
		try {
			return clob.setString(pos, str);
		} catch (SQLException e) {
			return -1;
		}
	}

	public int setString(long pos, String str, int offset, int len) {
		try {
			return clob.setString(pos, str, offset, len);
		} catch (SQLException e) {
			return -1;
		}
	}

	public SEOutputStream setAsciiStream(long pos) {
		try {
			return new SEOutputStream(clob.setAsciiStream(pos));
		} catch (SQLException e) {
			return new SEOutputStream(NullOutputStream.INSTANCE);
		}
	}

	public SEWriter setCharacterStream(long pos) {
		try {
			return new SEWriter(clob.setCharacterStream(pos));
		} catch (SQLException e) {
			return new SEWriter(NullWriter.INSTANCE);
		}
	}

	public void truncate(long len) {
		try {
			clob.truncate(len);
		} catch (SQLException e) {
		}
	}

	public void free() {
		try {
			clob.free();
		} catch (SQLException e) {
		}
	}

	public SEReader getCharacterStream(long pos, long length) {
		try {
			return new SEReader(clob.getCharacterStream(pos, length));
		} catch (SQLException e) {
			return new SEReader(NullReader.INSTANCE);
		}
	}

}
