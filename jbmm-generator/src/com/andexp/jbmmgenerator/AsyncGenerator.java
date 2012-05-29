package com.andexp.jbmmgenerator;

public class AsyncGenerator extends Thread {
	final int POIDSMAX = 700000;

	final int GEN9_8_FLASH = 465;
	final int GEN9_8_HDD = 599;
	final int GEN9_10_FLASH = 649;
	final int GEN9_10_HDD = 755;
	final int ARCHOS70BIT = 330;
	final int ARCHOS9 = 800;
	final int ARCHOS70D = 280;
	final int ARCHOS50b = 184;
	final int ARNO10bG3 = 630;
	final int WEBRADIO = 416;

	int mFrom, mTo;
	
	CSVBuilder myCsvBuilder;
	
	
	public AsyncGenerator(int from, int to) {
		mFrom = from;
		mTo = to;
		myCsvBuilder = new CSVBuilder(from, to);
	}

	@Override
	public void run() {
		for(int gen9_8_flash_number = mFrom; gen9_8_flash_number < mTo; gen9_8_flash_number++){
			for(int gen9_8_hdd_number = 1; gen9_8_hdd_number * GEN9_8_HDD < POIDSMAX; gen9_8_hdd_number++){
				for(int gen9_10_flash_number = 1; gen9_10_flash_number * GEN9_10_FLASH < POIDSMAX; gen9_10_flash_number++){
					for(int gen9_10_hdd_number = 1; gen9_10_hdd_number * GEN9_10_HDD < POIDSMAX; gen9_10_hdd_number++){
						for(int archos70bit_number = 1; archos70bit_number * ARCHOS70BIT < POIDSMAX; archos70bit_number++){
							for(int archos9_number = 1; archos9_number * ARCHOS9 < POIDSMAX; archos9_number++){
								for(int archos70d_number = 1; archos70d_number * ARCHOS70D < POIDSMAX; archos70d_number++){
									for(int archos50b_number = 1; archos50b_number * ARCHOS50b < POIDSMAX; archos50b_number++){
										for(int ARNO10bG3_number = 1; ARNO10bG3_number * ARNO10bG3 < POIDSMAX; ARNO10bG3_number++){
											for(int webradio_number = 1; webradio_number * WEBRADIO < POIDSMAX; webradio_number++){
												int weight = getWeight(gen9_8_flash_number, gen9_8_hdd_number, gen9_10_flash_number, gen9_10_hdd_number, archos70bit_number, archos9_number, archos70d_number, archos50b_number, ARNO10bG3_number, webradio_number);
												if(weight==DATA.MAXWEIGHT){
													myCsvBuilder.addLine(gen9_8_flash_number, gen9_8_hdd_number, gen9_10_flash_number, gen9_10_hdd_number, archos70bit_number, archos9_number, archos70d_number, archos50b_number, ARNO10bG3_number, webradio_number, weight);
													displaySolutionNumber();
												} 
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		myCsvBuilder.Close();
		System.out.print("\n//////////////////////////////////////////////////////\n" +
				"END Thread "+mFrom+"-"+mTo+" solution number : "+DATA.solutionNumber+
				"\n//////////////////////////////////////////////////////\n");
	}
	
	int getWeight(int gen9_8_flash_number, 
			int gen9_8_hdd_number,
			int gen9_10_flash_number,
			int gen9_10_hdd_number,
			int archos70bit_number,
			int archos9_number,
			int archos70d_number,
			int archos50b_number,
			int arno10bg3_number,
			int webradio_number){
		
		int weight = (gen9_8_flash_number * GEN9_8_FLASH) + 
				(gen9_8_hdd_number * GEN9_8_HDD) + 
				(gen9_10_flash_number * GEN9_10_FLASH) + 
				(gen9_10_hdd_number * GEN9_10_HDD) + 
				(archos70bit_number * ARCHOS70BIT) + 
				(archos9_number * ARCHOS9) + 
				(archos70d_number * ARCHOS70D) + 
				(archos50b_number * ARCHOS50b) + 
				(arno10bg3_number * ARNO10bG3) + 
				(webradio_number * WEBRADIO);
		return weight;
	}
	
	private void displaySolutionNumber(){
		if(++DATA.solutionNumber%1000 == 0) 
			System.out.print("solution number : "+DATA.solutionNumber+"\n");
	}
	
}
