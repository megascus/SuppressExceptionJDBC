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
import java.io.Writer;

/**
 * @author megascus
 */
public class SEWriter extends Writer {

	private Writer writer;

	public SEWriter(Writer writer) {
		this.writer = writer;
	}

	public Writer getRealWriter() {
		return writer;
	}

	public int hashCode() {
		return writer.hashCode();
	}

	public void write(int c) {
		try {
			writer.write(c);
		} catch (IOException e) {
		}
	}

	public void write(char[] cbuf) {
		try {
			writer.write(cbuf);
		} catch (IOException e) {
		}
	}

	public void write(char[] cbuf, int off, int len) {
		try {
			writer.write(cbuf, off, len);
		} catch (IOException e) {
		}
	}

	public boolean equals(Object obj) {
		return writer.equals(obj);
	}

	public void write(String str) {
		try {
			writer.write(str);
		} catch (IOException e) {
		}
	}

	public void write(String str, int off, int len) {
		try {
			writer.write(str, off, len);
		} catch (IOException e) {
		}
	}

	public SEWriter append(CharSequence csq) {
		try {
			writer.append(csq);
		} catch (IOException e) {
		}
		return this;
	}

	public SEWriter append(CharSequence csq, int start, int end) {
		try {
			writer.append(csq, start, end);
		} catch (IOException e) {
		}
		return this;
	}

	public SEWriter append(char c) {
		try {
			writer.append(c);
		} catch (IOException e) {
		}
		return this;
	}

	public void flush() {
		try {
			writer.flush();
		} catch (IOException e) {
		}
	}

	public String toString() {
		return writer.toString();
	}

	public void close() {
		try {
			writer.close();
		} catch (IOException e) {
		}
	}

}
