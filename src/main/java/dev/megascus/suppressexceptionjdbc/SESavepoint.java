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
import java.sql.Savepoint;
/**
 * @author megascus
 */
public class SESavepoint implements Savepoint {

	private Savepoint savepoint;

	public SESavepoint(Savepoint savepoint) {
		this.savepoint = savepoint;
	}

	public Savepoint getRealSavepoint() {
		return savepoint;
	}

	@Override
	public int getSavepointId() {
		try {
			return savepoint.getSavepointId();
		} catch (SQLException e) {
			return -1;
		}
	}

	@Override
	public String getSavepointName() {
		try {
			return savepoint.getSavepointName();
		} catch (SQLException e) {
			return "";
		}
	}

}
