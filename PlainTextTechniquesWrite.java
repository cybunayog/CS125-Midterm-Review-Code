/*
 *
 *
 * Read in text using Scanner()
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
