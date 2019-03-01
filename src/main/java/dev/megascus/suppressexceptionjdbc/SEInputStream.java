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

import java.io.IOException;
import java.io.InputStream;

/**
 * @author megascus
 */
public class SEInputStream extends InputStream {

	private InputStream in;

	public SEInputStream(InputStream in) {
		this.in = in;
	}

	public InputStream getRealInputStream() {
		return in;
	}

	public int read() {
		try {
			return in.read();
		} catch (IOException e) {
			return -1;
		}
	}

	public int hashCode() {
		return in.hashCode();
	}

	public int read(byte[] b) {
		try {
			return in.read(b);
		} catch (IOException e) {
			return -1;
		}
	}

	public boolean equals(Object obj) {
		return in.equals(obj);
	}

	public int read(byte[] b, int off, int len) {
		try {
			return in.read(b, off, len);
		} catch (IOException e) {
			return -1;
		}
	}

	public long skip(long n) {
		try {
			return in.skip(n);
		} catch (IOException e) {
			return 0;
		}
	}

	public String toString() {
		return in.toString();
	}

	public int available() {
		try {
			return in.available();
		} catch (IOException e) {
			return 0;
		}
	}

	public void close() {
		try {
			in.close();
		} catch (IOException e) {
		}
	}

	public void mark(int readlimit) {
		in.mark(readlimit);
	}

	public void reset() {
		try {
			in.reset();
		} catch (IOException e) {
		}
	}

	public boolean markSupported() {
		return in.markSupported();
	}

}
