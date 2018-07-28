package com.scheripa.solutions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FilterValues {
	public HashMap<String, ArrayList<String>> hm = new HashMap<>();
	public static String[] inputFileNames = { "task", "streaming_channel", "solution", "topic", "record_action",
			"topic_assignment", "user" };

	public static void main(String[] args) throws Exception {

		FilterValues fv = new FilterValues();
		String marketoFileName = "C:/Users/scheripa/Downloads/Marketo.xlsx";
		ArrayList<String> marketoValues = new ArrayList<>();
		try {
			marketoValues = fv.readFile(marketoFileName);

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int i = 0; i < inputFileNames.length; i++) {
			fv.matchValues(inputFileNames[i], marketoValues);

		}
	}

	private ArrayList<String> readFile(String fileName) throws IOException {
		System.out.println("ENTER===>");
		ArrayList<String> values = new ArrayList<>();
		FileInputStream inputStream = new FileInputStream(new File(fileName));
		Workbook workbook = new XSSFWorkbook(inputStream);
		org.apache.poi.ss.usermodel.Sheet firstSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = firstSheet.iterator();

		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();

				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					values.add(cell.getStringCellValue());
//					System.out.print(cell.getStringCellValue() + "\n");
					break;
				case Cell.CELL_TYPE_BOOLEAN:
//					System.out.print(cell.getBooleanCellValue());
					break;
				case Cell.CELL_TYPE_NUMERIC:
//					System.out.print(cell.getNumericCellValue());
					break;
				}
			}
		}
		workbook.close();
		inputStream.close();
		System.out.println("EXIT====>>");
		return values;
	}

	private void matchValues(String inputFileName, ArrayList<String> marketoValues) throws IOException {
//		String marketoFileName = "C:/Users/scheripa/Downloads/Marketo.xlsx";
		String salesforceFileName = "C:/Users/scheripa/Downloads/" + inputFileName + ".xlsx";
		FilterValues fv = new FilterValues();
		ArrayList<String> salesforceValues = new ArrayList<>();
		try {
			salesforceValues = fv.readFile(salesforceFileName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ENTER ====>>");
		for (int i = 0; i < salesforceValues.size() - 1; i++) {
			String input = salesforceValues.get(i).toLowerCase();
			ArrayList<String> matchedValues = new ArrayList<>();
			for (int j = 0; j < marketoValues.size() - 1; j++) {
				String marketoValue = marketoValues.get(j).toLowerCase();
				if ((marketoValue.indexOf(input) != -1) || input.indexOf(marketoValue) != -1
						|| input.contains(marketoValue) || marketoValue.contains(input)) {
					if (!matchedValues.contains(marketoValue)) {
						matchedValues.add(marketoValue);

					}

				}
			}

			hm.put(input, matchedValues);

		}
		System.out.println("hm values are====>>>" + hm);

		createSheet(inputFileName);
	}

	private void createSheet(String inputFileName) throws FileNotFoundException, IOException {
		int rowCount = 0;
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("output");
		XSSFFont headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 14);
		headerFont.setColor(IndexedColors.RED.getIndex());
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		XSSFFont cellHeaderFont = workbook.createFont();
		cellHeaderFont.setBold(true);
		cellHeaderFont.setFontHeightInPoints((short) 14);
		cellHeaderFont.setColor(IndexedColors.BLACK.getIndex());
		CellStyle CellStyle = workbook.createCellStyle();
		CellStyle.setFont(cellHeaderFont);

		int columnCount = 1;

		for (Entry<String, ArrayList<String>> entry : hm.entrySet()) {
			Row row = sheet.createRow(++rowCount);
			Cell cell1 = row.createCell(0);
			cell1.setCellValue(entry.getKey());
			cell1.setCellStyle(headerCellStyle);

			ArrayList<String> vs = entry.getValue();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < vs.size(); i++) {
				sb.append(vs.get(i) + "\n");
			}
			Cell cell2 = row.createCell(1);
			cell2.setCellValue(sb.toString());
			cell2.setCellStyle(CellStyle);

		}
		try (FileOutputStream outputStream = new FileOutputStream(
				"C:/Users/scheripa/Downloads/" + inputFileName + "_output.xlsx")) {
			workbook.write(outputStream);
		}
	}
}
