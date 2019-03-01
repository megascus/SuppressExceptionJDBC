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
import java.sql.Blob;

/**
 * @author megascus
 */
public class NullBlob implements Blob {

	public static final Blob INSTANCE = new NullBlob();

	NullBlob() {
	}

	@Override
	public long length() {
		return 0;
	}

	@Override
	public byte[] getBytes(long pos, int length) {
		return new byte[0];
	}

	@Override
	public InputStream getBinaryStream() {
		return NullInputStream.INSTANCE;
	}

	@Override
	public long position(byte[] pattern, long start) {
		return -1;
	}

	@Override
	public long position(Blob pattern, long start) {
		return -1;
	}

	@Override
	public int setBytes(long pos, byte[] bytes) {
		return -1;
	}

	@Override
	public int setBytes(long pos, byte[] bytes, int offset, int len) {
		return -1;
	}

	@Override
	public OutputStream setBinaryStream(long pos) {
		return NullOutputStream.INSTANCE;
	}

	@Override
	public void truncate(long len) {
	}

	@Override
	public void free() {
	}

	@Override
	public InputStream getBinaryStream(long pos, long length) {
		return NullInputStream.INSTANCE;
	}
}
