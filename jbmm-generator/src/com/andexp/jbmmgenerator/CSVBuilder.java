package com.andexp.jbmmgenerator;

import java.io.IOException;

import com.csvreader.CsvWriter;

public class CSVBuilder {
	final static int MAXCELLNUMBER = 100000;
	CsvWriter mWriter;
	int sheetNumber, cellNumber, mFrom, mTo;

	public CSVBuilder(int from, int to){
		mFrom = from;
		mTo = to;
		
		writeNewFile();
		addHeader();
		
	}
	
	private void writeNewFile(){
		++sheetNumber;
		mWriter = new CsvWriter("/home/vincent/jbmm/jbmmresult_from_"+mFrom+"_to_"+mTo+"_sheet_"+sheetNumber+".csv");
		cellNumber=0;
	}
	
	private void addHeader(){
		try {
			mWriter.write("Archos Gen9 8p flash");
			mWriter.write("Archos Gen9 8p HDD");
			mWriter.write("Archos Gen9 10p Flash");
			mWriter.write("Archos Gen9 10p HDD");
			mWriter.write("Archos 70B IT");
			mWriter.write("Archos 9");
			mWriter.write("Archos 70d");
			mWriter.write("Archos 50b");
			mWriter.write("Arnova 10b G3");
			mWriter.write("Arnova Web Radio & TV");
			mWriter.write("Poids Total en grammes");
			mWriter.endRecord();
			++cellNumber;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addLine(int gen9_8_flash_number, 
			int gen9_8_hdd_number,
			int gen9_10_flash_number,
			int gen9_10_hdd_number,
			int archos70bit_number,
			int archos9_number,
			int archos70d_number,
			int archos50b_number,
			int arno10bg3_number,
			int webradio_number,
			int weight){

		try {
			mWriter.write(String.valueOf(gen9_8_flash_number));
			mWriter.write(String.valueOf(gen9_8_hdd_number));
			mWriter.write(String.valueOf(gen9_10_flash_number));
			mWriter.write(String.valueOf(gen9_10_hdd_number));
			mWriter.write(String.valueOf(archos70bit_number));
			mWriter.write(String.valueOf(archos9_number));
			mWriter.write(String.valueOf(archos70d_number));
			mWriter.write(String.valueOf(archos50b_number));
			mWriter.write(String.valueOf(arno10bg3_number));
			mWriter.write(String.valueOf(webradio_number));
			mWriter.write(String.valueOf(weight));
			mWriter.endRecord();
			checkSheetSize();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void checkSheetSize(){
		if(++cellNumber==MAXCELLNUMBER){
			mWriter.close();
			writeNewFile();
			addHeader();
		}
	}
	
	public void Close(){
		mWriter.close();
	}



}
