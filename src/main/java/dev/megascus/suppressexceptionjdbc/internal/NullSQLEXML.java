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
import java.sql.SQLXML;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;

/**
 * @author megascus
 */
public class NullSQLEXML implements SQLXML {

	public static final NullSQLEXML INSTANCE = new NullSQLEXML();

	NullSQLEXML() {
	}

	@Override
	public void free() {
	}

	@Override
	public InputStream getBinaryStream() {
		return NullInputStream.INSTANCE;
	}

	@Override
	public OutputStream setBinaryStream() {
		return NullOutputStream.INSTANCE;
	}

	@Override
	public Reader getCharacterStream() {
		return NullReader.INSTANCE;
	}

	@Override
	public Writer setCharacterStream() {
		return NullWriter.INSTANCE;
	}

	@Override
	public String getString() {
		return "";
	}

	@Override
	public void setString(String value) {
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Source> T getSource(Class<T> sourceClass) {
		if (sourceClass == null) {
			return (T) new DOMSource();
		}
		try {
			return sourceClass.getConstructor().newInstance();
		} catch (ReflectiveOperationException | SecurityException ex) {
			return null;
		}
	}

	@Override
	public <T extends Result> T setResult(Class<T> resultClass) {
		try {
			return resultClass.getConstructor().newInstance();
		} catch (ReflectiveOperationException | SecurityException ex) {
			return null;
		}
	}
}
