package search;

import java.text.DecimalFormat;
import java.util.ArrayList;

import model.ProductDTO;

public class TableModelChange {
	ArrayList<ProductDTO> productList;

	public TableModelChange(ArrayList<ProductDTO> productList) {

		this.productList = productList;
	}

	public Object[][] listTypeChange() {
		DecimalFormat formatter = new DecimalFormat("###,###");
		Object[][] data = new Object[productList.size()][4];
		for (int i = 0; i < data.length; i++) {
			data[i][0] = productList.get(i).getP_model();
			data[i][1] = productList.get(i).getP_name();
			data[i][2] = productList.get(i).getP_class();
			data[i][3] = formatter.format(productList.get(i).getP_price());
		}
		return data;
	}
}
