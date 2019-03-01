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
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.sql.Clob;

/**
 * @author megascus
 */
public class NullClob implements Clob {

	public static final NullClob INSTANCE = new NullClob();

	NullClob() {
	}

	@Override
	public long length() {
		return 0;
	}

	@Override
	public String getSubString(long pos, int length) {
		return "";
	}

	@Override
	public Reader getCharacterStream() {
		return NullReader.INSTANCE;
	}

	@Override
	public InputStream getAsciiStream() {
		return NullInputStream.INSTANCE;
	}

	@Override
	public long position(String searchstr, long start) {
		return -1;
	}

	@Override
	public long position(Clob searchstr, long start) {
		return -1;
	}

	@Override
	public int setString(long pos, String str) {
		return -1;
	}

	@Override
	public int setString(long pos, String str, int offset, int len) {
		return -1;
	}

	@Override
	public OutputStream setAsciiStream(long pos) {
		return NullOutputStream.INSTANCE;
	}

	@Override
	public Writer setCharacterStream(long pos) {
		return NullWriter.INSTANCE;
	}

	@Override
	public void truncate(long len) {
	}

	@Override
	public void free() {
	}

	@Override
	public Reader getCharacterStream(long pos, long length) {
		return NullReader.INSTANCE;
	}
}
