/*
 *
 *
 * Read in text using Scanner() and split()
 *
 *
 */

 File f = new File(fileName);
 Scanner scanner = null;

 FileInputStream fis = null;
 ObjectInputStream ois = null;
 boolean readFail = false;

 ArrayList<Hotel> hotels = new ArrayList<Hotel>();

 try {
	 scanner = new Scanner(f);
	 while (scanner.hasNextLine()) {

		 //removing the "Hotel(" at the begining of the line
		 String t = scanner.nextLine().replace("Hotel(", "");
		 //checking if ")" exsists at the end of the line as the last character
		 if (t.indexOf(")") >= 0) {
			 //removing the last character from the line
			 t = t.substring(0, t.length() - 1);
		 }

		 String[] newString = t.split(",");

		 hotels.add(new Hotel(Long.parseLong(newString[0]), newString[1], newString[2], newString[3], newString[4], Double.parseDouble(newString[5])));
	 }

 } catch (FileNotFoundException e) {
	 e.printStackTrace();
 } finally {

	 try {
		 // Close input objects
		 if (ois != null)
			 ois.close();
		 if (fis != null)
			 fis.close();
	 } catch (Exception e) {
		 System.out.println("ERROR: Problem occured while closing " + fileName);
		 e.printStackTrace();
	 }
 }


/*
 *
 *
 * Read in text using Scanner() and delimiter
 *
 *
 */


ArrayList<Hotel> hotels = new ArrayList();
    

    FileInputStream fis = null;
    Scanner fScan = null;
    

    try
    {
      fis = new FileInputStream(fileName);
      fScan = new Scanner(fis);
      

      while (fScan.hasNextLine())
      {
	
	//removes parentheses
        String line = fScan.nextLine();
        if (line.indexOf("(") >= 0)
          line = line.substring(line.indexOf("(") + 1);
        if (line.lastIndexOf(")") >= 0) {
          line = line.substring(0, line.lastIndexOf(")"));
        }
        
        Scanner lScan = new Scanner(line);
        lScan.useDelimiter(",");
        

        Hotel h = new Hotel();
        h.setUniqueId(Long.parseLong(lScan.next().trim()));
        h.setHotelName(lScan.next().trim());
        h.setAddress(lScan.next().trim());
        h.setCity(lScan.next().trim());
        h.setStateAbbrev(lScan.next().trim());
        h.setPricePerNight(Double.parseDouble(lScan.next().trim()));
        hotels.add(h);
      }
    }
    catch (FileNotFoundException e)
    {
      System.out.println("ERROR: " + e.getMessage());
      






      if (fScan != null)
        fScan.close();
      if (fis != null) {
        try { fis.close(); } catch (IOException e) { System.out.println("ERROR: " + e.getMessage());
        }
      }
    }
    catch (Exception e)
    {
      System.out.println("ERROR: " + e.getMessage());
      


      if (fScan != null)
        fScan.close();
      if (fis != null) {
        try { fis.close(); } catch (IOException e) { System.out.println("ERROR: " + e.getMessage());
        }
      }
    }
    finally
    {
      if (fScan != null)
        fScan.close();
      if (fis != null) {
        try { fis.close(); } catch (IOException e) { System.out.println("ERROR: " + e.getMessage());
        }
      }
    }
