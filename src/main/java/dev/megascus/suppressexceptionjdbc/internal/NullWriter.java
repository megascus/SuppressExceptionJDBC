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

import java.io.Writer;

/**
 * @author megascus
 */
public class NullWriter extends Writer {

	public static final NullWriter INSTANCE = new NullWriter();

	@Override
	public void write(char[] cbuf, int off, int len) {
	}

	@Override
	public void flush() {
	}

	@Override
	public void close() {
	}

}
