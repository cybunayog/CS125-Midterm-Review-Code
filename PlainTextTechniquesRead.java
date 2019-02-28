    /*
    *
    *
    * Write text using PrintWriter()
    *
    *
    */

  FileOutputStream fos = null;
		PrintWriter pw = null;

		// 2) TRY/CATCH/FINALLY structure
		try {
			// 2a) TRY - init output variables
			fos = new FileOutputStream(fileName);
			pw = new PrintWriter(fos);

			// 2b) TRY - Write data out to file
			for (Samurai s : samurai) {
				pw.print(s.getName() + " - ");
				pw.print(s.getBirthplace() + " - ");
				pw.print(s.getArmorStrength() + " - ");
				pw.println(s.getSwordDamage());
			}

		// 2c) CATCH - FileNotFoundException & Exception
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found");
		} catch (Exception e) {
			System.out.println("ERROR: An unknown error occurred");
		} finally {
			// 2d) FINALLY - Close output variables
			try {
				if (pw != null)
					pw.close();
				if (fos != null)
					fos.close();
			} catch (Exception e) {
				System.out.println("ERROR: An unknown error occurred");
			}
		}
