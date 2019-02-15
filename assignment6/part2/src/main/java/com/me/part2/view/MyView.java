package com.me.part2.view;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class MyView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HSSFSheet sheet = workbook.createSheet("SalesOrder");
		HttpSession session = request.getSession();
		ArrayList<String[]> rs = (ArrayList<String[]>) session.getAttribute("rs");
		System.out.println(rs==null);
		int rowcount = 0;
		for (String[] row : rs) {
			int col = 0;
			for (String unit : row) {
				HSSFCell cell = getCell(sheet, rowcount, col);
				setText(cell, unit);
				col++;
			}
			rowcount++;
		}
	}

}
