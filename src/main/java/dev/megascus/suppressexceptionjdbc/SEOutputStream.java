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
import java.io.OutputStream;

/**
 * @author megascus
 */
public class SEOutputStream extends OutputStream {

	private OutputStream out;

	public SEOutputStream(OutputStream out) {
		this.out = out;
	}

	public OutputStream getRealOutputStream() {
		return out;
	}

	public void write(int b) {
		try {
			out.write(b);
		} catch (IOException e) {

		}
	}

	public int hashCode() {
		return out.hashCode();
	}

	public void write(byte[] b) {
		try {
			out.write(b);
		} catch (IOException e) {

		}
	}

	public void write(byte[] b, int off, int len) {
		try {
			out.write(b, off, len);
		} catch (IOException e) {
		}
	}

	public boolean equals(Object obj) {
		return out.equals(obj);
	}

	public void flush() {
		try {
			out.flush();
		} catch (IOException e) {

		}
	}

	public void close() {
		try {
			out.close();
		} catch (IOException e) {

		}
	}

	public String toString() {
		return out.toString();
	}

}
