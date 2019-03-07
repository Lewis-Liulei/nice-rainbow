package rt.lewis.filter;

import com.alibaba.druid.filter.logging.Log4j2Filter;

import java.util.regex.Pattern;

/**
 * 
 * @author
 * @since 1.1.10
 */
public class RtLog4j2Filter extends Log4j2Filter {

	/** 是否打印查询语句(可能较多,较长) */
	private boolean statementExecutableQuerySqlLogEnable;
	/**长打印字符数 */
	private int statementLogMaxLength = 10240;

	static final Pattern QUERY_STATEMENT_PATTERN = Pattern
			.compile("(?i)\\{conn-\\d+, \\w?stmt-\\d+} executed.\\s+select.*");

	@Override
	protected void statementLog(String message) {
		if (message == null) {
			super.statementLog(message);
			return;
		}

		if (message.length() > statementLogMaxLength) {
			message = message.substring(0, statementLogMaxLength) + "(IGNORE"
					+ (message.length() - statementLogMaxLength) + "CHARS)";
		}

		if (!statementExecutableQuerySqlLogEnable && QUERY_STATEMENT_PATTERN.matcher(message).matches()) {
			return;
		}

		super.statementLog(message);
	}

	@Override
	protected void connectionLog(String message) {
		if (message != null && message.endsWith("setAutoCommit true")) {
			return;
		}
		super.connectionLog(message);
	}

	public boolean isStatementExecutableQuerySqlLogEnable() {
		return statementExecutableQuerySqlLogEnable;
	}

	public void setStatementExecutableQuerySqlLogEnable(boolean statementExecutableQuerySqlLogEnable) {
		this.statementExecutableQuerySqlLogEnable = statementExecutableQuerySqlLogEnable;
	}

	public int getStatementLogMaxLength() {
		return statementLogMaxLength;
	}

	public void setStatementLogMaxLength(int statementLogMaxLength) {
		this.statementLogMaxLength = statementLogMaxLength;
	}

}
