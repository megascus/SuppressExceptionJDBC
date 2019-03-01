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

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.RowIdLifetime;
import java.sql.SQLException;

import dev.megascus.suppressexceptionjdbc.internal.NullResultSet;

/**
 * @author megascus
 */
public class SEDatabaseMetaData implements DatabaseMetaData {

	private final SEDriver driver; // maybe null.
	private final DatabaseMetaData base;
	private final SEConnection parent;

	public SEDatabaseMetaData(SEDriver driver, SEConnection parent, DatabaseMetaData base) {
		this.driver = driver;
		this.parent = parent;
		this.base = base;
	}

	public DatabaseMetaData getRealDatabaseMetaData() {
		return base;
	}

	@Override
	public boolean allProceduresAreCallable() {
		try {
			return base.allProceduresAreCallable();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean allTablesAreSelectable() {
		try {
			return base.allTablesAreSelectable();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public String getURL() {
		String url = parent.getURL();
		if (url != null) {
			return url;
		}
		try {
			return base.getURL();
		} catch (final SQLException ex) {
		}
		return null;
	}

	@Override
	public String getUserName() {
		try {
			return base.getUserName();
		} catch (final SQLException ex) {
			return "";
		}
	}

	@Override
	public boolean isReadOnly() {
		try {
			return base.isReadOnly();
		} catch (final SQLException ex) {
			return true;
		}
	}

	@Override
	public boolean nullsAreSortedHigh() {
		try {
			return base.nullsAreSortedHigh();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean nullsAreSortedLow() {
		try {
			return base.nullsAreSortedLow();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean nullsAreSortedAtStart() {
		try {
			return base.nullsAreSortedAtStart();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean nullsAreSortedAtEnd() {
		try {
			return base.nullsAreSortedAtEnd();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public String getDatabaseProductName() {
		try {
			return base.getDatabaseProductName();
		} catch (final SQLException ex) {
			return "";
		}
	}

	@Override
	public String getDatabaseProductVersion() {
		try {
			return base.getDatabaseProductVersion();
		} catch (final SQLException ex) {
			return "";
		}
	}

	@Override
	public String getDriverName() {
		if (driver == null) {
			try {
				return base.getDriverName();
			} catch (SQLException e) {
			}
		}
		return SEDriver.class.getName();
	}

	@Override
	public String getDriverVersion() {
		if (driver == null) {
			try {
				return base.getDriverVersion();
			} catch (SQLException e) {
			}
		}
		return driver.getMajorVersion() + "." + driver.getMinorVersion();
	}

	@Override
	public int getDriverMajorVersion() {
		if (driver == null) {
			return base.getDriverMajorVersion();
		}
		return driver.getMajorVersion();
	}

	@Override
	public int getDriverMinorVersion() {
		if (driver == null) {
			return base.getDriverMinorVersion();
		}
		return driver.getMinorVersion();
	}

	@Override
	public boolean usesLocalFiles() {
		try {
			return base.usesLocalFiles();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean usesLocalFilePerTable() {
		try {
			return base.usesLocalFilePerTable();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsMixedCaseIdentifiers() {
		try {
			return base.supportsMixedCaseIdentifiers();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean storesUpperCaseIdentifiers() {
		try {
			return base.storesUpperCaseIdentifiers();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean storesLowerCaseIdentifiers() {
		try {
			return base.storesLowerCaseIdentifiers();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean storesMixedCaseIdentifiers() {
		try {
			return base.storesMixedCaseIdentifiers();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsMixedCaseQuotedIdentifiers() {
		try {
			return base.supportsMixedCaseQuotedIdentifiers();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean storesUpperCaseQuotedIdentifiers() {
		try {
			return base.storesUpperCaseQuotedIdentifiers();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean storesLowerCaseQuotedIdentifiers() {
		try {
			return base.storesLowerCaseQuotedIdentifiers();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean storesMixedCaseQuotedIdentifiers() {
		try {
			return base.storesMixedCaseQuotedIdentifiers();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public String getIdentifierQuoteString() {
		try {
			return base.getIdentifierQuoteString();
		} catch (final SQLException ex) {
			return "";
		}
	}

	@Override
	public String getSQLKeywords() {
		try {
			return base.getSQLKeywords();
		} catch (final SQLException ex) {
			return "";
		}
	}

	@Override
	public String getNumericFunctions() {
		try {
			return base.getNumericFunctions();
		} catch (final SQLException ex) {
			return "";
		}
	}

	@Override
	public String getStringFunctions() {
		try {
			return base.getStringFunctions();
		} catch (final SQLException ex) {
			return "";
		}
	}

	@Override
	public String getSystemFunctions() {
		try {
			return base.getSystemFunctions();
		} catch (final SQLException ex) {
			return "";
		}
	}

	@Override
	public String getTimeDateFunctions() {
		try {
			return base.getTimeDateFunctions();
		} catch (final SQLException ex) {
			return "";
		}
	}

	@Override
	public String getSearchStringEscape() {
		try {
			return base.getSearchStringEscape();
		} catch (final SQLException ex) {
			return "%";
		}
	}

	@Override
	public String getExtraNameCharacters() {
		try {
			return base.getExtraNameCharacters();
		} catch (final SQLException ex) {
			return "";
		}
	}

	@Override
	public boolean supportsAlterTableWithAddColumn() {
		try {
			return base.supportsAlterTableWithAddColumn();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsAlterTableWithDropColumn() {
		try {
			return base.supportsAlterTableWithDropColumn();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsColumnAliasing() {
		try {
			return base.supportsColumnAliasing();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean nullPlusNonNullIsNull() {
		try {
			return base.nullPlusNonNullIsNull();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsConvert() {
		try {
			return base.supportsConvert();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsConvert(int fromType, int toType) {
		try {
			return base.supportsConvert(fromType, toType);
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsTableCorrelationNames() {
		try {
			return base.supportsTableCorrelationNames();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsDifferentTableCorrelationNames() {
		try {
			return base.supportsDifferentTableCorrelationNames();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsExpressionsInOrderBy() {
		try {
			return base.supportsExpressionsInOrderBy();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsOrderByUnrelated() {
		try {
			return base.supportsOrderByUnrelated();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsGroupBy() {
		try {
			return base.supportsGroupBy();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsGroupByUnrelated() {
		try {
			return base.supportsGroupByUnrelated();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsGroupByBeyondSelect() {
		try {
			return base.supportsGroupByBeyondSelect();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsLikeEscapeClause() {
		try {
			return base.supportsLikeEscapeClause();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsMultipleResultSets() {
		try {
			return base.supportsMultipleResultSets();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsMultipleTransactions() {
		try {
			return base.supportsMultipleTransactions();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsNonNullableColumns() {
		try {
			return base.supportsNonNullableColumns();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsMinimumSQLGrammar() {
		try {
			return base.supportsMinimumSQLGrammar();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsCoreSQLGrammar() {
		try {
			return base.supportsCoreSQLGrammar();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsExtendedSQLGrammar() {
		try {
			return base.supportsExtendedSQLGrammar();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsANSI92EntryLevelSQL() {
		try {
			return base.supportsANSI92EntryLevelSQL();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsANSI92IntermediateSQL() {
		try {
			return base.supportsANSI92IntermediateSQL();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsANSI92FullSQL() {
		try {
			return base.supportsANSI92FullSQL();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsIntegrityEnhancementFacility() {
		try {
			return base.supportsIntegrityEnhancementFacility();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsOuterJoins() {
		try {
			return base.supportsOuterJoins();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsFullOuterJoins() {
		try {
			return base.supportsFullOuterJoins();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsLimitedOuterJoins() {
		try {
			return base.supportsLimitedOuterJoins();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public String getSchemaTerm() {
		try {
			return base.getSchemaTerm();
		} catch (final SQLException ex) {
			return "";
		}
	}

	@Override
	public String getProcedureTerm() {
		try {
			return base.getProcedureTerm();
		} catch (final SQLException ex) {
			return "";
		}
	}

	@Override
	public String getCatalogTerm() {
		try {
			return base.getCatalogTerm();
		} catch (final SQLException ex) {
			return "";
		}
	}

	@Override
	public boolean isCatalogAtStart() {
		try {
			return base.isCatalogAtStart();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public String getCatalogSeparator() {
		try {
			return base.getCatalogSeparator();
		} catch (final SQLException ex) {
			return "";
		}
	}

	@Override
	public boolean supportsSchemasInDataManipulation() {
		try {
			return base.supportsSchemasInDataManipulation();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsSchemasInProcedureCalls() {
		try {
			return base.supportsSchemasInProcedureCalls();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsSchemasInTableDefinitions() {
		try {
			return base.supportsSchemasInTableDefinitions();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsSchemasInIndexDefinitions() {
		try {
			return base.supportsSchemasInIndexDefinitions();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsSchemasInPrivilegeDefinitions() {
		try {
			return base.supportsSchemasInPrivilegeDefinitions();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsCatalogsInDataManipulation() {
		try {
			return base.supportsCatalogsInDataManipulation();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsCatalogsInProcedureCalls() {
		try {
			return base.supportsCatalogsInProcedureCalls();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsCatalogsInTableDefinitions() {
		try {
			return base.supportsCatalogsInTableDefinitions();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsCatalogsInIndexDefinitions() {
		try {
			return base.supportsCatalogsInIndexDefinitions();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsCatalogsInPrivilegeDefinitions() {
		try {
			return base.supportsCatalogsInPrivilegeDefinitions();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsPositionedDelete() {
		try {
			return base.supportsPositionedDelete();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsPositionedUpdate() {
		try {
			return base.supportsPositionedUpdate();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsSelectForUpdate() {
		try {
			return base.supportsSelectForUpdate();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsStoredProcedures() {
		try {
			return base.supportsStoredProcedures();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsSubqueriesInComparisons() {
		try {
			return base.supportsSubqueriesInComparisons();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsSubqueriesInExists() {
		try {
			return base.supportsSubqueriesInExists();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsSubqueriesInIns() {
		try {
			return base.supportsSubqueriesInIns();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsSubqueriesInQuantifieds() {
		try {
			return base.supportsSubqueriesInQuantifieds();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsCorrelatedSubqueries() {
		try {
			return base.supportsCorrelatedSubqueries();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsUnion() {
		try {
			return base.supportsUnion();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsUnionAll() {
		try {
			return base.supportsUnionAll();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsOpenCursorsAcrossCommit() {
		try {
			return base.supportsOpenCursorsAcrossCommit();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsOpenCursorsAcrossRollback() {
		try {
			return base.supportsOpenCursorsAcrossRollback();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsOpenStatementsAcrossCommit() {
		try {
			return base.supportsOpenStatementsAcrossCommit();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsOpenStatementsAcrossRollback() {
		try {
			return base.supportsOpenStatementsAcrossRollback();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public int getMaxBinaryLiteralLength() {
		try {
			return base.getMaxBinaryLiteralLength();
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public int getMaxCharLiteralLength() {
		try {
			return base.getMaxCharLiteralLength();
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public int getMaxColumnNameLength() {
		try {
			return base.getMaxColumnNameLength();
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public int getMaxColumnsInGroupBy() {
		try {
			return base.getMaxColumnsInGroupBy();
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public int getMaxColumnsInIndex() {
		try {
			return base.getMaxColumnsInIndex();
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public int getMaxColumnsInOrderBy() {
		try {
			return base.getMaxColumnsInOrderBy();
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public int getMaxColumnsInSelect() {
		try {
			return base.getMaxColumnsInSelect();
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public int getMaxColumnsInTable() {
		try {
			return base.getMaxColumnsInTable();
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public int getMaxConnections() {
		try {
			return base.getMaxConnections();
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public int getMaxCursorNameLength() {
		try {
			return base.getMaxCursorNameLength();
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public int getMaxIndexLength() {
		try {
			return base.getMaxIndexLength();
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public int getMaxSchemaNameLength() {
		try {
			return base.getMaxSchemaNameLength();
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public int getMaxProcedureNameLength() {
		try {
			return base.getMaxProcedureNameLength();
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public int getMaxCatalogNameLength() {
		try {
			return base.getMaxCatalogNameLength();
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public int getMaxRowSize() {
		try {
			return base.getMaxRowSize();
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public boolean doesMaxRowSizeIncludeBlobs() {
		try {
			return base.doesMaxRowSizeIncludeBlobs();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public int getMaxStatementLength() {
		try {
			return base.getMaxStatementLength();
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public int getMaxStatements() {
		try {
			return base.getMaxStatements();
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public int getMaxTableNameLength() {
		try {
			return base.getMaxTableNameLength();
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public int getMaxTablesInSelect() {
		try {
			return base.getMaxTablesInSelect();
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public int getMaxUserNameLength() {
		try {
			return base.getMaxUserNameLength();
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public int getDefaultTransactionIsolation() {
		try {
			return base.getDefaultTransactionIsolation();
		} catch (final SQLException ex) {
			return Connection.TRANSACTION_NONE;
		}
	}

	@Override
	public boolean supportsTransactions() {
		try {
			return base.supportsTransactions();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsTransactionIsolationLevel(int level) {
		try {
			return base.supportsTransactionIsolationLevel(level);
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsDataDefinitionAndDataManipulationTransactions() {
		try {
			return base.supportsDataDefinitionAndDataManipulationTransactions();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsDataManipulationTransactionsOnly() {
		try {
			return base.supportsDataManipulationTransactionsOnly();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean dataDefinitionCausesTransactionCommit() {
		try {
			return base.dataDefinitionCausesTransactionCommit();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean dataDefinitionIgnoredInTransactions() {
		try {
			return base.dataDefinitionIgnoredInTransactions();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public SEResultSet getProcedures(String catalog, String schemaPattern, String procedureNamePattern) {
		try {
			return new SEResultSet(base.getProcedures(catalog, schemaPattern, procedureNamePattern));
		} catch (final SQLException ex) {
			return new SEResultSet(NullResultSet.INSTANCE);
		}
	}

	@Override
	public SEResultSet getProcedureColumns(String catalog, String schemaPattern, String procedureNamePattern,
			String columnNamePattern) {
		try {
			return new SEResultSet(
					base.getProcedureColumns(catalog, schemaPattern, procedureNamePattern, columnNamePattern));
		} catch (final SQLException ex) {
			return new SEResultSet(NullResultSet.INSTANCE);
		}
	}

	@Override
	public SEResultSet getTables(String catalog, String schemaPattern, String tableNamePattern, String[] types) {
		try {
			return new SEResultSet(base.getTables(catalog, schemaPattern, tableNamePattern, types));
		} catch (final SQLException ex) {
			return new SEResultSet(NullResultSet.INSTANCE);
		}
	}

	@Override
	public SEResultSet getSchemas() {
		try {
			return new SEResultSet(base.getSchemas());
		} catch (final SQLException ex) {
			return new SEResultSet(NullResultSet.INSTANCE);
		}
	}

	@Override
	public SEResultSet getCatalogs() {
		try {
			return new SEResultSet(base.getCatalogs());
		} catch (final SQLException ex) {
			return new SEResultSet(NullResultSet.INSTANCE);
		}
	}

	@Override
	public SEResultSet getTableTypes() {
		try {
			return new SEResultSet(base.getTableTypes());
		} catch (final SQLException ex) {
			return new SEResultSet(NullResultSet.INSTANCE);
		}
	}

	@Override
	public SEResultSet getColumns(String catalog, String schemaPattern, String tableNamePattern,
			String columnNamePattern) {
		try {
			return new SEResultSet(base.getColumns(catalog, schemaPattern, tableNamePattern, columnNamePattern));
		} catch (final SQLException ex) {
			return new SEResultSet(NullResultSet.INSTANCE);
		}
	}

	@Override
	public ResultSet getColumnPrivileges(String catalog, String schema, String table, String columnNamePattern) {
		try {
			return new SEResultSet(base.getColumnPrivileges(catalog, schema, table, columnNamePattern));
		} catch (final SQLException ex) {
			return new SEResultSet(NullResultSet.INSTANCE);
		}
	}

	@Override
	public SEResultSet getTablePrivileges(String catalog, String schemaPattern, String tableNamePattern) {
		try {
			return new SEResultSet(base.getTablePrivileges(catalog, schemaPattern, tableNamePattern));
		} catch (final SQLException ex) {
			return new SEResultSet(NullResultSet.INSTANCE);
		}
	}

	@Override
	public SEResultSet getBestRowIdentifier(String catalog, String schema, String table, int scope, boolean nullable) {
		try {
			return new SEResultSet(base.getBestRowIdentifier(catalog, schema, table, scope, nullable));
		} catch (final SQLException ex) {
			return new SEResultSet(NullResultSet.INSTANCE);
		}
	}

	@Override
	public SEResultSet getVersionColumns(String catalog, String schema, String table) {
		try {
			return new SEResultSet(base.getVersionColumns(catalog, schema, table));
		} catch (final SQLException ex) {
			return new SEResultSet(NullResultSet.INSTANCE);
		}
	}

	@Override
	public SEResultSet getPrimaryKeys(String catalog, String schema, String table) {
		try {
			return new SEResultSet(base.getPrimaryKeys(catalog, schema, table));
		} catch (final SQLException ex) {
			return new SEResultSet(NullResultSet.INSTANCE);
		}
	}

	@Override
	public SEResultSet getImportedKeys(String catalog, String schema, String table) {
		try {
			return new SEResultSet(base.getImportedKeys(catalog, schema, table));
		} catch (final SQLException ex) {
			return new SEResultSet(NullResultSet.INSTANCE);
		}
	}

	@Override
	public SEResultSet getExportedKeys(String catalog, String schema, String table) {
		try {
			return new SEResultSet(base.getExportedKeys(catalog, schema, table));
		} catch (final SQLException ex) {
			return new SEResultSet(NullResultSet.INSTANCE);
		}
	}

	@Override
	public SEResultSet getCrossReference(String parentCatalog, String parentSchema, String parentTable,
			String foreignCatalog, String foreignSchema, String foreignTable) {
		try {
			return new SEResultSet(base.getCrossReference(parentCatalog, parentSchema, parentTable, foreignCatalog,
					foreignSchema, foreignTable));
		} catch (final SQLException ex) {
			return new SEResultSet(NullResultSet.INSTANCE);
		}
	}

	@Override
	public SEResultSet getTypeInfo() {
		try {
			return new SEResultSet(base.getTypeInfo());
		} catch (final SQLException ex) {
			return new SEResultSet(NullResultSet.INSTANCE);
		}
	}

	@Override
	public SEResultSet getIndexInfo(String catalog, String schema, String table, boolean unique, boolean approximate) {
		try {
			return new SEResultSet(base.getIndexInfo(catalog, schema, table, unique, approximate));
		} catch (final SQLException ex) {
			return new SEResultSet(NullResultSet.INSTANCE);
		}
	}

	@Override
	public boolean supportsResultSetType(int type) {
		try {
			return base.supportsResultSetType(type);
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsResultSetConcurrency(int type, int concurrency) {
		try {
			return base.supportsResultSetConcurrency(type, concurrency);
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean ownUpdatesAreVisible(int type) {
		try {
			return base.ownUpdatesAreVisible(type);
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean ownDeletesAreVisible(int type) {
		try {
			return base.ownDeletesAreVisible(type);
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean ownInsertsAreVisible(int type) {
		try {
			return base.ownInsertsAreVisible(type);
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean othersUpdatesAreVisible(int type) {
		try {
			return base.othersUpdatesAreVisible(type);
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean othersDeletesAreVisible(int type) {
		try {
			return base.othersDeletesAreVisible(type);
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean othersInsertsAreVisible(int type) {
		try {
			return base.othersInsertsAreVisible(type);
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean updatesAreDetected(int type) {
		try {
			return base.updatesAreDetected(type);
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean deletesAreDetected(int type) {
		try {
			return base.deletesAreDetected(type);
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean insertsAreDetected(int type) {
		try {
			return base.insertsAreDetected(type);
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsBatchUpdates() {
		try {
			return base.supportsBatchUpdates();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public SEResultSet getUDTs(String catalog, String schemaPattern, String typeNamePattern, int[] types) {
		try {
			return new SEResultSet(base.getUDTs(catalog, schemaPattern, typeNamePattern, types));
		} catch (final SQLException ex) {
			return new SEResultSet(NullResultSet.INSTANCE);
		}
	}

	@Override
	public SEConnection getConnection() {
		return parent;
	}

	@Override
	public boolean supportsSavepoints() {
		try {
			return base.supportsSavepoints();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsNamedParameters() {
		try {
			return base.supportsNamedParameters();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsMultipleOpenResults() {
		try {
			return base.supportsMultipleOpenResults();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsGetGeneratedKeys() {
		try {
			return base.supportsGetGeneratedKeys();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public SEResultSet getSuperTypes(String catalog, String schemaPattern, String typeNamePattern) {
		try {
			return new SEResultSet(base.getSuperTypes(catalog, schemaPattern, typeNamePattern));
		} catch (final SQLException ex) {
			return new SEResultSet(NullResultSet.INSTANCE);
		}
	}

	@Override
	public SEResultSet getSuperTables(String catalog, String schemaPattern, String tableNamePattern) {
		try {
			return new SEResultSet(base.getSuperTables(catalog, schemaPattern, tableNamePattern));
		} catch (final SQLException ex) {
			return new SEResultSet(NullResultSet.INSTANCE);
		}
	}

	@Override
	public SEResultSet getAttributes(String catalog, String schemaPattern, String typeNamePattern,
			String attributeNamePattern) {
		try {
			return new SEResultSet(base.getAttributes(catalog, schemaPattern, typeNamePattern, attributeNamePattern));
		} catch (final SQLException ex) {
			return new SEResultSet(NullResultSet.INSTANCE);
		}
	}

	@Override
	public boolean supportsResultSetHoldability(int holdability) {
		try {
			return base.supportsResultSetHoldability(holdability);
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public int getResultSetHoldability() {
		try {
			return base.getResultSetHoldability();
		} catch (final SQLException ex) {
			return ResultSet.CLOSE_CURSORS_AT_COMMIT;
		}
	}

	@Override
	public int getDatabaseMajorVersion() {
		try {
			return base.getDatabaseMajorVersion();
		} catch (final SQLException ex) {
			return -1;
		}
	}

	@Override
	public int getDatabaseMinorVersion() {
		try {
			return base.getDatabaseMinorVersion();
		} catch (final SQLException ex) {
			return -1;
		}
	}

	@Override
	public int getJDBCMajorVersion() {
		try {
			return base.getJDBCMajorVersion();
		} catch (final SQLException ex) {
			if (driver != null) {
				return driver.getMajorVersion();
			}
			return new SEDriver().getMajorVersion();
		}
	}

	@Override
	public int getJDBCMinorVersion() {
		try {
			return base.getJDBCMinorVersion();
		} catch (final SQLException ex) {
			if (driver != null) {
				return driver.getMinorVersion();
			}
			return new SEDriver().getMinorVersion();
		}
	}

	@Override
	public int getSQLStateType() {
		try {
			return base.getSQLStateType();
		} catch (final SQLException ex) {
			return DatabaseMetaData.sqlStateXOpen;
		}
	}

	@Override
	public boolean locatorsUpdateCopy() {
		try {
			return base.locatorsUpdateCopy();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean supportsStatementPooling() {
		try {
			return base.supportsStatementPooling();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public RowIdLifetime getRowIdLifetime() {
		try {
			return base.getRowIdLifetime();
		} catch (final SQLException ex) {
			return RowIdLifetime.ROWID_UNSUPPORTED;
		}
	}

	@Override
	public SEResultSet getSchemas(String catalog, String schemaPattern) {
		try {
			return new SEResultSet(base.getSchemas(catalog, schemaPattern));
		} catch (final SQLException ex) {
			return new SEResultSet(NullResultSet.INSTANCE);
		}
	}

	@Override
	public boolean supportsStoredFunctionsUsingCallSyntax() {
		try {
			return base.supportsStoredFunctionsUsingCallSyntax();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public boolean autoCommitFailureClosesAllResultSets() {
		try {
			return base.autoCommitFailureClosesAllResultSets();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public SEResultSet getClientInfoProperties() {
		try {
			return new SEResultSet(base.getClientInfoProperties());
		} catch (final SQLException ex) {
			return new SEResultSet(NullResultSet.INSTANCE);
		}
	}

	@Override
	public SEResultSet getFunctions(String catalog, String schemaPattern, String functionNamePattern) {
		try {
			return new SEResultSet(base.getFunctions(catalog, schemaPattern, functionNamePattern));
		} catch (final SQLException ex) {
			return new SEResultSet(NullResultSet.INSTANCE);
		}
	}

	@Override
	public SEResultSet getFunctionColumns(String catalog, String schemaPattern, String functionNamePattern,
			String columnNamePattern) {
		try {
			return new SEResultSet(
					base.getFunctionColumns(catalog, schemaPattern, functionNamePattern, columnNamePattern));
		} catch (final SQLException ex) {
			return new SEResultSet(NullResultSet.INSTANCE);
		}
	}

	@Override
	public SEResultSet getPseudoColumns(String catalog, String schemaPattern, String tableNamePattern,
			String columnNamePattern) {
		try {
			return new SEResultSet(base.getPseudoColumns(catalog, schemaPattern, tableNamePattern, columnNamePattern));
		} catch (final SQLException ex) {
			return new SEResultSet(NullResultSet.INSTANCE);
		}
	}

	@Override
	public boolean generatedKeyAlwaysReturned() {
		try {
			return base.generatedKeyAlwaysReturned();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public long getMaxLogicalLobSize() {
		try {
			return base.getMaxLogicalLobSize();
		} catch (final SQLException ex) {
			return 0;
		}
	}

	@Override
	public boolean supportsRefCursors() {
		try {
			return base.supportsRefCursors();
		} catch (final SQLException ex) {
			return false;
		}
	}

	@Override
	public <T> T unwrap(Class<T> iface) {
		try {
			return base.unwrap(iface);
		} catch (final SQLException ex) {
			return null;
		}
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) {
		try {
			return base.isWrapperFor(iface);
		} catch (final SQLException ex) {
			return false;
		}
	}

}
