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
import java.io.Reader;
import java.nio.CharBuffer;

/**
 * @author megascus
 */
public class SEReader extends Reader {

	private Reader reader;

	public SEReader(Reader reader) {
		this.reader = reader;
	}

	public Reader getRealReader() {
		return reader;
	}

	public int hashCode() {
		return reader.hashCode();
	}

	public int read(CharBuffer target) {
		try {
			return reader.read(target);
		} catch (IOException e) {
			return -1;
		}
	}

	public int read() {
		try {
			return reader.read();
		} catch (IOException e) {
			return -1;
		}
	}

	public boolean equals(Object obj) {
		return reader.equals(obj);
	}

	public int read(char[] cbuf) {
		try {
			return reader.read(cbuf);
		} catch (IOException e) {
			return -1;
		}
	}

	public int read(char[] cbuf, int off, int len) {
		try {
			return reader.read(cbuf, off, len);
		} catch (IOException e) {
			return -1;
		}
	}

	public long skip(long n) {
		try {
			return reader.skip(n);
		} catch (IOException e) {
			return 0;
		}
	}

	public boolean ready() {
		try {
			return reader.ready();
		} catch (IOException e) {
			return false;
		}
	}

	public boolean markSupported() {
		return reader.markSupported();
	}

	public void mark(int readAheadLimit) {
		try {
			reader.mark(readAheadLimit);
		} catch (IOException e) {
		}
	}

	public void reset() {
		try {
			reader.reset();
		} catch (IOException e) {
		}
	}

	public void close() {
		try {
			reader.close();
		} catch (IOException e) {
		}
	}

	public String toString() {
		return reader.toString();
	}

}
