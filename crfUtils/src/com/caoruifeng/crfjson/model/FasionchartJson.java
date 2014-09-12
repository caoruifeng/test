package com.caoruifeng.crfjson.model;

import java.util.List;
import java.util.Map;

public class FasionchartJson {

	private Object chart;
	private Map<String, Object> categories;
	private List<?> dataset;
	public Object getChart() {
		return chart;
	}
	public void setChart(Object chart) {
		this.chart = chart;
	}
	public Map<String, Object> getCategories() {
		return categories;
	}
	public void setCategories(Map<String, Object> categories) {
		this.categories = categories;
	}
	public List<?> getDataset() {
		return dataset;
	}
	public void setDataset(List<?> dataset) {
		this.dataset = dataset;
	}
	
	
}
