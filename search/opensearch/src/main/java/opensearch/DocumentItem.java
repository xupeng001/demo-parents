package opensearch;

public class DocumentItem<T> {
	private String cmd;
	private T indexDO;

	/**
	 * @return the cmd
	 */
	public String getCmd() {
		return cmd;
	}

	/**
	 * @param cmd
	 *            the cmd to set
	 */
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	/**
	 * @return the indexDO
	 */
	public T getIndexDO() {
		return indexDO;
	}

	/**
	 * @param indexDO
	 *            the indexDO to set
	 */
	public void setIndexDO(T indexDO) {
		this.indexDO = indexDO;
	}
}
