import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	static List<Telepulesek> telepulesekList = new ArrayList<>();

	public static void main(String[] args) {

		read("telepulesek.txt");

		int kun = kunság();
		System.out.println(kun + " db település tartalmaz kun szót.");
		final int minNépesség = 20;
		int népesség = népesség(minNépesség);
		System.out.println(minNépesség + "-nél kisebb lélekszámú településből " + népesség + " van");
		telepulesekMegyenkent();
	}

	static void telepulesekMegyenkent() {
		List<String> megyekodok = Arrays.asList("BK", "BE", "BA", "BZ", "BU", "CS", "FE", "GS", "HB", "HE", "JN", "KE",
				"NO", "PE", "SO", "SZ", "TO", "VA", "VE", "ZA");
		int[] telepulesSzamok = new int[megyekodok.size()];

		for (Telepulesek t : telepulesekList) {
			String megyekod = t.getMegyekód();
			int index = megyekodok.indexOf(megyekod);

			if (index >= 0) {
				int current = telepulesSzamok[index];
				telepulesSzamok[index] = current + 1;
			}
		}
		for (int i = 0; i < telepulesSzamok.length; i++) {
			System.out.println(megyekodok.get(i) + ": " + telepulesSzamok[i] + " db");
		}
	}

	static int népesség(int népesség) {
		int count = 0;

		for (int i = 0; i < telepulesekList.size(); i++) {
			if (telepulesekList.get(i).getJogállás() == 6 && telepulesekList.get(i).getNépesség() < népesség) {
				System.out.println(telepulesekList.get(i).toString());
				count++;
			}
		}
		return count;
	}

	static int kunság() {
		int count = 0;
		final String search = "kun";
		for (Telepulesek t : telepulesekList) {
			if (t.getNév().toLowerCase().contains(search)) {
				System.out.println(t.toString());
				count++;
			}
		}
		return count;
	}

	static void read(String filename) {
		Scanner fileInput = null;

		try {
			File file = new File(filename);
			fileInput = new Scanner(file);

			while (fileInput.hasNextLine()) {
				String line = fileInput.nextLine();
				Telepulesek t = new Telepulesek(line);
				telepulesekList.add(t);
			}
		} catch (FileNotFoundException e) {
			System.out.println("A megadott fájl nem található: " + filename);
		} catch (Exception e) {
			System.out.println("Hiba történt! " + e.getMessage());
		} finally {
			if (fileInput != null) {
				fileInput.close();
			}
		}
		System.out.println("Beolvasott sorok száma: " + telepulesekList.size());
	}

	static void printAll() {
		for (Telepulesek t : telepulesekList) {
			System.out.println(t.toString());
		}
	}

}
