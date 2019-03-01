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

import java.sql.Blob;
import java.sql.SQLException;

import dev.megascus.suppressexceptionjdbc.internal.NullInputStream;
import dev.megascus.suppressexceptionjdbc.internal.NullOutputStream;

/**
 * @author megascus
 */
public class SEBlob implements Blob {

	private Blob blob;

	public SEBlob(Blob blob) {
		this.blob = blob;
	}

	public Blob getRealBlob() {
		return blob;
	}

	public long length() {
		try {
			return blob.length();
		} catch (SQLException e) {
			return 0;
		}
	}

	public byte[] getBytes(long pos, int length) {
		try {
			return blob.getBytes(pos, length);
		} catch (SQLException e) {
			return new byte[0];
		}
	}

	public SEInputStream getBinaryStream() {
		try {
			return new SEInputStream(blob.getBinaryStream());
		} catch (SQLException e) {
			return new SEInputStream(NullInputStream.INSTANCE);
		}
	}

	public long position(byte[] pattern, long start) {
		try {
			return blob.position(pattern, start);
		} catch (SQLException e) {
			return 0;
		}
	}

	public long position(Blob pattern, long start) {
		try {
			return blob.position(pattern, start);
		} catch (SQLException e) {
			return 0;
		}
	}

	public int setBytes(long pos, byte[] bytes) {
		try {
			return blob.setBytes(pos, bytes);
		} catch (SQLException e) {
			return -1;
		}
	}

	public int setBytes(long pos, byte[] bytes, int offset, int len) {
		try {
			return blob.setBytes(pos, bytes, offset, len);
		} catch (SQLException e) {
			return -1;
		}
	}

	public SEOutputStream setBinaryStream(long pos) {
		try {
			return new SEOutputStream(blob.setBinaryStream(pos));
		} catch (SQLException e) {
			return new SEOutputStream(NullOutputStream.INSTANCE);
		}
	}

	public void truncate(long len) {
		try {
			blob.truncate(len);
		} catch (SQLException e) {
		}
	}

	public void free() {
		try {
			blob.free();
		} catch (SQLException e) {
		}
	}

	public SEInputStream getBinaryStream(long pos, long length) {
		try {
			return new SEInputStream(blob.getBinaryStream(pos, length));
		} catch (SQLException e) {
			return new SEInputStream(NullInputStream.INSTANCE);
		}
	}

}
