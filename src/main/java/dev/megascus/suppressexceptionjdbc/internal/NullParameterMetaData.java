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

import java.sql.ParameterMetaData;

/**
 * @author megascus
 */
public class NullParameterMetaData implements ParameterMetaData {

	public static final NullParameterMetaData INSTANCE = new NullParameterMetaData();

	@Override
	public <T> T unwrap(Class<T> iface) {
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) {
		return false;
	}

	@Override
	public int getParameterCount() {
		return 0;
	}

	@Override
	public int isNullable(int param) {
		return ParameterMetaData.parameterNullableUnknown;
	}

	@Override
	public boolean isSigned(int param) {
		return false;
	}

	@Override
	public int getPrecision(int param) {
		return 0;
	}

	@Override
	public int getScale(int param) {
		return 0;
	}

	@Override
	public int getParameterType(int param) {
		return ParameterMetaData.parameterModeUnknown;
	}

	@Override
	public String getParameterTypeName(int param) {
		return null;
	}

	@Override
	public String getParameterClassName(int param) {
		return null;
	}

	@Override
	public int getParameterMode(int param) {
		return 0;
	}

}
