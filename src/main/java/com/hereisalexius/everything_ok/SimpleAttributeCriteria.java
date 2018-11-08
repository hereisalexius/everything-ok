package com.hereisalexius.everything_ok;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Element;

public class SimpleAttributeCriteria implements Criteria {

	protected int mark;
	protected int markBooster;
	protected String specAttrName;

	public SimpleAttributeCriteria(int markBooster) {
		this.markBooster = markBooster;
	}

	public SimpleAttributeCriteria(int markBooster, String specAttrName) {
		super();
		this.markBooster = markBooster;
		this.specAttrName = specAttrName;
	}

	public Criteria check(Attribute attr, Element other) {
		mark = 0;
		if (specAttrName == null || other.hasAttr(specAttrName))
			if (other.hasAttr("calss")) {
				for (String cls : attr.getValue().split(" ")) {
					if (other.attr(attr.getKey()).contains(cls)) {
						mark += markBooster;
					}
				}
			}
			else if (other.attr(attr.getKey()).contentEquals(attr.getValue())) {
			mark += markBooster;
		}
		return this;
	}

	@Override
	public int getMark() {
		return mark;
	}

}
