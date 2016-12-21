package com.nao20010128nao.AIW;

public class MaterialData {
	private final String type;
	private byte data = 0;

	/**
	 * @param type
	 *            the raw type id
	 * @deprecated Magic value
	 */
	@Deprecated
	public MaterialData(final String type) {
		this(type, (byte) 0);
	}

	/**
	 * @param type
	 *            the type
	 * @param data
	 *            the raw data value
	 * @deprecated Magic value
	 */
	@Deprecated
	public MaterialData(final String type, final byte data) {
		this.type = type;
		this.data = data;
	}

	/**
	 * Gets the raw data in this material
	 *
	 * @return Raw data
	 * @deprecated Magic value
	 */
	@Deprecated
	public byte getData() {
		return data;
	}

	/**
	 * Sets the raw data of this material
	 *
	 * @param data
	 *            New raw data
	 * @deprecated Magic value
	 */
	@Deprecated
	public void setData(byte data) {
		this.data = data;
	}

	/**
	 * Gets the Material that this MaterialData represents
	 *
	 * @return Material represented by this MaterialData
	 */
	public String getItemType() {
		return type;
	}

	/**
	 * Creates a new ItemStack based on this MaterialData
	 *
	 * @return New ItemStack containing a copy of this MaterialData
	 */
	public ItemStack toItemStack() {
		ItemStack is = new ItemStack();
		is.type = type;
		is.amount = 0;
		is.meta = data;
		return is;
	}

	/**
	 * Creates a new ItemStack based on this MaterialData
	 *
	 * @param amount
	 *            The stack size of the new stack
	 * @return New ItemStack containing a copy of this MaterialData
	 */
	public ItemStack toItemStack(int amount) {
		ItemStack is = new ItemStack();
		is.type = type;
		is.amount = amount;
		is.meta = data;
		return is;
	}

	@Override
	public String toString() {
		return getItemType() + "(" + getData() + ")";
	}

	@Override
	public int hashCode() {
		return getItemType().hashCode() << 8 ^ getData();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof MaterialData) {
			MaterialData md = (MaterialData) obj;
			return md.getItemType().equals(getItemType()) && md.getData() == getData();
		} else
			return false;
	}
}
