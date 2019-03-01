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

import java.sql.SQLException;
import java.sql.SQLXML;

import javax.xml.transform.Result;
import javax.xml.transform.Source;

import dev.megascus.suppressexceptionjdbc.internal.NullInputStream;
import dev.megascus.suppressexceptionjdbc.internal.NullOutputStream;
import dev.megascus.suppressexceptionjdbc.internal.NullReader;
import dev.megascus.suppressexceptionjdbc.internal.NullSQLEXML;
import dev.megascus.suppressexceptionjdbc.internal.NullWriter;

/**
 * @author megascus
 */
public class SESQLXML implements SQLXML {

	private SQLXML sqlxml;

	public SESQLXML(SQLXML sqlxml) {
		this.sqlxml = sqlxml;
	}

	public SQLXML getRealSQLXML() {
		return sqlxml;
	}

	public void free() {
		try {
			sqlxml.free();
		} catch (SQLException e) {
		}
	}

	public SEInputStream getBinaryStream() {
		try {
			return new SEInputStream(sqlxml.getBinaryStream());
		} catch (SQLException e) {
			return new SEInputStream(NullInputStream.INSTANCE);
		}
	}

	public SEOutputStream setBinaryStream() {
		try {
			return new SEOutputStream(sqlxml.setBinaryStream());
		} catch (SQLException e) {
			return new SEOutputStream(NullOutputStream.INSTANCE);
		}
	}

	public SEReader getCharacterStream() {
		try {
			return new SEReader(sqlxml.getCharacterStream());
		} catch (SQLException e) {
			return new SEReader(NullReader.INSTANCE);
		}
	}

	public SEWriter setCharacterStream() {
		try {
			return new SEWriter(sqlxml.setCharacterStream());
		} catch (SQLException e) {
			return new SEWriter(NullWriter.INSTANCE);
		}
	}

	public String getString() {
		try {
			return sqlxml.getString();
		} catch (SQLException e) {
			return "";
		}
	}

	public void setString(String value) {
		try {
			sqlxml.setString(value);
		} catch (SQLException e) {
		}
	}

	public <T extends Source> T getSource(Class<T> sourceClass) {
		try {
			return sqlxml.getSource(sourceClass);
		} catch (SQLException e) {
			return NullSQLEXML.INSTANCE.getSource(sourceClass);
		}
	}

	public <T extends Result> T setResult(Class<T> resultClass) {
		try {
			return sqlxml.setResult(resultClass);
		} catch (SQLException e) {
			return NullSQLEXML.INSTANCE.setResult(resultClass);
		}
	}

}
