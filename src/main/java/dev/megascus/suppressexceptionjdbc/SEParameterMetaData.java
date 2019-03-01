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

import java.sql.ParameterMetaData;
import java.sql.SQLException;
import java.sql.Types;

/**
 * @author megascus
 */
public class SEParameterMetaData implements ParameterMetaData {

	private final ParameterMetaData parameterMetaData;

	public SEParameterMetaData(ParameterMetaData parameterMetaData) {
		this.parameterMetaData = parameterMetaData;
	}

	public ParameterMetaData getRealParameterMetaData() {
		return parameterMetaData;
	}

	@Override
	public int getParameterCount() {
		try {
			return parameterMetaData.getParameterCount();
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public int isNullable(int param) {
		try {
			return parameterMetaData.isNullable(param);
		} catch (final SQLException ex) {
			return parameterNullableUnknown;
		}
	}

	@Override
	public boolean isSigned(int param) {
		try {
			return parameterMetaData.isSigned(param);
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public int getPrecision(int param) {
		try {
			return parameterMetaData.getPrecision(param);
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public int getScale(int param) {
		try {
			return parameterMetaData.getScale(param);
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public int getParameterType(int param) {
		try {
			return parameterMetaData.getParameterType(param);
		} catch (final SQLException ex) {
			return Types.NULL;
		}
	}

	@Override
	public String getParameterTypeName(int param) {
		try {
			return parameterMetaData.getParameterTypeName(param);
		} catch (final SQLException ex) {
			return "";
		}
	}

	@Override
	public String getParameterClassName(int param) {
		try {
			return parameterMetaData.getParameterClassName(param);
		} catch (final SQLException ex) {
			return Object.class.getName();
		}
	}

	@Override
	public int getParameterMode(int param) {
		try {
			return parameterMetaData.getParameterMode(param);
		} catch (final SQLException ex) {
			return parameterModeUnknown;
		}
	}

	@Override
	public <T> T unwrap(Class<T> iface) {
		try {
			return parameterMetaData.unwrap(iface);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) {
		try {
			return parameterMetaData.isWrapperFor(iface);
		} catch (final SQLException ex) {
			return false;
		}
	}

}
